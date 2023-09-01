package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.casemanagement.CaseOtherPartyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class ApprovalPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//span[@title='QA_Nov24v5 - LHNLIGLv']")
    WebElement LegalHoldName;

    @FindBy(id = "appr-approve-btn")
    WebElement ApproveBtn;

    @FindBy(id = "send-approval-btn")
    WebElement SaveBtn;

    @FindBy(id = "appr-reject-btn")
    WebElement RejectBtn;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Project Details')]")
    WebElement ProjectDetails;

    @FindBy(xpath = "//mat-panel-title[contains(text(),' Legal Hold Details ')]")
    WebElement CaseLHDetails;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Legal Hold Details')]")
    WebElement LegalHoldDetailsAccordion;

    @FindBy(xpath = "//mat-panel-title[contains(text(),' Approval History ')]")
    WebElement ApprovalHistoryAccordion;

    @FindBy(xpath = "//a[contains(text(),'View')]")
    WebElement ViewBtn;

    @FindBy(xpath = "//button[contains(text(),'Close')]")
    WebElement CloseBtn;

    @FindBy(xpath = "//div[@col-id='EntityStatusName']//span[contains(text(),'Approved')]")
    WebElement BatchApprovedStatus;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement FilterIcon;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@ref='eLabel']/span")
    WebElement PartyHeader;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement MenuIcon;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement SearchBarIcon;

    @FindBy(xpath = "//div[@role='region']//section[@id='approvalStatus']//span[contains(text(),'Approved')]")
    WebElement ProjectDetailsApproved;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Data Sources')]")
    WebElement DataSourcesAcc;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Custodians')]")
    WebElement CustodianAcc;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Date Ranges')]")
    WebElement DateRangesAcc;

    @FindBy(xpath = "//mat-panel-title[contains(text(),'Keywords')]")
    WebElement KeywordsAcc;

    @FindBy(xpath = "//form[@id='approvalCustodianForm']//section[@id='approvalstatus-party-name']//p")
    WebElement CustodianApprovalStatus;

    @FindBy(xpath = "//form[@id='approvalDateRangesForm']//section[@id='common-approval-status-start-date']//p")
    WebElement DataSourcesApprovalStatus;

    @FindBy(xpath = "//form[@id='row-approvalDateRangesForm']//section[@id='common-approval-status-end-date']//p")
    WebElement DateRangesApprovalStatus;

    @FindBy(xpath = "//form[@id='keywordsForm']//td[5]//p")
    WebElement KeywordsApprovalStatus;




    public ILiglPage approvingLegalHold() throws InterruptedException {

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
            Thread.sleep(3000);
            getDriver().waitForelementToBeClickable(ApproveBtn);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
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
            throw new Exception("approvingRejectedCase() Failed ", ex);
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

    public ILiglPage clickOnPendingLHNameInAppPage(String CaseLHname) throws Exception {
        try {
            log_Info("Check Pending Approval Legal hold name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseLHname + "')]")).click();
            Thread.sleep(15000);
            log_Info("Pending Approval Legal hold name checked");
            return new ApprovalPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnPendingLHNameInAppPage() Failed", ex);
        }
    }


        public ILiglPage validateCaseLHDetailsInAppPage(String OnlyLHname) throws Exception {
            try {
                Thread.sleep(5000);
                log_Info("Click on Case Details Accordion");
                getDriver().waitForelementToBeClickable(ProjectDetails);
                waitForPageToLoad();
                Thread.sleep(5000);
                ProjectDetails.click();
                getSession().log_Pass("Clicked on Case Details Accordion");
                Thread.sleep(5000);
                log_Info("Click on Legal hold Details Accordion");
                getDriver().waitForelementToBeClickable(CaseLHDetails);
                waitForPageToLoad();
                ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
                Thread.sleep(5000);
                CaseLHDetails.click();
                getSession().log_Pass("Clicked on Legal hold Details Accordion");
                Thread.sleep(5000);

                log_Info("Click on Legal hold Name in LH Details Accordion");
                boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OnlyLHname+"')]")).isDisplayed();
                System.out.println(a1);
                Thread.sleep(5000);
                Assert.assertEquals(true, a1);

                log_Info("Clicked on Legal hold Name in LH Details Accordion");

                return  new ApprovalPage();
            }
            catch (Exception | Error ex)
            {
                log_Error(ex.getMessage());
                throw new Exception("validateCaseLHDetailsInAppPage() Failed", ex);
            }
    }



    public ILiglPage clickOnApproveBtnInAppPage() throws Exception {
        try {
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
            Thread.sleep(7000);
            getSession().log_Pass("Clicked on Save Button");

            return  new ApprovalPage();
        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("clickOnApproveBtnInAppPage() Failed", ex);
        }
    }

    public ILiglPage validateBatchForProjectApprovalStatus() throws Exception {

        try {
            log_Info("validateBatchForProjectApprovalStatus() Started");
            Thread.sleep(5000);
            if(BatchApprovedStatus.isDisplayed()){
                log_Pass("The Assigned Project Batch Is In Approved State");
            }
            else {
                throw new Exception("Assigned Project Batch Is Not In Approved State");
            }

            return  new ApprovalPage();
        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("validateBatchForProjectApprovalStatus() Failed", ex);
        }
    }

    public ILiglPage searchRequiredProjectBatch(String BatchName) throws Exception {

        try {


            log_Info("searchRequiredProjectBatch() Started");
            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(PartyHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(2000);

            log_Info("click on Party menu icon");
            MenuIcon.click();
            log_Info("clicked on Party menu icon");
            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(2000);
            FilterIcon.click();
            log_Info("Filter Clicked");
            getDriver().waitForelementToBeClickable(SearchBarIcon);
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(BatchName);
            Thread.sleep(20000);

            validateBatchForProjectApprovalStatus();

            getCurrentDriver().findElement(By.xpath("//div[@col-id='Name']//span[@title='"+BatchName+"']")).click();

            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredProjectBatch() Failed", ex);

        }
    }

    public ILiglPage validateProjectDetailsAreInApprovedStateInApprovalPage() throws Exception {

        try {


            log_Info("validateProjectDetailsAreInApprovedStateInApprovalPage() Started");
            Thread.sleep(2000);

            if (ProjectDetailsApproved.isDisplayed()){
                log_Pass("Project Is In Approved State In Approval Page Details");
            }
            else {
                throw new Exception("Project Is In Not Approved State");
            }
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProjectDetailsAreInApprovedStateInApprovalPage() Failed", ex);

        }
    }

    public ILiglPage validateProjectCustodiansAreInApprovedState() throws Exception {

        try {


            log_Info("validateProjectCustodiansAreInApprovedState() Started");
            Thread.sleep(2000);

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ApproveBtn);
            log_Info("Click on Custodian Accordian Grid");
            getDriver().waitForelementToBeClickable(CustodianAcc);
            CustodianAcc.click();
            Thread.sleep(2000);
            log_Pass("Clicked On Custodian Accordian Grid");

            if (CustodianApprovalStatus.isDisplayed()){
                log_Pass("Project Custodians Are In Approved State In Approval Page Details");
            }
            else {
                throw new Exception("Project Custodians Are In Not Approved State");
            }
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProjectCustodiansAreInApprovedState() Failed", ex);

        }
    }

    public ILiglPage validateProjectDataSourcesAreInApprovedState() throws Exception {

        try {


            log_Info("validateProjectDataSourcesAreInApprovedState() Started");
            Thread.sleep(2000);

            log_Info("Click on DataSources Accordian Grid");
            getDriver().waitForelementToBeClickable(DataSourcesAcc);
            DataSourcesAcc.click();
            Thread.sleep(2000);
            log_Pass("Clicked On DataSources Accordian Grid");

            if (DataSourcesApprovalStatus.isDisplayed()){
                log_Pass("Project DataSources Is In Approved State In Approval Page Details");
            }
            else {
                throw new Exception("Project DataSources Is In Not Approved State");
            }
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProjectDataSourcesAreInApprovedState() Failed", ex);

        }
    }

    public ILiglPage validateProjectDateRangessAreInApprovedState() throws Exception {

        try {


            log_Info("validateProjectDateRangessAreInApprovedState() Started");
            Thread.sleep(2000);

            log_Info("Click on DateRanges Accordian Grid");
            getDriver().waitForelementToBeClickable(DateRangesAcc);
            DateRangesAcc.click();
            Thread.sleep(2000);
            log_Pass("Clicked On DateRanges Accordian Grid");

            if (DateRangesApprovalStatus.isDisplayed()){
                log_Pass("Project DateRanges Is In Approved State In Approval Page Details");
            }
            else {
                throw new Exception("Project DateRanges Is In Not Approved State");
            }
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProjectDateRangessAreInApprovedState() Failed", ex);

        }
    }

    public ILiglPage validateProjectKeywordsAreInApprovedState() throws Exception {

        try {


            log_Info("validateProjectKeywordsAreInApprovedState() Started");
            Thread.sleep(2000);

            log_Info("Click on Keywords Accordian Grid");
            getDriver().waitForelementToBeClickable(DataSourcesAcc);
            KeywordsAcc.click();
            Thread.sleep(2000);
            log_Pass("Clicked On Keywords Accordian Grid");

            if (KeywordsApprovalStatus.isDisplayed()){
                log_Pass("Project Keywords Is In Approved State In Approval Page Details");
            }
            else {
                throw new Exception("Project Keywords Is In Not Approved State");
            }
            return new ApprovalPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProjectKeywordsAreInApprovedState() Failed", ex);

        }
    }

}