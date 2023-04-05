package com.ligl.Administration.LegalHold.ManageQuestionnaireTemplatesPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC20792_Verify_Functionality_of_Add_Questions_Button_for_a_template_created_by_choosing_Create_New_Template extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "AdministrationModule")
    public void TC20792_Verify_Functionality_of_Add_Questions_Button_for_a_template_created_by_choosing_Create_New_Template(Hashtable<String, String> data) throws Exception{
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminLegalHold()
                    .getAdminLeft()
                    .clickOnManageQuestionnaireTemplatesPageLink()
                    .clickOnAddTemplate()
                    .createNewQuestionnaireTemplates(data)
                    .clickOnAddNewQuestionButton()
                    .addQuestionToManageQuestionnaireTemplate(data)
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC20792_Verify_Functionality_of_Add_Questions_Button_for_a_template_created_by_choosing_Create_New_Template Failed");
            throw new Exception("TC20792_Verify_Functionality_of_Add_Questions_Button_for_a_template_created_by_choosing_Create_New_Template Failed", ex);
        } finally {
            session.end();
        }
    }
}
