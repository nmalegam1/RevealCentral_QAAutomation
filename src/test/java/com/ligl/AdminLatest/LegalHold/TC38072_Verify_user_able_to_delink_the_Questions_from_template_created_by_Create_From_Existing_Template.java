package com.ligl.AdminLatest.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC38072_Verify_user_able_to_delink_the_Questions_from_template_created_by_Create_From_Existing_Template extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC38072_Verify_user_is_able_to_delink_the_Questions_from_the_template_created_by_choosing_Create_From_Existing_Template(Hashtable<String, String> data) throws Exception{
        testCaseId="2453492";
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
                    //.loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .adminLogin(data.get("Username"),"Vertical.321",data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToManageQuestionnaireTemplatesPage()
                    .clickOnAddTemplate(data)
                    .createNewQuestionnaireTemplates(data)
                    .clickOnAddNewQuestionButton()
                    .addQuestionToManageQuestionnaireTemplate(data)
                    .deLinkTheQuestion(data.get("DeLinkTheQuestion"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC38072_Verify_user_able_to_delink_the_Questions_from_template_created_by_Create_From_Existing_Template Failed");
            throw new Exception("TC38072_Verify_user_able_to_delink_the_Questions_from_template_created_by_Create_From_Existing_Template Failed", ex);
        } finally {
            session.end();
        }
    }
}
