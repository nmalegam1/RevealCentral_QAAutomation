package com.ligl.Administration.LegalHold.Stakeholder;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC37922_Verify_functionality_of_delete_button_in_the_Stakeholder_grid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC37922_Verify_functionality_of_delete_button_in_the_Stakeholder_grid(Hashtable<String, String> data) throws Exception{
        try {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminLegalHold()
                    .getAdminLeft()
                    .clikcOnStakeholderLink()
                    .searchTheStakeholder(data.get("StakeholderEmail"))
                    .scrollToRightToDoAction(data.get("StakeholderEmail"))
                    .deleteTheExitingStakeholder()
                    .getHeader()
                    .logout();
        }catch (Exception ex){
            session.log_Error("TC37922_the_functionality_of_delete_button_in_the_Stakeholder_grid Failed");
            throw new Exception("TC37922_Verify_functionality_of_delete_button_in_the_Stakeholder_grid Failed", ex);
        }finally {
            session.end();
        }
    }
}
