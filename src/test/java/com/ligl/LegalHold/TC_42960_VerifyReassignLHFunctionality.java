package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_42960_VerifyReassignLHFunctionality extends TestBase
{

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_42960_VerifyReassignLHFunctionality(Hashtable<String, String> data) throws Exception
    {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Check That Any Added Custodian Should Not Be Displayed In LHN Or In DSI Page Untill Approved

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .validateLHStatus(data.get("Status"))
                    .clickOnLHCheckbox(data.get("LHname"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .selectTemplateAndApproverAndClickOnSendBtn(data.get("Template1"),data.get("ApproverName"))
                    .secondSearch(data.get("LHname"))
                    .validateLHStatus(data.get("Status"));


        }catch (Exception ex){
            session.log_Error("TC_42960_VerifyReassignLHFunctionality");
            throw new Exception("TC_42960_VerifyReassignLHFunctionality Failed", ex);
        }finally {
            session.end();
        }
    }
}