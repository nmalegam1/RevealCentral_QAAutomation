package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.Constants;

public class EnterPasswordPage extends LiglBasePage {

	@FindBy(id="")
	WebElement loginPassword;
	
	@FindBy(xpath="")
	WebElement nextButton;
	
	public ILiglPage submitPassword(String password) {
		log_Info("Submitting Password");
		loginPassword.sendKeys(password);
		nextButton.click();
		waitForPageToLoad();
		
		return new EntitySelectPage();
		
	}
}
