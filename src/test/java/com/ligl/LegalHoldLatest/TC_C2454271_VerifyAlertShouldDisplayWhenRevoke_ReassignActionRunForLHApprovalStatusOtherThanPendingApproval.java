package com.ligl.LegalHoldLatest;

        import com.ligl.base.TestBase;
        import com.ligl.base.pages.ILiglPage;
        import com.ligl.dataprovider.TestDataProvider;
        import com.ligl.pages.LaunchPage;
        import com.ligl.util.DataUtil;
        import org.testng.SkipException;
        import org.testng.annotations.Test;

        import java.util.Hashtable;

public class TC_C2454271_VerifyAlertShouldDisplayWhenRevoke_ReassignActionRunForLHApprovalStatusOtherThanPendingApproval extends TestBase
{
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_C2454271_VerifyAlertShouldDisplayWhenRevoke_ReassignActionRunForLHApprovalStatusOtherThanPendingApproval(Hashtable<String, String> data) throws Exception
    {
        testCaseId="2454271";
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("NotInitiatedLHname"))
                    .clickOnLHCheckbox(data.get("NotInitiatedLHname"))
                    .clickOnActionDropDownAndRun(data.get("ReAssignAction"))
                    .revokeReassignNotInitiatedLH()
                    //.clickOnLHCheckbox(data.get("NotInitiatedLHname"))
                    .clickOnActionDropDownAndRun(data.get("RevokeAction"))
                    .revokeReassignNotInitiatedLH()
                    .searchRequiredLegalHoldName(data.get("ApprovedLHname"))
                    .clickOnLHCheckbox(data.get("ApprovedLHname"))
                    .revokeReassignNotInitiatedLH();


        }catch (Exception ex){
            session.log_Error("TC_C2454271_VerifyAlertShouldDisplayWhenRevoke_ReassignActionRunForLHApprovalStatusOtherThanPendingApproval");
            throw new Exception("TC_C2454271_VerifyAlertShouldDisplayWhenRevoke_ReassignActionRunForLHApprovalStatusOtherThanPendingApproval", ex);
        }finally {
            session.end();
        }
    }
}
