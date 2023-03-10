package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_50827_CheckNoDuplicateRecordsAfterResendActionLHNGrid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
    public void TC_50827_CheckNoDuplicateRecordsAfterResendActionLHNGrid(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());

            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Launch = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHName"))
                    .goToLegalHold(data.get("LHName"))
                    .resendLHN(data.get("CustMail"),data.get("DPAction"));
        } catch (Exception ex) {
            session.log_Error("TC_50827_CheckNoDuplicateRecordsAfterResendActionLHNGrid Failed");
            throw new Exception("TC_50827_CheckNoDuplicateRecordsAfterResendActionLHNGrid Failed", ex);
        } finally {
            session.end();
        }
    }
}
