package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyApprovingCaseDualApprovalLinearTypeFirstOneApproved_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void VerifyApprovingCaseDualApprovalLinearTypeFirstOneApproved_Test(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verify The Case When Dual Approval Is Selected First One APPROVED Linear Type

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email1"), data.get("Employee1"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addDataSources()
                    .getLeftMenu()
                    .goToSecurityPage().validateCaseNotinitiatedState()
                    .sendingCaseForDualApprovalLinearType(data.get("Employee1"),data.get("GmailCheck"), data.get("GoogleDriveCheck"),data.get("BatchNAME"), data.get("USER1"), data.get("USER2"),data.get("SubType"),data.get("EMAIL") )
                    .getHeader().goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCasePendingForApprovalState()
                    .verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status2"), data.get("AssignedUser1"), data.get("Status1") )
                    .getHeader().logout()
                    .login(data.get("Username1"), data.get("Password1")).getHeader().goToApprovalPage().rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser2"), data.get("Status2") )
                    .getHeader().logout().login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName")).getLeftMenu().goToSecurityPage().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser2"), data.get("Status2"));



        } catch (Exception ex) {
            session.log_Error("VerifyApprovingCaseDualApprovalLinearTypeFirstOneApproved_Test Failed");
            throw new Exception("VerifyApprovingCaseDualApprovalLinearTypeFirstOneApproved_Test", ex);
        } finally {
            session.end();
        }
    }
}