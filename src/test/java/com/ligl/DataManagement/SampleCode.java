package com.ligl.DataManagement;

        import com.ligl.base.TestBase;
        import com.ligl.base.pages.ILiglPage;
        import com.ligl.dataprovider.TestDataProvider;
        import com.ligl.pages.LaunchPage;
        import com.ligl.util.DataUtil;
        import org.testng.SkipException;
        import org.testng.annotations.Test;

        import java.util.Hashtable;

public class SampleCode extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "DataManagement")
    public void SampleCode(Hashtable<String, String> data) throws Exception {

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
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .multipleCustodianSelect(data)
                    .getLeftMenu().navigateToDataSourcesPage()
                    .multipleDataSourceSelect(data)
                    .getLeftMenu().goToSecurityPage()
                    .getLeftMenu().goToDSIPage()
                    .multipleCCDsSelect(data)
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(data.get("CollectionStatus"));



        } catch (Exception ex) {
            session.log_Error("AddOneOrMoreExistingProsecutors_Test Failed");
            throw new Exception("AddOneOrMoreExistingProsecutors_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
