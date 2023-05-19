package com.ligl.Administration.LegalHold.ManageQuestionnaireTemplates;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC38070_Verify_newly_created_templates_populated_under_Custodian_and_stakeHolder_Questionnaire_template_dropdown extends TestBase{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description = "Administration")
    public void TC38070_Verify_newly_created_templates_are_populated_under_Questionnaire_Template_dropdown_for_Custodian_and_Stakeholder(Hashtable<String, String> data) throws Exception{
        try{
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    //Admin-ManageQuestionnaire
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToManageQuestionnaireTemplatesPage()
                    .selectQuestionnaireTemplate(data.get("CustodianQuestionTemplateName"))
                    .getQuestionnaireTemplateName("TC38070_CustodianQuestionTemplate")
                    .selectQuestionnaireTemplate(data.get("StakeHolderQuestionTemplateName"))
                    .getQuestionnaireTemplateName("TC38070_StakeHolderQuestionTemplate")
                    //Case-Legal Hold
                    .getHeader()
                    .goToCasePage()
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .checkThatNewlyCreatedQuestionnaireIsDisplaying(data.get("LegalHoldName"), data.get("CustodianNotice"),
                            session.getRegressionData("TC38070_CustodianQuestionTemplate"), data.get("StakeHolderNotice"),
                            session.getRegressionData("TC38070_StakeHolderQuestionTemplate"))

                    .getHeader()
                    .logout();
        }catch (Exception ex) {
            session.log_Error("TC38070_Verify_newly_created_templates_populated_under_Custodian_and_stakeHolder_Questionnaire_template_dropdown Failed");
            throw new Exception("TC38070_Verify_newly_created_templates_populated_under_Custodian_and_stakeHolder_Questionnaire_template_dropdown Failed", ex);
        } finally {
            session.end();
        }
    }
}
