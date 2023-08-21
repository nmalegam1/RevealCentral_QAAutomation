package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ReviewInsights_VerifyTheClearAllFunctionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void TC_17475_ReviewInsights_VerifyTheClearAllFunctionality(Hashtable<String,String> data) throws Exception {
         testCaseId="2453871";
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
                    .clickOnReviewInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE2"));

        }catch (Exception ex){
            session.log_Error("TC_17475_ReviewInsights_VerifyTheClearAllFunctionality Failed");
            throw new Exception("Exception in TC_17475_ReviewInsights_VerifyTheClearAllFunctionality", ex);
        }finally {
            session.end();
        }
    }
}