package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Case-Counsel-Outside Counsel- Verifying the functionality of adding Outside Counsel to Case using +LawFirm button in modal
 */
public class TC_1669_AddingOutsideCounselwithAddLawFirmButton_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_1669_AddingOutsideCounselwithAddLawFirmButton_Test(Hashtable<String, String> data) throws Exception {
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
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToOtherPartyPage()
                    .addingExistingParty(data.get("PartyName"), data.get("PartyType"))
                    .searchingParty(data.get("PartyName"))
                    .goToOutSideCounselInOtherParty()
                    .addOutCounselWithAddLawFirmBtn(data.get("PartyName"), data.get("LawFirm"), data.get("CounselFstName"), data.get("CounselLstName"), data.get("CounselFullName"));
        } catch (Exception ex) {
            //session.log_Error("TC_1669_AddingOutsideCounselwithAddLawFirmButton_Test Failed");
            throw new Exception("TC_1669_AddingOutsideCounselwithAddLawFirmButton_Test Failed", ex);
        }
    }
}
