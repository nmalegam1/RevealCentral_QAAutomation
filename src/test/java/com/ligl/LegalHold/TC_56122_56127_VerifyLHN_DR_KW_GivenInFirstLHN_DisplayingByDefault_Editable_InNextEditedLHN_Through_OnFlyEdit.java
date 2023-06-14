package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_56122_56127_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Editable_InNextEditedLHN_Through_OnFlyEdit extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_56122_56127_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Editable_InNextEditedLHN_Through_OnFlyEdit(Hashtable<String,String> data) throws Exception {
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
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHName2"))
                    .editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable(data.get("LHName1"),data.get("LHName2"),data.get("LHName3"),data.get("CustNoticeTemp"),data.get("StartDate"),data.get("EndDate"),data.get("KeyWord"),data.get("NewTempName"),data.get("MailSubject"),data.get("MailContent"));
        } catch (Exception ex) {
            session.log_Error("TC_56122_56127_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Editable_InNextEditedLHN_Through_OnFlyEdit Failed");
            throw new Exception("TC_56122_56127_VerifyLHN_DR_KW_GivenInFirstLHN_DisplayingByDefault_Editable_InNextEditedLHN_Through_OnFlyEdit Failed", ex);
        } finally {
            session.end();
        }
    }
}




