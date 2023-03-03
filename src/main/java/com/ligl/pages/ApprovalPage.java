package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ApprovalPage extends LiglBaseSessionPage {

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement ApproveNameMenu;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@ref='eLabel']")
    WebElement ApproveNameHeader;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement ApproveSearchFilter;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement ApproveSearchBar;

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

    @FindBy(id = "appr-reject-btn")
    WebElement RejectBtn;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Legal Hold Details')]")
    WebElement LegalHoldDetailsAccordion;

    @FindBy(xpath = "//mat-panel-title[contains(text(),' Approval History ')]")
    WebElement ApprovalHistoryAccordion;

    @FindBy(xpath = "//a[contains(text(),'View')]")
    WebElement ViewBtn;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement CloseBtn;


    // Approving The Legal Hold

    public ILiglPage approvingLegalHold() throws Exception {

        try {

        log_Info("Click on LegalHold Name");
        getDriver().waitForelementToBeClickable(LegalHoldName);
        LegalHoldName.click();
        Thread.sleep(8000);
        getSession().log_Pass("Clicked on Legal Hold Name");
        waitForPageToLoad();


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

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("approvingLegalHold() Failed ", ex);
        }
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
            getDriver().waitForAngularRequestsToComplete();
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", RejectBtn);
            getDriver().waitForelementToBeClickable(ApproveBtn);
            ApproveBtn.click();
            getSession().log_Pass("Clicked on Approve Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            waitForPageToLoad();
            Thread.sleep(5000);
            SaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Save Button");

            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("approvingCaseSingleApprover() Failed ", ex);
        }
    }

    public ILiglPage rejectingTheCase(String CaseNameApprove) throws Exception {

        try {


            log_Info("Click On Case Name");
            Thread.sleep(8000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + CaseNameApprove + "']")).click();
            getSession().log_Pass("Clicked on Case Name");


            log_Info("Click on Reject Button");
            waitForPageToLoad();
            getDriver().waitForelementToBeClickable(RejectBtn);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
            RejectBtn.click();
            getSession().log_Pass("Clicked on Reject Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            waitForPageToLoad();
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("rejectingTheCase() Failed ", ex);
        }
    }

    public ILiglPage checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid(String CaseNameApprove,String keywords) throws Exception {

        try {


            log_Info("Click On Case Name");
            Thread.sleep(8000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + CaseNameApprove + "']")).click();
            Thread.sleep(8000);
            getSession().log_Pass("Clicked on Case Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApprovalHistoryAccordion);

            log_Info("Validate The Legal Hold Details And Approval History Accordion");
            Thread.sleep(5000);
            boolean v1 = LegalHoldDetailsAccordion.isDisplayed();
            Thread.sleep(5000);
            boolean v2 = ApprovalHistoryAccordion.isDisplayed();
            Thread.sleep(5000);

            System.out.println(v1);
            Thread.sleep(5000);
            System.out.println(v2);
            Thread.sleep(5000);

            Assert.assertEquals(true, v1);
            Assert.assertEquals(true, v2);


            log_Info("Validated The Legal Hold Details And Approval History Accordion");

            log_Info("Click On Legal Hold Details");
            getDriver().waitForelementToBeClickable(LegalHoldDetailsAccordion);
            waitForPageToLoad();
            LegalHoldDetailsAccordion.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Save Button");


            log_Info("Click On View Button");
            getDriver().waitForelementToBeClickable(ViewBtn);
            waitForPageToLoad();
            ViewBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on View Button");

            log_Info("Validate The Keywords Added While Creating The LH");
            Thread.sleep(5000);
            boolean v5 = getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+keywords+"')]")).isDisplayed();
            System.out.println(v5);
            Thread.sleep(5000);

            Assert.assertEquals(true, v5);
            Thread.sleep(5000);

            log_Info("Validate The Keywords Added While Creating The LH");

            log_Info("Click On Close Button");
            getDriver().waitForelementToBeClickable(CloseBtn);
            waitForPageToLoad();
            CloseBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Close Button");


            log_Info("Click on Approve Button");
            getDriver().waitForAngularRequestsToComplete();
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", RejectBtn);
            getDriver().waitForelementToBeClickable(ApproveBtn);
            ApproveBtn.click();
            getSession().log_Pass("Clicked on Approve Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            waitForPageToLoad();
            Thread.sleep(5000);
            SaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Save Button");

            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid() Failed ", ex);
        }
    }

}