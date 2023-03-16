package com.ligl.Administration.LegalHold.ManageQuestionBank;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC20282_Verifying_the_functionality_of_Save_button_in_Create_and_Edit_Questionnaire_modal extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC20282_Verifying_the_functionality_of_Save_button_in_Create_and_Edit_Questionnaire_modal(Hashtable<String, String> data) throws Exception {
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
                    .clickOnManageQuestionBankPageLink()
                    .clickOnQuestionnaireButton()
                    .createNewQuestionnaire(data.get("QuestionnaireTitle"), data.get("RenderType"),data.get("IsParent"),
                            data.get("IsQuestionMandatory"), data.get("RenderOptions"), data.get("Description"),
                            data.get("AppliesTo"), data.get("Null"))
                    .refreshTheManageQuestionBankPage()

                    //Edit
                    .searchTheQuestion(data.get("searchQuestion"))
                    .scrollToRightToDoActionInManageQuestionGrid(data.get("searchQuestion"))
                    .clickOnEditInQuestionGrid()
                    .editExitingQuestionnaire(data.get("EditQuestionnaireTitle"), data.get("EditIsQuestionMandatory"),data.get("EditDescription"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC20282_Verifying_the_functionality_of_Save_button_in_Create_and_Edit_Questionnaire_modal Failed");
            throw new Exception("TC20282_Verifying_the_functionality_of_Save_button_in_Create_and_Edit_Questionnaire_modal Failed", ex);
        } finally {
            session.end();
        }
    }
}
