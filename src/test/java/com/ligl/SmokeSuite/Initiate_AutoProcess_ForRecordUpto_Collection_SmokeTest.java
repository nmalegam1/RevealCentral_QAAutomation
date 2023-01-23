package com.ligl.SmokeSuite;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.util.Hashtable;

public class Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTest extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData")
    public void Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTest(Hashtable<String, String> data) throws Exception {

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
                    .login(data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .goToDSIPage()
                    .addDataSourceRecordToDSIGrid(data.get("Custodian"),data.get("DataSource"), data.get("DataHold"))
                    .automateRecordInDSI()
                    .getLeftMenu().goToDataManagementSummary()
                    .waitAndvalidateForRecordToCompleteCollection(data.get("CollectionStatus"));


        } catch (Exception ex) {
            session.log_Error("Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTest Failed");
            throw new Exception("Initiate_AutoProcess_ForRecordUpto_Collection_SmokeTest Failed", ex);
        } finally {
            session.end();
        }
    }
}