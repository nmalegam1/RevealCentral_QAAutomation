package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_10329_VerifyProcessOfDeletingAssignedPartyInCase extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_10329_VerifyProcessOfDeletingAssignedPartyInCase(Hashtable<String, String> data) throws Exception {

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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingNewParty(data.get("PartyName"), data.get("PartyType"), data.get("Status"), data.get("Description"))
                    .deletingAddedParty(data.get("PartyName"))
                    .validatedeletedparty(data.get("PartyName"));

        } catch (Exception ex) {
            session.log_Error("TC_10329_VerifyProcessOfDeletingAssignedPartyInCase Failed");
            throw new Exception("TC_10329_VerifyProcessOfDeletingAssignedPartyInCase Failed", ex);
        } finally {
            session.end();
        }
    }
}
