package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_10305_VerifyUserIsAbleToViewCaseDocumentInNewTab extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void TC_10305_VerifyUserIsAbleToViewCaseDocumentInNewTab(Hashtable<String, String> data) throws Exception {

        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent report
                session.skipTest("skipping the test as runmode was no");
                // skip-testng
                throw new SkipException("Skipping the test as Runmode Was No");
            }
            // Create new template using +template button for case approval category

            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .goToCaseDocument()
                    .searchRequiredCaseDocument(data.get("CaseDocument"))
                    .clickOnCaseDocument(data.get("CaseDocument"));


        } catch (Exception ex) {
            session.log_Error("TC_10305_VerifyUserIsAbleToViewCaseDocumentInNewTab Failed");
            throw new Exception("TC_10305_VerifyUserIsAbleToViewCaseDocumentInNewTab Failed", ex);
        } finally {
            session.end();
        }
    }
}
