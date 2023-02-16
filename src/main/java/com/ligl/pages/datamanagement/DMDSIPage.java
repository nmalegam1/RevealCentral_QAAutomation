package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import org.apache.poi.hssf.record.PageBreakRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import java.security.InvalidKeyException;


public class DMDSIPage extends LiglBaseSessionPage {
    @FindBy(id = "add-datasource")
    WebElement AddDSBtn;
    @FindBy(id = "dsi-custodian")
    WebElement CustDropDown;
    @FindBy(id = "dsi-datasource-type")
    WebElement DataSourceDropDown;
    @FindBy(id = "dsi-DHScope-id")
    WebElement DataHoldScopeDD;

    @FindBy(id = "dsi-daterange-id")
    WebElement DateRangeDrpDwn;

    @FindBy(id = "dsi-keyword-id")
    WebElement KeyWordDrpDwn;

    @FindBy(xpath = "//span[contains(text(),' None')]")
    WebElement DataHoldNone;
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement SearchBtn;
    @FindBy(id = "btn-yes")
    WebElement AutomateYesBtn;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham choosecolumns']//div[@ref='eCheckbox']")
    WebElement RecordCheckBox;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@class='ag-center-cols-container']//div[@role='row']//div[position()=14]//span[@class='ellipsisAgGrid']")
    WebElement StatusText;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@ref='eCheckbox']")
    WebElement DSIGridCheckBox;
    @FindBy(id = "Add-records-to-dsi")
    WebElement AddRecordToDSI;
    @FindBy(xpath = "//button[contains(text(),'Automate')]")
    WebElement AutomateBtn;

    @FindBy(id = "General-button")
    WebElement GeneralBtn;

    @FindBy(xpath = "//span[contains(text(),'Account Email')]/ancestor::div[@ref='eLabel']")
    WebElement AccountEmailHeader;

    @FindBy(xpath = "//span[contains(text(),'Account Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement AccountEmailMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;


    public ILiglPage addDataSourceRecordToDSIGrid(String cust, String datasource, String DataHold,String DateRanges,String Keywords) throws Exception {

        try {


            log_Info("addDataSourceRecordToDSIGrid() Started");
            log_Info("Click on Add Data Source Button");
            getDriver().waitForelementToBeClickable(AddDSBtn);
            Thread.sleep(3000);
            AddDSBtn.click();
            log_Info("Clicked on Add Data Source Button");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);


            log_Info("Click on Custodian Drop Down");
            getDriver().waitForelementToBeClickable(CustDropDown);
            Thread.sleep(5000);
            CustDropDown.sendKeys(Keys.ENTER);
            CustDropDown.sendKeys(cust);

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);
            GeneralBtn.click();
            log_Info("Clicked on Custodian Drop Down");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);

            log_Info("Click on DataSource Drop Down");
            getDriver().waitForelementToBeClickable(DataSourceDropDown);
            Thread.sleep(5000);
            DataSourceDropDown.sendKeys(Keys.ENTER);
            DataSourceDropDown.sendKeys(datasource);
            log_Info("Clicked on DataSource Drop Down");

            log_Info("Click on DataHold Scope Drop Down");
            getDriver().waitForelementToBeClickable(DataHoldScopeDD);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            DataHoldScopeDD.sendKeys(DataHold);
            GeneralBtn.click();
            log_Info("Clicked on DataHold Scope Drop Down");


            log_Info("Click on DateRange Drop Down");
            getDriver().waitForelementToBeClickable(DateRangeDrpDwn);
            Thread.sleep(5000);
            DateRangeDrpDwn.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            DateRangeDrpDwn.sendKeys(DateRanges);
            log_Info("Clicked on DateRange Drop Down");

            log_Info("Click on Keywords Drop Down");
            getDriver().waitForelementToBeClickable(KeyWordDrpDwn);
            KeyWordDrpDwn.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            KeyWordDrpDwn.sendKeys(Keywords);
            log_Info("Clicked on Keywords Drop Down");
            

            log_Info("Click on Search Button");
            getDriver().waitForelementToBeClickable(SearchBtn);
            Thread.sleep(5000);
            SearchBtn.click();
            log_Info("Clicked on Search Button");

            log_Info("Click on Selected Record Check Box");
            getDriver().waitForelementToBeClickable(RecordCheckBox);
            Thread.sleep(5000);
            RecordCheckBox.click();
            log_Info("Clicked on Selected Record Check Box");


            log_Info("Click on Add Records To DSI Button");
            getDriver().waitForelementToBeClickable(AddRecordToDSI);
            Thread.sleep(5000);
            AddRecordToDSI.click();
            Thread.sleep(5000);
            log_Info("Clicked on Add Records To DSI Button");

            return new DMDSIPage();

        } catch (Exception ex) {
            log_Error("addDataSourceRecordToDSIGrid() Failed");
            throw new Exception("Exception in addDataSourceRecordToDSIGrid()", ex);
        }
    }

    public ILiglPage automateRecordInDSI() throws Exception {
        try {

            log_Info("automateRecordInDSI() Started");
            DSIGridCheckBox.click();
            AutomateBtn.click();
            AutomateYesBtn.click();
            Thread.sleep(7000);
            return new DMDSIPage();
        } catch (Exception ex) {
            log_Error("automateRecordInDSI() Failed");
            throw new Exception("Exception in automateRecordInDSI()", ex);
        }
    }


    // Searching Account Email Through Search Filter - First Time

    public ILiglPage searchAccountEmailRecordInDSI(String Email1) throws Exception {

        try {

            log_Info("searchAccountEmailRecordInDSI() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(AccountEmailHeader).perform();
            Thread.sleep(5000);

            log_Info("Click On Menu Icon");
            AccountEmailMenu.click();
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
            return new DMDSIPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchAccountEmailRecordInDSI() Failed", ex);
        }
    }

        // Click On Filter For Searching Email

    public ILiglPage searchAccountEmailOneMoreTime() throws Exception{

        try{

            log_Info("searchAccountEmailOneMoreTime() Started");
        log_Info("Hover on Name Header");
        Thread.sleep(5000);
        Actions ac=new Actions(getCurrentDriver());
        ac.moveToElement(AccountEmailHeader).perform();
        Thread.sleep(5000);

        log_Info("Click On Menu Icon");
        AccountEmailMenu.click();
        Thread.sleep(5000);
        log_Info("Menu clicked");
        log_Info("Clear Email From The Search Bar");
        Searchbar.clear();
        return new DMDSIPage();

        }catch(Exception ex){
        log_Error("searchAccountEmailOneMoreTime() Failed");
        throw new Exception("Exception in searchAccountEmailOneMoreTime()",ex);
        }
    }


    // Click On The Check Box Of Custodian

    public ILiglPage clickOnCheckBoxOfCustodian() throws Exception{

        try{

            log_Info("clickOnCheckBoxOfCustodian() Started");
            log_Info("Click On The Check Box");
            Thread.sleep(5000);
            DSIGridCheckBox.click();
            Thread.sleep(5000);
            log_Info("Clicked On The Check Box");
            return new DMDSIPage();

        }catch(Exception ex){
            log_Error("clickOnCheckBoxOfCustodian() Failed");
            throw new Exception("Exception in clickOnCheckBoxOfCustodian()",ex);
        }
    }

    public ILiglPage sendingAccountEmailOneMorTime(String Email2) throws Exception{

        try {

            log_Info("sendingAccountEmailOneMorTime() Started");
            log_Info("Sending Employee Email To The SearchBar");
            Thread.sleep(5000);
            Searchbar.sendKeys(Email2);
            Thread.sleep(5000);
            log_Info("Entered Employee");
            return new DMDSIPage();

        }catch(Exception ex){
            log_Error("sendingAccountEmailOneMorTime() Failed");
            throw new Exception("Exception in sendingAccountEmailOneMorTime()",ex);
        }
    }


    // CLick On The Automate Button After Selecting The Records In The Grid

    public ILiglPage clickOnAutomateButton() throws Exception{

        try {

            log_Info("clickOnAutomateButton() Started");
            log_Info("Click On Automate Button");
            Thread.sleep(5000);
            AutomateBtn.click();
            Thread.sleep(5000);
            AutomateYesBtn.click();
            Thread.sleep(7000);
            log_Info("Clicked On Automate Button");
            return new DMDSIPage();

        }catch(Exception ex){
            log_Error("clickOnAutomateButton() Failed");
            throw new Exception("Exception in clickOnAutomateButton()",ex);
        }
    }


    public ILiglPage addDataSourceRecordToDSIGridUptoCollection(String cust, String datasource, String DataHold) throws Exception {

        try {


            log_Info("addDataSourceRecordToDSIGrid() Started");
            log_Info("Click on Add Data Source Button");
            getDriver().waitForelementToBeClickable(AddDSBtn);
            Thread.sleep(3000);
            AddDSBtn.click();
            log_Info("Clicked on Add Data Source Button");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);


            log_Info("Click on Custodian Drop Down");
            getDriver().waitForelementToBeClickable(CustDropDown);
            Thread.sleep(5000);
            CustDropDown.sendKeys(Keys.ENTER);
            CustDropDown.sendKeys(cust);

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);
            GeneralBtn.click();
            log_Info("Clicked on Custodian Drop Down");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);

            log_Info("Click on DataSource Drop Down");
            getDriver().waitForelementToBeClickable(DataSourceDropDown);
            Thread.sleep(5000);
            DataSourceDropDown.sendKeys(Keys.ENTER);
            DataSourceDropDown.sendKeys(datasource);
            log_Info("Clicked on DataSource Drop Down");

            log_Info("Click on DataHold Scope Drop Down");
            getDriver().waitForelementToBeClickable(DataHoldScopeDD);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            DataHoldScopeDD.sendKeys(DataHold);
            GeneralBtn.click();
            log_Info("Clicked on DataHold Scope Drop Down");


            log_Info("Click on Search Button");
            getDriver().waitForelementToBeClickable(SearchBtn);
            Thread.sleep(5000);
            SearchBtn.click();
            log_Info("Clicked on Search Button");

            log_Info("Click on Selected Record Check Box");
            getDriver().waitForelementToBeClickable(RecordCheckBox);
            Thread.sleep(5000);
            RecordCheckBox.click();
            log_Info("Clicked on Selected Record Check Box");


            log_Info("Click on Add Records To DSI Button");
            getDriver().waitForelementToBeClickable(AddRecordToDSI);
            Thread.sleep(5000);
            AddRecordToDSI.click();
            Thread.sleep(5000);
            log_Info("Clicked on Add Records To DSI Button");

            return new DMDSIPage();

        } catch (Exception ex) {
            log_Error("addDataSourceRecordToDSIGridUptoCollection() Failed");
            throw new Exception("Exception In addDataSourceRecordToDSIGridUptoCollection()", ex);
        }
    }

}