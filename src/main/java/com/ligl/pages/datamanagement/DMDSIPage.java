package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import jdk.jfr.Timespan;
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
    @FindBy(id="add-datasource")
    WebElement AddDSBtn;
    @FindBy(id="dsi-custodian")
    WebElement CustDropDown;
    @FindBy(id="dsi-datasource-type")
    WebElement DataSourceDropDown;
    @FindBy(id="dsi-DHScope-id")
    WebElement DataHoldScopeDD;
    @FindBy(xpath = "//span[contains(text(),' None')]")
    WebElement DataHoldNone;
    @FindBy(xpath = "//button[contains(text(),'Search')]")
    WebElement SearchBtn;
    @FindBy(id="btn-yes")
    WebElement AutomateYesBtn;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham choosecolumns']//div[@ref='eCheckbox']")
    WebElement RecordCheckBox;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@class='ag-center-cols-container']//div[@role='row']//div[position()=14]//span[@class='ellipsisAgGrid']")
    WebElement StatusText;
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@ref='eCheckbox']")
    WebElement DSIGridCheckBox;
    @FindBy(id="Add-records-to-dsi")
    WebElement AddRecordToDSI;
    @FindBy(xpath = "//button[contains(text(),'Automate')]")
    WebElement AutomateBtn;

    @FindBy(id = "General-button")
    WebElement GeneralBtn;

    public ILiglPage addDataSourceRecordToDSIGrid(String cust,String datasource,String DataHold) throws Exception{

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
            GeneralBtn.click();
            log_Info("Clicked on DataSource Drop Down");

            log_Info("Click on DataHold Scope Drop Down");
            getDriver().waitForelementToBeClickable(DataHoldScopeDD);
            Thread.sleep(5000);
            DataHoldScopeDD.sendKeys(Keys.ENTER);
            DataHoldScopeDD.sendKeys(DataHold);
            GeneralBtn.click();
            log_Info("Clicked on DataHold Scope Drop Down");









           /* Select st = new Select(getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+cust+"')]")));
            DataSourceDropDown.click();


            WebElement mnuOptionElement;
            mnuOptionElement = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+cust+"')]"));
            Actions builder = new Actions(getCurrentDriver());
            // Move cursor to the Main Menu Element
            *//*builder.moveToElement(mnuOptionElement).click();*//*
            builder.moveToElement(mnuOptionElement).sendKeys(Keys.ENTER);*/



           // getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+cust+"')]")).click();
            //getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+cust+"')]")).sendKeys(Keys.ENTER);

           /* DataSourceDropDown.click();
            //DataSourceDropDown.click();
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+datasource+"')]")).click();
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+datasource+"')]")).sendKeys(Keys.ENTER);
            Thread.sleep(3000);
*/
          /*  Thread.sleep(3000);
            DataHoldScopeDD.click();
            DataHoldNone.sendKeys(Keys.ENTER);
            //DataHoldNone.click();
            Thread.sleep(3000);*/

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
            log_Info("Clicked on Add Records To DSI Button");

            return new DMDSIPage();

        }catch (Exception ex){
            log_Error("addDataSourceRecordToDSIGrid() Failed");
            throw new Exception("Exception in addDataSourceRecordToDSIGrid()",ex);
        }
    }
    public ILiglPage automateRecordInDSI()throws Exception{
        try{
            log_Info("automateRecordInDSI() Started");
            DSIGridCheckBox.click();
            AutomateBtn.click();
            AutomateYesBtn.click();
            Thread.sleep(7000);
            return new DMDSIPage();
        }catch (Exception ex){
            log_Error("automateRecordInDSI() Failed");
            throw new  Exception("Exception in automateRecordInDSI()",ex);
        }
    }
}