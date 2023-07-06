package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_52336_VerifyThatProjectAndScopeItemsCanBeSentForApprovalWhenProjectApprovalConfig_True extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_52336_VerifyThatProjectAndScopeItemsCanBeSentForApprovalWhenProjectApprovalConfig_True(Hashtable<String, String> data) throws Exception {

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
                    .addCustodianToCase(data.get("Email1"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addingDataSource(data.get("Datasource1"))
                    .clickOnSaveButton()
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .getLeftMenu()
                    .navigateToKeyWordsPage()
                    .addKeywordsByCustom(data.get("Keywords1"), data.get("Datasource1") )
                    .getLeftMenu()
                    .goToSecurityPage().validateCaseNotinitiatedState()
                    .projectAndScopeItemsSendingForApproval(data.get("EmployeeName"), data.get("DataSourceCheck"), data.get("DateRangeCheck"), data.get("KeyWordsCheck"), data.get("BatchName"), data.get("UserName"), data.get("EmailTemplate"))
                    .getHeader().goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .searchRequiredProjectBatch(data.get("CaseNameApprove"))
                    .validateProjectDetailsAreInApprovedStateInApprovalPage()
                    .validateProjectCustodiansAreInApprovedState()
                    .validateProjectDataSourcesAreInApprovedState()
                    .validateProjectDateRangessAreInApprovedState()
                    .validateProjectKeywordsAreInApprovedState()
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC_52336_VerifyThatProjectAndScopeItemsCanBeSentForApprovalWhenProjectApprovalConfig_True Failed");
            throw new Exception("TC_52336_VerifyThatProjectAndScopeItemsCanBeSentForApprovalWhenProjectApprovalConfig_True Failed", ex);
        } finally {
            session.end();
        }
    }
}
