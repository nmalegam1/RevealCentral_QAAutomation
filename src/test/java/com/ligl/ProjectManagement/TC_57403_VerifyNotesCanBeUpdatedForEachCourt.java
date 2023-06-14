package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_57403_VerifyNotesCanBeUpdatedForEachCourt extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_57403_VerifyNotesCanBeUpdatedForEachCourt(Hashtable<String, String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .searchingAddedCourt(data.get("CourtName1"))
                    .clickingOnNotesIconInCourtGrid()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .clickOnRefreshButtonInNotesGrid()
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .secondSearchInNotesGrid(data.get("NOTES2"))
                    .editNotes(data.get("REQBY4"), data.get("NOTES4"))
                    .clickOnRefreshButtonInNotesGrid()
                    .validateDataInNotesGrid(data.get("NOTES4"));

        } catch (Exception ex) {
            session.log_Error("TC_57403_VerifyNotesCanBeUpdatedForEachCourt Failed");
            throw new Exception("TC_57403_VerifyNotesCanBeUpdatedForEachCourt Failed", ex);
        } finally {
            session.end();
        }
    }
}