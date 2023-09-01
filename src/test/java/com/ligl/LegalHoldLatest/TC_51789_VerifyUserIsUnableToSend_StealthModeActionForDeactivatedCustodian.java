package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51789_VerifyUserIsUnableToSend_StealthModeActionForDeactivatedCustodian extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51789_VerifyUserIsUnableToSend_StealthModeActionForDeactivatedCustodian(Hashtable<String,String> data) throws Exception {
        testCaseId="2454786";
        try {
            session.log_Info(data.toString());

            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Launch = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHName"))
                    .goToLegalHold(data.get("LHName"))
                    .searchLHNThroughEmail(data.get("CustMail"))
                    .clickOnActionDropDownAndRun(data.get("Action"))
                    .checkUnableToSetStealthModeToDeactiveCust(data.get("CustMail"))
                    .verifyRecordStatusInLHNSH(data.get("CustStatus"));
        } catch (Exception ex) {
            session.log_Error("TC_51789_VerifyUserIsUnableToSend_StealthModeActionForDeactivatedCustodian Failed");
            throw new Exception("TC_51789_VerifyUserIsUnableToSend_StealthModeActionForDeactivatedCustodian Failed", ex);
        } finally {
            session.end();
        }
    }
}



