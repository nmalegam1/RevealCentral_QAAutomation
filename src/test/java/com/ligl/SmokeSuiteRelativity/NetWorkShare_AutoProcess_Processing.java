package com.ligl.SmokeSuiteRelativity;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class NetWorkShare_AutoProcess_Processing extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Smoke")
    public void NetWorkShare_AutoProcess_Processing(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Initiate Auto Process UpTo Collection

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("Username"), data.get("Password"), data.get("EntitySelection"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToDSIPage()
                    .addingDSToDSIThroughCustom(data.get("Emp"),data.get("Datasource"),data.get("SourcePath"), data.get("DataHold"))
                    .searchAccountEmailRecordInDSI(data.get("Email"))
                    .automateRecordInDSI()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteCollection(data.get("CollectionStatus"))
                    .getLeftMenu().goToPMSummaryPage()
                    .validateAndWaitForRecordsToCompleteProcessing(data.get("Pstatus"))
                    .logout();


        } catch (Exception ex) {
            session.log_Error("NetWorkShare_AutoProcess_Processing Failed");
            throw new Exception("NetWorkShare_AutoProcess_Processing Failed", ex);
        } finally {
            session.end();
        }
    }
}