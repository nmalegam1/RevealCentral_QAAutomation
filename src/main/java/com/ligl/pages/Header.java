package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.administration.ContactMasterPage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
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

	@FindBy(xpath = "//a[@title='Administration']")
	public WebElement AdministrationTab;
	@FindBy(xpath = "//a[@ng-click='vmBase.resetMouseHoverPopUp()']")
	public WebElement SwitchCaseTab;
	@FindBy(id="view-case")
	public WebElement ViewCaseBtn;

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

}
