package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22059_Create_Ligl_User_with_out_Manual_Password_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC22059_Create_Ligl_User_with_out_Manual_Password_Test(Hashtable<String, String> data) throws Exception {
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
                    .clickOnAdminGeneral()
                    .getAdminLeft()
                    .clickOnUserAndRolesLink()
                    .clickOnAddUserButton()
                    .swithToLiglUser()
                    .creatingLiglUser(data.get("UserName"), data.get("Email"), data.get("FirstName"),
                            data.get("MiddleName"), data.get("LastName"), data.get("Role"), data.get("Status"),
                            data.get("PasswordConfirmation"),data.get("CreatePassword"), data.get("ConfirmPassword"),
                            data.get("SendPasswordInEmail"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC22059_Create_Ligl_User_with_out_Manual_Password_Test Failed");
            throw new Exception("TC22059_Create_Ligl_User_with_out_Manual_Password_Test Failed", ex);
        } finally {
            session.end();
        }

    }
}
