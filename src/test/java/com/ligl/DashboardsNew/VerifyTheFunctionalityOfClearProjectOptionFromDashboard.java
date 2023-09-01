package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyTheFunctionalityOfClearProjectOptionFromDashboard extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void VerifyTheFunctionalityOfClearProjectOptionFromDashboard(Hashtable<String,String> data) throws Exception {
         testCaseId="2453900";
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
                    .getHeader().clearCaseFunctionality().validateTheSelectCaseNameInHeader();

        }catch (Exception ex){
            session.log_Error("TC_28570_VerifyTheFunctionalityOfClearProjectOptionFromDashboard Failed");
            throw new Exception("Exception in TC_28570_VerifyTheFunctionalityOfClearProjectOptionFromDashboard", ex);
        }finally {
            session.end();
        }
    }
}

