package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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

    @FindBy(id = "selectParentQuestion")
    public WebElement selectParentQuestionBtn;

    @FindBy(id = "render-options")
    public WebElement renderTypeTxt;

    @FindBy(xpath = "//button[@id='radio-left-yes-opt-button']")
    public WebElement questionMandatoryYesBtn;

    @FindBy(xpath = "//button[@id='radio-right-no-opt-button']")
    public WebElement questionMandatoryNoBtn;

    @FindBy(id = "questionnaire-description")
    public WebElement descriptionTxt;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[1]")
    public WebElement custodianRadioBtn;

    @FindBy(xpath = "//mat-radio-group//mat-radio-button[2]")
    public WebElement stakeHolderRadioBtn;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[contains(text(), 'Cancel')]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    public WebElement deleteBtn;

    //@FindBy(xpath = "//span[@ref='eText'][normalize-space()='Question Title']")
    @FindBy(xpath = "//span[@class='ag-header-cell-text'][normalize-space()='Question Title']")
    public WebElement questionTitleColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filterBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement searchBar;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement dropDownSearchBar;

    @FindBy(id = "ok-btn")
    public WebElement OkBtn;

    @FindBy(xpath = "//mat-radio-group[@id='applies-to-radio-group']")
    public WebElement AppliesToOptions;

    @FindBy(xpath = "(//span[@class='ag-header-cell-text'][normalize-space()='Question Title'])[3]")
    public WebElement parentQuestionTitleColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[6]")
    public WebElement MenuBtn;

    public ILiglPage refreshTheManageQuestionBankPage() throws Exception {
        getCurrentDriver().navigate().refresh();
        wait(2);
        return new ManageQuestionBankPage();
    }

    //create Question Button
    public ILiglPage clickOnQuestionnaireButton() throws Exception {
        getSession().log_Info("Click On '+Questionnaire' Button");
        getDriver().waitForelementToBeClickable(questionnaireCreateBtn);
        questionnaireCreateBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked On '+Questionnaire' Button");
        return new ManageQuestionBankPage();
    }

    //edit
    public ILiglPage clickOnEditInQuestionGrid() throws Exception {
        getSession().log_Info("Click on 'edit' button");
        getDriver().waitForelementToBeClickable(editBtn);
        editBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on 'edit' button");
        return new ManageQuestionBankPage();
    }

    //Scroll To Right AG grid
    public ILiglPage scrollToRightToDoActionInManageQuestionGrid(String question) throws Exception {
        getSession().log_Info("Hover on 'Questionnaire Title'");
        getDriver().waitForelementToBeClickable(questionTitleColumn);
        getDriver().waitForMoveToElement(questionTitleColumn);
        getSession().log_Pass("Hovered on Questionnaire Title");


        getSession().log_Info("Click Scroll Bar And Move to Right");
        getDriver().customXpathBasedOnTextValue(question).click();
        getDriver().moveToRightInAngularTable("4");
        getSession().log_Pass("Clicked Scroll Bar And Moved to Right");
        return new ManageQuestionBankPage();
    }

    //search
    public ILiglPage searchTheQuestion(String question) throws Exception {
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

    public ILiglPage searchParentQuestion(String parentQuestion) throws Exception {
        try {
            getSession().log_Info("Hover on 'Questionnaire Title'");
            getDriver().waitForelementToBeClickable(parentQuestionTitleColumn);
            getDriver().waitForMoveToElement(parentQuestionTitleColumn);
            getSession().log_Pass("Hovered on Questionnaire Title");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(MenuBtn);
            getDriver().waitForMoveToElement(MenuBtn);
            MenuBtn.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filterBtn);
            filterBtn.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Questionnaire in Search Bar");
            getDriver().waitForelementToBeClickable(searchBar);
            searchBar.sendKeys(parentQuestion);
            filterBtn.click();
            getSession().log_Pass("Questionnaire in Search Bar");

            wait(2);
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search the Question Failed", ex);

        }
    }

    public ILiglPage searchChildQuestion(String childQuestion) throws Exception {
        try {
            getSession().log_Info("Search the Child Question");
            searchTheQuestion(childQuestion);
            scrollToRightToDoActionInManageQuestionGrid(childQuestion);

            getSession().log_Pass("Child Question Searched");
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search Child Question Failed", ex);
        }
    }

    //Create
    @Override
    public ILiglPage createNewQuestionnaire(String questionnaireTitle, String renderType, String IsParent,
                                            String IsQuestionMandatory, String RenderOptions, String Description,
                                            String AppliesTo, String searchParentQuestion) throws Exception {
        try {
            //Questionnaire Title
            getSession().log_Info("Enter 'Questionnaire Title'");
            getDriver().waitForelementToBeClickable(questionnaireTitleTXt);
            questionnaireTitleTXt.sendKeys(questionnaireTitle);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Questionnaire Title' Entered");

            //Render Type
            getSession().log_Info("Select 'Render Type'");
            getDriver().waitForelementToBeClickable(renderTypeDrpDwn);
            renderTypeDrpDwn.click();
            dropDownSearchBar.sendKeys(renderType);
            wait(1);
            getDriver().customXpathBasedOnTextValue(renderType).click();
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

                //Render Options
                getSession().log_Info("Enter 'Render Options'");
                getDriver().waitForelementToBeClickable(renderOptionsTxt);
                renderTypeTxt.sendKeys(RenderOptions);
                getSession().log_Pass("'Render Options' Entered");

            } else if (IsParent.contains("No")) {
                getSession().log_Info("Click On 'No'");
                getDriver().waitForelementToBeClickable(parentNoBtn);
                parentNoBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'No'");

                //Select Parent Question Button
                getSession().log_Info("Click On 'Select Parent Question' Button");
                getDriver().waitForelementToBeClickable(selectParentQuestionBtn);
                selectParentQuestionBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getDriver().waitUntilSpinnerIsClosed();
                getSession().log_Pass("Clicked On 'Select Parent Question' Button");

                //Search and Select Parent Question
                getSession().log_Info("Search the 'Parent Question'");
                searchParentQuestion(searchParentQuestion);
                getSession().log_Pass("'Parent Question' Searched");
                getSession().log_Info("Select the 'Parent Question'");
                getDriver().checkTheCheckBox(searchParentQuestion).click();
                getSession().log_Pass("'Parent Question' Selected");

                //Ok
                getSession().log_Info("Click On 'OK' Button");
                getDriver().waitForelementToBeClickable(OkBtn);
                OkBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked On 'OK' Button");

            }
            getSession().log_Pass("'Is Parent?' is Selected");


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

            if (AppliesToOptions.isSelected()) {
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
            }
            wait(1);
            getSession().takeScreenShot();
            //Save
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

    //Editing
    @Override
    public ILiglPage editExitingQuestionnaire(String questionnaireTitle, String IsQuestionMandatory, String Description) throws Exception {
        try {
            //Questionnaire Title
            getDriver().waitForelementToBeClickable(questionnaireTitleTXt);
            getSession().log_Info("Clear the Existing 'Questionnaire Title'");
            questionnaireTitleTXt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Existing 'Questionnaire Title' Cleared");
            getSession().log_Info("Enter 'Questionnaire Title'");
            questionnaireTitleTXt.sendKeys(questionnaireTitle);
            getDriver().waitForAngularRequestsToComplete();
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
            getDriver().waitForelementToBeClickable(descriptionTxt);
            getSession().log_Info("Clear the Existing 'Questionnaire Title'");
            descriptionTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Existing 'Questionnaire Title' Cleared");
            getSession().log_Info("Enter 'Description'");
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

    @Override
    public ILiglPage checkAppliesToIsNonEditableField() throws Exception {
        try {
            //Applies To
            getSession().log_Info("Check 'AppliesTo' Is Non-Editable Field");
            Assert.assertEquals(AppliesToOptions.isSelected(), false);
            getSession().log_Pass("'AppliesTo' Is Non-Editable Field");

            //Save
            getSession().log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Save Button");
            wait(2);
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check AppliesTo Is Non-Editable Field Failed", ex);
        }
    }

    // Is Parent Option
    public ILiglPage verifyTheIsParentOption(String question) throws Exception {
        try {
            scrollToRightToDoActionInManageQuestionGrid(question);
            getSession().log_Info("Verify The 'IsParent' Option displayed 'Yes or No'");
            try {
                String actual = getCurrentDriver().findElement(By.xpath("//div[@aria-label='Press SPACE to select this row.']//div[7]")).getText();
                Assert.assertEquals(actual, "No");
                getSession().takeScreenShot();
                getSession().log_Pass("'IsParent' Option displayed as " + actual.toUpperCase());

            } catch (Exception ex) {
                ////span[@class='ellipsisAgGrid'][normalize-space()='Yes']
                String actual = getCurrentDriver().findElement(By.xpath("//div[@aria-label='Press SPACE to select this row.']//div[7]")).getText();
                Assert.assertEquals(actual, "Yes");
                getSession().takeScreenShot();
                getSession().log_Pass("'IsParent' Option displayed as " + actual.toUpperCase());
            }
            wait(2);
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Verify The 'IsParent' Option Failed", ex);
        }
    }

    //Verify ParentQuestion Column

    public ILiglPage verifyParentQuestionColumn(String question) throws Exception {
        try {
            scrollToRightToDoActionInManageQuestionGrid(question);
            getSession().log_Info("Verify the ParentQuestion Column");
            String a1 = getCurrentDriver().findElement(By.xpath("//div[@col-id='ParentQuestion']//span[@class='ellipsisAgGrid']")).getText();
            getSession().log_Pass("Parent Question is " + "'" + a1 + "'");
            getSession().takeScreenShot();
            wait(2);
            return new ManageQuestionBankPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Verify The 'Parent Question' Column", ex);
        }
    }

}
