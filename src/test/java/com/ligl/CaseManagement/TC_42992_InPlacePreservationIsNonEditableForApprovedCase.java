package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_42992_InPlacePreservationIsNonEditableForApprovedCase extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_42992_InPlacePreservationIsNonEditableForApprovedCase(Hashtable<String,String> data) throws Exception {

        try{

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

        ILiglPage page = new LaunchPage()

                .openBrowser("chrome")
                .navigateURL()
                .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                .caseEditInplace();

        } catch (Exception ex) {
            session.log_Error("TC_42992_InPlacePreservationIsNonEditableForApprovedCase Failed");
            throw new Exception("TC_42992_InPlacePreservationIsNonEditableForApprovedCase Failed", ex);
        } finally {
            session.end();
        }
    }
}
