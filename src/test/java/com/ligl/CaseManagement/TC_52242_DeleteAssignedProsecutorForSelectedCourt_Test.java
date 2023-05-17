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
 * Case-Courts-Prosecutors-Verifying the process of Deleting assigned Prosecutors for selected Court
 */
public class TC_52242_DeleteAssignedProsecutorForSelectedCourt_Test extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "CaseManagement")
    public void TC_52242_DeleteAssignedProsecutorForSelectedCourt_Test(Hashtable<String , String> data) throws Exception{
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
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .searchcase(data.get("CaseName"))
                    .GoToCase(data.get("CaseName"))
                    .getLeftMenu()
                    .navigateToCourtPage()
                    .addCourtToCase(data.get("CourtName"))
                    .searchCourt(data.get("CourtName"))
                    .navigateToProsecutor()
                    .addExistingProsecutor(data.get("CounselFullName"))
                    .searchProsecutor(data.get("CounselFN"),data.get("CounselLN"))
                    .deleteProsecutor(data.get("CounselFN"),data.get("CounselLN"));
        }catch (Exception | Error ex){
            throw new Exception("TC_52242_DeleteAssignedProsecutorForSelectedCourt_Test Failed");
        }
    }
}

