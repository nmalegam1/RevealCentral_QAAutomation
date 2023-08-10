package com.ligl.SmokeSuiteSIT;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AdminLoginTest_001 extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "Smoke")
    public void AdminLoginTest_001(Hashtable<String,String> data) throws Exception {
        testCaseId="2452788";
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .validateAdminRole()
                    .getHeader()
                    .logout();


        }catch (Exception ex){
            session.log_Error("AdminLoginTest_001 Failed");
            throw new Exception("AdminLoginTest_001 Failed", ex);
        }finally {
            session.end();
        }
    }
}

