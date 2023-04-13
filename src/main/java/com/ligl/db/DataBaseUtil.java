package com.ligl.db;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.testng.Assert;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;


//Connection-(SIT)
//DB-(IND/US/Master)
//Query-Employee/User&Roles/Case
//Columns(CreatedOnTime/SentOnTime/Status/Id/Content)

//Store the id- and then Compare the Content
//Store the id- wait until Status success and Compare with Email

public class DataBaseUtil extends LiglBaseSessionPage {
    Connection connection = null;
    ResultSet resultSet;
    Statement sqlStatement;
    DatabaseMetaData databaseMetaData;

    public ILiglPage dataBaseConnection(String selectDB) throws SQLException {
        getSession().log_Info("Connect to SQL Data Base");
        try {
            switch (getSession().getGlobalData("DB_Server")) {
                case "SIT_DB":
                    if (selectDB.contains("enityDB")) {
                        switch (getSession().getGlobalData("SelectEntityDB")) {
                            case "DB_IND":
                                System.out.println("IND");
                                String serverName_IN = "jdbc:sqlserver://" + getSession().getGlobalData("SIT_DB_Server") + ";";
                                String databaseName_IN = "databaseName=" + getSession().getGlobalData("DataBase_IND") + ";";
                                String dataBase_URL_IN = serverName_IN + databaseName_IN + "integratedSecurity=true";
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                getSession().log_Info("Get the Current SQL server url");
                                connection = DriverManager.getConnection(dataBase_URL_IN);
                                getSession().log_Pass("Connected to SIT Data Base and URl is " + dataBase_URL_IN);
                                break;
                            case "DB_US":
                                System.out.println("US");
                                String serverName_US = "jdbc:sqlserver://" + getSession().getGlobalData("SIT_DB_Server") + ";";
                                String databaseName_US = "databaseName=" + getSession().getGlobalData("DataBase_US") + ";";
                                String dataBase_URL_US = serverName_US + databaseName_US + "integratedSecurity=true";
                                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                                getSession().log_Info("Get the Current SQL server url");
                                connection = DriverManager.getConnection(dataBase_URL_US);
                                getSession().log_Pass("Connected to SIT Data Base and URl is " + dataBase_URL_US);
                                break;
                        }
                    } else if (selectDB.contains("masterBD")) {
                        String serverName_SIT = "jdbc:sqlserver://" + getSession().getGlobalData("SIT_DB_Server") + ";";
                        String databaseName_SIT = "databaseName=" + getSession().getGlobalData("DataBase_Master") + ";";
                        String dataBase_URL_SIT = serverName_SIT + databaseName_SIT + "integratedSecurity=true";
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        getSession().log_Info("Get the Current SQL server url");
                        connection = DriverManager.getConnection(dataBase_URL_SIT);
                        getSession().log_Pass("Connected to SIT Data Base and URl is " + dataBase_URL_SIT);
                    }
                    break;
                case "RT_DB":
                    break;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            log_Error(ex.getMessage());
            throw new SQLException("Data Base Connection got Failed", ex);
        } catch (ClassNotFoundException e) {
            log_Error(e.getMessage());
            throw new RuntimeException("Data Base Connection got Failed", e);
        }
        return this;
    }

    public ILiglPage executeSQL_Query(String sql_Query) throws SQLException {
        try {
            if (connection != null) {
                //databaseMetaData = (DatabaseMetaData) connection.getMetaData();
                getSession().log_Info("Execute the SQL Query");
                sqlStatement = connection.createStatement();
                resultSet = sqlStatement.executeQuery(sql_Query);
                getSession().log_Pass("Executed the Query " + sql_Query);
            }
        } catch (SQLException ex) {
            log_Error(ex.getMessage());
            ex.printStackTrace();
            throw new SQLException("Failed", ex);
        }
        return this;
    }

    public ILiglPage validatingEmailsInDB() throws SQLException {
        try {
            if (connection != null) {
                getSession().log_Info("Get Email Tracker ID");
                while (resultSet.next()) {
                    getSession().setRegressionData("DB_EmailTrackerID", resultSet.getString("EmailTrackerID"));
                }
                getSession().log_Pass("Email Tracker ID is" + getSession().getRegressionData("DB_EmailTrackerID"));

                getSession().log_Info("Execute the Query with Email Tracker ID");
                resultSet = sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
                getSession().log_Pass("Executed the Query with Email Tracker ID " + "SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));

                while (resultSet.next()) {
                    getSession().log_Info("Get Email Status");
                    String es = resultSet.getString("EmailStatus");
                    getSession().setRegressionData("DB_EmailStatus", es);
                    getSession().log_Info("Wait for Email Status");
                    for (int i = 1; i <= 200; i++) {    //total wait 35 min
                        try {
                            wait(15);//15 sec
                            System.out.println("1");
                            String actualValue = getSession().getRegressionData("DB_EmailStatus");
                            if (actualValue.contains("8272")) {//EnityDB email sent status
                                break;
                            }
                            if (actualValue.contains("84")) {//MasterDB email sent status
                                break;
                            }
                            if (actualValue.contains("8273")) {//EnityDB email Failed status
                                break;
                            }
                            if (actualValue.contains("83")) {//MasterDB email Failed status
                                break;
                            }
                            sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
                        } catch (Exception ex) {
                            log_Error("Failed");
                        }
                    }
                    getSession().log_Pass("Get Email Status " + getSession().getRegressionData("DB_EmailStatus"));

                    getSession().log_Info("Get the Content Results");
                    String cr = resultSet.getString("ContentResults");
                    getSession().setRegressionData("DB_ContentResults", cr);
                    getSession().log_Pass("Content Results " + getSession().getRegressionData("DB_ContentResults"));
                }
            }
        } catch (SQLException ex) {
            log_Error(ex.getMessage());
            ex.printStackTrace();
            throw new SQLException("Failed", ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ILiglPage validateEmpData() throws Exception {
        try {
            //Employee Full Name
            getSession().log_Info("Check 'Employee Full Name' in ContentResults");

            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "3rfr3f3 rf3rfrf")), true);

            getSession().log_Pass("'Employee Full Name' available in ContentResults");




            //Employee Email id
            getSession().log_Info("Check 'Employee Email I'd' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "testbulkim@ligl.io")), true);
            getSession().log_Pass("'Employee Email I'd' available in ContentResults");

            //Action
            getSession().log_Info("Check 'Action' in ContentResults");
            String actValue = getSession().getRegressionData("DB_ContentResults");
            if (actValue.contains("Added")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Added"), true);
                getSession().log_Pass("'Added' Action available in ContentResults");
            } else if (actValue.contains("Edited")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Edited"), true);
                getSession().log_Pass("'Edited' Action available in ContentResults");
            }

            return this;
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Failed", exception);
        }
    }

    public ILiglPage validateUseRolesData() throws Exception {
        try {
            //Employee Full Name
            getSession().log_Info("Check 'User Name' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), getSession().getRegressionData("TC12160_UserName"))), true);
            getSession().log_Pass("'User Name' available in ContentResults");

            //Employee Email id
            getSession().log_Info("Check 'Password' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), getSession().getRegressionData("TC12160_Password"))), true);
            getSession().log_Pass("'Password' available in ContentResults");

            return this;
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Failed", exception);
        }
    }

    public ILiglPage closeTheDBConnection() throws SQLException {
        try {
            getSession().log_Info("Close the DB Connection");
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
            getSession().log_Pass("Closed the DB Connection");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return this;
    }


    /*public ILiglPage validatingEmailsInDB() {
        dataBaseConnection();
        STring qry =
                getSession().setRegressionData("TC11_EmailtrackerId", "");

        //further logic
        loop(until status = '')

    }

    public ILiglPage validatingEmpEmailsInOutLook() {
        dataBaseConnection();
        STring qry =

    }*/

}
