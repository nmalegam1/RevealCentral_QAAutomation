package com.ligl.AdminLatest.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC51903_Check_the_Duplicate_Validation_Message_for_Email_field_in_Stakeholders_Create_and_Edit extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC51903_Check_the_Duplicate_Validation_Message_for_Email_field_in_Stakeholders_Create_and_Edit(Hashtable<String, String> data) throws Exception {
        try{
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
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("Entity"),data.get("Username"), data.get("Password"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToStakeholderPage()
                    .clickOnAddStakeholderButton()
                    .createStakeholder(data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Email"),
                            data.get("Department"), data.get("Category"))
                    .verifyTheDuplicateValidationMessage()

                    //Edit
                    .searchTheStakeholder(data.get("SearchStakeHolderEmail"))
                    .scrollToRightToDoAction(data.get("SearchStakeHolderEmail"))
                    .editExitingStakeholder(data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Email"),
                            data.get("Department"), data.get("Category"), data.get("Status"), data.get("StatusChangeReason"))
                    .verifyTheDuplicateValidationMessage()
                    .getHeader()
                    .logout();

        }catch (Exception ex){
            session.log_Error("TC51903_Check_the_Duplicate_Validation_Message_for_Email_field_in_Stakeholders_Create_and_Edit Failed");
            throw new Exception("TC51903_Check_the_Duplicate_Validation_Message_for_Email_field_in_Stakeholders_Create_and_Edit Failed", ex);
        }finally {
            session.end();
        }
    }
}
