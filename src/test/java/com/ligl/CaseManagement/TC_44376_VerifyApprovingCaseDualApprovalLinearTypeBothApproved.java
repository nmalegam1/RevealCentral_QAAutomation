package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_44376_VerifyApprovingCaseDualApprovalLinearTypeBothApproved extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_44376_VerifyApprovingCaseDualApprovalLinearTypeBothApproved(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verify The Case When Dual Approval Is Selected BOTH APPROVED Linear Type

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
                    .addingDataSource(data.get("Datasource2"))
                    .clickOnSaveButton()
                    .getLeftMenu()
                    .goToSecurityPage().validateCaseNotinitiatedState()
                    .sendingCaseForDualApprovalLinearType(data.get("Employee1"),data.get("GmailCheck"), data.get("GoogleDriveCheck"),data.get("BatchNAME"),data.get("EMAIL"), data.get("USER1"), data.get("USER2"),data.get("SubType") )
                    .getHeader().goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCasePendingForApprovalState()
                    .verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status2"), data.get("AssignedUser1"), data.get("Status1") )
                    .getHeader().logout()
                    .login(data.get("Username1"), data.get("Password1"),data.get("EntitySelection")).getHeader().goToApprovalPage().approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().verifyingApproveStatus().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status1"), data.get("AssignedUser2"), data.get("Status2") )
                    .getHeader().logout().login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName")).getLeftMenu().goToSecurityPage().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status1"), data.get("AssignedUser2"), data.get("Status2"))
                    .logout();



        } catch (Exception ex) {
            session.log_Error("TC_44376_VerifyApprovingCaseDualApprovalLinearTypeBothApproved Failed");
            throw new Exception("TC_44376_VerifyApprovingCaseDualApprovalLinearTypeBothApproved Failed", ex);
        } finally {
            session.end();
        }
    }
}
