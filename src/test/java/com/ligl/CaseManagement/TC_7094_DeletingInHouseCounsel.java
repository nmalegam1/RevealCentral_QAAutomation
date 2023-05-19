package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_7094_DeletingInHouseCounsel extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_7094_DeletingInHouseCounsel(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }

            ILiglPage page = new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToCaseCounselPage()
                    .addInhouseCounselToCase(data.get("Email1"), data.get("CounselName"))
                    .deleteInhouseCounselFromCase()
                    .validateInhouseCounsel();
        } catch (Exception ex) {
            session.log_Error("TC_7094_DeletingInHouseCounsel Failed");
            throw new Exception("TC_7094_DeletingInHouseCounsel Failed", ex);
        } finally {
            session.end();
        }
    }
}

