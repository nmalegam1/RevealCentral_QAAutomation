package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56658_VerifyCaseDocumentNotesInCaseHistory extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_56658_VerifyCaseDocumentNotesInCaseHistory(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }
        ILiglPage Page = new LaunchPage()

                .openBrowser("chrome")
                .navigateURL()
                .login(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                .getLeftMenu()
                .navigateToCaseDocumentsPage()
                .goToNotesPageFromDocuments()
                .createNewNotes(data.get("RequestBy"), data.get("Notes"))
                .getLeftMenu().navigateToNotesHistoryPage()
                .displayingSelectedNotesList(data.get("TypeofEvent"));

        }catch (Exception e)
        {
            session.log_Error("TC_56658_VerifyCaseDocumentNotesInCaseHistory Failed");
            throw new Exception("TC_56658_VerifyCaseDocumentNotesInCaseHistory Failed", e);
        } finally {
            session.end();
        }
    }
}