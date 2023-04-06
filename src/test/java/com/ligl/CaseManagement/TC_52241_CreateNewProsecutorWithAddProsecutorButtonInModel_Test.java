package com.ligl.CaseManagement;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 *Case-Courts-Prosecutors-Verifying the functionality of creating new Prosecutors using +Prosecutor button in modal
 */
public class TC_52241_CreateNewProsecutorWithAddProsecutorButtonInModel_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "CaseManagement")
    public void TC_52241_CreateNewProsecutorWithAddProsecutorButtonInModel_Test(Hashtable<String , String> data) throws Exception{
        try{
            session.log_Info(data.get(toString()));
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }
            ILiglPage page = new LaunchPage()
                    .openBrowser("chrome")
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("Entity"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .searchCourt(data.get("CourtName"))
                    .navigateToProsecutor()
                    .createNewProsecutor(data.get("CounselFN"),data.get("CounselLN"))
                    .searchCourt(data.get("CourtName"))
                    .navigateToProsecutor()
                    .validateProsecutorAddedToGrid(data.get("CounselFN"),data.get("CounselLN"));

        }catch (Exception | Error ex){
            throw new Exception("TC_52241_CreateNewProsecutorWithAddProsecutorButtonInModel_Test Failed");
        }
    }
}