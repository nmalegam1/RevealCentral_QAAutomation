package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class NewUsersLandingPage extends LiglBaseSessionPage {

    @FindBy(id = "old-password-input")
    WebElement oldPasswordTxtBox;
    @FindBy(id = "new-password-input")
    WebElement newPasswordTxtBox;
    @FindBy(id = "confirm-password-input")
    WebElement confirmPasswordTxtBox;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement saveBtn;
    @FindBy(xpath = "//div[@class='modal-body modal-body-alert-box-component']")
    WebElement noRoleAlertMsg;
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OKBtn;
    @FindBy(id = "myModalLabelEula")
    WebElement eulaMsg;
    @FindBy(id = "save-btn-accept-eula")
    WebElement eulaAcceptBtn;

    @Override
    public ILiglPage changePasswordAfterUserLogin(
            String changePasswordConfirmation, String oldPassword,
            String newPassword, String confirmPassword
    ) throws Exception {
        getSession().log_Info("Check that 'Change Password pop up' displayed");
        getCurrentDriver().findElement(By.id("change-modal-label")).getText().contains("Change Password");
        getSession().log_Pass("Change Password pop up displayed");
        try {
            if (changePasswordConfirmation.contains("yes")) {
                //Old Password
                getSession().log_Info("Enter Old Password");
                getDriver().waitForelementToBeClickable(oldPasswordTxtBox);
                oldPasswordTxtBox.sendKeys(oldPassword);
                getSession().log_Pass("Entered Old Password");
                //New Password
                getSession().log_Info("Enter New Password");
                getDriver().waitForelementToBeClickable(newPasswordTxtBox);
                newPasswordTxtBox.sendKeys(newPassword);
                getSession().log_Pass("Entered New Password");
                //Confirm Password
                getSession().log_Info("Enter Confirm Password");
                getDriver().waitForelementToBeClickable(confirmPasswordTxtBox);
                confirmPasswordTxtBox.sendKeys(confirmPassword);
                getSession().log_Pass("Entered Confirm Password");
                //Save
                getSession().log_Info("Click 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getSession().log_Pass("Clicked 'Save' Button");
                return new LoginPage();
            } else if (changePasswordConfirmation.contains("no")) {
                getSession().log_Info("Close the change Password popup");
                getCurrentDriver().findElement(By.id("btn-cross")).click();
                getSession().log_Pass("Closeed the change Password popup");
                return new DefaultLandingPage();
            }
            return new DefaultLandingPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Change Password After User login failed", ex);
        }
    }

    public ILiglPage acceptEula() throws Exception {
        try {
            getSession().log_Info("Check that Eula popup is displayed");
            eulaMsg.getText().contains(" User License Agreement");
            getSession().log_Pass("Eula popup is displayed");
            getSession().log_Info("Click on eula 'Accept' button");
            getDriver().waitForelementToBeClickable(eulaAcceptBtn);
            eulaAcceptBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on eula 'Accept' button");
            return this;
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Accept Eula Page Test failed", ex);
        }
    }

    public ILiglPage checkTheAlertNoRoleAssign() throws Exception {
        try {
            getSession().log_Info("check that 'User not found in the selected entity' ALERT displayed");
            Assert.assertEquals(noRoleAlertMsg.getText(), "SW122005-User not found in the selected entity");
            getSession().log_Pass("'User not found in the selected entity' ALERT displayed");
            getSession().log_Info("Click on 'Ok' button");
            getDriver().waitForelementToBeClickable(OKBtn);
            OKBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Ok' button");
            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("No Role Login Failed", ex);
        }
    }

    public ILiglPage verifyInActiveSSOUserLoginValidation() throws Exception {
        try {
            getSession().log_Info("Check that 'Not Authorized' Validation Displayed");
            wait(1);
            String not = getCurrentDriver().findElement(By.xpath("//div[@class='modal-title modal-title-font']")).getText();
            Assert.assertEquals(not, "Not Authorized");
            getSession().log_Pass("'The User is currently disabled' Validation Displayed");
            getSession().log_Info("Click 'OK' Button");
            getDriver().waitForelementToBeClickable(OKBtn);
            OKBtn.click();
            getSession().log_Pass("Clicked on 'OK' Button");
            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("InActive User Login Failed", ex);
        }
    }
}
