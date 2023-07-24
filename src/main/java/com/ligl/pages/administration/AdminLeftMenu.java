package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//span[@title='Employee Directory']")
    public WebElement employeeMasterLink;

    @FindBy(xpath = "//span[@title='Parties']")
    public WebElement partiesLink;

    @FindBy(xpath = "//span[@title='Email Templates']")
    public WebElement emailTemplatesLink;

    @FindBy(xpath = "//span[@title='Project Settings']")
    public WebElement caseSettingsLink;

    @FindBy(xpath = "//span[@title='Lookup Manager']")
    public WebElement lookupManagerLink;

    @FindBy(xpath = "//span[@title='Stakeholder']")
    public WebElement stakeholderLink;

    @FindBy(xpath = "//span[@title='Legal Hold Templates']")
    public WebElement legalHoldTemplatesLink;

    @FindBy(xpath = "//span[@title='Manage QuestionBank']")
    public WebElement manageQuestionBankLink;

    @FindBy(xpath = "//span[@title='Manage Questionnaire Templates']")
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
        return this;
    }

    public ILiglPage sideMeanuExpand() {
        getSession().log_Info("Click on Side Meanu 'Expand' Icon");
        getDriver().waitForelementToBeClickable(expandLink);
        expandLink.click();
        getSession().log_Pass("Clicked on Side Meanu 'Expand' Icon");
        return this;
    }

    public ILiglPage clickOnAdminGeneral() throws Exception {
        try {
            getSession().log_Info("Click on Admin General");
            getDriver().waitForelementToBeClickable(adminGeneralLink);
            adminGeneralLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Admin General");
            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Admin General Link Failed", ex);
        }
    }

    public ILiglPage clickOnAdminLegalHoldLink() throws Exception {
        try {
            getSession().log_Info("Click on Admin Legal Hold");
            getDriver().waitForelementToBeClickable(adminLegalHoldLink);
            adminLegalHoldLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Legal Hold");
            return new ContactMasterPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Admin LegalHold Link Failed", ex);
        }
    }


    public ILiglPage navigateToUserAndRolesPage() throws Exception {
        try {

            try {
                if (UsersRolesLink.isDisplayed()) {

                    log_Info("Click on users and roles");
                    getDriver().waitForelementToBeClickable(UsersRolesLink);
                    Thread.sleep(5000);
                    UsersRolesLink.click();
                    log_Info("Clicked on users and roles tab");
                }
                else
                    throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!UsersRolesLink.isDisplayed()) {
                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on users and roles tab");
                    getDriver().waitForelementToBeClickable(UsersRolesLink);
                    Thread.sleep(5000);
                    UsersRolesLink.click();
                    log_Info("Clicked on users and roles tab");
                }
            }
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To User And Roles Failed", ex);
        }
    }

    public ILiglPage navigateToContactsMasterPage() throws Exception {
        try {
            getSession().log_Info("Navigate to 'Contacts Master' Page");
            getDriver().waitForelementToBeClickable(contactsMasterLink);
            contactsMasterLink.click();
            getSession().log_Pass("Navigated to 'Contacts Master' Page");
            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Contacts Master Page Failed", ex);
        }
    }

    public ILiglPage navigateToEmployeeMaster() throws Exception {
        try {
            try {
                if (employeeMasterLink.isDisplayed()) {

                    log_Info("Click on Employee master");
                    getDriver().waitForelementToBeClickable(employeeMasterLink);
                    Thread.sleep(5000);
                    employeeMasterLink.click();
                    log_Info("Clicked on Employee master tab");
                }
                else
                    throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!employeeMasterLink.isDisplayed()) {
                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on Employee master tab");
                    getDriver().waitForelementToBeClickable(employeeMasterLink);
                    Thread.sleep(5000);
                    employeeMasterLink.click();
                    log_Info("Clicked on Employee master tab");
                }
            }
            return new EmployeeMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Employee Master Page Failed", ex);
        }
    }

    public ILiglPage navigateToPartiesPage() throws Exception {
        try {
            try {
                if (partiesLink.isDisplayed()) {

                    log_Info("Click on parties tab");
                    getDriver().waitForelementToBeClickable(partiesLink);
                    Thread.sleep(5000);
                    partiesLink.click();
                    log_Info("Clicked on parties tab");
                }
                else
                    throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!partiesLink.isDisplayed()) {
                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on Parties tab");
                    getDriver().waitForelementToBeClickable(partiesLink);
                    Thread.sleep(5000);
                    partiesLink.click();
                    log_Info("Clicked on Parties tab");
                }
            }
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Parties Page Failed", ex);
        }
    }

    public ILiglPage navigateToEmailTemplatesPage() throws Exception {
        try {
            try {
                if (emailTemplatesLink.isDisplayed()) {

                    log_Info("Click on Email Templates");
                    getDriver().waitForelementToBeClickable(emailTemplatesLink);
                    Thread.sleep(5000);
                    emailTemplatesLink.click();
                    log_Info("Clicked on Email Templates tab");
                }
                else
                    throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!emailTemplatesLink.isDisplayed()) {
                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on Email Templates tab");
                    getDriver().waitForelementToBeClickable(emailTemplatesLink);
                    Thread.sleep(5000);
                    emailTemplatesLink.click();
                    log_Info("Clicked on Email Templates tab");
                }
            }
            return new EmailTemplatePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Email Templates Page Failed", ex);
        }
    }

    public ILiglPage navigateToCaseSettingsPage() throws Exception {
        try {

            try {
                   if(caseSettingsLink.isDisplayed()) {
                       log_Info("Click on Project Settings Template");
                       getDriver().waitForelementToBeClickable(caseSettingsLink);
                       Thread.sleep(5000);
                       caseSettingsLink.click();
                       log_Info("Clicked on Project Settings Template");
                   }else
                       throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!caseSettingsLink.isDisplayed()) {

                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on Project Settings Template");
                    getDriver().waitForelementToBeClickable(caseSettingsLink);
                    Thread.sleep(5000);
                    caseSettingsLink.click();
                    log_Info("Clicked on Project Settings Template");
                }
            }
            return new CaseSettingsPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Case Settings Page Failed", ex);
        }
    }

    public ILiglPage navigateToLookupManagerPage() throws Exception {
        try {

            try {
                if (lookupManagerLink.isDisplayed()) {

                    log_Info("Click on lookup manager");
                    getDriver().waitForelementToBeClickable(lookupManagerLink);
                    Thread.sleep(5000);
                    lookupManagerLink.click();
                    log_Info("Clicked on lookup manager tab");
                }
                else
                    throw new NoSuchElementException("");
            } catch (NoSuchElementException e) {

                if (!lookupManagerLink.isDisplayed()) {
                    log_Info("Click on General Tab");
                    getDriver().waitForelementToBeClickable(adminGeneralLink);
                    adminGeneralLink.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("General tab clicked");

                    log_Info("Click on lookup Manager tab");
                    getDriver().waitForelementToBeClickable(lookupManagerLink);
                    Thread.sleep(5000);
                    lookupManagerLink.click();
                    log_Info("Clicked on lookup manager tab");
                }
            }
            return new LookupManagerPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Lookup Manager Page Failed", ex);
        }
    }

    public ILiglPage navigateToStakeholderPage() throws Exception {
        try {
            clickOnAdminLegalHoldLink();

            getSession().log_Info("Navigate to 'Stakeholder' Page");
            getDriver().waitForelementToBeClickable(stakeholderLink);
            stakeholderLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitUntilSpinnerIsClosed();
            getSession().log_Pass("Navigated to 'Stakeholder' Page");
            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Stakeholder Page Failed", ex);
        }
    }

    public ILiglPage navigateToManageQuestionBankPage() throws Exception {
        try {
            clickOnAdminLegalHoldLink();

            getSession().log_Info("Navigate To 'Manage Question Bank' Page");
            getDriver().waitForelementToBeClickable(manageQuestionBankLink);
            manageQuestionBankLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitUntilSpinnerIsClosed();
            getSession().log_Pass("Navigated to 'Manage Question Bank' Page");
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Manage Question Bank Page Failed", ex);
        }
    }

    public ILiglPage navigateToManageQuestionnaireTemplatesPage() throws Exception {
        try {
            clickOnAdminLegalHoldLink();

            getSession().log_Info("Navigate To 'Manage Questionnaire Templates' Page");
            getDriver().waitForelementToBeClickable(manageQuestionTemplatesLink);
            manageQuestionTemplatesLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Navigated To 'Manage Questionnaire Templates' Page");
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Manage Questionnaire Templates Page Failed", ex);
        }
    }

    public ILiglPage navigateToEscalationAndReminderPage() throws Exception {
        try {
            clickOnAdminLegalHoldLink();

            getDriver().waitForelementToBeClickable(escalationAndReminderLink);
            getSession().log_Info("Navigate To 'Escalation And Reminder' Page");
            escalationAndReminderLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Navigated To 'Escalation And Reminder' Page");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Escalation And Reminder Page Failed", ex);
        }
    }

    public ILiglPage navigateToManageDisplayContentPage() throws Exception {
        try {
            clickOnAdminLegalHoldLink();

            getDriver().waitForelementToBeClickable(manageDisplayContentLink);
            getSession().log_Info("Navigate To 'Manage Display Content' Page Link");
            manageDisplayContentLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Navigated To 'Manage Display Content' Page");
            return new ManageDisplayContentPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Navigate To Manage Display Content Page Failed", ex);
        }
    }

}
