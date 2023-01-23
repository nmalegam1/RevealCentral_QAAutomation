package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;

//****************CasePage*******************

public class DefaultLandingPage extends LiglBaseSessionPage {


    @FindBy(id="sel-matter-type")
    WebElement CaseType;
    @FindBy(xpath="//div[@id='sel-matter-type-panel']//input[@type='text']")
    WebElement CaseTypeText;
    @FindBy(id="sel-role-type")
    WebElement RoleType;
    @FindBy(xpath="//div[@id='sel-role-type-panel']//input[@type='text']")
    WebElement RoleTypeText;
    @FindBy(id="input-case-name")
    WebElement CaseName;
    @FindBy(id="select-workflow-template")
    WebElement WFT;
    @FindBy(xpath="//div[@id='select-workflow-template-panel']//input[@type='text']")
    WebElement WFTText;
    @FindBy(id="select-optimum-setting")
    WebElement CST;
    @FindBy(xpath="//div[@id='select-optimum-setting-panel']//input[@type='text']")
    WebElement CSTText;
    @FindBy(id = "select-org")
    WebElement Entity;
    @FindBy(xpath="//div[@id='select-org-panel']//input[@type='text']")
    WebElement EntityText;
    @FindBy(id = "select-sub-org")
    WebElement Region;
    @FindBy(xpath="//div[@id='select-sub-org-panel']//input[@type='text']")
    WebElement RegionText;
    @FindBy(id="select-priority")
    WebElement Priority;
    @FindBy(xpath="//div[@id='select-priority-panel']//mat-option[2]")
    WebElement SelPriority;
    @FindBy(xpath = "//textarea[@id='input-description-2']")
    WebElement Desc;
    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement CaseSearchMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CaseSearchFilter;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CaseSearchBar;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]/ancestor::div[@ref='eLabel']")
    WebElement CaseNameHeader;
    @FindBy(id="btn-save-and-add")
    WebElement SaveBtn;
    @FindBy(xpath = "//span[@class='menu-item-parent']/ancestor::a[@ng-click='vmBase.resetMouseHoverPopUp()']//span")
    WebElement NewlyCreatedCaseName;

    @FindBy(id = "btn-create-case")
    WebElement createCaseBtn;
    @FindBy(id = "btn-clear")
    WebElement clearFilterBtn;

    @FindBy(id = "caseAction")
    WebElement selectActionDrp;

    @FindBy(id = "modelaction-btn")
    WebElement runBtn;

    @FindBy(id = "btn-refresh")
    WebElement refreshBtn;



    //Create NewCase
    public ILiglPage createNewCase(Hashtable<String,String> data) throws Exception {
        try {


            log_Info("createNewCase() Started");
            Thread.sleep(3000);
            log_Info("Click Create Case Button");
            createCaseBtn.click();
            log_Info(data.toString());
            log_Info("Enter CaseType");
            getDriver().waitForelementToBeClickable(CaseType);
            CaseType.click();
            Thread.sleep(3000);
            CaseTypeText.sendKeys(data.get("CaseType"));
            Thread.sleep(3000);
            CaseTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.click();
            Thread.sleep(3000);
            RoleTypeText.sendKeys(data.get("Role"));
            Thread.sleep(3000);
            RoleTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter CaseName");
            getDriver().waitForelementToBeClickable(CaseName);
            CaseName.sendKeys(data.get("CaseName"));


            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.click();
            Thread.sleep(3000);
            WFTText.sendKeys(data.get("WFT"));
            Thread.sleep(3000);
            WFTText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            Thread.sleep(3000);
            CSTText.sendKeys(data.get("CaseSetTemp"));
            Thread.sleep(3000);
            CSTText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.click();
            Thread.sleep(3000);
            EntityText.sendKeys(data.get("Entity"));
            Thread.sleep(3000);
            EntityText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Region.click();
            Thread.sleep(3000);
            RegionText.sendKeys(data.get("Region"));
            Thread.sleep(3000);
            RegionText.sendKeys(Keys.ENTER);
            log_Info("Region Entered");
            Thread.sleep(3000);

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Desc.sendKeys(data.get("Description"));

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            Priority.click();
            Thread.sleep(5000);
            SelPriority.click();
            log_Pass("Priority Selected");
            Thread.sleep(3000);

            log_Pass("All Mandatory Fields Are Entered");
            log_Info("Click Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("CaseName"),b);
            log_Pass("Case Created Successfully");
            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in createNewCase()", ex);
        }
    }

                //Clear Filter

    public ILiglPage clickClearFilterBtn() {
        log_Info("Click Clear Filter Button");
        clearFilterBtn.click();
        waitForPageToLoad();
        return new LiglBasePage();
    }

    // Searching a particular case throgh filter

    public ILiglPage searchcase(String CaseName) throws Exception {

        try {

            getDriver().waitForelementToBeClickable(CaseNameHeader);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CaseNameHeader).perform();


            log_Info("pointed mouse to the case name");
            waitForPageToLoad();
            log_Info("click on case search menu");
            CaseSearchMenu.click();
            log_Info("clicked on case search menu");
            waitForPageToLoad();
            log_Info("click on case filter");
            CaseSearchFilter.click();
            log_Info("clicked on case filter");
            waitForPageToLoad();
            log_Info("sending case name to the search bar");
            CaseSearchBar.sendKeys(CaseName);
            log_Info("recieved case name to the search bar");
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchcase() Failed",ex);
        }

    }


    // Particular Case Name Is Selecting

    public ILiglPage GoToCase(String CaseName) throws Exception {

        try {


            log_Info("Select Particular Case Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.linkText(CaseName)).click();
            Thread.sleep(5000);
            log_Info("Particular Case Name Is Selected");
            return new CaseSummaryPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("GoToCase() Failed ",ex);
        }
    }

}
