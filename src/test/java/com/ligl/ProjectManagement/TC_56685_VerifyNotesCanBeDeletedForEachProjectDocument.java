package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56685_VerifyNotesCanBeDeletedForEachProjectDocument  extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_56685_VerifyNotesCanBeDeletedForEachProjectDocument(Hashtable<String,String> data) throws Exception{
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
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
