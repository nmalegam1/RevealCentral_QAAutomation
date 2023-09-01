package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_14720_VerifyDataSentByDateInLHNforCustodianAndStakeholder extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "LegalHold")
    public void TC_14720_VerifyDataSentByDateInLHNforCustodianAndStakeholder(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("skipping the test as runmode was no");

                throw new SkipException("Skipping the test as Runmode Was No");
            }

            // Verifying The Columns In The LHN Custodian Grid

            ILiglPage page = new LaunchPage()

                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname1")).goToRequiredLegalHoldName(data.get("LHname1"))
                    .searchActionThroughEmail(data.get("Email"))
                    .verifySentByAndSentOnData(data.get("SentBy"), data.get("SentOn") )
                    .switchOnToTheStakeHolderTab()
                    .searchActionThroughEmail(data.get("Email"))
                    .verifySentByAndSentOnData(data.get("SentBy"), data.get("SentOn") );


        } catch (Exception ex) {
            session.log_Error("TC_14720_VerifyDataSentByDateInLHNforCustodianAndStakeholder Failed");
            throw new Exception("TC_14720_VerifyDataSentByDateInLHNforCustodianAndStakeholder Failed", ex);
        } finally {
            session.end();
        }
    }
}
