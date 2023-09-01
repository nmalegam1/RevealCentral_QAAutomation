package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_20764_20770_VerifySendAndStealthActionsOfLHN_WhenStatusIsNotInitiated extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_20764_20770_VerifySendAndStealthActionsOfLHN_WhenStatusIsNotInitiated(Hashtable<String, String> data) throws Exception {
        testCaseId="2454161,2454160";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }



            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname1"))
                    .goToRequiredLegalHoldName(data.get("LHname1"))
                    .searchActionThroughEmail(data.get("Email1"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .sendLHNToCustodian()
                    .validateLHStatus(data.get("Status1"))
                    .refreshLHN()
                    .searchActionThroughEmail(data.get("Email2"))
                    .clickOnActionDropDownAndRun(data.get("Action2"))
                    .sendStealthMode()
                    .validateLHStatus(data.get("Status2"))

                    .switchOnToTheStakeHolderTab()

                    .searchActionThroughEmail(data.get("Email1"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action1"))
                    .validateLHStatus(data.get("Status1"))
                    .clickOnRefreshButtonStakeHolder()
                    .searchActionThroughEmail(data.get("Email2"))
                    .clickOnActionDropDownAndRun(data.get("Action3"))
                    .clickOnRefreshButtonStakeHolder()
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action2"))
                    .validateLHStatus(data.get("Status2"));


        } catch (Exception ex) {
            session.log_Error("TC_20764_20770_VerifySendAndStealthActionsOfLHN_WhenStatusIsNotInitiated Failed");
            throw new Exception("TC_20764_20770_VerifySendAndStealthActionsOfLHN_WhenStatusIsNotInitiated Failed", ex);
        } finally {
            session.end();
        }
    }
}
