package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject(Hashtable<String, String> data) throws Exception {
        testCaseId="2453284";
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
            session.log_Error("Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject Failed");
            throw new Exception("Prosecutors_VerifyProsecutorsAddedForProjectCanBeDeletedFromProject Failed", ex);
        } finally {
            session.end();
        }
    }
}

