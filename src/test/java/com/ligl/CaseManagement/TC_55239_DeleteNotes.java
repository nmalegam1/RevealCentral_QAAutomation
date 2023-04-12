package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_55239_DeleteNotes extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_55239_DeleteNotes(Hashtable<String,String> data) throws Exception {
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
                .login(data.get("Username"), data.get("Password"),data.get("Entity"))
             //   .selectEntity(data.get("Entity"))
                .searchcase(data.get("CaseName"))
                .goToNotesPage()
                .notesSearchFilter(data.get("NotesDescription"))
              //  .NewTabFunction()
//                .notesDelete()
//                .getHeader()
//                .goToCasePage()
//                .searchcase(data.get("CaseName"))
//                .GoToNotesPage()
//                .NotesSearchFilter(data.get("NotesDescription"))
                .NotesDelete(data.get("NotesDescription"))
               .validateDeletedNote(data.get("NotesDescription"));

    }
}
