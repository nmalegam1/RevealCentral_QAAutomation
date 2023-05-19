package com.ligl.Administration.General.ContactMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC42982_Verify_Mobile_number_field_optional_field_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC42982_Verify_Mobile_number_field_optional_field_Test(Hashtable<String, String> data) throws Exception{
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))//"usa")
                    .getHeader()
                    .goToAdministrationPage()
                    .clickOnAddContactButton()
                    .createContact(data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Title"),
                            data.get("IsPrimaryContact"), data.get("Status"), data.get("ContactType"), data.get("PartyType"),
                            data.get("PartyName"), data.get("PrimaryEmail"), data.get("SecondaryEmail"), data.get("MobileOptional"),
                            data.get("Telephone"),data.get("Fax"), data.get("AddressLine1"), data.get("AddressLine2"),
                            data.get("Country"), data.get("State"), data.get("City"), data.get("Zip"))
                    .searchAndSelectTheContact(data.get("SearchFirstName"))
                    .editContact(data.get("EditFirstName"), data.get("EditMiddleName"), data.get("EditLastName"), data.get("EditTitle"),
                            data.get("EditIsPrimaryContact"), data.get("EditStatus"), data.get("EditContactType"), data.get("EditPartyType"),
                            data.get("EditPartyName"), data.get("EditPrimaryEmail"), data.get("EditSecondaryEmail"), data.get("EditMobileOptional"),
                            data.get("EditTelephone"),data.get("EditFax"), data.get("EditAddressLine1"), data.get("EditAddressLine2"),
                            data.get("EditCountry"), data.get("EditState"), data.get("EditCity"), data.get("EditZip"))
                    .getHeader()
                    .logout();

        }catch (Exception exception){
            session.log_Error("TC42982_Verify_Mobile_number_field_optional_field_Test");
            throw new Exception("TC42982_Verify_Mobile_number_field_optional_field_Test", exception);
        }finally {
            session.end();
        }
    }
}
