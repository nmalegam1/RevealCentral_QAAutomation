package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_44367_CaseApprovalReassignForDualApproval extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_44367_CaseApprovalReassignForDualApproval(Hashtable<String,String> data) throws Exception {

        try{

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }
        ILiglPage page = new LaunchPage()
                .openBrowser("chrome")
                .navigateURL()
                .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                .getLeftMenu().goToSecurityPage()
                .validateCasePendingForApprovalState()
                .reAssignCaseForDualApproval(data)
                .validateReassignForDualApproval(data.get("ApproverName2"),data.get("ApproverName1"),data.get("ApprovalStatus"));

        } catch (Exception ex) {
            session.log_Error("TC_44367_CaseApprovalReassignForDualApproval Failed");
            throw new Exception("TC_44367_CaseApprovalReassignForDualApproval Failed", ex);
        } finally {
            session.end();
        }
    }
}