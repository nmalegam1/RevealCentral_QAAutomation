package com.ligl.Administration.LegalHold.ManageQuestionnaireTemplates;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC20802_Verify_the_Functionality_of_Save_Button_after_Editing_the_fields_for_a_Questionnaire_Template extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC20802_Verify_the_Functionality_of_Save_Button_after_Editing_the_fields_for_a_Questionnaire_Template(Hashtable<String, String> data) throws Exception{
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
                    .navigateToManageQuestionnaireTemplatesPage()
                    .selectQuestionnaireTemplate(data.get("QuestionnaireTemplate"))
                    .clickOnEditButtonInManageQuestionnaireTemplate()
                    .editQuestionnaireTemplate(data)
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC20802_Verify_the_Functionality_of_Save_Button_after_Editing_the_fields_for_a_Questionnaire_Template Failed");
            throw new Exception("TC20802_Verify_the_Functionality_of_Save_Button_after_Editing_the_fields_for_a_Questionnaire_Template Failed", ex);
        } finally {
            session.end();
        }
    }
}
