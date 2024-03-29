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

public class Verify_user_able_to_import_Employee_by_giving_all_fields_in_Short_Template_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void Verify_user_able_to_import_Employee_by_giving_all_fields_in_Short_Template_Test(Hashtable<String, String> data) throws Exception {
        testCaseId="2453843";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .clickOnImport()
                    .employeeBulkImport(Constants.ImportXLSX_ShortTemplate)
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC56376_Verify_user_able_to_import_Employee_by_giving_all_fields_in_Short_Template_Test Failed");
            throw new Exception("TC56376_Verify_user_able_to_import_Employee_by_giving_all_fields_in_Short_Template_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
