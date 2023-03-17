package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56121_56126_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Disable_InNextCreatedLHN_Through_OnFlyEdit extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
    public void TC_56121_56126_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Disable_InNextCreatedLHN_Through_OnFlyEdit(Hashtable<String,String> data) throws Exception {
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
                    //.searchRequiredLegalHoldName(data.get("LHName"))
                    .createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled(data.get("LHName1"),data.get("LHName2"),data.get("LHName3"),data.get("CustNoticeTemp"),data.get("StartDate"),data.get("EndDate"),data.get("KeyWord"),data.get("NewTempName"),data.get("MailSubject"),data.get("MailContent"));
        } catch (Exception ex) {
            session.log_Error("TC_56121_56126_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Disable_InNextCreatedLHN_Through_OnFlyEdit Failed");
            throw new Exception("TC_56121_56126_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Disable_InNextCreatedLHN_Through_OnFlyEdit Failed", ex);
        } finally {
            session.end();
        }
    }
}



