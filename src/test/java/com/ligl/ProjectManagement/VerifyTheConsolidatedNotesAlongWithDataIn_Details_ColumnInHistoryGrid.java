package com.ligl.ProjectManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class VerifyTheConsolidatedNotesAlongWithDataIn_Details_ColumnInHistoryGrid extends TestBase {

    @Test(dataProviderClass = TestDataProvider.class, dataProvider = "getData", description = "ProjectManagement")
    public void VerifyTheConsolidatedNotesAlongWithDataIn_Details_ColumnInHistoryGrid(Hashtable<String, String> data) throws Exception {
        testCaseId="2453341,2453477";
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
                    .searchcase(data.get("PROJECT")).GoToCase(data.get("PROJECT"))
                    .getLeftMenu()
                    .navigateToNotesHistoryPage()
                    .ValidateDefaultValueInTypeofEventDropdown(data.get("DROPDOWNVALUE"))
                    .displayingSelectedNotesList(data.get("TOEDrpDwnValue1"))
                    .displayingSelectedNotesList(data.get("TOEDrpDwnValue2"))
                    .displayingSelectedNotesList(data.get("TOEDrpDwnValue3"))
                    .displayingSelectedNotesList(data.get("TOEDrpDwnValue4"))
                    .displayingSelectedNotesList(data.get("TOEDrpDwnValue5"));


        } catch (Exception ex) {
            session.log_Error("VerifyTheConsolidatedNotesAlongWithDataIn_Details_ColumnInHistoryGrid Failed");
            throw new Exception("VerifyTheConsolidatedNotesAlongWithDataIn_Details_ColumnInHistoryGrid Failed", ex);
        } finally {
            session.end();
        }
    }
}
