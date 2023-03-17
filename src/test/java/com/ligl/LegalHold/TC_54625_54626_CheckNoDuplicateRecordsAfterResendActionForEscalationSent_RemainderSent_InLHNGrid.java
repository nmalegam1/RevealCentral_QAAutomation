package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_54625_54626_CheckNoDuplicateRecordsAfterResendActionForEscalationSent_RemainderSent_InLHNGrid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
    public void TC_54625_54626_CheckNoDuplicateRecordsAfterResendActionForEscalationSent_RemainderSent_InLHNGrid(Hashtable<String,String> data) throws Exception {
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
                    .searchcase(data.get("RemainderCaseName")).GoToCase(data.get("RemainderCaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("RemainderLHN"))
                    .goToLegalHold(data.get("RemainderLHN"))
                    .resendLHN(data.get("RemainderMail"),data.get("CustAction"))
                    .getHeader().switchCase()
                    .searchcase(data.get("EscalateCase")).GoToCase(data.get("EscalateCase"))
                    .searchRequiredLegalHoldName(data.get("RemainderLHN"))
                    .goToLegalHold(data.get("RemainderLHN"))
                    .resendLHN(data.get("EscalateMail"),data.get("CustAction"));
        } catch (Exception ex) {
            session.log_Error("TC_54625_54626_CheckNoDuplicateRecordsAfterResendActionForEscalationSent_RemainderSent_InLHNGrid Failed");
            throw new Exception("TC_54625_54626_CheckNoDuplicateRecordsAfterResendActionForEscalationSent_RemainderSent_InLHNGrid Failed", ex);
        } finally {
            session.end();
        }
    }
}



