package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_28570_VerifyTheNavigationProcessOfClickingClearCaseOptionInDashboards  extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_28570_VerifyTheNavigationProcessOfClickingClearCaseOptionInDashboards(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"),data.get("Password"),data.get("Entity"))
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .clickOnLegalHoldInsightsTab()
                    .getHeader().selectCase()
                    .searchcase(data.get("CaseName1")).GoToCase(data.get("CaseName1"))
                    .validateTheNavigateToDashBoardPageURL(data.get("TITLE2"))
                    .getHeader().clearCaseFunctionality().validateTheSelectCaseNameInHeader();

        }catch (Exception ex){
            session.log_Error("TC_28570_VerifyTheNavigationProcessOfClickingClearCaseOptionInDashboards Failed");
            throw new Exception("Exception in TC_28570_VerifyTheNavigationProcessOfClickingClearCaseOptionInDashboards", ex);
        }finally {
            session.end();
        }
    }
}

