package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ApprovalPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//*[@id='content']/article/div[2]/div[2]/ag-grid-angular/div/div[2]/div[2]/div[1]/div[2]/div/div/div[1]/div[3]")
    WebElement Name;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement Menu;

    @FindBy(xpath = "//*[@id='content']/article/div[2]/div[2]/ag-grid-angular/div/div[6]/div/div[1]/span[2]")
    WebElement Filter;

    @FindBy(id = "ag-1912-input")
    WebElement SearchBar;

    @FindBy(xpath = "//span[@title='QA_Nov24v5 - LHNLIGLv']")
    WebElement LegalHoldName;

    @FindBy(id = "appr-approve-btn")
    WebElement ApproveBtn;

    @FindBy(id = "send-approval-btn")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='QA_Jan3v4-Batch1']")
    WebElement CaseName;


    // Approving The Legal Hold

    public ILiglPage approvingLegalHold() throws InterruptedException {

        /*getDriver().waitForelementToBeClickable(Name);
        Actions ac = new Actions(getCurrentDriver());
        ac.moveToElement(Name).perform();

        Menu.click();

        log_Info("Click on Filter Button");
        getDriver().waitForelementToBeClickable(Filter);
        Filter.click();
        getSession().log_Pass("Filter Button clicked");

        log_Info("Click on Search Bar And SendKeys");
        getDriver().waitForelementToBeClickable(SearchBar);
        SearchBar.sendKeys("QA_Nov24v5 - LHNNEW");
        getSession().log_Pass("Clicked on Search Bar And SendKeys");*/

        log_Info("Click on LegalHold Name");
        getDriver().waitForelementToBeClickable(LegalHoldName);
        LegalHoldName.click();
        Thread.sleep(8000);
        getSession().log_Pass("Clicked on Legal Hold Name");
        waitForPageToLoad();

        /*JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
        js.executeScript("window.scroll(0,1000)");*/
        ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);

        log_Info("Click on Approve Button");
        getDriver().waitForelementToBeClickable(ApproveBtn);
        waitForPageToLoad();
        ApproveBtn.click();
        getSession().log_Pass("Clicked on Approve Button");

        log_Info("Click on Save Button");
        getDriver().waitForelementToBeClickable(SaveBtn);
        waitForPageToLoad();
        SaveBtn.click();
        getSession().log_Pass("Clicked on Save Button");
        return new ApprovalPage();


    }

    public ILiglPage approvingRejectedCase(String CaseNameApprove) throws Exception {

        try {


            log_Info("Click On Case Name");
            Thread.sleep(8000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + CaseNameApprove + "']")).click();
            getSession().log_Pass("Clicked on Case Name");

            log_Info("Click on Approve Button");
            waitForPageToLoad();
            getDriver().waitForelementToBeClickable(ApproveBtn);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
            ApproveBtn.click();
            getSession().log_Pass("Clicked on Approve Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            waitForPageToLoad();
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("approvingRejectedCase() Failed ", ex);
        }
    }

    // Approving The Case Through Single Approver

    public ILiglPage approvingCaseSingleApprover(String CaseNameApprove) throws Exception {

        try {


            log_Info("Click On Case Name");
            Thread.sleep(8000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + CaseNameApprove + "']")).click();
            getSession().log_Pass("Clicked on Case Name");

            log_Info("Click on Approve Button");
            waitForPageToLoad();
            getDriver().waitForelementToBeClickable(ApproveBtn);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
            ApproveBtn.click();
            getSession().log_Pass("Clicked on Approve Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            waitForPageToLoad();
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("approvingRejectedCase() Failed ", ex);
        }
    }

}