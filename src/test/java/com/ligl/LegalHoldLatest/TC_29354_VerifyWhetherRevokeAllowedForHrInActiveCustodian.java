package com.ligl.LegalHoldLatest;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class
TC_29354_VerifyWhetherRevokeAllowedForHrInActiveCustodian extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_29354_VerifyWhetherRevokeAllowedForHrInActiveCustodian(Hashtable<String, String> data) throws Exception {
        testCaseId="2454169";
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }


            ILiglPage page = new LaunchPage()


                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname")).goToRequiredLegalHoldName(data.get("LHname"))
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRun(data.get("Action1"))
                    .clickOnSendButton()
                    .validateLHNStatus(data.get("LHNstatus"))
                    .getHeader().goToAdministrationPage()
                    .getAdminLeft().navigateToEmployeeMaster()
                    .searchThroughEmail(data.get("Email")).performEditAction(data.get("Employee"))
                    .editEmployeeStatus(data.get("EmpStatus"))
                    .getHeader().viewCase().getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname")).goToRequiredLegalHoldName(data.get("LHname"))
                    .searchActionThroughEmail(data.get("Email"))
                    .clickOnActionDropDownAndRun(data.get("Action2"))
                    .validateLHNStatus(data.get("LHNstatus1"));




        } catch (Exception ex) {
            session.log_Error("TC_29354_VerifyWhetherRevokeAllowedForHrInActiveCustodian Failed");
            throw new Exception("TC_29354_VerifyWhetherRevokeAllowedForHrInActiveCustodian Failed", ex);
        } finally {
            session.end();
        }
    }
}
