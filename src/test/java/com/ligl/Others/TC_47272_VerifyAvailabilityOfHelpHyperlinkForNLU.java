package com.ligl.Others;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_47272_VerifyAvailabilityOfHelpHyperlinkForNLU extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_47272_VerifyAvailabilityOfHelpHyperlinkForNLU(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .verifyAvailabilityOfHelpLinkInCaseListPage();

        } catch (Exception ex) {
            session.log_Error("TC_47272_VerifyAvailabilityOfHelpHyperlinkForNLU Failed");
            throw new Exception("TC_47272_VerifyAvailabilityOfHelpHyperlinkForNLU Failed", ex);
        } finally {
            session.end();
        }
    }
}
