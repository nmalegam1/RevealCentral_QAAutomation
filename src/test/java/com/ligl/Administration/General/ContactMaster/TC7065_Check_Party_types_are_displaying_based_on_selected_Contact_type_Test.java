package com.ligl.Administration.General.ContactMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC7065_Check_Party_types_are_displaying_based_on_selected_Contact_type_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC7065_Check_Party_types_are_displaying_based_on_selected_Contact_type_Test(Hashtable<String, String> data) throws Exception {
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
                    .checkPartyNameBasedOnSelectedContactType(data.get("ContactType"), data.get("PartyType"))
                    .searchAndSelectTheContact(data.get("SearchFirstName"))
                    .checkPartyNameBasedOnSelectedContactType(data.get("EditContactType"), data.get("EditPartyType"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC7065_Check_Party_types_are_displaying_based_on_selected_Contact_type_Test");
            throw new Exception("TC7065_Check_Party_types_are_displaying_based_on_selected_Contact_type_Test Failed", ex);
        } finally {
            session.end();
        }
    }

}
