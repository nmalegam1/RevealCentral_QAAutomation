package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51804_56120_VerifyDefaultLHN_DR_KW_DisplayingFromSecondRecordAreEditableInEdit_Irrespective_ApprovalStatus extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData", description = "LegalHold")
    public void TC_51804_56120_VerifyDefaultLHN_DR_KW_DisplayingFromSecondRecordAreEditableInEdit_Irrespective_ApprovalStatus(Hashtable<String,String> data) throws Exception {
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
                    .editLHNCreatedWithDRKW(data.get("LHName1"),data.get("LHName2"),data.get("CustNoticeTemp"),data.get("StartDate"),data.get("EndDate"),data.get("KeyWord"));
        } catch (Exception ex) {
            session.log_Error("TC_51803_VerifyFirstCreatedLH_KW_DR_DisplayedDefaultToRestOfLHs Failed");
            throw new Exception("TC_51803_VerifyFirstCreatedLH_KW_DR_DisplayedDefaultToRestOfLHs Failed", ex);
        } finally {
            session.end();
        }
    }
}
