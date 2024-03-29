package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_26253_CheckCaseEditBtnEnabled extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_26253_CheckCaseEditBtnEnabled(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseNotinitiatedState()
                    .getLeftMenu().goToCaseManagement().verifyingEditBtn().getHeader().goToCasePage()
                    .searchcase(data.get("CaseName1")).GoToCase(data.get("CaseName1"))
                    .getLeftMenu().goToSecurityPage().validateCasePendingForApprovalState()
                    .getLeftMenu().goToCaseManagement().verifyingEditBtn().getHeader().goToCasePage()
                    .searchcase(data.get("CaseName2")).GoToCase(data.get("CaseName2"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState()
                    .getLeftMenu().goToCaseManagement().verifyingEditBtn();


        } catch (Exception ex) {
            session.log_Error("TC_26253_CheckCaseEditBtnEnabled Failed");
            throw new Exception("TC_26253_CheckCaseEditBtnEnabled Failed", ex);
        } finally {
            session.end();
        }
    }
}
