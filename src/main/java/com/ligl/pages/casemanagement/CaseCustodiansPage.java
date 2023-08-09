package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.LegalHoldPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

public class CaseCustodiansPage extends LiglBaseSessionPage {
    @FindBy(id = "btn-createcustodian")
    WebElement AddCust;
    @FindBy(xpath = "//span[@title='a custodians1']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement Employee;

    @FindBy(id = "edit-btn")
    WebElement AddToCase;

    @FindBy(xpath = "//span[contains(text(),'Employment Status')]/ancestor::div[@ref='eLabel']")
    WebElement EmployeeStatusHeader;
    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']")
    WebElement EmailName;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@ref='eLabel']")
    WebElement NameHead;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement NameMenu;

    @FindBy(xpath = "//span[contains(text(),'Alias')]/ancestor::div[@ref='eLabel']")
    WebElement AliasName;

    @FindBy(xpath = "//span[contains(text(),'ID')]/ancestor::div[@ref='eLabel']")
    WebElement IdHead;

    @FindBy(xpath = "//span[contains(text(),'Action')]/ancestor::div[@ref='eLabel']//span")
    WebElement ActionHead;

    @FindBy(xpath = "//span[contains(text(),'Date Joined')]/ancestor::div[@ref='eLabel']//span")
    WebElement DateJoinedHead;

    @FindBy(xpath = "//span[contains(text(),'Date Terminated')]/ancestor::div[@ref='eLabel']")
    WebElement DateTerminatedHead;

    @FindBy(xpath = "//span[contains(text(),'Department')]/ancestor::div[@ref='eLabel']")
    WebElement DepartmentHead;

    @FindBy(xpath = "//span[contains(text(),'Alias')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement AliasMenu;

    @FindBy(xpath = "//span[@title='Vyshnavi Yerra']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement Employeee;

    @FindBy(xpath = "//span[@title='Vyshnavi Yerra']")
    WebElement CustodianName;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable']//span//span")
    WebElement EmailMenu;

    @FindBy(xpath = "//*[@id='content']/div[2]/div[2]/ag-grid-angular/div/div[2]/div[2]/div[1]/div[2]/div/div/div[5]/div[3]/span/span")
    WebElement EmailMenuu;//Doubt

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//*[@id='record-edit']")
    WebElement EditBtn;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement EmpMail;

    @FindBy(id="CaseCustodianColumns")
    WebElement ChooseColumnsMenuCustodians;

    @FindBy(xpath = "//input[@aria-label='Filter Columns Input']")
    WebElement ChooseColumnsSearch;

    @FindBy(xpath = "//span[contains(text(),'Workforce Id')]/ancestor::div[@ref='eLabel']")
    WebElement WorkForceID;

    @FindBy(xpath = "//span[contains(text(),'Heritage Email Primary')]/ancestor::div[@ref='eLabel']")
    WebElement HeritageEmailPrimary;

    @FindBy(xpath = "//span[contains(text(),'Heritage Email Secondary')]/ancestor::div[@ref='eLabel']")
    WebElement HeritageEmailSecondary;

    @FindBy(xpath = "//span[contains(text(),'FullName')]")
    WebElement FullNameCol;
    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement CustEmailHeader;
    @FindBy(id="activate-deactivate-custodians")
    WebElement ActInActBtn;
    @FindBy(xpath = "//option[contains(text(),'Deactivate')and @class='ng-star-inserted']")
    WebElement DeActiveOption;
    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']")
    WebElement NameHeader;
    @FindBy(xpath = "//option[contains(text(),'Activate')and @class='ng-star-inserted']")
    WebElement ActiveOption;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesBtn;
    @FindBy(id = "refresh-button")
    WebElement RefreshBtn;
    @FindBy(xpath = "//button[contains(text(),'PROCEED')]")
    WebElement InactEmpProceed;

    @FindBy(xpath="//button[@aria-label='Columns']")
    WebElement ChooseColumnsEmployeeMaster;

    @FindBy(xpath="//span[contains(text(),'Action')]")
    WebElement ActionColumn;

    @FindBy(id="back-btn-employeemaster")
    WebElement BackButton;

    @FindBy(xpath="//span[contains(text(),'Import')]/ancestor::div[@aria-disabled='true']")
    WebElement DisabledImportTab;


    //12. After Navigating To Custodian Tab The Actions We Perform Adding Custodians To A Case

    public ILiglPage addCustodianToCase(String Email1) throws Exception {

        try {
            log_Info("addCustodianToCase() Started");
            log_Info("Click Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            AddCust.click();

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmpMail);

            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmpMail).perform();
            Thread.sleep(5000);

            EmpMail.click();

            Thread.sleep(5000);
            log_Info("Menu clicked");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(5000);
            log_Info("Enter Employee");
            Searchbar.sendKeys(Email1);
            Thread.sleep(5000);
            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Email1+"']/ancestor::div[@role='row']//div[@col-id='FullName']//div[@ref='eCheckbox']")).click();
            log_Info("Employee checked");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            AddToCase.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCustodiansPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addCustodianToCase() Failed", ex);
        }
    }
    public ILiglPage multipleCustodianSelect(Hashtable<String, String> data)throws Exception{
        try{
            log_Info("Started multipleCustodianSelect()");
            if(data.get("O365_Exchange_RunState").equals("Y")) {
                searchCustodian(data.get("O365_Exchange_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("O365_Exchange_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("O365_Exchange_Custodian"));
                }
            }
            if(data.get("O365_Sharepoint_RunState").equals("Y")) {
                searchCustodian(data.get("O365_Sharepoint_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("O365_Sharepoint_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("O365_Sharepoint_Custodian"));
                }
            }
            if(data.get("OneDrive_RunState").equals("Y")) {
                searchCustodian(data.get("OneDrive_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("OneDrive_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("OneDrive_Custodian"));
                }
            }
            if(data.get("MS_Teams_RunState").equals("Y")) {
                searchCustodian(data.get("MS_Teams_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("MS_Teams_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("MS_Teams_Custodian"));
                }
            }

            if(data.get("Hangouts_Chat_RunState").equals("Y")) {
                searchCustodian(data.get("Hangouts_Chat_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Hangouts_Chat_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Hangouts_Chat_Custodian"));
                }
            }
            if(data.get("GMail_RunState").equals("Y")) {
                searchCustodian(data.get("GMail_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("GMail_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("GMail_Custodian"));
                }
            }
            if(data.get("GDrive_RunState").equals("Y")) {
                searchCustodian(data.get("GDrive_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("GDrive_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("GDrive_Custodian"));
                }
            }
            if(data.get("Google_Chat_RunState").equals("Y")) {
                searchCustodian(data.get("Google_Chat_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" +data.get("Google_Chat_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Google_Chat_Custodian"));
                }
            }

            if(data.get("Dropbox_RunState").equals("Y")) {
                searchCustodian(data.get("Dropbox_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Dropbox_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Dropbox_Custodian"));
                }
            }
            if(data.get("Box_RunState").equals("Y")) {
                searchCustodian(data.get("Box_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Box_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Box_Custodian"));
                }
            }
            if(data.get("Proofpoint_RunState").equals("Y")) {
                searchCustodian(data.get("Proofpoint_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Proofpoint_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Proofpoint_Custodian"));
                }
            }
            if(data.get("Zoom_Video_RunState").equals("Y")) {
                searchCustodian(data.get("Zoom_Video_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Zoom_Video_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Zoom_Video_Custodian"));
                }
            }
            if(data.get("Zoom_Chat_RunState").equals("Y")) {
                searchCustodian(data.get("Zoom_Chat_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Zoom_Chat_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Zoom_Chat_Custodian"));
                }
            }
            if(data.get("Onna_RunState").equals("Y")) {
                searchCustodian(data.get("Onna_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Onna_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Onna_Custodian"));
                }
            }
            if(data.get("Slack_RunState").equals("Y")) {
                searchCustodian(data.get("Slack_Custodian"));
                try {
                    if (getCurrentDriver().findElement(By.xpath("//span[@title='" + data.get("Slack_Custodian") + "']")).isDisplayed()){
                        log_Info("Custodian is already Added to Grid");
                    }
                }catch(Exception ex){
                    addCustodianToCase(data.get("Slack_Custodian"));
                }
            }

            return new CaseCustodiansPage();
        }catch(Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("multipleCustodianSelect() Failed", ex);
        }
    }
    /**
     * Method to validate Custodian Added from Employee master Grid is Added to Custodian Grid
     * @param Custodian
     * @return
     * @throws Exception
     */
    public ILiglPage validateCustodianAddedToGrid(String Custodian) throws Exception{
        try{
            log_Info("validateCustodianAddedToGrid() Started");
            searchCustodian(Custodian);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Custodian+"']")).isDisplayed();
            return new CaseCustodiansPage();
        }catch (Exception ex){
            log_Error("validateCustodianAddedToGrid() Failed");
            throw new Exception("Exception in validateCustodianAddedToGrid()");
        }
    }
    public ILiglPage addInActiveEMPToCase(String EmpMail) throws Exception {
        addCustodianToCase(EmpMail);
        log_Info("addInActiveEMPToCase() Started");
        InactEmpProceed.click();
        Thread.sleep(3000);
        return new CaseCustodiansPage();
    }
    /**
     * Method to Search The Particular Custodian in Grid
     * @param Custodian
     * @return
     * @throws Exception
     */
    public ILiglPage searchCustodian(String Custodian) throws Exception{
        try{
            log_Info("searchCustodian() Started");
            try {
                Thread.sleep(1000);
                if (Searchbar.isDisplayed()) {
                    Searchbar.clear();
                    Searchbar.sendKeys(Custodian);
                }
            }catch(Exception ex){
                CustEmailHeader.click();
            }
            Thread.sleep(1000);
            try {
                if(Searchbar.isDisplayed()) {
                    Searchbar.clear();
                    Searchbar.sendKeys(Custodian);
                }
                Thread.sleep(1000);
            }catch(Exception ex){

                Filter.click();
                Searchbar.sendKeys(Custodian);
                Thread.sleep(1000);
            }
            return new CaseCustodiansPage();
        }catch (Exception ex){
            log_Error("searchCustodian() failed");
            throw new Exception("Exception in searchCustodian()");
        }
    }


    // Adding One Or More Custodians To A case Through Single/Multiple Filters

    public ILiglPage addCustodiansToCaseThroughFilters(String Employee1, String Employee2) throws Exception {

        try {

            log_Info("Click On Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Custodians button clicked");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);

            log_Info("Hover on Name Header");
            getDriver().waitForelementToBeClickable(EmailName);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmailName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            EmailMenuu.click();
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(2000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(2000);
            log_Info("Enter Employee");
            Searchbar.sendKeys(Employee1);

            // Second Filter Through Alias

           /* ac.moveToElement(AliasName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            AliasMenu.click();
            log_Info("Menu clicked");
            Thread.sleep(2000);

            log_Info("Click on Filter");
            Thread.sleep(2000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(2000);
            log_Info("Enter Employee");
            Searchbar.sendKeys("vyerra");
            log_Info(" Employee Entered ");*/


            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee2 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Employee checked");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            Thread.sleep(3000);
            AddToCase.click();
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addCustodiansToCaseThroughFilters() Failed", ex);
        }
    }

    // Validating The Custodians After Adding In The Custodian Page

    public ILiglPage validatingCustodians(String Employee2) throws Exception {

        try {

            log_Info("Check The Name Of The Custodian");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee2 + "']")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validatingCustodians()", ex);
        }
    }

    // Validating The Columns in the Custodian Page

    public ILiglPage verifyColumnsInCustodianGrid() throws Exception {

        try {

            log_Info("Click On Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Custodians button clicked");

            log_Info("Check The Column names In The Custodian Page");
            boolean c1 = NameHead.isDisplayed();
            boolean c2 = IdHead.isDisplayed();
            boolean c3 = AliasName.isDisplayed();
            boolean c4 = DepartmentHead.isDisplayed();
            boolean c5 = EmailName.isDisplayed();

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);

            boolean c6 = EmployeeStatusHeader.isDisplayed();
            /*boolean c7 = DateJoinedHead.isDisplayed();
            boolean c8 = DateTerminatedHead.isDisplayed();
            boolean c9 = ActionHead.isDisplayed();*/

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);
           /* System.out.println(c7);
            System.out.println(c8);
            System.out.println(c9);*/

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            Assert.assertEquals(true, c6);
           /* Assert.assertEquals(true, c7);
            Assert.assertEquals(true, c8);
            Assert.assertEquals(true, c9);*/
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInCustodianGrid()", ex);
        }
    }


    // Click On The Selected EmployeeCheck Box From The Grid

    public ILiglPage clickOnTheCutsodianCheckBox(String Emp1) throws Exception {

        try {

            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Emp1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Employee checked");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnTheCutsodianCheckBox() Failed", ex);
        }
    }

    // Click On Add To Case Button For Adding An Employee To Custodian

    public ILiglPage clickOnAddToCaseButton() throws Exception {
        try {


            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            Thread.sleep(3000);
            AddToCase.click();
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addCustodiansToCaseThroughFilters() Failed", ex);
        }
    }

    // Performing The Clear Function In The Search Bar

    public ILiglPage performClearAction(String Email2) throws Exception {
        try {


            log_Info("Click And Clear The Data From The SearchBar");
            Searchbar.clear();
            Thread.sleep(5000);
            log_Info("Enter Employee From The Grid");
            Searchbar.sendKeys(Email2);
            Thread.sleep(5000);
            getSession().log_Pass("Entered Employee From The Grid");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addCustodiansToCaseThroughFilters() Failed", ex);
        }
    }

    // click On Filter Button For Searching The Required Custodians Adding Second Time

    public ILiglPage clickOnFilterButtonOnly() throws Exception {

        try {

            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);

            log_Info("Hover on Name Header");
            getDriver().waitForelementToBeClickable(EmailName);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmailName).perform();
            log_Info("Hovered on Name Header");

            EmpMail.click();
            log_Info("Menu clicked");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnFilterButtonOnly() Failed", ex);
        }
    }

        // Click On Add Custodian To Case At One Time
    public ILiglPage addCustodianToCaseAtOneTime(String Email1) throws Exception {

        try {

            log_Info("addCustodianToCaseAtOneTime() Started");
            log_Info("Click On Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            log_Info("Clicked On Add Custodian Button");

            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmpMail).perform();
            Thread.sleep(5000);

            log_Info("Click On Menu Icon");
            EmpMail.click();
            Thread.sleep(5000);
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(5000);
            log_Info("Enter Employee");
            Searchbar.sendKeys(Email1);
            Thread.sleep(5000);
            log_Info("Entered Employee");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addCustodianToCase() Failed", ex);
        }


    }

    public ILiglPage verifyAdditionalColumnsInCustodianGrid() throws Exception {

        try {

            log_Info("Check The Additional Column names In The Custodian grid");

            log_Info("Checking for Full name column");
            ChooseColumnsMenuCustodians.click();
            log_Info("Searching for Full name column");
            ChooseColumnsSearch.sendKeys("FullName");
            Thread.sleep(2000);
            FullNameCol.click();
            log_Info("Fullname column is Checked from chosse columns");
            ChooseColumnsMenuCustodians.click();
            log_Info("Choose columns closed");
            // boolean c1 = FullNameCol.isDisplayed();
            log_Info("Full name column is displaying in grid");

            boolean c2 = WorkForceID.isDisplayed();
            log_Info("Workforce ID column is displaying in grid");

            boolean c3 = HeritageEmailPrimary.isDisplayed();
            log_Info("Heritage Email Primary column is displaying in grid");

            boolean c4 = HeritageEmailSecondary.isDisplayed();
            log_Info("Heritage Email Secondary column is displaying in grid");

            //System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            Thread.sleep(5000);

            //Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyAdditionalColumnsInCustodianGrid()", ex);
        }
    }
    /**
     * Method to DeActive the Active Custodians in Grid
     * @param Custodian
     * @param Status
     * @return
     * @throws Exception
     */
    public ILiglPage deActivateActiveCustodian(String Custodian,String Status) throws Exception{
        try{
            log_Info("deActivateActiveCustodian() Started");
            //searchCustodian(Custodian);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Custodian+"']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            Thread.sleep(3000);
            ActInActBtn.click();
            DeActiveOption.click();
            YesBtn.click();
            //secondSearchCustodian(Custodian);
            validateCustStatus(Status);
            return new CaseCustodiansPage();
        }catch (Exception ex){
            log_Error("deActivateActiveCustodian() Failed");
            throw new Exception("Exception in deActivateActiveCustodian()");
        }
    }

    /**
     * Method to Activate DeActive Custodians
     * @param Custodian
     * @param Status
     * @return
     * @throws Exception
     */
    public ILiglPage activeInactiveCustodians(String Custodian, String Status) throws Exception{
        try{
            log_Info("activeInactiveCustodians() Started");
            RefreshBtn.click();
            secondSearchCustodian(Custodian);
            Thread.sleep(4000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Custodian+"']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            Thread.sleep(3000);
            ActInActBtn.click();
            ActiveOption.click();
            YesBtn.click();
            validateCustStatus(Status);

            return new CaseCustodiansPage();
        }catch(Exception ex){
            log_Error("activeInactiveCustodians() Failed");
            throw new Exception("Exception in activeInactiveCustodians()",ex);
        }
    }
    /**
     * Method to Search Record Second Time(Change in Filter Button)
     * @param Custodian
     * @return
     * @throws Exception
     */
    public ILiglPage secondSearchCustodian(String Custodian) throws Exception{
        try{
            log_Info("secondSearchCustodian() Started");
            Thread.sleep(3000);
            CustEmailHeader.click();
            Thread.sleep(3000);
            Searchbar.clear();
            Thread.sleep(5000);
            Searchbar.sendKeys(Custodian);
            Thread.sleep(3000);
            return new CaseCustodiansPage();
        }catch (Exception ex){
            log_Error("searchCustodian() failed");
            throw new Exception("Exception in searchCustodian()");
        }
    }
    /**
     * Method to validate the Custodian Status in case Custodians Grid
     * @param CustStatus
     * @return
     * @throws Exception
     */
    public ILiglPage validateCustStatus(String CustStatus) throws Exception{
        try{
            log_Info("validateCustStatus() Started");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='FullName']//span[@class='ellipsisAgGrid']")).click();
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 8; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }

            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+CustStatus+"')]")).isDisplayed();
            Thread.sleep(4000);
            for (int i = 0; i < 8; i++) {
                ac.sendKeys(Keys.ARROW_LEFT).perform();
            }
            log_Info("Status is updated");

            return new CaseCustodiansPage();
        }catch (Exception ex){
            log_Error("validateCustStatus is Failed");
            throw new Exception("Exception in validateCustStatus()");
        }
    }

    //validating Action column is unavailable for Non-legal user & Non-legal reviewer
    public ILiglPage validateUnavailabilityOfActionColumnInEmployeeMasterFromCustodiansPage() throws Exception{

        try {
            AddCust.click();
            log_Info("Clicked Add Custodian button");
            Thread.sleep(5000);
            boolean v1 = DisabledImportTab.isEnabled();
            System.out.println(v1);
            Assert.assertEquals(true, v1);
            log_Info("Import tab is disabled when redirected from Custodians page");
            Thread.sleep(5000);
            ChooseColumnsEmployeeMaster.click();
            log_Info("Clicked Choose columns");
            try
            {
                log_Info("Started checking unavailability of Action column in Employee master grid when redirected from Custodians page");
                ChooseColumnsSearch.sendKeys("Action");
                if(ActionColumn.isDisplayed()){
                    log_Error("Incorrect: Action column is displaying");
                }
            }
            catch (Exception ex)
            {
                log_Info("Action column is not displaying");
            }
            Thread.sleep(5000);
            BackButton.click();
            log_Info("Clicked Back button and redirected to Custodians page");
            Thread.sleep(5000);
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateUnavailabilityOfCreateAndEditOfEmployeeFromCustodiansPage() Failed",ex);
        }
    }

}


