package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC29212_Verify_availability_of_Mentioned_Optional_Additional_fields_Test extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC29212_Verify_availability_of_Mentioned_Optional_Additional_fields_Test(Hashtable<String, String> data) throws Exception {
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
                    .availablityOfOptionlFields()
                    .clickOnEmployee()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .availablityOfOptionlFields()
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC29212_Verify_availability_of_Mentioned_Optional_Additional_fields_Test failed");
            throw new Exception("TC29212_Verify_availability_of_Mentioned_Optional_Additional_fields_Test failed", ex);
        } finally {
            session.end();
        }

    }
}
