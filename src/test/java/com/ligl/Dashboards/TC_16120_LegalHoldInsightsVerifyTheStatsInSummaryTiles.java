package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_16120_LegalHoldInsightsVerifyTheStatsInSummaryTiles extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_16120_LegalHoldInsightsVerifyTheStatsInSummaryTiles(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getHeader().navigateToDashboardPage().clickOnLegalHoldInsightsTab()
                    .checkAndValidateTheCountOfTheLegalHoldInsightsStats(data.get("Email"),data.get("Emp"),data.get("EMAIL"),data.get("EMP"), data.get("DataSource"),data.get("SourcePath"),data.get("DataHold"),data.get("CollectionStatus"), data.get("LHname"), data.get("Action"));


        }catch (Exception ex){
            session.log_Error("TC_16120_LegalHoldInsightsVerifyTheStatsInSummaryTiles Failed");
            throw new Exception("Exception in TC_16120_LegalHoldInsightsVerifyTheStatsInSummaryTiles", ex);
        }finally {
            session.end();
        }
    }
}