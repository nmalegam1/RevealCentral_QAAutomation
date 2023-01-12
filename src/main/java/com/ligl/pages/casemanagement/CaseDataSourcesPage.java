package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CaseDataSourcesPage extends LiglBaseSessionPage
{

    @FindBy (xpath = "//div[text()='Google Drive']//../..//div[@class='sourceChkbxDiv']")
    WebElement GoogleDrive;

    @FindBy (xpath = "//div[text()='Gmail']//../..//div[@class='sourceChkbxDiv']")
    WebElement Gmail;

    @FindBy (id="save-btn")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='Case Management']")
    WebElement CaseManage;

    @FindBy(xpath = "//h1[contains(text(),'Select Data Source(s)')]")
    WebElement DSHeading;




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


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addDataSources() Failed",ex);
        }
    }

}
