package com.ligl.Administration.LegalHold.ManageQuestionBank;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC51773_Check_AppliesTo_field_is_NonEditable_in_EditQuestion_for_Parent_and_Child_questions extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "Administration")
    public void TC51773_Check_AppliesTo_field_is_NonEditable_in_EditQuestion_for_Parent_and_Child_questions(Hashtable<String, String> data) throws Exception {
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
                    .adminLogin(data.get("Username"), data.get("Password"), data.get("Entity"))
                    .getHeader()
                    .goToAdministrationPage()
                    .getAdminLeft()
                    .navigateToManageQuestionBankPage()
                    .searchTheQuestion(data.get("ParentQuestion"))
                    .scrollToRightToDoActionInManageQuestionGrid(data.get("ParentQuestion"))
                    .clickOnEditInQuestionGrid()
                    .checkAppliesToIsNonEditableField()
                    .refreshTheManageQuestionBankPage()
                    .searchChildQuestion(data.get("ChildQuestion"))
                    .clickOnEditInQuestionGrid()
                    .checkAppliesToIsNonEditableField()
                    .getHeader()
                    .logout();

        }catch (Exception | Error ex){
            session.log_Error("TC51773_Check_AppliesTo_field_is_NonEditable_in_EditQuestion_for_Parent_and_Child_questions Failed");
            throw new Exception("TC51773_Check_AppliesTo_field_is_NonEditable_in_EditQuestion_for_Parent_and_Child_questions Failed", ex);
        }
    }
}
