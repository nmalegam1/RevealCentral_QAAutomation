package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToEditMandatoryFieldsInProjectEditPopUpUntilProjectApprovedExcept_OurRole_Field extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToEditMandatoryFieldsInProjectEditPopUpUntilProjectApprovedExcept_OurRole_Field(Hashtable<String, String> data) throws Exception {
        testCaseId="2453465";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .createNewCase(data)
                    .clickOnProjectEditButton()
                    .verifyMandatoryFieldsAreEditableInEditProjectPopUpUntillProjectApproved(data)
                    .clickOnSaveButtonFromEditPopUpInCaseSummaryPage()
                    .validateTheEditedDetailsInEditProjectPopUpInProjectSummary(data);


        } catch (Exception ex) {
            session.log_Error("TC_33780_VerifyUserAbleToEditMandatoryFieldsInProjectEditPopUpUntilProjectApprovedExcept_OurRole_Field Failed");
            throw new Exception("TC_33780_VerifyUserAbleToEditMandatoryFieldsInProjectEditPopUpUntilProjectApprovedExcept_OurRole_Field Failed", ex);
        } finally {
            session.end();
        }
    }
}
