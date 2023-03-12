package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class SendLHNtoCustodianAndAcknowledge_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void SendLHNtoCustodianAndAcknowledge_Test(Hashtable<String,String> data) throws Exception {
        try{
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
                .login(data.get("UserName"), data.get("Password"),data.get("Entity"))
                .searchcase(data.get("CaseName"))
                .getLeftMenu().navigateToLegalHoldPage()
                .sendLHNToCustodian(data.get("CustodianName"));
        }catch (Exception ex) {
            session.log_Error("SendLHNtoCustodianAndAcknowledge_Test Failed");
            throw new Exception("SendLHNtoCustodianAndAcknowledge_Test is Failed", ex);
        }
    }
}