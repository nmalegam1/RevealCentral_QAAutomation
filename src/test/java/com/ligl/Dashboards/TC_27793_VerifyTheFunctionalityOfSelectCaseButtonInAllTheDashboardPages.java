package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_27793_VerifyTheFunctionalityOfSelectCaseButtonInAllTheDashboardPages extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_27793_VerifyTheFunctionalityOfSelectCaseButtonInAllTheDashboardPages(Hashtable<String,String> data) throws Exception {
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
            session.log_Error("TC_27793_VerifyTheFunctionalityOfSelectCaseButtonInAllTheDashboardPages Failed");
            throw new Exception("Exception in TC_27793_VerifyTheFunctionalityOfSelectCaseButtonInAllTheDashboardPages", ex);
        }finally {
            session.end();
        }
    }
}
