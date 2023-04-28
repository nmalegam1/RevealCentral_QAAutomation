package com.ligl.db;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
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
//Columns(EmailTrackerID/Status/Content)

//Store the id- and then Compare the Content
//Store the id- wait until Status success and Compare with Email

public class DataBaseUtil extends LiglBaseSessionPage {
    Connection connection = null;
    Statement sqlStatement;
    ResultSet resultSet;
    DatabaseMetaData databaseMetaData;

    public void dataBaseConnection(String selectDB) throws SQLException {
        getSession().log_Info("Connect to SQL Data Base");
        try {
            switch (getSession().getGlobalData("DB_Server")) {
                case "SIT_DB":
                    if (selectDB.equalsIgnoreCase("entityDB")) {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        switch (getSession().getGlobalData("SelectEntityDB")) {
                            case "DB_IND":
                                System.out.println("IND");
                                String serverName_SIT_IN = getSession().getGlobalData("SIT_DB_Server");
                                String databaseName_SIT_IN = "databaseName=" + getSession().getGlobalData("DataBase_IND");
                                String dataBase_URL_SIT_IN = "jdbc:sqlserver://" + serverName_SIT_IN + ";" + databaseName_SIT_IN + ";" + "integratedSecurity=true";
                                getSession().log_Info("Get the Current SQL server url");
                                connection = DriverManager.getConnection(dataBase_URL_SIT_IN);
                                getSession().log_Pass("Connected to SIT Data Base and URl is " + dataBase_URL_SIT_IN);
                                break;
                            case "DB_US":
                                System.out.println("US");
                                String serverName_SIT_US = getSession().getGlobalData("SIT_DB_Server");
                                String databaseName_SIT_US = "databaseName=" + getSession().getGlobalData("DataBase_US");
                                String dataBase_URL_SIT_US = "jdbc:sqlserver://" + serverName_SIT_US + ";" + databaseName_SIT_US + ";" + "integratedSecurity=true";
                                getSession().log_Info("Get the Current SQL server url");
                                connection = DriverManager.getConnection(dataBase_URL_SIT_US);
                                getSession().log_Pass("Connected to SIT Data Base and URl is " + dataBase_URL_SIT_US);
                                break;
                        }
                    } else if (selectDB.equalsIgnoreCase("masterDB")) {
                        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                        String serverName_SIT = getSession().getGlobalData("SIT_DB_Server");
                        String databaseName_SIT = "databaseName=" + getSession().getGlobalData("DataBase_Master");
                        String dataBase_URL_SIT = "jdbc:sqlserver://" + serverName_SIT + ";" + databaseName_SIT + ";" + "integratedSecurity=true";
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
            throw new SQLException("Executing SQL Query Failed", ex);
        }
        return this;
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

    public ILiglPage getEmailDeliveryStatusFromDB() throws SQLException {
        try {
            if (connection != null) {
                //Email Tracker ID
                getSession().log_Info("Get Email Tracker ID");
                while (resultSet.next()) {
                    getSession().setRegressionData("DB_EmailTrackerID", resultSet.getString("EmailTrackerID"));
                }
                getSession().log_Pass("Email Tracker ID is " + getSession().getRegressionData("DB_EmailTrackerID"));

                getSession().log_Info("Execute the Query with Email Tracker ID");
                resultSet = sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
                getSession().log_Pass("Executed the Query with Email Tracker ID " + "SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));

                getSession().log_Info("Get Email Status");
                while (resultSet.next()) {
                    String es = resultSet.getString("EmailStatus");
                    getSession().setRegressionData("DB_EmailStatus", es);

                    getSession().log_Info("Wait for Email Status");
                    for (int i = 1; i <= 200; i++) {//total wait 50 min
                        try {
                            wait(15);//15 sec
                            int emailStatusActualValue = Integer.parseInt(getSession().getRegressionData("DB_EmailStatus"));
                            if (emailStatusActualValue == 8272) {//EnityDB email sent status
                                break;
                            } else if (emailStatusActualValue == 84) {//MasterDB email sent status
                                break;
                            } else if (emailStatusActualValue == 8273) {//EnityDB email Failed status
                                break;
                            } else if (emailStatusActualValue == 85) {//MasterDB email Failed status
                                break;
                            }
                            resultSet = sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
                            while (resultSet.next()) {
                                String emailStatus = resultSet.getString("EmailStatus");
                                getSession().setRegressionData("DB_EmailStatus", emailStatus);
                            }
                        } catch (Exception ex) {
                            log_Error("Waiting for Email Status Failed");
                        }
                    }

                    int emailStatusValue = Integer.parseInt(getSession().getRegressionData("DB_EmailStatus"));

                    if (emailStatusValue == 8272) {
                        getSession().log_Pass("Get Email Status " + getSession().getRegressionData("DB_EmailStatus"));
                    } else if (emailStatusValue == 8273) {
                        getSession().log_Error("Get Email Status " + getSession().getRegressionData("DB_EmailStatus"));
                    } else if (emailStatusValue == 84) {
                        getSession().log_Pass("Get Email Status " + getSession().getRegressionData("DB_EmailStatus"));
                    } else if (emailStatusValue == 85) {
                        getSession().log_Error("Get Email Status " + getSession().getRegressionData("DB_EmailStatus"));
                    } else {
                        getSession().log_Error("Email Failed due Time SessionOut");
                    }
                }
            }
        } catch (SQLException ex) {
            log_Error(ex.getMessage());
            ex.printStackTrace();
            throw new SQLException("Get Email Delivery Status From DataBase Failed", ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    public ILiglPage getContentResultsfromDBEmailTracker() throws SQLException {
        try {
            getSession().log_Info("Get the Content Results");
            resultSet = sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
            while (resultSet.next()) {
                String cr = resultSet.getString("ContentResults");
                getSession().setRegressionData("DB_ContentResults", cr);
            }
            getSession().log_Pass("Content Results " + getSession().getRegressionData("DB_ContentResults"));
        } catch (SQLException ex) {
            log_Error(ex.getMessage());
            ex.printStackTrace();
            throw new SQLException("Get Content Results From DataBase Email Tracker Failed", ex);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

}
