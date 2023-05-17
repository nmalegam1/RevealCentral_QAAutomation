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
                    .login(session.getRegressionData("Username"), session.getRegressionData("Password"),session.getRegressionData("EntitySelection"))
                    /*.navigateSSOLoginPage()
                    .SSOLogin(session.getRegressionData("Username"), session.getRegressionData("Password"),session.getRegressionData("EntitySelection"))
                    */.searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToDSIPage()
                    .addDataSourceRecordToDSIGrid(data.get("TC_01_CustFullName"),data.get("TC_01_DataSource"),data.get("DHScope"),data.get("DR1"),data.get("KW1"))
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteCollection(data.get("CollectionStatus"));
            ILiglPage page1=new GoogleVaultPage();
            page1.googleVaultLogin(session.getGlobalData("GoogleVaultURL"),session.getGlobalData("GVaultUserName"),session.getGlobalData("GVaultPassword"))
                    .goToMatters().searchMatter(session.getGlobalData("MatterName"))
                    .goToExports(session.getGlobalData("MatterRecord"));

        } catch (Exception ex) {
            session.log_Error("GSuite_Validation Failed");
            throw new Exception("GSuite_Validation Failed", ex);
        } finally {
            session.end();
        }
    }
}
