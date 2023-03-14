package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC51900_Check_Duplicate_Validation_Message_is_Displaying_When_Ligl_User_Create_and_Edit_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC51900_Check_Duplicate_Validation_Message_is_Displaying_When_Ligl_User_Create_and_Edit_Test(Hashtable<String, String> data) throws Exception {
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
                    .duplicateValidationMessageForLiglUser()

                    .searchTheUser(data.get("SearchUserName"))
                    .scrollToRightToDoActionInUsers(data.get("SearchUserName"))
                    .editTheUser(data.get("UserName"), data.get("Email"),
                            data.get("FirstName"), data.get("MiddleName"), data.get("LastName"),
                            data.get("Role"), data.get("Status"), data.get("UserEditingConfirmation"))
                    .duplicateValidationMessageForLiglUser()

                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC51900_Check_Duplicate_Validation_Message_is_Displaying_When_Ligl_User_Create_and_Edit_Test Failed");
            throw new Exception("TC51900_Check_Duplicate_Validation_Message_is_Displaying_When_Ligl_User_Create_and_Edit_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}