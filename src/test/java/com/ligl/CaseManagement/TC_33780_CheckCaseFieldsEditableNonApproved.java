package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_33780_CheckCaseFieldsEditableNonApproved extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_33780_CheckCaseFieldsEditableNonApproved(Hashtable<String, String> data) throws Exception {

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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .verifyingCaseFieldsAreEditable(data.get("CaseTypeDrpDwn"), data.get("CaseName1"), data.get("CaseSettingTemplateDrpDwn"))
                    .verifyingCaseFieldsAreEdited(data.get("CaseTypeDrpDwn"), data.get("CaseName1"), data.get("CaseSettingTemplateDrpDwn"))
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC_33780_CheckCaseFieldsEditableNonApproved Failed");
            throw new Exception("TC_33780_CheckCaseFieldsEditableNonApproved Failed", ex);
        } finally {
            session.end();
        }
    }
}

