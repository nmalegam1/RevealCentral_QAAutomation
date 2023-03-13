package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_35031_35058_VerifyApprovingCaseDualApprovalEitherTypeBothRejected extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_35031_35058_VerifyApprovingCaseDualApprovalEitherTypeBothRejected(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verify The Case When Dual Approval Is Selected BOTH APPROVED Either Type

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email1"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addDataSources(data.get("DataSource1"))
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .validatingDateRanges()
                    .getLeftMenu()
                    .navigateToKeyWordsPage()
                    .addKeywordsByCustom(data.get("Keywords1"), data.get("DataSource1") )
                    .addKeywordsByCustom(data.get("Keywords1"), data.get("DataSource1"))
                    .validatingKeywords()
                    .getLeftMenu()
                    .goToCaseManagement().getLeftMenu()
                    .goToSecurityPage().validateCaseNotinitiatedState()
                    .sendingCaseForDualApprovalEitherType(data.get("Employee1"),data.get("GmailCheck"), data.get("GoogleDriveCheck"),data.get("DateRange1"),data.get("DateRange2"),data.get("Keyword1"),data.get("Keyword2"),data.get("BatchNAME"),data.get("EMAIL"), data.get("USER1"), data.get("USER2"),data.get("SubType") )
                    .getHeader().goToApprovalPage()
                    .rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCasePendingForApprovalState()
                    .verifyApprovalHistoryStatus(data.get("AssignedUser1"), data.get("Status3"), data.get("AssignedUser2"), data.get("Status2") )
                    .getHeader().logout()
                    .login(data.get("Username1"), data.get("Password1"),data.get("Entity")).getHeader().goToApprovalPage().rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser1"), data.get("Status3") )
                    .getHeader().logout().login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName")).getLeftMenu().goToSecurityPage().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser1"), data.get("Status3"));



        } catch (Exception ex) {
            session.log_Error("TC_35031_35058_VerifyApprovingCaseDualApprovalEitherTypeBothRejected Failed");
            throw new Exception("TC_35031_35058_VerifyApprovingCaseDualApprovalEitherTypeBothRejected", ex);
        } finally {
            session.end();
        }
    }
}