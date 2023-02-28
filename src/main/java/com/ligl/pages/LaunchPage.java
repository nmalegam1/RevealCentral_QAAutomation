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
//		getDriver().navigate(getSession().ge.getProperty("appURL"));
		getDriver().navigate(getSession().getSmokeData("URL"));
		getSession().log_Pass("Navigated to "+ getSession().getSmokeData("URL"));
		waitForPageToLoad();
		return new LoginPage();
	}

}
