package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseUtil;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC37985_Creating_SSOUser_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC37985_Creating_SSOUser_Test(Hashtable<String, String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToUserAndRolesPage()
                    .clickOnAddUserButton()
                    //.creatingSSOUser(session.getRegressionData("TC37985_SSOEmail"), data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Role"), data.get("Status"))
                    .creatingSSOUser(session.getRegressionData("TC37985_SSOEmail"), session.getRegressionData("TC37985_FirstName"), data.get("MiddleName"), session.getRegressionData("TC37985_LastName"), data.get("Role"), data.get("Status"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC37985_Creating_SSOUser_Test Failed");
            throw new Exception("TC37985_Creating_SSOUser_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
