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

public class TC_01_GMailDataValidation extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_01_GMailDataValidation(Hashtable<String, String> data) throws Exception {

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
                    */.searchcase(session.getRegressionData("TC_01_CaseName")).GoToCase(session.getRegressionData("TC_01_CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(session.getRegressionData("TC_01_Custodian"))
                    .getLeftMenu().navigateToDataSourcesPage()
                    .addDataSource(session.getRegressionData("TC_01_DataSource"))
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(session.getRegressionData("TC_01_StartDate"),session.getRegressionData("TC_01_EndDate"),session.getRegressionData("TC_01_DateDescription"))
                    .getLeftMenu().navigateToKeyWordsPage()
                    .addKeywordsByBasic(session.getRegressionData("TC_01_KeyWords"))
                    .getLeftMenu().goToDSIPage()
                    .addDataSourceRecordToDSIGrid(session.getRegressionData("TC_01_CustFullName"),session.getRegressionData("TC_01_DataSource"),session.getRegressionData("DHScope"),session.getRegressionData("DR1"),session.getRegressionData("KW1"))
                    .selectAllCCDs()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteCollection(session.getRegressionData("CollectionStatus"));
            ILiglPage page1=new GoogleVaultPage();
            page1.googleVaultLogin(session.getGlobalData("GoogleVaultURL"),session.getGlobalData("GVaultUserName"),session.getGlobalData("GVaultPassword"))
                    .goToMatters().searchMatter(session.getGlobalData("MatterName"))
                    .goToExports(session.getGlobalData("MatterRecord"));

        } catch (Exception ex) {
            session.log_Error("TC_01_GMailDataValidation Failed");
            throw new Exception("TC_01_GMailDataValidation Failed", ex);
        } finally {
            session.end();
        }
    }
}
