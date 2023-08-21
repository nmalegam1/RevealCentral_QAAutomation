package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToAddOneOrMoreExistingPartiesFromModalByClickingAddPartyButton extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToAddOneOrMoreExistingPartiesFromModalByClickingAddPartyButton(Hashtable<String, String> data) throws Exception {
        testCaseId="2453441";
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
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyType1"), data.get("PartyName1"))
                    .addingExistingParty(data.get("PartyType2"), data.get("PartyName2"))
                    .searchingParty(data.get("PartyName1"))
                    .validatePartyInTheOtherPartyScreenAfterAddingThroughAddPartyButton(data.get("PartyName1"))
                    .secondSearchPartyInOtherPartyGrid(data.get("PartyName2"))
                    .validatePartyInTheOtherPartyScreenAfterAddingThroughAddPartyButton(data.get("PartyName2"));

        } catch (Exception ex) {
            session.log_Error("TC_1603_VerifyUserAbleToAddOneOrMoreExistingPartiesFromModalByClickingAddPartyButton Failed");
            throw new Exception("TC_1603_VerifyUserAbleToAddOneOrMoreExistingPartiesFromModalByClickingAddPartyButton Failed", ex);
        } finally {
            session.end();
        }
    }
}