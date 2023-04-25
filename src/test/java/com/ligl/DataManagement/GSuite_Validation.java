package com.ligl.DataManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.GoogleVaultPage;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GSuite_Validation extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void GSuite_Validation(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    //.navigateSSOLoginPage()
                    //.SSOLogin(session.getRegressionData("Username"), session.getRegressionData("Password"),session.getRegressionData("EntitySelection"));
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                   /* .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToDSIPage()
                    .multipleCCDsSelect(data)
                    .selectAllCCDs()
                    .clickOnAutomateButton()*/
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(data.get("CollectionStatus"))
                    .getHeader().logout();
            ILiglPage page1=new GoogleVaultPage();
            page1.googleVaultLogin(session.getGlobalData("GoogleVaultURL"),session.getGlobalData("GVaultUserName"),session.getGlobalData("GVaultPassword"))
                    .goToMatters().searchMatter(data.get("MatterName"))
                    .goToExports(data.get("MatterName"))
                    .getAndValidateCCDStats();

        } catch (Exception ex) {
            session.log_Error("GSuite_Validation Failed");
            throw new Exception("GSuite_Validation Failed", ex);
        } finally {
            session.end();
        }
    }
}
