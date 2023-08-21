package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Create_new_contact_For_any_party_type_using_addContact_button_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void Create_new_contact_For_any_party_type_using_addContact_button_Test(Hashtable<String, String> data) throws Exception{
        testCaseId="2453818";
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
                    .getHeader()
                    .goToAdministrationPage()
                    .clickOnAddContactButton()
                    .createContact(data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Title"),
                            data.get("IsPrimaryContact"), data.get("Status"), data.get("ContactType"), data.get("PartyType"),
                            data.get("PartyName"), data.get("PrimaryEmail"), data.get("SecondaryEmail"), data.get("Mobile"),
                            data.get("Telephone"),data.get("Fax"), data.get("AddressLine1"), data.get("AddressLine2"),
                            data.get("Country"), data.get("State"), data.get("City"), data.get("Zip"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC8712_Create_new_contact_For_any_party_type_using_addContact_button_Test");
            throw new Exception("TC8712_Create_new_contact_For_any_party_type_using_addContact_button_Test", ex);
        } finally {
            session.end();
        }

    }
}
