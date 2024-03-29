package com.ligl.AdminLatest.Genral;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC35048_Edit_Subject_and_Content_for_Mentioned_Email_Template_Categories_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC35048_Edit_Subject_and_Content_for_Mentioned_Email_Template_Categories_Test(Hashtable<String, String> data) throws Exception{
        testCaseId="2453835";
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
                    .editEmailTemplate(data.get("SelectEmailTemplateCategory"), data.get("SelectEmailTemplate"),
                            data.get("EditSubject"), data.get("EditContent"))
                    .getHeader()
                    .logout();
        }catch (Exception ex){
            session.log_Error("TC35048_Edit_Subject_and_Content_for_Mentioned_Email_Template_Categories_Test");
            throw new Exception("TC35048_Edit_Subject_and_Content_for_Mentioned_Email_Template_Categories_Test", ex);
        }finally {
            session.end();
        }
    }

}
