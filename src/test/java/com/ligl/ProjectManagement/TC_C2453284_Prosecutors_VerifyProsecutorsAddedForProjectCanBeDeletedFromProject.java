package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_C2453284_Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_C2453284_Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject(Hashtable<String, String> data) throws Exception {

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
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("AvailableCourt"))
                    .searchingAddedCourt(data.get("AvailableCourt"))
                    .navigateAndAddProsecutor(data.get("AvailableCourt"), data.get("AvailableProsecutor1"), data.get("AvailableProsecutor2"), data.get("AvailableProsecutor3"), data.get("AvailableProsecutor4"))
                    .validateProsecutors(data.get("AvailableProsecutor1"), data.get("AvailableProsecutor2"), data.get("AvailableProsecutor3"), data.get("AvailableProsecutor4"))
                    .searchProsecutor(data.get("FirstName"), data.get("LastName"))
                    .deleteProsecutor(data.get("FirstName"), data.get("LastName"));


        } catch (Exception ex) {
            session.log_Error("TC_1731_VerifyUserAbleToAddExistingProsecutorsForCourt Failed");
            throw new Exception("TC_1731_VerifyUserAbleToAddExistingProsecutorsForCourt Failed", ex);
        } finally {
            session.end();
        }
    }
}

