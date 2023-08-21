package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyReassignButtonFunctionalityWhenProjectIsInPendingApprovalState extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "ProjectManagement")
    public void VerifyReassignButtonFunctionalityWhenProjectIsInPendingApprovalState(Hashtable<String,String> data) throws Exception {
         testCaseId="2453469";
        try{

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                     .createNewCase(data)
                    .getLeftMenu().goToSecurityPage()
                    .validateCaseNotinitiatedState()
                    .sendingCaseForSingleApproval(data.get("BatchName"), data.get("UserName"), data.get("TempName"))
                    .performReAssignFunctionalityForTheProject(data.get("TempName1"), data.get("UserName1") )
                    .validateReAssignButtonFunctionality(data.get("AssignedUserName"), data.get("ApprovalStatus"));

        } catch (Exception ex) {
            session.log_Error("TC_42956_VerifyReassignButtonFunctionalityWhenProjectIsInPendingApprovalState Failed");
            throw new Exception("TC_42956_VerifyReassignButtonFunctionalityWhenProjectIsInPendingApprovalState Failed", ex);
        } finally {
            session.end();
        }
    }
}

