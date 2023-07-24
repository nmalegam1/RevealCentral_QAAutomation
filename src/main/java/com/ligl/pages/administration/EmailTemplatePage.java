package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LegalHoldPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class EmailTemplatePage extends LiglBaseSessionPage {


    @FindBy(css="input[id='Name']")
    WebElement NewTempName;
    @FindBy(css="input[id='subject']")
    WebElement MailSubject;
    @FindBy(id="btn-save")
    WebElement SaveBtn;
    @FindBy(css="div[role='textbox']")
    WebElement MailContent;

    /********************************************************************************************************/

    @FindBy(id = "add-btn")
    public WebElement addTemplateBtn;

    @FindBy(id = "select-email-template-categoryemailtemplatecategory")
    public WebElement emailTemplateCategoryDrpDwn;

    @FindBy(id = "select-email-templateemailtemplate")
    public WebElement emailTemplateDrpDwn;

    @FindBy(id = "Name")
    public WebElement EmailTemplateNameTxt;

    @FindBy(id = "subject")
    public WebElement subjectTxt;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement contentTxt;

    @FindBy(id = "btn-edit")
    public WebElement editBtn;

    @FindBy(id = "btn-delete")
    public WebElement deleteBtn;

    @FindBy(id = "btn-cancel")
    public WebElement cancelBtn;

    @FindBy(id = "btn-save")
    public WebElement saveBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement drpDwnSearchBar;

    @FindBy(xpath = "//div[@class='param-padding-bottom']")
    public WebElement parameterNameTxt;

    JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();


    public ILiglPage editTempOnFly(String NewtempName, String subject, String content)throws Exception{

        try{

            log_Info("editTempOnFly() Started");
            Thread.sleep(5000);
            NewTempName.sendKeys(NewtempName);
            Thread.sleep(5000);
            MailSubject.clear();
            MailSubject.sendKeys(subject);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
            MailContent.clear();
            MailContent.sendKeys(content);
            SaveBtn.click();

            return new LegalHoldPage();

        }catch (Exception ex){
            log_Error("editTempOnFly() is Failed");
            throw new Exception("Exception in editTempOnFly()",ex);
        }
    }

    /*********************************************************************************************/



    /**
     * Creating new template using +Template button.
     * <p>
     * TC1983 Email Templates- Verify the process of creating new template using +Template button for 'Case Approval' category.
     */


    public ILiglPage createNewEmailTemplate(String emailTemplateCategory, String emailTemplateName, String subject,
                                            String content) throws Exception {
        try {
            //Select Email Template Category
            Thread.sleep(5000);
            getSession().log_Info("Select Email Template Category");
            js.executeScript("window.scrollBy(0,-500)");
            getDriver().waitForelementToBeClickable(emailTemplateCategoryDrpDwn);
            emailTemplateCategoryDrpDwn.click();
            drpDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            drpDwnSearchBar.sendKeys(emailTemplateCategory);

            getDriver().customXpathBasedOnTextValue(emailTemplateCategory).click();
            wait(2);

            //getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + emailTemplateCategory + "']")).click();

            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Template Category Selected");


            //Parameters
            //Assert.assertEquals(parameterNameTxt.getText(), emailTemplateCategory+"'s Parameters");

            //+Template Button
            getSession().log_Info("Click on '+ Template' Button");
            getDriver().waitForelementToBeClickable(addTemplateBtn);
            addTemplateBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on '+ Template' Button");

            //Email Template Name
            getSession().log_Info("Enter Email Template Name");
            getDriver().waitForelementToBeClickable(EmailTemplateNameTxt);
            EmailTemplateNameTxt.sendKeys(emailTemplateName);
            getSession().log_Pass("'Email Template Name' Entered");

            //Subject
            getSession().log_Info("Enter 'Subject'");
            getDriver().waitForelementToBeClickable(subjectTxt);
            subjectTxt.sendKeys(subject);
            getSession().log_Pass("'Subject' Entered");

            //Content
            getSession().log_Info("Enter 'Content'");
            getDriver().waitForelementToBeClickable(contentTxt);
            contentTxt.sendKeys(content);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Content' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            js.executeScript("arguments[0].scrollIntoView();", saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");
            wait(4);
            return new EmailTemplatePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Email Template Failed", ex);
        }
    }

    /**
     * TC35048 Email Templates (System)- Verify the process of editing Subject & Content for mentioned email template categories.
     */

    public ILiglPage editEmailTemplate(String emailTemplateCategory, String emailTemplate, String subject,
                                       String content) throws Exception {
        try {
            //Select Email Template Category
            getSession().log_Info("Select Email Template Category");
            wait(3);
            js.executeScript("window.scrollBy(0,-500)");
            getDriver().waitForelementToBeClickable(emailTemplateCategoryDrpDwn);
            emailTemplateCategoryDrpDwn.click();
            drpDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            drpDwnSearchBar.sendKeys(emailTemplateCategory);
            getDriver().customXpathBasedOnTextValue(emailTemplateCategory).click();
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Template Category Selected");

            //Select Email Template
            getSession().log_Info("Select Email Template");
            js.executeScript("window.scrollBy(0,-500)", emailTemplateDrpDwn);
            getDriver().waitForelementToBeClickable(emailTemplateDrpDwn);
            emailTemplateDrpDwn.click();
            drpDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            drpDwnSearchBar.sendKeys(emailTemplate);
            //getDriver().customXpathBasedOnTextValue(emailTemplate).click();
            getCurrentDriver().findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='"+emailTemplate+"']")).click();
            wait(2);
            //emailTemplateDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Template Selected");

            //Edit
            getSession().log_Info("Click on 'Edit' Button");
            js.executeScript("arguments[0].scrollIntoView();", editBtn);
            editBtn.click();
            getSession().log_Pass("Click on 'Edit' Button");

            //Subject
            getSession().log_Info("Enter 'Subject'");
            js.executeScript("window.scrollBy(0,1000)", subjectTxt);
            getDriver().waitForelementToBeClickable(subjectTxt);
            subjectTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            subjectTxt.sendKeys(subject);
            getSession().log_Pass("'Subject' Entered");

            //Content
            getSession().log_Info("Enter 'Content'");
            getDriver().waitForelementToBeClickable(contentTxt);
            //contentTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            wait(1);
            contentTxt.sendKeys(content);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Content' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            js.executeScript("arguments[0].scrollIntoView();", saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");

            wait(4);
            return new EmailTemplatePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Email Template Failed", ex);
        }
    }

    /**
     * TC35049 Email Templates (System)- Check that '+Template' & 'Delete' buttons are click disabled for mentioned email template categories.
     */

    public ILiglPage checkWhetherAddTemplateAndDeleteButtonsAreDisabled(String emailTemplateCategory,
                                                                        String emailTemplate) throws Exception {
        try {
            //Select Email Template Category
            getSession().log_Info("Select Email Template Category");
            wait(5);
            js.executeScript("window.scrollBy(0,-300)");
           // getDriver().waitForelementToBeClickable(emailTemplateCategoryDrpDwn);
            emailTemplateCategoryDrpDwn.click();
            drpDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            drpDwnSearchBar.sendKeys(emailTemplateCategory);
            getDriver().customXpathBasedOnTextValue(emailTemplateCategory).click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Template Category Selected");

            //Select Email Template
            getSession().log_Info("Select Email Template");
            js.executeScript("window.scrollBy(0,-500)", emailTemplateDrpDwn);
            getDriver().waitForelementToBeClickable(emailTemplateDrpDwn);
            emailTemplateDrpDwn.click();
            drpDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            drpDwnSearchBar.sendKeys(emailTemplate);
            getCurrentDriver().findElement(By.xpath("//span[@class='mat-option-text'][normalize-space()='"+emailTemplate+"']")).click();
            wait(1);
            emailTemplateDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Template Selected");

            //+Template Buttons Are Disabled
            wait(2);
            getSession().log_Info("Check Whether '+Template' Button Disabled");
            js.executeScript("window.scrollBy(0,1000)", addTemplateBtn);
            Assert.assertEquals(addTemplateBtn.isEnabled(), false);
            getSession().log_Pass("'+Template' Button is Disabled");

            //+Delete Buttons Are Disabled
            getSession().log_Info("Check Whether 'Delete' Button Disabled");
            js.executeScript("arguments[0].scrollIntoView();", deleteBtn);
            Assert.assertEquals(deleteBtn.isEnabled(), false);
            getSession().log_Pass("'Delete' Button is Disabled");


            return new EmailTemplatePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check Whether Add Template And Delete Buttons Are Disabled Failed", ex);
        }
    }



}
