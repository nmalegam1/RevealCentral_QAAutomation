package com.ligl.Administration.DataBase;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseValidations;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "DataBase")
    public void TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test(Hashtable<String, String> data) throws Exception {
        DataBaseValidations dataBase = new DataBaseValidations();
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
                    .navigateSSOLoginPage()
                    .SSOLogin(session.getRegressionData("SSOEmail"), session.getRegressionData("SSOPassword"), session.getGlobalData("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmployeeMaster()
                    .getFieldsDataFromEmployee(data)
                    .getHeader()
                    .logout();
            dataBase.checkAllParametersReplacingWithActualValueWhenEmployeeAddOrEdit();
        } catch (Exception ex) {
            session.log_Error("TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test Failed");
            throw new Exception("TC38627_Check_All_Parameters_replacing_with_Actual_values_In_EmailTemplates_When_Employee_Create_Test Failed", ex);
        } finally {
            dataBase.closeTheDBConnection();
            session.end();
        }
    }

}
