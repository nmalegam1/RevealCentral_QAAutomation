package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CheckCaseFieldsEditableNonApproved_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void CheckCaseFieldsEditableNonApproved_Test(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .verifyingCaseFieldsAreEditable(data.get("CaseTypeDrpDwn"), data.get("CaseName1"),data.get("CaseSettingTemplateDrpDwn") )
                    .verifyingCaseFieldsAreEdited(data.get("CaseTypeDrpDwn"), data.get("CaseName1"),data.get("CaseSettingTemplateDrpDwn"));


        } catch (Exception ex) {
            session.log_Error("CheckCaseFieldsEditableNonApproved_Test Failed");
            throw new Exception("CheckCaseFieldsEditableNonApproved_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
