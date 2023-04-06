package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC20363_Verify_availability_of_Mentioned_Optional_Dropdown_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC20363_Verify_availability_of_Mentioned_Optional_Dropdown_Test(Hashtable<String, String> data) throws Exception {
        try {
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminGeneral()
                    .getAdminLeft()
                    .clickOnEmployeeMaster()
                    .clickOnImport()
                    .clickOnAddEmployeeButton()
                    .availablityOfOptionlDropDowns()
                    .clickOnEmployee()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .availablityOfOptionlDropDowns()
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC20363_Verify_availability_of_Mentioned_Optional_Dropdown_Test failed");
            throw new Exception("TC20363_Verify_availability_of_Mentioned_Optional_Dropdown_Test failed", ex);
        } finally {
            session.end();
        }

    }
}
