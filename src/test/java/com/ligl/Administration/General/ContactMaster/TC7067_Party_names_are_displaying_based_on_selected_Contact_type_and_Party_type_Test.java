package com.ligl.Administration.General.ContactMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC7067_Party_names_are_displaying_based_on_selected_Contact_type_and_Party_type_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC7067_Party_names_are_displaying_based_on_selected_Contact_type_and_Party_type_Test(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .clickOnAddContactButton()
                    .checkPartyName(data.get("ContactType"), data.get("PartyType"), data.get("PartyName"))
                    .searchAndSelectTheContact(data.get("SearchFirstName"))
                    .checkPartyName(data.get("EditContactType"), data.get("EditPartyType"), data.get("EditPartyName"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC7067_Party_names_are_displaying_based_on_selected_Contact_type_and_Party_type_Test");
            throw new Exception("TC7067_Party_names_are_displaying_based_on_selected_Contact_type_and_Party_type_Test", ex);
        } finally {
            session.end();
        }
    }

}
