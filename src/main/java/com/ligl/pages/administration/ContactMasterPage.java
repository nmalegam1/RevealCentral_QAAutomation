package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ContactMasterPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//span[@title='General']")
    WebElement GeneralTab;
    @FindBy(xpath = "//span[@title='Legal Hold']")
    WebElement LegalHoldTab;
    @FindBy(xpath = "//span[@title='Users and Roles']")
    WebElement UsersAndRolesTab;
    @FindBy(xpath = "//span[@title='Employee Master']")
    WebElement EmployeeMasterTab;



    @FindBy(xpath = "//span[contains(text(),'Legal Hold')]")
    WebElement LegalHold;

    @FindBy(xpath = "//span[contains(text(),'Employee Master')]")
    WebElement EmployeeMaster;

    @FindBy(xpath = "//span[contains(text(),'Escalation and Reminder')]")
    WebElement EscalationRemainder;

    @FindBy(id = "number-of-days-before-reminder-escalation")
    WebElement NumberOfDays;

    @FindBy(id = "reminder-frequency-escaltion")
    WebElement Remainderfrequency;

    @FindBy(id = "reminder-mails-cap")
    WebElement RemainderMails;

    @FindBy(id = "escalation-remainder-yes-opt-button")
    WebElement YesButton;

    @FindBy(id = "select-reminder-email-template-escalation")
    WebElement RemainderTemplate;

    @FindBy(id = "number-of-days-after-reminder")
    WebElement NumberOfDaysAfterRemainder;

    @FindBy(id = "escalation-frequency")
    WebElement EscalationFrequency;

    @FindBy(id = "escalation-mails-cap")
    WebElement EscalationMails;

    @FindBy(id = "select-escalation-email-template")
    WebElement EscalationTemplate;

    @FindBy(id = "escalation-sent-to")
    WebElement EscalationSentTo;
    public ILiglPage goToUsersRoles()throws Exception{
        try{
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            UsersAndRolesTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new UsersAndRolesPage();
        }catch (Exception ex){
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()",ex);
        }
    }
    public ILiglPage goToEmployeeMasterpage()throws Exception{
        try{
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            GeneralTab.click();
            log_Info("General Tab Clicked");
            EmployeeMasterTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new EmployeeMasterPage();
        }catch (Exception ex){
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()",ex);
        }
    }

    public ILiglPage navigateToEscalationAndRemainder() throws Exception {

        try {

            log_Info("Click on LegalHold Main Tab");
            getDriver().waitForelementToBeClickable(LegalHold);
            Thread.sleep(5000);
            LegalHold.click();
            getSession().log_Pass("Clicked on LegalHold Main Tab");

            log_Info("Click on Escalation And Remainder Sub Tab");
            getDriver().waitForelementToBeClickable(EscalationRemainder);
            Thread.sleep(5000);
            EscalationRemainder.click();
            getSession().log_Pass("Clicked on Escalation And Remainder Sub Tab");

            return new ContactMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("createNewOutsideCounselToCase () Failed",ex);
        }
    }


    public ILiglPage validateEscalationAndRemainderDefaultValues() throws Exception{

        try {

            Thread.sleep(5000);

            log_Info("Validate The Escalation And Remainder Default Values");

            boolean a1  = NumberOfDays.isDisplayed();
            boolean a2  = Remainderfrequency.isDisplayed();
            boolean a3  = RemainderMails.isDisplayed();
            boolean a4  = YesButton.isDisplayed();
            boolean a5  = RemainderTemplate.isDisplayed();
            boolean a6  = NumberOfDaysAfterRemainder.isDisplayed();
            boolean a7  = EscalationFrequency.isDisplayed();
            boolean a8  = EscalationMails.isDisplayed();
            boolean a9  = EscalationTemplate.isDisplayed();
            boolean a10 = EscalationSentTo.isDisplayed();

            Thread.sleep(3000);

            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);
            System.out.println(a9);
            System.out.println(a10);

            Thread.sleep(3000);

            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, a3);
            Assert.assertEquals(true, a4);
            Assert.assertEquals(true, a5);
            Assert.assertEquals(true, a6);
            Assert.assertEquals(true, a7);
            Assert.assertEquals(true, a8);
            Assert.assertEquals(true, a9);
            Assert.assertEquals(true, a10);

            return new ContactMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateEscalationAndRemainderDefaultValues() Failed",ex);
        }
    }

    public ILiglPage navigateToEmployeeMasterPage() throws Exception {

        try {

            log_Info("Click on Employee Master Page");
            getDriver().waitForelementToBeClickable(EmployeeMaster);
            Thread.sleep(5000);
            EmployeeMaster.click();
            getSession().log_Pass("Click on Employee Master Page");

            return new EmployeeMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("navigateToEmployeeMasterPage () Failed",ex);
        }
    }

}





