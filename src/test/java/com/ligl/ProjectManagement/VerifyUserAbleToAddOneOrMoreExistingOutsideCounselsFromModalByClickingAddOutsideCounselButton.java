package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToAddOneOrMoreExistingOutsideCounselsFromModalByClickingAddOutsideCounselButton extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToAddOneOrMoreExistingOutsideCounselsFromModalByClickingAddOutsideCounselButton(Hashtable<String, String> data) throws Exception {
        testCaseId="2453443";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage Launch = new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToCaseCounselPage().toggleToOutSideCounsel()
                    .clickOnAddOutsideCounsel().selectALawfirmFromDropdown(data.get("LAWFIRM"))
                    .selectAvailableLawFirms(data.get("SubLAWFIRM1"))
                    .selectAvailableLawFirms(data.get("SubLAWFIRM2"))
                    .clickOnSaveButtonInAddOutsideCounselPopUp()
                    .searchRequiredOutsideCounselInOutsideCounselGrid(data.get("SubLAWFIRM1"))
                    .validateNewOutSideCounselAdded(data.get("SubLAWFIRM1"))
                    .secondSearchRequiredOutsideCounselInOutsideCounselGrid(data.get("SubLAWFIRM2"))
                    .validateNewOutSideCounselAdded(data.get("SubLAWFIRM2"));


        } catch (Exception ex) {
            session.log_Error("TC_1669_VerifyUserAbleToAddOneOrMoreExistingOutsideCounselsFromModalByClickingAddOutsideCounselButton Failed");
            throw new Exception("TC_1669_VerifyUserAbleToAddOneOrMoreExistingOutsideCounselsFromModalByClickingAddOutsideCounselButton Failed", ex);
        } finally {
            session.end();
        }
    }
}