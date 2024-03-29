package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC21664_22859_Creating_new_Case_settings_template_using_add_Template_button_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "Administration")
    public void TC21664_22859_Creating_new_Case_settings_template_using_add_Template_button_Test(Hashtable<String, String> data) throws Exception {
        testCaseId="2453721";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testing
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToCaseSettingsPage()
                    .createCaseSettingsTemplate(data.get("CaseSettingsTemplateName"), data.get("Description"), data.get("kWE"),
                            data.get("WorkSpaceTemplateId"), data.get("ClientTemplateId"), data.get("ProcessingProfiles"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC21664_22859_Creating_new_Case_settings_template_using_add_Template_button_Test");
            throw new Exception("TC21664_22859_Creating_new_Case_settings_template_using_add_Template_button_Test Failed", ex);

        }finally {
            session.end();
        }
    }
}
