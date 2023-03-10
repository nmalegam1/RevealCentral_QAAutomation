package com.ligl.LegalHold;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

/**
 * 47403- Verify the Availability of 'Custodian' Role in Users & Roles->Roles Assigned dropdown
 */
public class TC_50432_Verify_AvailabilityOf_CustodianRoleIn_RolesDPIn_UsersAndRoles  extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class,dataProvider = "getData")
    public void TC_50432_Verify_AvailabilityOf_CustodianRoleIn_RolesDPIn_UsersAndRoles(Hashtable<String,String>data) throws Exception {
        try {
            session.log_Info(data.toString());

            if (!new DataUtil().isRunnable(testName, xls) || data.get("Runmode").equals("N")) {
                // skip in extent rep
                session.skipTest("Skipping the test as Runmode was NO");
                //skip - testng
                throw new SkipException("Skipping the test as Runmode was NO");
            }

            ILiglPage Launch = new LaunchPage()
                    .openBrowser(data.get("Browser"))
                    .navigateURL()
                    .login(data.get("Username"), data.get("Password"),data.get("EntitySelection"))
                    .getHeader()
                    .goToAdministrationPage()
                    .goToUsersRoles()
                    .checkCustodianRoleInUserCreationPopUp(data.get("Role"));
        } catch (Exception ex) {
            session.log_Error("TC_50432_Verify_AvailabilityOf_CustodianRoleIn_RolesDPIn_UsersAndRoles Failed");
            throw new Exception("TC_50432_Verify_AvailabilityOf_CustodianRoleIn_RolesDPIn_UsersAndRoles Failed", ex);
        } finally {
            session.end();
        }
    }
}