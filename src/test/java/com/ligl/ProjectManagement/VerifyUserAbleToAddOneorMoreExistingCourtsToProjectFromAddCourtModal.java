package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToAddOneorMoreExistingCourtsToProjectFromAddCourtModal extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToAddOneorMoreExistingCourtsToProjectFromAddCourtModal(Hashtable<String, String> data) throws Exception {

        testCaseId="2453280";
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
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("CourtName1"))
                    .addCourtToCase(data.get("CourtName2"))
                    .addCourtToCase(data.get("CourtName3"))
                    .validateAddedCourts(data.get("CourtName1"))
                    .validateSecondSearchAddedCourts(data.get("CourtName2"))
                    .validateSecondSearchAddedCourts(data.get("CourtName3"));

        } catch (Exception ex) {
            session.log_Error("TC_1707_VerifyUserAbleToAddOneorMoreExistingCourtsToProjectFromAddCourtModal Failed");
            throw new Exception("TC_1707_VerifyUserAbleToAddOneorMoreExistingCourtsToProjectFromAddCourtModal Failed", ex);
        } finally {
            session.end();
        }
    }
}