package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToDeleteAddedCourtToProject extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToDeleteAddedCourtToProject(Hashtable<String, String> data) throws Exception {
        testCaseId="2453281";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("CourtName1"))
                    .addCourtToCase(data.get("CourtName2"))
                    .searchingAddedCourt(data.get("CourtName1"))
                    .deleteCourt(data.get("CourtName1"));

        } catch (Exception ex) {
            session.log_Error("TC_1711_VerifyUserAbleToDeleteAddedCourtToProject Failed");
            throw new Exception("TC_1711_VerifyUserAbleToDeleteAddedCourtToProject Failed", ex);
        } finally {
            session.end();
        }
    }
}
