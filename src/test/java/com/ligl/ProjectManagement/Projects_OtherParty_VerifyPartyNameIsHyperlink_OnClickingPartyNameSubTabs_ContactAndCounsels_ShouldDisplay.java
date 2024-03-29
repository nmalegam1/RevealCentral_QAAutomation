package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Projects_OtherParty_VerifyPartyNameIsHyperlink_OnClickingPartyNameSubTabs_ContactAndCounsels_ShouldDisplay extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void Projects_OtherParty_VerifyPartyNameIsHyperlink_OnClickingPartyNameSubTabs_ContactAndCounsels_ShouldDisplay(Hashtable<String, String> data) throws Exception {
        testCaseId="2453288";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToOtherPartyPage()
                    .searchingParty(data.get("PartyName"))
                    .verifyContactsAndCounselsShouldDisplayForTheRespectiveParty(data.get("Contact"), data.get("Counsel") );


        } catch (Exception ex) {
            session.log_Error("TC_C2453288_Projects_OtherParty_VerifyPartyNameIsHyperlink_OnClickingPartyNameSubTabs_ContactAndCounsels_ShouldDisplay Failed");
            throw new Exception("TC_C2453288_Projects_OtherParty_VerifyPartyNameIsHyperlink_OnClickingPartyNameSubTabs_ContactAndCounsels_ShouldDisplay Failed", ex);
        } finally {
            session.end();
        }
    }
}
