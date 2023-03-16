package com.ligl.Administration.General.LookManagerPage;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC54587_Check_admin_is_able_to_create_edit_the_Entity_and_SubEntity_lookup_value_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void TC54587_Check_admin_is_able_to_create_edit_the_Entity_and_SubEntity_lookup_value_Test(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnLookupManagerLink()
                    .selectLookupType(data.get("SelectLookUp"))
                    .clickOnNewButton()
                    .createLookUp(data.get("EntityName"), data.get("EntityDisplayOrder"), data.get("EntityDescription"), data.get("EntityOptional"))
                    .searchAndSelectTheLookUp(data.get("SearchLookUpEntityName"))
                    .editLookUp(data.get("EditEntityName"), data.get("EditEntityDisplayOrder"), data.get("EditEntityDescription"), data.get("EntityOptional"))
                    .selectLookupType(data.get("SelectSubEntityLookUp"))
                    .clickOnNewButton()
                    .createLookUp(data.get("SubEntityName"), data.get("SubEntityDisplayOrder"), data.get("SubEntityDescription"), data.get("SelectEntity"))
                    .searchAndSelectTheLookUp(data.get("SearchLookUpSubEntityName"))
                    .editLookUp(data.get("EditSubEntityName"), data.get("EditSubEntityDisplayOrder"), data.get("EditSubEntityDescription"), data.get("ChangeEntity"))
                    .getHeader()
                    .logout();

        } catch (Exception ex) {
            session.log_Error("TC54587_Check_admin_is_able_to_create_edit_the_Entity_and_SubEntity_lookup_value_Test Failed");
            throw new Exception("TC54587_Check_admin_is_able_to_create_edit_the_Entity_and_SubEntity_lookup_value_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
