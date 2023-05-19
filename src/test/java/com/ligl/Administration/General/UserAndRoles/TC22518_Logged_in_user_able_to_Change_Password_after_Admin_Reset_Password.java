package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22518_Logged_in_user_able_to_Change_Password_after_Admin_Reset_Password extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC22518_Logged_in_user_able_to_Change_Password_after_Admin_Reset_Password(Hashtable<String, String> data) throws Exception{
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
                    .newLogin(data.get("Username"), data.get("PasswordRestByAdmin"))
                    .changePasswordAfterUserLogin(data.get("ChangePasswordConfirmation"),
                            data.get("OldPassword"), data.get("NewPassword"),data.get("ConfirmPassword"));
        }catch (Exception ex) {
            session.log_Error("TC22518_Logged_in_user_able_to_Change_Password_after_Admin_Reset_Password Failed");
            throw new Exception("TC22518_Logged_in_user_able_to_Change_Password_after_Admin_Reset_Password Failed", ex);
        } finally {
            session.end();
        }

    }

}
