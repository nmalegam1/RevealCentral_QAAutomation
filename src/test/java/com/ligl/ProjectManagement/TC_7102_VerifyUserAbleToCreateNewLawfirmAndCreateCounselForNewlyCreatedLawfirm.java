package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7102_VerifyUserAbleToCreateNewLawfirmAndCreateCounselForNewlyCreatedLawfirm extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_7102_VerifyUserAbleToCreateNewLawfirmAndCreateCounselForNewlyCreatedLawfirm(Hashtable<String, String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu().goToCaseCounselPage().toggleToOutSideCounsel()
                    .clickOnAddOutsideCounsel()
                    .selectALawfirmFromDropdown(data.get("LAWFIRM"))
                    .clickOnAddLawFirmButtonInAddOutsideCounselPopUp()
                    .createNewLawFirmInAddLawFirmPopUp(data.get("FirstLAWFIRM"),data.get("PartyLAWFIRM"), data.get("StatusLAWFIRM"), data.get("DescLAWFIRM") )
                    .toggleToOutSideCounsel().clickOnAddOutsideCounsel()
                    .selectALawfirmFromDropdown(data.get("FirstLAWFIRM"))
                    .clickOnAddCounselButtonInAddOutsideCounselPopUp()
                    .createNewCounselInAddOutsideCounselPopUp(data.get("FIRSTname"), data.get("SECONDname") )
                    .toggleToOutSideCounsel()
                    .searchRequiredOutsideCounselInOutsideCounselGrid(data.get("FULLname"))
                    .validateNewOutSideCounselAdded(data.get("FULLname"));


        } catch (Exception ex) {
            session.log_Error("TC_7102_VerifyUserAbleToCreateNewLawfirmAndCreateCounselForNewlyCreatedLawfirm Failed");
            throw new Exception("TC_7102_VerifyUserAbleToCreateNewLawfirmAndCreateCounselForNewlyCreatedLawfirm Failed", ex);
        } finally {
            session.end();
        }
    }
}
