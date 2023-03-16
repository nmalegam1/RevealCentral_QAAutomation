package com.ligl.RequestTracker;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .getHeader().goToGlobalRequestPage()
                    .validateCreatedRequestInTheGlobalRequestGrid(data.get("ReqTitle"))
                    .clickOnEditIconInTheGrid();


        }catch (Exception ex){
            session.log_Error("TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress Failed");
            throw new Exception("Exception in TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress", ex);
        }finally {
            session.end();
        }
    }
}