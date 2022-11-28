package com.ligl.pages;

import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends LiglBasePage {
	@FindBy(id="username")
	WebElement userNameTxt;

	@FindBy(id="password")
	WebElement passwordTxt;

	@FindBy(id="signin-button")
	WebElement signInBtn;
	//sign-in-with-sso

	@FindBy(id="sign-in-with-sso")
	WebElement ssoSignInBtn;

	@Override
	public ILiglPage login(String userName, String password) throws Exception {// 20 elements
		try {
			//log("Enter UserName");
			log_Info("Enter User Name");
			getDriver().waitForelementToBeClickable(userNameTxt);
			userNameTxt.sendKeys(userName);
			getSession().log_Pass("user name entered");
			log_Info("Enter Password");
			//getSession().failTest("failed action");
			getDriver().waitForelementToBeClickable(passwordTxt);
			passwordTxt.sendKeys(password);
			log_Pass("password entered");
			//getSession().log_Pass("password entered");
			//log("Click SignIn button");
			signInBtn.click();
			getSession().log_Pass("Clicked signin button");
			waitForPageToLoad();
			//Check the URL Name
			if (getCurrentDriver().getTitle().contains("Entity Select")) {
				log_Info("EntityPage Loaded");
				return new EntitySelectPage();
			} else //if (getCurrentDriver().getTitle().contains("Cases | Ligl")) {
			{	getDriver().waitForVisibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']"));
				//getDriver().waitForAngularRequestsToComplete();
				log_Info("DefaultLandingPage Loaded");
				return new DefaultLandingPage();
			}
			//return new DefaultLandingPage();
		} catch (Exception | Error ex) {
			log_Error(ex.getMessage());
			throw new Exception("login failed", ex);
		}
	}

	@Override
	public ILiglPage adminLogin(String userName, String password, String entity) throws Exception {// 20 elements
		try {
			//log("Enter UserName");
			log_Info("Enter User Name");
			getDriver().waitForelementToBeClickable(userNameTxt);
			userNameTxt.sendKeys(userName);
			getSession().log_Pass("user name entered");
			log_Info("Enter Password");
			//getSession().failTest("failed action");
			getDriver().waitForelementToBeClickable(passwordTxt);
			passwordTxt.sendKeys(password);
			log_Pass("password entered");
			//getSession().log_Pass("password entered");
			//log("Click SignIn button");
			signInBtn.click();
			getSession().log_Pass("Clicked signin button");
			getDriver().waitForAngularRequestsToComplete();
			Thread.sleep(2000);
			//Check the URL Name
			if (getCurrentDriver().getTitle().contains("Entity Select")) {
				//String url=getCurrentDriver().getCurrentUrl();
				log_Info("EntityPage Loaded");
				//waitForPageToLoad();

				System.out.println("Entity : "+entity);
					if(entity.contains("usa"))
					{
						getCurrentDriver().findElement(By.xpath("//a[@id='entity']/span[contains(text(),'USA')]")).click();
						getDriver().waitForAngularRequestsToComplete();
						//Thread.sleep(3000);
						return new DashboardPage();
					}else if (entity.contains("ind")){
						getCurrentDriver().findElement(By.xpath("//a[@id='entity']/span[contains(text(),'IND')]")).click();
						return new DashboardPage();
					}
			} else if (getCurrentDriver().getCurrentUrl().contains("dashboard/caseinsights")) {
				//getDriver().waitForVisibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']"));
				//getDriver().waitForAngularRequestsToComplete();
				log_Info("DashboardPage Loaded");
				return new DashboardPage();
			}
			return new LiglBasePage();
		} catch (Exception | Error ex) {
			log_Error(ex.getMessage());
			throw new Exception("Admin login failed", ex);
		}
	}

	@Override
	public ILiglPage navigateSSOLoginPage() {// 20 elements
		log_Info("Click SSO Signin button");
		ssoSignInBtn.click();
		getSession().log_Pass("Clicked SSO Signin button");
		//waitForPageToLoad();
		return new SSOLoginPage();
	}
}
