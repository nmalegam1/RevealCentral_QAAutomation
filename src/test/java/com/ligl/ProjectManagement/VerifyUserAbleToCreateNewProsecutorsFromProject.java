package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToCreateNewProsecutorsFromProject extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToCreateNewProsecutorsFromProject(Hashtable<String , String> data) throws Exception{
        testCaseId="2453471";
        try{
            session.log_Info(data.get(toString()));
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("CourtName"))
                    .searchCourt(data.get("CourtName"))
                    .navigateToProsecutor()
                    .createNewProsecutor(data.get("CounselFN"),data.get("CounselLN"))
                    .searchCourt(data.get("CourtName"))
                    .navigateToProsecutor()
                    .validateProsecutorAddedToGrid(data.get("CounselFN"),data.get("CounselLN"))
                    .logout();

        }catch (Exception e)
        {session.log_Error("TC_52241_VerifyUserAbleToCreateNewProsecutorsFromProject Failed");
            throw new Exception("TC_52241_VerifyUserAbleToCreateNewProsecutorsFromProject Failed", e);
        } finally {
            session.end();
        }
    }
}
