package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51752_VerifyFunctionalityOfEditLHNbySelectingNewTemplateCreatedOnFly extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51752_VerifyFunctionalityOfEditLHNbySelectingNewTemplateCreatedOnFly(Hashtable<String,String> data) throws Exception {
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
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHName"))
                    .editExistingLHNWithOnFlyEditOfCustTemp(data.get("LHName"),data.get("NewTempName"),data.get("MailSubject"),data.get("MailContent"));
        } catch (Exception ex) {
            session.log_Error("TC_51752_VerifyFunctionalityOfEditLHNbySelectingNewTemplateCreatedOnFly Failed");
            throw new Exception("TC_51752_VerifyFunctionalityOfEditLHNbySelectingNewTemplateCreatedOnFly Failed", ex);
        } finally {
            session.end();
        }
    }
}
