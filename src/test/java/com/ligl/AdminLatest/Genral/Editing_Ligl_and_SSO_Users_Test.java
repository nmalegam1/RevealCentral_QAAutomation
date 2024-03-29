package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Editing_Ligl_and_SSO_Users_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void Editing_Ligl_and_SSO_Users_Test(Hashtable<String, String> data) throws Exception {
        try {
            testCaseId="2453821";
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
                    .searchTheUser(data.get("SelectUser"))
                    .scrollToRightToDoActionInUsers(data.get("SelectUser"))
                    .editTheUser(data.get("EditUserName"), data.get("EditEmail"),
                            data.get("EditFirstName"), data.get("EditMiddleName"), data.get("EditLastName"),
                            data.get("EditRole"), data.get("EditStatus"), data.get("UserEditingConfirmation"))
                    .refreshUserAndRolesPage()
                    .searchTheUser(data.get("SelectUsersEmail"))
                    .scrollToRightToDoActionInUsers(data.get("SelectUsersEmail"))
                    .editSSOUser(data.get("EditEmail"), data.get("EditFirstName"),
                            data.get("EditMiddleName"), data.get("EditLastName"), data.get("EditRole"), data.get("EditStatus"))
                    .getHeader()
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC12104_Editing_Ligl_and_SSO_Users_Test Failed");
            throw new Exception("TC12104_Editing_Ligl_and_SSO_Users_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
