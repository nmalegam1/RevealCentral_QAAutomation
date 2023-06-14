package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_52331_VerifyDataInAdditionalScopeApprovalGridColumns extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_52331_VerifyDataInAdditionalScopeApprovalGridColumns(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage()
                    .searchRequiredApprovalBatchName(data.get("AppBatchname"))
                    .verifyColumnsDatainAdditionalScopeApprovalGrid(data.get("ApprovalBatchNameExpected"),data.get("CustodiansCountExpected"),data.get("DatasourcesCountExpected"),data.get("KeywordsCountExpected"),data.get("DateRangesCountExpected"),data.get("ApprovalStatusColumnExpected"),data.get("ApprovalTypeExpected"),data.get("ApprovalUsersExpected"),data.get("ApprovedOrRejectedOnExpected"))
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC_52331_VerifyDataInAdditionalScopeApprovalGridColumns Failed");
            throw new Exception("TC_52331_VerifyDataInAdditionalScopeApprovalGridColumns Failed", ex);
        } finally {
            session.end();
        }
    }
}
