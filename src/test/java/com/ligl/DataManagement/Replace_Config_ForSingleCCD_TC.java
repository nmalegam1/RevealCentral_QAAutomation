package com.ligl.DataManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Replace_Config_ForSingleCCD_TC extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "DataManagement")
    public void Replace_Config_ForSingleCCD_TC(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
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
                    .createLHWith_KW_DR(data.get("LHName"),data.get("CustodianTemplate"),data.get("startDate"),data.get("endDate"),data.get("keyword"))
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
                    .goToDMLHScope()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(data.get("Status"))
                    .getLeftMenu().goToPreservation()
                    .goToPreservationLHScope()
                    .searchCCDWithCustNameAndDSName(data.get("CustFullName"),data.get("DataSource"))
                    .checkResultsCount()
                    .getLeftMenu().goToLegalHoldPage()
                    .editLH_DR_KW(data.get("LHName"),data.get("NewStartDate"),data.get("NewEndDate"),data.get("NewKeyword"))
                    .getLeftMenu().goToPreservation()
                    .goToPreservationLHScope()
                    .checkingSingleCCDRecordIsReplacedWithLatestFilters(data.get("CustFullName"),data.get("DataSource"),data.get("Status"),data.get("LockNotInitiateStatus"),data.get("ExpectedLHLDR"),data.get("ExpectedLHLKW"));

        } catch (Exception ex) {
            session.log_Error("Replace_Config_ForSingleCCD_TC Failed");
            throw new Exception("Replace_Config_ForSingleCCD_TC Failed", ex);
        } finally {
            session.end();
        }
    }
}
