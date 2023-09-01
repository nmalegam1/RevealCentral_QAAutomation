package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyUserAbleToCreateAnyNumberOfKeywordsForProjectUsingAddKeywordsButtonByChoosingBasicOption extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyUserAbleToCreateAnyNumberOfKeywordsForProjectUsingAddKeywordsButtonByChoosingBasicOption(Hashtable<String, String> data) throws Exception {
         testCaseId="2453467";
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
                    .RCLogin(data.get("LoginUser"), data.get("Entity"))
                    .searchcase(data.get("CaseName")).GoToCase(data.get("CaseName"))
                    .getLeftMenu().navigateToKeyWordsPage()
                    .addKeywordsByBasic(data.get("Keywords1"))
                    .addKeywordsByBasic(data.get("Keywords2"))
                    .validatingKeywordsByKeywordType()
                    .logout();


        } catch (Exception ex) {
            session.log_Error("TC_35057_VerifyUserAbleToCreateAnyNumberOfKeywordsForProjectUsingAddKeywordsButtonByChoosingBasicOption Failed");
            throw new Exception("TC_35057_VerifyUserAbleToCreateAnyNumberOfKeywordsForProjectUsingAddKeywordsButtonByChoosingBasicOption Failed", ex);
        } finally {
            session.end();
        }
    }
}


