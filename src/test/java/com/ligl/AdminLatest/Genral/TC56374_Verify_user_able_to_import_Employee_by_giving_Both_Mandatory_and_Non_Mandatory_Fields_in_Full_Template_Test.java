package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.Constants;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC56374_Verify_user_able_to_import_Employee_by_giving_Both_Mandatory_and_Non_Mandatory_Fields_in_Full_Template_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC56374_Verify_user_able_to_import_Employee_by_giving_Both_Mandatory_and_Non_Mandatory_Fields_in_Full_Template_Test(Hashtable<String, String> data) throws Exception {
        testCaseId="";
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("Entity"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .clickOnImport()
                    .employeeBulkImport(Constants.ImportXLSX_Template_FullTemplate)
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC40180_user_is_able_to_import_employee_without_filling_Title_field_Test");
            throw new Exception("TC40180_user_is_able_to_import_employee_without_filling_Title_field_Test", ex);
        } finally {
            session.end();
        }
    }
}
