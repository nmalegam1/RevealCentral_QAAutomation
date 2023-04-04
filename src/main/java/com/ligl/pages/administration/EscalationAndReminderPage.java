package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LegalHoldPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EscalationAndReminderPage extends LiglBaseSessionPage {

    @FindBy(id = "btn-edit")
    public WebElement editBtn;

    @FindBy(xpath = "//mat-slide-toggle[@id='reminder-toggle']//span//span")
    public WebElement remainderToggle;

    @FindBy(xpath = "//mat-slide-toggle[@id='escalation-toggle']//span//span")
    public WebElement escalationToggle;

    @FindBy(css = "#number-of-days-before-reminder-escalation")
    public WebElement numberOfDaysBeforeReminderCanBeSentTxt;

    @FindBy(css = "#reminder-frequency-escaltion")
    public WebElement reminderFrequencyTxt;

    @FindBy(css = "#reminder-mails-cap")
    public WebElement reminderMailsCapTxt;

    @FindBy(css = "#escalation-remainder-yes-opt")
    public WebElement stopReminderMailsAfterEscalationYes;

    @FindBy(css = "escalation-remainder-no-opt")
    public WebElement stopReminderMailsAfterEscalationNo;

    @FindBy(id = "select-reminder-email-template-escalation")
    public WebElement reminderEmailTemplateEscalationDrpDwn;

    @FindBy(css = "#number-of-days-after-reminder")
    public WebElement numberOfDaysAfterReminderWhenEscalationCanBeSentTxt;

    @FindBy(css = "#escalation-frequency")
    public WebElement escalationFrequencyTxt;

    @FindBy(css = "#escalation-mails-cap")
    public WebElement escalationMailsCapTxt;

    @FindBy(css = "#select-escalation-email-template")
    public WebElement escalationEmailTemplateDrpDwn;

    @FindBy(css = "#escalation-sent-to")
    public WebElement escalationToBeSentToTxt;

    @FindBy(id = "btn-save")
    WebElement saveBtn;

    @FindBy(id = "btn-undo")
    WebElement undoBtn;

    //Edit
    public ILiglPage clickOnEditButtonInEscalationAndReminder() throws Exception {
        try {
            getSession().log_Info("Click on 'Edit' Button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Edit' Button");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On 'Edit' Button in Escalation And Reminder Failed", ex);
        }
    }

    //Save
    public ILiglPage clickOnSaveButtonInEscalationAndReminder() throws Exception {
        try {
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            getDriver().scrollToView(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On 'Save' Button in Escalation And Reminder Failed", ex);
        }
    }

    //Undo
    public ILiglPage clickOnUndoButtonInEscalationAndReminder() throws Exception {
        try {
            getSession().log_Info("Click on 'Undo' Button");
            getDriver().waitForelementToBeClickable(undoBtn);
            getDriver().scrollToView(undoBtn);
            undoBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Undo' Button");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On 'Undo' Button in Escalation And Reminder Failed", ex);
        }
    }


    //Reminder
    public ILiglPage reminderToggle() throws Exception {
        try {
            getDriver().waitForelementToBeClickable(remainderToggle);
            getSession().log_Info("Click on Remainder Toggle");
            remainderToggle.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Remainder Toggle");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Reminder Toggle Failed", ex);
        }
    }

    //Escalation
    public ILiglPage escalationToggle() throws Exception {
        try {
            getDriver().waitForelementToBeClickable(escalationToggle);
            getSession().log_Info("Click on Escalation Toggle");
            escalationToggle.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Escalation Toggle");
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Escalation Toggle Failed", ex);
        }
    }

    //Reminder Configurations
    public ILiglPage reminderConfigurations(String reminderDays, String reminderFrequency, String reminderMailCap, String stopOption,
                                            String reminderTemplate) throws Exception {
        try {
            //Number of days before reminder can be sent
            getSession().log_Info("Enter Number of days before reminder can be sent");
            getDriver().waitForelementToBeClickable(numberOfDaysBeforeReminderCanBeSentTxt);
            numberOfDaysBeforeReminderCanBeSentTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String reminderDaysNew = reminderDays.replace("*", "");
            numberOfDaysBeforeReminderCanBeSentTxt.sendKeys(reminderDaysNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Number of days before reminder can be sent Entered");

            //Reminder frequency
            getSession().log_Info("Enter Reminder frequency");
            getDriver().waitForelementToBeClickable(reminderFrequencyTxt);
            reminderFrequencyTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String reminderFrequencyNew = reminderFrequency.replace("*", "");
            reminderFrequencyTxt.sendKeys(reminderFrequencyNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Reminder frequency");

            //Reminder mails cap
            getSession().log_Info("Enter Reminder mails cap");
            getDriver().waitForelementToBeClickable(reminderMailsCapTxt);
            reminderMailsCapTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String reminderMailCapNew = reminderMailCap.replace("*", "");
            reminderMailsCapTxt.sendKeys(reminderMailCapNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Reminder mails cap");

            //Stop reminder mails after escalation

            getSession().log_Info("Stop reminder mails after escalation");
            if (stopOption.contains("Yes")) {
                getDriver().waitForelementToBeClickable(stopReminderMailsAfterEscalationYes);
                stopReminderMailsAfterEscalationYes.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Click On 'Yes' Option");
            } else if (stopOption.contains("No")) {
                getDriver().waitForelementToBeClickable(stopReminderMailsAfterEscalationNo);
                stopReminderMailsAfterEscalationNo.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Click On 'No' Option");
            }

            //Reminder email template
            getSession().log_Info("Select Reminder email template");
            getDriver().waitForelementToBeClickable(reminderEmailTemplateEscalationDrpDwn);
            reminderEmailTemplateEscalationDrpDwn.sendKeys(reminderTemplate);
            wait(1);
            reminderEmailTemplateEscalationDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Reminder email template Selected");

            return new EscalationAndReminderPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Reminder Configurations Failed", ex);
        }
    }

    //Escalation
    public ILiglPage escalationConfigurations(String escalationDay, String escalationFrequency, String escalationMailsCap,
                                              String escalationEmailTemplate, String escalationToBeSentTo) throws Exception {
        try {
            //Number of days after reminder when escalation can be sent
            getSession().log_Info("Enter 'Number of days after reminder when escalation can be sent'");
            getDriver().waitForelementToBeClickable(numberOfDaysBeforeReminderCanBeSentTxt);
            numberOfDaysBeforeReminderCanBeSentTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String escalationDayNew = escalationDay.replace("*", "");
            numberOfDaysBeforeReminderCanBeSentTxt.sendKeys(escalationDayNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Number of days after reminder when escalation can be sent' Entered");

            //Escalation frequency
            getSession().log_Info("Enter 'Escalation frequency'");
            getDriver().waitForelementToBeClickable(escalationFrequencyTxt);
            escalationFrequencyTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String escalationFrequencyNew = escalationFrequency.replace("*", "");
            escalationFrequencyTxt.sendKeys(escalationFrequencyNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Escalation frequency' Entered");

            //Escalation mails cap
            getSession().log_Info("Enter 'Escalation mails cap'");
            getDriver().waitForelementToBeClickable(escalationMailsCapTxt);
            escalationMailsCapTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String escalationMailsCapNew = escalationMailsCap.replace("*", "");
            escalationMailsCapTxt.sendKeys(escalationMailsCapNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Escalation mails cap' Entered");

            //Escalation email template
            getSession().log_Info("Select 'Escalation email template'");
            getDriver().waitForelementToBeClickable(escalationEmailTemplateDrpDwn);
            escalationEmailTemplateDrpDwn.sendKeys(escalationEmailTemplate);
            wait(1);
            escalationEmailTemplateDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Escalation email template' Selected");

            //Escalation to be sent to
            getSession().log_Info("Enter 'Escalation to be sent to'");
            getDriver().waitForelementToBeClickable(escalationToBeSentToTxt);
            escalationToBeSentToTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            escalationToBeSentToTxt.sendKeys(escalationToBeSentTo);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Escalation to be sent to' Entered");

            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Escalation Configurations Failed", ex);
        }
    }


    public ILiglPage checkThatReminderConfigurationsInLegalHoldAtAminLevel(String checkReminderDay,String checkReminderFrequency,
                                                                           String checkReminderMailsCap) throws Exception {
        try {
            clickOnEditButtonInEscalationAndReminder();
            wait(2);

            //Reminder Configurations

            //Number of days before reminder can be sent
            getSession().log_Info("Check that 'Number of days before reminder can be sent' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(numberOfDaysBeforeReminderCanBeSentTxt);
            String numberOfDaysBeforeReminderCanBeSent = numberOfDaysBeforeReminderCanBeSentTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkReminderDay, numberOfDaysBeforeReminderCanBeSent);
            getSession().log_Pass("'Number of days before reminder can be sent' Entered not reflected in Admin level " +
                    numberOfDaysBeforeReminderCanBeSent);

            //Reminder frequency
            getSession().log_Info("Check that 'Reminder frequency' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(reminderFrequencyTxt);
            String reminderFrequency = reminderFrequencyTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkReminderFrequency, reminderFrequency);
            getSession().log_Pass("'Reminder frequency' not reflected in Admin level " + reminderFrequency);

            //Reminder mails cap
            getSession().log_Info("Check that 'Reminder mails cap' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(reminderMailsCapTxt);
            String reminderMailsCap = reminderMailsCapTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkReminderMailsCap, reminderMailsCap);
            getSession().log_Pass("'Reminder mails cap' not reflected in Admin level " + reminderMailsCap);

            clickOnUndoButtonInEscalationAndReminder();
            wait(2);
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check That Reminder And Escalation Configurations Failed", ex);
        }
    }

    public ILiglPage checkThatEscalationConfigurationsInLegalHoldAtAminLevel(String checkEscalationDay,String checkEscalationFrequency,
                                                                           String checkEscalationMailsCap) throws Exception {
        try {

            clickOnEditButtonInEscalationAndReminder();

            //Escalation Configurations

            //Number of days after reminder when escalation can be sent
            getSession().log_Info("Check that 'Number of days after reminder when escalation can be sent' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(numberOfDaysAfterReminderWhenEscalationCanBeSentTxt);
            String numberOfDaysAfterReminderWhenEscalationCanBeSent = numberOfDaysAfterReminderWhenEscalationCanBeSentTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkEscalationDay, numberOfDaysAfterReminderWhenEscalationCanBeSent);
            getSession().log_Pass("'Number of days after reminder when escalation can be sent' Entered not reflected in Admin level " +
                    numberOfDaysAfterReminderWhenEscalationCanBeSent);

            //Escalation frequency
            getSession().log_Info("Check that 'Escalation frequency' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(escalationFrequencyTxt);
            String reminderFrequency = escalationFrequencyTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkEscalationFrequency, reminderFrequency);
            getSession().log_Pass("'Escalation frequency' not reflected in Admin level " + reminderFrequency);

            //Escalation mails cap
            getSession().log_Info("Check that 'Escalation mails cap' not reflected in Admin level");
            getDriver().waitForelementToBeClickable(escalationMailsCapTxt);
            String escalationMailsCap = escalationMailsCapTxt.getAttribute("value");
            getDriver().waitForAngularRequestsToComplete();
            Assert.assertNotEquals(checkEscalationMailsCap, escalationMailsCap);
            getSession().log_Pass("'Escalation mails cap' not reflected in Admin level " + escalationMailsCap);

            clickOnUndoButtonInEscalationAndReminder();
            wait(2);
            return new EscalationAndReminderPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check That Escalation Configurations Failed", ex);
        }
    }
}
