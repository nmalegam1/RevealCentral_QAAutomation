package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;


public class TC51897_Unavailability_of_ChangePassword_Logged_SSO_User_Profile_icon_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC51897_Unavailability_of_ChangePassword_Logged_SSO_User_Profile_icon_Test(Hashtable<String, String> data) throws Exception {
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
                    .unavailabilityOfChangePasswordOption()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC51897_Unavailability_of_ChangePassword_Logged_SSO_User_Profile_icon_Test Failed");
            throw new Exception("TC51897_Unavailability_of_ChangePassword_Logged_SSO_User_Profile_icon_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
