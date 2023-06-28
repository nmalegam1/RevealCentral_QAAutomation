package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_55227_178_239_VerifyOneOrMoreNotesCanBe_Created_Edited_Deleted_ForEachProject extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "ProjectManagement")
    public void TC_55227_178_239_VerifyOneOrMoreNotesCanBe_Created_Edited_Deleted_ForEachProject(Hashtable<String,String> data) throws Exception{
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
                    .searchcase(data.get("PROJECT")).goToNotesPage()
                    .createNewNotes(data.get("REQBY1"), data.get("NOTES1"))
                    .createNewNotes(data.get("REQBY2"), data.get("NOTES2"))
                    .notesSearchFilter(data.get("NOTES1"))
                    .validateDataInNotesGrid(data.get("NOTES1"))
                    .secondSearchInNotesGrid(data.get("NOTES2"))
                    .validateDataInNotesGrid(data.get("NOTES2"))
                    .editNotes(data.get("REQBY3"), data.get("NOTES3"))
                    .getHeader()
                    .goToCasePage().searchcase(data.get("PROJECT")).goToNotesPage()
                    .notesSearchFilter(data.get("NOTES3"))
                    .validateDataInNotesGrid(data.get("NOTES3"))
                    .deleteTheRequiredNotes()
                    .validateDeletedNote(data.get("NOTES3"));

        }catch (Exception e)
        {session.log_Error("TC_55227_178_239_VerifyOneOrMoreNotesCanBe_Created_Edited_Deleted_ForEachProject Failed");
            throw new Exception("TC_55227_178_239_VerifyOneOrMoreNotesCanBe_Created_Edited_Deleted_ForEachProject Failed", e);
        } finally {
            session.end();
        }
    }
}

