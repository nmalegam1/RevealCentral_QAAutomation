package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_37050_StakeholderCreationBySelectingCategoryFromLegalHold extends TestBase
{

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_37050_StakeholderCreationBySelectingCategoryFromLegalHold(Hashtable<String, String> data) throws Exception
    {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Check That Any Added Custodian Should Not Be Displayed In LHN Or In DSI Page Untill Approved

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .clickOnApprovedLH(data.get("LHname"))
                    .switchOnToTheStakeHolderTab()
                    .clickOnCreateStakeHolderBtnInLH(data.get("FirstName"),data.get("LastName"),data.get("StakeDepartment"),data.get("StakeEmailID"),data.get("StakeCategoryValue"))
                    .verifyStakeholderEmailIsDisplayed(data.get("StakeEmailID"));


        }catch (Exception ex){
            session.log_Error("TC_37050_StakeholderCreationBySelectingCategoryFromLegalHold");
            throw new Exception("TC_37050_StakeholderCreationBySelectingCategoryFromLegalHold Failed", ex);
        }finally {
            session.end();
        }
    }
}