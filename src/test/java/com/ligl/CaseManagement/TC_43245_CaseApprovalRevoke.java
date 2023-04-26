package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_43245_CaseApprovalRevoke extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_43245_CaseApprovalRevoke(Hashtable<String,String> data) throws Exception {

        try{

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

        ILiglPage Ref = new LaunchPage()

                .openBrowser("chrome")
                .navigateURL()
                .login(data.get("UserName"),data.get("Password"),data.get("EntitySelection"))
                .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                .getLeftMenu()
                .goToSecurityPage()
                .sendingCaseForSingleApproval(data.get("Batch"),data.get("Approver"), data.get("TempName"))
                .revokeCase()
                .validateRevokeCaseForSingleApproval(data.get("ApproverName1"),data.get("ApprovalStatus"));

        } catch (Exception ex) {
            session.log_Error("TC_43245_CaseApprovalRevoke Failed");
            throw new Exception("TC_43245_CaseApprovalRevoke Failed", ex);
        } finally {
            session.end();
        }
    }
}