package com.ligl.Administration.LegalHold.ManageDisplayContent;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC36508_Check_applicable_Parameters_displayed_to_the_Value_selected_from_the_category_dropdown extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC36508_Check_applicable_Parameters_displayed_to_the_Value_selected_from_the_category_dropdown(Hashtable<String, String> data) throws Exception {
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
                    .navigateToManageDisplayContentPage()
                    .verifyTheParametersInManageDisplayContent(data.get("ManageContentCategory"),
                            session.getRegressionData("TC36508_Parameter1"), session.getRegressionData("TC36508_Parameter2"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC36508_Check_applicable_Parameters_displayed_to_the_Value_selected_from_the_category_dropdown Failed");
            throw new Exception("TC36508_Check_applicable_Parameters_displayed_to_the_Value_selected_from_the_category_dropdown Failed", ex);
        } finally {
            session.end();
        }
    }
}
