package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_55227_CreatingNewNotesForCase extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void CreatingNewNotesForCase_Test(Hashtable<String,String> data) throws Exception{
        try {
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
                    .searchcase(data.get("CaseName"))
                    .GoToNotesPage()
                    .createNewNotes(data.get("RequestBy"), data.get("Notes"))
                    .notesSearchFilter(data.get("Notes"))
                    .validateDataInNotesGrid(data.get("Notes"));
                    /*.editNotes(data.get("EditRequestBy"), data.get("EditNotesContent"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToNotesPage()
                    .notesSearchFilter(data.get("FinalNotesDescription"))
                    .validateDataInNotesGrid(data.get("FinalNotesDescription"))
                    .validateDeletedNote();*/
            }catch (Exception e)
        {session.log_Error("CreatingNewNotesForCase_Test Failed");
            throw new Exception("CreatingNewNotesForCase_Test Failed", e);
        } finally {
            session.end();
        }




    }
}
