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
    public void TC_55227_CreatingNewNotesForCase(Hashtable<String,String> data) throws Exception{
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
                    .searchcase(data.get("CaseName")).goToNotesPage()
                    .createNewNotes(data.get("RequestBy"), data.get("Notes"))
                    .notesSearchFilter(data.get("Notes"))
                    .validateDataInNotesGrid(data.get("Notes"));

            }catch (Exception e)
        {session.log_Error("TC_55227_CreatingNewNotesForCase Failed");
            throw new Exception("TC_55227_CreatingNewNotesForCase Failed", e);
        } finally {
            session.end();
        }
    }
}
