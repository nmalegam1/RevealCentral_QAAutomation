package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC1983_Create_Template_using_addTemplate_button_for_CaseApproval_Template_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC1983_Create_Template_using_addTemplate_button_for_CaseApproval_Template_Test(Hashtable<String, String> data) throws Exception{
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .adminLogin(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEmailTemplatesPage()
                    .createNewEmailTemplate(data.get("EmailTemplateCategory"), data.get("EmailTemplateName"),
                            data.get("Subject"), data.get("Content"))
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC1983_Create_Template_using_addTemplate_button_for_CaseApproval_Template_Test");
            throw new Exception("TC1983_Create_Template_using_addTemplate_button_for_CaseApproval_Template_Test Failed", ex);
        }finally {
            session.end();
        }
    }
}
