package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class StakeHoldersPage extends LiglBaseSessionPage {
    @FindBy(css = "#add-stkhldr-btn")
    public WebElement addStakeholderBtn;

    @FindBy(id = "btn-clear-adminstakeholder")
    public WebElement clearBtn;

    @FindBy(id = "refresh-data")
    public WebElement refreshGridBtn;

    @FindBy(id = "lhns-add-fname")
    public WebElement firstNameTxt;

    @FindBy(id = "lhns-add-mname")
    public WebElement middleNameTxt;

    @FindBy(id = "lhns-add-lname")
    public WebElement lastNameTxt;

    @FindBy(id = "lhns-add-email")
    public WebElement emailTxt;

    @FindBy(id = "lhns-add-deptdepartment")
    public WebElement departmentDrpDwn;

    @FindBy(id = "lhns-add-categorycategory")
    public WebElement categoryDrpDwn;

    @FindBy(id = "lhns-add-statusstatus")
    public WebElement statusDrpDwn;

    @FindBy(id = "lhns-add-changereason")
    public WebElement statusChangeReasonTxt;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelBtn;

    @FindBy(xpath = "//button[contains(text(),'No')]")
    public WebElement noBtn;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    public WebElement yesBtn;

    @FindBy(xpath = "//button[contains(text(),'SAVE')]")
    public WebElement saveBtn;

    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Email']")
    public WebElement emailColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[4]")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filterBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement searchBar;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    public WebElement deleteBtn;

    @FindBy(xpath = "//div[@aria-label='Records are updated']")
    public WebElement recordUpdateValidation;

    @FindBy(css = ".error-message.custom-label-error")
    public WebElement errorMessageValidation;

    Actions ac = new Actions(getCurrentDriver());

    public ILiglPage clickOnAddStakeholderButton() throws Exception {
        getSession().log_Info("Click on '+Stakeholder' Button");

        wait(1);
        getDriver().waitForelementToBeClickable(addStakeholderBtn);
        addStakeholderBtn.click();

        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on '+Stakeholder' Button");
        return new StakeHoldersPage();
    }

    public ILiglPage searchTheStakeholder(String email) throws Exception {
        try {
            wait(2);
            getSession().log_Info("Hover on Email Header");
            getDriver().waitForelementToBeClickable(emailColumn);
            getDriver().waitForMoveToElement(emailColumn);
            getSession().log_Pass("Hovered on Email Column");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menuBtn);
            getDriver().waitForMoveToElement(menuBtn);
            menuBtn.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filterBtn);
            filterBtn.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Email in Search Bar");
            getDriver().waitForelementToBeClickable(searchBar);
            searchBar.sendKeys(email);
            filterBtn.click();
            getSession().log_Pass("Entered the Email in Search Bar");

            return new StakeHoldersPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search The Stakeholder Failed", ex);
        }
    }


    public ILiglPage scrollToRightToDoAction(String email) throws Exception {
        try {
            log_Info("Click Scroll Bar And Move to Right");
            getDriver().customXpathBasedOnTextValue(email).click();
            wait(1);
            getDriver().moveToRightInAngularTable("1");
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Scroll To Right To DoAction Failed", ex);
        }
    }


    public ILiglPage createStakeholder(String firstName, String middleName, String lastName, String email,
                                       String department, String category) throws Exception {
        try {
            //First Name
            getSession().log_Info("Enter 'First Name'");
            getDriver().waitForelementToBeClickable(firstNameTxt);
            firstNameTxt.sendKeys(firstName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'First Name' Entered");

            //Middle Name
            getSession().log_Info("Enter 'Middle Name'");
            getDriver().waitForelementToBeClickable(middleNameTxt);
            middleNameTxt.sendKeys(middleName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Middle Name' Entered");

            //Last Name
            getSession().log_Info("Enter 'Last Name'");
            getDriver().waitForelementToBeClickable(lastNameTxt);
            lastNameTxt.sendKeys(lastName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Last Name' Entered");

            //Email
            getSession().log_Info("Enter 'Email'");
            getDriver().waitForelementToBeClickable(emailTxt);
            emailTxt.sendKeys(email);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Email' Entered");

            //Department
            getSession().log_Info("Select 'Department'");
            getDriver().waitForelementToBeClickable(departmentDrpDwn);
            departmentDrpDwn.sendKeys(department);
            wait(1);
            departmentDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Department' Selected");

            //Category
            getSession().log_Info("Select 'Category'");
            getDriver().waitForelementToBeClickable(categoryDrpDwn);
            categoryDrpDwn.sendKeys(category);
            wait(1);
            categoryDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Category' Selected");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            wait(2);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Save' Button");

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create Stakeholder Failed", ex);
        }
    }

    public ILiglPage editExitingStakeholder(String firstName, String middleName, String lastName, String email,
                                            String department, String category, String status, String reason) throws Exception {
        try {
            //Edit Button
            getSession().log_Info("Click on 'edit' button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'edit' button");

            //First Name
            getDriver().waitForelementToBeClickable(firstNameTxt);
            getSession().log_Info("Clear 'First Name'");
            firstNameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'First Name' Cleared");
            getSession().log_Info("Enter 'First Name'");
            firstNameTxt.sendKeys(firstName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'First Name' Entered");

            //Middle Name
            getSession().log_Info("Enter 'Middle Name'");
            getDriver().waitForelementToBeClickable(middleNameTxt);
            getSession().log_Info("Clear 'First Name'");
            middleNameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'First Name' Cleared");
            middleNameTxt.sendKeys(middleName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Middle Name' Entered");

            //Last Name
            getDriver().waitForelementToBeClickable(lastNameTxt);
            getSession().log_Info("Clear 'First Name'");
            lastNameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'First Name' Cleared");
            getSession().log_Info("Enter 'Last Name'");
            lastNameTxt.sendKeys(lastName);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Last Name' Entered");

            //Email
            getDriver().waitForelementToBeClickable(emailTxt);
            getSession().log_Info("Clear 'First Name'");
            emailTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'First Name' Cleared");
            getSession().log_Info("Enter 'Email'");
            emailTxt.sendKeys(email);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Email' Entered");

            //Department
            getSession().log_Info("Select 'Department'");
            getDriver().waitForelementToBeClickable(departmentDrpDwn);
            departmentDrpDwn.sendKeys(department);
            wait(1);
            departmentDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Department' Selected");

            //Category
            getSession().log_Info("Select 'Category'");
            getDriver().waitForelementToBeClickable(categoryDrpDwn);
            categoryDrpDwn.sendKeys(category);
            wait(1);
            categoryDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Category' Selected");

            //Status
            getSession().log_Info("Select 'Status'");
            getDriver().waitForelementToBeClickable(statusDrpDwn);
            statusDrpDwn.sendKeys(status);
            wait(1);
            statusDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Status 'Selected'");

            //Status Change Reason
            getSession().log_Info("Enter 'Status Change Reason'");
            getDriver().waitForelementToBeClickable(statusChangeReasonTxt);
            statusChangeReasonTxt.sendKeys(reason);
            getSession().log_Pass("'Status Change Reason' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForMoveToElement(saveBtn);
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Save' Button");

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Exiting Stakeholder Failed", ex);
        }
    }

    /**
     * TC37922 Admin-Legal Hold-Stakeholders Delete Option-Verify the functionality of delete button in the grid.
     **/

    public ILiglPage deleteTheExitingStakeholder() throws Exception {
        try {
            getSession().log_Info("Click On 'Delete' Button");
            getDriver().waitForelementToBeClickable(deleteBtn);
            deleteBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Delete' Button");

            getSession().log_Info("Are you sure you want to delete?");
            getSession().log_Info("Click On 'Yes' Button");
            getDriver().waitForelementToBeClickable(yesBtn);
            yesBtn.click();

            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Yes' Button");

            wait(3);
            Assert.assertEquals(recordUpdateValidation.getText(), "Records are updated");

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Delete The Exiting Stakeholder Failed", ex);
        }
    }


    public ILiglPage checkStakeholderDisplayingInGrid(String email) throws Exception {
        try {

            try {
                boolean actualValue = getDriver().customXpathBasedOnTextValue(email).isDisplayed();

                getSession().log_Info("Check that newly created Stakeholder Displaying In Stakeholder Grid");
                Assert.assertEquals(actualValue, true);
                getSession().log_Pass("Newly created Stakeholder Displayed In Stakeholder Grid");
            } catch (Exception exception) {
                getSession().log_Info("Check that deleted created Stakeholder not Displaying In Stakeholder Grid");

                getSession().log_Pass("deleted created Stakeholder not Displayed In Stakeholder Grid");
            }

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search And Select The Stakeholder Failed", ex);
        }
    }

    /*
     *TC51903 Admin-Legal Hold-Stakeholders Create & Edit -Check for the duplicate validation message for Email-id field
     *  */

    public ILiglPage verifyTheDuplicateValidationMessage() throws Exception {
        try {
            getSession().log_Info("Verify that Duplicate Validation Message displaying");
            Assert.assertEquals(errorMessageValidation.getText(), "Email ID already exists");
            getSession().log_Pass("'Email ID already exists' Validation Message is displaying");

            //Cancel Button
            getSession().log_Info("Click on Cancel Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Cancel Button");
            wait(1);
            getSession().log_Info("Form has unsaved changes, Do you want to exit?");
            getDriver().waitForelementToBeClickable(yesBtn);
            yesBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Yes' Button");

            return new StakeHoldersPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Verify The Duplicate Validation Message Failed", ex);
        }
    }

}
