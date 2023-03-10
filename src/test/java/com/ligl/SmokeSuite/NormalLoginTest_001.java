package com.ligl.SmokeSuite;

import com.ligl.base.TestBase;
import com.ligl.base.pages.ILiglPage;
import com.ligl.dataprovider.TestDataProvider;
import com.ligl.pages.LaunchPage;
import com.ligl.util.DataUtil;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Hashtable;

public class NormalLoginTest_001 extends TestBase {
    @Test(dataProviderClass = TestDataProvider.class , dataProvider = "getData")
    public void NormalLoginTest_001(Hashtable<String,String> data) throws Exception {
        try {
            session.log_Info(data.toString());
            //DefaultLandingPage defaultPage=new DefaultLandingPage();
            //Header header=new Header(session.getCon().getCurrentDriver());
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
                    .createNewCase(data)
                    .getHeader()
                    .logout();
            //.validator(false).validateTitle(Constants.HOME_PAGE_TITLE)// returns home page object , dont have to stop
            //.validator(false).validateText(Constants.HOMEPAGE_TEXT_LOCATOR,"Your Life's Work, Powered By Our Life's Work")// returns home page object , stop if validation fails
            //.validator(true).validateElementPresence(Constants.LOGIN_LINK_LOCATOR)
            //.submitUsername(username);
		    /*
		    if(page instanceof EnterUsernamePage & userNameValid.equals("Y")) {
		    	// failure
		    	page.validator(true).fail("Could enter valid username "+ userNameValid);
		    }else if(page instanceof EnterPasswordPage  ) {
		    	if(userNameValid.equals("N")) {
		    	// failure
		    	page.validator(true).fail("Able to enter and submit valid username "+ userNameValid);
		    	}else {
		    		//proceed with password entry and login
		    		page.submitPassword(password);
		    		session.log("Password submitted");
		    	}

		    }*/
        }catch (Exception ex){
            session.log_Error("NormalLoginTest_001 Failed");
            throw new Exception("NormalLoginTest_001 Failed", ex);
        }finally {
            session.end();
        }
    }
}
