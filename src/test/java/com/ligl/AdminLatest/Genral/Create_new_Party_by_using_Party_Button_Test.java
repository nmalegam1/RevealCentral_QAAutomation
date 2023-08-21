package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Create_new_Party_by_using_Party_Button_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void Create_new_Party_by_using_Party_Button_Test(Hashtable<String, String> data) throws Exception{
        testCaseId="2453819";
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
                    .getAdminLeft()
                    .navigateToPartiesPage()
                    .clickOnAddPartyButton()
                    .craeteNewParty(data.get("Name"), data.get("PartyType"), data.get("Department"), data.get("Status"), data.get("Description"),
                            data.get("Website"), data.get("Email"), data.get("Phone"), data.get("Telephone"), data.get("Fax"), data.get("AddressLine1"),
                            data.get("AddressLine2"),data.get("AddressLine3"), data.get("Country"), data.get("State"), data.get("City"), data.get("Zip"))
                    .getHeader()
                    .logout();
        }catch (Exception exception){
            session.log_Error("TC8735_Create_new_Party_by_using_Party_Button_Test");
            throw new Exception("TC8735_Create_new_Party_by_using_Party_Button_Test Failed", exception);
        }finally {
            session.end();
        }
    }

}
