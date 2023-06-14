package com.ligl.Administration.General.LookManagerPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC54576_Check_admin_is_able_to_Create_or_edit_the_Case_type_lookup_value_when_CS_config_is_false_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC54576_Check_admin_is_able_to_Create_or_edit_the_Case_type_lookup_value_when_CS_config_is_false_Test(Hashtable<String, String> data) throws Exception {
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
                    .navigateToLookupManagerPage()
                    .selectLookupType(data.get("SelectLookUp"))
                    .clickOnNewButton()
                    .createLookUp(data.get("CaseTypeName"), data.get("DisplayOrder"), data.get("Description"), data.get("Optional"))
                    .searchAndSelectTheLookUp(data.get("SearchLookUpName"))
                    .editLookUp(data.get("EditCaseTypeName"), data.get("EditDisplayOrder"), data.get("EditDescription"), data.get("Optional"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC54576_Check_admin_is_able_to_Create_or_edit_the_Case_type_lookup_value_when_CS_config_is_false_Test Failed");
            throw new Exception("TC54576_Check_admin_is_able_to_Create_or_edit_the_Case_type_lookup_value_when_CS_config_is_false_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
