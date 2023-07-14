package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_52352_ProjectInsights_LegalHoldInsights_ProcessInsights_ReviewInsights_ProductionInsights_VerifyThePrintButtonFunctionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void TC_52352_ProjectInsights_LegalHoldInsights_ProcessInsights_ReviewInsights_ProductionInsights_VerifyThePrintButtonFunctionality(Hashtable<String,String> data) throws Exception {
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
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .clickOnPrintButton()
                    .validateThePrintButtonFunctionality()
                    .clickOnLegalHoldInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE2"))
                    .clickOnPrintButton()
                    .validateThePrintButtonFunctionality()
                    .clickOnProcessInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE3"))
                    .clickOnPrintButton()
                    .validateThePrintButtonFunctionality()
                    .clickOnReviewInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE4"))
                    .clickOnPrintButton()
                    .validateThePrintButtonFunctionality()
                    .clickOnProductionInsightsTab()
                    .validateDashBoardPageURL(data.get("TITLE5"))
                    .clickOnPrintButton()
                    .validateThePrintButtonFunctionality();



        }catch (Exception ex){
            session.log_Error("TC_52352_ProjectInsights_LegalHoldInsights_ProcessInsights_ReviewInsights_ProductionInsights_VerifyThePrintButtonFunctionality Failed");
            throw new Exception("Exception in TC_52352_ProjectInsights_LegalHoldInsights_ProcessInsights_ReviewInsights_ProductionInsights_VerifyThePrintButtonFunctionality", ex);
        }finally {
            session.end();
        }
    }
}

