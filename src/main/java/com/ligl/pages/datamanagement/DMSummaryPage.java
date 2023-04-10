package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class DMSummaryPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//input[@class='ag-input-field-input ag-checkbox-input']/ancestor::ag-grid-angular[@class='ag-theme-balham']//div[@class='ag-center-cols-container']//div[@role='row']//div[position()=1]//div[@ref='eWrapper']")
    WebElement SummaryCheckBox;
    @FindBy(id = "refresh-button")
    WebElement RefreshBtn;
    @FindBy(xpath = "//ag-grid-angular//div[@ref='eCenterContainer']//span[contains(text(),'Collection Completed')]")
    WebElement ColComStatus;

    @FindBy(xpath = "//span[contains(text(),'Custodian Name')]/ancestor::div[@ref='eLabel']")
    WebElement CustodianNameHeader;

    @FindBy(xpath = "//span[contains(text(),'Custodian Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable']//span//span")
    WebElement CustodianNameMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    // For Single Record Waiting For The Collection Completed Status

    public ILiglPage waitAndvalidateForRecordToCompleteCollection(String status) throws Exception {

        try {

            log_Info("waitAndvalidateForRecordToCompleteCollection() Started");
            Thread.sleep(3000);
            SummaryCheckBox.click();

            for (int i = 0; i < 16; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            for (int i = 1; i <= 10; i++) {
                try {
                    WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
                    wait.until(ExpectedConditions.visibilityOf(ColComStatus));
                    String s = ColComStatus.getText();
                    if (s.equals(status)) {
                        break;
                    }
                } catch (Exception e) {

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

        } catch (Exception ex) {
            log_Error("waitAndvalidateForRecordToCompleteCollection() Failed");
            throw new Exception("Exception in waitAndvalidateForRecordToCompleteCollection()", ex);
        }
    }

    /**
     * Gets Collection Size
     * @return
     * @throws Exception
     */
    public String getCollectionSize()throws Exception{
        try{
            log_Info("getCollectionSize() Started");
            String CollectioSize=null;
           // WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = getCurrentDriver().findElements(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']"));
            for(WebElement rows :listItem){
               List<WebElement> RowList = rows.findElements(By.xpath("//div[@role='gridcell'][@col-id='SizeWithUnit']//span[@class='ellipsisAgGrid']"));
               for(WebElement size:RowList){
                   CollectioSize=size.getText();
               }
            }
            return CollectioSize;
        }catch(Exception ex){
            log_Error("getCollectionSize() Failed");
            throw new Exception("Exception in getCollectionSize()", ex);
        }
    }

    public String getCollectionCount()throws Exception{
        try{
            log_Info("getCollectionCount() Started");
            String CollectioSize=null;
            // WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = getCurrentDriver().findElements(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']"));
            for(WebElement rows :listItem){
                List<WebElement> RowList = rows.findElements(By.xpath("//div[@role='gridcell'][@col-id='ItemCount']//span[@class='ellipsisAgGrid']"));
                for(WebElement size:RowList){
                    CollectioSize=size.getText();
                }
            }
            return CollectioSize;
        }catch(Exception ex){
            log_Error("getCollectionCount() Failed");
            throw new Exception("Exception in getCollectionCount()", ex);
        }
    }
    /**
     * Wait and Validate CCDs Status
     * @param CollectionStatus
     * @return DMSummaryPage
     * @throws Exception
     */
    public ILiglPage validateAndWaitForRecordsToCompleteCollection(String CollectionStatus) throws Exception {

        try {

            log_Info("validateAndWaitForRecordsToCompleteCollection() Started");
            Thread.sleep(5000);
            SummaryCheckBox.click();

            for (int i = 0; i < 16; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            int y = 0;
            int z = 0;

            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));

            Outer:

            for (int i = 1; i <= 200; i++) {

                try {

                    Thread.sleep(30000);
                    for (int j = 0; j < listItem.size(); j++) {
                        String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();

                        if (actualValue.equalsIgnoreCase(CollectionStatus)) {
                            y++;
                        }
                        if (actualValue.contains("Failed")) {
                            y++;
                            z++;
                        }
                        if(listItem.size() == y){
                            getSession().takeScreenShot();
                            break Outer;
                        }
                    }
                    z=0;
                    y=0;
                    RefreshBtn.click();


                } catch (Exception e) {

                }

            }

            for (int j = 0; j < listItem.size(); j++) {
                String Status = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='WorkFlowStatusReason']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.ARROW_LEFT).perform();
                }
                String DataSource = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='DataSourceTypeName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DataSourceTypeName']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.TAB).perform();
                }
                if(Status.contains("Failed")) {
                    String FailedReason = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusReason']//span[@class='ellipsisAgGrid']")).getText();
                    log_Info("Status of '" + DataSource + "' is '" + Status + "' with Reason '"+FailedReason+"' ");
                }
                else{
                    log_Info("Status of '"+DataSource+"' is '"+Status+"' ");
                }
            }
            if (z==listItem.size()) {
                getSession().takeScreenShot();
                return new DMSummaryPage();

            }

            return new DMSummaryPage();

        } catch (Exception ex) {
            log_Error("validateAndWaitForRecordsToCompleteCollection() Failed");
            throw new Exception("validateAndWaitForRecordsToCompleteCollection()", ex);
        }
    }
    public ILiglPage validateCollectionStats() throws Exception{
        try{
            log_Info("Started validateCollectionStats()");
            String ColSize=getCollectionSize();
            String ColCount=getCollectionCount();
            try {
                if (ColSize == getSession().getRegressionData("TC_01_CollectionSize")) {
                    log_Pass("Collection Size is Matched");
                    if (ColCount == getSession().getRegressionData("TC_01_CollectionCount")) {
                        log_Pass("Collection Count is Matched");
                    }
                }
            }catch (Exception ex){
                throw new Exception("Collection Size/Count not getting as Expected or null");
            }

            return new DMSummaryPage();
        }catch (Exception ex){
            log_Error("validateCollectionStats() Failed");
            throw new Exception("validateCollectionStats()", ex);
        }
    }
}


