package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_28296_GlobalInsights_VerifyTheClearAllFunctionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void TC_28296_GlobalInsights_VerifyTheClearAllFunctionality(Hashtable<String,String> data) throws Exception {
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
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .clickOnGlobalInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE2"))
                    .validateClearFilterFunctionalityInGlobalInsights(data.get("SelectYear"), data.get("SelectValue") );

        }catch (Exception ex){
            session.log_Error("TC_28296_GlobalInsights_VerifyTheClearAllFunctionality Failed");
            throw new Exception("Exception in TC_28296_GlobalInsights_VerifyTheClearAllFunctionality", ex);
        }finally {
            session.end();
        }
    }
}
