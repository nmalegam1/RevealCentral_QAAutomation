package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserIsAbleToAddOneorMoreExistingOutsideCounselsToOtherPartyFromModal extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserIsAbleToAddOneorMoreExistingOutsideCounselsToOtherPartyFromModal(Hashtable<String, String> data) throws Exception {
        testCaseId="2453455";

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
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyType"), data.get("PartyName"))
                    .searchingParty(data.get("PartyName"))
                    .addExistingOutCounsel(data.get("ExistingLawFirm"), data.get("SelectedLawFirmSubEntities"))
                    .validateAddedOutsideCounsel(data.get("SelectedLawFirmSubEntities"));

        } catch (Exception ex) {
            session.log_Error("TC_7126_VerifyUserIsAbleToAddOneorMoreExistingOutsideCounselsToOtherPartyFromModal Failed");
            throw new Exception("TC_7126_VerifyUserIsAbleToAddOneorMoreExistingOutsideCounselsToOtherPartyFromModal failed", ex);
        } finally {
            session.end();
        }
    }
}
