package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyDaterangesCanBeEnabledorDisabledByClickingToggleButton extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyDaterangesCanBeEnabledorDisabledByClickingToggleButton(Hashtable<String, String> data) throws Exception {
        testCaseId="2453473";
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
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .enableAndDisableDateRanges(data.get("Status1"))
                    .validateEnableAndDisableDateRanges(data.get("Status2"))
                    .logout();



        } catch (Exception ex) {
            session.log_Error("TC_52366_VerifyDaterangesCanBeEnabledorDisabledByClickingToggleButton Failed");
            throw new Exception("TC_52366_VerifyDaterangesCanBeEnabledorDisabledByClickingToggleButton", ex);
        } finally {
            session.end();
        }
    }
}