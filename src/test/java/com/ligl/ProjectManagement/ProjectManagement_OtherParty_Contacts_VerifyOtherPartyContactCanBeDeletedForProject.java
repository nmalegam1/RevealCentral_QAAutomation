package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ProjectManagement_OtherParty_Contacts_VerifyOtherPartyContactCanBeDeletedForProject extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void ProjectManagement_OtherParty_Contacts_VerifyOtherPartyContactCanBeDeletedForProject(Hashtable<String, String> data) throws Exception {
        testCaseId="2453279";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName"), data.get("PartyType"), data.get("Description"),data.get("Status"))
                    .createNewContactForSelectedParty(data.get("PartyName"), data.get("FirstName"), data.get("LastName"))
                    .searchingContact(data.get("ContactName"))
                    .validatingContactAddedForParty(data.get("ContactName"))
                    .deleteContactsAddedForRespectiveParty(data.get("ContactName"))
                    .validatingContactsAfterDeletingFromParty();


        } catch (Exception ex) {
            session.log_Error("TC_C2453279_ProjectManagement_OtherParty_Contacts_VerifyOtherPartyContactCanBeDeletedForProject Failed");
            throw new Exception("TC_C2453279_ProjectManagement_OtherParty_Contacts_VerifyOtherPartyContactCanBeDeletedForProject Failed", ex);
        } finally {
            session.end();
        }
    }
}