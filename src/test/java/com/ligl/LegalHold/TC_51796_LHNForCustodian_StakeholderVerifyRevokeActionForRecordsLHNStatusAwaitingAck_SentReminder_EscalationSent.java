package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51796_LHNForCustodian_StakeholderVerifyRevokeActionForRecordsLHNStatusAwaitingAck_SentReminder_EscalationSent extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51796_LHNForCustodian_StakeholderVerifyRevokeActionForRecordsLHNStatusAwaitingAck_SentReminder_EscalationSent(Hashtable<String,String> data) throws Exception {
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
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .goToLegalHold(data.get("LHname"))
                    .searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .clickOnActionDropDownAndRun(data.get("CustAction"))
                    .refreshLHN()
                    .searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .verifyRecordStatusInLHN(data.get("CustStatus"))
                    .switchOnToTheStakeHolderTab()
                    .searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .clickOnActionDropDownAndRunInStakeHolder(data.get("CustAction"))
                    //.clickOnRefreshButtonStakeHolder()
                    //.searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .verifyRecordStatusInLHN(data.get("CustStatus"));
                    /*.refreshLHN()
                    .searchLHNThroughEmail(data.get("RemaindCustMail"))
                    .clickOnActionDropDownAndRun(data.get("CustAction"))
                    .refreshLHN()
                    .searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .verifyRecordStatusInLHN(data.get("CustStatus"))
                    .refreshLHN()
                    .searchLHNThroughEmail(data.get("NotInitiateCustMail"))
                    .clickOnActionDropDownAndRun(data.get("CustAction"))
                    .refreshLHN()
                    .searchLHNThroughEmail(data.get("AwaitingCustMail"))
                    .verifyRecordStatusInLHN(data.get("CustStatus"));*/
        } catch (Exception ex) {
            session.log_Error("TC_51796_LHNForCustodian_StakeholderVerifyRevokeActionForRecordsLHNStatusAwaitingAck_SentReminder_EscalationSent Failed");
            throw new Exception("TC_51796_LHNForCustodian_StakeholderVerifyRevokeActionForRecordsLHNStatusAwaitingAck_SentReminder_EscalationSent Failed", ex);
        } finally {
            session.end();
        }
    }
}




