package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_17036_VerifyAddingInhouseCounsel extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData",description ="CaseManagement")

    public void TC_17036_VerifyAddingInhouseCounsel(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToCaseCounselPage()
                    .addInhouseCounselToCase(data.get("Email1"), data.get("CounselName1"))
                    .addOneMoreInhouseCounselToCase(data.get("Email2"), data.get("CounselName2"))
                    .validateOneOrMoreInhouseCounsel(data.get("CounselName1"), data.get("CounselName2"));

        } catch (Exception ex) {
            session.log_Error("TC_17036_VerifyAddingInhouseCounsel Failed");
            throw new Exception("TC_17036_VerifyAddingInhouseCounsel Failed", ex);
        } finally {
            session.end();
        }
    }
}