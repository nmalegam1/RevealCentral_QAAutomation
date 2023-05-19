package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;
///Creating New Case And Validating Case Created Or Not

public class TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test(Hashtable<String, String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .editWFT(data.get("WFT"))
                    .getLeftMenu().goToSecurityPage()
                    .sendCaseForApproval(data.get("BatchNameRej"),data.get("AppTemp"),data.get("AppUserName"))
                    .getLeftMenu().goToCaseManagement()
                    .editWFT(data.get("WFT"))
                    .getHeader().rejectingTheCase(data.get("CaseNameApproverej"))
                    .getHeader().viewCase()
                    .getLeftMenu().goToCaseManagement()
                    .editWFT(data.get("WFT"))
                    .getLeftMenu().goToSecurityPage()
                    .sendCaseForApproval(data.get("BatchName"),data.get("AppTemp"),data.get("AppUserName"))
                    .getHeader().approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader().viewCase()
                    .getLeftMenu().goToCaseManagement()
                    .editWFT(data.get("WFT"));
        } catch (Exception ex) {
            session.log_Error("TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test Failed");
            throw new Exception("TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}