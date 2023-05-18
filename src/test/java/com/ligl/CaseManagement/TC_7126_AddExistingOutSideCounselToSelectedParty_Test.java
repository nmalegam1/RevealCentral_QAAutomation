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
 * Case-Other Party-Outside Counsel- Verify the process of adding existing Outside Counsels to selected party from +OutsideCounsel modal
 */
public class TC_7126_AddExistingOutSideCounselToSelectedParty_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_7126_AddExistingOutSideCounselToSelectedParty_Test(Hashtable<String, String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyName"), "Government")
                    .searchingParty(data.get("PartyName"))
                    .addExistingOutCounsel(data.get("ExistingLawFirm"), data.get("SelectedLawFirmSubEntities"))
                     //.searchingOutSideCounsel(data.get("SelectedLawFirmSubEntities"))
                    .validateAddedOutsideCounsel(data.get("SelectedLawFirmSubEntities"));
        } catch (Exception ex) {
            session.log_Error("TC_7126_AddExistingOutSideCounselToSelectedParty_Test Failed");
            throw new Exception("TC_7126_AddExistingOutSideCounselToSelectedParty_Test failed", ex);
        } finally {
            session.end();
        }
    }
}