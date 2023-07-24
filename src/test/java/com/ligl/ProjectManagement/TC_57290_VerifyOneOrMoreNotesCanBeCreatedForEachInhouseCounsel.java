package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_57290_VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_57290_VerifyOneOrMoreNotesCanBeCreatedForEachInhouseCounsel(Hashtable<String, String> data) throws Exception {
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
                    /*.createNewCase(data)*/
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToCaseCounselPage()
                    /*.addInhouseCounselToCase(data.get("Email1"), data.get("CounselName"))
                    .addInhouseCounselToCase(data.get("Email2"), data.get("CounselName2"))*/

                    .searchingRequriedCounsel(data.get("Email1"))
                    .clickingOnNotesIcon()
                    /*.createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .createNewNotes(data.get("RequestBy1"),data.get("NotesContent1"))*/
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
