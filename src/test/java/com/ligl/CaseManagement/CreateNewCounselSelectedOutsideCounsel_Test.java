package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CreateNewCounselSelectedOutsideCounsel_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void CreateNewCounselSelectedOutsideCounsel_Test(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyNameA"),data.get("PartyNew"))
                    .searchingParty()
                    .createNewCounselForSelectedOutsideCounsel(data.get("PartyNew"),data.get("OptionFromLawFirmDropDwn"),data.get("FirstName"),data.get("LastName"))
                    .searchingOutSideCounsel(data.get("PartyNew"),data.get("OptionFromLawFirmDropDwn"))
                    .validateAddedOutsideCounsel(data.get("OutSideCounselName"));



        } catch (Exception ex) {
            session.log_Error("CreateNewCounselSelectedOutsideCounsel_Test Failed");
            throw new Exception("CreateNewCounselSelectedOutsideCounsel_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}


