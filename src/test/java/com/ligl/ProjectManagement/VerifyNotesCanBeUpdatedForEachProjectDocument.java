package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyNotesCanBeUpdatedForEachProjectDocument extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "ProjectManagement")
    public void VerifyNotesCanBeUpdatedForEachProjectDocument(Hashtable<String,String> data) throws Exception{
        testCaseId="2453350";
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
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .secondSearchInNotesGrid(data.get("NOTES2"))
                    .editNotes(data.get("REQBY4"), data.get("NOTES4"))
                    .validateDataInNotesGrid(data.get("NOTES4"));

        }catch (Exception e)
        {session.log_Error("TC_56684_VerifyNotesCanBeUpdatedForEachProjectDocument Failed");
            throw new Exception("TC_56684_VerifyNotesCanBeUpdatedForEachProjectDocument Failed", e);
        } finally {
            session.end();
        }
    }
}