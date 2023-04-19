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

    public void dataBaseConnection(String selectDB) throws SQLException {
        getSession().log_Info("Connect to SQL Data Base");
        try {
            switch (getSession().getGlobalData("DB_Server")) {
                case "SIT_DB":
                    if (selectDB.equalsIgnoreCase("entityDB")) {
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
                    } else if (selectDB.equalsIgnoreCase("masterDB")) {
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

    public ILiglPage getEmailDeliveryStatusFromDB() throws SQLException {
        try {
            if (connection != null) {

                //Email Tracker ID
                getSession().log_Info("Get Email Tracker ID");
                while (resultSet.next()) {
                    getSession().setRegressionData("DB_EmailTrackerID", resultSet.getString("EmailTrackerID"));
                }
                getSession().log_Pass("Email Tracker ID is" + getSession().getRegressionData("DB_EmailTrackerID"));

                getSession().log_Info("Execute the Query with Email Tracker ID");
                resultSet = sqlStatement.executeQuery("SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));
                getSession().log_Pass("Executed the Query with Email Tracker ID " + "SELECT * FROM VERTICAL.EMAILTRACKER WHERE EmailTrackerID = " + getSession().getRegressionData("DB_EmailTrackerID"));

                getSession().log_Info("Get Email Status");
                while (resultSet.next()) {
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
                                String es = resultSet.getString("EmailStatus");
                                getSession().setRegressionData("DB_EmailStatus", es);
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

    public ILiglPage getContentResultsfromDBEmailTracker() throws SQLException{
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
            throw new Exception("Validate Use and Roles Data Failed", exception);
        }
    }

    public ILiglPage validateSSOUserData(String intendeduser, String userName) throws Exception {
        try {
            //intendeduser
            getSession().log_Info("Check 'intendeduser' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), intendeduser)), true);
            getSession().log_Pass("'intendeduser' available in ContentResults");

            //username
            getSession().log_Info("Check 'username' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), userName)), true);
            getSession().log_Pass("'username' available in ContentResults");
            return this;
        } catch (Exception e) {
            e.getMessage();
            throw new Exception("Validate SSO User Data Failed", e);
        }
    }

    public ILiglPage validateEmpData(String custodianName, String emailID) throws Exception {
        try {
            //intendeduser
            //Custodian Name
            getSession().log_Info("Check 'Custodian Name' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), custodianName)), true);
            getSession().log_Pass("'Custodian Name' available in ContentResults");

            //Employee Email id
            getSession().log_Info("Check 'Employee Email I'd' in ContentResults");
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), emailID)), true);
            getSession().log_Pass("'Employee Email I'd' available in ContentResults");

            //Action
            getSession().log_Info("Check 'Action' in ContentResults");
            String actValue = getSession().getRegressionData("DB_ContentResults");
            if (actValue.equalsIgnoreCase("Added")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Added"), true);
                getSession().log_Pass("'Added' Action available in ContentResults");
            } else if (actValue.equalsIgnoreCase("Edited")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Edited"), true);
                getSession().log_Pass("'Edited' Action available in ContentResults");
            }

            //workflowstatus
            getSession().log_Info("Check 'WorkFlow Status' in ContentResults");
            if (actValue.equalsIgnoreCase("Added")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Added"), true);
                getSession().log_Pass("'Added' 'WorkFlow Status available in ContentResults");
            } else if (actValue.equalsIgnoreCase("Edited")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Edited"), true);
                getSession().log_Pass("'Edited' 'WorkFlow Status available in ContentResults");
            }
            //Entity
            getSession().log_Info("Check 'Entity' in ContentResults");
            if (actValue.equalsIgnoreCase("New")){
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "New"), true);
            getSession().log_Pass("'Entity' available in ContentResults");
            }
            return this;
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Validating Emp Data Failed", exception);
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



    //38005	Users & Roles-Check whether email is triggered to user when new SSO user is created
    public ILiglPage checkEmailTriggeredToNewSSOUserCreation() throws Exception {
        try {

            dataBaseConnection(getSession().getRegressionData("DB_Master"));
            executeSQL_Query(getDriver().sqlQueryForEmailTracker(getSession().getRegressionData("TC37985_SSOEmail"),
                    "SIT-New SSO user login created for {intendeduser} with username as  {username} "));
            getEmailDeliveryStatusFromDB();
            getContentResultsfromDBEmailTracker();
            validateSSOUserData(getDriver().concat(getSession().getRegressionData("TC37985_FirstName"),
                    getSession().getRegressionData("TC37985_LastName")), getSession().getRegressionData("TC37985_SSOEmail"));

            return this;
        } catch (Exception exception) {
            getSession().log_Error("Check Email Triggered To New SSO User Creation Failed");
            throw new Exception("Check Email Triggered To New SSO User Creation", exception);
        }
    }

    //38627	Email Templates-Employee Added /Edited- Check whether all applicable parameters are replacing with actual values in mail
    public ILiglPage checkAllParametersReplacingWithActualValueWhenEmployeeAdded()throws Exception{
        try {
            dataBaseConnection(getSession().getRegressionData("DB_Entity"));
            executeSQL_Query(getDriver().sqlQueryForEmailTracker("ssivaraju@ligl.io",
                    "SIT-{Entity} Employee {action} to Lilac. "));
            getEmailDeliveryStatusFromDB();
            getContentResultsfromDBEmailTracker();
            validateEmpData(getDriver().concat(getSession().getRegressionData("TC33890_FirstName"),
                    getSession().getRegressionData("TC33890_LastName")), getSession().getRegressionData("TC333890_SSOEmail"));
            return this;
        } catch (Exception exception) {
            getSession().log_Error("Check All Parameters Replacing With Actual Value When Employee Added Failed");
            throw new Exception("Check All Parameters Replacing With Actual Value When Employee Added Creation", exception);
        }
    }


}
