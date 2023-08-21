package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyAlertShouldDisplayWhenIn_ActiveEmployeeIsAddedAsCustodianToProjectShouldBeAbleToAddToProject extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyAlertShouldDisplayWhenIn_ActiveEmployeeIsAddedAsCustodianToProjectShouldBeAbleToAddToProject(Hashtable<String, String> data) throws Exception {
        testCaseId="2453401";
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
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToCustodiansPage()
                    .addInActiveEMPToCase(data.get("Custodian"))
                    .validateCustodianAddedToGrid(data.get("Custodian"));


        } catch (Exception ex) {
            session.log_Error("TC_C2453401_VerifyAlertShouldDisplayWhenIn_ActiveEmployeeIsAddedAsCustodianToProjectShouldBeAbleToAddToProject Failed");
            throw new Exception("Exception in TC_C2453401_VerifyAlertShouldDisplayWhenIn_ActiveEmployeeIsAddedAsCustodianToProjectShouldBeAbleToAddToProject", ex);
        } finally {
            session.end();
        }
    }
}