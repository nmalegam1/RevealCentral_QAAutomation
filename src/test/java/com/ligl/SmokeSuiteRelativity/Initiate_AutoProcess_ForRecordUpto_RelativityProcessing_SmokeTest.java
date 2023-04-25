package com.ligl.SmokeSuiteRelativity;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class Initiate_AutoProcess_ForRecordUpto_RelativityProcessing_SmokeTest extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Smoke")
    public void Initiate_AutoProcess_ForRecordUpto_RelativityProcessing_SmokeTest(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Initiating The Auto Process For Records In Relativity Processing

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToDSIPage()
                    .addDataSourceRecordToDSIGrid(data.get("Emp1"),data.get("Datasource1"), data.get("DataHold"),data.get("DateRange1"), data.get("KeyWords1"))
                    .addDataSourceRecordToDSIGrid(data.get("Emp2"),data.get("Datasource2"), data.get("DataHold"),data.get("DateRange2"), data.get("KeyWords2"))
                    .searchAccountEmailRecordInDSI(data.get("Email1"))
                    .clickOnCheckBoxOfCustodian()
                    .searchAccountEmailOneMoreTime()
                    .sendingAccountEmailOneMorTime(data.get("Email2"))
                    .clickOnCheckBoxOfCustodian()
                    .searchAccountEmailOneMoreTime()
                    .clickOnAutomateButton()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(data.get("CollectionStatus"))
                    .getLeftMenu().goToPMSummaryPage()
                    .validateAndWaitForRecordsToCompleteProcessing(data.get("Pstatus"));


        } catch (Exception ex) {
            session.log_Error("Initiate_AutoProcess_ForRecordUpto_RelativityProcessing_SmokeTest Failed");
            throw new Exception("Initiate_AutoProcess_ForRecordUpto_RelativityProcessing_SmokeTest Failed", ex);
        } finally {
            session.end();
        }
    }
}
