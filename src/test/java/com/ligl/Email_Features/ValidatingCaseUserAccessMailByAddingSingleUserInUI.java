package com.ligl.Email_Features;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.pages.SecurityPage;
import com.ligl.util.DataUtil;
import com.ligl.util.DatabaseUtil;
import com.ligl.util.DbUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ValidatingCaseUserAccessMailByAddingSingleUserInUI extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void ValidatingCaseUserAccessMailByAddingSingleUserInUI(Hashtable<String, String> data) throws Exception {

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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("entity"))
                    .createNewCase(data)
                    .getLeftMenu()
                    .goToSecurityPage()
                    .sendingCaseForSingleApproval(data.get("BatchName"),data.get("UserName"),data.get("EmailTemp"))
                    .getHeader()
                    .goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader()
                     .goToCasePage()
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToSecurityPage()
                  .DisableSuperUser()
                    .verifyProvidingCaseAccessToUsersInSecurityUsersDropdown(data.get("SSOUser"))
                    .fetchDataFromDb("CaseUserAccess",data);


        } catch (Exception ex) {
            session.log_Error("ValidatingCaseUserAccessMailByAddingSingleUserInUI Failed");
            throw new Exception("ValidatingCaseUserAccessMailByAddingSingleUserInUI Failed", ex);
        } finally {
            session.end();
        }
    }


}
