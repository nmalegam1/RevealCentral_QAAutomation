package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_24316_VerifyClickFunctionalityOfEscalationButton extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_24316_VerifyClickFunctionalityOfEscalationButton(Hashtable<String, String> data) throws Exception {

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
                    .clickOnEscalationButtonInEscalationConfigTab(data.get("LHname"), data.get("CustodianNoticeTemplate"),data.get("StakeHolderNoticeTemplate"));


        } catch (Exception ex) {
            session.log_Error("TC_24316_VerifyClickFunctionalityOfEscalationButton Failed");
            throw new Exception("TC_24316_VerifyClickFunctionalityOfEscalationButton Failed", ex);
        } finally {
            session.end();
        }
    }
}