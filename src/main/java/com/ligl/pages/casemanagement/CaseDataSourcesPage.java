package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CaseDataSourcesPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//div[text()='Google Drive']//../..//div[@class='sourceChkbxDiv']")
    WebElement GoogleDrive;

    @FindBy(xpath = "//div[text()='Gmail']//../..//div[@class='sourceChkbxDiv']")
    WebElement Gmail;

    @FindBy(xpath = "//button[contains(text(),Save) and @type='submit']")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='Case Management']")
    WebElement CaseManage;

    @FindBy(xpath = "//h1[contains(text(),'Select Data Source(s)')]")
    WebElement DSHeading;
    @FindBy(id = "On-Prem-button")
    WebElement OnpremDS;


    public ILiglPage addDataSources() throws Exception {

        try {

            log_Info("Click on Google Drive checkbox");
            getDriver().waitForelementToBeClickable(GoogleDrive);
            Thread.sleep(3000);
            GoogleDrive.click();
            log_Info("Clicked on Google Drive checkbox");


            log_Info("Click on Gmail checkbox");
            getDriver().waitForelementToBeClickable(Gmail);
            Thread.sleep(3000);
            Gmail.click();
            log_Info("Clicked on Gmail checkbox");

            JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
            Thread.sleep(3000);
            js.executeScript("window.scroll(0,1000)");


            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveBtn.click();
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DSHeading);
            return new CaseDataSourcesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addDataSources() Failed", ex);
        }
    }

    public ILiglPage addOnpremDataSource(String DataSource)throws Exception{
        try{
            log_Info("addOnpremDataSource() Started");
            OnpremDS.click();
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Data Source is selected");
            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            return new CaseDataSourcesPage();
        }catch (Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("addOnpremDataSource() Failed", ex);
        }
    }

    public ILiglPage addDataSource(String DataSource) throws Exception {

        try {
            log_Info("addDataSources() Started");
            log_Info("Click on checkbox");
            //getDriver().waitForelementToBeClickable(Gmail);
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on checkbox");
            Thread.sleep(2000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DSHeading);

            return new CaseDataSourcesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addDataSources() Failed", ex);
        }
    }

    // Adding DataSource To The Selected Custodian - ReUsable Method

    public ILiglPage addingDataSource(String DataSource) throws Exception {

        try {

            log_Info("addingDataSource() Started");
            log_Info("Click on checkbox");
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on checkbox");
            Thread.sleep(2000);
            return new CaseDataSourcesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addingDataSource() Failed", ex);
        }
    }

    public ILiglPage clickOnSaveButton() throws Exception {

        try {

            log_Info("clickOnSaveButton() Started");
            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            Thread.sleep(2000);
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DSHeading);
            return new CaseDataSourcesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnSaveButton() Failed", ex);
        }

    }
}
