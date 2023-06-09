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

import java.util.Hashtable;
import java.util.List;
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
    @FindBy(id = "Custom-button")
    WebElement CustomTab;
    @FindBy(id = "source-path")
    WebElement SourcePath;
    @FindBy(id="dsi-datasource-type")
    WebElement CustomDSTDropdown;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement CustomSaveBtn;
    @FindBy(xpath = "//button[contains(text(),'Proceed')]")
    WebElement CustomProceedBtn;
    @FindBy(id="btn-ok")
    WebElement ConfirmationBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(id="dsi-daterange-id")
    WebElement CustomDRDropdown;

    @FindBy(id="dsi-keyword-id")
    WebElement CustomKWDropdown;
    @FindBy(id="select-all-id")
    WebElement SelectAllCCDs;

    @FindBy(id = "all-selected-records")
    WebElement PleaseSelectDropdown;

    @FindBy(xpath = "//select[@id='all-selected-records']//option[@value='Selected']")
    WebElement SelectedDropdown;

    @FindBy(id = "selected-records-run")
    WebElement SelectedRecordsRunBtn;


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
            Thread.sleep(5000);
            CustDropDown.sendKeys(cust);

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);
           /* GeneralBtn.click();*/
         /*   log_Info("Clicked on Custodian Drop Down");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", GeneralBtn);*/

            log_Info("Click on DataSource Drop Down");
            getDriver().waitForelementToBeClickable(DataSourceDropDown);
            Thread.sleep(5000);
            DataSourceDropDown.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            DataSourceDropDown.sendKeys(datasource);
            log_Info("Clicked on DataSource Drop Down");

            log_Info("Click on DataHold Scope Drop Down");
            getDriver().waitForelementToBeClickable(DataHoldScopeDD);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(DataHold);
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


            log_Info("Click on Add To Identification DropDown");
            getDriver().waitForelementToBeClickable(PleaseSelectDropdown);
            Thread.sleep(5000);
            PleaseSelectDropdown.click();
            Thread.sleep(5000);
            SelectedDropdown.click();
            Thread.sleep(5000);
            log_Info("Clicked on Add To Identification DropDown");

            log_Info("Click on Run Button");
            getDriver().waitForelementToBeClickable(SelectedRecordsRunBtn);
            Thread.sleep(5000);
            SelectedRecordsRunBtn.click();
            log_Info("Clicked on Run Button");

            return new DMDSIPage();

        } catch (Exception ex) {
            log_Error("addDataSourceRecordToDSIGrid() Failed");
            throw new Exception("Exception in addDataSourceRecordToDSIGrid()", ex);
        }
    }

    public ILiglPage addingDSToDSIThroughCustom(String cust, String datasource,String sourcepath,String DataHold)throws Exception{
        try{
            log_Info("addingDSToDSIThroughCustom() Started");
            Thread.sleep(3000);
            AddDSBtn.click();
            CustomTab.click();
            Thread.sleep(5000);
            CustDropDown.click();
            Thread.sleep(2000);
            CustDropDown.sendKeys(cust);
            Thread.sleep(3000);
            CustDropDown.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            CustomDSTDropdown.click();
            Thread.sleep(5000);
            CustomDSTDropdown.sendKeys(datasource);
            Thread.sleep(3000);
            CustomDSTDropdown.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            SourcePath.sendKeys(sourcepath);
            Thread.sleep(3000);
            DataHoldScopeDD.click();
            Thread.sleep(3000);
            DataHoldScopeDD.sendKeys(DataHold);
            Thread.sleep(3000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            Thread.sleep(2000);




            CustomSaveBtn.click();
            Thread.sleep(2000);
            CustomProceedBtn.click();
            Thread.sleep(2000);
            ConfirmationBtn.click();


            return new DMDSIPage();
        }catch(Exception ex){
            log_Error("addingDSToDSIThroughCustom() Failed");
            throw new Exception("Exception in addingDSToDSIThroughCustom()",ex);
        }
    }

    public ILiglPage multipleCCDsSelect(Hashtable<String, String> data)throws Exception {
        try {

            log_Info("multipleCCDsSelect() Started");
            if (data.get("O365_Exchange_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("O365_Exchange_Cust_FullName"), data.get("O365_Sharepoint_DataSource"), data.get("DHScope"));
            }
            if (data.get("O365_Sharepoint_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("O365_Sharepoint_Cust_FullName"), data.get("O365_Sharepoint_DataSource"), data.get("DHScope"));
            }
            if (data.get("OneDrive_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("OneDrive_Cust_FullName"), data.get("OneDrive_DataSource"), data.get("DHScope"));
            }
            if (data.get("MS_Teams_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("MS_Teams_Cust_FullName"), data.get("MS_Teams_DataSource"), data.get("DHScope"));
            }


            if (data.get("Hangouts_Chat_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("Hangouts_Chat_Cust_FullName"), data.get("Hangouts_Chat_DataSource"), data.get("DHScope"));
            }
            if (data.get("GMail_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("GMail_Cust_FullName"), data.get("GMail_DataSource"), data.get("DHScope"));
            }
            if (data.get("GDrive_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("GDrive_Cust_FullName"), data.get("GDrive_DataSource"), data.get("DHScope"));
            }
            if (data.get("Google_Chat_RunState").equals("Y")) {
                addDataSourceRecordToDSIGridUptoCollection(data.get("Google_Chat_Cust_FullName"), data.get("Google_Chat_DataSource"), data.get("DHScope"));
            }

            if(data.get("Dropbox_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Dropbox_Cust_FullName"),data.get("Dropbox_DataSource"),data.get("DHScope"));
            if(data.get("Box_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Box_Cust_FullName"),data.get("Box_DataSource"),data.get("DHScope"));
            if(data.get("Proofpoint_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Proofpoint_Cust_FullName"),data.get("Proofpoint_DataSource"),data.get("DHScope"));
            if(data.get("Zoom_Video_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Zoom_Video_Cust_FullName"),data.get("Zoom_Video_DataSource"),data.get("DHScope"));


            if(data.get("Zoom_Chat_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Zoom_Chat_Cust_FullName"),data.get("Zoom_Chat_DataSource"),data.get("DHScope"));
            if(data.get("Onna_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Onna_Cust_FullName"),data.get("Onna_DataSource"),data.get("DHScope"));
            if(data.get("Slack_RunState").equals("Y"))
                addDataSourceRecordToDSIGridUptoCollection(data.get("Slack_Cust_FullName"),data.get("Slack_DataSource"),data.get("DHScope"));


            return new DMDSIPage();
        } catch (Exception ex) {
            log_Error("multipleCCDsSelect() Failed");
            throw new Exception("multipleCCDsSelect()", ex);
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

            log_Info("Click On Menu Icon");
            AccountEmailMenu.click();
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
            AddDSBtn.click();
            Thread.sleep(3000);
            log_Info("Clicked on Add Data Source Button");

            log_Info("Click on Custodian Drop Down");
            getDriver().waitForelementToBeClickable(CustDropDown);
            CustDropDown.sendKeys(cust);
            Thread.sleep(3000);
            CustDropDown.sendKeys(Keys.ENTER);
            Thread.sleep(3000);

            log_Info("Clicked on Custodian Drop Down");

            log_Info("Click on DataSource Drop Down");
            getDriver().waitForelementToBeClickable(DataSourceDropDown);
            DataSourceDropDown.sendKeys(datasource);
            Thread.sleep(5000);
            DataSourceDropDown.sendKeys(Keys.ENTER);
            log_Info("Clicked on DataSource Drop Down");

            log_Info("Click on DataHold Scope Drop Down");
            getDriver().waitForelementToBeClickable(DataHoldScopeDD);
            DataHoldScopeDD.sendKeys(DataHold);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            log_Info("Clicked on DataHold Scope Drop Down");


            log_Info("Click on Search Button");
            getDriver().waitForelementToBeClickable(SearchBtn);
            SearchBtn.click();
            log_Info("Clicked on Search Button");

            log_Info("Click on Selected Record Check Box");
            getDriver().waitForelementToBeClickable(RecordCheckBox);
            Thread.sleep(5000);
            RecordCheckBox.click();
            log_Info("Clicked on Selected Record Check Box");


            log_Info("Click on Add To Identification DropDown");
            getDriver().waitForelementToBeClickable(PleaseSelectDropdown);
            Thread.sleep(5000);
            PleaseSelectDropdown.click();
            Thread.sleep(5000);
            SelectedDropdown.click();
            Thread.sleep(5000);
            log_Info("Clicked on Add To Identification DropDown");

            log_Info("Click on Run Button");
            getDriver().waitForelementToBeClickable(SelectedRecordsRunBtn);
            Thread.sleep(5000);
            SelectedRecordsRunBtn.click();
            Thread.sleep(3000);
            log_Info("Clicked on Run Button");

            return new DMDSIPage();

        } catch (Exception ex) {
            log_Error("addDataSourceRecordToDSIGridUptoCollection() Failed");
            throw new Exception("Exception In addDataSourceRecordToDSIGridUptoCollection()", ex);
        }
    }

    public ILiglPage selectAllCCDs() throws InterruptedException {
        log_Info("selectAllCCDs() Started");
        SelectAllCCDs.click();
        Thread.sleep(2000);
        return new DMDSIPage();
    }

    public ILiglPage verifyNonApprovedScopeInCustomTab(String Custodian,String Datasource,String Daterange,String Keyword) throws Exception
    {

        try {

            log_Info("verifyNonApprovedScopeInCustomTab() Started");
            AddDSBtn.click();
            log_Info("Add Datasource button clicked");
            Thread.sleep(5000);
            CustomTab.click();
            log_Info("Custom tab is clicked");
            Thread.sleep(5000);

            CustDropDown.click();
            Thread.sleep(5000);

            log_Info("Custodian dropdown clicked");
            log_Info("Started Non-Approved Custodian validation in Custodian dropdown");
            boolean temp1 =false;
            WebElement test1=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-custodian-panel']"));
            List<WebElement> listItem1=test1.findElements(By.tagName("mat-option"));
            for(int i = 0; i<  listItem1.size(); i++)
            {
                String actualValue=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-custodian-panel']//mat-option["+(i+1)+"]//span[@class='mat-option-text']")).getText();
                if(actualValue.equalsIgnoreCase(Custodian))
                {
                    temp1=true;
                    break;
                }
            }
            if(temp1==true)
                System.out.println("Non-Approved Custodian is displaying in dropdown-Not Expected");
            else
                System.out.println("Non-Approved Custodian is not displaying in dropdown-Expected");
            log_Info("Completed Non-Approved Custodian validation in Custodian dropdown");


            CustDropDown.sendKeys(Keys.ENTER);
            Thread.sleep(5000);

            CustomTab.click();
            Thread.sleep(5000);

            CustomDSTDropdown.click();
            Thread.sleep(5000);
            log_Info("Datasource dropdown clicked");

            log_Info("Started Non-Approved Datasource validation in Datasource dropdown");
            boolean temp2 =false;
            WebElement test2=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-datasource-type-panel']"));
            List<WebElement> listItem2=test2.findElements(By.tagName("mat-option"));
            for(int i = 0; i<  listItem2.size(); i++)
            {
                String actualValue=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-datasource-type-panel']//mat-option["+(i+1)+"]//span[@class='mat-option-text']")).getText();
                if(actualValue.equalsIgnoreCase(Datasource))
                {
                    temp2=true;
                    break;
                }
            }
            if(temp2==true)
                System.out.println("Non-Approved Datasource is displaying in dropdown-Not Expected");
            else
                System.out.println("Non-Approved Datasource is not displaying in dropdown-Expected");
            log_Info("Completed Non-Approved Datasource validation in Datasource dropdown");

            CustomDSTDropdown.sendKeys(Keys.ENTER);
            Thread.sleep(5000);

            CustomTab.click();
            Thread.sleep(5000);

            CustomDRDropdown.click();
            log_Info("Daterange dropdown clicked");
            log_Info("Started Non-Approved Dateranges validation in Dateranges dropdown");
            boolean temp3 =false;
            WebElement test3=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-daterange-id-panel']"));
            List<WebElement> listItem3=test3.findElements(By.tagName("mat-option"));
            for(int i = 0; i<  listItem3.size(); i++)
            {
                String actualValue=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-daterange-id-panel']//mat-option["+(i+1)+"]//span[@class='mat-option-text']")).getText();
                if(actualValue.equalsIgnoreCase(Daterange))
                {
                    temp3=true;
                    break;
                }
            }
            if(temp3==true)
                System.out.println("Non-Approved Dateranges is displaying in dropdown-Not Expected");
            else
                System.out.println("Non-Approved Dateranges is not displaying in dropdown-Expected");
            log_Info("Completed Non-Approved Dateranges validation in Dateranges dropdown");
            CustomDRDropdown.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            CustomTab.click();

            CustomKWDropdown.click();
            log_Info("Keyword dropdown clicked");
            log_Info("Started Non-Approved Keywords validation in Keywords dropdown");
            boolean temp4 =false;
            WebElement test4=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-keyword-id-panel']"));
            List<WebElement> listItem4=test4.findElements(By.tagName("mat-option"));
            for(int i = 0; i<  listItem4.size(); i++)
            {
                String actualValue=getCurrentDriver().findElement(By.xpath("//div[@id='dsi-keyword-id-panel']//mat-option["+(i+1)+"]//span[@class='mat-option-text']")).getText();
                if(actualValue.equalsIgnoreCase(Keyword))
                {
                    temp4=true;
                    break;
                }
            }
            if(temp4==true)
                System.out.println("Non-Approved Keywords is displaying in dropdown-Not Expected");
            else
                System.out.println("Non-Approved Keywords is not displaying in dropdown-Expected");
            log_Info("Completed Non-Approved Keywords validation in Keywords dropdown");
            Thread.sleep(5000);

            log_Pass("verifyNonApprovedScopeInCustomTab() Completed Successfully");

            return new DMDSIPage();

        }catch(Exception ex){
            log_Error("verifyNonApprovedScopeInCustomTab() Failed");
            throw new Exception("Exception in verifyNonApprovedScopeInCustomTab()",ex);
        }
    }
}