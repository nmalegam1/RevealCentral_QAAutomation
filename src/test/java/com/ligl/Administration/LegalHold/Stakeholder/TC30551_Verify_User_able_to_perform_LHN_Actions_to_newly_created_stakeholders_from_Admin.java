package com.ligl.Administration.LegalHold.Stakeholder;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC30551_Verify_User_able_to_perform_LHN_Actions_to_newly_created_stakeholders_from_Admin extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC30551_Verify_User_able_to_perform_LHN_Actions_to_newly_created_stakeholders_from_Admin(Hashtable<String, String> data) throws Exception {
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LegalHoldName"))
                    .goToRequiredLegalHoldName(data.get("LegalHoldName"))
                    .switchOnToTheStakeHolderTab()
                    .searchActionThroughEmail(data.get("StakeholderEmail"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action"))
                    .getHeader()
                    .logout();
        }catch (Exception ex){
            session.log_Error("TC30551_Verify_User_able_to_perform_LHN_Actions_to_newly_created_stakeholders_from_Admin Failed");
            throw new Exception("TC30551_Verify_User_able_to_perform_LHN_Actions_to_newly_created_stakeholders_from_Admin FAiled", ex);
        }finally {
            session.end();
        }
    }
}
