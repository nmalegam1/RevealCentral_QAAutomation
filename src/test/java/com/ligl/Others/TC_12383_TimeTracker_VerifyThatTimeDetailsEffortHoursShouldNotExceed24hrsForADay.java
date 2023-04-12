package com.ligl.Others;
import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;
import java.util.Hashtable;
public class TC_12383_TimeTracker_VerifyThatTimeDetailsEffortHoursShouldNotExceed24hrsForADay extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_12383_TimeTracker_VerifyThatTimeDetailsEffortHoursShouldNotExceed24hrsForADay(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("skipping the test as runmode was no");
                throw new SkipException("Skipping the test as Runmode Was No");
            }



            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .getHeader()
                    .goToTimeTrackerPage()
                    .addTimeDetail(data)
                    .addTimeDetail(data)
                    .validateHoursExceededAlert(data.get("Alert"))
                    .getHeader()
                    .logout();
         } catch (Exception ex) {
            session.log_Error("TC_12383_TimeTracker_VerifyThatTimeDetailsEffortHoursShouldNotExceed24hrsForADay Failed");
            throw new Exception("TC_12383_TimeTracker_VerifyThatTimeDetailsEffortHoursShouldNotExceed24hrsForADay Failed", ex);
        } finally {
            session.end();
        }
    }

}
