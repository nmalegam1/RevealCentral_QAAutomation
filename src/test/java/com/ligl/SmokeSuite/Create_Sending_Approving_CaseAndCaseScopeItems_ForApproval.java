package com.ligl.SmokeSuite;

        import com.ligl.base.TestBase;
        import com.ligl.base.pages.ILiglPage;
        import com.ligl.dataprovider.TestDataProvider;
        import com.ligl.pages.LaunchPage;
        import com.ligl.util.DataUtil;
        import org.testng.SkipException;
        import org.testng.annotations.Test;

        import java.util.Hashtable;

public class Create_Sending_Approving_CaseAndCaseScopeItems_ForApproval extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void Create_Sending_Approving_CaseAndCaseScopeItems_ForApproval(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"))
                    .createNewCase(data)
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("CustodianMail"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addDataSource(data.get("DataSource"))
                    .getLeftMenu()
                    .goToSecurityPage()
                    .sendingCaseForApprovalWithScopeItems(data.get("Custodian"),data.get("DataSource1"),data.get("BatchName"),data.get("UserName"),data.get("EmailTemp"))
                    .getHeader()
                    .goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .logout();

        }catch (Exception ex){
            session.log_Error("Create_Sending_Approving_CaseAndCaseScopeItems_ForApproval Failed");
            throw new Exception("Create_Sending_Approving_CaseAndCaseScopeItems_ForApproval Failed", ex);
        }finally {
            session.end();
        }
    }
}


