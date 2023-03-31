package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;

public class ManageQuestionnaireTemplatesPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//button[contains(text(), 'Add Template')]")
    public WebElement addTemplateBtn;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//button//span[.='Create New Template']")
    public WebElement createNewTemplateBtn;

    @FindBy(xpath = "//div[@class='cdk-overlay-container']//button//span[.='Create From Existing Template']")
    public WebElement createFromExistingTemplateBtn;

    @FindBy(id = "select-questionnare-templatesID")
    public WebElement selectQuestionnareTemplatesDrpDwn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement dropDownSearchBar;

    @FindBy(css = "#questionnaire-template-name")
    public WebElement questionnaireTemplateNameTxt;

    @FindBy(css = "#description")
    public WebElement descriptionTxt;

    @FindBy(xpath = "//mat-radio-group[@id='applies-to-radio-group']")
    public WebElement AppliesToOptions;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[1]")
    public WebElement custodianRadioBtn;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[2]")
    public WebElement stakeHolderRadioBtn;

    @FindBy(id = "questionnaire-template-save-btn")
    WebElement saveBtn;

    @FindBy(id = "questionnaire-template-cancel-btn")
    WebElement cancelBtn;

    @FindBy(id = "edit-btn")
    WebElement editBtn;

    @FindBy(xpath = "//button[@title='DELINK']")
    public WebElement delinkBtn;

    @FindBy(xpath = "//button[.='Yes']")
    public WebElement yesBtn;

    @FindBy(xpath = "//button[.='no']")
    public WebElement noBtn;

    @FindBy(id = "add-new-question-button")
    public WebElement addNewQuestionBtn;

    @FindBy(id = "add-to-template-button")
    public WebElement addToTemplateBtn;

    @FindBy(xpath = "//div[@col-id='QuestionnaireText']//app-custom-grid-text//span//span//span")
    public WebElement questionnaireTitleColumn;

    @FindBy(xpath = "//span[@class='ag-header-cell-text'][normalize-space()='Question Title']")
    public WebElement questionTitleColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[2]")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filterBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement searchBar;

    public ManageQuestionBankPage selectQuestion = new ManageQuestionBankPage();

    //Add Template Button
    public ILiglPage clickOnAddTemplate(Hashtable<String, String> data) throws Exception {
        try {
            getSession().log_Info("Click On 'AddTemplate' Button");
            getDriver().waitForelementToBeClickable(addTemplateBtn);
            addTemplateBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'AddTemplate' Button");

            if (data.get("addTemplate").contains("Create New Template")) {
                getSession().log_Info("Select 'Create New Template'");
                getDriver().waitForelementToBeClickable(createNewTemplateBtn);
                createNewTemplateBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Create New Template' Selected");
            } else if (data.get("addTemplate").contains("Create From Existing Template")) {
                getSession().log_Info("Select 'Create From Existing Template'");
                getDriver().waitForelementToBeClickable(createFromExistingTemplateBtn);
                createFromExistingTemplateBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Create From Existing Template' Selected");

                //Select Questionnaire Template
                getSession().log_Info("Select Questionnaire Template");
                getDriver().waitForelementToBeClickable(selectQuestionnareTemplatesDrpDwn);
                selectQuestionnareTemplatesDrpDwn.click();
                dropDownSearchBar.sendKeys(data.get("selectQuestionnaireTemplate"));
                wait(1);
                getDriver().customXpathBasedOnTextValue(data.get("selectQuestionnaireTemplate")).click();
                getSession().log_Pass("Questionnaire Template Selected");
            }

            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Add Template Failed", ex);
        }
    }

    //Edit Button
    public ILiglPage clickOnEditButtonInManageQuestionnaireTemplate() throws Exception {
        try {
            getSession().log_Info("Click On 'Edit' Button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Edit' Button");
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Edit Button Failed", ex);
        }
    }

    //Add Question Button
    public ILiglPage clickOnAddNewQuestionButton() throws Exception {
        try {
            getSession().log_Info("Click on 'Add New Question' Button");
            getDriver().waitForelementToBeClickable(addNewQuestionBtn);
            addNewQuestionBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Add New Question' Button");
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Add New Question Failed", ex);
        }
    }

    //Select Questionnaire Template
    public ILiglPage selectQuestionnaireTemplate(String questionnaireTemplate) throws Exception {
        try {
            getSession().log_Info("Select Questionnaire Template");
            getDriver().waitForelementToBeClickable(selectQuestionnareTemplatesDrpDwn);
            selectQuestionnareTemplatesDrpDwn.sendKeys(questionnaireTemplate);
            wait(1);
            selectQuestionnareTemplatesDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Questionnaire Template Selected");
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Select Questionnaire Template Failed", ex);
        }
    }

    //Search the Question In Manage Question Template
    public ILiglPage searchTheQuestionInManageQuestionTemplate(String question) throws Exception {
        try {
            getSession().log_Info("Hover on 'Questionnaire Title'");
            getDriver().waitForelementToBeClickable(questionTitleColumn);
            getDriver().waitForMoveToElement(questionTitleColumn);
            getSession().log_Pass("Hovered on Questionnaire Title");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menuBtn);
            getDriver().waitForMoveToElement(menuBtn);
            menuBtn.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filterBtn);
            filterBtn.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Questionnaire in Search Bar");
            getDriver().waitForelementToBeClickable(searchBar);
            searchBar.sendKeys(question);
            filterBtn.click();
            getSession().log_Pass("Entered the Questionnaire in Search Bar");
            wait(2);
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search the Question Failed", ex);
        }
    }


    @Override
    public ILiglPage createNewQuestionnaireTemplates(Hashtable<String, String> data) throws Exception {
        try {


            //Clear the Questionnaire Template Name Field
            getDriver().waitForelementToBeClickable(questionnaireTemplateNameTxt);
            getSession().log_Info("Clear the 'Questionnaire Template Name' Field");
            questionnaireTemplateNameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Questionnaire Template Name' Field Cleared");
            //Enter the Questionnaire Template Name
            getSession().log_Info("Enter 'Questionnaire Template Name'");
            questionnaireTemplateNameTxt.sendKeys(data.get("questionnaireTemplateName"));
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Questionnaire Template Name' Entered");

            //Applies To:

            getSession().log_Info("Select Applies To");
            if (data.get("appliesTo").contains("Custodian")) {
                getSession().log_Info("Select 'Case Custodian Questionnaire' Option");
                getDriver().waitForelementToBeClickable(custodianRadioBtn);
                custodianRadioBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Case Custodian Questionnaire' Option Selected");
            } else if (data.get("appliesTo").contains("StakeHolder")) {
                getSession().log_Info("Select 'Case StakeHolder Questionnaire' Option");
                getDriver().waitForelementToBeClickable(stakeHolderRadioBtn);
                stakeHolderRadioBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Case StakeHolder Questionnaire' Option Selected");
            }
            getSession().log_Pass("'Applies To' is Selected");

            //Description
            getDriver().waitForelementToBeClickable(descriptionTxt);
            getSession().log_Info("Clear the 'Description' Field");
            descriptionTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Description' Field Cleared");
            //Enter the Questionnaire Template Name
            getSession().log_Info("Enter 'Description'");
            descriptionTxt.sendKeys(data.get("description"));
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            //Save Button
            getSession().log_Info("Click On 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Save' Button");
            wait(4);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//div[@class='cm-div-read col-4 ng-star-inserted'][1]//div")).isDisplayed();

            getSession().takeScreenShot();

            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create Questionnaire Templates Failed", ex);
        }
    }

    //Add Question to Manage Questionnaire Template
    public ILiglPage addQuestionToManageQuestionnaireTemplate(Hashtable<String, String> data) throws Exception {
        try {
            //Search the Question
            selectQuestion.searchParentQuestion(data.get("addQuestion"));

            //Select the Question
            getSession().log_Info("Click On Question check box");
            getDriver().checkTheCheckBox(data.get("addQuestion")).click();
            getSession().log_Pass("Clicked On Question check box");

            //Click on AddToTemplate Button
            getSession().log_Info("Click on 'AddToTemplate' Button");
            getDriver().waitForelementToBeClickable(addToTemplateBtn);
            addToTemplateBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Info("Click on 'AddToTemplate' Button");

            //Verify that add question displaying in grid
            getSession().log_Info("Verify that add question displaying in grid");
            searchTheQuestionInManageQuestionTemplate(data.get("addQuestion"));
            String question = questionnaireTitleColumn.getText();
            Assert.assertEquals(question, data.get("addQuestion"));
            getSession().log_Pass("Verify that add question displaying in grid");

            getSession().takeScreenShot();
            wait(2);
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Add Question to Questionnaire Templates Failed", ex);
        }
    }

    // de-link the Question
    public ILiglPage deLinkTheQuestion(String question) throws Exception {
        try {
            searchTheQuestionInManageQuestionTemplate(question);
            getDriver().customXpathBasedOnTextValue(question).click();
            getDriver().moveToRightInAngularTable("3");
            getSession().log_Info("Click on 'DeLink'");
            getDriver().waitForelementToBeClickable(delinkBtn);
            delinkBtn.click();
            getSession().log_Pass("Clicked on 'DeLink'");

            getSession().log_Info("Are you sure you want to delete?");
            getSession().log_Info("Click on 'Yes' Button");
            getDriver().waitForelementToBeClickable(yesBtn);
            yesBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Yes' Button");

            getSession().takeScreenShot();
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("DeLink the Question to Questionnaire Templates Failed", ex);
        }
    }

    //Edit Questionnaire Template Fields
    public ILiglPage editQuestionnaireTemplate(Hashtable<String, String> data) throws Exception {
        try {

            //Clear the Questionnaire Template Name Field
            getDriver().waitForelementToBeClickable(questionnaireTemplateNameTxt);
            getSession().log_Info("Clear the 'Questionnaire Template Name' Field");
            questionnaireTemplateNameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Questionnaire Template Name' Field Cleared");
            //Enter the Questionnaire Template Name
            getSession().log_Info("Enter 'Questionnaire Template Name'");
            questionnaireTemplateNameTxt.sendKeys(data.get("questionnaireTemplateName"));
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Questionnaire Template Name' Entered");

            //Description
            getDriver().waitForelementToBeClickable(descriptionTxt);
            getSession().log_Info("Clear the 'Description' Field");
            descriptionTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Description' Field Cleared");
            //Enter the Questionnaire Template Name
            getSession().log_Info("Enter 'Description'");
            descriptionTxt.sendKeys(data.get("description"));
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            //Save Button
            getSession().log_Info("Click On 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Save' Button");
            getSession().takeScreenShot();
            wait(2);
            return new ManageQuestionnaireTemplatesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit the Questionnaire Templates Failed", ex);
        }
    }
}
