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
 * Custodian-Check the functionality of 'Activate/Deactivate' dropdown
 */
public class TC_28868_Active_Inactive_Custodians_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "CaseManagement")
    public void TC_28868_Active_Inactive_Custodians_Test(Hashtable<String, String> data) throws Exception {
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
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Custodian"))
                    .validateCustodianAddedToGrid(data.get("Custodian"))
                    .deActivateActiveCustodian(data.get("Custodian"), data.get("InactiveStatus"))
                    .activeInactiveCustodians(data.get("Custodian"), data.get("ActiveStatus"));
        } catch (Exception ex) {
            session.log_Error("TC_28868_Active_Inactive_Custodians_Test Failed");
            throw new Exception("Exception in TC_28868_Active_Inactive_Custodians_Test", ex);
        } finally {
            session.end();
        }
    }
}
