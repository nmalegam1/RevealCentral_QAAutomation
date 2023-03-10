package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_9972_VerifyProcessOfCreatingCaseByClickingSaveAndAddDetailsBtn extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_9972_VerifyProcessOfCreatingCaseByClickingSaveAndAddDetailsBtn(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .createNewCase(data)
                    .validateCreatedCase(data.get("CaseName"));

        } catch (Exception ex) {
            session.log_Error("TC_9972_VerifyProcessOfCreatingCaseByClickingSaveAndAddDetailsBtn Failed");
            throw new Exception("TC_9972_VerifyProcessOfCreatingCaseByClickingSaveAndAddDetailsBtn Failed", ex);
        } finally
        {
            session.end();
        }
    }
}
