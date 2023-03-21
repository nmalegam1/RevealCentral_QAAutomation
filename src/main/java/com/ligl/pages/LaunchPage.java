package com.ligl.pages;

import com.ligl.base.pages.LiglBasePage;
import com.ligl.base.pages.ILiglPage;

public class LaunchPage extends LiglBasePage {

    public ILiglPage openBrowser(String browser) {
    	getDriver().openBrowser(browser);
    	return this;
    }
    
	public ILiglPage navigateURL() {
		log_Info("Navigaing to Application URL");

		switch(getSession().getGlobalData("Environment")) {
			case "SIT":
				getDriver().navigate(getSession().getGlobalData("SIT_URL"));
				getSession().log_Pass("Navigated to "+ getSession().getGlobalData("SIT_URL"));
				break;
			case "RT":
				getDriver().navigate(getSession().getGlobalData("RT_URL"));
				getSession().log_Pass("Navigated to "+ getSession().getGlobalData("RT_URL"));
				break;
		}
		waitForPageToLoad();
		return new LoginPage();
	}

}
