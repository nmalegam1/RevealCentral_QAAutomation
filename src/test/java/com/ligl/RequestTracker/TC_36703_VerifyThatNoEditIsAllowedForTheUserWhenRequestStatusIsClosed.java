package com.ligl.RequestTracker;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_36703_VerifyThatNoEditIsAllowedForTheUserWhenRequestStatusIsClosed extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "RequestTracker")
    public void TC_36703_VerifyThatNoEditIsAllowedForTheUserWhenRequestStatusIsClosed(Hashtable<String,String> data) throws Exception {
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
                    .searchForTheParticularTitleOfTheRequest(data.get("ReqTitle"))
                    .moveToTheParticularColumn(data.get("ReqTitle"))
                    .clickOnViewIconInTheGrid()
                    .validateStatusOfTheRequest(data.get("Status"))
                    .validateMessageBoxIsInDisableMode();


        }catch (Exception ex){
            session.log_Error("TC_36703_VerifyThatNoEditIsAllowedForTheUserWhenRequestStatusIsClosed Failed");
            throw new Exception("Exception in TC_36703_VerifyThatNoEditIsAllowedForTheUserWhenRequestStatusIsClosed", ex);
        }finally {
            session.end();
        }
    }
}