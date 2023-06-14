package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_62314_VerifyColumnNamesAndColumnDataInProjectListGridWhenRelativityprocessingConfiguredCSFalse extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_62314_VerifyColumnNamesAndColumnDataInProjectListGridWhenRelativityprocessingConfiguredCSFalse(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("PROJECT"))
                    .clickOnChooseColumnsInProjectGrid()
                    .searchForTheRequiredColumnsThroughChooseColumn(data.get("INVENTORY"))
                    .performClearActionInSearchBarInChooseColumn()
                    .searchForTheRequiredColumnsThroughChooseColumn(data.get("PUBLISH"));



        } catch (Exception ex) {
            session.log_Error("TC_62314_VerifyColumnNamesAndColumnDataInProjectListGridWhenRelativityprocessingConfiguredCSFalse Failed");
            throw new Exception("TC_62314_VerifyColumnNamesAndColumnDataInProjectListGridWhenRelativityprocessingConfiguredCSFalse Failed", ex);
        } finally {
            session.end();
        }
    }
}