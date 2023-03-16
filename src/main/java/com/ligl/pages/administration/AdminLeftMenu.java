package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AdminLeftMenu extends LiglBasePage {

    @FindBy(xpath = "//i[@class='fa fa-bars']")
    public WebElement collapseLink;

    @FindBy(xpath = "//i[@class='fa fa-expand']")
    public WebElement expandLink;
    @FindBy(id = "AdminGeneral")
    public WebElement adminGeneralLink;

    @FindBy(id = "AdminLegal Hold")
    public WebElement adminLegalHoldLink;

    @FindBy(xpath = "//span[@title='Users and Roles']")
    public WebElement UsersRolesLink;

    @FindBy(xpath = "//span[@title='Contacts Master']")
    public WebElement contactsMasterLink;

    @FindBy(xpath = "//span[@title='Employee Master']")
    public WebElement employeeMasterLink;

    @FindBy(xpath = "//span[@title='Parties']")
    public WebElement partiesLink;

    @FindBy(xpath = "//span[@title='Email Templates']")
    public WebElement emailTemplatesLink;

    @FindBy(xpath = "//span[@title='Case Settings']")
    public WebElement caseSettingsLink;

    @FindBy(xpath = "//span[@title='Lookup Manager']")
    public WebElement lookupManagerLink;

    @FindBy(xpath = "//span[@title='Stakeholder']")
    public WebElement stakeholderLink;

    @FindBy(xpath = "//span[@title='Legal Hold Templates']")
    public WebElement legalHoldTemplatesLink;

    @FindBy(xpath = "//span[@title='Manage QuestionBank']")
    public WebElement manageQuestionBankLink;

    @FindBy(xpath = "//span[@title='Manage QuestionTemplates']")
    public WebElement manageQuestionTemplatesLink;

    @FindBy(xpath = "//span[@title='Escalation and Reminder']")
    public WebElement escalationAndReminderLink;

    @FindBy(xpath = "//span[@title='Manage Display Content']")
    public WebElement manageDisplayContentLink;

    public AdminLeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public AdminLeftMenu() {

    }

    public ILiglPage sideMeanuCollapse() {
        getSession().log_Info("Click on Side Meanu 'Collapse' Icon");
        getDriver().waitForelementToBeClickable(collapseLink);
        collapseLink.click();
        getSession().log_Pass("Clicked on Side Meanu 'Collapse' Icon");
        return new AdminLeftMenu();
    }

    public ILiglPage sideMeanuExpand() {
        getSession().log_Info("Click on Side Meanu 'Expand' Icon");
        getDriver().waitForelementToBeClickable(expandLink);
        expandLink.click();
        getSession().log_Pass("Clicked on Side Meanu 'Expand' Icon");
        return this;
    }

    public ILiglPage clickOnAdminGeneral() {
        /*getSession().log_Info("Click on Admin General");
        getDriver().waitForelementToBeClickable(adminGeneralLink);
        adminGeneralLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on Admin General");*/
        return new ContactMasterPage();
    }

    public ILiglPage clickOnAdminLegalHold() {
        getSession().log_Info("Click on Admin Legal Hold");
        getDriver().waitForelementToBeClickable(adminLegalHoldLink);
        adminLegalHoldLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on Legal Hold");
        return new ContactMasterPage();
    }


    public ILiglPage clickOnUserAndRolesLink() {
        getSession().log_Info("Click on Users And Roles");
        getDriver().waitForelementToBeClickable(UsersRolesLink);
        UsersRolesLink.click();
        //getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on Users And Roles");
        return new UsersAndRolesPage();
    }

    public ILiglPage clickOnContactsMaster() {
        getSession().log_Info("Click on 'Contacts Master'");
        getDriver().waitForelementToBeClickable(contactsMasterLink);
        contactsMasterLink.click();
        getSession().log_Pass("Clicked on 'Contacts Master'");
        return new ContactMasterPage();
    }

    public ILiglPage clickOnEmployeeMaster() {
        getSession().log_Info("Click on 'Employee Master'");
        getDriver().waitForelementToBeClickable(employeeMasterLink);
        employeeMasterLink.click();
        getSession().log_Pass("Clicked on 'Employees Master'");
        return new EmployeeMasterPage();
    }

    public ILiglPage clickOnPartiesLink() {
        getSession().log_Info("Click on 'Parties'");
        getDriver().waitForelementToBeClickable(partiesLink);
        partiesLink.click();
        getSession().log_Pass("Clicked on 'Parties'");
        wait(2);
        return new PartiesPage();
    }

    public ILiglPage clickOnEmailTemplatesLink() {
        getSession().log_Info("Click on Email Templates");
        getDriver().waitForelementToBeClickable(emailTemplatesLink);
        emailTemplatesLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clikced on Email Tempaltes");
        return new EmailTemplatePage();
    }

    public ILiglPage clickOnCaseSettingsLink() {
        getSession().log_Info("Click on Case Settings");
        getDriver().waitForelementToBeClickable(caseSettingsLink);
        caseSettingsLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clikced on Case Settings");
        return new CaseSettingsPage();
    }

    public ILiglPage clickOnLookupManagerLink() {
        getSession().log_Info("Click on Lookup Manager");
        getDriver().waitForelementToBeClickable(lookupManagerLink);
        lookupManagerLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clikced on Lookup Manager");
        return new LookupManagerPage();
    }

    public ILiglPage clickOnStakeholderLink() {
        getSession().log_Info("Click On Stakeholder");
        getDriver().waitForelementToBeClickable(stakeholderLink);
        stakeholderLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getDriver().waitUntilSpinnerIsClosed();
        getSession().log_Pass("Clicked On Stakeholder");
        return new StakeHoldersPage();
    }

    public ILiglPage clickOnManageQuestionBankPageLink() {
        getSession().log_Info("Click On Manage Question Bank Link");
        getDriver().waitForelementToBeClickable(manageQuestionBankLink);
        manageQuestionBankLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getDriver().waitUntilSpinnerIsClosed();
        getSession().log_Pass("Clicked On Manage Question Bank Link");
        return new ManageQuestionBankPage();
    }

}
