package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class DMCollectionsPage extends LiglBaseSessionPage {

    @FindBy(id = "add-datasource")
    WebElement AddDataSources;

    @FindBy(id = "dsi-custodian")
    WebElement SelectCustodianDrpDwn;

    @FindBy(id = "CloseFilebtn")
    WebElement CloseBtn;

    @FindBy(xpath = "//span[contains(text(),'Custodian name is required')]")
    WebElement CNIR;

    @FindBy(xpath = "//span[contains(text(),'Please select')]")
    WebElement PleaseSelect;


             // checking The custodian In The Data Management

    public ILiglPage checkDSIForCustodians(String Employee1) throws Exception {

        try {

            log_Info("Click on Add Data Sources Button");
            getDriver().waitForelementToBeClickable(AddDataSources);
            Thread.sleep(5000);
            AddDataSources.click();
            log_Info("Clicked on Add Data Sources Button");

            log_Info("Click On Select Custodian Drop Down");
            getDriver().waitForelementToBeClickable(SelectCustodianDrpDwn);
            Thread.sleep(5000);
            SelectCustodianDrpDwn.click();
            Thread.sleep(5000);
            PleaseSelect.click();
            log_Info("Clicked On Select Custodian Drop Down");

            log_Info("Check The Message Displayed Or Not");
            boolean a1 = CNIR.isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("Observed The Message Displayed");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", CloseBtn);

            log_Info("Click on Close Button");
            getDriver().waitForelementToBeClickable(CloseBtn);
            Thread.sleep(5000);
            CloseBtn.click();
            log_Info("Clicked on Close Button");
            return new DMCollectionsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkDSIForCustodians() Failed",ex);
        }
    }

    public ILiglPage validateDSIForCustodians(String Employee1) throws Exception{
        try {

            log_Info("Click on Add Data Sources Button");
            getDriver().waitForelementToBeClickable(AddDataSources);
            Thread.sleep(5000);
            AddDataSources.click();
            log_Info("Clicked on Add Data Sources Button");

            log_Info("Click On Select Custodian Drop Down");
            getDriver().waitForelementToBeClickable(SelectCustodianDrpDwn);
            Thread.sleep(5000);
            SelectCustodianDrpDwn.click();
            Thread.sleep(8000);
            log_Info("Clicked On Select Custodian Drop Down");

            log_Info("Check The Message Displayed Or Not");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Employee1+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("Observed The Message Displayed");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", CloseBtn);


            log_Info("Click on Close Button");
            getDriver().waitForelementToBeClickable(CloseBtn);
            Thread.sleep(5000);
            CloseBtn.click();
            log_Info("Clicked on Close Button");
            return new DMCollectionsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateDSIForCustodians() Failed",ex);
        }
    }

}
