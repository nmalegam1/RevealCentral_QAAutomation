package com.ligl.RequestTracker;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51886_CheckWhetherRequestCreatorAbleToAddTheMessagesForNewStateRequest extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "RequestTracker")
    public void TC_51886_CheckWhetherRequestCreatorAbleToAddTheMessagesForNewStateRequest(Hashtable<String,String> data) throws Exception {
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
                    .getHeader().goToGlobalRequestPage().clickOnAddRequestButton()
                    .addAllDetailsInTheAddRequestPopUpByAssigningToRole(data.get("ReqType"), data.get("ReqTitle"), data.get("ChooseCase"), data.get("ChooseUser"), data.get("Priority"), data.get("CompleteDate"), data.get("AdditionalText") )
                    .validateCreatedRequestInTheGlobalRequestGrid(data.get("ReqTitle"))
                    .clickOnEditIconInTheGrid(data.get("ReqTitle"))
                    .sendAdditionalMessageWhenReqIsInNewStatus(data.get("Message"))
                    .moveToTheParticularColumn(data.get("ReqTitle")).validateStatusOfTheRequest(data.get("Message"));

        }catch (Exception ex){
            session.log_Error("TC_51886_CheckWhetherRequestCreatorAbleToAddTheMessagesForNewStateRequest Failed");
            throw new Exception("Exception in TC_51886_CheckWhetherRequestCreatorAbleToAddTheMessagesForNewStateRequest", ex);
        }finally {
            session.end();
        }
    }
}
