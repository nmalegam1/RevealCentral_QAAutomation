package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22050_User_is_able_to_Accept_EULA_page_for_first_time_Login_when_CS_config_is_False_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC22050_User_is_able_to_Accept_EULA_page_for_first_time_Login_when_CS_config_is_False_Test(Hashtable<String, String> data) throws Exception {
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
                    .newLogin(data.get("Username"), data.get("Password"))
                    .acceptEula()
                    .changePasswordAfterUserLogin(data.get("ChangePasswordConfirmation"), data.get("OldPassword"), data.get("NewPassword"),
                            data.get("ConfirmPassword"))
                    .login(data.get("Username"), data.get("NewPassword"), data.get("Null"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC22050_User_is_able_to_Accept_EULA_page_for_first_time_Login_when_CS_config_is_False_Test Failed");
            throw new Exception("TC22050_User_is_able_to_Accept_EULA_page_for_first_time_Login_when_CS_config_is_False_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}