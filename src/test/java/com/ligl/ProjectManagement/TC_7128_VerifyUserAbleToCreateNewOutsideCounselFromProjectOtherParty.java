package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7128_VerifyUserAbleToCreateNewOutsideCounselFromProjectOtherParty extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_7128_VerifyUserAbleToCreateNewOutsideCounselFromProjectOtherParty(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToOtherPartyPage()
                    .clickAddPartyBtns()
                    .addingNewParty(data.get("PartyName"), data.get("PartyType"), data.get("Status"), data.get("Description"))
                    .searchingParty(data.get("PartyName"))
                    .createOtherPartyNewOutsideCounsel(data.get("PartyName"), data.get("NameTextBox"), data.get("PartyDrpDwn"), data.get("Description"), data.get("Status"), data.get("FirstName"), data.get("LastName"))
                    .validateAddedNewOutsideCounsel(data.get("OutsideCounsel"), data.get("NameTextBox"));


        } catch (Exception ex) {
            session.log_Error("TC_7128_VerifyUserAbleToCreateNewOutsideCounselFromProjectOtherParty Failed");
            throw new Exception("TC_7128_VerifyUserAbleToCreateNewOutsideCounselFromProjectOtherParty Failed", ex);
        } finally {
            session.end();
        }
    }
}