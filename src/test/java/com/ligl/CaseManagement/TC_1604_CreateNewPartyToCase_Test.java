package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_1604_CreateNewPartyToCase_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_1604_CreateNewPartyToCase_Test(Hashtable<String , String> data) throws Exception {
        try{
            session.log_Info(data.get(toString()));
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName"),data.get("PartyType"),data.get("Description"));
        }catch (Exception ex){
            session.log_Error("TC_1604_CreateNewPartyToCase_Test Failed");
            throw new Exception("TC_1604_CreateNewPartyToCase_Test failed",ex);
        }
        finally{
            session.end();
        }
    }
}
