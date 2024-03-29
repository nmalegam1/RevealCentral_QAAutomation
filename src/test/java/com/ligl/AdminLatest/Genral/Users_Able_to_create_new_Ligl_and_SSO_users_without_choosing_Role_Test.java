package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Users_Able_to_create_new_Ligl_and_SSO_users_without_choosing_Role_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void Users_Able_to_create_new_Ligl_and_SSO_users_without_choosing_Role_Test(Hashtable<String, String> data) throws Exception {
        testCaseId="2454631";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .clickOnAddUserButton()
                    .swithToLiglUser()
                    .creatingLiglUser(data.get("UserName"), data.get("Email"), data.get("FirstName"),
                            data.get("MiddleName"), data.get("LastName"), data.get("NoRole"), data.get("Status"),
                            data.get("PasswordConfirmation"),data.get("CreatePassword"), data.get("ConfirmPassword"),
                            data.get("SendPasswordInEmail"))

                    .clickOnAddUserButton()
                    .creatingSSOUser(data.get("Email"), data.get("FirstName"),
                            data.get("MiddleName"), data.get("LastName"), data.get("NoRole"), data.get("Status"));
        }catch (Exception ex) {
            session.log_Error("TC28540_Users_Able_to_create_new_Ligl_and_SSO_users_without_choosing_Role_Test Failed");
            throw new Exception("TC28540_Users_Able_to_create_new_Ligl_and_SSO_users_without_choosing_Role_Test Failed", ex);
        } finally {
            session.end();
        }

    }
}
