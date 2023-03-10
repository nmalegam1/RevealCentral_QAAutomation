package com.ligl.pages;

import com.google.common.base.Equivalence;
import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.administration.ManageDisplayContentPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.ArrayList;

public class MyHoldsPage extends LiglBaseSessionPage {


    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]")
    WebElement LHNAME;

    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement LHNameMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//button[@title='Acknowledgement Link']")
    WebElement AckLink;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]")
    WebElement CaseNameHeader;

    @FindBy(xpath = "//span[contains(text(),'Acknowledgement Link')]")
    WebElement AcklinkHeader;

    @FindBy(xpath = "//span[contains(text(),'Acknowledgement Mode')]")
    WebElement AckModeHeader;

    @FindBy(xpath = "//button[contains(text(),'Acknowledge')]")
    WebElement AckButton;

    @FindBy(xpath = "//span[contains(text(),'Acknowledged')]")
    WebElement LHNStatus;

    @FindBy(xpath = "//button[@class='btn submitBtn record-edit disabledAnchorTag iconic-btn ng-star-inserted']")
    WebElement AckLinkDisabled;

    @FindBy(xpath = "//span[contains(text(),'Application')]")
    WebElement AckMode;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement AckYesBtn;
    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]/ancestor::div/span[@ref='eMenu']")
    WebElement LHNNameHeader;
    @FindBy(id = "btn-refresh")
    WebElement RefreshBtn;
    @FindBy(xpath = "//span[contains(text(),'Case Name')]/ancestor::div/span[@ref='eMenu']")
    WebElement CaseNamHeader;
    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CaseNameFilter;
    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CaseSearchBar;
    @FindBy(xpath = "//div[@col-id='AcknowledgementDrivenType' and @role='gridcell']//span[@class='ellipsisAgGrid']")
    WebElement ACKMode;
    public ILiglPage searchRequiredLegalHoldName(String LHname) throws Exception {
        try {



            log_Info("searchRequiredLegalHoldName() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(LHNAME).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            log_Info("Click On Legal Hold Name Menu");
            LHNameMenu.click();
            Thread.sleep(5000);
            log_Info("Clicked On Legal Hold Name Menu");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            log_Info("Enter LH name In The Search Bar");
            Searchbar.sendKeys(LHname);
            Thread.sleep(5000);
            log_Info("Entered LH name In The Search Bar");
            return new MyHoldsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredLegalHoldName() Failed", ex);

        }}


    public ILiglPage myHoldsAcknowledgeLink() throws Exception {
        try {
            log_Info("myHoldsAcknowledgeLink() Started");
            Thread.sleep(5000);
            CaseNameHeader.click();
            for (int i = 0; i < 10; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(AckLink);
            AckLink.click();
            Thread.sleep(5000);
            log_Info("myHoldsAcknowledgeLink clicked & Acknowledgement Page opened in next tab");
            log_Info("Switching control from tab1 to tab2");
            ArrayList<String> tabs2 = new ArrayList<String>(getCurrentDriver().getWindowHandles());
            getCurrentDriver().switchTo().window(tabs2.get(1));
            log_Info("Control shifted to Tab2");
            waitForPageToLoad();
            WebElement element = getCurrentDriver().findElement(By.xpath("//input[@id='agree-input']"));
            Actions actions = new Actions(getCurrentDriver());
            actions.moveToElement(element).click().build().perform();
            log_Info("Agree...Checkbox checked");
            Thread.sleep(5000);
            AckButton.click();
            log_Info("Acknowledge button clicked successfully");
            Thread.sleep(2000);
            AckYesBtn.click();
            Thread.sleep(5000);
            getCurrentDriver().close();
            log_Info("Switching control from tab2 to tab1");
            ArrayList<String> tabs1 = new ArrayList<String>(getCurrentDriver().getWindowHandles());
            getCurrentDriver().switchTo().window(tabs1.get(0));
            log_Info("Control shifted to Tab1");
            return new MyHoldsPage();

        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("myHoldsAcknowledgeLink() Failed", ex);

        }
    }

    public ILiglPage clickOnRefreshButton() throws Exception
    {
        try {
            log_Info("clickOnRefreshButton() Started");
            log_Info("click On Refresh Button");
            Thread.sleep(10000);
            RefreshBtn.click();
            Thread.sleep(5000);
            log_Info("clicked On Refresh Button");
            return new MyHoldsPage();
        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("clickOnRefreshButton() Failed", ex);    }}
    public ILiglPage firstSearch() throws InterruptedException {
        log_Info("firstSearch() Started");
        Thread.sleep(3000);
        CaseNamHeader.click();
        CaseNameFilter.click();
        CaseSearchBar.clear();
        CaseSearchBar.sendKeys("");
        return this;
    }

    public ILiglPage checkAckModeColumn(String CaseName,String LHN,String Ackmode)throws Exception{
        try{
            log_Info("checkAckModeColumn() Started");
            RefreshBtn.click();
            caseNameSearch("QA_Feb_06");
            Thread.sleep(5000);
            RefreshBtn.click();
            Thread.sleep(3000);
            legalHoldSearch(LHN);
            Thread.sleep(3000);
            RefreshBtn.click();
            Thread.sleep(3000);
            Actions ac=new Actions(getCurrentDriver());
            getCurrentDriver().findElement(By.xpath("//div[@col-id='Comments']//span[@class='ellipsisAgGrid']")).click();

            for (int i = 0; i < 6; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            String acm1=ACKMode.getText();
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//div[@col-id='Comments']//span[@class='ellipsisAgGrid']")).click();

            for (int i = 0; i < 6; i++) {
                ac.sendKeys(Keys.ARROW_LEFT).perform();
            }
            Assert.assertEquals(acm1,Ackmode);

            log_Pass("Acknowledge Mode is Updated Correctly");

            return new MyHoldsPage();
        }catch (Exception ex){
            log_Error("checkAckModeColumn() Failed");
            throw new Exception("Exception in checkAckModeColumn()",ex);
        }
    }

    public ILiglPage caseNameSearch(String Case)throws Exception{
        try {
            log_Info("caseNameSearch() Started");
            CaseNamHeader.click();

            CaseSearchBar.clear();
            CaseSearchBar.sendKeys(Case);

            return new MyHoldsPage();
        }catch (Exception ex){
            log_Error("caseNameSearch() Failed");
            throw new Exception("Exception in caseNameSearch()",ex);
        }
    }
    public ILiglPage legalHoldSearch(String LHN)throws Exception{
        try{
            log_Info("legalHoldSearch() Started");
            LHNNameHeader.click();
            //CaseNameFilter.click();
            CaseSearchBar.clear();
            CaseSearchBar.sendKeys(LHN);
            return new MyHoldsPage();
        }catch(Exception ex){
            log_Error("legalHoldSearch() Failed");
            throw new Exception("Exception in legalHoldSearch()",ex);
        }
    }

    public ILiglPage validateMyHoldsGridData() throws Exception {
        try {
            log_Info("validateMyHoldsGridData() Started");

            log_Info("Acknowledge link disabled validation started");
            boolean b= AckLinkDisabled.isEnabled();
            System.out.println(b);
            Thread.sleep(5000);
            Assert.assertEquals(false, b);
            log_Info("Acknowledgement link is displaying as disabled in My holds grid");

            log_Info("Acknowledgement Mode column data validation started");
            AcklinkHeader.click();
            for (int i = 0; i < 1; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(AckMode);
            AckMode.isDisplayed();
            log_Info("Acknowledgement mode is displaying as Application in My holds grid");

            Thread.sleep(5000);
            log_Info("LHN Status column data validation started");
            AckModeHeader.click();
            for (int i = 0; i > 7; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(LHNStatus);
            Thread.sleep(5000);
            LHNStatus.isDisplayed();
            log_Info("LHN Status is displaying as Acknowledged in My holds grid");
            Thread.sleep(5000);
            return new MyHoldsPage();

        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("validateMyHoldsGridData() Failed", ex);

        }
    }



}
