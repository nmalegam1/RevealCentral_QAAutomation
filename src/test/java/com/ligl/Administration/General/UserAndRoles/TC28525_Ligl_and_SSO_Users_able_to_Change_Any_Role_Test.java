package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC28525_Ligl_and_SSO_Users_able_to_Change_Any_Role_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC28525_Ligl_and_SSO_Users_able_to_Change_Any_Role_Test(Hashtable<String, String> data) throws Exception {
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
                    .navigateToUserAndRolesPage()
                    .searchTheUser(data.get("SelectLiglUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectLiglUser"))
                    .changeRole(data.get("SelectLiglRole"))
                    .getHeader()
                    .logout()
                    //SSO
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .searchTheUser(data.get("SelectSSOUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectSSOUser"))
                    .changeSSORole(data.get("SelectSSORole"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC28525_Ligl_and_SSO_Users_able_to_Change_Any_Role_Test Failed");
            throw new Exception("TC28525_Ligl_and_SSO_Users_able_to_Change_Any_Role_Test Failed", ex);
        } finally {
            session.end();
        }


    }

}

