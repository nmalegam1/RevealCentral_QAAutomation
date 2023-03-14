package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseSettingsPage extends LiglBaseSessionPage {
    @FindBy(id = "add-btn")
    public WebElement addTemplateBtn;

    @FindBy(id = "Name")
    public WebElement caseSettingsTemplateNameTxt;

    @FindBy(id = "Description")
    public WebElement descriptionTxt;

    @FindBy(id = "KWE")
    public WebElement kWETxt;

    @FindBy(id = "workspacetemplate")
    public WebElement workSpaceTemplateDrpDwn;

    @FindBy(id = "workspacetemplates")
    public WebElement clientTemplateIdDrpDwn;

    @FindBy(id = "processingprofile")
    public WebElement processingProfileDrpDwn;

    @FindBy(id = "btn-save")
    public WebElement saveBtn;

    @FindBy(id = "btn-cancel")
    public WebElement cancelBtn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement drpDwnSearchBar;


    /**
     * TC21664 Case Settings - Verify the process of creating new Case settings template using +Template button
     */
    public ILiglPage createCaseSettingsTemplate(String caseSettingsTemplateName, String Description, String kWE,
                                                String workSpaceTemplateId, String clientTemplateId,
                                                String processingProfiles) throws Exception {
        try {
            //Add Template Button
            getSession().log_Info("Click on '+Template' Button");
            getDriver().waitForelementToBeClickable(addTemplateBtn);
            addTemplateBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on '+Template' Button");

            //Case Settings Template
            getSession().log_Info("Enter Case Settings Template Name");
            getDriver().waitForelementToBeClickable(caseSettingsTemplateNameTxt);
            caseSettingsTemplateNameTxt.sendKeys(caseSettingsTemplateName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Case Settings Template Name Entered");

            //Description
            getSession().log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(Description);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Description Entered");

            //kWE
            getSession().log_Info("Enter kWE");
            getDriver().waitForelementToBeClickable(kWETxt);
            kWETxt.sendKeys(kWE);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("kWE Entered");

            //WorkSpaceTemplateId
            getSession().log_Info("Select WorkSpaceTemplateId");
            getDriver().waitForelementToBeClickable(workSpaceTemplateDrpDwn);
            workSpaceTemplateDrpDwn.click();
            drpDwnSearchBar.sendKeys(workSpaceTemplateId);
            getDriver().customXpathBasedOnTextValue(workSpaceTemplateId).click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("WorkSpaceTemplateId Selected");

            //ClientTemplateId
            getSession().log_Info("Select ClientTemplateId");
            getDriver().waitForelementToBeClickable(clientTemplateIdDrpDwn);
            clientTemplateIdDrpDwn.click();
            drpDwnSearchBar.sendKeys(clientTemplateId);
            getDriver().customXpathBasedOnTextValue(clientTemplateId).click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("ClientTemplateId Selected");

            //Processing Profiles
            getSession().log_Info("Select Processing Profiles");
            getDriver().scrollToView(processingProfileDrpDwn);
            getDriver().waitForelementToBeClickable(processingProfileDrpDwn);
            processingProfileDrpDwn.click();
            drpDwnSearchBar.sendKeys(processingProfiles);
            getDriver().customXpathBasedOnTextValue(processingProfiles).click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Processing Profiles Selected");

            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");
            wait(1);
            return new CaseSettingsPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create Case Settings Template Failed", ex);
        }
    }

}
