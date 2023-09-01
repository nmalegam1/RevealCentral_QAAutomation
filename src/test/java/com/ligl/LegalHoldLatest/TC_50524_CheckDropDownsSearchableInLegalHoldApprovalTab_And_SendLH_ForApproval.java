package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_50524_CheckDropDownsSearchableInLegalHoldApprovalTab_And_SendLH_ForApproval extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_50524_CheckDropDownsSearchableInLegalHoldApprovalTab_And_SendLH_ForApproval(Hashtable<String,String> data) throws Exception {
        testCaseId="2454288";
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
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .sendLHNToApproval(data.get("LHName"),data.get("DPAction"),data.get("EmailTemp"),data.get("Approver"));

        } catch (Exception ex) {
            session.log_Error("TC_50524_CheckDropDownsSearchableInLegalHoldApprovalTab_And_SendLH_ForApproval Failed");
            throw new Exception("TC_50524_CheckDropDownsSearchableInLegalHoldApprovalTab_And_SendLH_ForApproval Failed", ex);
        } finally {
            session.end();
        }
    }
}
