package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC51896_Employee_Edit_nonEditable_fields_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC51896_Employee_Edit_nonEditable_fields_Test(Hashtable<String, String> data) throws Exception {
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
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .empNonEditableFields()
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC51896_Employee_Edit_nonEditable_fields_Test");
            throw new Exception("TC51896_Employee_Edit_nonEditable_fields_Test", ex);
        } finally {
            session.end();
        }
    }

}
