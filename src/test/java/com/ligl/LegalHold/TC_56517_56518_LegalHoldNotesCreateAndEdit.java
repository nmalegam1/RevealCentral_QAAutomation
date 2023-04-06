package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56517_56518_LegalHoldNotesCreateAndEdit extends TestBase
{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_56517_56518_LegalHoldNotesCreateAndEdit(Hashtable<String, String> data) throws Exception
    {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Check That Any Added Custodian Should Not Be Displayed In LHN Or In DSI Page Untill Approved

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .legalHoldNotes()
                    .createNewNotes(data.get("RequestBy"),data.get("NotesContent"))
                    .validateDataInNotesGrid(data.get("NotesContent"))
                    .editNotes(data.get("EditRequestBy"),data.get("EditNotesContent"))
                    .validateDataInNotesGrid(data.get("FinalNotesContent"));

        }
        catch (Exception ex)
        {
            session.log_Error("TC_56517_56518_LegalHoldNotesCreateAndEdit");
            throw new Exception("TC_56517_56518_LegalHoldNotesCreateAndEdit Failed", ex);
        }
        finally
        {
            session.end();
        }
    }
}