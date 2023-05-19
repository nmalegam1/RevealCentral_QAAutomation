package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51430_CheckAckModeColumnInMyHoldsTabUpdatingBasedOnAcknowledgmentMode extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51430_CheckAckModeColumnInMyHoldsTabUpdatingBasedOnAcknowledgmentMode(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());

            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Launch = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .getHeader().goToMyHoldsPage()
                    .firstSearch()
                    .checkAckModeColumn(data.get("CaseName"),data.get("LHName1"),data.get("AckModeMail"))
                    .checkAckModeColumn(data.get("CaseName"),data.get("LHName2"),data.get("AckModeApp"));
        } catch (Exception ex) {
            session.log_Error("TC_51430_CheckAckModeColumnInMyHoldsTabUpdatingBasedOnAcknowledgmentMode Failed");
            throw new Exception("TC_51430_CheckAckModeColumnInMyHoldsTabUpdatingBasedOnAcknowledgmentMode Failed", ex);
        } finally {
            session.end();
        }
    }
}
