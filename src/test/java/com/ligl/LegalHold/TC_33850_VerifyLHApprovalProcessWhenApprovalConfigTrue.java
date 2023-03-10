package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getHeader().goToApprovalPage().approvingCaseSingleApprover(data.get("BatchName"));



        } catch (Exception ex) {
            session.log_Error("TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue Failed");
            throw new Exception("TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue Failed", ex);
        } finally {
            session.end();
        }
    }
}
