package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserShouldNotBeAbleToCreateDuplicateProjects extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserShouldNotBeAbleToCreateDuplicateProjects(Hashtable<String, String> data) throws Exception {
        testCaseId="2453396";
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
                    .createNewCase(data)
                    .getHeader().goToCasePage().clickOnAddProjectButton().enterProjectType(data.get("ProjectTYPE"))
                    .enterRole(data.get("ROLE")).enterProjectName(data.get("PROJECT")).enterDescription(data.get("DESC"))
                    .validatingTheErrorMessageWhileCreatingTheDuplicateProjectNames(data);

        } catch (Exception ex) {
            session.log_Error("TC_C2453396_VerifyUserShouldNotBeAbleToCreateDuplicateProjects Failed");
            throw new Exception("TC_C2453396_VerifyUserShouldNotBeAbleToCreateDuplicateProjects Failed", ex);
        } finally {
            session.end();
        }
    }
}