package com.ligl.Administration.LegalHold.Stakeholder;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC30545_Verify_Processes_of_Stakeholder_Creation extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC30545_Verify_Processes_of_Stakeholder_Creation(Hashtable<String, String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testing
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToStakeholderPage()
                    .clickOnAddStakeholderButton()
                    .createStakeholder(data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Email"),
                            data.get("Department"), data.get("Category"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC30545_Verify_Processes_of_Stakeholder_Creation Failed");
            throw new Exception("TC30545_Verify_Processes_of_Stakeholder_Creation Failed", ex);
        }finally {
            session.end();
        }
    }

}
