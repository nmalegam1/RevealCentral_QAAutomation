package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ProductionInsights_VerifyTheClearAllFunctionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void ProductionInsights_VerifyTheClearAllFunctionality(Hashtable<String,String> data) throws Exception {
         testCaseId="2453883";
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
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .clickOnProductionInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE2"))
                    .validateClearFilterFunctionalityInProductionInsights();

        }catch (Exception ex){
            session.log_Error("TC_25255_ProductionInsights_VerifyTheClearAllFunctionality Failed");
            throw new Exception("Exception in TC_25255_ProductionInsights_VerifyTheClearAllFunctionality", ex);
        }finally {
            session.end();
        }
    }
}