package com.ligl.Administration.General.EmployeeMaster;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC40183_User_able_to_save_Employee_without_filling_Title_field_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC40183_User_able_to_save_Employee_without_filling_Title_field_Test(Hashtable<String, String> data) throws Exception {
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
                    .clickOnImport()
                    .clickOnAddEmployeeButton()
                    .createNewEmployee(data.get("EmpID"), data.get("FirstName"), data.get("MiddleName"), data.get("LastName"),
                            data.get("Alias"), data.get("Department"), data.get("Title"), data.get("CheckTitleOptional"),
                            data.get("LastUpdateDate"), data.get("EmpJoinDate"), data.get("EmpTerminatedDate"),
                            data.get("Status"), data.get("EmpHistoricID"), data.get("EmpEmail"), data.get("AlternateEmail"), data.get("SecondaryEmail"),
                            data.get("TobileNumber"), data.get("Work Phone"), data.get("Work Fax"), data.get("Category "), data.get("Entity"), data.get("Location"),
                            data.get("Division"), data.get("Account Type"), data.get("Account Manager First Name"), data.get("Account Manager Middle Name"), data.get("Account Manager Last Name"),
                            data.get("Reporting Manager"), data.get("Office Type"), data.get("Office Name"), data.get("Office Address Line"), data.get("Office Address Building Code"),
                            data.get("Office Address Campus Code"), data.get("Office Address Mailing Code"), data.get("Office Address Zip Code"), data.get("Office Address City"),
                            data.get("Office Address State"), data.get("Affiliation"), data.get("Home Department Code"))
                    .clickOnEmployee()
                    .clickOnEmployee()
                    .searchAndSelectTheEmployee(data.get("SearchEmployeeAlias"))
                    .editEmployee(data.get("EditFirstName"), data.get("EditMiddleName"), data.get("EditLastName"),
                            data.get("EditDepartment"), data.get("EditTitle"), data.get("CheckTitleOptional"),
                            data.get("EditLastUpdateDate"), data.get("EditEmpJoinDate"), data.get("EditEmpTerminatedDate"),
                            data.get("EditStatus"), data.get("EditEmpHistoricID"), data.get("EditAlternateEmail"), data.get("EditSecondaryEmail"),
                            data.get("EditMobileNumber"), data.get("EditWorkPhone"), data.get("EditWorkFax"), data.get("EditCategory"),
                            data.get("EditEmpEntity"), data.get("EditLocation"), data.get("EditDivision"),
                            data.get("EditReportingManager"),data.get("EditOfficeType"), data.get("EditOfficeName"), data.get("EditOfficeAddressLine"),
                            data.get("EditOfficeAddressBuildingCode"), data.get("EditOfficeAddressCampusCode"), data.get("EditOfficeAddressMailingCode"),
                            data.get("EditOfficeAddressZipCode"), data.get("EditOfficeAddressCity"),
                            data.get("EditOfficeAddressState"), data.get("EditAffiliation"), data.get("EditHomeDepartmentCode"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC40183_User_able_to_save_Employee_without_filling_Title_field_Test");
            throw new Exception("TC40183_User_able_to_save_Employee_without_filling_Title_field_Test", ex);
        } finally {
            session.end();
        }
    }
}