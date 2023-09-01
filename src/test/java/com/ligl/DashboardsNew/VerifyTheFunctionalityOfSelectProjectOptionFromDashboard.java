package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyTheFunctionalityOfSelectProjectOptionFromDashboard extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void VerifyTheFunctionalityOfSelectProjectOptionFromDashboard(Hashtable<String,String> data) throws Exception {
         testCaseId="2453891";
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
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .clickOnLegalHoldInsightsTab()
                    .getHeader().selectCase()
                    .searchcase(data.get("CaseName1")).GoToCase(data.get("CaseName1"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE2"))
                    .clickOnProcessInsightsTab()
                    .getHeader().switchCase()
                    .searchcase(data.get("CaseName2")).GoToCase(data.get("CaseName2"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE3"))
                    .clickOnReviewInsightsTab()
                    .getHeader().switchCase()
                    .searchcase(data.get("CaseName3")).GoToCase(data.get("CaseName3"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE4"))
                    .clickOnProductionInsightsTab()
                    .getHeader().switchCase()
                    .searchcase(data.get("CaseName1")).GoToCase(data.get("CaseName1"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE5"))
                    .clickOnGlobalInsightsTab()
                    .getHeader().switchCase()
                    .searchcase(data.get("CaseName2")).GoToCase(data.get("CaseName2"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE6"));


        }catch (Exception ex){
            session.log_Error("TC_27793_VerifyTheFunctionalityOfSelectProjectOptionFromDashboard Failed");
            throw new Exception("Exception in TC_27793_VerifyTheFunctionalityOfSelectProjectOptionFromDashboard", ex);
        }finally {
            session.end();
        }
    }
}

