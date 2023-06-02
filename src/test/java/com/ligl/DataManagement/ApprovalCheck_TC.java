package com.ligl.DataManagement;

        import com.ligl.base.TestBase;
        import com.ligl.base.pages.ILiglPage;
        import com.ligl.dataprovider.TestDataProvider;
        import com.ligl.pages.GoogleVaultPage;
        import com.ligl.pages.LaunchPage;
        import com.ligl.util.DataUtil;
        import org.testng.SkipException;
        import org.testng.annotations.Test;

        import java.util.Hashtable;

public class ApprovalCheck_TC extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void ApprovalCheck_TC(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"),data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BchName"),data.get("Apptemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .enterNameOfTheLH(data.get("LHName"))
                    .clickOnNextBtn1()
                    .enterCustodianNoticeTemplate(data.get("CustTemp"))
                    .clickOnNextBtn2()
                    .clickOnNextBtn3()
                    .clickOnNextBtn4()
                    .clickOnNextBtn5()
                    .clickOnNextBtn6()
                    .clickOnSaveBtn()
                    .legalHoldApprovalIrrespectiveOfApprovalConfig(data.get("LHName"), data.get("LHAction"), data.get("ApprvlTemp"), data.get("ApprvlUN"), data.get("ApprvlRecord"));

        } catch (Exception ex) {
            session.log_Error("GSuite_Validation Failed");
            throw new Exception("GSuite_Validation Failed", ex);
        } finally {
            session.end();
        }
    }
}