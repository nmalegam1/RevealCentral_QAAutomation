package com.ligl.Administration.LegalHold.ManageQuestionnaireTemplates;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC20800_Verify_the_Functionality_of_Delink_Option_for_a_Question_in_Questionnaire_Template
        extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC20800_Verify_the_Functionality_of_Delink_Option_for_a_Question_in_Questionnaire_Template(Hashtable<String, String> data) throws Exception{
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
                    .navigateToManageQuestionnaireTemplatesPage()
                    .selectQuestionnaireTemplate(data.get("QuestionnaireTemplate"))
                    .deLinkTheQuestion(data.get("Question"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC20800_Verify_the_Functionality_of_Delink_Option_for_a_Question_in_Questionnaire_Template Failed");
            throw new Exception("TC20800_Verify_the_Functionality_of_Delink_Option_for_a_Question_in_Questionnaire_Template Failed", ex);
        } finally {
            session.end();
        }
    }
}
