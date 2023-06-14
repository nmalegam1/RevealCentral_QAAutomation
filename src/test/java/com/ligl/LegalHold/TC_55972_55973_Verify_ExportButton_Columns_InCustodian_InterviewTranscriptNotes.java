package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_55972_55973_Verify_ExportButton_Columns_InCustodian_InterviewTranscriptNotes extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_55972_55973_Verify_ExportButton_Columns_InCustodian_InterviewTranscriptNotes(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());

            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Launch = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(data.get("LHname"))
                    .goToLegalHold(data.get("LHname"))
                    .verifyCustodianInterviewTranscriptNotes();
        } catch (Exception ex) {
            session.log_Error("TC_55972_55973_Verify_ExportButton_Columns_InCustodian_InterviewTranscriptNotes Failed");
            throw new Exception("TC_55972_55973_Verify_ExportButton_Columns_InCustodian_InterviewTranscriptNotes Failed", ex);
        } finally {
            session.end();
        }
    }
}



