package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_57301_VerifyNotesCanBeUpdatedForEachOutsideCounsel extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_57301_VerifyNotesCanBeUpdatedForEachOutsideCounsel(Hashtable<String, String> data) throws Exception {
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
                    .getLeftMenu().goToCaseCounselPage().toggleToOutSideCounsel()
                    .searchRequiredOutsideCounselInOutsideCounselGrid(data.get("OutsideCounsel"))
                    .movingTheCursorToTheRightPosition()
                    .clickingOnNotesIcon()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .secondSearchInNotesGrid(data.get("NOTES2"))
                    .editNotes(data.get("REQBY4"), data.get("NOTES4"))
                    .validateDataInNotesGrid(data.get("NOTES4"));


        } catch (Exception ex) {
            session.log_Error("TC_57301_VerifyNotesCanBeUpdatedForEachOutsideCounsel Failed");
            throw new Exception("TC_57301_VerifyNotesCanBeUpdatedForEachOutsideCounsel Failed", ex);
        } finally {
            session.end();
        }
    }
}