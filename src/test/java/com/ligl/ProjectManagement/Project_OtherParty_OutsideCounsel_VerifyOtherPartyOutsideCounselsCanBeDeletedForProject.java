package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Project_OtherParty_OutsideCounsel_VerifyOtherPartyOutsideCounselsCanBeDeletedForProject extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void Project_OtherParty_OutsideCounsel_VerifyOtherPartyOutsideCounselsCanBeDeletedForProject(Hashtable<String, String> data) throws Exception {
        testCaseId="2453327";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToOtherPartyPage()
                    .clickAddPartyBtns()
                    .addingNewParty(data.get("PartyName"), data.get("PartyType"), data.get("Status"), data.get("Description"))
                    .searchingParty(data.get("PartyName"))
                    .createOtherPartyNewOutsideCounsel(data.get("PartyName"), data.get("NameTextBox"), data.get("PartyDrpDwn"), data.get("Description"), data.get("Status"), data.get("FirstName"), data.get("LastName"))
                    .validateAddedNewOutsideCounsel(data.get("OutsideCounsel"), data.get("NameTextBox"))
                    .deleteOutsideCounselForTheRespectiveParty(data.get("OutsideCounsel"));


        } catch (Exception ex) {
            session.log_Error("TC_C2453327_Project_OtherParty_OutsideCounsel_VerifyOtherPartyOutsideCounselsCanBeDeletedForProject Failed");
            throw new Exception("TC_C2453327_Project_OtherParty_OutsideCounsel_VerifyOtherPartyOutsideCounselsCanBeDeletedForProject Failed", ex);
        } finally {
            session.end();
        }
    }
}