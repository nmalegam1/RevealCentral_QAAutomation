package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_C2453364_Project_OtherParty_VerifyNotesCanBeDeletedForEachParty extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_C2453364_Project_OtherParty_VerifyNotesCanBeDeletedForEachParty(Hashtable<String, String> data) throws Exception {
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
                    .searchcase(data.get("PROJECT"))
                    .GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName1"),data.get("PartyType1"),data.get("Description1"),data.get("Status"))
                    .clickingOnNotesIconInOtherPartyGrid()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .validateDataInNotesGrid(data.get("NOTES1"))
                    .validateDataInNotesGrid(data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .clickOnRefreshButtonInNotesGrid()
                    .secondSearchInNotesGrid(data.get("NOTES3"))
                    .deleteTheRequiredNotes()
                    .validateDeletedNote(data.get("NOTES3"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName2"),data.get("PartyType2"),data.get("Description2"),data.get("Status"))
                    .clickingOnNotesIconInOtherPartyGrid()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .validateDataInNotesGrid(data.get("NOTES1"))
                    .validateDataInNotesGrid(data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .clickOnRefreshButtonInNotesGrid()
                    .secondSearchInNotesGrid(data.get("NOTES3"))
                    .deleteTheRequiredNotes()
                    .validateDeletedNote(data.get("NOTES3"));




        } catch (Exception ex) {
            session.log_Error("TC_C2453364_Project_OtherParty_VerifyNotesCanBeDeletedForEachParty Failed");
            throw new Exception("TC_C2453364_Project_OtherParty_VerifyNotesCanBeDeletedForEachParty Failed", ex);
        } finally {
            session.end();
        }
    }

}