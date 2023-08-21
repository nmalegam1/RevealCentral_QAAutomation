package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Relativity_ProcessInsights_CheckTheDataInSummaryTiles extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void Relativity_ProcessInsights_CheckTheDataInSummaryTiles(Hashtable<String,String> data) throws Exception {
         testCaseId="2453889";
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getHeader().navigateToDashboardPage()
                    .clickOnProcessInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .checkAndValidateTheCountOfTheProcessInsightsStats(data.get("Email"),data.get("Emp"),data.get("EMAIL"),data.get("EMP"), data.get("DataSource"),data.get("SourcePath"),data.get("DataHold"),data.get("CollectionStatus"));


        }catch (Exception ex){
            session.log_Error("TC_27238_Relativity_ProcessInsights_CheckTheDataInSummaryTiles Failed");
            throw new Exception("Exception in TC_27238_Relativity_ProcessInsights_CheckTheDataInSummaryTiles", ex);
        }finally {
            session.end();
        }
    }
}