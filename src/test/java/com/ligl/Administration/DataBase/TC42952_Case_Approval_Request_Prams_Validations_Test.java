package com.ligl.Administration.DataBase;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.db.DataBaseValidations;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC42952_Case_Approval_Request_Prams_Validations_Test extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "DataBase")
    public void TC42952_Case_Approval_Request_Prams_Validations_Test(Hashtable<String, String> data) throws Exception{
        DataBaseValidations dataBase = new DataBaseValidations();
        try {
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testing
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), session.getGlobalData("Entity"))
                    //.createNewProjectWithAllFields(data)
                    .GoToCase("QA_Automation_DBProject_QA05")
                    .getCaseFieldsDataInCaseSummaryPage()
                    .getLeftMenu()
                    .goToSecurityPage()
                    .sendAllForCaseApproval("A12347","CaseApproval","TEST LIGL")
                    .getHeader()
                    .logout();
            dataBase.checkAllParametersReplacingWithActualValueWhenCaseSendForApprovalRequest();
        } catch (Exception ex) {
            session.log_Error("TC42952_Case_Approval_Request_Prams_Validations_Test Failed");
            throw new Exception("TC42952_Case_Approval_Request_Prams_Validations_Test Failed", ex);
        } finally {
            dataBase.closeTheDBConnection();
            session.end();
        }
    }
}
