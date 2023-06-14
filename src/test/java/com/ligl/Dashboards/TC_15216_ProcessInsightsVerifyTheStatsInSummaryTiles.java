package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_15216_ProcessInsightsVerifyTheStatsInSummaryTiles extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_15216_ProcessInsightsVerifyTheStatsInSummaryTiles(Hashtable<String,String> data) throws Exception {
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
                    .getHeader().navigateToDashboardPage().clickOnProcessInsightsTab()
                    .checkAndValidateTheCountOfTheCaseInsightsStats(data.get("Email"),data.get("Emp"),data.get("EMAIL"),data.get("EMP"), data.get("DataSource"),data.get("SourcePath"),data.get("DataHold"),data.get("CollectionStatus"), data.get("Pstatus"));


        }catch (Exception ex){
            session.log_Error("TC_15216_ProcessInsightsVerifyTheStatsInSummaryTiles Failed");
            throw new Exception("Exception in TC_15216_ProcessInsightsVerifyTheStatsInSummaryTiles", ex);
        }finally {
            session.end();
        }
    }
}