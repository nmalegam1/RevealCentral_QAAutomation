package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC30468_Employee_Edit_Verify_that_HRStatus_HireDate_TerminatedDate_fields_are_editable_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC30468_Employee_Edit_Verify_that_HRStatus_HireDate_TerminatedDate_fields_are_editable_Test(Hashtable<String, String> data) throws Exception {
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
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .editableFiedsHRStatusHireDateTerminatedDate(data.get("HireDate"), data.get("TerminatedDate"), data.get("HRStatus"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC30468_Employee_Edit_Verify_that_HRStatus_HireDate_TerminatedDate_fields_are_editable_Test");
            throw new Exception("TC30468_Employee_Edit_Verify_that_HRStatus_HireDate_TerminatedDate_fields_are_editable_Test", ex);
        } finally {
            session.end();
        }
    }
}
