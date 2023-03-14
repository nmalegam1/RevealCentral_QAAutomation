package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC25196_User_Able_to_ResetPassword_And_without_Selecting_ManualPassword_checkbox_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC25196_User_Able_to_ResetPassword_And_without_Selecting_ManualPassword_checkbox_Test(Hashtable<String, String> data) throws Exception{
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminGeneral()
                    .getAdminLeft()
                    .clickOnUserAndRolesLink()
                    .searchTheUser(data.get("SelectUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectUser"))
                    .adminResetPassword(data.get("ConformManualPawdReset"),
                            data.get("PasswordToRest"), data.get("ConfirmPasswordToRest"))
                    .getHeader()
                    .logout();
        }catch (Exception ex) {
            session.log_Error("TC25196_User_Able_to_ResetPassword_And_without_Selecting_ManualPassword_checkbox_Test Failed");
            throw new Exception("TC25196_User_Able_to_ResetPassword_And_without_Selecting_ManualPassword_checkbox_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}

