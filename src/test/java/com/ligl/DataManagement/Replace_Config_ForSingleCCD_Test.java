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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BchName"),data.get("PJApptemp"),data.get("ApproverUN"),data.get("CaseNameApprove"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .createLHWith_KW_DR(data.get("LHName"),data.get("CustTemp"),data.get("StartDate"),data.get("EndDate"),data.get("Keyword"))
                    .legalHoldApprovalIrrespectiveOfApprovalConfig(data.get("LHName"),data.get("LHAction"),data.get("EmailTemp"),data.get("ApproverUN"),data.get("CaseLHN"))
                    .getLeftMenu().goToDSIPage()
                    .multipleCCDsSelect(data)
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .goToDMLHScope()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(data.get("LockCompletedStatus"))
                    .getLeftMenu()
                    .goToPreservation()
                    .goToPreservationLHScope()
                    .searchCCDWithCustNameAndDSName(data.get("GMail_Cust_FullName"),data.get("GMail_DataSource"))
                    .checkResultsCount()
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .editLH_DR_KW(data.get("LHName"),data.get("NewStartDate"),data.get("NewEndDate"),data.get("NewKeyword"))
                    .getLeftMenu().goToPreservation()
                    .goToPreservationLHScope()
                    .checkingSingleCCDRecordIsReplacedWithLatestFilters(data.get("GMail_Cust_FullName"),data.get("GMail_DataSource"),data.get("LockCompletedStatus"),data.get("LockNotInitiateStatus"),data.get("LatestLHLDR"),data.get("LatestLHLKW"));

        } catch (Exception ex) {
            session.log_Error("Replace_Config_ForSingleCCD_Test Failed");
            throw new Exception("Replace_Config_ForSingleCCD_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
