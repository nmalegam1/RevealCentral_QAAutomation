package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * 27274-Case Security-Check whether Approval History is updating based on User's actions
 */
public class TC_27274_CheckApproval_History_Security_BasedOnUsersActions_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_27274_CheckApproval_History_Security_BasedOnUsersActions_Test(Hashtable<String, String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToSecurityPage()
                    .sendCaseForApproval(data.get("BatchName"), data.get("AppTemp"), data.get("AppUserName"))
                    .approvalHistoryCheck(data.get("AppUserName"), data.get("PA-ApprvlStatus"))
                    .getHeader()
                    .goToApprovalPage()
                    .selectRecordInApprovalRequestsGrid(data.get("ApprovalRecord"))
                    .approveCase(data.get("RejRecord"))
                    .getHeader()
                    .viewCase()
                    .getLeftMenu()
                    .goToSecurityPage()
                    .approvalHistoryCheck(data.get("AppUserName"), data.get("Rej-ApprvlStatus"))
                    .sendRejectedCaseApproval()
                    .approvalHistoryCheck(data.get("AppUserName"), data.get("PA-ApprvlStatus"))
                    .getHeader()
                    .goToApprovalPage()
                    .selectRecordInApprovalRequestsGrid(data.get("ApprovalRecord"))
                    .approveCase(data.get("ApprvRecord"))
                    .getHeader()
                    .viewCase()
                    .getLeftMenu()
                    .goToSecurityPage()
                    .approvalHistoryCheck(data.get("AppUserName"), data.get("Aprv-ApprvlStatus"));
        } catch (Exception ex) {
            session.log_Error("TC_27274_CheckApproval_History_Security_BasedOnUsersActions_Test Failed");
            throw new Exception("Exception in TC_27274_CheckApproval_History_Security_BasedOnUsersActions_Test", ex);
        } finally {
            session.end();
        }
    }
}