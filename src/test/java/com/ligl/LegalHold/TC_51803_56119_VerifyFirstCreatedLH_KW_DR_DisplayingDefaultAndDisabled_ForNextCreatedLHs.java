package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51803_56119_VerifyFirstCreatedLH_KW_DR_DisplayingDefaultAndDisabled_ForNextCreatedLHs extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51803_56119_VerifyFirstCreatedLH_KW_DR_DisplayingDefaultAndDisabled_ForNextCreatedLHs(Hashtable<String,String> data) throws Exception {
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater(data.get("LHName1"),data.get("LHName2"),data.get("CustNoticeTemp"),data.get("StartDate"),data.get("EndDate"),data.get("KeyWord"));
        } catch (Exception ex) {
            session.log_Error("TC_51803_VerifyFirstCreatedLH_KW_DR_DisplayedDefaultToRestOfLHs Failed");
            throw new Exception("TC_51803_VerifyFirstCreatedLH_KW_DR_DisplayedDefaultToRestOfLHs Failed", ex);
        } finally {
            session.end();
        }
    }
}

