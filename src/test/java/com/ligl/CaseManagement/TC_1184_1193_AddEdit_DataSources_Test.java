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
 * Case-Data Sources-Verifying the functionality of Save button
 * Case-Data sources-Verify the functionality of Edit button
 */
public class TC_1184_1193_AddEdit_DataSources_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_1184_1193_AddEdit_DataSources_Test(Hashtable<String, String> data) throws Exception {
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addDataSources(data.get("DataSource1"))
                    .editDataSources(data.get("DataSource1"), data.get("DataSource2"));
        } catch (Exception ex) {
            session.log_Error("TC_1184_1193_AddEdit_DataSources_Test Failed");
            throw new Exception("Exception in TC_1184_1193_AddEdit_DataSources_Test", ex);
        } finally {
            session.end();
        }
    }
}