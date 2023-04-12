package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_55286_EditNotesInCaseHistory extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_55286_EditNotesInCaseHistory(Hashtable<String,String> data) throws Exception {
        session.log_Info(data.toString());
        if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
            // skip in extent rep
            session.skipTest("Skipping the test as Runmode was NO");
            //skip - testng
            throw new SkipException("Skipping the test as Runmode was NO");
        }
        ILiglPage Page = new LaunchPage()
                .openBrowser("chrome")
                .navigateURL()
                .login(data.get("Username"), data.get("Password"), data.get("Entity"))
                .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
//                .goToNotesPage().createNewNotes(data.get("RequestBy"), data.get("Notes"))
//                .GoToCase(data.get("CaseName"))
                .getLeftMenu()
                .navigateToNotesHistoryPage()
                .TypeofEventSearchFilter(data.get("TypeofEvent"))
                .notesEdit(data.get("RequestBy"),data.get("Notes"))
                .getHeader()
                .goToCasePage()
                .searchcase(data.get("CaseName"))
                .goToNotesPage()
                .notesSearchFilter(data.get("NotesDescription1"))
                .validateDataInNotesGrid(data.get("NotesDescription1"));
              //  .notesDelete().validateDeletedNote();



    }
}
