package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.Constants;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC56372_Verify_user_able_to_import_Employee_by_giving_AllMandatory_Fields_in_Full_Template_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC56372_Verify_user_able_to_import_Employee_by_giving_AllMandatory_Fields_in_Full_Template_Test(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminGeneral()
                    .getAdminLeft()
                    .clickOnEmployeeMaster()
                    .clickOnImport()
                    .employeeBulkImport(Constants.ImportXLSX_Template_Only_Mandatory_Field)
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC56372_Verify_user_able_to_import_Employee_by_giving_AllMandatory_Fields_in_Full_Template_Test Failed");
            throw new Exception("TC56372_Verify_user_able_to_import_Employee_by_giving_AllMandatory_Fields_in_Full_Template_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
