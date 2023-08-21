package com.ligl.DashboardsNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class ProjectInsights_VerifyThatTheDashboardDisplaysAllTheProjectsIrrespectiveOfAccessForLoggedInUserWhenUserAccessCasesIsFalse extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description = "Dashboards")
    public void ProjectInsights_VerifyThatTheDashboardDisplaysAllTheProjectsIrrespectiveOfAccessForLoggedInUserWhenUserAccessCasesIsFalse(Hashtable<String,String> data) throws Exception {
         testCaseId="2453906";
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
                    .searchLastDateModifiedColumnAndValidateTheCountInDashBoardWhenUACIsFALSE(data.get("Comparison"), data.get("Date"),data.get("Month"), data.get("Year"),data.get("TITLE1"),data.get("SYear"), data.get("SMonth"),data.get("SDate"));


        }catch (Exception ex){
            session.log_Error("TC_52354_ProjectInsights_VerifyThatTheDashboardDisplaysAllTheProjectsIrrespectiveOfAccessForLoggedInUserWhenUserAccessCasesIsFalse Failed");
            throw new Exception("Exception in TC_52354_ProjectInsights_VerifyThatTheDashboardDisplaysAllTheProjectsIrrespectiveOfAccessForLoggedInUserWhenUserAccessCasesIsFalse", ex);
        }finally {
            session.end();
        }
    }
}