package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC28539_Logged_in_user_is_displaying_with_Assigned_role_after_changing_the_role_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC28539_Logged_in_user_is_displaying_with_Assigned_role_after_changing_the_role_Test(Hashtable<String, String> data) throws Exception{
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
                    .login(data.get("Username"), data.get("Password"), data.get("Null"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .searchTheUser(data.get("SelectUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectUser"))
                    .changeRole(data.get("RoleToChange"))
                    .getHeader()
                    .logout()
                    .login(data.get("SelectUser"),data.get("SelectUserpassword"), data.get("Null"))
                    .getHeader()
                    .loggedInUserRoleAfterRoleChanged(data.get("ExpectedRoleAfterChange"))
                    .getHeader()
                    .logout();
                    //SSO
                    /*.navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"))
                    .getHeader()
                    .loggedInUserRoleAfterRoleChanged(data.get("ExpectedRoleAfterChange"))
                    .getHeader()
                    .logout()
                    .logout();*/

        }catch (Exception ex) {
            session.log_Error("TC28539_Logged_in_user_is_Displaying_with_Assigned_role_after_changing_the_role_Test Failed");
            throw new Exception("TC28539_Logged_in_user_is_Displaying_with_Assigned_role_after_changing_the_role_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
