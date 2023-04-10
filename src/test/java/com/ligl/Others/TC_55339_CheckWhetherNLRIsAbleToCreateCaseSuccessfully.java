package com.ligl.Others;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;
public class TC_55339_CheckWhetherNLRIsAbleToCreateCaseSuccessfully extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_55339_CheckWhetherNLRIsAbleToCreateCaseSuccessfully(Hashtable<String,String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .createNewCase(data)
                    .getHeader()
                    .goToCasePage()
                    .searchcase(data.get("CaseName"))
                    .logout();
        }catch (Exception ex){
            session.log_Error("CheckWhetherNLRIsAbleToCreateCaseSuccessfully Failed");
            throw new Exception("CheckWhetherNLRIsAbleToCreateCaseSuccessfully Failed", ex);
        }finally {
            session.end();
        }
    }
}
