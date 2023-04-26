package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.apache.maven.surefire.shade.booter.org.apache.commons.lang3.ObjectUtils;
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

    @FindBy(xpath = "//button//span[contains(text(),' IPP - Legal Hold Scope ')]")
    WebElement DMLHScopeBTN;

    @FindBy(id = "btn-cross")
    WebElement ScopPopupCloseBtn;

    @FindBy(xpath = "//span[@class='viewTextPlace']")
    WebElement LHScopePopupText;



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
     *
     * @return
     * @throws Exception
     */
    public String getCollectionSize() throws Exception {
        try {
            log_Info("getCollectionSize() Started");
            String CollectioSize = null;
            // WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = getCurrentDriver().findElements(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']"));
            for (WebElement rows : listItem) {
                List<WebElement> RowList = rows.findElements(By.xpath("//div[@role='gridcell'][@col-id='SizeWithUnit']//span[@class='ellipsisAgGrid']"));
                for (WebElement size : RowList) {
                    CollectioSize = size.getText();
                }
            }
            return CollectioSize;
        } catch (Exception ex) {
            log_Error("getCollectionSize() Failed");
            throw new Exception("Exception in getCollectionSize()", ex);
        }
    }

    public String getCollectionCount() throws Exception {
        try {
            log_Info("getCollectionCount() Started");
            String CollectioSize = null;
            // WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = getCurrentDriver().findElements(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']"));
            for (WebElement rows : listItem) {
                List<WebElement> RowList = rows.findElements(By.xpath("//div[@role='gridcell'][@col-id='ItemCount']//span[@class='ellipsisAgGrid']"));
                for (WebElement size : RowList) {
                    CollectioSize = size.getText();
                }
            }
            return CollectioSize;
        } catch (Exception ex) {
            log_Error("getCollectionCount() Failed");
            throw new Exception("Exception in getCollectionCount()", ex);
        }
    }

    /**
     * Wait and Validate CCDs Status
     *
     * @param Status
     * @return DMSummaryPage
     * @throws Exception
     */
    public ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(String Status) throws Exception {

        try {

            log_Info("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid() Started");
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
                        String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();

                        if (actualValue.equalsIgnoreCase(Status)) {
                            y++;
                        }
                        if (actualValue.contains("Failed")) {
                            y++;
                            z++;
                        }
                        if (listItem.size() == y) {
                            getSession().takeScreenShot();
                            break Outer;
                        }
                    }
                    z = 0;
                    y = 0;
                    RefreshBtn.click();


                } catch (Exception e) {

                }

            }

            for (int j = 0; j < listItem.size(); j++) {
                String Status1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='WorkFlowStatusReason']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.ARROW_LEFT).perform();
                }
                String DataSource = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='DataSourceTypeName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DataSourceTypeName']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.TAB).perform();
                }
                if (Status1.contains("Failed")) {
                    String FailedReason = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusReason']//span[@class='ellipsisAgGrid']")).getText();
                    log_Info("Status of '" + DataSource + "' is '" + Status1 + "' with Reason '" + FailedReason + "' ");
                } else {
                    log_Info("Status of '" + DataSource + "' is '" + Status1 + "' ");
                }
            }
            if (z == listItem.size()) {
                getSession().takeScreenShot();
                return new DMSummaryPage();

            }

            return new DMSummaryPage();

        } catch (Exception ex) {
            log_Error("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid() Failed");
            throw new Exception("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid()", ex);
        }
    }

    public ILiglPage validateCollectionStats() throws Exception {
        try {
            log_Info("Started validateCollectionStats()");
            String ColSize = getCollectionSize();
            String ColCount = getCollectionCount();
            try {
                if (ColSize == getSession().getRegressionData("TC_01_CollectionSize")) {
                    log_Pass("Collection Size is Matched");
                    if (ColCount == getSession().getRegressionData("TC_01_CollectionCount")) {
                        log_Pass("Collection Count is Matched");
                    }
                }
            } catch (Exception ex) {
                throw new Exception("Collection Size/Count not getting as Expected or null");
            }

            return new DMSummaryPage();
        } catch (Exception ex) {
            log_Error("validateCollectionStats() Failed");
            throw new Exception("validateCollectionStats()", ex);
        }
    }

    public ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(String Status) throws Exception {

        try {

            log_Info("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid() Started");
            Thread.sleep(2000);
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
                        String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='DataHoldStatusName']//span[@class='ellipsisAgGrid']")).getText();

                        if (actualValue.equalsIgnoreCase(Status)) {
                            y++;
                        }
                        if (actualValue.contains("Failed")) {
                            y++;
                            z++;
                        }
                        if (listItem.size() == y) {
                            getSession().takeScreenShot();
                            break Outer;
                        }
                    }
                    z = 0;
                    y = 0;
                    RefreshBtn.click();


                } catch (Exception e) {

                }

            }

            for (int j = 0; j < listItem.size(); j++) {
                String Status1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='DataHoldStatusName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='WorkFlowStatusReason']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.ARROW_LEFT).perform();
                }
                String DataSource = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='DataSourceTypeName']//span[@class='ellipsisAgGrid']")).getText();
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DataSourceTypeName']")).click();
                for (int i = 0; i < 16; i++) {
                    Actions ac = new Actions(getCurrentDriver());
                    ac.sendKeys(Keys.TAB).perform();
                }
                if (Status1.contains("Failed")) {
                    String FailedReason = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusReason']//span[@class='ellipsisAgGrid']")).getText();
                    log_Info("Status of '" + DataSource + "' is '" + Status1 + "' with Reason '" + FailedReason + "' ");
                } else {
                    log_Info("Status of '" + DataSource + "' is '" + Status1 + "' ");
                }
            }
            if (z == listItem.size()) {
                getSession().takeScreenShot();
                return new DMSummaryPage();

            }

            return new DMSummaryPage();

        } catch (Exception ex) {
            log_Error("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid() Failed");
            throw new Exception("validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid()", ex);
        }
    }

    public ILiglPage goToDMLHScope() {
        log_Info("goToDMLHScope() Started");
        DMLHScopeBTN.click();
        log_Info("Navigated to IPP-LegalHoldScope tab in Data Management");
        return new DMSummaryPage();
    }

    /**
     * To Validate LKW hyperlink popup values for CCD record in Data Management summary-Legal hold scope grid
     * @param ExpectedLHLKW
     * @return Data management Summary grid
     * @throws Exception
     */
    public ILiglPage validateLHKW(String ExpectedLHLKW) throws Exception {
        try {
            log_Info("validateLHKW() started");
            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));
            for(int j= 0;j < listItem.size(); j++)
            {
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")).click();
            String LHLKW = LHScopePopupText.getText();
            if (LHLKW.contains(ExpectedLHLKW)) {
                log_Pass("CCD Record is Populated with Latest LH LKW as Expected");
            }
            else{
                log_Error("CCD Record is not Populated with Latest LH LKW as Expected");
                throw new Exception("CCD Record is not Populated with Latest LH LKW as Expected");
            }
            ScopPopupCloseBtn.click();}
            return new DMSummaryPage();
        } catch (Exception ex) {
            log_Error("validateLHKW() is Failed");
            throw new Exception("Exception in validateLHKW()");
        }
    }

    /**
     * To Validate LDR hyperlink popup values for CCD record in Data Management summary-Legal hold scope grid
     * @param ExpectedLHLDR
     * @return Data management Summary grid
     * @throws Exception
     */
    public ILiglPage validateLHDR(String ExpectedLHLDR) throws Exception {
        try {
            log_Info("validateLHDR() started");
            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));
            for(int j= 0;j < listItem.size(); j++)
            {
                getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")).click();
                String LHLDR=LHScopePopupText.getText();
                if (LHLDR.contains(ExpectedLHLDR)) {
                    log_Pass("CCD Record is Populated with Latest LH LDR as Expected");
                }
                else{
                    log_Error("CCD Record is not Populated with Latest LH LDR as Expected");
                    throw new Exception("CCD Record is not Populated with Latest LH LDR as Expected");
                }
                ScopPopupCloseBtn.click();}
            return new DMSummaryPage();
        } catch (Exception ex) {
            log_Error("validateLHDR() is Failed");
            throw new Exception("Exception in validateLHDR()");
        }
    }

    public ILiglPage validateGSuiteDST_LockWithSingleLegalHoldWithoutFilters(String Status) throws Exception {
        try {

            validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid("Status");
            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));
            log_Info("validateGSuiteDST_LockWithSingleLegalHoldWithoutFilters() started");

            for(int j= 0;j < listItem.size(); j++)
            {
                if(getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='PreservationDateRangeName']//span[@title='null']")).isDisplayed())
            {
                log_Pass("Preservation Daterange Column is displaying as Null as expected");
                Thread.sleep(2000);
            }
            else
            {
                log_Error("Preservation Daterange Column is not displaying as Null");
            }
            if(getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='PreservationKeyWordName']//span[@title='null']")).isDisplayed()){
                log_Pass("Preservation Keyword Column is displaying as Null as expected");
                Thread.sleep(2000);
            }
            else
            {
                log_Error("Preservation Keyword Column is not displaying as Null");
            }Thread.sleep(3000);}
            return new DMSummaryPage();
        } catch (Exception ex) {
            log_Error("validateLHDRInDataSummaryGrid() is Failed");
            throw new Exception("Exception in validateLHDRInDataSummaryGrid()");
        }
    }


}



