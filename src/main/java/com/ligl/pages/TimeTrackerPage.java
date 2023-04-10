package com.ligl.pages;
import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;
public class TimeTrackerPage extends LiglBaseSessionPage {
    @FindBy(id = "add-time-tracker-btn")
    WebElement timeDetailButton;

    @FindBy(id = "btn-clear-timetracker")
    WebElement clearFilterButton;

    @FindBy(xpath = "//button[@title='Edit']")
    WebElement editIcon;

    @FindBy(xpath = "//span[@class='ag-tab ag-tab-selected']")
    WebElement filterIcon;

    @FindBy(xpath = "//button[@class='mat-focus-indicator mat-icon-button mat-button-base']")
    WebElement effortDate;

    @FindBy(xpath = "//mat-select[@id='case']")
    WebElement caseName;

    @FindBy(xpath = "//mat-select[@role='combobox'][@formcontrolname='taskType']")
    WebElement taskType;

    @FindBy(xpath = "//input[@type='text'][@formcontrolname='taskTitle']")
    WebElement taskTitle;

    @FindBy(xpath = "//input[@type='text'][@formcontrolname='hours']")
    WebElement hours;

    @FindBy(xpath = "//textarea[@formcontrolname='description']")
    WebElement description;

    @FindBy(id = "add-edit-time-cancel-btn")
    WebElement cancelButton;

    @FindBy(id = "add-edit-time-save-btn")
    WebElement createButton;

    @FindBy(id="add-edit-time-save-btn")
    WebElement updateButton;



    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//span[contains(text(),'Task Title')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement TaskTitleMenu;

    @FindBy(xpath = "//span[@class='error-message custom-label-error']")
    WebElement HoursValidationMessage;

    @FindBy(id = "swal2-html-container")
    WebElement HoursExceededAlert;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement CaseNameSearch;

    public ILiglPage addTimeDetail(String EffortDate, String CaseName, String TaskName, String TaskTitle, String EffortHours, String Description) throws Exception {

        try {
            log_Info("Click on add time detail button");
            getDriver().waitForelementToBeClickable(timeDetailButton);
            timeDetailButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Time Detail button clicked");

           log_Info("Click on Case Name");
            getDriver().waitForelementToBeClickable(caseName);
            caseName.click();
            CaseNameSearch.sendKeys(CaseName);
            Thread.sleep(20000);
            CaseNameSearch.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected Case name");

            log_Info("Click on Task Type");
            getDriver().waitForelementToBeClickable(taskType);
            taskType.click();
            taskType.sendKeys(TaskName);
            Thread.sleep(5000);
            taskType.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected Task Type");

            log_Info("Click on Task Title");
            getDriver().waitForelementToBeClickable(taskTitle);
            taskTitle.sendKeys(TaskTitle);
            Thread.sleep(5000);
            getSession().log_Pass("Selected Task Title");

            log_Info("Enter Hours");
            getDriver().waitForelementToBeClickable(hours);
            hours.sendKeys(EffortHours);
            Thread.sleep(5000);
            getSession().log_Pass("Entered Hours");

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(description);
            description.sendKeys(Description);
            Thread.sleep(5000);
            getSession().log_Pass("Entered Description");

            log_Info("Click on create button");
            getDriver().waitForelementToBeClickable(createButton);
            createButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on create button");

            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addTimeDetail failed", ex);
        }
    }







    public ILiglPage searchThroughTaskTitle(String TaskTitle) throws Exception {

        try {

            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(TaskTitleMenu).perform();
            Thread.sleep(5000);

            TaskTitleMenu.click();

            Thread.sleep(5000);
            log_Info("Menu clicked");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(5000);
            log_Info("Enter task title");
            Searchbar.sendKeys(TaskTitle);

            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchThroughTaskTitle failed", ex);
        }
    }

    public ILiglPage validateTheAddedDetailsInTheTimeTrackerGrid(String EffortHours, String CaseName, String TaskName, String TaskTitle) throws Exception {

        try {

            log_Info("Check The Column names In The History Grid");

            boolean c1 = getCurrentDriver().findElement(By.xpath("//span[@title='" + EffortHours + "']")).isDisplayed();
            boolean c2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseName + "')]")).isDisplayed();
            boolean c3 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + TaskName + "')]")).isDisplayed();
            boolean c4 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + TaskTitle + "')]")).isDisplayed();


            Thread.sleep(5000);

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);

            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheAddedDetailsInTheTimeTrackerGrid failed", ex);
        }
    }

    public ILiglPage verifyEffortHours(String ValidationMessage) throws Exception {

        try {
            String hours = HoursValidationMessage.getText();
            if (hours.equals(ValidationMessage)) {
                log_Pass("Validation message matching");
            } else {
                log_Error("Validation message not matching");


            }


            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyEffortHours failed", ex);
        }
    }

    public ILiglPage validateHoursExceededAlert(String Alert) throws Exception {

        try {
            String alertText = HoursExceededAlert.getText();
            if (alertText.equals(Alert)) {
                log_Pass("Validation message matching");
            } else {
                log_Error("Validation message not matching");


            }


            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateHoursExceededAlert failed", ex);
        }
    }


    public ILiglPage editFieldsInTimeTrackerPopUp(String EffortDate, String CaseName, String TaskName, String TaskTitle, String EffortHours, String Description) throws Exception {
        try {
            log_Info("Click on edit button");
            getDriver().waitForelementToBeClickable(editIcon);
            editIcon.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on edit button");

            log_Info("Click on Case Name");
            getDriver().waitForelementToBeClickable(caseName);
            caseName.click();
            CaseNameSearch.sendKeys(CaseName);
            Thread.sleep(20000);
            CaseNameSearch.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected Case name");

            log_Info("Click on Task Type");
            getDriver().waitForelementToBeClickable(taskType);
            taskType.click();
            taskType.sendKeys(TaskName);
            Thread.sleep(5000);
            taskType.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected Task Type");

            log_Info("Click on Task Title");
            getDriver().waitForelementToBeClickable(taskTitle);
            taskTitle.clear();
            taskTitle.sendKeys(TaskTitle);
            Thread.sleep(5000);
            getSession().log_Pass("Selected Task Title");

            log_Info("Enter Hours");
            getDriver().waitForelementToBeClickable(hours);
            hours.clear();
            hours.sendKeys(EffortHours);
            Thread.sleep(5000);
            getSession().log_Pass("Entered Hours");

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(description);
            description.clear();
            description.sendKeys(Description);
            Thread.sleep(5000);
            getSession().log_Pass("Entered Description");

            log_Info("Click on update button");
            getDriver().waitForelementToBeClickable(updateButton);
            updateButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on create button");

           return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("editFieldsInTimeTrackerPopUp failed", ex);
        }
    }
    public ILiglPage clickOnClearFilterButton() throws Exception {
        try {
    log_Info("Click on clear filter button");
    getDriver().waitForelementToBeClickable(clearFilterButton);
            clearFilterButton.click();
            Thread.sleep(5000);
    getSession().log_Pass("Clicked on clearFilterButton ");

            return new TimeTrackerPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnClearFilterButton failed", ex);
        }
    }

}
