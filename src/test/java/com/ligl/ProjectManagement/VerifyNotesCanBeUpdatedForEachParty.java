package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyNotesCanBeUpdatedForEachParty extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyNotesCanBeUpdatedForEachParty(Hashtable<String, String> data) throws Exception {
         testCaseId="2453363";
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
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .searchingParty(data.get("PartyName"))
                    .clickingOnNotesIconInOtherPartyGrid()
                    .notesSearchFilter(data.get("Notes1"))
                    .editNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent"))

                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .searchingParty(data.get("PartyName1"))
                    .clickingOnNotesIconInOtherPartyGrid()
                    .notesSearchFilter(data.get("Notes1"))
                    .editNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent"));


        } catch (Exception ex) {
            session.log_Error("TC_57400_VerifyNotesCanBeUpdatedForEachParty Failed");
            throw new Exception("TC_57400_VerifyNotesCanBeUpdatedForEachParty Failed", ex);
        } finally {
            session.end();
        }
    }
}