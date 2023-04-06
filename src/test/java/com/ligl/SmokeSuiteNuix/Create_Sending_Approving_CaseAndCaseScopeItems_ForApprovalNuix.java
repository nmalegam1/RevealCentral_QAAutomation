package com.ligl.SmokeSuiteNuix;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Create_Sending_Approving_CaseAndCaseScopeItems_ForApprovalNuix extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "Smoke")
    public void Create_Sending_Approving_CaseAndCaseScopeItems_ForApprovalNuix(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

                // Create A Case And Sending For Approval


            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .createNewCase(data)
                    .getLeftMenu()
                    .navigateToCustodiansPage()
                    .addCustodianToCaseAtOneTime(data.get("Email1"))
                    .clickOnTheCutsodianCheckBox(data.get("Emp1"))
                    .clickOnFilterButtonOnly()
                    .performClearAction(data.get("Email2"))
                    .clickOnTheCutsodianCheckBox(data.get("Emp2"))
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
                    .clickOnSendForApprovalButton()
                    .clickOnCustodianCheckBoxForApproval(data.get("Emp1"))
                    .clickOnCustodianCheckBoxForApproval(data.get("Emp2"))
                    .clickOnNextButtonForApproval()
                    .clickOnDataSourceCheckBoxForApproval(data.get("DataSource1"))
                    .clickOnDataSourceCheckBoxForApproval(data.get("DataSource2"))
                    .clickOnNextButtonForApproval()
                    .clickOnDateRangesCheckBoxForApproval(data.get("DateRange1"))
                    .clickOnDateRangesCheckBoxForApproval(data.get("DateRange2"))
                    .clickOnNextButtonForApproval()
                    .clickOnKeywordsCheckBoxForApproval(data.get("KeyWords1"))
                    .clickOnKeywordsCheckBoxForApproval(data.get("KeyWords2"))
                    .sendingCaseForApprovalAfterAddingScopeItems(data.get("BatchName"),data.get("UserName"),data.get("EmailTemp"))
                    .getHeader()
                    .goToApprovalPage()
                    .approvingCaseSingleApprover(data.get("CaseNameApprove"))
                    .logout();

        }catch (Exception ex){
            session.log_Error("Create_Sending_Approving_CaseAndCaseScopeItems_ForApprovalNuix Failed");
            throw new Exception("Create_Sending_Approving_CaseAndCaseScopeItems_ForApprovalNuix Failed", ex);
        }finally {
            session.end();
        }
    }
}


