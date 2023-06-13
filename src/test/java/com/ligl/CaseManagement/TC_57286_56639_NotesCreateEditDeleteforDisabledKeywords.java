package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_57286_56639_NotesCreateEditDeleteforDisabledKeywords extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_57286_56639_NotesCreateEditDeleteforDisabledKeywords(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToKeyWordsPage()
                    .addKeywordsByBasic(data.get("Keywords"))
                    .searchRequiredKeywordName(data.get("KWname"))
                    .enableAndDisableKeywords(data.get("Status1"))
                    .validateEnableAndDisableKeywords(data.get("Status2"))
                    .disabledKeywordsNotesClick(data.get("KWname"))
                    .createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .editNotes(data.get("EditRequestBy"),data.get("EditNotesContent"))
                    .validateDataInNotesGrid(data.get("FinalNotesContent"))
                    .NotesDelete(data.get("FinalNotesContent"))
                    .validateDeletedNote(data.get("FinalNotesContent"))
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC_57286_56639_NotesCreateEditDeleteforDisabledKeywords Failed");
            throw new Exception("TC_57286_56639_NotesCreateEditDeleteforDisabledKeywords Failed", ex);
        } finally {
            session.end();
        }
    }
}
