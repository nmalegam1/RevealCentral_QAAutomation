package com.ligl.DataManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Replace_Config_ForSingleCCD_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "DataManagement")
    public void Replace_Config_ForSingleCCD_Test(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    /*.navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))*/
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BchName"),data.get("Apptemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .createLHWith_KW_DR(data.get("LHName"),data.get("CustodianTemplate"),data.get("startDate"),data.get("endDate"),data.get("keyword"))
                    .legalHoldApprovalIrrespectiveOfApprovalConfig(data.get("LHName"),data.get("LHAction"),data.get("EmailTemp"),data.get("ApproverUN"),data.get("CaseLHN"))
                    .getLeftMenu().goToDSIPage()
                    .multipleCCDsSelect(data)
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .goToDMLHScope()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(data.get("Status"))
                    .getLeftMenu()
                    .goToPreservation()
                    .goToPreservationLHScope()
                    .searchCCDWithCustNameAndDSName(data.get("CustFullName"),data.get("DataSource"))
                    .checkResultsCount()
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .editLH_DR_KW(data.get("LHName"),data.get("NewStartDate"),data.get("NewEndDate"),data.get("NewKeyword"))
                    .getLeftMenu().goToPreservation()
                    .goToPreservationLHScope()
                    .checkingSingleCCDRecordIsReplacedWithLatestFilters(data.get("CustFullName"),data.get("DataSource"),data.get("Status"),data.get("LockNotInitiateStatus"),data.get("ExpectedLHLDR"),data.get("ExpectedLHLKW"));

        } catch (Exception ex) {
            session.log_Error("Replace_Config_ForSingleCCD_Test Failed");
            throw new Exception("Replace_Config_ForSingleCCD_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
