package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue(Hashtable<String, String> data) throws Exception {
        testCaseId="2454171";
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
                    .getLeftMenu().navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .enterNameOfTheLH(data.get("LHname"))
                    .enterCustodianNoticeTemplate(data.get("CUSTNOTICETEMPLATE"))
                    .clickOnSaveBtn()
                    .sendLHNToApproval(data.get("LHname"), data.get("Action"),data.get("EmailTemplate"), data.get("ApproverName") )
                    .getHeader().goToApprovalPage().approvingCaseSingleApprover(data.get("BatchName"));



        } catch (Exception ex) {
            session.log_Error("TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue Failed");
            throw new Exception("TC_33850_VerifyLHApprovalProcessWhenApprovalConfigTrue Failed", ex);
        } finally {
            session.end();
        }
    }
}
