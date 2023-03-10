package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TakesScreenshot;
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


    // Validate And Wait For The Records To Complete Collection Process

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


            for (int i = 1; i <= 120; i++) {

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

            if (z==listItem.size()) {
                getSession().takeScreenShot();
                return new DMSummaryPage();

            }

            return new DMCollectionsPage();

        } catch (Exception ex) {
            log_Error("validateAndWaitForRecordsToCompleteCollection() Failed");
            throw new Exception("validateAndWaitForRecordsToCompleteCollection()", ex);
        }
    }
}


