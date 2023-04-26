package com.ligl.DataManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GSuite_ValidateLockWithSingleLegalHoldWithoutFilters extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "DataManagement")
    public void GSuite_ValidateLockWithSingleLegalHoldWithoutFilters(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(session.getRegressionData("Username"), session.getRegressionData("Password"),session.getRegressionData("EntitySelection"))
                    /*.navigateSSOLoginPage()
                    .SSOLogin(session.getRegressionData("Username"), session.getRegressionData("Password"),session.getRegressionData("EntitySelection"))
                    */.searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .checkApprovalConfStatus(data.get("BchName"),data.get("Apptemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .getLeftMenu().goToLegalHoldPage()
                    .createLHWithOut_KW_DR(data.get("LHName"),data.get("CustodianTemplate"))
                    //If Legal hold Approval is True need to call below methods
                    /*.searchRequiredLegalHoldName(data.get("LHName"))
                    .sendLHNToApproval(data.get("LHName"),data.get("action"),data.get("emailTemp"),data.get("approver"))
                    .getHeader().goToApprovalPage()
                    .clickOnPendingLHNameInAppPage(data.get("CaseLHName"))
                    .clickOnApproveBtnInAppPage()
                    .getHeader().viewCase()*/
                    .getLeftMenu().goToDSIPage()
                    .addDataSourceRecordToDSIGridUptoCollection(data.get("CustFullName"),data.get("DataSource"),data.get("DHScope"))
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateGSuiteDST_LockWithSingleLegalHoldWithoutFilters(data.get("Status"));


        } catch (Exception ex) {
            session.log_Error("GSuite_ValidateLockWithSingleLegalHoldWithoutFilters Failed");
            throw new Exception("GSuite_ValidateLockWithSingleLegalHoldWithoutFilters Failed", ex);
        } finally {
            session.end();
        }
    }
}
