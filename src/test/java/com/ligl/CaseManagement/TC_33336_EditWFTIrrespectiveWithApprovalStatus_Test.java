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
                    .login(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("ApprovedCaseName"))
                    .GoToCase(data.get("ApprovedCaseName"))
                    .editWFT(data.get("WFT"))
                    .getHeader().switchCase()
                    .searchcase(data.get("PenAppCaseName"))
                    .GoToCase(data.get("PenAppCaseName"))
                    .editWFT(data.get("WFT"))
                    .getHeader().switchCase()
                    .searchcase(data.get("NotIniCaseName"))
                    .GoToCase(data.get("NotIniCaseName"))
                    .editWFT(data.get("WFT"))
                    .getHeader().switchCase()
                    .searchcase(data.get("RejectedCaseName"))
                    .GoToCase(data.get("RejectedCaseName"))
                    .editWFT(data.get("WFT"))
                    .getHeader().switchCase();
        } catch (Exception ex) {
            session.log_Error("TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test Failed");
            throw new Exception("TC_33336_EditWFTIrrespectiveWithApprovalStatus_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}