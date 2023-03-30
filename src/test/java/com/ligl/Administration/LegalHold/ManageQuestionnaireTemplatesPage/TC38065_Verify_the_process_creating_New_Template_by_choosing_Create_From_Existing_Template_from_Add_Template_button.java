package com.ligl.Administration.LegalHold.ManageQuestionnaireTemplatesPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC38065_Verify_the_process_creating_New_Template_by_choosing_Create_From_Existing_Template_from_Add_Template_button extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "AdministrationModule")
    public void TC38065_Verify_the_process_creating_New_Template_by_choosing_Create_From_Existing_Template_from_Add_Template_button(Hashtable<String, String> data) throws Exception{
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
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC38065_Verify_the_process_creating_New_Template_by_choosing_Create_From_Existing_Template_from_Add_Template_button Failed");
            throw new Exception("TC38065_Verify_the_process_creating_New_Template_by_choosing_Create_From_Existing_Template_from_Add_Template_button Failed", ex);
        } finally {
            session.end();
        }
    }
}
