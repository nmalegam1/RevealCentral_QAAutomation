package com.ligl.Others;
import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;
import java.util.Hashtable;
public class TC_28855_RegionSwitch_VerifyWhetherUserIsAbleToSwitchRegionWithoutLoggingOut extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void TC_28855_RegionSwitch_VerifyWhetherUserIsAbleToSwitchRegionWithoutLoggingOut(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
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
                    .getHeader()
                    .switchRegionFunctionality(data.get("SwitchedEntity"))
                    .verifySwitchedRegion(data.get("SwitchedEntity"))
                    .logout();
        }catch (Exception ex){
            session.log_Error("RegionSwitch_VerifyWhetherUserIsAbleToSwitchRegionWithoutLoggingOut Failed");
            throw new Exception("RegionSwitch_VerifyWhetherUserIsAbleToSwitchRegionWithoutLoggingOut Failed", ex);
        }finally {
            session.end();
        }
    }
}
