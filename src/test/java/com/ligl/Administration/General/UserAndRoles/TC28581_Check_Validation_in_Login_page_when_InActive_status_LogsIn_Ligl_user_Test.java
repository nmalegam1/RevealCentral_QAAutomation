package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC28581_Check_Validation_in_Login_page_when_InActive_status_LogsIn_Ligl_user_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC28581_Check_Validation_in_Login_page_when_InActive_status_LogsIn_Ligl_user_Test(Hashtable<String, String> data) throws Exception{
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
                    .loginPageValidation(data.get("Username"), data.get("Password"))
                    .verifyInActiveUserLoginValidation();
                    //.navigateSSOLoginPage()
                    //.SSOLoginValidation("ssivaraju@ligl.io", "Sai.1995")
                    //.verifyInActiveSSOUserLoginValidation();

        }catch (Exception ex) {
            session.log_Error("TC28581_Check_Validation_in_Login_page_when_InActive_status_LogsIn_Ligl_user_Test Failed");
            throw new Exception("TC28581_Check_Validation_in_Login_page_when_InActive_status_LogsIn_Ligl_user_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}

