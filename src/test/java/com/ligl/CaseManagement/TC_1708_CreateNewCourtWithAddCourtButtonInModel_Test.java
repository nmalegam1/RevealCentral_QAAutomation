package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * 512-Case-Courts-Verifying the process of creating New Court to case using +Court button in modal
 */
public class TC_1708_CreateNewCourtWithAddCourtButtonInModel_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_1708_CreateNewCourtWithAddCourtButtonInModel_Test(Hashtable<String, String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .createNewCourt(data.get("CourtName"),data.get("PartyType"),data.get("Description"))
                    .validateCourtAddedToGrid(data.get("CourtName"));

        } catch (Exception | Error ex) {
            throw new Exception("TC_1708_CreateNewCourtWithAddCourtButtonInModel_Test Failed", ex);
        }
    }
}