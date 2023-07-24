package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7110_VerifyUserAbleToCreateInhouseCounselsFromProjectForPartyType_Enterprise_AndAbleToAddExistingInhouseCounselsToProjectOnlyIfPartyTypeIs_Enterprise extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_7110_VerifyUserAbleToCreateInhouseCounselsFromProjectForPartyType_Enterprise_AndAbleToAddExistingInhouseCounselsToProjectOnlyIfPartyTypeIs_Enterprise(Hashtable<String, String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("PROJECT1")).GoToCase(data.get("PROJECT1"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyType"),data.get("PartyName"))
                    .searchingParty(data.get("PartyName"))
                    .createNewInHouseCounselForEnterpriseParty(data.get("PartyName"),data.get("FirstName"),data.get("LastName"))
                    .searchingInHouseCounsel(data.get("PartyName"),data.get("InHouseCounselName"))
                    .validateAddedInHouseCounsel(data.get("InHouseCounselName"))
                    .getHeader().goToCasePage()
                    .searchcase(data.get("PROJECT2")).GoToCase(data.get("PROJECT2"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyType"),data.get("PartyName"))
                    .searchingParty(data.get("PartyName"))
                    .addExistingInHouseCounselToParty(data.get("InHouseCounselName"));

        } catch (Exception ex) {
            session.log_Error("TC_7110_VerifyUserAbleToCreateInhouseCounselsFromProjectForPartyType_Enterprise_AndAbleToAddExistingInhouseCounselsToProjectOnlyIfPartyTypeIs_Enterprise Failed");
            throw new Exception("TC_7110_VerifyUserAbleToCreateInhouseCounselsFromProjectForPartyType_Enterprise_AndAbleToAddExistingInhouseCounselsToProjectOnlyIfPartyTypeIs_Enterprise failed", ex);
        } finally {
            session.end();
        }
    }
}
