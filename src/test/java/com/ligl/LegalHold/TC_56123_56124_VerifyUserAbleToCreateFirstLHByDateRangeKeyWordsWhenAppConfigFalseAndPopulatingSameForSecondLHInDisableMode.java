package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56123_56124_VerifyUserAbleToCreateFirstLHByDateRangeKeyWordsWhenAppConfigFalseAndPopulatingSameForSecondLHInDisableMode extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_56123_56124_VerifyUserAbleToCreateFirstLHByDateRangeKeyWordsWhenAppConfigFalseAndPopulatingSameForSecondLHInDisableMode(Hashtable<String, String> data) throws Exception {

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
                    .createNewLegalHoldByDateRangeKeyWords(data.get("LHname"), data.get("CustodianNoticeTemplate"),data.get("StakeHolderNoticeTemplate"), data.get("StartDATE"), data.get("EndDATE"), data.get("NumberOFDAYS"), data.get("KEYwords"))
                    .searchRequiredLegalHoldName(data.get("LHname")).validateLHNStatus(data.get("ApprovalStatus"))
                    .clickOnAddNewLegalHoldButton().enterNameOfTheLH(data.get("LHname1"))
                    .clickOnNextBtn1().enterCustodianNoticeTemplate(data.get("CustodianNoticeTemplate"), data.get("CustodianQueTemplate") )
                    .clickOnNextBtn2().clickOnStakeHolderNoticeTemplate(data.get("StakeHolderNoticeTemplate"), data.get("StakeHolderQueTemplate"))
                    .clickOnNextBtn3().validateTheDRandKWInDisableMode().clickOnNextBtn5().clickOnNextBtn6().clickOnSaveBtn();




        } catch (Exception ex) {
            session.log_Error("TC_56123_56124_VerifyUserAbleToCreateFirstLHByDateRangeKeyWordsWhenAppConfigFalseAndPopulatingSameForSecondLHInDisableMode Failed");
            throw new Exception("TC_56123_56124_VerifyUserAbleToCreateFirstLHByDateRangeKeyWordsWhenAppConfigFalseAndPopulatingSameForSecondLHInDisabledMode Failed", ex);
        } finally {
            session.end();
        }
    }
}
