package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC35807_Check_that_Designation_field_changed_to_Title_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC35807_Check_that_Designation_field_changed_to_Title_Test(Hashtable<String, String> data) throws Exception {
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
                    .titleFieldName()
                    .clickOnEmployee()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .titleFieldName()
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC35807_Check_that_Designation_field_changed_to_Title_Test");
            throw new Exception("TC35807_Check_that_Designation_field_changed_to_Title_Test", ex);
        } finally {
            session.end();
        }
    }
}
