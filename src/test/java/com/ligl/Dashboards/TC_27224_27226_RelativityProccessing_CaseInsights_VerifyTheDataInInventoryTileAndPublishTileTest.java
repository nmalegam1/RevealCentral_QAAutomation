package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_27224_RelativityProccessing_CaseInsights_VerifyTheDataInInventoryTile extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_17477_ReviewInsightsVerifyTheStatsInSummaryTiles(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"),data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getHeader().navigateToDashboardPage().clickOnReviewInsightsTab()
                    .checkAndValidateTheCountOfTheProcessInsightsStats(data.get("EMAIL"));


        }catch (Exception ex){
            session.log_Error("TC_17477_ReviewInsightsVerifyTheStatsInSummaryTiles Failed");
            throw new Exception("Exception in TC_17477_ReviewInsightsVerifyTheStatsInSummaryTiles", ex);
        }finally {
            session.end();
        }
    }
}
