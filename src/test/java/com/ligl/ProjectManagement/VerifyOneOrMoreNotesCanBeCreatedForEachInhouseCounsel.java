package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel(Hashtable<String, String> data) throws Exception {
        testCaseId="2453356";
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
                    .createNewCase(data)
                    .getLeftMenu().goToCaseCounselPage()
                    .addInhouseCounselToCase(data.get("Email1"), data.get("CounselName"))
                    .addInhouseCounselToCase(data.get("Email2"), data.get("CounselName2"))

                    .searchingRequriedCounsel(data.get("Email1"))
                    .clickingOnNotesIcon()
                    .createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .createNewNotes(data.get("RequestBy1"),data.get("NotesContent1"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent1"))

                    .getLeftMenu().goToCaseCounselPage()
                    .searchingRequriedCounsel(data.get("Email2"))
                    .clickingOnNotesIcon()
                    .createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .createNewNotes(data.get("RequestBy1"),data.get("NotesContent1"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent1"));


        } catch (Exception ex) {
            session.log_Error("TC_57290_VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel Failed");
            throw new Exception("TC_57290_VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel Failed", ex);
        } finally {
            session.end();
        }
    }
}
