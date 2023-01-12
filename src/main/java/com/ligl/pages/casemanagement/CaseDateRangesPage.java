package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseDateRangesPage extends LiglBaseSessionPage {

    @FindBy(id = "add-date-range-btn")
    WebElement AddDateRange;

    @FindBy(xpath = "//*[@id='description']")
    WebElement Description;

    @FindBy(xpath = "//*[@id='startDate']")
    WebElement StartDate;

    @FindBy(xpath = "//*[@id='endDate']")
    WebElement EndDate;

    @FindBy(id="save-btn")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='DR1']")
    WebElement DR1;

    @FindBy(xpath = "//span[@title='DR2']")
    WebElement DR2;

    // 12. Adding Date Ranges To The Case

    public ILiglPage addDateRanges(String StartDate1 ,String EndDate1,String DescriptionBox) throws Exception {

        try {

            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", AddDateRange);

            log_Info("Click on AddDateRanges Btn");
            getDriver().waitForelementToBeClickable(AddDateRange);
            Thread.sleep(5000);
            AddDateRange.click();
            getSession().log_Pass("Clicked on AddDateRanges Btn");

            log_Info("Click on Start Date Text Box");
            getDriver().waitForelementToBeClickable(StartDate);
            Thread.sleep(5000);
            StartDate.sendKeys(StartDate1);
            getSession().log_Pass("Clicked on Start Date Text Box");

            log_Info("Click on End Date Text Box");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(EndDate1);
            getSession().log_Pass("Clicked on End Date Text Box");


            log_Info("Click on Description Text Box");
            getDriver().waitForelementToBeClickable(Description);
            Thread.sleep(5000);
            Description.sendKeys(DescriptionBox);
            getSession().log_Pass("Click on Description Text Box");


            log_Info("Click on Save Btn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Btn");
            return new CaseDateRangesPage();

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addDateRanges() Failed", ex);
        }

    }
    //12. Validating The Date Ranges Added The Case In The Date Range Grid
    public ILiglPage validatingDateRanges() throws Exception {

        try {

            log_Info("Check The Name Of Date Ranges As DR1 And DR2");
            boolean a1 = DR1.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            boolean b1 = DR2.isDisplayed();
            Thread.sleep(3000);
            System.out.println(b1);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, b1);
            return new CaseDateRangesPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingDateRanges() Failed",ex);
        }
    }

    public ILiglPage enableAndDisableDateRanges(String Status1) throws Exception{

        try {


            log_Info("Click On Enable Button In The Grid");
            Thread.sleep(5000);

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            Actions ac = new Actions(getCurrentDriver());

            for (int i = 0; i < 7; i++) {


                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");

            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Status1+"')]")).click();
            getSession().log_Pass("Clicked On Enable Button In The Grid");
            return new CaseDateRangesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("enableAndDisableDateRanges() Failed", ex);
        }
    }

    public ILiglPage validateEnableAndDisableDateRanges(String Status2) throws Exception{

        try {


            log_Info("Check The Status Of DateRanges Is Enable/Disable");

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            Actions ac = new Actions(getCurrentDriver());

            for (int i = 0; i < 7; i++) {


                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");

            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Status2+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseDateRangesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateEnableAndDisableDateRanges() Failed", ex);
        }
    }
}
