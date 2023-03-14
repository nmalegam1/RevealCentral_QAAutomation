package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageQuestionBankPage extends LiglBaseSessionPage {
    @FindBy(id = "questionnaire-button")
    public WebElement questionnaireCreateBtn;

    @FindBy(id = "questionnaire-title")
    public WebElement questionnaireTitleTXt;

    @FindBy(id = "select-render-typeRenderTypeUniqueID")
    public WebElement renderTypeDrpDwn;

    @FindBy(id = "render-options")
    public WebElement renderOptionsTxt;

    @FindBy(id = "questionnaire-create-yes")
    public WebElement parentYesBtn;

    @FindBy(id = "questionnaire-create-no")
    public WebElement parentNoBtn;

    @FindBy(id = "render-options")
    public WebElement renderTypeTxt;

    @FindBy(id = "radio-left-yes-opt")
    public WebElement questionMandatoryYesBtn;

    @FindBy(id = "radio-left-no-opt")
    public WebElement questionMandatoryNoBtn;

    @FindBy(id = "questionnaire-description")
    public WebElement descriptionTxt;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[1]//span[@class='mat-radio-outer-circle']")
    public WebElement custodianRadioBtn;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[2]//span[@class='mat-radio-outer-circle']")
    public WebElement stakeHolderRadioBtn;

    @FindBy(xpath = "//span[contains(text(), 'Save')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//span[contains(text(), 'Cancel')]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Question Title']")
    public WebElement questionTitleColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filterBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement searchBar;

    public ILiglPage clickOnQuestionnaire() throws Exception {
        getSession().log_Info("Click On '+Questionnaire' Button");
        getDriver().waitForelementToBeClickable(questionnaireCreateBtn);
        questionnaireCreateBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked On '+Questionnaire' Button");
        return new ManageQuestionBankPage();
    }


    public ILiglPage createNewQuestionnaire(String questionnaireTitle, String renderType, String IsParent,
                                            String IsQuestionMandatory, String RenderOptions, String Description,
                                            String AppliesTo) throws Exception {
        try {
            //Questionnaire Title
            getSession().log_Info("Enter 'Questionnaire Title'");
            getDriver().waitForelementToBeClickable(questionnaireTitleTXt);
            questionnaireTitleTXt.sendKeys(questionnaireTitle);
            getSession().log_Pass("'Questionnaire Title' Entered");

            //Render Type
            getSession().log_Info("Select 'Render Type'");
            getDriver().waitForelementToBeClickable(renderTypeDrpDwn);
            renderTypeDrpDwn.sendKeys(renderType);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Render Type' Selected");

            //Is Parent?
            getSession().log_Info("Select Is Parent?");
            if (IsParent.contains("Yes")) {
                getSession().log_Info("Click On 'Yes'");
                getDriver().waitForelementToBeClickable(parentYesBtn);
                parentYesBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'Yes'");
            } else if (IsParent.contains("No")) {
                getSession().log_Info("Click On 'No'");
                getDriver().waitForelementToBeClickable(parentNoBtn);
                parentNoBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'No'");
            }
            getSession().log_Pass("'Is Parent?' is Selected");

            //Render Options
            getSession().log_Info("Enter 'Render Options'");
            getDriver().waitForelementToBeClickable(renderOptionsTxt);
            renderTypeTxt.sendKeys(RenderOptions);
            getSession().log_Pass("'Render Options' Entered");

            //Is Question Mandatory?
            getSession().log_Info("Select Is Question Mandatory?");
            if (IsQuestionMandatory.contains("Yes")) {
                getSession().log_Info("Click On 'Yes'");
                getDriver().waitForelementToBeClickable(questionMandatoryYesBtn);
                questionMandatoryYesBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'Yes'");
            } else if (IsQuestionMandatory.contains("No")) {
                getSession().log_Info("Click On 'No'");
                getDriver().waitForelementToBeClickable(questionMandatoryNoBtn);
                questionMandatoryNoBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'No'");
            }
            getSession().log_Pass("'Is Question Mandatory?' is Selected");

            //Description
            getSession().log_Info("Enter 'Description'");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(Description);
            getSession().log_Pass("'Description' Entered");

            //Applies To:
            getSession().log_Info("Select Applies To");
            if (AppliesTo.contains("Custodian")) {
                getSession().log_Info("Select 'Case Custodian Questionnaire' Option");
                getDriver().waitForelementToBeClickable(custodianRadioBtn);
                custodianRadioBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Case Custodian Questionnaire' Option Selected");
            } else if (IsQuestionMandatory.contains("StakeHolder")) {
                getSession().log_Info("Select 'Case StakeHolder Questionnaire' Option");
                getDriver().waitForelementToBeClickable(stakeHolderRadioBtn);
                stakeHolderRadioBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("'Case StakeHolder Questionnaire' Option Selected");
            }
            getSession().log_Pass("'Applies To' is Selected");

            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");

            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Questionnaire Failed", ex);
        }

    }

    public ILiglPage editExitingQuestionnaire(String questionnaireTitle, String IsQuestionMandatory,String Description) throws Exception {
        try {
            //Questionnaire Title
            getSession().log_Info("Enter 'Questionnaire Title'");
            getDriver().waitForelementToBeClickable(questionnaireTitleTXt);
            questionnaireTitleTXt.sendKeys(questionnaireTitle);
            getSession().log_Pass("'Questionnaire Title' Entered");


            //Is Question Mandatory?
            getSession().log_Info("Select Is Question Mandatory?");
            if (IsQuestionMandatory.contains("Yes")) {
                getSession().log_Info("Click On 'Yes'");
                getDriver().waitForelementToBeClickable(questionMandatoryYesBtn);
                questionMandatoryYesBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'Yes'");
            } else if (IsQuestionMandatory.contains("No")) {
                getSession().log_Info("Click On 'No'");
                getDriver().waitForelementToBeClickable(questionMandatoryNoBtn);
                questionMandatoryNoBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'No'");
            }
            getSession().log_Pass("'Is Question Mandatory?' is Selected");

            //Description
            getSession().log_Info("Enter 'Description'");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(Description);
            getSession().log_Pass("'Description' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");

            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Exiting Questionnaire Failed", ex);
        }

    }

}
