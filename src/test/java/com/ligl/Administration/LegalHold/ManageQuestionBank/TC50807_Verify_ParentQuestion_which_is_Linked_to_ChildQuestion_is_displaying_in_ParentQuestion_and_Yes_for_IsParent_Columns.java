package com.ligl.Administration.LegalHold.ManageQuestionBank;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC50807_Verify_ParentQuestion_which_is_Linked_to_ChildQuestion_is_displaying_in_ParentQuestion_and_Yes_for_IsParent_Columns extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC50807_Verify_ParentQuestion_which_is_Linked_to_ChildQuestion_is_displaying_in_ParentQuestion_and_Yes_for_IsParent_Columns(Hashtable<String, String> data) throws Exception {
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
                    .navigateToManageQuestionBankPage()
                    .clickOnQuestionnaireButton()
                    .createNewQuestionnaire(data.get("QuestionnaireTitle"), data.get("RenderType"), data.get("IsParent"),
                            data.get("IsQuestionMandatory"), data.get("Null"), data.get("Description"), data.get("Null"),
                            data.get("ParentQuestionAddToChild"))
                    .refreshTheManageQuestionBankPage()
                    .searchTheQuestion(data.get("QuestionnaireTitle"))
                    .verifyTheIsParentOption(data.get("QuestionnaireTitle"))
                    .refreshTheManageQuestionBankPage()
                    .searchTheQuestion(data.get("QuestionnaireTitle"))
                    .verifyParentQuestionColumn(data.get("QuestionnaireTitle"))
                    .getHeader()
                    .logout();

        } catch (Exception | Error ex) {
            session.log_Error("TC50807_Verify_ParentQuestion_which_is_Linked_to_ChildQuestion_is_displaying_in_ParentQuestion_and_Yes_for_IsParent_Columns Failed");
            throw new Exception("TC50807_Verify_ParentQuestion_which_is_Linked_to_ChildQuestion_is_displaying_in_ParentQuestion_and_Yes_for_IsParent_Columns Failed", ex);
        }
    }
}
