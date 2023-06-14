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
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData",description="RequestTracker")
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader().goToGlobalRequestPage()
                    .searchForTheParticularTitleOfTheRequest(data.get("ReqTitle"))
                    .clickOnEditIconInTheGrid(data.get("ReqTitle"))
                    .validateStatusOfTheRequest(data.get("Status"))
                    .addMessageWhenReqIsInProgress(data.get("Message"))
                    .searchForTheParticularTitleOfTheRequest(data.get("ReqTitle"))
                    .moveToTheParticularColumn(data.get("ReqTitle"))
                    .validateStatusOfTheRequest(data.get("Message"));


        }catch (Exception ex){
            session.log_Error("TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress Failed");
            throw new Exception("Exception in TC_36700_CheckWhetherUserableToAddMessagesWhenRequestStatusIsInProgress", ex);
        }finally {
            session.end();
        }
    }
}