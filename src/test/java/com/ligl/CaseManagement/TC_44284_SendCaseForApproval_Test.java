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
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
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
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage()
                    .sendCaseForApproval(data.get("BatchName"),data.get("AppTemp"),data.get("AppUserName"))
                    .getHeader().goToApprovalPage()
                    .selectRecordInApprovalRequestsGrid(data.get("BatchName"))
                    .approveCase(data.get("CaseBatchName"));

        }
        catch (Exception ex){
            session.log_Error("TC_44284_SendCaseForApproval_Test Failed");
            throw new Exception("TC_44284_SendCaseForApproval_Test is Failed" , ex);
        }
    }
}
