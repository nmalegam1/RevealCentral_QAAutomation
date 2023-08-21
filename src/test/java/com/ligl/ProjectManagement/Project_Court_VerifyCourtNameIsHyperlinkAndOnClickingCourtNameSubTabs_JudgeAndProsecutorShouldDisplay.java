package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Project_Court_VerifyCourtNameIsHyperlinkAndOnClickingCourtNameSubTabs_JudgeAndProsecutorShouldDisplay extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void Project_Court_VerifyCourtNameIsHyperlinkAndOnClickingCourtNameSubTabs_JudgeAndProsecutorShouldDisplay(Hashtable<String, String> data) throws Exception {
        testCaseId="2453328";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("PROJECT"))
                    .GoToCase(data.get("PROJECT"))
                    .getLeftMenu().navigateToCourtPage()
                    .searchCourt(data.get("CourtName"))
                    .verifyJudgesAndProsecutorsShouldDisplayForTheRespectiveCourt(data.get("JudgeName"), data.get("ProsecutorName") );

        } catch (Exception ex) {
            session.log_Error("TC_C2453328_Project_Court_VerifyCourtNameIsHyperlinkAndOnClickingCourtNameSubTabs_JudgeAndProsecutorShouldDisplay Failed");
            throw new Exception("TC_C2453328_Project_Court_VerifyCourtNameIsHyperlinkAndOnClickingCourtNameSubTabs_JudgeAndProsecutorShouldDisplay Failed", ex);
        } finally {
            session.end();
        }
    }
}