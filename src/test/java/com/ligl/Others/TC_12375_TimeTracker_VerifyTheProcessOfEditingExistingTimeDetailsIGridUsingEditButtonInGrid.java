package com.ligl.Others;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_12375_TimeTracker_VerifyTheProcessOfEditingExistingTimeDetailsIGridUsingEditButtonInGrid extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC_12375_TimeTracker_VerifyTheProcessOfEditingExistingTimeDetailsIGridUsingEditButtonInGrid(Hashtable<String, String> data) throws Exception {

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
                    .searchThroughTaskTitle(data.get("TaskTitle"))
                    .editFieldsInTimeTrackerPopUp(data.get("EffortDate"),data.get("CaseName"),data.get("TaskName"),data.get("TaskTitle"),data.get("EffortHours"),data.get("Description"))
                    .validateTheAddedDetailsInTheTimeTrackerGrid(data.get("EffortHours"),data.get("CaseName"),data.get("TaskName"),data.get("TaskTitle"));



        } catch (Exception ex) {
            session.log_Error("TC_12375_TimeTracker_VerifyTheProcessOfEditingExistingTimeDetailsIGridUsingEditButtonInGrid Failed");
            throw new Exception("TC_12375_TimeTracker_VerifyTheProcessOfEditingExistingTimeDetailsIGridUsingEditButtonInGrid Failed", ex);
        } finally {
            session.end();
        }
    }

}