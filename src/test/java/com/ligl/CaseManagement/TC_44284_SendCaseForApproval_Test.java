package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

///Sending Case For Approval And Approving Case

public class TC_44284_SendCaseForApproval_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "CaseManagement")
    public void TC_44284_SendCaseForApproval_Test(Hashtable<String , String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage()
                    .sendCaseForApproval(data.get("BatchName"),data.get("AppTemp"),data.get("AppUserName"))
                    .approvalHistoryCheck(data.get("Username"),"Pending Approval")
                    .logout();

        }
        catch (Exception ex){
            session.log_Error("TC_44284_SendCaseForApproval_Test Failed");
            throw new Exception("TC_44284_SendCaseForApproval_Test is Failed" , ex);
        }
    }
}
