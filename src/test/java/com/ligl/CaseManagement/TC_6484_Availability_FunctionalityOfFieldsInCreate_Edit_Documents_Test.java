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
 * 6105-Case-Documents-Verify the availability & functionality of Issued By, Received By,Issued Date, Received Date fields in Create & Edit Document Modal
 */
public class TC_6484_Availability_FunctionalityOfFieldsInCreate_Edit_Documents_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_6484_Availability_FunctionalityOfFieldsInCreate_Edit_Documents_Test(Hashtable<String, String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCaseDocumentsPage()
                    .datesIssuedFields(data.get("IssuedBy"), data.get("ReceivedBy"), data.get("ParticularIssuedDate"), data.get("ParticulatReceivedDate"));
        } catch (Exception ex) {
            session.log_Error("TC_6484_Availability_FunctionalityOfFieldsInCreate_Edit_Documents_Test Failed");
            throw new Exception("TC_6484_Availability_FunctionalityOfFieldsInCreate_Edit_Documents_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
