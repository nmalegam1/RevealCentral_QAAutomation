package com.ligl.Dashboards;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_15572_52354_VerifyThatTopStatsMatchWithGridStatsWhenUserAccessibleCasesConfigSetToFalse extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_15572_52354_VerifyThatTopStatsMatchWithGridStatsWhenUserAccessibleCasesConfigSetToFalse(Hashtable<String,String> data) throws Exception {
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
                    .validateUserAccessCasesCountWhenUACsetToFalse(data.get("Username1"),data.get("Password1"),data.get("EntitySelection"), data.get("TITLE1") );


        }catch (Exception ex){
            session.log_Error("TC_15572_52354_VerifyThatTopStatsMatchWithGridStatsWhenUserAccessibleCasesConfigSetToFalse Failed");
            throw new Exception("Exception in TC_15572_52354_VerifyThatTopStatsMatchWithGridStatsWhenUserAccessibleCasesConfigSetToFalse", ex);
        }finally {
            session.end();
        }
    }
}
