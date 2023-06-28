package com.ligl.SmokeSuiteSP;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Case_Create_ApproveFor_ServiceProvider extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "SmokeSuiteSP")
    public void Case_Create_ApproveFor_ServiceProvider(Hashtable<String, String> data) throws Exception {

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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .createNewCaseSP(data)
                   /* .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))*/
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCaseAtOneTime(data.get("Email1"))
                    .clickOnTheCutsodianCheckBox(data.get("CLIENT"))
                    .clickOnFilterButtonOnly()
                    .performClearAction(data.get("Email2"))
                    .clickOnTheCutsodianCheckBox(data.get("CLIENT"))
                    .clickOnAddToCaseButton()
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addingDataSource(data.get("Datasource1"))
                    .addingDataSource(data.get("Datasource2"))
                    .clickOnSaveButton()
                    .getLeftMenu()
                    .navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox"))
                    .addDateRanges(data.get("StartDate2"), data.get("EndDate2"), data.get("DescriptionBox"))
                    .getLeftMenu().navigateToKeyWordsPage()
                    .addKeywordsByBasic(data.get("Keywords1"))
                    .addKeywordsByBasic(data.get("Keywords2"))
                    .getLeftMenu()
                    .goToSecurityPage()
                    .caseApprovalIrrespectiveOfApprovalConfig(data.get("BatchName"),data.get("EmailTemp"),data.get("UserName"),data.get("CaseNameApprove"))
                    .logout();


        } catch (Exception ex) {
            session.log_Error("Case_Create_ApproveFor_ServiceProvider Failed");
            throw new Exception("Case_Create_ApproveFor_ServiceProvider Failed", ex);
        } finally {
            session.end();
        }
    }
}
