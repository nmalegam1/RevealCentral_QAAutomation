package com.ligl.RequestTrackerNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class GlobalLevel_VerifyUserIsAbleToCreateRequestByFillingOnlyMandatoryFields extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "RequestTracker")
    public void GlobalLevel_VerifyUserIsAbleToCreateRequestByFillingOnlyMandatoryFields(Hashtable<String,String> data) throws Exception {
         testCaseId="2453015";
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
                    .createRequestByFillingOnlyMandatoryFieldsInTheAddRequestPopUp(data.get("ReqType"), data.get("ReqTitle"), data.get("ChooseCase"))
                    .validateCreatedRequestInTheGlobalRequestGrid(data.get("ReqTitle"));


        }catch (Exception ex){
            session.log_Error("TC_61570_GlobalLevel_VerifyUserIsAbleToCreateRequestByFillingOnlyMandatoryFields Failed");
            throw new Exception("Exception in TC_61570_GlobalLevel_VerifyUserIsAbleToCreateRequestByFillingOnlyMandatoryFields", ex);
        }finally {
            session.end();
        }
    }
}