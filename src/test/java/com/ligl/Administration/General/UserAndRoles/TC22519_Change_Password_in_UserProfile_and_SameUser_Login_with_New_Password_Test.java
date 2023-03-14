package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22519_Change_Password_in_UserProfile_and_SameUser_Login_with_New_Password_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC22519_Change_Password_in_UserProfile_and_SameUser_Login_with_New_Password_Test(Hashtable<String, String> data) throws Exception {
        try{
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
                        .login(data.get("Username"), data.get("Password"), data.get("null"))
                        .getHeader()
                        .clickChangePassword()
                        .changePasswordInUserProfile(data.get("OldPassword"), data.get("NewPassword"), data.get("ConfirmPassword"))
                        .login(data.get("Username"), data.get("LoginWithNewPassword"), data.get("null"))
                        .getHeader()
                        .logout();
        }catch (Exception ex) {
            session.log_Error("TC22519_Change_Password_in_UserProfile_and_SameUser_Login_with_New_Password_Test Failed");
            throw new Exception("TC22519_Change_Password_in_UserProfile_and_SameUser_Login_with_New_Password_Test Failed", ex);
        }finally {
            session.end();
        }

    }
}
