package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_37153_152_151_VerifyCopyeesListBasedOnActionInLH extends TestBase
{

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_37153_152_151_VerifyCopyeesListBasedOnActionInLH(Hashtable<String, String> data) throws Exception
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
                    .searchRequiredLHNStatus(data.get("Status1"))
                    .clickOnLHCheckbox(data.get("Custodian1"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .validateSSCopyeesList()
                    .copyeeSScancelBtnClick()
                    .clickOnRefreshButton()
                    .searchRequiredLHNStatus(data.get("Status1"))
                    .clickOnLHCheckbox(data.get("Custodian2"))
                    .clickOnActionDropDownAndRun(data.get("Action2"))
                    .validateSSCopyeesList()
                    .copyeeSScancelBtnClick()
                    .clickOnRefreshButton()
                    .searchRequiredLHNStatus(data.get("Status3"))
                    .clickOnLHCheckbox(data.get("Custodian3"))
                    .clickOnActionDropDownAndRun(data.get("Action3"))
                    .validateRCopyeesList()
                    .copyeeReleaseCancelBtnClick()
                    .clickOnRefreshButton()
                    .searchRequiredLHNStatus(data.get("Status4"))
                    .clickOnLHCheckbox(data.get("Custodian4"))
                    .clickOnActionDropDownAndRun(data.get("Action3"))
                    .validateRCopyeesList()
                    .copyeeReleaseCancelBtnClick()
                    .clickOnRefreshButton()
                    .searchRequiredLHNStatus(data.get("Status5"))
                    .clickOnLHCheckbox(data.get("Custodian5"))
                    .clickOnActionDropDownAndRun(data.get("Action3"))
                    .validateRCopyeesList()
                    .copyeeReleaseCancelBtnClick()
                    .clickOnRefreshButton();
        }
        catch (Exception ex)
        {
            session.log_Error("TC_37153_152_151_VerifyCopyeesListBasedOnActionInLH");
            throw new Exception("TC_37153_152_151_VerifyCopyeesListBasedOnActionInLH Failed", ex);
        }
        finally
        {
            session.end();
        }
    }
}