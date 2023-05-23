package com.ligl.SmokeSuiteRelativity;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Case_Create_ApproveFor_OnPremDST extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Smoke")
    public void Case_Create_ApproveFor_OnPremDST(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Initiate Auto Process UpTo Collection

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                   /* .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))*/
                    .createNewCase(data)
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addOnpremDataSource(data.get("DataSource"))
                    .getLeftMenu()
                    .goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BatchName"),data.get("EmailTemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .logout();

        } catch (Exception ex) {
            session.log_Error("Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTestNuix Failed");
            throw new Exception("Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTestNuix Failed", ex);
        } finally {
            session.end();
        }
    }
}
