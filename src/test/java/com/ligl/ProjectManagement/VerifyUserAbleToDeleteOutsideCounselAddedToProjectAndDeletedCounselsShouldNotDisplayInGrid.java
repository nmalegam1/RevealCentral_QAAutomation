package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToDeleteOutsideCounselAddedToProjectAndDeletedCounselsShouldNotDisplayInGrid extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToDeleteOutsideCounselAddedToProjectAndDeletedCounselsShouldNotDisplayInGrid(Hashtable<String, String> data) throws Exception {
        testCaseId="2453449";

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("skipping the test as runmode was no");
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToCaseCounselPage()
                    .addDeleteOutsideCounselToCase(data.get("OptionFromLawFirmDropDwn"), data.get("SelectAvailableLawfirm"))
                    .validateOutSideCounsel();

        } catch (Exception ex) {
            session.log_Error("TC_7100_VerifyUserAbleToDeleteOutsideCounselAddedToProjectAndDeletedCounselsShouldNotDisplayInGrid Failed");
            throw new Exception("TC_7100_VerifyUserAbleToDeleteOutsideCounselAddedToProjectAndDeletedCounselsShouldNotDisplayInGrid Failed", ex);
        } finally {
            session.end();
        }
    }
}
