package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.administration.ContactMasterPage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ligl.base.pages.LiglBasePage;

public class Header extends LiglBasePage {

	@FindBy(xpath="//a[@id='case-tab']")
	public WebElement caseTab;

	@FindBy(xpath="//span[@id='requests-tab']")
	public WebElement requestsTab;

	@FindBy(xpath="//span[@id='job-manager-tab']")
	public WebElement jobManagerTab;

	@FindBy(xpath="//span[@id='reports-tab']")
	public WebElement reportsTab;

	@FindBy(xpath="//span[@id='about-tab']")
	public WebElement aboutTab;

	@FindBy(id="profileDropdown")
	public WebElement userNameLink;

	@FindBy(xpath="//a[@data-action='userLogout']")
	public WebElement logoutLink;

	@FindBy(xpath = "//a[@id='approval-tab']")
	public WebElement approvalTab;
	@FindBy(id="user-profile")
	public WebElement UserProfiles;
	@FindBy(xpath = "//a[@title='Administration']")
	public WebElement AdministrationTab;
	@FindBy(xpath = "//a[@ng-click='vmBase.resetMouseHoverPopUp()']")
	public WebElement SwitchCaseTab;
	@FindBy(id="view-case")
	public WebElement ViewCaseBtn;

	@FindBy(id="custodianprofile-tab")
	public WebElement myHoldsTab;
	@FindBy(id = "switch-case")
	public WebElement SwitchCaseBtn;

	@FindBy(xpath = "//*[@id=\"layout\"]/app-navigation/div/nav/div[2]/a/span/span")
	WebElement ClickonCaseName;

	@FindBy(xpath = "//*[@id=\"switch-case\"]/span")
	WebElement SwitchCase;

	public Header(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}


	public ILiglPage logout() throws Exception {

		try {


			getDriver().waitForelementToBeClickable(userNameLink);
			userNameLink.click();
			getSession().log_Pass("Clicked Username link");
			getDriver().waitForelementToBeClickable(logoutLink);
			logoutLink.click();
			getSession().log_Pass("Clicked logout link");
			waitForPageToLoad();
			getSession().log_Pass("logout successful");
			return new LoginPage();

		}catch (Exception | Error ex){
			log_Error(ex.getMessage());
			throw new Exception("logout() Failed",ex);
		}
	}

	public ILiglPage viewCase() throws Exception{

		try{

			log_Info("switchCase() Started");
			SwitchCaseTab.click();
			Thread.sleep(2000);
			ViewCaseBtn.click();
			return new CaseSummaryPage();

		}catch (Exception ex){
			throw new Exception("Exception in switchCase()");
		}
	}
	public ILiglPage switchCase() throws Exception{
		try{
			log_Info("switchCase() Started");
			Thread.sleep(2000);
			SwitchCaseTab.click();
			Thread.sleep(2000);
			SwitchCaseBtn.click();
			Thread.sleep(5000);
			return new DefaultLandingPage();
		}catch (Exception ex){
			throw new Exception("Exception in switchCase()");
		}
	}
	public ILiglPage checkLoggedInUser(String Username,String role) throws Exception{
		try{
			log_Info("checkLoggedInUser() Started");
			UserProfiles.click();
			Thread.sleep(3000);
			getCurrentDriver().findElement(By.xpath("//div[@aria-labelledby='profileDropdown']//p[@title='"+Username+"']")).isDisplayed();
			getCurrentDriver().findElement(By.xpath("//div[@aria-labelledby='profileDropdown']//p[contains(text(),'"+role+"')]")).isDisplayed();
			log_Pass("LoggedIn User Role Name And Role are checked");
			return new MyHoldsPage();
		}catch (Exception ex){
			log_Error("checkLoggedInUser() Failed");
			throw new Exception("Exception in checkLoggedInUser()",ex);
		}
	}

	public ILiglPage goToApprovalPage(){
		approvalTab.click();
		return new ApprovalPage();
	}

	public ILiglPage goToCasePage() throws Exception {

		Thread.sleep(5000);
		caseTab.click();
		return new DefaultLandingPage();
	}
	public ILiglPage goToAdministrationPage() {
		AdministrationTab.click();
		return new ContactMasterPage();
	}

	public ILiglPage create(String elementText) {

		/*addIcon.click();
		if(elementText.equals("lead")) {
			submenuLead.click();
			return new NewLeadPage();
		}else if(elementText.equals("contacts")) {
			submenuContact.click();
			//return new NewContactPage();
		}else if(elementText.equals("task")) {
			submenuTasks.click();
			//return new NewContactPage();
		}*/
		// report a failure and stop
		return new LiglBasePage();

	}

	public ILiglPage goToAboutPage() {
		aboutTab.click();
		return new AboutPage();
	}

	public ILiglPage goToMyHoldsPage(){
		myHoldsTab.click();
		return new MyHoldsPage();
	}

	public ILiglPage switchCaseFunctionality() throws Exception {

		try{
			log_Info("switchCaseFunctionality() started");
			log_Info("Click On The Case Name For Switch");
			getDriver().waitForelementToBeClickable(ClickonCaseName);
			Thread.sleep(5000);
			ClickonCaseName.click();
			log_Info("Clicked On The Case Name For Switch");
			getDriver().waitForelementToBeClickable(SwitchCase);
			Thread.sleep(3000);
			SwitchCase.click();
			getSession().log_Pass("Clicked On The Switch Case Icon");
			Thread.sleep(5000);
			return new DefaultLandingPage();



		}catch (Exception | Error ex){
			log_Error(ex.getMessage());
			throw new Exception("switchCaseFunctionality() Failed",ex);

		}
	}

}
