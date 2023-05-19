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
 * Case-Other Party-Contact- Verify the process of adding existing Contacts for selected Party from +Contact modal
 */
public class TC_7103_AddExistingContactsForSelectedParty_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_7103_AddExistingContactsForSelectedParty_Test(Hashtable<String, String> data) throws Exception {
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
                    .addingExistingParty(data.get("PartyName"), data.get("PartyType"))
                    .searchingParty(data.get("PartyName"))
                    .addExistingContact(data.get("ExistingContact"));
        } catch (Exception ex) {
            session.log_Error("TC_7103_AddExistingContactsForSelectedParty_Test Failed");
            throw new Exception("TC_7103_AddExistingContactsForSelectedParty_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
