package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_20771_VerifyReleaseActionForLHNStatus extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_20771_VerifyReleaseActionForLHNStatus(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname1")).goToRequiredLegalHoldName(data.get("LHname1"))
                    .searchActionThroughEmail(data.get("Email1"))
                    .validateLHNStatus(data.get("LHNstatus1"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .selectTemplateAndClickOnSendBtn(data.get("Template"))
                    .clickOnRefreshButton()
                    .searchActionThroughEmail(data.get("Email2"))
                    .validateLHNStatus(data.get("LHNstatus2"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .selectTemplateAndClickOnSendBtn(data.get("Template"))
                    .clickOnRefreshButton()
                    .searchActionThroughEmail(data.get("Email3"))
                    .validateLHNStatus(data.get("LHNstatus3"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .selectTemplateAndClickOnSendBtn(data.get("Template"))

                    .switchOnToTheStakeHolderTab()

                    .searchActionThroughEmail(data.get("Email1"))
                    .validateLHNStatus(data.get("LHNstatus1"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action1"))
                    .clickOnRefreshButtonStakeHolder()
                    .searchActionThroughEmail(data.get("Email2"))
                    .validateLHNStatus(data.get("LHNstatus2"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action1"))
                    .clickOnRefreshButtonStakeHolder()
                    .searchActionThroughEmail(data.get("Email3"))
                    .validateLHNStatus(data.get("LHNstatus3"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action1"));



        } catch (Exception ex) {
            session.log_Error("TC_20771_VerifyReleaseActionForLHNStatus Failed");
            throw new Exception("TC_20771_VerifyReleaseActionForLHNStatus Failed", ex);
        } finally {
            session.end();
        }
    }
}
