package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyAddingInhouseCounsel_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void VerifyAddingInhouseCounsel_Test(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToCaseCounselPage()
                    .addInhouseCounselToCase(data.get("Email1"),data.get("CounselName"))
                    .addOneMoreInhouseCounselToCase(data.get("Email2"),data.get("CounselName1"))
                    .validateOneOrMoreInhouseCounsel(data.get("CounselName"),data.get("CounselName1"));





        } catch (Exception ex) {
            session.log_Error("VerifyAddingInhouseCounsel_Test Failed");
            throw new Exception("VerifyAddingInhouseCounsel_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}