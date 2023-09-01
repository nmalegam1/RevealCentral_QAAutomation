package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyOneOrMoreNotesCanBeCreatedForEachParty extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyOneOrMoreNotesCanBeCreatedForEachParty(Hashtable<String, String> data) throws Exception {
        testCaseId="2453362";
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
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName"),data.get("PartyType"),data.get("Status"),data.get("Description"))
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName1"),data.get("PartyType1"),data.get("Status1"),data.get("Description1"))
                    .clickingOnNotesIconInOtherPartyGrid()
                    .createNewNotes(data.get("RequestBy"), data.get("NotesContent"))
                    .createNewNotes(data.get("RequestBy1"), data.get("NotesContent1"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent1"))

                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .searchingParty(data.get("PartyName"))

                    .clickingOnNotesIconInOtherPartyGrid()
                    .createNewNotes(data.get("RequestBy"), data.get("NotesContent"))
                    .createNewNotes(data.get("RequestBy1"), data.get("NotesContent1"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent1"));



        } catch (Exception ex) {
            session.log_Error("TC_57398_VerifyOneOrMoreNotesCanBeCreatedForEachParty Failed");
            throw new Exception("TC_57398_VerifyOneOrMoreNotesCanBeCreatedForEachParty Failed", ex);
        } finally {
            session.end();
        }
    }

}
