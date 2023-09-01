package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyNotesCanBeDeletedForEachOutsideCounsel extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyNotesCanBeDeletedForEachOutsideCounsel(Hashtable<String, String> data) throws Exception {
         testCaseId="2453361";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToCaseCounselPage().toggleToOutSideCounsel()
                    .searchRequiredOutsideCounselInOutsideCounselGrid(data.get("OutsideCounsel"))
                    .movingTheCursorToTheRightPosition()
                    .clickingOnNotesIcon()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .deleteTheRequiredNotes()
                    .validateDeletedNote(data.get("NOTES1"));

        } catch (Exception ex) {
            session.log_Error("TC_57303_VerifyNotesCanBeDeletedForEachOutsideCounsel Failed");
            throw new Exception("TC_57303_VerifyNotesCanBeDeletedForEachOutsideCounsel Failed", ex);
        } finally {
            session.end();
        }
    }
}