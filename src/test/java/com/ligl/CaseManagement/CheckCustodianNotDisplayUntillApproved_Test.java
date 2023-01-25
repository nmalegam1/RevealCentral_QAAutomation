package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class CheckCustodianNotDisplayUntillApproved_Test extends TestBase
{

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void CheckCustodianNotDisplayUntillApproved_Test(Hashtable<String, String> data) throws Exception
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
                    .login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email1"))
                    .getLeftMenu().goToLegalHoldPage().checkLHNForCustodians(data.get("LHN"), data.get("Employee1"))
                    .validateCustodianBeforeApproved()
                    .getLeftMenu().goToDataManagement().checkDSIForCustodians(data.get("Employee1"))
                    .getLeftMenu().goToSecurityPage()
                    .sendingCaseCustodianForApproval(data.get("Employee1"), data.get("BatchNAME"), data.get("USER"), data.get("EMAIL"))
                    .getHeader().goToApprovalPage().approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .getHeader().goToCasePage().searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToLegalHoldPage().checkLHNForCustodians(data.get("LHN"), data.get("Employee1")).validateCustodianAfterApproved(data.get("Employee1"))
                    .getLeftMenu().goToDataManagement().validateDSIForCustodians(data.get("Employee1"));


        }catch (Exception ex){
            session.log_Error("CheckCustodianNotDisplayUntillApproved_Test");
            throw new Exception("CheckCustodianNotDisplayUntillApproved_Test Failed", ex);
        }finally {
            session.end();
        }
    }
}