package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DMSummaryPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@class='ag-center-cols-container']//div[@role='row']//div[position()=1]//div[@ref='eWrapper']")
    WebElement SummaryCheckBox;
    @FindBy(id="refresh-button")
    WebElement RefreshBtn;
    @FindBy(xpath = "//ag-grid-angular//div[@ref='eCenterContainer']//span[contains(text(),'Collection Completed')]")
    WebElement ColComStatus;



    public ILiglPage waitAndvalidateForRecordToCompleteCollection(String status)throws Exception{
        try{
            log_Info("waitAndvalidateForRecordToCompleteCollection() Started");
            Thread.sleep(3000);
            SummaryCheckBox.click();
            //((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReasonHeader);
            for (int i = 0; i < 16; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            for(int i=1;i<=10 ;i++){
                try {
                    var wait = new WebDriverWait(getCurrentDriver(), 30);
                    var div = wait.until(ExpectedConditions.visibilityOf(ColComStatus));
                    String s=ColComStatus.getText();
                    if(s.equals(status)){
                        break;
                    }
                }catch (Exception e){
                    //log_Info("Exception");
                }
                RefreshBtn.click();

            }
            ColComStatus.click();
            Thread.sleep(5000);
            if (getCurrentDriver().getTitle().contains("Data Collection | Vertical")) {
                log_Pass("Navigated to Collection Page");
            }
            log_Pass("Collection Completed");
            getSession().takeScreenShot();
            return new DMCollectionsPage();
        }catch (Exception ex){
            log_Error("waitAndvalidateForRecordToCompleteCollection() Failed");
            throw new Exception("Exception in waitAndvalidateForRecordToCompleteCollection()",ex);
        }
    }
}