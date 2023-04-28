package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseUtil;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC33890_Creating_new_Employee_using_Employee_button_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC33890_Creating_new_Employee_using_Employee_button_Test(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), session.getGlobalData("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .clickOnImport()
                    .clickOnAddEmployeeButton()
                    .createNewEmployee(data.get("EmpID"), data.get("FirstName"), data.get("MiddleName"), data.get("LastName"),
                            data.get("Alias"), data.get("Department"), data.get("Title"), data.get("CheckTitleOptional"),
                            data.get("LastUpdateDate"), data.get("EmpJoinDate"), data.get("EmpTerminatedDate"),
                            data.get("Status"), data.get("EmpHistoricID"), data.get("EmpEmail"), data.get("AlternateEmail"), data.get("SecondaryEmail"),
                            data.get("MobileNumber"), data.get("WorkPhone"), data.get("WorkFax"), data.get("Category"), data.get("EmpEntity"), data.get("Location"),
                            data.get("Division"), data.get("AccountType"), data.get("AccountManagerFirstName"), data.get("AccountManagerMiddleName"), data.get("AccountManagerLastName"),
                            data.get("ReportingManager"), data.get("OfficeType"), data.get("OfficeName"), data.get("OfficeAddressLine"), data.get("OfficeAddressBuildingCode"),
                            data.get("OfficeAddressCampusCode"), data.get("OfficeAddressMailingCode"), data.get("OfficeAddressZipCode"), data.get("OfficeAddressCity"),
                            data.get("OfficeAddressState"), data.get("Affiliation"), data.get("HomeDepartmentCode"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test");
            throw new Exception("TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test", ex);
        } finally {
            session.end();
        }
    }

}
