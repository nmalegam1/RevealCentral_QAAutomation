package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyNotesCanBeEditedSuccessfullyFromHistoryGrid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "ProjectManagement")
    public void VerifyNotesCanBeEditedSuccessfullyFromHistoryGrid(Hashtable<String,String> data) throws Exception {
        testCaseId="2453478";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToNotesHistoryPage()
                    .TypeofEventSearchFilter(data.get("TypeofEvent"))
                    .notesEdit(data.get("RequestBy"),data.get("NotesDescription"))
                    .getHeader()
                    .goToCasePage()
                    .searchcase(data.get("CaseName"))
                    .goToNotesPage()
                    .notesSearchFilter(data.get("NotesDescription"))
                    .validateDataInNotesGrid(data.get("NotesDescription"));


        }catch (Exception e)
        {session.log_Error("TC_55286_VerifyNotesCanBeEditedSuccessfullyFromHistoryGrid Failed");
            throw new Exception("TC_55286_VerifyNotesCanBeEditedSuccessfullyFromHistoryGrid Failed", e);
        } finally {
            session.end();
        }
    }
}
