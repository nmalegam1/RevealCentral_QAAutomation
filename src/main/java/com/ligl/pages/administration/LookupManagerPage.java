package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class LookupManagerPage extends LiglBaseSessionPage {
    @FindBy(css = ".dropdown.open.show")
    public WebElement lookUpTypeDrpDwn;

    @FindBy(xpath = "//li[@role='menuitem'][2]//i")
    public WebElement expandEntityDrpDwn;

    @FindBy(id = "add-lookupType-btn")
    public WebElement newBtn;

    @FindBy(id = "btn-lkup-refresh")
    public WebElement gridRefreshBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    public WebElement deletBtn;

    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Name']")
    public WebElement nameColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    public WebElement menu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement Searchbar;

    @FindBy(id = "name")
    public WebElement nameTxt;

    @FindBy(id = "displayOrder")
    public WebElement displayOrderTx;

    @FindBy(id = "description")
    public WebElement descriptionTxt;

    @FindBy(id = "select-entitytype")
    public WebElement entityTypeDrpDwn;

    @FindBy(id = "btn-save")
    public WebElement saveBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    public WebElement cancelBtn;

    @FindBy(xpath = "//button[normalize-space()='Reset']")
    public WebElement resetBtn;

    Actions ac = new Actions(getCurrentDriver());

    /**
     * Select Lookup Type
     */
    public ILiglPage selectLookupType(String lookup) throws Exception {
        try {

            // Select Lookup type
            getSession().log_Info("Click on 'Select Lookup type' Drop Down");
            getDriver().waitForelementToBeClickable(lookUpTypeDrpDwn);
            lookUpTypeDrpDwn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Select Lookup type' Drop Down");

            // Select the Lookup
            getSession().log_Info("Select the 'Lookup'");
            if (lookup.contains("Sub Entity")) {
                getSession().log_Info("Expand sub Entity Drop Down");
                getDriver().waitForelementToBeClickable(expandEntityDrpDwn);
                expandEntityDrpDwn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("sub Entity Drop Down Expanded");
                getDriver().waitForAngularRequestsToComplete();
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + lookup + "')]")).click();
                getSession().log_Pass("Lookup Selected as " + lookup.toUpperCase());
                return new LookupManagerPage();
            } else {
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + lookup + "')]")).click();
                getSession().log_Pass("'Lookup' Selected as " + lookup.toUpperCase());
                return new LookupManagerPage();
            }
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Select Lookup Type Failed", ex);
        }
    }

    /**
     * New Button
     */

    public ILiglPage clickOnNewButton() throws Exception {
        try {
            // New Button
            getSession().log_Info("Click on '+ New' Button");
            getDriver().waitForelementToBeClickable(newBtn);
            newBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on '+ New' Button");
            return new LookupManagerPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On New Button", ex);
        }
    }

    /**
     * Search And Select The Contact
     */
    public ILiglPage searchAndSelectTheLookUp(String name) throws Exception {
        try {
            wait(2);
            getSession().log_Info("Hover on Name Header");
            getDriver().waitForelementToBeClickable(nameColumn);
            getDriver().waitForMoveToElement(nameColumn);
            getSession().log_Pass("Hovered on Name Header");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menu);
            getDriver().waitForMoveToElement(menu);
            menu.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filter);
            filter.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Name in Search Bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Searchbar.sendKeys(name);
            filter.click();
            getSession().log_Pass("Entered the Name in Search Bar");

            // select the edit button
            log_Info("Click Scroll Bar And Move to Right");
            wait(1);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + name + "')]")).click();
            wait(1);
            for (int i = 0; i < 2; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

            getSession().log_Info("Click on 'edit' button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");

            return new LookupManagerPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search And Select LookUp Failed", ex);
        }

    }

    /**
     * Create LookUp
     */
    public ILiglPage createLookUp(String name, String displayOrder, String description, String entityType)
            throws Exception {
        try {
            // Name
            getSession().log_Info("Enter 'Name'");
            getDriver().waitForelementToBeClickable(nameTxt);
            nameTxt.sendKeys(name);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Name' Entered");

            // Display Order
            getDriver().waitForelementToBeClickable(displayOrderTx);
            getSession().log_Info("Clear the 'Display Order' field");
            displayOrderTx.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            wait(1);
            getSession().log_Pass("'Display Order 'field Cleared");
            String displayOrderNew = displayOrder.replace("*", ""); // remove special character
            displayOrderTx.sendKeys(displayOrderNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Display Order' Entered");

            // Description
            getSession().log_Info("Enter 'Description'");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(description);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            try {
                if (getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Entity Type')]")).isDisplayed()) {
                    getDriver().waitForelementToBeClickable(entityTypeDrpDwn);
                    getSession().log_Info("Select the 'Entity Type'");
                    entityTypeDrpDwn.sendKeys(entityType);
                    wait(1);
                    entityTypeDrpDwn.sendKeys(Keys.ENTER);
                    getSession().log_Pass("'Entity' Selected");
                }

                // Save Button
                getSession().log_Info("Click on 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Save' Button");
            } catch (Exception e) {
                // Save Button
                getSession().log_Info("Click on 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Save' Button");
            }

            wait(2);
            return new LookupManagerPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create Lookup Failed ", ex);
        }
    }

    /* Edit LooUp */

    public ILiglPage editLookUp(String name, String displayOrder, String description, String entityType)
            throws Exception {
        try {

            // Name
            getDriver().waitForelementToBeClickable(nameTxt);
            getSession().log_Info("Clear the 'Name' field");
            wait(1);
            nameTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            wait(1);
            getSession().log_Pass("'Name' field Cleared");
            getSession().log_Info("Enter 'Name'");
            nameTxt.sendKeys(name);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Name' Entered");

            // Display Order
            getDriver().waitForelementToBeClickable(displayOrderTx);
            getSession().log_Info("Clear the 'Display Order' field");
            displayOrderTx.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Display Order 'field Cleared");
            String displayOrderNew = displayOrder.replace("*", ""); // remove special character
            displayOrderTx.sendKeys(displayOrderNew);
            displayOrderTx.sendKeys(Keys.TAB);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Display Order' Entered");

            // Description
            getDriver().waitForelementToBeClickable(descriptionTxt);
            getSession().log_Info("Clear the 'Description' field");
            descriptionTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("'Description' field Cleared");
            getSession().log_Info("Enter 'Description'");
            descriptionTxt.sendKeys(description);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            try {
                // Entity Type
                if (getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Entity Type')]")).isDisplayed()) {
                    getDriver().waitForelementToBeClickable(entityTypeDrpDwn);
					/*getSession().log_Info("Clear the 'Entity Type' field");
					entityTypeDrpDwn.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
					getSession().log_Pass("'Entity Type' field Cleared");*/
                    getSession().log_Info("Select the 'Entity Type'");
                    entityTypeDrpDwn.sendKeys(entityType);
                    wait(1);
                    entityTypeDrpDwn.sendKeys(Keys.ENTER);
                    getSession().log_Pass("'Entity' Selected");
                }

                // Save Button
                getSession().log_Info("Click on 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Save' Button");
            } catch (Exception e) {
                // Save Button
                getSession().log_Info("Click on 'Save' Button");
                getDriver().waitForelementToBeClickable(saveBtn);
                saveBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on 'Save' Button");
            }

            // Grid Refresh
            /*getSession().log_Info("Click on Grid Refresh Button");
            getDriver().waitForelementToBeClickable(gridRefreshBtn);
            gridRefreshBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Grid Refresh Button");*/

            wait(4);
            return new LookupManagerPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Lookup Failed ", ex);
        }
    }
}
