package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_1604_VerifyUserAbleToCreateNewPartyFromProject extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_1604_VerifyUserAbleToCreateNewPartyFromProject(Hashtable<String, String> data) throws Exception {
        try {
            session.log_Info(data.get(toString()));
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .createAndValidatePartyCreatedOrNot(data.get("PartyName"), data.get("PartyType"), data.get("Description"),data.get("Status"));

        } catch (Exception ex) {
            session.log_Error("TC_1604_VerifyUserAbleToCreateNewPartyFromProject Failed");
            throw new Exception("TC_1604_VerifyUserAbleToCreateNewPartyFromProject failed", ex);
        } finally {
            session.end();
        }
    }
}
