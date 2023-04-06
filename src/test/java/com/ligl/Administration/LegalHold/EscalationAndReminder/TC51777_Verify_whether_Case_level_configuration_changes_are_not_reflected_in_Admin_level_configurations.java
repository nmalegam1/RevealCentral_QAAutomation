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
                    .SSOLogin(data.get("EmailId"), data.get("Password"), data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToLegalHoldPage()
                    .clickOnAddNewLegalHoldButton()
                    .createLegalHoldWithEscalationAndReminderConfigurations(data)
                    .getReminderConfigurationsValuesInLegalHoldAtCaseLevel(data.get("legalHoldName"),"TC51777_reminderDays",
                            "TC5177_reminderFrequency","TC5177_reminderMailCap")
                    .getEscalationConfigurationsValuesInLegalHoldAtCaseLevel("TC5177_escalationDay",
                            "TC5177_escalationFrequency", "TC5177_escalationMailsCap")
                    //Admin level configuration
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .clickOnAdminLegalHold()
                    .getAdminLeft()
                    .clickOnEscalationAndReminderPageLink()
                    .checkThatReminderConfigurationsInLegalHoldAtAminLevel(session.getSmokeData("TC51777_reminderDays"),
                            session.getSmokeData("TC5177_reminderFrequency"), session.getSmokeData("TC5177_reminderMailCap"))
                    .checkThatEscalationConfigurationsInLegalHoldAtAminLevel(session.getSmokeData("TC5177_escalationDay"),
                            session.getSmokeData("TC5177_escalationFrequency"),session.getSmokeData("TC5177_escalationMailsCap"))
                    .getHeader()
                    .logout();
        } catch (Exception ex) {
            session.log_Error("TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations Failed");
            throw new Exception("TC51777_Verify_whether_Case_level_configuration_changes_are_not_reflected_in_Admin_level_configurations Failed", ex);
        } finally {
            session.end();
        }
    }
}
