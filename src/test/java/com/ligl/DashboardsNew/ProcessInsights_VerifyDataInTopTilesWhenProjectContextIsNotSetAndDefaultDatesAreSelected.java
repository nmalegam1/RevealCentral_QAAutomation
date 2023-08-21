package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ProcessInsights_VerifyDataInTopTilesWhenProjectContextIsNotSetAndDefaultDatesAreSelected extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "Dashboards")
    public void ProcessInsights_VerifyDataInTopTilesWhenProjectContextIsNotSetAndDefaultDatesAreSelected(Hashtable<String, String> data) throws Exception {
         testCaseId="2453911";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref = new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .getHeader().navigateToDashboardPage().clickOnProcessInsightsTab()
                    .verifyTheDataInProcessInsightsWhenProjectContextIsNotSetWhenDefaultDatesAreSelected(data, data.get("Emp"));


        } catch (Exception ex) {
            session.log_Error("TC_15216_ProcessInsights_VerifyDataInTopTilesWhenProjectContextIsNotSetAndDefaultDatesAreSelected Failed");
            throw new Exception("Exception in TC_15216_ProcessInsights_VerifyDataInTopTilesWhenProjectContextIsNotSetAndDefaultDatesAreSelected", ex);
        } finally {
            session.end();
        }
    }

}