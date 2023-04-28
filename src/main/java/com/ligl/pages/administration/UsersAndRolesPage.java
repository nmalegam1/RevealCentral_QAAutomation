package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;


public class UsersAndRolesPage extends LiglBaseSessionPage {
    @FindBy(id = "add-user-roles-btn")
    WebElement AddUserBtn;
    @FindBy(id = "role-sel-input")
    WebElement RolesAssignedDP;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement RolesDPSearch;
    @FindBy(xpath = "//mat-select[@id='role-sel-input']//span//span")
    WebElement SelectedDPValue;

    /********************************************************************************************/
    @FindBy(id = "add-user-roles-btn")
    WebElement addUserBtn;
    @FindBy(id = "ligl-user-opt-button")
    WebElement liglUserBtn;
    @FindBy(id = "sso-user-opt-button]")
    WebElement ssoUserBtn;
    @FindBy(xpath = "//input[@aria-label='email']")
    WebElement emailTxtBox;
    @FindBy(id = "frst-name-input")
    WebElement firstNameTxtBox;
    @FindBy(id = "lst-name-input")
    WebElement lastNameTxtBox;
    @FindBy(id = "mid-name-input")
    WebElement middleNameTxtBox;
    @FindBy(id = "role-sel-input")
    WebElement roleAssigDropDown;
    @FindBy(id = "role-sel-inputstatus")
    WebElement statusDropDown;
    @FindBy(id = "usr-name-input")
    WebElement userNameTxtBox;

    @FindBy(xpath = "//span[@class='mat-checkbox-inner-container']")
    WebElement manualPwdChk;
    @FindBy(id = "password-input")
    WebElement pwdTxtBox;
    @FindBy(id = "conf-password-input")
    WebElement confPwdTxtBox;
    @FindBy(id = "add-edit-users-save-btn")
    WebElement saveBtn;
    @FindBy(id = "add-edit-users-cancel-btn")
    WebElement cancelbtn;


    //Do you want to send password in mail?
    @FindBy(xpath = "//button[normalize-space()='Yes']")
    //@FindBy(id = "users-and-roles-save-btn")
            WebElement yesBtn;
    @FindBy(id = "//button[contains(text(), 'No')]")
    WebElement noBtn;
    @FindBy(xpath = "//span[contains(text(),'User Name')]/ancestor::div[@ref='eLabel']")
    WebElement UserNameColumn;
    @FindBy(xpath = "//span[@ref='eMenu']")
    WebElement menu;
    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement filter;
    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;
    @FindBy(xpath = "//button[@title='Edit']")
    public WebElement editBtn;
    @FindBy(xpath = "//div[@class='alert-success alert-align ng-star-inserted']")
    WebElement sucessAlert;
    @FindBy(xpath = "//button[@title='Reset Password']")
    WebElement restPasswordBtn;
    @FindBy(xpath = "//button[@class='btn primary-button ng-star-inserted'][contains(text(), 'Yes')]")
    WebElement restPassEmailBtn;
    @FindBy(xpath = "//button[contains(text(), 'Ok')]")
    WebElement PsswdResetOk;
    @FindBy(xpath = "//button[@title='Password reset is not possible for SSO']")
    WebElement ssoRestPasswordBtn;
    @FindBy(id = "btn-clear-userroles")
    WebElement userRolesClearBtn;
    @FindBy(xpath = "//small[@class='custom-label-error ng-star-inserted']")
    WebElement userValidationMessage;

    Actions ac = new Actions(getCurrentDriver());

    /**
     * Method to check the Availability od Custodian Role in Roles Assigned Dropdown in Create role pop up
     *
     * @return
     * @throws Exception
     */
    public ILiglPage checkCustodianRoleInUserCreationPopUp(String Role) throws Exception {
        try {
            log_Info("checkCustodianRoleInUserCreationPopUp() Started");
            AddUserBtn.click();
            Thread.sleep(3000);
            log_Info("Add User button Clicked");
            RolesAssignedDP.click();
            RolesAssignedDP.sendKeys("Custodian");
            Thread.sleep(3000);
            RolesAssignedDP.sendKeys(Keys.ENTER);
            log_Info("Role is selected");
            String RoleVal = SelectedDPValue.getText();
            Assert.assertEquals(RoleVal, Role);
            log_Pass("'" + Role + "' is Present in Roles Assigned DropDown");

            return new UsersAndRolesPage();

        } catch (Exception ex) {
            log_Error("checkCustodianRoleInUserCreationPopUp() is Failed");
            throw new Exception("Exception in checkCustodianRoleInUserCreationPopUp()", ex);

        }
    }

    /********************************************************************************************/
    public ILiglPage clickOnAddUserButton() throws Exception {
        //Click +User Button
        getSession().log_Info("Click on '+User' Button");
        getDriver().waitForelementToBeClickable(addUserBtn);
        addUserBtn.click();
        getSession().log_Pass("Clicked on '+User' Button");
        return new UsersAndRolesPage();
    }

    public ILiglPage swithToLiglUser() throws Exception {
        //Select the Ligl User Option
        log_Info("Click on Ligl User");
        liglUserBtn.click();
        getSession().log_Pass("Clicked on Ligl User");
        return new UsersAndRolesPage();
    }

    public ILiglPage searchTheUser(String selectUser) throws Exception {
        log_Info("Hover on Name Header");
        wait(2);
        getDriver().waitForelementToBeClickable(UserNameColumn);
        ac.moveToElement(UserNameColumn).perform();
        getSession().log_Pass("Hovered on Name Header");
        log_Info("Click the Menu");
        getDriver().waitForelementToBeClickable(menu);
        menu.click();
        getSession().log_Pass("Clicked the Menu");
        log_Info("Click the filter");
        getDriver().waitForelementToBeClickable(filter);
        filter.click();
        getSession().log_Pass("Clicked on filter");

        log_Info("Enter the User Name");
        wait(1);
        Searchbar.sendKeys(selectUser);
        filter.click();
        wait(3);
        getSession().log_Pass("Entered the User Name");

        return new UsersAndRolesPage();
    }

    public ILiglPage scrollToRightToDoActionInUsers(String selectUser) throws Exception {
        try {
            log_Info("Click Scroll Bar And Move to Right");
            getCurrentDriver().findElement(By.xpath("//div[contains(text(), '" + selectUser + "')]")).click();
            for (int i = 0; i < 6; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");
            return new UsersAndRolesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Scroll To Right To DoAction Failed", ex);

        }
    }

    public ILiglPage refreshUserAndRolesPage() throws Exception {
        getCurrentDriver().navigate().refresh();
        wait(2);
        return new UsersAndRolesPage();
    }

    /**
     * TC 12160 Verify the process of creating Ligl user by selecting Ligl user option in +User modal with Manual Password
     **/
    /**
     * TC22059-Verify the process of creating Ligl user by selecting Ligl user option in +User modal without selecting Manual Password.
     **/

    public ILiglPage creatingLiglUser(
            String userName, String email, String firstName,
            String middleName, String lastName, String role, String status,
            String passWordConfirmation, String password, String confirmPassword, String sendPasswordInEmail
    ) throws Exception {
        try {

            //User Name
            log_Info("Enter the User Name");
            userNameTxtBox.sendKeys(userName);
            getSession().log_Pass("Entered the User Name");
            //email
            log_Info("Enter the Email");
            emailTxtBox.sendKeys(email);
            getSession().log_Pass("Entered the email");
            //First Name
            log_Info("Enter the First Name");
            firstNameTxtBox.sendKeys(firstName);
            getSession().log_Pass("Entered the First Name");
            //Middle Name
            log_Info("Enter the Middle Name");
            middleNameTxtBox.sendKeys(middleName);
            getSession().log_Pass("Entered the Middle Name");
            //Last Name
            log_Info("Enter The Last Name");
            lastNameTxtBox.sendKeys(lastName);
            getSession().log_Pass("Entered the Last Name");
            //Role
            if (role.contains("Please Select")) {
                log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(role);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(role);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the Role");
            }
            //Status
            log_Info("Select the User Status");
            statusDropDown.sendKeys(status);
            wait(1);
            statusDropDown.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected the User Status and Status is " + status);
            //Manual Password Check
            if (passWordConfirmation.contains("Yes")) {
                log_Info("Check the 'Manual Password' Check Box");
                manualPwdChk.click();
                getSession().log_Pass("Checked the 'Manual Password' Check Box");
                //Password
                log_Info("Enter the 'Manual Password'");
                pwdTxtBox.sendKeys(password);
                getSession().log_Pass("Entered the 'Manual Password'");
                //Confirm Password
                log_Info("Enter the 'Confirm Password'");
                confPwdTxtBox.sendKeys(confirmPassword);
                getSession().log_Pass("Entered the 'Confirm Password'");
            }

            //Save
            log_Info("Click on 'Save' Button");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
            wait(1);
            saveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            //SendPasswordInEmail
            if (sendPasswordInEmail.contains("Yes")) {
                log_Info("Click on 'Yes' Button");
                getDriver().waitForelementToBeClickable(yesBtn);
                yesBtn.click();
                getSession().log_Pass("Clicked on 'Yes' Button");
            }
            try {
                sucessAlert.isDisplayed();
                wait(2);
                Assert.assertEquals(sucessAlert.getText(), "Success! User Created Successfully");
                getSession().log_Pass(userName + "User Created Successfully");
            } catch (Exception exception) {
                getSession().log_Info("Check whether duplicate validation message is displaying");
            }

            /*if (UserCreationConfirmation.contains("Save")) {
                log_Info("Click on 'Save' Button");
                ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", saveBtn);
                wait(1);
                saveBtn.click();
                getSession().log_Pass("Clicked on Save Button");

                log_Info("send password in mail");
                if (sendPasswordInMailConfirmation.contains("Yes")) {
                    log_Info("Click on 'Yes' Button");
                    getDriver().waitForelementToBeClickable(yesBtn);
                    yesBtn.click();
                    getSession().log_Pass("Clicked on 'Yes' Button");
                    getSession().log_Pass("send password to " + email + "email");
                } else if (sendPasswordInMailConfirmation.contains("No")) {
                    log_Info("Click on 'No' Button");
                    getDriver().waitForelementToBeClickable(noBtn);
                    noBtn.click();
                    getSession().log_Pass("Clicked on 'No' Button");
                    getSession().log_Pass("send not password to " + email + "email");
                }

                wait(3);
                String actualAlertSucess = sucessAlert.getText();
                Assert.assertEquals(actualAlertSucess, "Success! User Created Successfully");
                getSession().log_Pass(userName + " User Created Successfully");
            } else if (UserCreationConfirmation.contains("Cancel")) {
                log_Info("Click on 'Cancel' Button");
                wait(1);
                cancelbtn.click();
                getSession().log_Pass("Clicked on 'Cancel' Button");
                getSession().log_Pass(userName + " User Creation Cancled");
            }*/
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("creating Ligl User With Manual Password failed", ex);
        }
    }

    /**
     * SSO User creation
     */
    public ILiglPage creatingSSOUser(
            String email, String firstName, String middleName, String lastName, String role, String status
    ) throws Exception {
        try {

            log_Info("Enter the Email");
            emailTxtBox.sendKeys(email);
            getSession().log_Pass("Entered the email");
            //First Name
            log_Info("Enter the First Name");
            firstNameTxtBox.sendKeys(firstName);
            getSession().log_Pass("Entered the First Name");
            //Middle Name
            log_Info("Enter the Middle Name");
            middleNameTxtBox.sendKeys(middleName);
            getSession().log_Pass("Entered the Middle Name");
            //Last Name
            log_Info("Enter The Last Name");
            lastNameTxtBox.sendKeys(lastName);
            getSession().log_Pass("Entered the Last Name");
            //Role
            if (role.contains("Please Select")) {
                log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(role);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(role);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the Role");
            }
            //Status
            log_Info("Select the User Status");
            statusDropDown.sendKeys(status);
            wait(1);
            statusDropDown.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected the User Status and Status is " + status);

            //Save
            log_Info("Click on 'Save' Button");
            saveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            //SendPasswordInEmail
            log_Info("Click on 'Yes' Button");
            getDriver().waitForelementToBeClickable(yesBtn);
            yesBtn.click();
            getSession().log_Pass("Clicked on 'Yes' Button");
            try {
                sucessAlert.isDisplayed();
                wait(2);
                Assert.assertEquals(sucessAlert.getText(), "Success! User Created Successfully");
                getSession().log_Pass("User Created Successfully");
            } catch (Exception exception) {
                getSession().log_Info("Check whether duplicate validation message is displaying");
            }
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Creating SSO User failed", ex);
        }
    }


    /**
     * 12104 Verify the process of editing existing users by using Edit User button in grid
     **/

    public ILiglPage editTheUser(String editUserName, String editEmail, String editFirstName,
                                 String editMiddleName, String editLastName, String editRole, String editStatus,
                                 String userEditingConfirmation
    ) throws Exception {
        try {

            //click edit
            log_Info("Click on 'edit' button");
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");
            //User Name
            log_Info("Clear the 'User Name'");
            userNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'User Name'");
            log_Info("Enter the User Name");
            userNameTxtBox.sendKeys(editUserName);
            getSession().log_Pass("Entered the User Name");
            //email
            log_Info("Clear the 'Email',");
            emailTxtBox.clear();
            getSession().log_Pass("Cleared the 'Email'");
            log_Info("Enter the Email");
            emailTxtBox.sendKeys(editEmail);
            getSession().log_Pass("Entered the email");
            //First Name
            log_Info("Clear the 'First Name'");
            firstNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'First Name'");
            log_Info("Enter the First Name");
            firstNameTxtBox.sendKeys(editFirstName);
            getSession().log_Pass("Entered the First Name");
            //Middle Name
            log_Info("Clear the 'Middle Name'");
            middleNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'Middle Name'");
            log_Info("Enter the Middle Name");
            middleNameTxtBox.sendKeys(editMiddleName);
            getSession().log_Pass("Entered the Middle Name");
            //Last Name
            log_Info("Clear the 'Last Name'");
            lastNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'Last Name'");
            log_Info("Enter the Last Name");
            lastNameTxtBox.sendKeys(editLastName);
            getSession().log_Pass("Entered the Last Name");
            //Role
            if (editRole.contains("Please Select")) {
                log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(editRole);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(editRole);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the Role");
            }
            //Status
            log_Info("Select the User Status");
            statusDropDown.sendKeys(editStatus);
            wait(1);
            statusDropDown.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Selected the User Status and Status is " + editStatus.toUpperCase());
            //Save or Cancle
            if (userEditingConfirmation.contains("Save")) {
                log_Info("Click on 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getSession().log_Pass("Clicked on 'Save' Button");
                log_Info("Click on 'Yes' Button");
                getDriver().waitForelementToBeClickable(yesBtn);
                yesBtn.click();
                getSession().log_Pass("Clicked on 'Yes' Button");
                wait(3);
                try {
                    sucessAlert.isDisplayed();
                    Assert.assertEquals(sucessAlert.getText(), "Saved Successfully");
                    getSession().log_Pass("User Edited Successfully");

                } catch (Exception exception) {
                    getSession().log_Info("Check whether duplicate validation message is displaying");
                }

            } else if (userEditingConfirmation.contains("Cancel")) {
                log_Info("Click on 'Cancel' Button");
                getDriver().waitForelementToBeClickable(cancelbtn);
                cancelbtn.click();
                getSession().log_Pass("Clicked on 'Cancel' Button");
                getSession().log_Pass("User Editing Cancelled");
            }
            wait(4);
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("edit The User failed", ex);
        }
    }

    /*
     *edit sso user
     *  */
    public ILiglPage editSSOUser(String editEmail, String editFirstName,
                                 String editMiddleName, String editLastName, String editRole, String editStatus
    ) throws Exception {
        try {
            //click edit
            log_Info("Click on 'edit' button");
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");
            //email
            log_Info("Clear the 'Email',");
            emailTxtBox.clear();
            getSession().log_Pass("Cleared the 'Email'");
            log_Info("Enter the Email");
            emailTxtBox.sendKeys(editEmail);
            getSession().log_Pass("Entered the email");
            //First Name
            log_Info("Clear the 'First Name'");
            firstNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'First Name'");
            log_Info("Enter the First Name");
            firstNameTxtBox.sendKeys(editFirstName);
            getSession().log_Pass("Entered the First Name");
            //Middle Name
            log_Info("Clear the 'Middle Name'");
            middleNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'Middle Name'");
            log_Info("Enter the Middle Name");
            middleNameTxtBox.sendKeys(editMiddleName);
            getSession().log_Pass("Entered the Middle Name");
            //Last Name
            log_Info("Clear the 'Last Name'");
            lastNameTxtBox.clear();
            getSession().log_Pass("Cleared the 'Last Name'");
            log_Info("Enter the Last Name");
            lastNameTxtBox.sendKeys(editLastName);
            getSession().log_Pass("Entered the Last Name");
            //Role
            if (editRole.contains("Please Select")) {
                log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(editRole);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(editRole);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the Role");
            }
            //Status
            log_Info("Select the User Status");
            statusDropDown.sendKeys(editStatus);
            wait(1);
            statusDropDown.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Selected the User Status and Status is " + editStatus.toUpperCase());
            //Save or Cancle
            log_Info("Click on 'Save' Button");
            getCurrentDriver().findElement(By.id("add-edit-users-save-btn")).click();
            getSession().log_Pass("Clicked on 'Save' Button");
            wait(2);

            try {
                sucessAlert.isDisplayed();
                Assert.assertEquals(sucessAlert.getText(), "Saved Successfully");
                getSession().log_Pass("User Edited Successfully");

            } catch (Exception exception) {
                getSession().log_Info("Check whether duplicate validation message is displaying");
            }
            wait(4);
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("edit The SSo failed", ex);
        }
    }


    /**
     * TC22518 Check whether User able Login with Admin Reset Password
     */

    public ILiglPage adminResetPassword(String conformManualPawdReset, String password, String confirmPassword) throws Exception {
        try {
            //click rest password
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");
            getSession().log_Info("Click Rest Password");
            getDriver().waitForelementToBeClickable(restPasswordBtn);
            restPasswordBtn.click();
            getSession().log_Pass("Clicked Rest Password");
            //Manual Password Check
            if (conformManualPawdReset.contains("yes")) {
                log_Info("Check the 'Manual Password' Check Box");
                manualPwdChk.click();
                getSession().log_Pass("Checked the 'Manual Password' Check Box");
                //Password
                log_Info("Enter the 'Manual Password'");
                pwdTxtBox.sendKeys(password);
                getSession().log_Pass("Entered the 'Manual Password'");
                //Confirm Password
                log_Info("Enter the 'Confirm Password'");
                confPwdTxtBox.sendKeys(confirmPassword);
                getSession().log_Pass("Entered the 'Confirm Password'");
                log_Info("Click on 'Yes' Button");
                getDriver().waitForelementToBeClickable(yesBtn);
                yesBtn.click();
                getSession().log_Pass("Clicked on 'Yes' Button");
                log_Info("Click on 'Yes' Button for send password in mail");
                getDriver().waitForelementToBeClickable(restPassEmailBtn);
                restPassEmailBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Yes' Button send password in mail");
                getSession().log_Info("Click 'Ok' Button");
                PsswdResetOk.click();
                getSession().log_Pass("Clicked 'Ok' Button");
            } else if (conformManualPawdReset.contains("no")) {
                log_Info("Click on 'Yes' Button");
                getDriver().waitForelementToBeClickable(yesBtn);
                yesBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Yes' Button");
                getSession().log_Info("Click 'Ok' Button");
                PsswdResetOk.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked 'Ok' Button");
            }
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Login With Admin Reset Password", ex);
        }
    }

    /**
     * TC25171 SSO User - Check whether 'Reset Password' button in grid is Click Disabled
     */

    public ILiglPage restPasswordClickDisabledForSSOUser(String searchSSOUser) throws Exception {
        try {
            getSession().log_Info("Check that 'Reset Password' button is Click Disabled");
            boolean actualValue = ssoRestPasswordBtn.isEnabled();
            Assert.assertEquals(actualValue, false);
            getSession().log_Pass("'Reset Password' button is Click Disabled");
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("'Rest Password' Click Disabled For SSO User failed", ex);
        }
    }

    /**
     * TC28525 - Ligl & SSO users - Check whether user is able to change role to another role or no role
     */

    public ILiglPage changeRole(String roleChangeTo) throws Exception {
        try {
            //click edit
            log_Info("Click on 'edit' button");
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");
            //Role
            if (roleChangeTo.contains("Please Select")) {
                getSession().log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(roleChangeTo);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                getSession().log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(roleChangeTo);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the " + roleChangeTo.toUpperCase() + " Role");
            }
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getSession().log_Info("Click on 'Yes' Button");
            getDriver().waitForelementToBeClickable(yesBtn);
            yesBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Yes' Button");

            wait(5);
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Change Role failed", ex);
        }

    }

    public ILiglPage changeSSORole(String roleChangeTo) throws Exception {
        try {
            //click edit
            log_Info("Click on 'edit' button");
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");
            //Role
            if (roleChangeTo.contains("Please Select")) {
                getSession().log_Info("Assign No Role");
                roleAssigDropDown.sendKeys(roleChangeTo);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("No Role Assigned");
            } else {
                getSession().log_Info("Assign the Role");
                roleAssigDropDown.sendKeys(roleChangeTo);
                wait(1);
                roleAssigDropDown.sendKeys(Keys.ENTER);
                getSession().log_Pass("Assigned the " + roleChangeTo.toUpperCase() + " Role");
            }
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            wait(4);
            getSession().log_Pass("Clicked on 'Save' Button");
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Change SSO Role failed", ex);
        }

    }


    /**
     * 51900	Users & Roles-Ligl & SSO users-Create & Edit - Check duplicate validation message is displaying for 'Username' field
     */

    public ILiglPage duplicateValidationMessageForLiglUser() throws Exception {
        try {
            wait(2);
            Assert.assertEquals(userValidationMessage.getText(), "SW100008-User already exists");
            getSession().log_Pass("Duplicate validation message is displaying for 'Username' field");
            getSession().log_Info("Click on 'Cancel' Button");
            getDriver().waitForelementToBeClickable(cancelbtn);
            cancelbtn.click();
            getSession().log_Pass("Clicked on 'Cancel' Button");
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Change Role failed", ex);
        }

    }

    public ILiglPage duplicateValidationMessageForSSOUser() throws Exception {
        try {
            wait(2);
            Assert.assertEquals(userValidationMessage.getText(), "Email ID already exists");
            getSession().log_Pass("Duplicate validation message is displaying for 'Email' field");
            getSession().log_Info("Click on 'Cancel' Button");
            getDriver().waitForelementToBeClickable(cancelbtn);
            cancelbtn.click();
            getSession().log_Pass("Clicked on 'Cancel' Button");
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Change Role failed", ex);
        }

    }

    public ILiglPage clickOnEditButton(String user) throws Exception {
        //click edit
        log_Info("Click on 'edit' button");
        editBtn.click();
        getSession().log_Pass("Clicked on 'edit' button");
        return this;
    }

    public ILiglPage verifyTheDataCreateUserPopUp() throws Exception {
        try {
            //User Name
            getDriver().waitForelementToBeClickable(userNameTxtBox);
            getSession().setRegressionData("TC12160_UserName", userNameTxtBox.getAttribute("value"));
            //email
            getDriver().waitForelementToBeClickable(emailTxtBox);
            getSession().setRegressionData("TC12160_Email", emailTxtBox.getAttribute("value"));
            //First Name
            getDriver().waitForelementToBeClickable(firstNameTxtBox);
            String firstNAme = firstNameTxtBox.getAttribute("value");
            //Middle Name
            getDriver().waitForelementToBeClickable(middleNameTxtBox);
            String middleName = middleNameTxtBox.getAttribute("value");
            //Last Name
            getDriver().waitForelementToBeClickable(lastNameTxtBox);
            String lastName = lastNameTxtBox.getAttribute("value");


            //Role
            getDriver().waitForelementToBeClickable(roleAssigDropDown);
            roleAssigDropDown.getText();
            //Status
            getDriver().waitForelementToBeClickable(statusDropDown);
            statusDropDown.getText();
            //Password
            getDriver().waitForelementToBeClickable(pwdTxtBox);
            pwdTxtBox.getAttribute("value");
            //Confirm Password
            getDriver().waitForelementToBeClickable(confPwdTxtBox);
            confPwdTxtBox.getAttribute("value");
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Verify The Data User PopUp failed", ex);
        }
    }

    public ILiglPage getFieldsDataFromSSOUserPopUp(Hashtable<String, String> data) throws Exception {
        try {
            clickOnAddUserButton();
            creatingSSOUser(data.get("Email"), data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Role"), data.get("Status"));
            searchTheUser(data.get("Email"));
            scrollToRightToDoActionInUsers(data.get("Email"));
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            //SSOEmail
            getSession().setRegressionData("get_SSOEmail", emailTxtBox.getAttribute("value"));

            //First Name
            getSession().setRegressionData("get_SSOFirstName", firstNameTxtBox.getAttribute("value"));

            //Middle Name
            getSession().setRegressionData("get_SSOMiddleName", middleNameTxtBox.getAttribute("value"));

            //Last Name
            getSession().setRegressionData("get_SSOLastName", lastNameTxtBox.getAttribute("value"));

            //Roles Assigned
            getSession().setRegressionData("get_SSORolesAssigned", roleAssigDropDown.getText());

            //Status
            getSession().setRegressionData("get_SSOStatus", statusDropDown.getText());

            getDriver().waitForelementToBeClickable(cancelbtn);
            cancelbtn.click();
            getDriver().waitForAngularRequestsToComplete();
            return new UsersAndRolesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Verify The Data User PopUp failed", ex);
        }
    }


}
