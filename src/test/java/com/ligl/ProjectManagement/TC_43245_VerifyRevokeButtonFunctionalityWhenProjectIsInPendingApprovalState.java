package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_43245_VerifyRevokeButtonFunctionalityWhenProjectIsInPendingApprovalState extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_43245_VerifyRevokeButtonFunctionalityWhenProjectIsInPendingApprovalState(Hashtable<String, String> data) throws Exception {

        try {

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"), data.get("SSOUsername"), data.get("SSOPassword"), data.get("EntitySelection"), data.get("Username"), data.get("Password"))
                    .createNewCase(data)
                    .getLeftMenu()
                    .goToSecurityPage()
                    .validateCaseNotinitiatedState()
                    .sendingCaseForSingleApproval(data.get("BatchName"), data.get("UserName"), data.get("TempName"))
                    .revokeCase()
                    .validateRevokeButtonFunctionality(data.get("ApproverName1"), data.get("ApprovalStatus"));

        } catch (Exception ex) {
            session.log_Error("TC_43245_VerifyRevokeButtonFunctionalityWhenProjectIsInPendingApprovalState Failed");
            throw new Exception("TC_43245_VerifyRevokeButtonFunctionalityWhenProjectIsInPendingApprovalState Failed", ex);
        } finally {
            session.end();
        }
    }
}
