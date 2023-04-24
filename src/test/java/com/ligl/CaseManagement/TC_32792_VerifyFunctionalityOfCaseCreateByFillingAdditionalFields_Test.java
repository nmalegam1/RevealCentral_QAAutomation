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
 * Case-Verify the functionality of 'Save & Add Details' button after entering all Additional fields
 */
public class TC_32792_VerifyFunctionalityOfCaseCreateByFillingAdditionalFields_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_32792_VerifyFunctionalityOfCaseCreateByFillingAdditionalFields_Test(Hashtable<String, String> data) throws Exception {
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
                    .login(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .caseCreateWithAdditionalFields(data);
        } catch (Exception ex) {
            session.log_Error("TC_32792_VerifyFunctionalityOfCaseCreateByFillingAdditionalFields_Test Failed");
            throw new Exception("Exception in TC_32792_VerifyFunctionalityOfCaseCreateByFillingAdditionalFields_Test", ex);
        } finally {
            session.end();
        }
    }
}

