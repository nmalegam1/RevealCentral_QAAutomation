package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_20764_20770_VerifySendStealthActionLHNStatusInNotInitiated extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_20764_20770_VerifySendStealthActionLHNStatusInNotInitiated(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verifying The Columns In The LHN Custodian Grid

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname1")).goToRequiredLegalHoldName(data.get("LHname1"))
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .validateRecordWhenLHNStatusIsInNotintiatedState(data.get("Status1"))
                    .clickOnActionDropDownAndRun(data.get("Action2"))
                    .validateRecordWhenLHNStatusIsInNotintiatedState(data.get("Status1"))
                    .switchOnToTheStakeHolderTab()
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action1"))
                    .validateRecordWhenLHNStatusIsInNotintiatedState(data.get("Status1"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("Action2"))
                    .validateRecordWhenLHNStatusIsInNotintiatedState(data.get("Status1"));


        } catch (Exception ex) {
            session.log_Error("TC_20764_20770_VerifySendStealthActionLHNStatusInNotInitiated Failed");
            throw new Exception("TC_20764_20770_VerifySendStealthActionLHNStatusInNotInitiated Failed", ex);
        } finally {
            session.end();
        }
    }
}
