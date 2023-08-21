package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserShouldBeAbleToSendScopeItemsForApprovalByClickingSelectAllAboveEachGridInSendForApprovalPopup extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserShouldBeAbleToSendScopeItemsForApprovalByClickingSelectAllAboveEachGridInSendForApprovalPopup(Hashtable<String, String> data) throws Exception {
         testCaseId="2453411";
        try {

            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                session.skipTest("Skipping the test as Runmode was NO");
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .createNewCase(data)
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCase(data.get("Email1"))
                    .getLeftMenu()
                    .navigateToDataSourcesPage()
                    .addingDataSource(data.get("Datasource1"))
                    .addingDataSource(data.get("Datasource2"))
                    .clickOnSaveButton()
                    .getLeftMenu().navigateToDateRangesPage()
                    .addDateRanges(data.get("StartDate1"), data.get("EndDate1"), data.get("DescriptionBox1"))
                    .addDateRanges(data.get("StartDate2"), data.get("EndDate2"), data.get("DescriptionBox2"))
                    .validatingDateRanges()
                    .getLeftMenu()
                    .navigateToKeyWordsPage()
                    .addKeywordsByCustom(data.get("Keywords1"), data.get("Datasource1") )
                    .addKeywordsByCustom(data.get("Keywords2"), data.get("Datasource2"))
                    .validatingKeywords()
                    .getLeftMenu()
                    .goToCaseManagement().getLeftMenu()
                    .goToSecurityPage().sendCaseForApprovalWithAllScope(data.get("BatchName"), data.get("TempName"), data.get("UserName") )
                    .validateCasePendingForApprovalState();


        } catch (Exception ex) {
            session.log_Error("TC_62366_VerifyUserShouldBeAbleToSendScopeItemsForApprovalByClickingSelectAllAboveEachGridInSendForApprovalPopup Failed");
            throw new Exception("TC_62366_VerifyUserShouldBeAbleToSendScopeItemsForApprovalByClickingSelectAllAboveEachGridInSendForApprovalPopup Failed", ex);
        } finally {
            session.end();
        }
    }
}
