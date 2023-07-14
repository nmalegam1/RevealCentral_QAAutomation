package com.ligl.RequestTrackerNew;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class TC_51983_GlobalLevel_VerifyWhetherNonApproved_NotInitiated_PendingApproval_Rejected_ArchivedAndObsoletedProjectsAreNotPopulatingInTheChooseProjectDropdownInCreateRequestPage extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData", description = "RequestTracker")
    public void TC_51983_GlobalLevel_VerifyWhetherNonApproved_NotInitiated_PendingApproval_Rejected_ArchivedAndObsoletedProjectsAreNotPopulatingInTheChooseProjectDropdownInCreateRequestPage(Hashtable<String,String> data) throws Exception {
        try{
            session.log_Info(data.toString());
            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {

                session.skipTest("Skipping the test as Runmode was NO");

                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Ref= new LaunchPage()

                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .loginWithLiglorSSOUser(data.get("IsSSOLogin"),data.get("SSOUsername"), data.get("SSOPassword"),data.get("EntitySelection"),data.get("Username"), data.get("Password"))
                    .getHeader().goToGlobalRequestPage().clickOnAddRequestButton()
                    .clickOnChooseACaseDropDown()
                    .validatingNonApprovedCasesInCaseDropDown(data.get("CaseName1"))
                    .clearActionInCaseDropDown()
                    .validatingNonApprovedCasesInCaseDropDown(data.get("CaseName2"))
                    .clearActionInCaseDropDown()
                    .validatingNonApprovedCasesInCaseDropDown(data.get("CaseName3"))
                    .clearActionInCaseDropDown()
                    .validatingNonApprovedCasesInCaseDropDown(data.get("CaseName4"));


        }catch (Exception ex){
            session.log_Error("TC_51983_GlobalLevel_VerifyWhetherNonApproved_NotInitiated_PendingApproval_Rejected_ArchivedAndObsoletedProjectsAreNotPopulatingInTheChooseProjectDropdownInCreateRequestPage Failed");
            throw new Exception("Exception in TC_51983_GlobalLevel_VerifyWhetherNonApproved_NotInitiated_PendingApproval_Rejected_ArchivedAndObsoletedProjectsAreNotPopulatingInTheChooseProjectDropdownInCreateRequestPage", ex);
        }finally {
            session.end();
        }
    }
}