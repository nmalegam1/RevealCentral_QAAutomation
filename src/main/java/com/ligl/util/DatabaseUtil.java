package com.ligl.util;

import org.json.JSONObject;
import org.testng.Assert;

import java.sql.*;
import java.util.Hashtable;


public class DatabaseUtil {


    public static void dbConnection(String testCase, Hashtable<String, String> data) throws Exception {
        Connection conn = null;
        try {
            //SIT WINDOWS AUTHENTICATION
            String dbURL = "jdbc:sqlserver://IN-OPT-SIT-01\\OPTIMUM_SIT:58082;databaseName=OPTIMUM_SIT_VD_US;integratedSecurity=true";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            //RT WINDOWS AUTHENTICATION
//            String dbURL = "jdbc:sqlserver://US-DBSERVER\\VDSQL,60444;databaseName=PRM_EP_VD_US;integratedSecurity=true";
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            conn = DriverManager.getConnection(dbURL);
            if (conn != null) {
                DatabaseMetaData dm = conn.getMetaData();
                System.out.println("Driver name: " + dm.getDriverName());
                Statement sqlStatement = conn.createStatement();
              //  String queryStatus = getQueryForStatus(data);
                String queryStatus=data.get("SqlQuery");
                Thread.sleep(310000);
                //Thread.sleep(2000);
                ResultSet rs = sqlStatement.executeQuery(queryStatus);


                if (rs.next()) {
                    String status = rs.getString("EmailStatus");
                    if (status.equals("8270") || status.equals("8271")) {
                      Thread.sleep(310000);
                      //  Thread.sleep(100000);
                        ResultSet rs1 = sqlStatement.executeQuery(queryStatus);
                        if (rs.next()) {
                            String status1 = rs.getString("EmailStatus");
                            if (status1.equals("8272")) {

                                String contentResults = rs.getString("ContentResults");
                                JSONObject json = new JSONObject(contentResults);
                                boolean result = validateParams(testCase, json, data);
                                if (result) {
                                    Assert.assertEquals("Valid", "Valid");
                                } else {
                                    Assert.assertEquals("Invalid", "Valid");
                                }
                            } else {
                                Assert.assertEquals("Invalid", "Valid");
                            }
                        } else {
                            Assert.assertEquals("Invalid", "Valid");
                        }
                    } else if (status.equals("8272")) {
                        String contentResults = rs.getString("ContentResults");
                        JSONObject json = new JSONObject(contentResults);
                        boolean result = validateParams(testCase, json, data);
                        if (result) {
                            Assert.assertEquals("Valid", "Valid");
                        } else {
                            Assert.assertEquals("Invalid", "Valid");
                        }
                    } else {
                        Assert.assertEquals("Invalid", "Valid");
                    }


                } else {
                    Assert.assertEquals("Invalid", "Valid");
                    System.out.println("fail");
                }
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (conn != null && !conn.isClosed()) {
                    conn.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public static String getQueryForStatus(Hashtable<String, String> data) {

        StringBuilder testBuilder = new StringBuilder();
        String toAddress = data.get("ToAddress");
        String subjectWithParams = data.get("SubjectWithParams");
        String emailStatus1 = "(8270,8271,8272)";
        String caseName = data.get("CaseName");
        testBuilder.append("select top 1 * from Vertical.EmailTracker where ToAddress=");
        testBuilder.append("'");
        testBuilder.append(toAddress);
        testBuilder.append("'");
        testBuilder.append(" and EmailStatus in");
        testBuilder.append(emailStatus1);
        testBuilder.append(" and SubjectWithParams like");
        testBuilder.append("'%");
        testBuilder.append(subjectWithParams);
        testBuilder.append("%");
        testBuilder.append(caseName);
        testBuilder.append("%'");
        testBuilder.append(" order by 1 desc");
        System.out.println("Sql Query Formed *****" + testBuilder);

        return testBuilder.toString();
    }

    public static boolean validateParams(String testCase, JSONObject json, Hashtable<String, String> data) {
        boolean result = false;
        System.out.println("***** Json Object" + json);
        switch (testCase) {
            case "CaseUserAccess":
                try {
                    Assert.assertEquals(data.get("CaseName"), json.getString("casename"));
                    System.out.println("Case name matching");
                    Assert.assertEquals(data.get("SSOUser"), json.getString("intendeduser"));
                    System.out.println("Intended user matching");
                    Assert.assertEquals(data.get("Description"), json.getString("casedescription"));
                    System.out.println(" Case Description matching");
                    Assert.assertEquals(data.get("Entity"), json.getString("entity"));
                    System.out.println(" Entity matching");
                    Assert.assertEquals(data.get("Region"), json.getString("subentity"));
                    System.out.println(" Region matching");
                    Assert.assertEquals(data.get("CaseType"), json.getString("casetype"));
                    System.out.println(" CaseType matching");
                    Assert.assertEquals(data.get("Role"), json.getString("caserole"));
                    System.out.println(" Role matching");
                    Assert.assertEquals(data.get("CaseSetTemp"), json.getString("casesettingtemplate"));
                    System.out.println(" Case Settings Template matching");
                    Assert.assertEquals(data.get("WFT"), json.getString("workflowsettingtemplate"));
                    System.out.println("workflow template  matching");






                    return true;
                }catch(Exception ex) {
                    return false;
                }


            case "ApprovalResponseMail":
                try {


                    Assert.assertEquals(data.get("CaseName"), json.getString("casename"));
                    System.out.println("Case name matching");

                    Assert.assertEquals(data.get("CaseSetTemp"), json.getString("casesettingstemplate"));
                    System.out.println(" Case Settings Template matching");

                    Assert.assertEquals(data.get("UserName"), json.getString("intendeduser"));
                    System.out.println("Intended user matching");

                    Assert.assertEquals(data.get("Action"), json.getString("action"));
                    System.out.println(" Action matching");

                    Assert.assertEquals(data.get("Description"), json.getString("casedescription"));
                    System.out.println(" Case Description matching");

                    String inhouse1 = data.get("InhouseCounsel");
                    String inhouse2 = json.getString("caseinhousecounsels");
                    if (inhouse2.contains(inhouse1)){
                        Assert.assertTrue(true);
                        System.out.println("Inhouse Counsel  matching");
                    }
                    else{
                        Assert.assertTrue(false);
                        System.out.println("Inhouse Counsel not matching");
                    }
                    String outhouse1 = data.get("OutsideCounsel");
                    String outhouse2 = json.getString("caseoutsidecounsels");
                    if (outhouse2.contains(outhouse1)){
                        Assert.assertTrue(true);
                        System.out.println("Outside Counsel  matching");
                    }
                    else{
                        Assert.assertTrue(false);
                        System.out.println("Outside Counsel not matching");
                    }

                    Assert.assertEquals(data.get("FirstApprover"), json.getString("firstApprover"));
                    System.out.println("Approver  matching");

                    Assert.assertEquals(data.get("Entity"), json.getString("entity"));
                    System.out.println(" Entity matching");


                    Assert.assertEquals(data.get("CaseType"), json.getString("casetype"));
                    System.out.println(" CaseType matching");


                    Assert.assertEquals(data.get("Role"), json.getString("caserole"));
                    System.out.println(" Role matching");


                    String court1 = data.get("Court");
                    String court2 = json.getString("courts");
                    if (court2.contains(court1)){
                        Assert.assertTrue(true);
                        System.out.println("Court  matching");
                    }
                    else{
                        Assert.assertTrue(false);
                        System.out.println("Court not matching");
                    }





                    Assert.assertEquals(data.get("InPlacePreservation"), json.getString("inplacepreservation"));
                    System.out.println("InPlacePreservation matching");


                    Assert.assertEquals(data.get("WFT"), json.getString("workflowtemplate"));
                    System.out.println("workflow template  matching");

                    Assert.assertEquals(data.get("Region"), json.getString("subentity"));
                    System.out.println(" Region matching");


                    Assert.assertEquals(data.get("DocketNumber"), json.getString("docketnumber"));
                    System.out.println(" DocketNumber matching");


                    Assert.assertEquals(data.get("DueDate"), json.getString("caseduedate"));
                    System.out.println(" DueDate matching");


                    Assert.assertEquals(data.get("ApprovalType"), json.getString("approvalType"));
                    System.out.println(" ApprovalType matching");


                    return true;
                }catch(Exception ex) {
                    return false;
                }
            case "CaseUserRevoke":
                try{

                    return true;
                }
                catch(Exception ex) {
                    return false;
                }
            case "CaseUserAccessByEnablingUser":
                try{
                    Assert.assertEquals(data.get("CaseName"), json.getString("casename"));
                    System.out.println("Case name matching");
                    Assert.assertEquals(data.get("AddUser"), json.getString("intendeduser"));
                    System.out.println("Intended user matching");
                    Assert.assertEquals(data.get("Description"), json.getString("casedescription"));
                    System.out.println(" Case Description matching");
                    Assert.assertEquals(data.get("Entity"), json.getString("entity"));
                    System.out.println(" Entity matching");
                    Assert.assertEquals(data.get("Region"), json.getString("subentity"));
                    System.out.println(" Region matching");
                    Assert.assertEquals(data.get("CaseType"), json.getString("casetype"));
                    System.out.println(" CaseType matching");
                    Assert.assertEquals(data.get("Role"), json.getString("caserole"));
                    System.out.println(" Role matching");
                    Assert.assertEquals(data.get("CaseSetTemp"), json.getString("casesettingtemplate"));
                    System.out.println(" Case Settings Template matching");
                    Assert.assertEquals(data.get("WFT"), json.getString("workflowsettingtemplate"));
                    System.out.println("workflow template  matching");

                    return true;
                }catch(Exception ex) {
                    return false;
                }

            case "ApprovalRequestMail":
               try {


                   Assert.assertEquals(data.get("CaseName"), json.getString("casename"));
                   System.out.println("Case name matching");

                   Assert.assertEquals(data.get("CaseSetTemp"), json.getString("casesettingstemplate"));
                   System.out.println(" Case Settings Template matching");

                   Assert.assertEquals(data.get("Description"), json.getString("casedescription"));
                   System.out.println(" Case Description matching");

                   Assert.assertEquals(data.get("UserName"), json.getString("intendeduser"));
                   System.out.println("Intended user matching");

                   String inhouse1 = data.get("InhouseCounsel");
                   String inhouse2 = json.getString("caseinhousecounsels");
                   if (inhouse2.contains(inhouse1)){
                       Assert.assertTrue(true);
                       System.out.println("Inhouse Counsel  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Inhouse Counsel not matching");
                   }
                   String outhouse1 = data.get("OutsideCounsel");
                   String outhouse2 = json.getString("caseoutsidecounsels");
                   if (outhouse2.contains(outhouse1)){
                       Assert.assertTrue(true);
                       System.out.println("Outside Counsel  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Outside Counsel not matching");
                   }

                   Assert.assertEquals(data.get("FirstApprover"), json.getString("firstApprover"));
                   System.out.println("Approver  matching");

                   Assert.assertEquals(data.get("Entity"), json.getString("entity"));
                   System.out.println(" Entity matching");


                   Assert.assertEquals(data.get("CaseType"), json.getString("casetype"));
                   System.out.println(" CaseType matching");


                   Assert.assertEquals(data.get("CaseName"), json.getString("casename"));
                   System.out.println(" CaseName matching");



                   Assert.assertEquals(data.get("Role"), json.getString("caserole"));
                   System.out.println(" Role matching");


                   String court1 = data.get("Court");
                   String court2 = json.getString("courts");
                   if (court2.contains(court1)){
                       Assert.assertTrue(true);
                   System.out.println("Court  matching");
               }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Court not matching");
                   }
                   String kw1 = data.get("KeyWords1");
                   String kw2 = json.getString("keywordslist");
                   if (kw2.contains(kw1)){
                       Assert.assertTrue(true);
                       System.out.println("Keywords  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Keywords not matching");
                   }

                   String Dr1 = data.get("DateRangeslist");
                   String Dr2 = json.getString("daterangeslist");
                   if (Dr2.contains(Dr1)){
                       Assert.assertTrue(true);
                       System.out.println("Dateranges  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Dateranges not matching");
                   }


                   Assert.assertEquals(data.get("InPlacePreservation"), json.getString("inplacepreservation"));
                   System.out.println("InPlacePreservation matching");

                   String dst1 = data.get("Datasource1");
                   String dst2 = json.getString("datasources");
                   if (dst2.contains(dst1)){
                       Assert.assertTrue(true);
                       System.out.println("DataSource  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("DataSource not matching");
                   }

                   String cust1 = data.get("Emp1");
                   String cust2 = json.getString("custodians");
                   if (cust2.contains(cust1)){
                       Assert.assertTrue(true);
                       System.out.println("Custodian  matching");
                   }
                   else{
                       Assert.assertTrue(false);
                       System.out.println("Custodian not matching");
                   }



                   Assert.assertEquals(data.get("WFT"), json.getString("workflowtemplate"));
                   System.out.println("workflow template  matching");

                   Assert.assertEquals(data.get("Region"), json.getString("subentity"));
                   System.out.println(" Region matching");


                   Assert.assertEquals(data.get("DocketNumber"), json.getString("docketnumber"));
                   System.out.println(" DocketNumber matching");


                   Assert.assertEquals(data.get("DueDate"), json.getString("caseduedate"));
                   System.out.println(" DueDate matching");


                   Assert.assertEquals(data.get("ApprovalType"), json.getString("approvalType"));
                   System.out.println(" ApprovalType matching");








                   return true;
               }catch(Exception ex) {
                  return false;
               }




        }

        return result;

    }




}