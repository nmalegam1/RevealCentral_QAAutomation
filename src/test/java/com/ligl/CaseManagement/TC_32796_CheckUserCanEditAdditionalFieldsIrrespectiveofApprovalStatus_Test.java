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
 * Cases-Check whether user can edit Additional fields irrespective of Approval Status
 */
public class TC_32796_CheckUserCanEditAdditionalFieldsIrrespectiveofApprovalStatus_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_32796_CheckUserCanEditAdditionalFieldsIrrespectiveofApprovalStatus_Test(Hashtable<String,String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("ApprovedCaseName"))
                    .GoToCase(data.get("ApprovedCaseName"))
                    .editAdditionalFields(data.get("Cost centre"), data.get("Case Alias"),data.get("AddDP"))
                    .getHeader()
                    .switchCase()
                    .searchcase(data.get("PenAppCaseName"))
                    .GoToCase(data.get("PenAppCaseName"))
                    .editAdditionalFields(data.get("Cost centre"), data.get("Case Alias"),data.get("AddDP"))
                    .getHeader()
                    .switchCase()
                    .searchcase(data.get("NotIniCaseName"))
                    .GoToCase(data.get("NotIniCaseName"))
                    .editAdditionalFields(data.get("Cost centre"), data.get("Case Alias"),data.get("AddDP"));
        }catch (Exception ex){
            session.log_Error("TC_32796_CheckUserCanEditAdditionalFieldsIrrespectiveofApprovalStatus_Test Failed");
            throw new Exception("Exception in TC_32796_CheckUserCanEditAdditionalFieldsIrrespectiveofApprovalStatus_Test", ex);
        }finally {
            session.end();
        }
    }
}
