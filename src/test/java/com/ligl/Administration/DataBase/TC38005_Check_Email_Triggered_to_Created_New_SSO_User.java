package com.ligl.Administration.DataBase;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseValidations;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC38005_Check_Email_Triggered_to_Created_New_SSO_User extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "DataBase")
    public void TC38005_Check_Email_Triggered_to_Created_New_SSO_User(Hashtable<String, String> data) throws Exception {
        DataBaseValidations dataBase = new DataBaseValidations();
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), session.getGlobalData("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .getFieldsDataFromSSOUserPopUp(data)
                    .getHeader()
                    .logout();
            dataBase.checkEmailTriggeredToNewSSOUser();
        } catch (Exception ex) {
            session.log_Error("TC38005_Check_Email_Triggered_to_Created_New_SSO_User Failed");
            throw new Exception("TC38005_Check_Email_Triggered_to_Created_New_SSO_User Failed", ex);
        } finally {
            dataBase.closeTheDBConnection();
            session.end();
        }
    }
}
