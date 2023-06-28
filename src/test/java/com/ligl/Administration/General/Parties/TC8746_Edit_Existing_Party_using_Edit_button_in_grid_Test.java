package com.ligl.Administration.General.Parties;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC8746_Edit_Existing_Party_using_Edit_button_in_grid_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC8746_Edit_Existing_Party_using_Edit_button_in_grid_Test(Hashtable<String, String> data) throws Exception{
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToPartiesPage()
                    .searchAndSelectTheParties(data.get("SearchPartyName"))
                    .editParty(data.get("EditName"), data.get("EditPartyType"), data.get("EditDepartment"), data.get("EditStatus"),
                            data.get("StatusChangeReason"), data.get("EditDescription"), data.get("EditWebsite"), data.get("EditEmail"),
                            data.get("EditPhone"), data.get("EditTelephone"),data.get("EditFax"), data.get("EditAddressLine1"),
                            data.get("EditAddressLine2"),data.get("EditAddressLine3"), data.get("EditCountry"), data.get("EditState"),
                            data.get("EditCity"), data.get("EditZip"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC8746_Edit_Existing_Party_using_Edit_button_in_grid_Test");
            throw new Exception("TC8746_Edit_Existing_Party_using_Edit_button_in_grid_Test Failed", ex);
        }finally {
            session.end();
        }

    }

}
