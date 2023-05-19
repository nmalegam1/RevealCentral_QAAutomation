package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7119_CreateNewInhouseCounselEnterpriseParty extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_7119_CreateNewInhouseCounselEnterpriseParty(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToOtherPartyPage()
                    .addingNewParty(data.get("PartyName"), data.get("PartyType"), data.get("Status"), data.get("Description"))
                    .searchingParty(data.get("PartyName"))
                    .createNewInHouseCounselForEnterpriseParty(data.get("PartyName"), data.get("FirstName"), data.get("LastName"))
                    .searchingInHouseCounsel(data.get("PartyName"), data.get("CounselName"))
                    .validateAddedInHouseCounsel(data.get("CounselName"));


        } catch (Exception ex) {
            session.log_Error("TC_7119_CreateNewInhouseCounselEnterpriseParty Failed");
            throw new Exception("TC_7119_CreateNewInhouseCounselEnterpriseParty Failed", ex);
        } finally {
            session.end();
        }
    }
}
