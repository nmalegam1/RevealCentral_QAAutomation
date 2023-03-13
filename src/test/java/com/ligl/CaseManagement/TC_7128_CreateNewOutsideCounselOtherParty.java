package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7128_CreateNewOutsideCounselOtherParty extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_7128_CreateNewOutsideCounselOtherParty(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToOtherPartyPage()
                    .addingNewParty(data.get("PartyName"),data.get("PartyType"), data.get("Description"), data.get("Status"))
                    .searchingParty(data.get("PartyName"))
                    .createOtherPartyNewOutsideCounsel(data.get("PartyName"), data.get("NameTextBox"),data.get("PartyDrpDwn"), data.get("Description"), data.get("Status"),data.get("FirstName"),data.get("LastName"))
                    .validateAddedNewOutsideCounsel(data.get("OutsideCounsel"), data.get("NameTextBox"));




        } catch (Exception ex) {
            session.log_Error("TC_7128_CreateNewOutsideCounselOtherParty Failed");
            throw new Exception("TC_7128_CreateNewOutsideCounselOtherParty Failed", ex);
        } finally {
            session.end();
        }
    }
}
