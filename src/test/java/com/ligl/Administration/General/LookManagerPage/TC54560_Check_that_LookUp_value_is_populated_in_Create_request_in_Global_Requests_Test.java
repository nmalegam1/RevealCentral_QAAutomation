package com.ligl.Administration.General.LookManagerPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC54560_Check_that_LookUp_value_is_populated_in_Create_request_in_Global_Requests_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC54560_Check_that_LookUp_value_is_populated_in_Create_request_in_Global_Requests_Test(Hashtable<String, String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testing
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToGlobalRequestPage()
                    .checkNewlyCreatedLookupPopulatedInRequestTypeDropDown(data.get("RequestType"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC54560_Check_that_LookUp_value_is_populated_in_Create_request_in_Global_Requests_Test Failed");
            throw new Exception("TC54560_Check_that_LookUp_value_is_populated_in_Create_request_in_Global_Requests_Test Failed", ex);
        }
    }

}
