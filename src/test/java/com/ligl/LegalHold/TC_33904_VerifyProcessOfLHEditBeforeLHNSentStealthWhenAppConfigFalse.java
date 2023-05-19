package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_33904_VerifyProcessOfLHEditBeforeLHNSentStealthWhenAppConfigFalse extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_33904_VerifyProcessOfLHEditBeforeLHNSentStealthWhenAppConfigFalse(Hashtable<String, String> data) throws Exception {

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
                    .clickOnAddNewLegalHoldButton()
                    .createNewLegalHold(data.get("LHname"), data.get("CustodianNoticeTemplate"), data.get("CustodianQueTemplate"),data.get("StakeHolderNoticeTemplate"), data.get("StakeHolderQueTemplate") )
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .clickOnEditButtonInLHNGrid()
                    .clearActionInLegalHold()
                    .createNewLegalHold(data.get("LHname1"), data.get("CustodianNoticeTemplate1"), data.get("CustodianQueTemplate1"),data.get("StakeHolderNoticeTemplate1"), data.get("StakeHolderQueTemplate1") )
                    .goToRequiredLegalHoldName(data.get("LHname1"))
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRun(data.get("Action")).clickOnSendButton()
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname1"))
                    .clickOnEditButtonInLHNGrid().checkTheLHPopUpDetailsInDisabledCondition();



        } catch (Exception ex) {
            session.log_Error("TC_33904_VerifyProcessOfLHEditBeforeLHNSentStealthWhenAppConfigFalse Failed");
            throw new Exception("TC_33904_VerifyProcessOfLHEditBeforeLHNSentStealthWhenAppConfigFalse Failed", ex);
        } finally {
            session.end();
        }
    }
}