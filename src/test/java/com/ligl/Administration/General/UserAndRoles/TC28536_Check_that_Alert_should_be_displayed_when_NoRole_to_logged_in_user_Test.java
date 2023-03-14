package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC28536_Check_that_Alert_should_be_displayed_when_NoRole_to_logged_in_user_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC28536_Check_that_Alert_should_be_displayed_when_NoRole_to_logged_in_user_Test(Hashtable<String, String> data) throws Exception {
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
                    .checkTheAlertNoRoleAssign();
        } catch (Exception ex) {
            session.log_Error("TC28536_Check_that_Alert_should_be_displayed_when_NoRole_to_logged_in_user_Test Failed");
            throw new Exception("TC28536_Check_that_Alert_should_be_displayed_when_NoRole_to_logged_in_user_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
