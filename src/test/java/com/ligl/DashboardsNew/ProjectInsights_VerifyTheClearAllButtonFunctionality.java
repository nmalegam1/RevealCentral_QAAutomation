package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ProjectInsights_VerifyTheClearAllButtonFunctionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void ProjectInsights_VerifyTheClearAllButtonFunctionality(Hashtable<String,String> data) throws Exception {
         testCaseId="2453907";
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
                    .validateDashBoardPageURL(data.get("TITLE1"))
                    .checkAndValidateTheFunctionalityOfFromToDateAndApplyButton(data.get("SYear"), data.get("SMonth"),data.get("SDate"),data.get("EYear"), data.get("EMonth"),data.get("EDate"))
                    .clickOnClearAllButton();


        }catch (Exception ex){
            session.log_Error("TC_52358_ProjectInsights_VerifyTheClearAllButtonFunctionality Failed");
            throw new Exception("Exception in TC_52358_ProjectInsights_VerifyTheClearAllButtonFunctionality", ex);
        }finally {
            session.end();
        }
    }
}
