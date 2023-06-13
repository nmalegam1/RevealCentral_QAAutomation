package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_52341_CheckThatAdditionalScopeItemsAddedToCaseNotVisibleInAddDSUntilTheyApproved extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "CaseManagement")
    public void TC_52341_CheckThatAdditionalScopeItemsAddedToCaseNotVisibleInAddDSUntilTheyApproved(Hashtable<String,String> data) throws Exception {
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    //.addCustodianToCase(data.get("CustodianMail1"))
                    .addCustodianToCase(data.get("CustodianMail2"))
                    .getLeftMenu()
                    .goToSecurityPage().sendingCaseCustodianForApproval(data.get("Custodian1"),data.get("BatchName"),data.get("AppUserName"),data.get("AppTemp"))
                    .getHeader()
                    .approvingCaseSingleApprover(data.get("ApprovalRecord"))
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC_52341_CheckThatAdditionalScopeItemsAddedToCaseNotVisibleInAddDSUntilTheyApproved test Failed");
            throw new Exception("TC_52341_CheckThatAdditionalScopeItemsAddedToCaseNotVisibleInAddDSUntilTheyApproved test Failed", ex);
        }finally {
            session.end();
        }
    }
}
