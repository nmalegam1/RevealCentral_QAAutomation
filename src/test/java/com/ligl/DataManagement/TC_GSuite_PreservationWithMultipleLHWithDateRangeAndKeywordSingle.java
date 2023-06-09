package com.ligl.DataManagement;

        import com.ligl.base.TestBase;
        import com.ligl.base.pages.ILiglPage;
        import com.ligl.dataprovider.TestDataProvider;
        import com.ligl.pages.GoogleVaultPage;
        import com.ligl.pages.LaunchPage;
        import com.ligl.util.DataUtil;
        import org.testng.SkipException;
        import org.testng.annotations.Test;

        import java.util.Hashtable;

public class TC_GSuite_PreservationWithMultipleLHWithDateRangeAndKeywordSingle extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData" ,description = "DataManagement")
    public void TC_GSuite_PreservationWithMultipleLHWithDateRangeAndKeywordSingle(Hashtable<String, String> data) throws Exception {

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
                    //.login(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BchName"),data.get("Apptemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .createLHWith_KW_DR(data.get("LHName"), data.get("CustTemp"), data.get("StartDate"), data.get("EndDate"),data.get("Keywords"))
                    .legalHoldApprovalIrrespectiveOfApprovalConfig(data.get("LHName"),data.get("LHAction"),data.get("EmailTemp"),data.get("ApproverUN"),data.get("CaseLHN"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .enterNameOfTheLH(data.get("LHName2"))
                    .enterCustodianNoticeTemplate(data.get("CustTemp"))
                    .lhnSave()
                    .getLeftMenu().goToDSIPage()
                    .multipleCCDsSelect(data)
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .goToDMLHScope()
                    .validateAndWaitForRecordsToCompleteLock(data.get("LockStatus"));
        } catch (Exception ex) {
            session.log_Error("TC_GSuite_PreservationWithMultipleLHWithDateRangeAndKeywordSingle Failed");
            throw new Exception("TC_GSuite_PreservationWithMultipleLHWithDateRangeAndKeywordSingle Failed", ex);
        } finally {
            session.end();
        }
    }
}



