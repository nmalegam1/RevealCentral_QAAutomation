package com.ligl.Administration.General.UserAndRoles;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22868_User_Should_not_be_able_to_Login_with_Old_Password_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "Administration")
    public void TC22868_User_Should_not_be_able_to_Login_with_Old_Password_Test(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginPageValidation(data.get("Username"), data.get("OldPassword"))
                    .oldPasswordValidation();
        }catch (Exception ex){
            session.log_Error("TC22868_User_Should_not_be_able_to_Login_with_Old_Password_Test Failed");
            throw new Exception("TC22868_User_Should_not_be_able_to_Login_with_Old_Password_Test Failed", ex);
        }finally {
            session.end();
        }
    }
}
