package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC21215_User_Able_to_click_ResetPassword_button_And_Reset_Password_Manually_for_Ligl_User_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC21215_User_Able_to_click_ResetPassword_button_And_Reset_Password_Manually_for_Ligl_User_Test(Hashtable<String, String> data) throws Exception{
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("Entity"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .searchTheUser(data.get("SelectUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectUser"))
                    .adminResetPassword(data.get("ConformManualPawdReset"),
                            data.get("PasswordToRest"), data.get("ConfirmPasswordToRest"))
                    .getHeader()
                    .logout();
        }catch (Exception ex) {
            session.log_Error("TC21215_User_Able_to_click_ResetPassword_button_And_Reset_Password_Manually_for_Ligl_User_Test Failed");
            throw new Exception("TC21215_User_Able_to_click_ResetPassword_button_And_Reset_Password_Manually_for_Ligl_User_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
