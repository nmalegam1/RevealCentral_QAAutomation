package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51785_VerifyRevokeFunctionalityForPendingApprovalLegalHolds extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51785_VerifyRevokeFunctionalityForPendingApprovalLegalHolds(Hashtable<String,String> data) throws Exception {
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHName"))
                    .selectLHN(data.get("LHName"))
                    .clickOnActionDropDownAndRun(data.get("Action"))
                    .verifyRecordStatusOfLHN(data.get("LHNStatus"));
        } catch (Exception ex) {
            session.log_Error("TC_51785_VerifyRevokeFunctionalityForPendingApprovalLegalHolds Failed");
            throw new Exception("TC_51785_VerifyRevokeFunctionalityForPendingApprovalLegalHolds Failed", ex);
        } finally {
            session.end();
        }
    }
}


