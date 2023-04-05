package com.ligl.RequestTracker;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_36651_VerifyWhetherTopLevelStatsAreUpdatedToTheCurrentStatusLikeNewProgressClose extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_36651_VerifyWhetherTopLevelStatsAreUpdatedToTheCurrentStatusLikeNewProgressClose(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .getHeader().goToGlobalRequestPage()
                    .checkAndValidateTheCountOfRequestUnderNewInProgressCloseStats(data.get("ReqType"), data.get("ReqTitle"), data.get("ChooseCase"), data.get("ChooseUser"), data.get("Priority"), data.get("CompleteDate"), data.get("AdditionalText"), data.get("Status1"), data.get("Status2") );


        }catch (Exception ex){
            session.log_Error("TC_36651_VerifyWhetherTopLevelStatsAreUpdatedToTheCurrentStatusLikeNewProgressClose Failed");
            throw new Exception("Exception in TC_36651_VerifyWhetherTopLevelStatsAreUpdatedToTheCurrentStatusLikeNewProgressClose", ex);
        }finally {
            session.end();
        }
    }
}
