package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserCanChooseAnyDate_PastAndCurrent_DateInDueDateFieldInProjectCreateOredit extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserCanChooseAnyDate_PastAndCurrent_DateInDueDateFieldInProjectCreateOredit(Hashtable<String, String> data) throws Exception {
         testCaseId="2453420";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .verifyUserCanChooseAnyDateInDueDateWhileProjectCreateOrEdit(data)
                    .validateCreatedCase(data.get("PROJECT"));

        } catch (Exception ex) {
            session.log_Error("TC_60305_VerifyUserCanChooseAnyDate_PastAndCurrent_DateInDueDateFieldInProjectCreateOredit Failed");
            throw new Exception("TC_60305_VerifyUserCanChooseAnyDate_PastAndCurrent_DateInDueDateFieldInProjectCreateOredit Failed", ex);
        } finally
        {
            session.end();
        }
    }
}
