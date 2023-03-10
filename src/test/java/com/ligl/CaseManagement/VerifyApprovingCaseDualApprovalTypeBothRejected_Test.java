package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyApprovingCaseDualApprovalTypeBothRejected_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void VerifyApprovingCaseDualApprovalTypeBothRejected_Test(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verify The Case When Dual Approval Is Selected FIRST REJECTED SECOND APPROVED

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email1"))
                    .getLeftMenu()
                    .goToSecurityPage().validateCaseNotinitiatedState()
                    .sendingCaseForDualApproval(data.get("BatchNAME"), data.get("USER1"), data.get("USER2"), data.get("EMAIL"), data.get("Employee1"), data.get("SubType") )
                    .getHeader().goToApprovalPage().rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState()
                    .verifyApprovalHistoryStatus(data.get("AssignedUser1"), data.get("Status3"), data.get("AssignedUser2"), data.get("Status2") )
                    .getHeader().logout()
                    .login(data.get("Username1"), data.get("Password1"),data.get("EntitySelection")).getHeader().goToApprovalPage().rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser1"), data.get("Status3") )
                    .getHeader().logout().login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName")).getLeftMenu().goToSecurityPage()
                    .validateCaseRejectedState().verifyApprovalHistoryStatus(data.get("AssignedUser2"), data.get("Status3"), data.get("AssignedUser1"), data.get("Status3"));



        } catch (Exception ex) {
            session.log_Error("VerifyApprovingCaseDualApprovalTypeBothRejected_Test Failed");
            throw new Exception("VerifyApprovingCaseDualApprovalTypeBothRejected_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}