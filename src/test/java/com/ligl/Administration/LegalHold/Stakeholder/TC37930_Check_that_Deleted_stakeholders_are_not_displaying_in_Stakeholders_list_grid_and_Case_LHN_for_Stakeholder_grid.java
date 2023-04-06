package com.ligl.Administration.LegalHold.Stakeholder;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC37930_Check_that_Deleted_stakeholders_are_not_displaying_in_Stakeholders_list_grid_and_Case_LHN_for_Stakeholder_grid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC37930_Check_that_Deleted_stakeholders_are_not_displaying_in_Stakeholders_list_grid_and_Case_LHN_for_Stakeholder_grid(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminLegalHold()
                    .getAdminLeft()
                    .clickOnStakeholderLink()
                    .searchTheStakeholder(data.get("StakeholderEmail"))
                    .checkStakeholderDisplayingInGrid(data.get("StakeholderEmail"))
                    .getHeader()
                    .logout()

                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LegalHoldName"))
                    .goToRequiredLegalHoldName(data.get("LegalHoldName"))
                    .switchOnToTheStakeHolderTab()
                    .checkDeletedStakeholderISDisplayingInLHStakeholderGrid(data.get("StakeholderEmail"))
                    .getHeader()
                    .logout();
        }catch (Exception ex){
            session.log_Error("TC37930_Check_that_Deleted_stakeholders_are_not_displaying_in_Stakeholders_list_grid_and_Case_LHN_for_Stakeholder_grid Failed");
            throw new Exception("TC37930_Check_that_Deleted_stakeholders_are_not_displaying_in_Stakeholders_list_grid_and_Case_LHN_for_Stakeholder_grid Failed", ex);
        }finally {
            session.end();
        }
    }
}
