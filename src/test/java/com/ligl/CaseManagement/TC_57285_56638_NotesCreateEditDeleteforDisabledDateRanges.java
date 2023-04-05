package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_57285_56638_NotesCreateEditDeleteforDisabledDateRanges extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_57285_56638_NotesCreateEditDeleteforDisabledDateRanges(Hashtable<String, String> data) throws Exception {

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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate"),data.get("EndDate"),data.get("Description"))
                    .searchRequiredDaterangeName(data.get("DRName"))
                    .enableAndDisableDateRanges(data.get("DRStatus1"))
                    .validateEnableAndDisableDateRanges(data.get("DRStatus2"))
                    .disabledDateRangeNotesClick(data.get("DRName"))
                    .createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .editNotes(data.get("EditRequestBy"),data.get("EditNotesContent"))
                    .validateDataInNotesGrid(data.get("FinalNotesContent"))
                    .NotesDelete(data.get("FinalNotesContent"))
                    .validateDeletedNote(data.get("FinalNotesContent"));


        } catch (Exception ex) {
            session.log_Error("TC_57285_56638_NotesCreateEditDeleteforDisabledDateRanges Failed");
            throw new Exception("TC_57285_56638_NotesCreateEditDeleteforDisabledDateRanges Failed", ex);
        } finally {
            session.end();
        }
    }
}
