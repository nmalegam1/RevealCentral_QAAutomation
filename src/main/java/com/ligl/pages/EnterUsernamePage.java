package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.Constants;
import com.ligl.base.pages.LiglBasePage;


public class EnterUsernamePage extends LiglBasePage {

	@FindBy(id = "")
	WebElement loginUsername;

	@FindBy(xpath = "")
	WebElement nextButton;


	public ILiglPage submitUsername(String userid) {
		waitForPageToLoad();
		loginUsername.sendKeys(userid);
		nextButton.click();

/*		boolean presencePassField = validator(false).isElementPresent(Constants.PASSWORD_LOCATOR);
		System.out.println("presencePassField "+presencePassField);
		if(!presencePassField)
			return this;
		else
			return new EnterPasswordPage();*/
		//validate

		return new EnterPasswordPage();
}
	
	
}
