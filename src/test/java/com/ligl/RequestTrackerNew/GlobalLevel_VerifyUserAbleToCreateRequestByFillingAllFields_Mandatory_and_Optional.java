package com.ligl.RequestTrackerNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GlobalLevel_VerifyUserAbleToCreateRequestByFillingAllFields_Mandatory_and_Optional extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "RequestTracker")
    public void GlobalLevel_VerifyUserAbleToCreateRequestByFillingAllFields_Mandatory_and_Optional(Hashtable<String,String> data) throws Exception {
         testCaseId="2453033";
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
                    .getHeader().goToGlobalRequestPage().clickOnAddRequestButton()
                    .addAllDetailsInTheAddRequestPopUp(data.get("ReqType"), data.get("ReqTitle"), data.get("ChooseCase"), data.get("ChooseUser"), data.get("Priority"), data.get("CompleteDate"), data.get("AdditionalText") )
                    .validateCreatedRequestInTheGlobalRequestGrid(data.get("ReqTitle"));


        }catch (Exception ex){
            session.log_Error("TC_36481_GlobalLevel_VerifyUserAbleToCreateRequestByFillingAllFields_Mandatory_and_Optional Failed");
            throw new Exception("Exception in TC_36481_GlobalLevel_VerifyUserAbleToCreateRequestByFillingAllFields_Mandatory_and_Optional", ex);
        }finally {
            session.end();
        }
    }
}

