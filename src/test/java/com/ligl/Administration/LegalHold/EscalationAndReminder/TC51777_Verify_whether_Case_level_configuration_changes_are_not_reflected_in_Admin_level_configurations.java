package com.ligl.Administration.LegalHold.EscalationAndReminder;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations(Hashtable<String, String> data) throws Exception{
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
                    //Case level configuration
                    .navigateSSOLoginPage()
                    .SSOLogin(data.get("EmailId"), data.get("Password"), session.getGlobalData("Entity"))
                    .searchcase("QA_Automation_04212023")
                    .GoToCase("QA_Automation_04212023")
                    .getCaseFieldsDataInCaseSummaryPage()
                    .getLeftMenu()
                    .goToSecurityPage()
                    .sendAllForCaseApproval("A12345","CaseApproval","TEST LIGL")
                    /*.searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .createLegalHoldWithEscalationAndReminderConfigurations(data)
                    .getReminderConfigurationsValuesInLegalHoldAtCaseLevel(data.get("legalHoldName"),"TC51777_reminderDays",
                            "TC51777_reminderFrequency","TC51777_reminderMailCap")
                    .getEscalationConfigurationsValuesInLegalHoldAtCaseLevel("TC51777_escalationDay",
                            "TC51777_escalationFrequency", "TC51777_escalationMailsCap")
                    //Admin level configuration
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToEscalationAndReminderPage()
                    .checkThatReminderConfigurationsInLegalHoldAtAminLevel(session.getRegressionData("TC51777_reminderDays"),
                            session.getRegressionData("TC51777_reminderFrequency"), session.getRegressionData("TC51777_reminderMailCap"))
                    .checkThatEscalationConfigurationsInLegalHoldAtAminLevel(session.getRegressionData("TC51777_escalationDay"),
                            session.getRegressionData("TC51777_escalationFrequency"),session.getRegressionData("TC51777_escalationMailsCap"))
                    */.getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations Failed");
            throw new Exception("TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations Failed", ex);
        } finally {
            session.end();
        }
    }
}
