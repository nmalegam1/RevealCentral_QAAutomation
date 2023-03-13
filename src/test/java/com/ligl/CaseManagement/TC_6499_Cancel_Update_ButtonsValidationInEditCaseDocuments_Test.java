package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * Case-Documents-Verify the functionality of Cancel & Update buttons in Edit Document modal
 */
public class TC_6499_Cancel_Update_ButtonsValidationInEditCaseDocuments_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_6499_Cancel_Update_ButtonsValidationInEditCaseDocuments_Test(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage Ref = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCaseDocumentsPage()
                    .updateInEditDocument(data.get("DescriptionToUpdate"))
                    .cancelInEditDocument(data.get("DescriptionToUpdate"));
        } catch (Exception ex) {
            session.log_Error("TC_6499_Cancel_Update_ButtonsValidationInEditCaseDocuments_Test Failed");
            throw new Exception("TC_6499_Cancel_Update_ButtonsValidationInEditCaseDocuments_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
