package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Dual Approval-Revoke-Check that Revoke functionality will apply on both Approver Users irrespective of Approval Status
 */
public class TC_44366_DualApproval_Revoke_Functionality extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "CaseManagement")
    public void TC_44366_DualApproval_Revoke_Functionality(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToSecurityPage()
                    .revokeCase()
                    .approvalHistoryCheck(data.get("Username1"),"Not Initiated")
                    .getHeader().logout()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username1"), data.get("Password1"),data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage()
                    .approvalHistoryCheck(data.get("Username1"),"Not Initiated");
        }catch (Exception ex){
            session.log_Error("TC_44366_DualApproval_Revoke_Functionality Failed");
            throw new Exception("Exception in TC_44366_DualApproval_Revoke_Functionality", ex);
        }finally {
            session.end();
        }
    }
}