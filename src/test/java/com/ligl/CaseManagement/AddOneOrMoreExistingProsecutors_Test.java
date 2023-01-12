package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class AddOneOrMoreExistingProsecutors_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void AddOneOrMoreExistingProsecutors_Test(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("AvailableCourt"))
                    .searchingAddedCourt(data.get("AvailableCourt"))
                    .navigateAndAddProsecutor(data.get("AvailableCourt"), data.get("AvailableProsecutor1"), data.get("AvailableProsecutor2"), data.get("AvailableProsecutor3"), data.get("AvailableProsecutor4") )
                    .validateProsecutors(data.get("AvailableProsecutor1"), data.get("AvailableProsecutor2"), data.get("AvailableProsecutor3"), data.get("AvailableProsecutor4"));




        } catch (Exception ex) {
            session.log_Error("AddOneOrMoreExistingProsecutors_Test Failed");
            throw new Exception("AddOneOrMoreExistingProsecutors_Test Failed", ex);
        } finally {
            session.end();
        }
    }
}
