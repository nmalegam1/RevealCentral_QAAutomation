package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyNotesCanBeDeletedForEachProjectDocument extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "ProjectManagement")
    public void VerifyNotesCanBeDeletedForEachProjectDocument(Hashtable<String,String> data) throws Exception{
         testCaseId="2453351";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().navigateToProjectDocumentsPage()
                    .searchRequiredCaseDocument(data.get("DocumentName"))
                    .goToNotesPageFromDocuments()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .deleteTheRequiredNotes()
                    .validateDeletedNote(data.get("NOTES1"));

        }catch (Exception e)
        {session.log_Error("TC_56685_VerifyNotesCanBeDeletedForEachProjectDocumentFailed");
            throw new Exception("TC_56685_VerifyNotesCanBeDeletedForEachProjectDocument Failed", e);
        } finally {
            session.end();
        }
    }
}
