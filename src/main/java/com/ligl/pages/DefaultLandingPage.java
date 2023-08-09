package com.ligl.pages;

import com.ligl.base.pages.Constants;
import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.CaseCounselPage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;

//****************CasePage*******************

public class DefaultLandingPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//button[@type='submit']")
    WebElement Notes_btn;
    @FindBy(id="sel-matter-typemattertype")
    WebElement CaseType;
    @FindBy(xpath="//div[@id='sel-matter-typemattertype-panel']//input[@type='text']")
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
    @FindBy(xpath="//input[@placeholder='Search']")
    WebElement SelPriority;
    @FindBy(xpath = "//textarea[@id='input-description-2']")
    WebElement Desc;
    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement CaseSearchMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CaseSearchFilter;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CaseSearchBar;

    @FindBy(xpath = "//div[@col-id='Name']//span[@ref='eMenu']")
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

    @FindBy(id="CaseListColumns")
    WebElement ChooseColumnsMenuCase;

    @FindBy(xpath = "//input[@aria-label='Filter Columns Input']")
    WebElement ChooseColumnsSearch;
    @FindBy(xpath = "//span[contains(text(),'Approval Type')]")
    WebElement ApprovalTypeCol;

    @FindBy(xpath = "//span[contains(text(),'Approved Or Rejected By')]")
    WebElement ApprovedOrRejectedByCol;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovedRejectedBy']//span[@class='ellipsisAgGrid']")
    WebElement ApprovedOrRejectedByColData;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalType']//span[@class='ellipsisAgGrid']")
    WebElement ApprovalTypeColData;

    @FindBy(id="btn-custom")
    WebElement MoreBtn;

    @FindBy(id="Column2")
    WebElement AdditionalField1;

    @FindBy(xpath = "//div[@id='Column3']//span[@class='label-txt ng-star-inserted']")
    WebElement AdditionalField2;

    @FindBy(xpath = "//div[@id='Column5']//span[@class='label-txt ng-star-inserted']")
    WebElement AdditionalField3;

    @FindBy(xpath = "//div[@id='Column31']//span[@class='label-txt ng-star-inserted']")
    WebElement AdditionalField4;

    @FindBy(id="Column10")
    WebElement AdditionalField5;

    @FindBy(id="btn-create-cancel")
    WebElement CancelBtn;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement CancelYesBtn;
    @FindBy(xpath = "//div[@col-id='Column31']")
    WebElement AdditionalField4InGrid;

    @FindBy(xpath = "//div[@col-id='Column5']")
    WebElement AdditionalField3InGrid;

    @FindBy(xpath = "//div[@col-id='Column3']")
    WebElement AdditionalField2InGrid;

    @FindBy(xpath = "//div[@col-id='Column2']")
    WebElement AdditionalField1InGrid;

    @FindBy(xpath = "//div[@col-id='Column10']")
    WebElement AdditionalField5InGrid;

    @FindBy(xpath = "//span[contains(text(),'Created By Name')]")
    WebElement CreatedByCol;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='CreatedByName']//span[@class='ellipsisAgGrid']")
    WebElement CreatedByColData;
    @FindBy(id = "input-dynamic-column-1")
    WebElement CostCentre;
    @FindBy(id="input-dynamic-column-2")
    WebElement CaseAlias;
    @FindBy(id="select-dynamic-column-3")
    WebElement AddDropDown;
    @FindBy(xpath = "//span[contains(text(),'Region is required')]")
    WebElement RegionReqValidation;
    @FindBy(id = "input-dynamic-column-4")
    WebElement inplace_checkbox;

    @FindBy(id="filedownload-btn")
    WebElement HelpLink;

    @FindBy(xpath = "//*[@id='input-dynamic-column-4']/label/span[1]/input")
    WebElement inplace_checkbox1;

    @FindBy(xpath = "//span[contains(text(),'Last Date Modified')]/ancestor::div[@ref='eLabel']")
    WebElement LastDateModifiedHeader;

    @FindBy(xpath = "//div[@col-id='ModifiedOn']//span[@ref='eMenu']")
    WebElement DateModifierMenu;

    @FindBy(xpath = "//div[@aria-label='Filtering operator']//div[@ref='eIcon']")
    WebElement ComparatorDropDown;

    @FindBy(xpath = "//div[@class='ag-filter-apply-panel']//button[contains(text(),'Apply')]")
    WebElement ApplyButton;

    @FindBy(xpath = "//label[@class='matchresults']//b")
    WebElement CasesCount;

    @FindBy(xpath = "//div[contains(text(),'Total Projects')]/ancestor::td//td[@class='tile-value']//div")
    WebElement CasesCountInDashBoard;

    @FindBy(xpath = "//div[@ref='eDateInput']//input[@ref='eInput']")
    WebElement DateFormat;

    @FindBy(xpath = "//input[@id='input-due-date']")
    WebElement DUEDATE;

    @FindBy(xpath = "//input[@id='input-docket-num-1']")
    WebElement DocketNumber;

    @FindBy(xpath = "//input[@id='input-dynamic-column-5']")
    WebElement ProjectRetirementDate;

    @FindBy(xpath = "//app-error-message[@class='ng-star-inserted']//div//span")
    WebElement ProjectNameErrorMsg;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement EditPopUpSaveBtn;

    @FindBy(id = "case-company")
    WebElement CompanyName;

    @FindBy(xpath = "//div[@id='case-company-panel']//input[@type='text']")
    WebElement CompanyNameTxt;

    @FindBy(id = "case-client")
    WebElement ClientName;

    @FindBy(xpath = "//div[@id='case-client-panel']//input[@type='text']")
    WebElement ClientNameTxt;

    @FindBy(xpath = "//div[@col-id='Name']//span[@ref='eMenu']")
    WebElement ProjectNameMenu;

    @FindBy(xpath = "//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-0']//button[@aria-label='Open calendar']")
    WebElement StartDateCalendar;

    @FindBy(xpath = "//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-1']//button[@aria-label='Open calendar']")
    WebElement EndDateCalendar;

    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement AYearTabInCalendar;

    @FindBy(id = "apply-filter")
    WebElement ApplyButtonInDB;

    @FindBy(xpath = "//div[contains(text(),'Project name already exist')]")
    WebElement DuplicateERROR;

    @FindBy(xpath = "//button[contains(text(),'OK')]")
    WebElement OKBUTTON;

    @FindBy(xpath = "//span[contains(text(),' Project Name Already Exists')]")
    WebElement ProjectFieldValidationMessage;

    /**
     * Method to Check the Region Field in Case Creation isMandatory
     * @param data
     * @return
     * @throws Exception
     */
    public ILiglPage checkRegionIsMandatory(Hashtable<String,String> data) throws Exception{
        try{
            log_Info("checkRegionIsMan() Started");
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
            EntityText.sendKeys(data.get("CaseEntity"));
            Thread.sleep(3000);
            EntityText.sendKeys(Keys.ENTER);
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
            boolean b=RegionReqValidation.isDisplayed();
            Assert.assertEquals(b,true);
            log_Pass("Region Field is Mandatory");
            return new CaseSummaryPage();
        }catch (Exception ex){
            throw new Exception("Exception in checkRegionIsMan()", ex);
        }
    }

    /**
     * Method to Create Case by filling Additional Fields
     * @param data
     * @return
     * @throws Exception
     */
    public ILiglPage caseCreateWithAdditionalFields(Hashtable<String,String> data) throws Exception{
        try{
            log_Info("caseAdditionalFields() Started");
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
            EntityText.sendKeys(data.get("CaseEntity"));
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
            MoreBtn.click();
            Thread.sleep(3000);
            CostCentre.sendKeys(data.get("Cost centre"));
            Thread.sleep(3000);
            CaseAlias.sendKeys(data.get("Case Alias"));
            Thread.sleep(3000);
            AddDropDown.click();
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+data.get("AddDP")+"')]")).click();
            Thread.sleep(3000);
            log_Info("Click Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("CaseName"),b);
            log_Pass("Case Created Successfully");
            return new CaseSummaryPage();
        }catch (Exception ex){
            log_Error("caseAdditionalFields() Failed");
            throw new Exception("Exception in caseAdditionalFields()",ex);
        }
    }

    //Create NewCase
    public ILiglPage createNewCase(Hashtable<String,String> data) throws Exception {
        try {


            log_Info("createNewCase() Started");
            log_Info("Click Create Case Button");
            createCaseBtn.click();
            log_Info(data.toString());
            log_Info("Enter CaseType");
            getDriver().waitForelementToBeClickable(CaseType);
            CaseType.click();
            Thread.sleep(1000);
            CaseTypeText.sendKeys(data.get("ProjectTYPE"));
            Thread.sleep(1000);
            CaseTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.click();
            Thread.sleep(1000);
            RoleTypeText.sendKeys(data.get("ROLE"));
            Thread.sleep(1000);
            RoleTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter CaseName");
            getDriver().waitForelementToBeClickable(CaseName);
            CaseName.sendKeys(data.get("PROJECT"));


            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.click();
            Thread.sleep(1000);
            WFTText.sendKeys(data.get("WFT"));
            Thread.sleep(1000);
            WFTText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            Thread.sleep(1000);
            CSTText.sendKeys(data.get("PST"));
            Thread.sleep(1000);
            CSTText.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.click();
            Thread.sleep(1000);
            EntityText.sendKeys(data.get("ENTITY"));
            Thread.sleep(1000);
            EntityText.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Region.click();
            Thread.sleep(1000);
            RegionText.sendKeys(data.get("REGION"));
            Thread.sleep(1000);
            RegionText.sendKeys(Keys.ENTER);
            log_Info("Region Entered");
            Thread.sleep(1000);

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Desc.sendKeys(data.get("DESC"));

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            Priority.click();
            Thread.sleep(1000);
            SelPriority.sendKeys(data.get("PRIORITY"));
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");
            Thread.sleep(1000);

            log_Pass("All Mandatory Fields Are Entered");
            log_Info("Click Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("PROJECT"),b);
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
        return new LiglBasePage();
    }

    // Searching a particular case throgh filter

    public ILiglPage searchcase(String CaseName) throws Exception {

        try {


            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CaseNameHeader).perform();


            log_Info("pointed mouse to the case name");
            log_Info("click on case search menu");
            ProjectNameMenu.click();
            log_Info("clicked on case search menu");
            log_Info("click on case filter");
            CaseSearchFilter.click();
            log_Info("clicked on case filter");
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
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.linkText(CaseName)).click();
            Thread.sleep(3000);
            log_Info("Particular Case Name Is Selected");
            return new CaseSummaryPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("GoToCase() Failed ",ex);
        }
    }


    public ILiglPage verifyCreatedByColDataInCaseGrid(String CreatedByName) throws Exception {

        try {
            log_Info("verifyCreatedByColDataInCaseGrid() started");
            ChooseColumnsMenuCase.click();
            log_Info("Searching for Created By column");
            ChooseColumnsSearch.sendKeys("Created By Name");
            Thread.sleep(2000);
            CreatedByCol.click();
            log_Info("Created By column is selected");
            ChooseColumnsSearch.clear();
            log_Info("Cleared search input");
            ChooseColumnsMenuCase.click();

            CaseNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            String s = CreatedByColData.getText();
            Assert.assertEquals(s,CreatedByName);
            log_Info("Created By Column data is displaying as expected");
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyCreatedByColDataInCaseGrid() Failed",ex);
        }

    }

    public ILiglPage clickAndChooseColumnsInCaseGrid() throws Exception {

        try {
            log_Info("Clicking on Choose columns");
            ChooseColumnsMenuCase.click();
            log_Info("Searching for Approval type column");
            ChooseColumnsSearch.sendKeys("Approval Type");
            Thread.sleep(2000);
            ApprovalTypeCol.click();
            log_Info("Approval type column is selected");
            ChooseColumnsSearch.clear();
            log_Info("Cleared search input");
            log_Info("Searching for Approved Or Rejected By column");
            ChooseColumnsSearch.sendKeys("Approved Or Rejected By");
            Thread.sleep(2000);
            ApprovedOrRejectedByCol.click();
            log_Info("Approved Or Rejected By column is selected");
            ChooseColumnsSearch.clear();
            log_Info("Again cleared search input");
            ChooseColumnsMenuCase.click();
            log_Info("Closing Choose columns");
            ChooseColumnsMenuCase.click();
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickAndChooseColumnsInCaseGrid() Failed",ex);
        }

    }

    public ILiglPage verifyChooseColumnsDataInCaseGrid(String ApprovedOrRejectedExpected, String ApprovalTypeExpected) throws Exception {

        try {
            log_Info("verifyChooseColumnsDataInCaseGrid() started");
            String a = ApprovedOrRejectedByColData.getText();
            Assert.assertEquals(a,ApprovedOrRejectedExpected);
            log_Info("Approved or Rejected By Column data is displaying as expected");

            String b = ApprovalTypeColData.getText();
            Assert.assertEquals(b,ApprovalTypeExpected);
            log_Info("Approval Type Column data is displaying as expected");
            log_Pass("verifyChooseColumnsDataInCaseGrid() completed");
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyChooseColumnsDataInCaseGrid() Failed",ex);
        }

    }

    public ILiglPage verifyAdditionalFieldsInCasePopup(String AddField1,String AddField2,String AddField3,String AddField5) throws Exception {

        try {
            log_Info("verifyAdditionalFieldsInCasePopup() started");
            createCaseBtn.click();
            log_Info("Clicked button in create case popup");
            Thread.sleep(2000);
            MoreBtn.click();
            Thread.sleep(2000);
            log_Info("Check The Column names In The Create Case popup");
            boolean c1 = AdditionalField1.isDisplayed();
            boolean c2 = AdditionalField2.isDisplayed();
            boolean c3 = AdditionalField3.isDisplayed();
            boolean c4 = AdditionalField4.isDisplayed();
            boolean c5 = AdditionalField5.isDisplayed();

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            log_Info("Additional Columns are displaying in The Create Case popup");
            CancelBtn.click();
            log_Info("Clicked Cancel button in create case popup");
            CancelYesBtn.click();
            log_Info("Clicked Yes button after clicking Cancel button in create case popup");
            Thread.sleep(5000);
            log_Info("Case list grid is loaded");

            ChooseColumnsMenuCase.click();
            ChooseColumnsSearch.sendKeys(AddField1);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + AddField1 + "')]/ancestor::div[@role='treeitem']//input")).click();
            log_Info("AddField1 is checked");
            ChooseColumnsSearch.clear();
            Thread.sleep(3000);

            ChooseColumnsSearch.sendKeys(AddField2);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + AddField2 + "')]/ancestor::div[@role='treeitem']//input")).click();
            log_Info("AddField2 is checked");
            ChooseColumnsSearch.clear();
            Thread.sleep(3000);

            ChooseColumnsSearch.sendKeys(AddField3);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+ AddField3 + "')]/ancestor::div[@role='treeitem']//input")).click();
            log_Info("AddField3 is checked");
            ChooseColumnsSearch.clear();
            Thread.sleep(5000);

            ChooseColumnsSearch.sendKeys(AddField5);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+AddField5 + "')]/ancestor::div[@role='treeitem']//input")).click();
            log_Info("AddField5 is checked");
            ChooseColumnsSearch.clear();
            Thread.sleep(3000);

            ChooseColumnsMenuCase.click();
            log_Info("Closed Choose columns menu");

            boolean a4 = AdditionalField4InGrid.isDisplayed();
            System.out.println(a4);
            Assert.assertEquals(true, a4);
            log_Info("Additional Field4 is displaying in case grid");

            boolean a5 = AdditionalField5InGrid.isDisplayed();
            System.out.println(a5);
            Assert.assertEquals(true, a5);
            log_Info("Additional Field5 is displaying in case grid");

            CaseNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 11; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            boolean a3 = AdditionalField3InGrid.isDisplayed();
            System.out.println(a3);
            Assert.assertEquals(true, a3);
            log_Info("Additional Field3 is displaying in case grid");

            boolean a1 = AdditionalField1InGrid.isDisplayed();
            System.out.println(a1);
            Assert.assertEquals(true, a1);
            log_Info("Additional Field1 is displaying in case grid");

            boolean a2 = AdditionalField2InGrid.isDisplayed();
            System.out.println(a2);
            Assert.assertEquals(true, a2);
            log_Info("Additional Field2 is displaying in case grid");
            log_Pass("verifyAdditionalFieldsInCasePopup() completed successfully");
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyAdditionalFieldsInCasePopup() Failed",ex);
        }

    }

    /*****************************************Admin related test**************************************************/

    /**
     * TC54583 Check whether case type user defined look up value is populated in the case type dropdown in create case popup
     */

    public ILiglPage checkNewlyCreatedLookupPopulatedInCaseTypeDropDown(String caseType) throws Exception{
        try {
            //Case Button
            getSession().log_Info("Click On '+Case' Button");
            getDriver().waitForelementToBeClickable(createCaseBtn);
            createCaseBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On '+Case' Button");

            //Case Type
            getSession().log_Info("Click On 'Case Type' Drop Down");
            getDriver().waitForelementToBeClickable(CaseType);
            CaseType.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Case Type' Drop Down");

            getSession().log_Info("Enter Case type");
            CaseTypeText.sendKeys(caseType);
            wait(2);
            getSession().log_Pass("Entered Case type");

            getSession().log_Info("Check Lookup Populated In 'CaseType' DropDown");
            String reqTypeText = getDriver().customXpathBasedOnTextValue(caseType).getText();
            Assert.assertEquals(reqTypeText, caseType);
            getDriver().customXpathBasedOnTextValue(caseType).click();
            getSession().log_Pass("Lookup Populated In 'CaseType' DropDown");

            //Cancle Button
            getSession().log_Info("Click On 'Cancle' Button");
            getDriver().waitForelementToBeClickable(CancelBtn);
            CancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Cancle' Button");
            getSession().log_Info("Click On 'yes' Button");
            getDriver().waitForelementToBeClickable(CancelYesBtn);
            CancelYesBtn.click();
            getSession().log_Pass("Clicked On 'Yes' Button");
            getDriver().waitForAngularRequestsToComplete();

            getDriver().waitUntilSpinnerIsClosed();

            return new DefaultLandingPage();
        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("Check Lookup Populated In Case Type DropDown Failed", ex);
        }
    }

    @Override
    public ILiglPage checkNewlyCreatedCaseSettingTemplatePopulatedInCaseSettingsTemplateDropDown(String caseSettingsTemplate) throws Exception {
        try {
            //Click On Case Create Button
            getSession().log_Info("Click On '+Case' Button");
            getDriver().waitForelementToBeClickable(createCaseBtn);
            createCaseBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked '+Case' Button");


            //Select case setting Template
            log_Info("Select the case Workflow Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            CSTText.sendKeys(caseSettingsTemplate);
            getSession().log_Pass("Case Workflow Template Selected");

            getSession().log_Info("Check that Newly Created Case Setting Template is Displaying in Select case setting Template Drop Down");
            Assert.assertEquals(getDriver().customXpathBasedOnTextValue(caseSettingsTemplate).getText(), caseSettingsTemplate);
            getSession().log_Pass("Newly Created Case Setting Template is Displayed in Select case setting Template Drop Down");
            CST.sendKeys(Keys.ESCAPE);

            getSession().log_Info("Click On 'Cancle' Button");
            getDriver().waitForelementToBeClickable(CancelBtn);
            CancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Cancle' Button");
            getSession().log_Info("Click On 'yes' Button");
            getDriver().waitForelementToBeClickable(CancelYesBtn);
            CancelYesBtn.click();
            getSession().log_Pass("Clicked On 'Yes' Button");
            getDriver().waitForAngularRequestsToComplete();

            wait(2);
            return new DefaultLandingPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception(" check Newly Created CaseSetting Template Test failed", ex);
        }
    }
//Verify availability of Help hyperlink in case list page for NLU
    public ILiglPage verifyAvailabilityOfHelpLinkInCaseListPage() throws Exception{

        try {
            Thread.sleep(5000);
            try
            {
                log_Info("Started checking availability of Help hyperlink in case list page");
                boolean a=HelpLink.isDisplayed();
                System.out.println(a);
                if(a==true) {
                    log_Info("Help link is displaying");
                }}
            catch (Exception ex)
            {
                log_Error("Help link is not displaying");
            }
            Thread.sleep(5000);
            return new DefaultLandingPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("verifyAvailabilityOfHelpLinkInCaseListPage() Failed",ex);
        }
    }

    /****************************************************************************************************************/
    public ILiglPage goToNotesPage() throws InterruptedException {
        try {
            log_Pass("Click on Notes Icon in Case list page");
            getDriver().waitUntilSpinnerIsClosed();
            Thread.sleep(3000);
            getDriver().waitForelementToBeClickable(Notes_btn);
            log_Info("Notes icon Clicked");
            Thread.sleep(3000);
            Notes_btn.click();
            Thread.sleep(5000);
            log_Info("Load Notes page");
            return new NotesPage();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public ILiglPage createCaseWithoutInplacePreservation(Hashtable<String,String> data) throws Exception {
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
            Thread.sleep(1000);
            SelPriority.sendKeys(data.get("PRIORITY"));
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");
            Thread.sleep(1000);




            log_Pass("All Mandatory Fields Are Entered");
            log_Info("Click on more button");
            MoreBtn.click();
            Thread.sleep(3000);
            log_Pass("more button clicked");
            log_Info("uncheck inplace preservation checkbox");
            inplace_checkbox.click();
            Thread.sleep(3000);
            log_Pass("uncheck inplace preservation checkbox");

            log_Info("Click on Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b = NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("CaseName"), b);
            log_Pass("Case Created Successfully");
            return new CaseSummaryPage();
        } catch (Exception ex) {
            throw new Exception("Exception in CreateCaseWithoutInplacePreservation()", ex);
        }

    }
    public ILiglPage searchLastDateModifiedColumnAndValidateTheCountInDashBoard(String Comparator,String Date,String Month,String Year,String Title,String SYEAR,String SMONTH,String SDATE) throws Exception {

        try {

            getDriver().waitUntilSpinnerIsClosed();
            getDriver().waitForAngularRequestsToComplete();

            getDriver().waitForelementToBeClickable(LastDateModifiedHeader);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(LastDateModifiedHeader).perform();
            log_Info("pointed mouse To The Date Modifier Menu");


            log_Info("click on Date Modifier Menu");
            DateModifierMenu.click();
            log_Info("clicked on Date Modifier Menu");


            log_Info("click on Date Modifier filter");
            CaseSearchFilter.click();
            log_Info("clicked on Date Modifier filter");


            log_Info("click On Date Modifier Dropdown");
            ComparatorDropDown.click();
            Thread.sleep(3000);
            log_Info("clicked On Date Modifier Dropdown");
            Thread.sleep(3000);
            log_Info("click On Date Modifier Dropdown Value");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//div[@role='option']//span[contains(text(),'"+Comparator+"')]")).click();
            Thread.sleep(2000);
            log_Info("clicked On Date Modifier Dropdown Value ");
            log_Info("Enter The Date In The Bar");
            DateFormat.click();
            Thread.sleep(2000);
            DateFormat.sendKeys(Date);
            Thread.sleep(2000);
            DateFormat.sendKeys(Month);
            Thread.sleep(2000);
            DateFormat.sendKeys(Year);
            Thread.sleep(2000);
            log_Info("Entered The Date In The Bar");
            log_Info("Click On Apply Button");
            ApplyButton.click();
            Thread.sleep(2000);
            log_Info("Clicked On Apply Button");
            Thread.sleep(5000);



            String CasesCOUNT = CasesCount.getText();
            int CasescountDL = Integer.parseInt(CasesCOUNT);

            log_Info("Total Number Of Cases  : " + CasescountDL);

            getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(Title);

            getSession().log_Info("Enter The Start Date");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(StartDateCalendar);
            Thread.sleep(5000);
            StartDateCalendar.click();
            Thread.sleep(2000);
            AYearTabInCalendar.click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SYEAR+"']")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+SMONTH+"')]")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SDATE+"']//div")).click();
            Thread.sleep(2000);
            getSession().log_Pass("Entered The Start Date");


            getSession().log_Info("Click On The Apply Button");
            getDriver().waitForelementToBeClickable(ApplyButtonInDB);
            Thread.sleep(2000);
            ApplyButtonInDB.click();
            getDriver().maxWait();
            getSession().log_Pass("Clicked On The Apply Button");

            String CasesCountDB = CasesCountInDashBoard.getText();
            int CASESCountDB = Integer.parseInt(CasesCountDB);

            log_Info("Total Number Of Cases  : " + CASESCountDB);

            try {

                if (CasescountDL == CASESCountDB) {

                    log_Pass("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are EQUAL ");
                }
                else
                {
                    throw new Exception("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are NOT EQUAL");
                }
            }
            catch(Exception e) {
                log_Error("Total Count In Both Pages Are Not Equal");
                throw new Exception("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are NOT EQUAL");
            }

            return  new DashboardPage();


        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchLastDateModifiedColumn() Failed",ex);
        }

    }


    public ILiglPage createNewCaseWithInPlacePreservation(Hashtable<String,String> data) throws Exception {
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
            Thread.sleep(1000);
            SelPriority.sendKeys(data.get("PRIORITY"));
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");
            Thread.sleep(1000);

            MoreBtn.click();
            log_Info("check for inplace preservation check box selected or not");
            boolean a1 = inplace_checkbox1.isSelected();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("inplace preservation check box selected for the Case");

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

    /*****************************************DB related test**************************************************/

    public ILiglPage createNewProjectWithAllFields(Hashtable<String,String> data) throws Exception{
        try{
            Thread.sleep(25555);
            getDriver().waitUntilSpinnerIsClosed();
            log_Info("Click Project Case Button");
            getDriver().waitForelementToBeClickable(createCaseBtn);
            createCaseBtn.click();
            log_Info(data.toString());

            log_Info("Enter Project Type");
            wait(2);
            getDriver().waitForelementToBeClickable(CaseType);
            CaseType.sendKeys(Keys.ENTER, data.get("ProjectType"), Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.sendKeys(Keys.ENTER, data.get("Role"), Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            log_Info("Enter Project Name");
            getDriver().waitForelementToBeClickable(CaseName);
            //CaseName.sendKeys(data.get("ProjectName"));
            CaseName.sendKeys("QA_Automation_DBProject_QA05");

            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.sendKeys(Keys.ENTER, data.get("WFT"), Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.sendKeys(Keys.ENTER,data.get("ProjectSetTemp"), Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.sendKeys(Keys.ENTER,data.get("Entity"),Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Region.sendKeys(Keys.ENTER, data.get("Region"), Keys.ENTER);

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Desc.sendKeys(data.get("Description"));

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            String priorityNew = getDriver().removeSpecialCharacter(data.get("Priority"));
            Priority.sendKeys(Keys.ENTER, priorityNew, Keys.ENTER);
            log_Pass("Priority Selected");
            Thread.sleep(3000);

            //Due Date
            String dueDateNew = getDriver().removeSpecialCharacter(data.get("DueDate"));
            getCurrentDriver().findElement(By.id("input-due-date")).sendKeys(dueDateNew);

            log_Pass("All Mandatory Fields Are Entered");
            log_Info("Click Save Button");
            SaveBtn.click();

            wait(5);
            return new CaseSummaryPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("Create New Case With All Fields Failed", ex);
        }
    }

    /*****************************************End To End Testing**************************************************/


    public ILiglPage createProjectWithBothMandatoryAndOptionalFields(Hashtable<String,String> data) throws Exception {
        try {


            log_Info("createProjectWithBothMandatoryAndOptionalFields() Started");
            log_Info("Click On Add Project Button");
            createCaseBtn.click();
            log_Pass("Clicked On Add Project Button");
            log_Info(data.toString());

            log_Info("Enter CaseType");
            getDriver().waitForelementToBeClickable(CaseType);
            Thread.sleep(1000);
            CaseType.click();
            Thread.sleep(1000);
            CaseTypeText.sendKeys(data.get("ProjectTYPE"));
            Thread.sleep(1000);
            CaseTypeText.sendKeys(Keys.ENTER);
            log_Pass("Entered Case Type");

            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.click();
            Thread.sleep(1000);
            RoleTypeText.sendKeys(data.get("ROLE"));
            Thread.sleep(1000);
            RoleTypeText.sendKeys(Keys.ENTER);
            log_Pass("Entered Role Type");

            log_Info("Enter CaseName");
            getDriver().waitForelementToBeClickable(CaseName);
            Thread.sleep(1000);
            CaseName.sendKeys(data.get("PROJECT"));
            log_Pass("Entered CaseName");

            log_Info("Enter Project Due Date");
            getDriver().waitForelementToBeClickable(DUEDATE);
            Thread.sleep(1000);
            DUEDATE.sendKeys(data.get("DUEDATE"));
            log_Pass("Entered Project Due Date");

            log_Info("Enter Docket Number");
            getDriver().waitForelementToBeClickable(DocketNumber);
            Thread.sleep(1000);
            DocketNumber.sendKeys(data.get("DocketNumber"));
            log_Pass("Entered Docket Number");

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Thread.sleep(1000);
            Desc.sendKeys(data.get("DESC"));
            log_Pass("Entered Description");


            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.click();
            Thread.sleep(1000);
            WFTText.sendKeys(data.get("WFT"));
            Thread.sleep(1000);
            WFTText.sendKeys(Keys.ENTER);
            log_Pass("Entered Work Flow Template");

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            Thread.sleep(1000);
            CSTText.sendKeys(data.get("PST"));
            Thread.sleep(1000);
            CSTText.sendKeys(Keys.ENTER);
            log_Pass("Entered Case Settings Template");

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.click();
            Thread.sleep(1000);
            EntityText.sendKeys(data.get("ENTITY"));
            Thread.sleep(1000);
            EntityText.sendKeys(Keys.ENTER);
            log_Pass("Entered Entity");

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Thread.sleep(3000);
            Region.click();
            RegionText.sendKeys(data.get("REGION"));
            Thread.sleep(1000);
            RegionText.sendKeys(Keys.ENTER);
            log_Pass("Entered Region");

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            Priority.click();
            Thread.sleep(1000);
            SelPriority.sendKeys(data.get("PRIORITY"));
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");



            log_Info("Click On More Button");
            MoreBtn.click();
            Thread.sleep(1000);
            log_Pass("Clicked On More Button");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", SaveBtn);

            log_Info("Click On Cost Centre");
            CostCentre.click();
            Thread.sleep(1000);
            CostCentre.sendKeys(data.get("CostCenter"));
            Thread.sleep(1000);
            log_Pass("Clicked On Cost Centre");

            log_Info("Click On Case Alias");
            CaseAlias.sendKeys(data.get("ProjectAlias"));
            Thread.sleep(1000);
            log_Pass("Clicked On Case Alias");

            log_Info("Click On Add Drop Down");
            AddDropDown.click();
            Thread.sleep(1000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+data.get("AddDP")+"')]")).click();
            Thread.sleep(1000);
            log_Pass("Clicked On Add Drop Down");

            log_Info("Click On Project Retirement Date");
            ProjectRetirementDate.sendKeys(data.get("RetirementDate"));
            Thread.sleep(1000);
            log_Pass("Clicked On Project Retirement Date");


            log_Info("check for inplace preservation check box selected or not");
            boolean a1 = inplace_checkbox1.isSelected();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("inplace preservation check box selected for the Case");

            log_Pass("All Mandatory/Optional Fields Are Entered");
            log_Info("Click Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("PROJECT"),b);
            log_Pass("Case Created Successfully");
            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in createProjectWithBothMandatoryAndOptionalFields()", ex);
        }
    }

    public ILiglPage enterProjectType(String ProjectType) throws Exception {

        try {

            log_Info("Enter Projet Type");
            getDriver().waitForelementToBeClickable(CaseType);
            Thread.sleep(1000);
            CaseType.click();
            Thread.sleep(1000);
            CaseTypeText.sendKeys(ProjectType);
            Thread.sleep(1000);
            CaseTypeText.sendKeys(Keys.ENTER);
            log_Pass("Entered Case Type");


            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterProjectType()", ex);
        }
    }

    public ILiglPage enterRole(String ROLE) throws Exception {

        try {

            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.click();
            Thread.sleep(1000);
            RoleTypeText.sendKeys(ROLE);
            Thread.sleep(1000);
            RoleTypeText.sendKeys(Keys.ENTER);
            log_Pass("Entered Role Type");


            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterRole)", ex);
        }
    }
    public ILiglPage enterProjectName(String PROJECT) throws Exception {

        try {

            log_Info("Enter CaseName");
            getDriver().waitForelementToBeClickable(CaseName);
            Thread.sleep(1000);
            CaseName.sendKeys(PROJECT);
            log_Pass("Entered CaseName");

            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterRole()", ex);
        }
    }

    public ILiglPage enterDescription(String DESC) throws Exception {

        try {

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Thread.sleep(1000);
            Desc.sendKeys(DESC);
            log_Pass("Entered Description");

            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterDescription()", ex);
        }
    }

    public ILiglPage enterProjectSettingTemplate(String PST) throws Exception {

        try {

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            Thread.sleep(1000);
            CSTText.sendKeys(PST);
            Thread.sleep(1000);
            CSTText.sendKeys(Keys.ENTER);
            log_Pass("Entered Case Settings Template");

            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterProjectSettingTemplate()", ex);
        }
    }

    public ILiglPage enterEntity(String ENTITY) throws Exception {

        try {

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.click();
            Thread.sleep(1000);
            EntityText.sendKeys(ENTITY);
            Thread.sleep(1000);
            EntityText.sendKeys(Keys.ENTER);
            log_Pass("Entered Entity");

            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterEntity()", ex);
        }
    }

    public ILiglPage enterRegion(String REGION) throws Exception {

        try {

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Thread.sleep(2000);
            Region.click();
            Thread.sleep(1000);
            RegionText.sendKeys(REGION);
            Thread.sleep(3000);
            RegionText.sendKeys(Keys.ENTER);
            log_Pass("Entered Region");


            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterRegion()", ex);
        }
    }

    public ILiglPage enterPriority(String PRIORITY) throws Exception {

        try {

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            Priority.click();
            Thread.sleep(1000);
            SelPriority.sendKeys(PRIORITY);
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");


            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in enterPriority()", ex);
        }
    }

    public ILiglPage clickOnSaveAndAddDetailsButtonInAddProjectPopUp(String CaseNAME) throws Exception {

        try {

            log_Info("Click On Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(1000);
            SaveBtn.click();
            Thread.sleep(2000);

            try{
                if (SaveBtn.isDisplayed())
                    SaveBtn.click();
                log_Pass("Clicked On Save Button");
            }
            catch (Exception ex){
                log_Pass("Save Button Is Clicked");

            }

            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(CaseNAME,b);
            log_Pass("Case Created Successfully");
            return new CaseSummaryPage();

        }
        catch (Exception ex){
            throw new Exception("Exception in clickOnSaveAndAddDetailsButtonInAddProjectPopUp()", ex);
        }
    }

    public ILiglPage clickOnAddProjectButton() throws Exception {

        try {

            log_Info("Click On Add Project Button");
            createCaseBtn.click();
            Thread.sleep(1000);
            log_Pass("Clicked On Add Project Button");

            return new DefaultLandingPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in clickOnAddProjectButton()", ex);
        }
    }

    public ILiglPage createProjectWhenProjectSettingTemplateFieldIsDisabled(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("createProjectWhenProjectSettingTemplateFieldIsDisabled() Started");
            log_Info(data.toString());
            clickOnAddProjectButton()
                    .enterProjectType(data.get("ProjectTYPE"))
                    .enterRole(data.get("ROLE")).enterProjectName(data.get("PROJECT"))
                    .enterEntity(data.get("ENTITY")).enterRegion(data.get("REGION")).enterPriority(data.get("PRIORITY")).enterDescription(data.get("DESC"))
                    .clickOnSaveAndAddDetailsButtonInAddProjectPopUp(data.get("PROJECT"));

            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in createProjectWhenProjectSettingTemplateFieldIsDisabled()", ex);
        }
    }


    public ILiglPage createProjectWhenRegionFieldIsDisabled(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("createProjectWhenCaseSettingTemplateFieldIsDisabled() Started");
            log_Info(data.toString());
            clickOnAddProjectButton()
                    .enterProjectType(data.get("ProjectTYPE"))
                    .enterRole(data.get("ROLE")).enterProjectName(data.get("PROJECT"))
                    .enterProjectSettingTemplate(data.get("PST")).enterEntity(data.get("ENTITY")).enterRegion(data.get("REGION")).enterPriority(data.get("PRIORITY")).enterDescription(data.get("DESC"))
                    .clickOnSaveAndAddDetailsButtonInAddProjectPopUp(data.get("PROJECT"));

            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in createProjectWhenRegionFieldIsDisabled()", ex);
        }
    }

    public ILiglPage verifyProjectNameFieldValidationSpecialCharactersAllowedAndNotAllowed(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("verifyProjectNameFieldValidationSpecialCharactersAllowedAndNotAllowed() Started");
            log_Info(data.toString());
            clickOnAddProjectButton()
                    .enterProjectType(data.get("ProjectTYPE"))
                    .enterRole(data.get("ROLE")).enterProjectName(data.get("PROJECT"))
                    .enterProjectSettingTemplate(data.get("PST"))
                    .enterEntity(data.get("ENTITY"))
                    .enterRegion(data.get("REGION"))
                    .enterPriority(data.get("PRIORITY"))
                    .enterDescription(data.get("DESC"))
                    .clickOnSaveAndAddDetailsButton()
                    .validateProjectNameFieldErrorMessage()
                    .performClearActionInTheProjectNameField()
                    .enterProjectName(data.get("PROJECT1"))
                    .clickOnSaveAndAddDetailsButtonInAddProjectPopUp(data.get("PROJECT1"));

            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in verifyProjectNameFieldValidationSpecialCharactersAllowedAndNotAllowed()", ex);
        }
    }

    public ILiglPage clickOnSaveAndAddDetailsButton() throws Exception {

        try {

            log_Info("clickOnSaveAndAddDetailsButton() Started");
            log_Info("Click On Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(1000);
            SaveBtn.click();
            log_Pass("Clicked On Save Button");

            return new DefaultLandingPage();

        }
        catch (Exception ex){
            throw new Exception("Exception in clickOnSaveAndAddDetailsButton()", ex);
        }
    }

    public ILiglPage performClearActionInTheProjectNameField() throws Exception {

        try {

            log_Info("performClearActionInTheProjectNameField() Started");
            log_Info("Click On Project Name And Perform Clear Functionality In The Field");
            getDriver().waitForelementToBeClickable(CaseName);
            Thread.sleep(1000);
            CaseName.clear();
            log_Pass("Clicked On Project Name And Performed Clear Functionality In The Field");

            return new DefaultLandingPage();

        }
        catch (Exception ex){
            throw new Exception("Exception in performClearActionInTheProjectNameField()", ex);
        }
    }

    public ILiglPage validateProjectNameFieldErrorMessage() throws Exception {

        try {

            log_Info("validateProjectNameFieldErrorMessage() Started");
            String s1 = ProjectNameErrorMsg.getText();
            String s2 = (Constants.ProjectSpecialChar_ErrorMessage);

            if(s1.equals(s2)){
                log_Pass("Error Message Displayed And Validated The Special Characters");
            }
            else {
                throw new Exception("Error Message not Displayed As It Allows Specified Special characters");
            }

            return new DefaultLandingPage();

        }
        catch (Exception ex){
            throw new Exception("Exception in validateProjectNameFieldErrorMessage()", ex);
        }
    }

    public ILiglPage verifyUserCanChooseAnyDateInDueDateWhileProjectCreateOrEdit(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("verifyUserCanChooseAnyDateInDueDateWhileProjectCreateOrEdit() Started");
            log_Info(data.toString());
            clickOnAddProjectButton()
                    .enterProjectType(data.get("ProjectTYPE"))
                    .enterRole(data.get("ROLE")).enterProjectName(data.get("PROJECT"))
                    .enterProjectSettingTemplate(data.get("PST"))
                    .enterEntity(data.get("ENTITY"))
                    .enterRegion(data.get("REGION"))
                    .enterProjectDueDate(data.get("DUEdatePast"))
                    .enterPriority(data.get("PRIORITY"))
                    .enterDescription(data.get("DESC"))
                    .clickOnSaveAndAddDetailsButtonInAddProjectPopUp(data.get("PROJECT"))
                    .clickOnProjectEditButton()
                    .performClearActionInProjectDueDate()
                    .enterProjectDueDateWhileEditing(data.get("DUEdateCurrent"))
                    .clickOnSaveButtonFromEditPopUpInCaseSummaryPage();

            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in verifyUserCanChooseAnyDateInDueDateWhileProjectCreateOrEdit()", ex);
        }
    }

    public ILiglPage  enterProjectDueDate(String DueDate) throws Exception {

        try {

            log_Info("Enter Project Due Date");
            getDriver().waitForelementToBeClickable(DUEDATE);
            Thread.sleep(1000);
            DUEDATE.sendKeys(DueDate);
            Thread.sleep(1000);
            DUEDATE.sendKeys(Keys.ENTER);
            log_Pass("Entered Project Due Date");

            return new DefaultLandingPage();

        }
        catch (Exception ex){
            throw new Exception("Exception in enterProjectDueDate()", ex);
        }
    }

    public ILiglPage clickOnChooseColumnsInProjectGrid() throws Exception {

        try {

            log_Info("clickOnChooseColumnsInProjectGrid() Started");
            log_Info("Click On Choose Column Menu");
            getDriver().waitForelementToBeClickable(ChooseColumnsMenuCase);
            Thread.sleep(2000);
            ChooseColumnsMenuCase.click();
            Thread.sleep(2000);
            log_Pass("Clicked On Choose Columns Menu");

            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnChooseColumnsInProjectGrid() Failed",ex);
        }

    }

    public ILiglPage searchForTheRequiredColumnsThroughChooseColumn(String RequiredColumn1) throws Exception {

        try {

            log_Info("searchForTheRequiredColumnsThroughChooseColumn() Started");
            log_Info("Enter The Required Column In Search Bar");
            getDriver().waitForelementToBeClickable(ChooseColumnsSearch);
            ChooseColumnsSearch.sendKeys(RequiredColumn1);
            Thread.sleep(1000);
            log_Pass("Entered The Required Column In Search Bar");

           /* getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+RequiredColumn1+"')]")).click();*/

            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchForTheRequiredColumnsThroughChooseColumn() Failed",ex);
        }

    }

    public ILiglPage performClearActionInSearchBarInChooseColumn() throws Exception {

        try {

            log_Info("performClearActionInSearchBarInChooseColumn() Started");
            log_Info("Clear The Required Column Name In Search Bar");
            getDriver().waitForelementToBeClickable(ChooseColumnsSearch);
            ChooseColumnsSearch.clear();
            Thread.sleep(1000);
            log_Pass("Cleared The Required Column Name In Search Bar");

            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("performClearActionInSearchBarInChooseColumn() Failed",ex);
        }

    }

    public ILiglPage createNewCaseSP(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("createNewCaseSP() Started");
            log_Info("Click On Add Project Button");
            Thread.sleep(2000);
            createCaseBtn.click();
            log_Pass("Clicked On Add Project Button");

            log_Info(data.toString());

            log_Info("Enter Company Name");
            CompanyName.click();
            Thread.sleep(2000);
            CompanyNameTxt.sendKeys(data.get("COMPANY"));
            Thread.sleep(2000);
            CompanyNameTxt.sendKeys(Keys.ENTER);
            log_Pass("Entered Company Name");

            log_Info("Enter Client Name");
            ClientName.click();
            Thread.sleep(2000);
            ClientNameTxt.sendKeys(data.get("CLIENT"));
            Thread.sleep(2000);
            ClientNameTxt.sendKeys(Keys.ENTER);
            log_Pass("Entered Client Name");

            log_Info("Enter CaseType");
            getDriver().waitForelementToBeClickable(CaseType);
            CaseType.click();
            Thread.sleep(1000);
            CaseTypeText.sendKeys(data.get("ProjectTYPE"));
            Thread.sleep(1000);
            CaseTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter RoleType");
            getDriver().waitForelementToBeClickable(RoleType);
            RoleType.click();
            Thread.sleep(1000);
            RoleTypeText.sendKeys(data.get("ROLE"));
            Thread.sleep(1000);
            RoleTypeText.sendKeys(Keys.ENTER);
            log_Info("Enter CaseName");
            getDriver().waitForelementToBeClickable(CaseName);
            CaseName.sendKeys(data.get("PROJECT"));


            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.click();
            Thread.sleep(1000);
            WFTText.sendKeys(data.get("WFT"));
            Thread.sleep(1000);
            WFTText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Enter Case Settings Template");
            getDriver().waitForelementToBeClickable(CST);
            CST.click();
            Thread.sleep(1000);
            CSTText.sendKeys(data.get("PST"));
            Thread.sleep(1000);
            CSTText.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            log_Info("Enter Entity");
            getDriver().waitForelementToBeClickable(Entity);
            Entity.click();
            Thread.sleep(1000);
            EntityText.sendKeys(data.get("ENTITY"));
            Thread.sleep(1000);
            EntityText.sendKeys(Keys.ENTER);
            Thread.sleep(1000);

            log_Info("Enter Region");
            getDriver().waitForelementToBeClickable(Region);
            Region.click();
            Thread.sleep(1000);
            RegionText.sendKeys(data.get("REGION"));
            Thread.sleep(1000);
            RegionText.sendKeys(Keys.ENTER);
            log_Info("Region Entered");
            Thread.sleep(1000);

            log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(Desc);
            Desc.sendKeys(data.get("DESC"));

            log_Info("Enter Priority");
            getDriver().waitForelementToBeClickable(Priority);
            Priority.click();
            Thread.sleep(1000);
            SelPriority.sendKeys(data.get("PRIORITY"));
            Thread.sleep(1000);
            SelPriority.sendKeys(Keys.ENTER);
            log_Pass("Priority Selected");
            Thread.sleep(1000);

            log_Pass("All Mandatory Fields Are Entered");
            log_Info("Click Save Button");
            SaveBtn.click();
            log_Pass("Save button Clicked");
            String b= NewlyCreatedCaseName.getAttribute("title");
            Assert.assertEquals(data.get("PROJECT"),b);
            log_Pass("Case Created Successfully");

            return new CaseSummaryPage();
        }
        catch (Exception ex){
            throw new Exception("Exception in createNewCaseSP()", ex);
        }
    }

    public ILiglPage searchLastDateModifiedColumnAndValidateTheCountInDashBoardWhenUACIsFALSE(String Comparator,String Date,String Month,String Year,String Title,String SYEAR,String SMONTH,String SDATE) throws Exception {

        try {

            getDriver().waitUntilSpinnerIsClosed();
            getDriver().waitForAngularRequestsToComplete();

            getDriver().waitForelementToBeClickable(LastDateModifiedHeader);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(LastDateModifiedHeader).perform();
            log_Info("pointed mouse To The Date Modifier Menu");


            log_Info("click on Date Modifier Menu");
            DateModifierMenu.click();
            log_Info("clicked on Date Modifier Menu");


            log_Info("click on Date Modifier filter");
            CaseSearchFilter.click();
            log_Info("clicked on Date Modifier filter");


            log_Info("click On Date Modifier Dropdown");
            ComparatorDropDown.click();
            Thread.sleep(3000);
            log_Info("clicked On Date Modifier Dropdown");
            Thread.sleep(3000);
            log_Info("click On Date Modifier Dropdown Value");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//div[@role='option']//span[contains(text(),'"+Comparator+"')]")).click();
            Thread.sleep(2000);
            log_Info("clicked On Date Modifier Dropdown Value ");
            log_Info("Enter The Date In The Bar");
            DateFormat.click();
            Thread.sleep(2000);
            DateFormat.sendKeys(Date);
            Thread.sleep(2000);
            DateFormat.sendKeys(Month);
            Thread.sleep(2000);
            DateFormat.sendKeys(Year);
            Thread.sleep(2000);
            log_Info("Entered The Date In The Bar");
            log_Info("Click On Apply Button");
            ApplyButton.click();
            Thread.sleep(2000);
            log_Info("Clicked On Apply Button");
            Thread.sleep(5000);



            String CasesCOUNT = CasesCount.getText();
            int CasescountDL = Integer.parseInt(CasesCOUNT);

            log_Info("Total Number Of Cases  : " + CasescountDL);

            getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(Title);

            getSession().log_Info("Enter The Start Date");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(StartDateCalendar);
            Thread.sleep(5000);
            StartDateCalendar.click();
            Thread.sleep(2000);
            AYearTabInCalendar.click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SYEAR+"']")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+SMONTH+"')]")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SDATE+"']//div")).click();
            Thread.sleep(2000);
            getSession().log_Pass("Entered The Start Date");


            getSession().log_Info("Click On The Apply Button");
            getDriver().waitForelementToBeClickable(ApplyButtonInDB);
            Thread.sleep(2000);
            ApplyButtonInDB.click();
            getDriver().maxWait();
            getSession().log_Pass("Clicked On The Apply Button");

            String CasesCountDB = CasesCountInDashBoard.getText();
            int CASESCountDB = Integer.parseInt(CasesCountDB);

            log_Info("Total Number Of Cases  : " + CASESCountDB);

            try {

                if (CasescountDL != CASESCountDB) {

                    log_Pass("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are NOT EQUAL");
                }
                else
                {
                    throw new Exception("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are EQUAL ");
                }
            }
            catch(Exception e) {
                log_Error("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are EQUAL ");
                throw new Exception("Total Count Of Cases In DefaultLanding Page And Dash Board Page Are EQUAL");
            }

            return  new DashboardPage();


        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchLastDateModifiedColumnAndValidateTheCountInDashBoardWhenUACIsFALSE() Failed",ex);
        }

    }

    public ILiglPage validatingTheErrorMessageWhileCreatingTheDuplicateProjectNames(Hashtable<String,String> data) throws Exception {

        try {

            log_Info("validatingTheErrorMessageWhileCreatingTheDuplicateProjectNames() Started");
            log_Info("Check The Validation PopUp");
            boolean a1 = DuplicateERROR.isDisplayed();
            System.out.println(a1);
            Assert.assertEquals(true, a1);
            getDriver().minWait();
            log_Pass("Checked The Validation PopUp");

            log_Info("Click On OK button In The Error PopUp");
            getDriver().waitForelementToBeClickable(OKBUTTON);
            OKBUTTON.click();
            getDriver().minWait();
            log_Pass("Clicked On OK button In The Error PopUp");

            log_Info(data.toString());

            enterDescription(data.get("DESC")).enterProjectSettingTemplate(data.get("PST")).enterEntity(data.get("ENTITY")).enterRegion(data.get("REGION")).enterPriority(data.get("PRIORITY"))
                            .validateTheSaveAndAddDetailsButtonIsInDisableModeInAddProjectPopUp();


            log_Info("Check The Field Validation Under The Project Name");
            getDriver().minWait();
            boolean a2 = ProjectFieldValidationMessage.isDisplayed();
            System.out.println(a2);
            Assert.assertEquals(true, a2);
            log_Pass("Checked The Field Validation Under The Project Name");


            return new DefaultLandingPage();

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validatingTheErrorMessageWhileCreatingTheDuplicateProjectNames() Failed",ex);
        }

    }

    public ILiglPage validateTheSaveAndAddDetailsButtonIsInDisableModeInAddProjectPopUp() throws Exception {

        try {

            log_Info("validateTheSaveAndAddDetailsButtonIsInDisableModeInAddProjectPopUp() Started");

                if (SaveBtn.isEnabled()) {
                    SaveBtn.click();
                    throw new Exception("Save And Add Details Button Is In Enable Mode");
                }
                else {
                    log_Pass("Save And Add Details Button Is In Disable Mode");
                }
            return this;

        }
        catch (Exception ex){
            throw new Exception("Exception in validateTheSaveAndAddDetailsButtonIsInDisableModeInAddProjectPopUp()", ex);
        }
    }
}
