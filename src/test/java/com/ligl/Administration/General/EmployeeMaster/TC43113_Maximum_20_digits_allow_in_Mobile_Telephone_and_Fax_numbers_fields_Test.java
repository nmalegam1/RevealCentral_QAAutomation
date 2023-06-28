/**
 *
 */
package com.ligl.Administration.General.EmployeeMaster;

import java.util.Hashtable;

import org.testng.SkipException;
import org.testng.annotations.Test;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;

public class TC43113_Maximum_20_digits_allow_in_Mobile_Telephone_and_Fax_numbers_fields_Test extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC43113_Maximum_20_digits_allow_in_Mobile_Telephone_and_Fax_numbers_fields_Test(Hashtable<String, String> data) throws Exception{
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testing
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .clickOnImport()
                    .clickOnAddEmployeeButton()
                    .employeeMaximumOfDigitsAllowedContctFields(data.get("MobileNumber"), data.get("TelephoneNumber"), data.get("WorkFaNumber"))
                    .clickOnEmployee()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .employeeMaximumOfDigitsAllowedContctFields(data.get("EditMobileNumber"), data.get("EditTelephoneNumber"), data.get("EditWorkFaNumber"))
                    .getHeader()
                    .logout();
        }catch (Exception ex) {
            session.log_Error("TC43113_Maximum_20_digits_allow_in_Mobile_Telephone_and_Fax_numbers_fields_Test");
            throw new Exception("TC43113_Maximum_20_digits_allow_in_Mobile_Telephone_and_Fax_numbers_fields_Test", ex);
        }finally {
            session.end();
        }
    }
}
