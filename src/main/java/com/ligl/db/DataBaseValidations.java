package com.ligl.db;

import com.ligl.base.pages.ILiglPage;
import org.testng.Assert;

public class DataBaseValidations extends DataBaseUtil {

    public ILiglPage validateCaseApprovalRequest(String intendedUser,String caseType, String caseRole, String caseName,
                                                 String casePrefix, String caseCreatedDate) throws Exception {
        try {
            //intended-user
            getSession().log_Info("Check 'Intendeduser' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), intendedUser), true);
            getSession().log_Pass("'Intendeduser' Entity available in ContentResults");

            //case Type
            getSession().log_Info("Check 'Case Role' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), caseType), true);
            getSession().log_Pass(caseType.toUpperCase() + " 'Case Type' Entity available in ContentResults");


            //caseRole
            getSession().log_Info("Check 'Case Role' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), caseRole), true);
            getSession().log_Pass(caseRole.toUpperCase() + " 'Case Role' Entity available in ContentResults");

            //case name
            getSession().log_Info("Check 'Case Name' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), caseName), true);
            getSession().log_Pass(caseName.toUpperCase()+ " 'Case Name' Entity available in ContentResults");

            //case prefix
            getSession().log_Info("Check 'Case Prefix' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), casePrefix), true);
            getSession().log_Pass(casePrefix.toUpperCase()+ " 'Case Prefix' Entity available in ContentResults");

            //case created date
            getSession().log_Info("Check 'Case Created Date' in ContentResults");
            Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), caseCreatedDate), true);
            getSession().log_Pass(caseCreatedDate.toUpperCase()+" 'Case Created Date' Entity available in ContentResults");

            return this;
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Validating Case Approval Request Data Failed", exception);
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
            throw new Exception("Validate Use and Roles Data Failed", exception);
        }
    }

    public ILiglPage validateSSOUserData(String intendeduser, String userName) throws Exception {
        try {
            //intended user
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
            //intended user
            //Custodian Name
            getSession().log_Info("Check 'Custodian Name' in ContentResults");
            System.out.println(custodianName);
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), custodianName)), true);
            getSession().log_Pass("'Custodian Name' available in ContentResults");

            //Employee Email id
            getSession().log_Info("Check 'Employee Email I'd' in ContentResults");
            System.out.println(emailID);
            Assert.assertEquals((getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), emailID)), true);
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

            //workflow status
            getSession().log_Info("Check 'WorkFlow Status' in ContentResults");
            if (actValue.contains("Added")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Added"), true);
                getSession().log_Pass("'Added' 'WorkFlow Status available in ContentResults");
            } else if (actValue.contains("Edited")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "Edited"), true);
                getSession().log_Pass("'Edited' 'WorkFlow Status available in ContentResults");
            }
            //Entity
            getSession().log_Info("Check 'Entity' in ContentResults");
            if (actValue.contains("New")) {
                Assert.assertEquals(getDriver().isSubstring(getSession().getRegressionData("DB_ContentResults"), "New"), true);
                getSession().log_Pass("'New' Entity available in ContentResults");
            }
            return this;
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Validating Emp Data Failed", exception);
        }
    }

    /*************************************************Test Cases****************************************************/

    //38005	Users & Roles-Check whether email is triggered to user when new SSO user is created
    public ILiglPage checkEmailTriggeredToNewSSOUser() throws Exception {
        try {
            dataBaseConnection(getSession().getRegressionData("DB_Master"));
            executeSQL_Query(getDriver().sqlQueryForEmailTracker(getSession().getRegressionData("get_SSOEmail"),
                    "SIT-New SSO user login created for {intendeduser} with username as  {username} "));
            getEmailDeliveryStatusFromDB();
            getContentResultsfromDBEmailTracker();
            validateSSOUserData(getDriver().concat(getSession().getRegressionData("getSSOFirstName"), " ",
                    getSession().getRegressionData("getSSOLastName")), getSession().getRegressionData("get_SSOEmail"));

            return this;
        } catch (Exception exception) {
            getSession().log_Error("Check Email Triggered To New SSO User Creation Failed");
            throw new Exception("Check Email Triggered To New SSO User Creation", exception);
        }
    }

    //38627	Email Templates-Employee Added /Edited-Check whether all applicable parameters are replacing with actual values in mail
    public ILiglPage checkAllParametersReplacingWithActualValueWhenEmployeeAddOrEdit() throws Exception {
        try {
            dataBaseConnection(getSession().getRegressionData("DB_Entity"));
            executeSQL_Query(getDriver().sqlQueryForEmailTracker(getSession().getRegressionData("SSOEmail"),
                    "SIT-{Entity} Employee {action} to Lilac."));
            getEmailDeliveryStatusFromDB();
            getContentResultsfromDBEmailTracker();
            validateEmpData(getSession().getRegressionData("get_EmployeeFullName"), getSession().getRegressionData("get_EmployeeEmailID"));
            return this;
        } catch (Exception exception) {
            getSession().log_Error("Check All Parameters Replacing With Actual Value When Employee Added Failed");
            throw new Exception("Check All Parameters Replacing With Actual Value When Employee Added Creation", exception);
        }
    }

    //TC42952 Email Templates-Case Approval Request-Check whether all applicable parameters are replacing with actual values in mail
    public ILiglPage checkAllParametersReplacingWithActualValueWhenCaseSendForApprovalRequest() throws Exception {
        try {
            dataBaseConnection(getSession().getRegressionData("DB_Entity"));
            executeSQL_Query(getDriver().sqlQueryForEmailTracker(getSession().getRegressionData("SSOEmail"),
                    "Case Approval"));
            getEmailDeliveryStatusFromDB();
            getContentResultsfromDBEmailTracker();
            validateCaseApprovalRequest(
                    getSession().getRegressionData("get_Case_CreatedBy"),
                    getSession().getRegressionData("get_Case_Type"),
                    getSession().getRegressionData("get_Case_Role"),
                    getSession().getRegressionData("get_Case_Name"),
                    getSession().getRegressionData("get_Case_Prefix"),
                    getSession().getRegressionData("get_Case_CreatedDate")
            );
            return this;
        } catch (Exception exception) {
            getSession().log_Error("Check All Parameters Replacing With Actual Value When Case Send For Approval Request Failed");
            throw new Exception("Check All Parameters Replacing With Actual Value When Case Send For Approval Request Failed", exception);
        }
    }


}
