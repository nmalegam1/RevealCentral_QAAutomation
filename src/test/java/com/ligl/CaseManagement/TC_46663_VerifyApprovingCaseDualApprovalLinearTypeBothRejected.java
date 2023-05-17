package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_46663_VerifyApprovingCaseDualApprovalLinearTypeBothRejected extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_46663_VerifyApprovingCaseDualApprovalLinearTypeBothRejected(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
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
                    .sendingCaseForDualApprovalLinearType(data.get("Employee1"),data.get("GmailCheck"), data.get("GoogleDriveCheck"),data.get("BatchNAME"),data.get("EMAIL"), data.get("USER1"), data.get("USER2"),data.get("SubType"))
                    .getHeader().goToApprovalPage()
                    .rejectingTheCase(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage().validateCaseRejectedState()
                    .verifyApprovalHistoryStatus(data.get("AssignedUser1"), data.get("Status3"), data.get("AssignedUser2"), data.get("Status4") );


        } catch (Exception ex) {
            session.log_Error("TC_46663_VerifyApprovingCaseDualApprovalLinearTypeBothRejected Failed");
            throw new Exception("TC_46663_VerifyApprovingCaseDualApprovalLinearTypeBothRejected", ex);
        } finally {
            session.end();
        }
    }
}