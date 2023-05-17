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
 * Sub Category of Entity -Check whether 'Region' field is mandatory in Create & Edit Case when Facility Config is True
 */
public class TC_33273_CheckRegionIsMandatoryInCreateEditCaseBasedOnConfig_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_33273_CheckRegionIsMandatoryInCreateEditCaseBasedOnConfig_Test(Hashtable<String, String> data) throws Exception {
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
                    .checkRegionIsMandatory(data)
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC_33273_CheckRegionIsMandatoryInCreateEditCaseBasedOnConfig_Test Failed");
            throw new Exception("TC_33273_CheckRegionIsMandatoryInCreateEditCaseBasedOnConfig_Test failed", ex);
        } finally {
            session.end();
        }
    }
}