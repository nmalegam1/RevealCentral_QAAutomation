package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_35057_VerifyFunctionalityOfCreatingKeywords extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_35057_VerifyFunctionalityOfCreatingKeywords(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Employee1"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addDataSources(data.get("DataSource1"))
                    .getLeftMenu().navigateToKeyWordsPage()
                    .addKeywordsByBasic(data.get("Keywords1"))
                    .addKeywordsByBasic(data.get("Keywords1"))
                    .validatingKeywordsByKeywordType()
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC_35057_VerifyFunctionalityOfCreatingKeywords Failed");
            throw new Exception("TC_35057_VerifyFunctionalityOfCreatingKeywords Failed", ex);
        } finally {
            session.end();
        }
    }
}


