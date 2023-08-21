package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToDeleteAddedInhouseCounselsToProjectAndDeletedCounselsShouldNotDisplayInGrid extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToDeleteAddedInhouseCounselsToProjectAndDeletedCounselsShouldNotDisplayInGrid(Hashtable<String, String> data) throws Exception {
        testCaseId="2453448";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToCaseCounselPage()
                    .addInhouseCounselToCase(data.get("Email1"), data.get("CounselName"))
                    .deleteInhouseCounselFromCase()
                    .validateInhouseCounsel();

        } catch (Exception ex) {
            session.log_Error("TC_7094_VerifyUserAbleToDeleteAddedInhouseCounselsToProjectAndDeletedCounselsShouldNotDisplayInGrid Failed");
            throw new Exception("TC_7094_VerifyUserAbleToDeleteAddedInhouseCounselsToProjectAndDeletedCounselsShouldNotDisplayInGrid Failed", ex);
        } finally {
            session.end();
        }
    }
}
