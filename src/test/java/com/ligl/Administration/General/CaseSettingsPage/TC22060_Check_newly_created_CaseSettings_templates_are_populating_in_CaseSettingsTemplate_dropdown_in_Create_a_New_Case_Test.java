package com.ligl.Administration.General.CaseSettingsPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC22060_Check_newly_created_CaseSettings_templates_are_populating_in_CaseSettingsTemplate_dropdown_in_Create_a_New_Case_Test extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC22060_Check_newly_created_CaseSettings_templates_are_populating_in_CaseSettingsTemplate_dropdown_in_Create_a_New_Case_Test(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL().navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    .checkNewlyCreatedCaseSettingTemplatePopulatedInCaseSettingsTemplateDropDown(data.get("CaseSettingsTemplate"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC22060_Check_newly_created_CaseSettings_templates_are_populating_in_CaseSettingsTemplate_dropdown_in_Create_a_New_Case_Test Failed");
            throw new Exception("TC22060_Check_newly_created_CaseSettings_templates_are_populating_in_CaseSettingsTemplate_dropdown_in_Create_a_New_Case_Test Failed", ex);
        }finally {
            session.end();
        }
    }
}
