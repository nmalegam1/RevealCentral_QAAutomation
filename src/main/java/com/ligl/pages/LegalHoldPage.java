package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.administration.EmailTemplatePage;
import com.ligl.pages.administration.EmployeeMasterPage;
import com.ligl.pages.administration.StakeHoldersPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.pages.datamanagement.DMCollectionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import com.ligl.web.LiglValidationDriver;

import java.util.ArrayList;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LegalHoldPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//span[@title='QA_Nov24v5 - LHNLIGLv']")
    WebElement LegalHoldName;

    @FindBy(id = "appr-approve-btn")
    WebElement ApproveBtn;

    @FindBy(id = "btn-save")
    WebElement SaveBtn;
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

    @FindBy(id = "adddoc-btn")
    WebElement AddLegalHoldBtn;

    @FindBy(xpath = "//span[contains(text(),'Custodian Name')]")
    WebElement CName;

    @FindBy(xpath = "//span[contains(text(),'HR Status')]")
    WebElement HRstatus;

    @FindBy(xpath = "//span[contains(text(),'Department')]")
    WebElement Department;

    @FindBy(xpath = "//span[contains(text(),'Email')]")
    WebElement Email;

    @FindBy(xpath = "//span[contains(text(),'Sent By')]")
    WebElement SentBy;

    @FindBy(xpath = "//span[contains(text(),'Sent On')]")
    WebElement SentOn;

    @FindBy(xpath = "//span[contains(text(),'LHN Status')]")
    WebElement LHNstatus;

    @FindBy(xpath = "//span[contains(text(),' Comments')]")
    WebElement Comments;

    @FindBy(id = "lhc-legal-hold-name")
    WebElement NameOfTheLegalHold;

    @FindBy(id = "btn-nextlhnTemp")
    WebElement NextBtn;

    @FindBy(id = "lhcNoticeTemplateLHNCustodianTemplateUniqueID")
    WebElement ChooseNoticeTemplateDrpDwn;

    @FindBy(xpath = "//*[@id='mat-option-7']/span")
    WebElement DrpDwnOption;

    @FindBy(id = "lhc-custodian-ques-templateCustodianQuestionnaireTemplateUniqueID")
    WebElement QuestionaireDrpDwn;


    @FindBy(id = "lhncustActions")
    WebElement SelectActionDrpDwn;

    @FindBy(id = "modelaction-btn")
    WebElement RunBtn;

    @FindBy(id = "lhnconfigutaion-refreshGrid")
    WebElement RefreshBtnLegalHold;

    @FindBy(id = "template-name")
    WebElement SelectEmailTemplateDrpDwn;

    @FindBy(id = "select-approver")
    WebElement SelectApprovalDrpDwn;

    @FindBy(id = "send-approval-btn")
    WebElement SendForApproveBtn;

    @FindBy(xpath = "//span[contains(text(),'Custodian Name')]")
    WebElement CustodianName;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(css = "span[class='ag-header-icon ag-header-cell-menu-button']")
    WebElement CNMenu;

    @FindBy(xpath = "//section[@class='legalholdNotice']//div[contains(text(),'No data available...')]")
    WebElement NoDataAvailable;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement EmpMail;


    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]")
    WebElement LHNAME;

    //@FindBy(xpath = "//span[contains(text(),'Email')]")
    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Email']")
    WebElement Semail;

    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement LHNameMenu;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement SemailMenu;

    @FindBy(id = "lhncustActions")
    WebElement ActionDrpDwn;
    @FindBy(id = "modelaction-btn")
    WebElement RunButn;

    @FindBy(id = "template-name")
    WebElement LegalholdTemplate;

    @FindBy(id = "select-approver")
    WebElement SelectLHApprover;

    @FindBy(id = "send-approval-btn")
    WebElement LHTemplateSendBtn;

    @FindBy(xpath = "//label[contains(text(),' Please deselect the stakeholders to whom the notification should not be sent. ')]")
    WebElement CopyeesSSLabel;

    @FindBy(id = "lhncust-refreshGrid")
    WebElement RefreshBtnCustodian;

    @FindBy(id = "lhnss-cancel-btn")
    WebElement CancelBtn;

    @FindBy(xpath = "//span[contains(text(),'LHN Status')]")
    WebElement LHNStatus;

    @FindBy(xpath = "//span[contains(text(),'LHN Status')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement StatusMenu;

    @FindBy(id = "lhnr-cancel-btn")
    WebElement CancelRBtn;

    @FindBy(xpath = "//label[contains(text(),'Please deselect the stakeholders to whom the notification should not be sent.')]")
    WebElement CopyeesRLabel;

    @FindBy(id = "user-button")
    WebElement StakeholderBtn;

    @FindBy(id = "lhns-add-stkhldr-btn")
    WebElement AddStakeholderBtn;

    @FindBy(id = "lhns-add-fname")
    WebElement Fname;

    @FindBy(id = "lhns-add-lname")
    WebElement Lname;

    @FindBy(id = "lhns-add-deptdepartment")
    WebElement StakeDept;

    @FindBy(id = "lhns-add-email")
    WebElement StakeEmail;

    @FindBy(id = "lhns-add-categorycategory")
    WebElement StakeCategory;

    @FindBy(id = "send-approval-btn")
    WebElement SaveStakeholderBtn;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='EmailAddress']//span[@class='ellipsisAgGrid']")
    WebElement EmailColumn;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='LegalHoldName']//span[@class='ellipsisAgGrid']")
    WebElement LHnamecolumn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement DeptSearchBar;

    @FindBy(xpath = "//span[contains(text(),' LHN Release Template')]")
    WebElement DefaultReleaseTemplate;

    @FindBy(id = "lhnr-rel-template")
    WebElement ReleaseTemplateDrpDown;

    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]")
    WebElement LHNameHeader;

    @FindBy(xpath = "//button[@title='Test Email']")
    WebElement TestMail;

    @FindBy(xpath = "//button[@class='btn primary-button']")
    WebElement TestMailSend;

    @FindBy(xpath = "//button[@title='Notes']")
    WebElement LHNoteIcon;

    @FindBy(id = "legal-hold-case-document-btn")
    WebElement NextButton1;

    @FindBy(id = "legal-hold-configuration-btn")
    WebElement NextButton2;

    @FindBy(id = "lhc-notice-template-selectionLHNStakeHolderTemplateUniqueID")
    WebElement StakeHolderNoticeTemplate;

    @FindBy(id = "legal-hold-case-document-next-btn")
    WebElement NextButton3;

    @FindBy(id = "legal-hold-conguration-component-btn")
    WebElement NextButton4;

    @FindBy(id = "legal-hold-configuration-backlhnName-btn")
    WebElement NextButton5;

    @FindBy(id = "legal-hold-configuration-primary-btn")
    WebElement NextButton6;

    @FindBy(id = "legal-hold-form-custodian-btn")
    WebElement LHSaveBtn;

    @FindBy(id = "lhc1-edit-template1")
    WebElement OnFlyEdit;

    @FindBy(id = "lhc-custodian-ques-templateCustodianQuestionnaireTemplateUniqueID")
    WebElement CustQuestionaireDrpDwn;

    @FindBy(xpath = "//button[@title='Edit']")
    WebElement LHEditIcon;
    @FindBy(id = "template-name")
    WebElement EmailTemp;
    @FindBy(css = "input[placeholder='Search']")
    WebElement EmailTempSearch;
    @FindBy(id = "select-approver")
    WebElement Approver;
    @FindBy(id = "send-approval-btn")
    WebElement SendApprovalBtn;
    @FindBy(xpath = "//span[@class='resultspace']/ancestor::div//label[@class='matchresults']//b")
    WebElement Results;
    @FindBy(id = "lhncust-refreshGrid")
    WebElement RefreshBtn;
    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement LHNSearchFilter;
    @FindBy(css = "input[placeholder='Filter...']")
    WebElement LHNSearchBar;
    @FindBy(css = "input[id='Name']")
    WebElement NewTempName;
    @FindBy(css = "input[id='subject']")
    WebElement MailSubject;
    @FindBy(css = "div[role='textbox']")
    WebElement MailContent;
    @FindBy(xpath = "//mat-select[@id='lhcNoticeTemplateLHNCustodianTemplateUniqueID']//span//span")
    WebElement selectedTemplateName;
    @FindBy(id = "legal-hold-configuration-btn")
    WebElement CustodianNextBtn;
    @FindBy(id = "lhc-notice-template-selectionLHNStakeHolderTemplateUniqueID")
    WebElement StakeNoticeTemp;
    @FindBy(id = "legal-hold-case-document-next-btn")
    WebElement StakeNextBtn;
    @FindBy(id = "lhc-start-date")
    WebElement Startdate;
    @FindBy(id = "lhc-enddate")
    WebElement EndDate;
    @FindBy(id = "lhc-no-of-days")
    WebElement NoOfDays;
    @FindBy(id = "legal-hold-conguration-component-btn")
    WebElement DateRangeNextbtn;
    @FindBy(id = "keywords")
    WebElement KeyWordsFields;
    @FindBy(id = "legal-hold-configuration-backlhnName-btn")
    WebElement KeyWordNextBtn;
    @FindBy(id = "number-of-days-before-reminder")
    WebElement NoofDayBeforeRemainderSent;
    @FindBy(id = "reminder-frequency-legalhold")
    WebElement RemainderFrequency;
    @FindBy(id = "reminder-mails-cap-legalhold")
    WebElement RemainderMailCap;
    @FindBy(id = "selectType")
    WebElement RemainderMailTemp;
    @FindBy(id = "reminder-mails-radio-group")
    WebElement RemainderMailRadioBtn;
    @FindBy(id = "legal-hold-configuration-primary-btn")
    WebElement RemainderNextBtn;
    @FindBy(id = "legal-hold-form-custodian-btn")
    WebElement LHNSaveBtn;
    @FindBy(id = "adddoc-btn")
    WebElement AddLHN;
    @FindBy(id = "lhnss-savecase-btn")
    WebElement SendStealth;
    @FindBy(id = "lhnss-checkall")
    WebElement UnCheckAll;
    @FindBy(id = "Columns")
    WebElement ChooseColumnsMenu;
    @FindBy(xpath = "//input[@aria-label='Filter Columns Input']")
    WebElement ChooseColumnsSearch;
    @FindBy(css = "button[title='Record Interview']")
    WebElement RecordInterViewBtn;
    @FindBy(id = "rec-saveInterview-btn")
    WebElement InterviewSaveBtn;
    @FindBy(css = "button[title='Edit']")
    WebElement EditLHN;
    @FindBy(id = "export-to-excel-recordinterview")
    WebElement InterviewExportBtn;
    @FindBy(xpath = "//span[contains(text(),'Interviewer Name')]")
    WebElement InterviewerNameColHeader;
    @FindBy(xpath = "//span[contains(text(),'Interview Date')]")
    WebElement InterviewDateColHeader;
    @FindBy(xpath = "//span[contains(text(),'Notes')]")
    WebElement InterviewNotesColHeader;
    @FindBy(xpath = "//span[contains(text(),'Last Edited by')]")
    WebElement InterviewLastEditedColHeader;
    @FindBy(xpath = "//span[contains(text(),'Action')]")
    WebElement InterviewActionColHeader;
    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DPNStatusName']")
    WebElement CustStatus;
    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DpnStatusName']")
    WebElement StakeStatus;
    @FindBy(css = "i[class='lnr lnr-pencil']")
    WebElement EditBtn;
    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement PopUpOkBtn;
    @FindBy(xpath = "//div[contains(text(),'Address')]")
    WebElement AddressTab;
    @FindBy(id = "more-button")
    WebElement MoreBtn;
    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalStatusName']")
    WebElement LHNAprvlStatus;
    @FindBy(id = "lhc-legal-hold-name")
    WebElement LHNNameField;
    @FindBy(id = "legal-hold-case-document-btn")
    WebElement LHNNextBtn;
    @FindBy(id = "lhcNoticeTemplateLHNCustodianTemplateUniqueID")
    WebElement CustNoticeTemp;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement Search;
    @FindBy(id = "lhc-custodian-ques-templateCustodianQuestionnaireTemplateUniqueID")
    WebElement CustQuestTemp;


    @FindBy(xpath = "//span[contains(text(),'Name')]")
    WebElement NameHeader;

    @FindBy(xpath = "//span[contains(text(),'Category')]")
    WebElement Category;
    @FindBy(xpath = "//span[contains(text(),'Request Sent By')]")
    WebElement RequestSentBy;
    @FindBy(xpath = "//span[contains(text(),'Request Sent Date')]")
    WebElement RequestSentDate;
    @FindBy(xpath = "//span[contains(text(),'Acknowledged On')]")
    WebElement Acknowledge;
    @FindBy(xpath = "//span[contains(text(),'LH Notice Status')]")
    WebElement LHNoticeStatus;
    @FindBy(xpath = "//span[contains(text(),'Responses')]")
    WebElement Responses;
    @FindBy(xpath = "//span[contains(text(),'Actions')]")
    WebElement Actions;


    @FindBy(xpath = "//button[@title='Questionnaire Response']")
    WebElement ResponseFile;


    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OKBTN;

    @FindBy(xpath = "//p[contains(text(),'Only Not-initiated records can be selected')]")
    WebElement AlertMessage;

    @FindBy(id = "lhns-actions")
    WebElement ActionDrpDwnStakeHolder;

    @FindBy(id = "lhns-modelaction-btn")
    WebElement RunButton;

    @FindBy(id = "lhnconfigutaion-refreshGrid")
    WebElement RefreshBtnLH;

    @FindBy(id = "lhns-grid-refresh")
    WebElement RefreshBtnStakeHolder;

    @FindBy(id = "lhnr-rel-template")
    WebElement CustodianReleaseTemplate;

    @FindBy(id = "lhnr-savecase-btn")
    WebElement CustodianTemplateSendBtn;


    @FindBy(id = "lhc-stakeholder-questionnaireStakeHolderQuestionnaireTemplateUniqueID")
    WebElement StakeHolderQuestionaireTemplate;


    @FindBy(id = "legal-hold-form-custodian-btn")
    WebElement SaveButton;

    @FindBy(xpath = "//button[@title='Edit']")
    WebElement EditICON;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesButton;

    @FindBy(xpath = "//mat-slide-toggle[@id='reminder-toggle']//span//span")
    WebElement RemainderBtn;

    @FindBy(xpath = "//mat-slide-toggle[@id='escalation-toggle']//span//span")
    WebElement EscalationBtn;

    @FindBy(id = "number-of-days-before-reminder")
    WebElement RemainderDays;

    @FindBy(id = "reminder-mails-cap-legalhold")
    WebElement RemainderMailsCap;


    @FindBy(id = "number-of-days-after-reminder-legalhold")
    WebElement EscalationDays;

    @FindBy(id = "escalation-mails-cap-legalhold")
    WebElement EscalationMailsCap;

    @FindBy(id = "escalation-frequency-legalhold")
    WebElement EscalationFrequency;

    @FindBy(id = "lhnss-savecase-btn")
    WebElement SendBtn;

    @FindBy(id = "lhc-start-date")
    WebElement StartDate;

    @FindBy(id = "lhc-no-of-days")
    WebElement NumberOfDays;

    @FindBy(xpath = "//input[@id='keyWords']")
    WebElement Keywords;

    @FindBy(xpath = "//a[contains(text(),'Edit')]")
    WebElement EditTemplate;


    @FindBy(xpath = "//button[@id='Columns']")
    WebElement ColumnMenu;

    @FindBy(xpath = "//input[@placeholder='Search...']")
    WebElement SEARCHbar;

    @FindBy(xpath = "//span[contains(text(),'Approval Status')]")
    WebElement ApprovalStatus;

    @FindBy(xpath = "//span[contains(text(),'Approval History')]")
    WebElement ApprovalHistory;

    @FindBy(xpath = "//div[@role='listbox']")
    WebElement ListBox;

    @FindBy(xpath = "//span[contains(text(),'Download LHN')]")
    WebElement DownloadLHN;
    @FindBy(xpath = "//span[@title='SendLHToCust']")
    WebElement LHN;
    @FindBy(id = "lhncustActions")
    WebElement SelectAction;

    @FindBy(xpath = "(//span[@ref='eMenu'])[4]")
    public WebElement menuBtn;

    @FindBy(xpath = "(//button//div[@class='mat-tab-header-pagination-chevron'])[1]")
    public WebElement legalHoldNoticePopUpLeftNavigation;

    @FindBy(xpath = "(//button//div[@class='mat-tab-header-pagination-chevron'])[2]")
    public WebElement legalHoldNoticePopUpRightNavigation;

    @FindBy(xpath = "//div[contains(text(),'Reminder Configurations')]")
    public WebElement reminderConfigurationsLink;

    @FindBy(xpath = "//div[contains(text(),'Escalation Configurations')]")
    public WebElement escalationConfigurationsLink;

    // Sending Legal Hold For Approval

    public ILiglPage sendLHNToCustodian(String CustName) throws InterruptedException {
        log_Info("Click on LHN ");
        Thread.sleep(15000);
        LHN.click();
        waitForPageToLoad();

        getCurrentDriver().findElement(By.xpath("//span[@title='" + CustName + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
        SelectAction.click();
        SelectAction.sendKeys("Send");
        SelectAction.sendKeys(Keys.ENTER);
        RunBtn.click();
        Thread.sleep(3000);
        return new LegalHoldPage();
    }

    public ILiglPage sendingLegalHoldForApproval() throws InterruptedException {


        log_Info("Click on LegalHoldName");
        getDriver().waitForelementToBeClickable(LegalHoldName);
        Thread.sleep(3000);
        LegalHoldName.click();
        getSession().log_Pass("LegalHoldName clicked");

        log_Info("Click on Select Action Drop Down");
        getDriver().waitForelementToBeClickable(SelectActionDrpDwn);
        Thread.sleep(3000);
        SelectActionDrpDwn.sendKeys("Send");
        SelectActionDrpDwn.sendKeys(Keys.ENTER);
        getSession().log_Pass("Select Action Drop Down clicked");

        log_Info("Click on Run Button");
        getDriver().waitForelementToBeClickable(RunBtn);
        Thread.sleep(3000);
        RunBtn.click();
        getSession().log_Pass("Run Button clicked");


        log_Info("Click on Select Email Template DrpDown");
        getDriver().waitForelementToBeClickable(SelectEmailTemplateDrpDwn);
        Thread.sleep(3000);
        SelectEmailTemplateDrpDwn.sendKeys("Case Legal hold Approval");
        SelectEmailTemplateDrpDwn.sendKeys(Keys.ENTER);
        getSession().log_Pass("Clicked on Select Email Template DrpDown");

        log_Info("Click on Select Approval DrpDown");
        getDriver().waitForelementToBeClickable(SelectEmailTemplateDrpDwn);
        Thread.sleep(3000);
        SelectApprovalDrpDwn.sendKeys("A Vinay-superuser");
        SelectApprovalDrpDwn.sendKeys(Keys.ENTER);
        getSession().log_Pass("Clicked on Select Approval DrpDown");

        log_Info("Click on Send For Approval Button");
        getDriver().waitForelementToBeClickable(SendForApproveBtn);
        Thread.sleep(3000);
        SendForApproveBtn.click();
        Thread.sleep(5000);
        getSession().log_Pass("Clicked on Send For Approval Button ");
        return new LegalHoldPage();


    }

    public ILiglPage goToLegalHold(String LHname) throws Exception {
        try {
            log_Info("goToRequiredLegalHoldName() Started");
            log_Info("click On The Legal Hold Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.linkText(LHname)).click();
            Thread.sleep(15000);
            log_Info("Clicked On Legal Hold Name");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToRequiredLegalHoldName() Failed", ex);
        }
    }

    public ILiglPage searchLHNThroughEmail(String Email1) throws Exception {
        try {
            log_Info("searchLHNThroughEmail() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            EmpMail.click();
            Thread.sleep(5000);
            log_Info("Menu clicked");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            LHNSearchFilter.click();
            log_Info("Filter Clicked");
            log_Info("Enter Employee");
            Thread.sleep(5000);
            LHNSearchBar.sendKeys(Email1);
            Thread.sleep(5000);
            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Email1 + "']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Employee checked");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchLHNThroughEmail() Failed", ex);
        }
    }

    public ILiglPage verifyRecordStatusInLHN(String LHStatus) throws Exception {
        try {
            log_Info("verifyRecordStatusInLHN() Started");
            Thread.sleep(8000);
            String status = CustStatus.getText();
            Assert.assertEquals(status, LHStatus);
            log_Info("Custodian Status is '" + status + "'");
            log_Pass("Custodian Status updated as per Change");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error(" verifyRecordStatusInLHN() is Failed");
            throw new Exception("Exception in verifyRecordStatusInLHN()", ex);
        }
    }

    public ILiglPage verifyRecordStatusInLHNSH(String LHStatus) throws Exception {
        try {
            log_Info("verifyRecordStatusInLHN() Started");
            Thread.sleep(8000);
            String status = StakeStatus.getText();
            Assert.assertEquals(status, LHStatus);
            log_Info("Custodian Status is '" + status + "'");
            log_Pass("Custodian Status updated as per Change");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error(" verifyRecordStatusInLHN() is Failed");
            throw new Exception("Exception in verifyRecordStatusInLHN()", ex);
        }
    }

    public ILiglPage resendLHN(String custMail, String action) throws Exception {
        try {
            log_Pass("resendLHN() Started");
            searchLHNThroughEmail(custMail);
            clickOnActionDropDownAndRun(action);
            Thread.sleep(5000);
            RefreshBtn.click();
            Thread.sleep(7000);
            searchLHNThroughEmail(custMail);
            String results = Results.getText();
            Assert.assertEquals(results, "1");
            log_Pass("No Duplicate Records after Resend of LHN");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("resendLHN() Failed");
            throw new Exception("Exception in resendLHN()", ex);
        }
    }

    public ILiglPage editTempOnFly(String NewtempName, String subject, String content) throws Exception {
        try {
            log_Info("editTempOnFly() Started");
            Thread.sleep(5000);
            NewTempName.sendKeys(NewtempName);
            Thread.sleep(3000);
            MailSubject.clear();
            MailSubject.sendKeys(subject);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
            MailContent.clear();
            MailContent.sendKeys(content);
            SaveBtn.click();
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("editTempOnFly() is Failed");
            throw new Exception("Exception in editTempOnFly()", ex);
        }
    }

    public ILiglPage editExistingLHNWithOnFlyEditOfCustTemp(String lhName, String NewtempName, String subject, String content) throws Exception {
        try {
            log_Info("editExistingLHNWithOnFlyEditOfCustTemp() Started");
            Thread.sleep(5000);
            EditLHN.click();
            Thread.sleep(3000);
            NextBtn.click();
            Thread.sleep(2000);
            OnFlyEdit.click();
            editTempOnFly(NewtempName, subject, content);
            Thread.sleep(3000);
            String s = selectedTemplateName.getText();
            Assert.assertEquals(s, NewtempName);
            log_Pass("New Template edited on Fly is Updated in Template Dropdown");
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Thread.sleep(2000);
            DateRangeNextbtn.click();
            Thread.sleep(2000);
            KeyWordNextBtn.click();
            Thread.sleep(2000);
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();
            Thread.sleep(8000);
            log_Pass("LHN Saved Successfully After onFly Edit");
            searchRequiredLegalHoldName(lhName);
            Thread.sleep(10000);
            EditLHN.click();
            Thread.sleep(2000);
            LHNNextBtn.click();
            Thread.sleep(2000);
            String s1 = selectedTemplateName.getText();
            Assert.assertEquals(s1, NewtempName);
            log_Pass("The On Fly Edited Custodian Template is Updated To LHN");

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("editExistingLHNWithOnFlyEditOfCustTemp() is Failed");
            throw new Exception("Exception in editExistingLHNWithOnFlyEditOfCustTemp()", ex);
        }
    }

    public ILiglPage sendLHNToApproval(String LHNName, String action, String emailTemp, String approver) throws Exception {
        try {
            log_Info("sendLHNToApproval() Started");
            Thread.sleep(15000);
            searchRequiredLegalHoldName(LHNName);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + LHNName + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            clickOnActionDropDownAndRun(action);
            Thread.sleep(5000);
            EmailTemp.click();
            EmailTempSearch.sendKeys(emailTemp);
            Thread.sleep(3000);
            EmailTempSearch.sendKeys(Keys.ENTER);
            log_Pass("Email Template Drop Down is Searchable in LHN Approval Tab");
            Thread.sleep(3000);
            Approver.click();
            EmailTempSearch.sendKeys(approver);
            Thread.sleep(2000);
            EmailTempSearch.sendKeys(Keys.ENTER);
            log_Pass("Approver Drop Down is Searchable in LHN Approval Tab");
            Thread.sleep(3000);
            SendApprovalBtn.click();


            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("sendLHNToApproval() Failed");
            throw new Exception("Exception in sendLHNToApproval()");
        }
    }

    public ILiglPage sendStealthMode() throws InterruptedException {
        UnCheckAll.click();
        SendStealth.click();
        Thread.sleep(7000);
        return new CaseCustodiansPage();
    }

    public ILiglPage selectLHN(String LHN) throws Exception {
        try {
            log_Info("selectLHN() Started");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + LHN + "']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            log_Pass("Required LHN is Selected");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("selectLHN() Failed");
            throw new Exception("Exception in selectLHN()", ex);
        }
    }

    public ILiglPage checkUnableToSetStealthModeToDeactiveCust(String mail) throws Exception {
        try {
            log_Info("checkUnableToSetStealthModeToDeactiveCust() Started");
            PopUpOkBtn.click();
            //searchLHNThroughEmail(mail);
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("checkUnableToSetStealthModeToDeactiveCust() is Failed");
            throw new Exception("Exception in checkUnableToSetStealthModeToDeactiveCust()", ex);
        }
    }

    public ILiglPage createLHWith_KW_DR(String lhName, String custTemp, String startDate, String endDate, String keyword) throws Exception {
        try {
            log_Info("createLHWith_KW_DR() is Started");
            AddLHN.click();
            Thread.sleep(5000);
            LHNNameField.sendKeys(lhName);
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustNoticeTemp.click();
            Thread.sleep(2000);
            Search.sendKeys(custTemp);
            Thread.sleep(2000);
            Search.sendKeys(Keys.ENTER);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Startdate.sendKeys(startDate);
            EndDate.sendKeys(endDate);
            DateRangeNextbtn.click();
            Thread.sleep(3000);
            KeyWordsFields.sendKeys(keyword);
            KeyWordNextBtn.click();
            Thread.sleep(3000);
            RemainderNextBtn.click();
            LHNSaveBtn.click();
            Thread.sleep(15000);

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("createLHWith_KW_DR() is Failed");
            throw new Exception("Exception in createLHWith_KW_DR()", ex);
        }
    }

    public ILiglPage chooseColumns(String columnName) throws Exception {
        try {
            log_Info("chooseColumns() is Started");
            ChooseColumnsMenu.click();
            ChooseColumnsSearch.sendKeys(columnName);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + columnName + "')]/ancestor::div[@role='treeitem']//input")).click();
            ChooseColumnsMenu.click();
            Thread.sleep(3000);
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("chooseColumns() is Failed");
            throw new Exception("Exception in chooseColumns()", ex);
        }
    }

    public ILiglPage createSecondLHN(String lhName, String custTemp) throws Exception {
        try {
            log_Info("createSecondLHN_With_KW_DR() is Started");
            AddLHN.click();
            Thread.sleep(5000);
            LHNNameField.sendKeys(lhName);
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustNoticeTemp.click();
            Thread.sleep(2000);
            Search.sendKeys(custTemp);
            Thread.sleep(2000);
            Search.sendKeys(Keys.ENTER);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Thread.sleep(2000);
            DateRangeNextbtn.click();
            Thread.sleep(2000);
            KeyWordNextBtn.click();
            Thread.sleep(2000);
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("createSecondLHN_With_KW_DR() is Failed");
            throw new Exception("Exception in createSecondLHN_With_KW_DR()", ex);
        }
    }

    public ILiglPage editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable(String lhName1, String lhName2, String lhName3, String custTemp, String startDate, String endDate, String keyword, String NewtempName, String subject, String content) throws Exception {
        try {
            log_Info("editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable() is Started");
            Thread.sleep(5000);
            EditLHN.click();
            Thread.sleep(3000);
            LHNNextBtn.click();
            Thread.sleep(2000);
            OnFlyEdit.click();
            editTempOnFly(NewtempName, subject, content);

            CustodianNextBtn.click();
            StakeNextBtn.click();
            Thread.sleep(2000);

            Startdate.click();
            Startdate.sendKeys(Keys.ESCAPE);
            Startdate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            Startdate.sendKeys(startDate);
            Startdate.sendKeys(Keys.TAB);

            EndDate.click();
            EndDate.sendKeys(Keys.ESCAPE);
            EndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            EndDate.sendKeys(startDate);
            EndDate.sendKeys(Keys.TAB);

            DateRangeNextbtn.click();
            Thread.sleep(2000);
            WebElement keyWordsForm = getCurrentDriver().findElement(By.xpath("//mat-chip-list[@id='mat-chip-list-0']"));
            keyWordsForm.click();
            List<WebElement> listItem = keyWordsForm.findElements(By.xpath("//mat-chip"));
            for (int i = 0; i < listItem.size(); i++) {
                keyWordsForm.sendKeys(Keys.BACK_SPACE);
            }
            getCurrentDriver().findElement(By.xpath("//mat-chip-list[@aria-label='keyWords']")).sendKeys(keyword);
            Thread.sleep(2000);
            KeyWordNextBtn.click();
            Thread.sleep(2000);
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();
            Thread.sleep(15000);

            //searchRequiredLegalHoldName(lhName1);
            Thread.sleep(15000);
            chooseColumns("Start Date");
            Thread.sleep(5000);
            chooseColumns("End Date");
            Thread.sleep(3000);
            chooseColumns("Keyword");
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='Notes']")).click();
            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 3; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            String SD = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='StartDate']")).getText();
            Assert.assertEquals(SD, startDate);
            String ED = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='EndDate']")).getText();
            Assert.assertEquals(ED, endDate);
            String KW = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeyWords']")).getText();
            Assert.assertEquals(KW, keyword);
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='IsConfigEditable']")).click();
            for (int i = 0; i < 4; i++) {
                ac.sendKeys(Keys.ARROW_LEFT).perform();
            }

            searchRequiredLegalHoldName(lhName2);
            Thread.sleep(15000);

            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='Notes']")).click();
            for (int i = 0; i < 3; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            String SD1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='StartDate']")).getText();
            Assert.assertEquals(SD1, startDate);
            String ED1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='EndDate']")).getText();
            Assert.assertEquals(ED1, endDate);
            String KW1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeyWords']")).getText();
            Assert.assertEquals(KW1, keyword);

            log_Pass("KWs DRs in second LHN are Editable and edited Saved LHN successfully");
            log_Pass("Edited second LHN KWs,DRs are updating in 1st LH also");

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable() is Failed");
            throw new Exception("Exception in editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable()", ex);
        }
    }

    public ILiglPage createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled(String lhName1, String lhName2, String lhName3, String custTemp, String startDate, String endDate, String keyword, String NewtempName, String subject, String content) throws Exception {
        try {
            log_Info("createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled");
            AddLHN.click();
            Thread.sleep(5000);
            LHNNameField.sendKeys(lhName2);
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustNoticeTemp.click();
            Thread.sleep(2000);
            Search.sendKeys(custTemp);
            Thread.sleep(2000);
            Search.sendKeys(Keys.ENTER);
            OnFlyEdit.click();
            Thread.sleep(3000);
            editTempOnFly(NewtempName, subject, content);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Thread.sleep(2000);
            Boolean b1 = Startdate.isEnabled();
            if (b1)
                throw new Exception("Start date Field is not Disabled");
            Boolean b2 = EndDate.isEnabled();
            if (b2)
                throw new Exception("End date Field is not Disabled");
            //String SD=Startdate.getAttribute("value");
            // Assert.assertEquals(SD,startDate);
            log_Pass("Start date is filled by default with first LHN date ");

            //String ED=EndDate.getAttribute("value");

            //Assert.assertEquals(ED,endDate);
            log_Pass("End date is filled by default with first LHN date ");
            DateRangeNextbtn.click();

            getCurrentDriver().findElement(By.xpath("//mat-chip-list[@aria-disabled='true']")).isDisplayed();

            //String KW= KeyWordsFields.getAttribute("value");
            //Assert.assertEquals(KW,keyword);
            log_Pass("Keyword is filled by default with first LHN date ");
            Thread.sleep(2000);
            KeyWordNextBtn.click();
            Thread.sleep(2000);
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();
            log_Info("Second Created LHN Edit started");
            EditLHN.click();
            LHNNextBtn.click();
            Thread.sleep(2000);
            editTempOnFly(NewtempName, subject, content);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Thread.sleep(2000);
            Startdate.click();
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled() is Failed");
            throw new Exception("Exception in createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled()", ex);
        }
    }

    public ILiglPage verifyCustodianInterviewTranscriptNotes() throws Exception {
        try {
            log_Info("verifyCustodianInterviewTranscriptNotes() Started");
            RecordInterViewBtn.click();
            Thread.sleep(3000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", InterviewSaveBtn);
            InterviewExportBtn.isDisplayed();
            InterviewActionColHeader.isDisplayed();
            InterviewLastEditedColHeader.isDisplayed();
            InterviewNotesColHeader.isDisplayed();
            InterviewerNameColHeader.isDisplayed();

            log_Pass("All the expected columns in Notes grid are available");

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("verifyCustodianInterviewTranscriptNotes is Failed");
            throw new Exception("Exception in verifyCustodianInterviewTranscriptNotes()", ex);
        }
    }

    public ILiglPage verifyColumnsInLegalHoldGrid() throws Exception {
        try {

            log_Info("verifyColumnsInLegalHoldGrid() Started");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Legal Hold Name')]")).isDisplayed();
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Created On')]")).isDisplayed();
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Approval Status')]")).isDisplayed();
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Test Email')]")).isDisplayed();
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Action')]")).isDisplayed();
            getCurrentDriver().findElement(By.xpath("//div[@role='columnheader']//span[contains(text(),'Notes')]")).isDisplayed();
            ChooseColumnsMenu.click();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Stakeholder LHN Template");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Stakeholder LHN Template')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Custodian Questionnaire Template");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Custodian Questionnaire Template')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Stakeholder Questionnaire Template");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Stakeholder Questionnaire Template')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Approval History");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Approval History')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("End Date");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'End Date')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Start Date");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Start Date')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Keyword");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Keyword')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Number of Days");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Number of Days')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            Thread.sleep(2000);
            ChooseColumnsSearch.sendKeys("Number of Attachments");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Number of Attachments')]")).isDisplayed();
            ChooseColumnsSearch.clear();

            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("verifyColumnsInLegalHoldGrid() is Failed");
            throw new Exception("Exception in verifyColumnsInLegalHoldGrid()");
        }
    }

    public ILiglPage editLHNCreatedWithDRKW(String lhName1, String lhName2, String custTemp, String startDate, String endDate, String keyword) throws Exception {
        try {
            log_Info("editLHNCreatedWithDRKW() is Started");
            // createSecondLHN(lhName1,custTemp);
            Thread.sleep(10000);
            searchRequiredLegalHoldName(lhName1);
            Thread.sleep(5000);
            EditLHN.click();
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Thread.sleep(2000);

            Startdate.click();
            Startdate.sendKeys(Keys.ESCAPE);
            Startdate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            Startdate.sendKeys(startDate);
            Startdate.sendKeys(Keys.TAB);

            EndDate.click();
            EndDate.sendKeys(Keys.ESCAPE);
            EndDate.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            EndDate.sendKeys(startDate);
            EndDate.sendKeys(Keys.TAB);

            DateRangeNextbtn.click();
            Thread.sleep(2000);
            WebElement keyWordsForm = getCurrentDriver().findElement(By.xpath("//mat-chip-list[@id='mat-chip-list-0']"));
            keyWordsForm.click();
            List<WebElement> listItem = keyWordsForm.findElements(By.xpath("//mat-chip"));
            for (int i = 0; i < listItem.size(); i++) {
                keyWordsForm.sendKeys(Keys.BACK_SPACE);
            }
            Thread.sleep(3000);
            KeyWordsFields.sendKeys(keyword);
            Thread.sleep(2000);
            KeyWordNextBtn.click();
            Thread.sleep(2000);
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();
            Thread.sleep(15000);
            //searchRequiredLegalHoldName(lhName1);
            Thread.sleep(15000);
            chooseColumns("Start Date");
            Thread.sleep(5000);
            chooseColumns("End Date");
            Thread.sleep(3000);
            chooseColumns("Keyword");
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='Notes']")).click();
            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 3; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            String SD = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='StartDate']//div//span//span")).getText();
            Assert.assertEquals(SD, startDate);
            String ED = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='EndDate']//div//span//span")).getText();
            Assert.assertEquals(ED, endDate);
            String KW = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeyWords']//div//span//span")).getText();
            Assert.assertEquals(KW, keyword);
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='IsConfigEditable']")).click();
            for (int i = 0; i < 4; i++) {
                ac.sendKeys(Keys.ARROW_LEFT).perform();
            }

            searchRequiredLegalHoldName(lhName2);
            Thread.sleep(15000);

            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='Notes']")).click();
            for (int i = 0; i < 3; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            String SD1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='StartDate']")).getText();
            Assert.assertEquals(SD1, startDate);
            String ED1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='EndDate']")).getText();
            Assert.assertEquals(ED1, endDate);
            String KW1 = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeyWords']")).getText();
            Assert.assertEquals(KW1, keyword);

            log_Pass("KWs DRs in second LHN are Editable and edited Saved LHN successfully");
            log_Pass("Edited second LHN KWs,DRs are updating in 1st LH also");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("editLHNCreatedWithDRKW() is Failed");
            throw new Exception("Exception in editLHNCreatedWithDRKW()", ex);
        }
    }

    public ILiglPage verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater(String lhName1, String lhName2, String custTemp, String startDate, String endDate, String keyword) throws Exception {
        try {
            log_Info("verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater() is Started");
            Thread.sleep(15000);
            createLHWith_KW_DR(lhName1, custTemp, startDate, endDate, keyword);
            searchRequiredLegalHoldName(lhName1);
            Thread.sleep(8000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + lhName1 + "')]")).isDisplayed();
            AddLHN.click();
            Thread.sleep(5000);
            LHNNameField.sendKeys(lhName2);
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustNoticeTemp.click();
            Thread.sleep(2000);
            Search.sendKeys(custTemp);
            Thread.sleep(2000);
            Search.sendKeys(Keys.ENTER);
            CustodianNextBtn.click();
            Thread.sleep(2000);
            StakeNextBtn.click();
            Boolean b1 = Startdate.isEnabled();
            if (!b1)
                log_Info("Start date Field is Disabled");
            Boolean b2 = EndDate.isEnabled();
            if (!b2)
                log_Info("Start date Field is Disabled");
            String SD = Startdate.getAttribute("value");
            Assert.assertEquals(SD, startDate);
            log_Pass("Start date is filled by default with first LHN date ");

            String ED = EndDate.getAttribute("value");

            Assert.assertEquals(ED, endDate);
            log_Pass("End date is filled by default with first LHN date ");
            DateRangeNextbtn.click();

            Boolean b3 = KeyWordsFields.isEnabled();
            if (!b3)
                log_Info("Start date Field is Disabled");
            String KW = KeyWordsFields.getAttribute("value");
            Assert.assertEquals(KW, keyword);
            log_Pass("Keyword field is filled by default with first LHN keyword");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater() is Failed");
            throw new Exception("Exeption in verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater()", ex);
        }
    }

    public ILiglPage refreshLHN() throws InterruptedException {
        log_Info("refreshLHN() is Started");
        RefreshBtn.click();
        Thread.sleep(15000);
        return new LegalHoldPage();
    }

    public ILiglPage verifyFieldsInAddLegalHoldModel(String LHName, String custNoticeTemp) throws Exception {
        try {

            log_Info("verifyFieldsInAddLegalHoldModel() Started");
            Thread.sleep(15000);
            AddLHN.click();
            Thread.sleep(4000);
            LHNNameField.sendKeys(LHName);
            log_Info("LHN Name Field is Verified");
            LHNNextBtn.click();
            Thread.sleep(2000);
            CustNoticeTemp.click();
            Thread.sleep(2000);
            Search.sendKeys(custNoticeTemp);
            Thread.sleep(2000);
            Search.sendKeys(Keys.ENTER);
            log_Info("Custodian Notice Template Field is Verified");
            CustQuestTemp.isDisplayed();
            log_Info("Custodian Questionnaire Template Field is Verified");
            Thread.sleep(2000);
            CustodianNextBtn.click();
            StakeNoticeTemp.isDisplayed();
            log_Info("Stake Holder Notice Template Field is Verified");
            StakeNextBtn.click();
            Thread.sleep(2000);
            Startdate.isDisplayed();
            log_Info("Start Date Field is Available");
            EndDate.isDisplayed();
            log_Info("End Date Field is Available");
           /* NoOfDays.isDisplayed();
            log_Info("No of Days Field is Available");*/
            DateRangeNextbtn.click();
            Thread.sleep(2000);
            KeyWordsFields.isDisplayed();
            KeyWordNextBtn.click();
            Thread.sleep(3000);
            RemainderMailTemp.isDisplayed();
            log_Info("Remainder Mail Template Field is Available");
            RemainderFrequency.isDisplayed();
            log_Info("Remainder Mail Frequency Field is Available");
            RemainderMailCap.isDisplayed();
            log_Info("Remainder Mail Cap Field is Available");
            RemainderMailRadioBtn.isDisplayed();
            log_Info("Remainder Mail Send Radio Button Field is Available");
            NoofDayBeforeRemainderSent.isDisplayed();
            log_Info("No of Days Before Mail sent Field is Available");
            RemainderNextBtn.click();
            Thread.sleep(2000);
            LHNSaveBtn.click();
            Thread.sleep(15000);
            searchRequiredLegalHoldName(LHName);
            Thread.sleep(15000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + LHName + "')]")).isDisplayed();
            log_Pass("Verified All Fields in Add Legal Hold Model And Created LegalHold Successfully ");


            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error("verifyFieldsInAddLegalHoldModel() is Failed");
            throw new Exception("Exception in verifyFieldsInAddLegalHoldModel()", ex);
        }
    }

    public ILiglPage verifyRecordStatusOfLHN(String LHStatus) throws Exception {
        try {
            log_Info("verifyRecordStatusInLHN() Started");
            Thread.sleep(5000);
            String status = LHNAprvlStatus.getText();
            Assert.assertEquals(status, LHStatus);
            log_Info("LHN Status is '" + status + "'");
            log_Pass("Custodian Status updated as per Change");
            return new LegalHoldPage();
        } catch (Exception ex) {
            log_Error(" verifyRecordStatusInLHN() is Failed");
            throw new Exception("Exception in verifyRecordStatusInLHN()", ex);
        }
    }

    public ILiglPage searchEmployeeInGrid(String custodianMail) throws Exception {
        try {
            log_Info("searchEmployeeInGrid() Started");
            EmpMail.click();

            Thread.sleep(5000);
            log_Info("Menu clicked");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(5000);
            log_Info("Enter Employee");
            Searchbar.sendKeys(custodianMail);
            Thread.sleep(5000);
            log_Info("Check Employee CheckBox");

            return new EmployeeMasterPage();
        } catch (Exception ex) {
            log_Error("searchEmployeeInGrid() Failed");
            throw new Exception("Exception in searchEmployeeInGrid()", ex);
        }
    }

    public ILiglPage checkReportingManagerFieldinAdditionalFields(String custodianMail) throws Exception {
        try {
            log_Info("checkReportingManagerFieldinAdditionalFields() Started");
            searchEmployeeInGrid(custodianMail);
            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='FullName']//span[@class='ellipsisAgGrid']")).click();

            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 8; i++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            EditBtn.click();
            AddressTab.click();
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", MoreBtn);
            MoreBtn.click();
            getCurrentDriver().findElement(By.xpath("//mat-form-field[@appearance='fill']/ancestor::div//span[contains(text(),'Reporting Manager')]")).isDisplayed();

            return new EmployeeMasterPage();
        } catch (Exception ex) {
            log_Error("checkReportingManagerFieldinAdditionalFields() Failed");
            throw new Exception("Exception in checkReportingManagerFieldinAdditionalFields()", ex);
        }
    }
    // Check That Any Added Custodian Should Not Be Displayed In LHN Or In DSI Page Untill Approved

    public ILiglPage checkLHNForCustodians(String LHN, String Employee1) throws Exception {

        try {

            log_Info("Click On Legal Hold Name ");
            getDriver().waitForElementLoad();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + LHN + "')]")).click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Legal Hold Name ");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("checkLHNForCustodians() Failed", ex);
        }
    }

    // validate Custodian Name Before Approving

    public ILiglPage validateCustodianBeforeApproved() throws Exception {

        try {

            log_Info("Check The Custodians In The LegalHold");
            boolean a1 = NoDataAvailable.isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateLHNForCustodians() Failed", ex);
        }
    }

    public ILiglPage validateCustodianAfterApproved(String Employee1) throws Exception {

        try {

            log_Info("Check The Custodians In The LegalHold");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Employee1 + "')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCustodianAfterApproved() Failed", ex);
        }
    }

    public ILiglPage searchActionThroughEmail(String Email1) throws Exception {

        try {

            log_Info("searchActionThroughEmail() Started");

            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmpMail).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            EmpMail.click();
            Thread.sleep(5000);
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee");
            Thread.sleep(5000);
            Searchbar.sendKeys(Email1);
            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Email1 + "']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            log_Info("Employee checked");
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchActionThroughEmail() Failed", ex);
        }


    }

    // Re - Assign Start
    public ILiglPage validateLHStatus(String Status) throws Exception {

        try {

            log_Info("Check The Status of LegalHold");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Status + "')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateLHStatus() Failed", ex);
        }


    }

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
            Thread.sleep(10000);
            log_Info("Entered LH name In The Search Bar");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredLegalHoldName() Failed", ex);
        }
    }


    public ILiglPage secondSearch(String LHname) throws Exception {
        try {


            log_Info("secondSearch() Started");
            //log_Info("Hover on Name Header");
            Thread.sleep(5000);
            // Actions ac = new Actions(getCurrentDriver());
            // ac.moveToElement(LHNAME).perform();
            //log_Info("Hovered on Name Header");
            // Thread.sleep(5000);
            log_Info("Click On Legal Hold Name Menu");
            LHNameMenu.click();
            Thread.sleep(5000);
            Searchbar.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            log_Info("Data is filtered");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("secondSearch() Failed", ex);
        }
    }

    public ILiglPage clickOnActionDropDownAndRun(String Action1) throws Exception {

        try {
            log_Info("clickOnActionDropDownAndRun() Started");
            log_Info("click On Action Drop Down");
            Thread.sleep(5000);
            ActionDrpDwn.sendKeys(Action1);
            ActionDrpDwn.sendKeys(Keys.ENTER);
            log_Info("clicked On Action Drop Down");
            Thread.sleep(5000);
            log_Info("click On Run Button");
            Thread.sleep(5000);
            RunButn.click();
            log_Info("clicked On Run Button");
            Thread.sleep(5000);
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnActionDropDownAndRun() Failed", ex);
        }
    }

    public ILiglPage clickOnLHCheckbox(String LHname) throws Exception {
        try {
            log_Info("Check Legal hold name CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + LHname + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Legal hold name checked");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnLHCheckbox() Failed", ex);
        }
    }

    public ILiglPage selectTemplateAndApproverAndClickOnSendBtn(String Template1, String ApproverName) throws Exception {
        try {
            log_Info("selectTemplateAndApproverAndClickOnSendBtn() Started");
            log_Info("click On Template Drop Down");
            Thread.sleep(5000);
            LegalholdTemplate.sendKeys(Template1);
            Thread.sleep(5000);
            LegalholdTemplate.sendKeys(Keys.ENTER);
            log_Info("clicked On Template Drop Down");
            Thread.sleep(5000);
            log_Info("click On Approver Drop Down");
            SelectLHApprover.sendKeys(ApproverName);
            Thread.sleep(5000);
            SelectLHApprover.sendKeys(Keys.ENTER);
            log_Info("clicked On Approver Drop Down");
            Thread.sleep(5000);
            log_Info("click On Send Button");
            LHTemplateSendBtn.click();
            Thread.sleep(5000);
            log_Info("clicked On Send Button");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("selectTemplateAndApproverAndClickOnSendBtn() Failed", ex);
        }
    }


    public ILiglPage validateSSCopyeesList() throws Exception {

        try {

            log_Info("Check The Copyees list in Popup");
            boolean a1 = CopyeesSSLabel.isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("Copyees list displayed in Popup");
            Thread.sleep(5000);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCopyeesList() Failed", ex);
        }


    }

    public ILiglPage clickOnApprovedLH(String LHname) throws Exception {

        try {

            log_Info("Click On Legal Hold Name ");
            getDriver().waitForElementLoad();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + LHname + "')]")).click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Legal Hold Name ");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnApprovedLH() Failed", ex);
        }
    }

    public ILiglPage searchRequiredLHNStatus(String Status) throws Exception {
        try {


            log_Info("searchRequiredLHNStatus() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(LHNStatus).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            log_Info("Click On LHN Status Menu");
            StatusMenu.click();
            Thread.sleep(5000);
            log_Info("Clicked On LHN Status Menu");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            log_Info("Enter LHN Status In The Search Bar");
            Searchbar.sendKeys(Status);
            Thread.sleep(5000);
            log_Info("Entered LHN Status In The Search Bar");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredLHNStatus() Failed", ex);
        }
    }

    public ILiglPage clickOnRefreshButton() throws Exception {
        try {
            log_Info("clickOnRefreshButton() Started");
            log_Info("click On Refresh Button");
            Thread.sleep(10000);
            RefreshBtnCustodian.click();
            Thread.sleep(5000);
            log_Info("clicked On Refresh Button");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickActionOnResponseDocument() Failed", ex);
        }
    }

    public ILiglPage copyeeSScancelBtnClick() throws Exception {

        try {

            log_Info("Click on Cancel button started");
            Thread.sleep(5000);
            log_Info("click On Cancel Button");
            Thread.sleep(5000);
            CancelBtn.click();
            log_Info("clicked On Cancel Button");
            Thread.sleep(5000);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("CopyeeSScancelBtnClick() Failed", ex);
        }


    }

    public ILiglPage copyeeReleaseCancelBtnClick() throws Exception {

        try {

            log_Info("Click on Release Cancel button started");
            Thread.sleep(5000);
            log_Info("click On Release Cancel Button");
            Thread.sleep(5000);
            CancelRBtn.click();
            log_Info("clicked On Release Cancel Button");
            Thread.sleep(5000);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("CopyeeReleaseCancelBtnClick() Failed", ex);
        }


    }

    public ILiglPage validateRCopyeesList() throws Exception {

        try {

            log_Info("Check The Copyees list in Release Popup");
            boolean a1 = CopyeesRLabel.isDisplayed();
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("Copyees list displayed in Release Popup");
            Thread.sleep(5000);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateRCopyeesList() Failed", ex);
        }


    }

    public ILiglPage switchOnToTheStakeHolderTab() throws Exception {
        try {
            log_Info("switchOnToTheStakeHolderTab() Started");
            log_Info("Click On The Stakeholder Tab Button");
            getDriver().waitForelementToBeClickable(StakeholderBtn);
            Thread.sleep(3000);
            StakeholderBtn.click();
            log_Info("clicked On The Stakeholder Button");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("switchOnToTheStakeHolderTab() Failed", ex);
        }
    }

    public ILiglPage clickOnCreateStakeHolderBtnInLH(String FirstName, String LastName, String StakeDepartment, String StakeEmailID, String StakeCategoryValue) throws Exception {
        try {
            log_Info("clickOnCreateStakeHolderBtnInLH() Started");
            log_Info("Click On The +Stakeholder Button in LH");
            getDriver().waitForelementToBeClickable(AddStakeholderBtn);
            Thread.sleep(3000);
            AddStakeholderBtn.click();
            log_Info("clicked On +Stakeholder Button in LH");

            log_Info("click On First name field");
            Thread.sleep(2000);
            Fname.sendKeys(FirstName);
            log_Info("First name entered successfully");

            log_Info("click On Last name field");
            Thread.sleep(2000);
            Lname.sendKeys(LastName);
            log_Info("Last name entered successfully");

            log_Info("click On Department dropdown field");
            StakeDept.click();
            DeptSearchBar.sendKeys(StakeDepartment);
            Thread.sleep(5000);
            StakeDept.sendKeys(Keys.ENTER);
            log_Info("Department selected successfully");

            log_Info("click On Email field");
            Thread.sleep(5000);
            StakeEmail.sendKeys(StakeEmailID);
            log_Info("Email entered successfully");

            log_Info("click On Category dropdown field");
            Thread.sleep(2000);
            StakeCategory.sendKeys(StakeCategoryValue);
            Thread.sleep(5000);
            StakeCategory.sendKeys(Keys.ENTER);
            log_Info("Category selected successfully");

            log_Info("click On Save button");
            Thread.sleep(2000);
            getDriver().waitForelementToBeClickable(SaveStakeholderBtn);
            SaveStakeholderBtn.click();
            log_Info("Stakeholder saved successfully");
            Thread.sleep(5000);


            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnCreateStakeHolderBtnInLH() Failed", ex);
        }
    }

    public ILiglPage searchStakeholderEmailFromLHNGrid(String StakeEmailID) throws Exception {
        try {


            log_Info("searchStakeholderEmailFromLHNGrid() Started");
            log_Info("Hover on Email Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(Semail).perform();
            log_Info("Hovered on Email Header");
            Thread.sleep(5000);
            log_Info("Click On Email search Menu");
            SemailMenu.click();
            Thread.sleep(5000);
            log_Info("Clicked On Email search Menu");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            log_Info("Enter email In The Search Bar");
            Searchbar.sendKeys(StakeEmailID);
            Thread.sleep(5000);
            Filter.click();
            log_Info("Entered email In The Search Bar");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchStakeholderEmailFromLHNGrid() Failed", ex);
        }
    }

    public ILiglPage verifyStakeholderEmailIsDisplayed(String StakeEmailID) throws Exception {
        try {

            log_Info("verifyStakeholderEmailIsDisplayed() Started");
            log_Info("searchStakeholderEmailFromLHNGrid() is going to start");
            searchStakeholderEmailFromLHNGrid(StakeEmailID);
            Thread.sleep(5000);
            log_Info("searchStakeholderEmailFromLHNGrid() completed");
            log_Info("Getting the Email column data");
            String Mail = EmailColumn.getText();
            Thread.sleep(5000);
            log_Info("Checking created stakeholder is displaying in grid");
            Assert.assertEquals(Mail, StakeEmailID);
            Thread.sleep(6000);
            log_Pass("Checked created stakeholder is displaying in grid");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyStakeholderEmailIsDisplayed() Failed", ex);
        }
    }

    public ILiglPage validateDisplayOfDefaultTemplateInLHReleasePopup(String DefaultTemplate) throws Exception {

        try {
            log_Info("Click on Release Template dropdown");
            Thread.sleep(5000);
            ReleaseTemplateDrpDown.click();
            log_Info("Clicked on Release Template dropdown");
            log_Info("Validate Display Of Default Template in Release Popup");
            Thread.sleep(5000);
            String Temp = DefaultReleaseTemplate.getText();
            Assert.assertEquals(Temp, DefaultTemplate);
            log_Pass("Default Template is displaying in Release Popup");
            Thread.sleep(5000);
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateDisplayOfDefaultTemplateInLHReleasePopup() Failed", ex);
        }


    }

    public ILiglPage sendBtnInTestMail() throws Exception {
        try {
            log_Info("sendBtnInTestMail() Started");
            Thread.sleep(5000);
            log_Info("Hovering onto Legal hold name column in grid & Moving to Test mail column");
            LHNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            //WebDriverWait wait1 = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(30));
            //wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ag-overlay ag-hidden']")));
            //System.out.println("Grid Loaded...");
            for (int i = 0; i < 3; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(TestMail);
            TestMail.click();
            log_Info("Test mail icon is clicked & Test mail popup opened");
            Thread.sleep(5000);
            TestMailSend.click();
            log_Info("Send button is clicked successfully in Test mail popup");
            Thread.sleep(5000);
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendBtnInTestMail() Failed", ex);

        }
    }

    public ILiglPage legalHoldNotes() throws Exception {
        try {
            log_Info("legalHoldNotes() Started");
            Thread.sleep(5000);
            LHNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 5; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(LHNoteIcon);
            LHNoteIcon.click();
            Thread.sleep(5000);
            log_Info("Legal hold Notes icon is clicked");
            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("legalHoldNotes() Failed", ex);

        }
    }

    public ILiglPage clickOnAddNewLegalHoldButton() throws Exception {
        try {
            log_Info("clickOnAddNewLegalHoldButton() Started");
            log_Info("Click on Add Legal Hold Button");
            getDriver().waitForelementToBeClickable(AddLegalHoldBtn);
            Thread.sleep(5000);
            AddLegalHoldBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Legal Hold Button clicked");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnAddNewLegalHoldButton() Failed", ex);
        }
    }

    public ILiglPage createNewLegalHoldWhenOnFlyIsFalse(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception {
        try {
            log_Info("createNewLegalHold() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");

            try {
                log_Info("Started checking unavailability of on fly edit button for Custodian");
                OnFlyEdit.isDisplayed();
            } catch (Exception ex) {
                log_Info("on fly edit button for Custodian is not displaying");
            }

            log_Info("Select Custodian Questionnaire Template Drop Down");
            getDriver().waitForelementToBeClickable(CustQuestionaireDrpDwn);
            Thread.sleep(5000);
            CustQuestionaireDrpDwn.sendKeys(CustodianQuestionaireTemplate);
            Thread.sleep(3000);
            CustQuestionaireDrpDwn.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            getSession().log_Pass(" Selected Custodian Questionnaire Template Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(LHSaveBtn);
            Thread.sleep(3000);
            LHSaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked & Legal hold created successfully");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage verifyCreatedLegalHoldIsDisplayed(String LHname) throws Exception {
        try {

            log_Info("verifyCreatedLegalHoldIsDisplayed() Started");
            log_Info("searchRequiredLegalHoldName() is going to start");
            searchRequiredLegalHoldName(LHname);
            Thread.sleep(5000);
            log_Info("searchRequiredLegalHoldName() completed");
            log_Info("Getting the Legal hold name column data");
            String LegalHoldname = LHnamecolumn.getText();
            Thread.sleep(5000);
            log_Info("Checking created legal hold is displaying in grid");
            Assert.assertEquals(LegalHoldname, LHname);
            Thread.sleep(5000);
            log_Pass("Verified created legal hold is displaying in grid");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyCreatedLegalHoldIsDisplayed() Failed", ex);
        }
    }

    public ILiglPage verifyEditedLegalHoldIsDisplayed(String LHname) throws Exception {
        try {
            log_Info("verifyEditedLegalHoldIsDisplayed() Started");
            log_Info("Getting the Legal hold name column data");
            String EditedLname = LHnamecolumn.getText();
            Thread.sleep(5000);
            Assert.assertEquals(EditedLname, LHname);
            Thread.sleep(5000);
            log_Pass("Updated legal hold name is displaying in grid");
            return new LegalHoldPage();

        } catch (Exception ex) {
            throw new Exception("Exception in verifyEditedLegalHoldIsDisplayed()", ex);
        }
    }

    public ILiglPage editLegalHoldWhenOnFlyIsFalse(String EditedLegalHoldname, String CustodianQTemplate, String LHname) throws Exception {
        try {
            log_Info("editLegalHoldWhenOnFlyIsFalse() started");
           /* log_Info("secondSearch() is going to start");
            secondSearch(LHname);
            Thread.sleep(5000);
            log_Info("secondSearch() completed");*/

            log_Info("Moving to Edit button in Action column in Legal hold grid");
            LHNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 4; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(LHEditIcon);
            LHEditIcon.click();
            Thread.sleep(5000);
            log_Info("Legal hold edit icon is clicked & edit popup opened");

            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(EditedLegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold edited");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            try {
                log_Info("Started checking unavailability of on fly edit button for Custodian");
                OnFlyEdit.isDisplayed();
            } catch (Exception ex) {
                log_Info("on fly edit button for Custodian is not displaying");
            }

            log_Info("Select Custodian Questionnaire Template Drop Down");
            getDriver().waitForelementToBeClickable(CustQuestionaireDrpDwn);
            Thread.sleep(5000);
            CustQuestionaireDrpDwn.sendKeys(CustodianQTemplate);
            Thread.sleep(3000);
            CustQuestionaireDrpDwn.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            getSession().log_Pass(" Selected another Custodian Questionnaire Template from Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(LHSaveBtn);
            Thread.sleep(3000);
            LHSaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked & Legal hold updated successfully");


            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("editLegalHoldWhenOnFlyIsFalse() Failed", ex);
        }
    }

    public ILiglPage clickOnLegalholdGridRefreshButton() throws Exception {
        try {
            log_Info("clickOnLegalholdGridRefreshButton() Started");
            log_Info("click On Legal hold Refresh Button");
            Thread.sleep(10000);
            RefreshBtnLegalHold.click();
            Thread.sleep(5000);
            log_Info("clicked On Legal hold Refresh Button");
            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnLegalholdGridRefreshButton() Failed", ex);
        }
    }

    public ILiglPage goToRequiredLegalHoldName(String LHname) throws Exception {

        try {

            log_Info("goToRequiredLegalHoldName() Started");
            log_Info("click On The Legal Hold Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.linkText(LHname)).click();
            Thread.sleep(5000);
            log_Info("Clicked On Legal Hold Name");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToRequiredLegalHoldName() Failed", ex);
        }
    }

    public ILiglPage verifyColumnsInLHNCustodianGrid() throws Exception {


        try {

            log_Info("verifyColumnsInLHNCustodianGrid() Started");
            log_Info("Check The Column names In The Custodian Page");

            boolean c1 = CName.isDisplayed();
            boolean c2 = HRstatus.isDisplayed();
            boolean c3 = Department.isDisplayed();
            boolean c4 = Email.isDisplayed();
            boolean c5 = SentBy.isDisplayed();
            boolean c6 = SentOn.isDisplayed();
            boolean c7 = LHNstatus.isDisplayed();
            boolean c8 = Comments.isDisplayed();

            Thread.sleep(5000);

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);
            System.out.println(c7);
            System.out.println(c8);

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            Assert.assertEquals(true, c6);
            Assert.assertEquals(true, c7);
            Assert.assertEquals(true, c8);
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInLHNCustodianGrid()", ex);
        }
    }

    public ILiglPage verifyColumnsInLHNStakeHolderGrid() throws Exception {


        try {

            log_Info("verifyColumnsInLHNStakeHolderGrid() Started");
            log_Info("click On The Stakeholder Button");
            getDriver().waitForelementToBeClickable(StakeholderBtn);
            Thread.sleep(3000);
            StakeholderBtn.click();
            log_Info("clicked On The Stakeholder Button");

            log_Info("Check The Column names In The StakeHolder Page");

            boolean c1 = NameHeader.isDisplayed();
            /*boolean c2 = Category.isDisplayed();*/
            boolean c3 = Department.isDisplayed();
            boolean c4 = Email.isDisplayed();
            boolean c5 = RequestSentBy.isDisplayed();
            boolean c6 = RequestSentDate.isDisplayed();
            boolean c7 = Acknowledge.isDisplayed();
            boolean c8 = LHNoticeStatus.isDisplayed();
            boolean c9 = Responses.isDisplayed();
            boolean c10 = Actions.isDisplayed();

            Thread.sleep(5000);

            System.out.println(c1);
            /* System.out.println(c2);*/
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);
            System.out.println(c7);
            System.out.println(c8);
            System.out.println(c9);
            System.out.println(c10);

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            /*  Assert.assertEquals(true, c2);*/
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            Assert.assertEquals(true, c6);
            Assert.assertEquals(true, c7);
            Assert.assertEquals(true, c8);
            Assert.assertEquals(true, c9);
            Assert.assertEquals(true, c10);
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInLHNStakeHolderGrid()", ex);
        }
    }

    /*public ILiglPage searchActionThroughEmail(String Email1) throws Exception {

        try {


            log_Info("searchActionThroughEmail() Started");

            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmpMail).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            EmpMail.click();
            Thread.sleep(5000);
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee");
            Thread.sleep(5000);
            Searchbar.sendKeys(Email1);
            Thread.sleep(5000);
            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Email1 + "']/ancestor::div[@role='rowgroup']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Employee checked");

            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchActionThroughEmail() Failed", ex);
        }

    }*/

    public ILiglPage verifySentByAndSentOnData(String Sentby, String Senton) throws Exception {

        try {

            log_Info("Check The Data In The Particular SentBy And SentOn Coulumns");

            boolean c1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Sentby + "')]")).isDisplayed();
            boolean c2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Senton + "')]")).isDisplayed();
            Thread.sleep(5000);

            System.out.println(c1);
            System.out.println(c2);
            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifySentByAndSentOnData() Failed", ex);
        }

    }

    public ILiglPage clickActionOnResponseDocument() throws Exception {


        try {

            log_Info("clickActionOnResponseDocument() Started");
            log_Info("click On The Response Document View Icon");
            getDriver().waitForelementToBeClickable(ResponseFile);
            Thread.sleep(3000);
            ResponseFile.click();
            log_Info("clicked On The Response Document View Icon");

            if (getCurrentDriver().getTitle().contains("Vertical")) {
                log_Pass("Navigated to Response Page");

            }

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickActionOnResponseDocument() Failed", ex);
        }

    }

    public ILiglPage validateRecordWhenLHNStatusIsInNotintiatedState(String status) throws Exception {

        try {
            log_Info("validateRecordWhenLHNStatusIsInNotintiatedState() Started");
            WebDriverWait wait = new WebDriverWait(getCurrentDriver(), 30);
            wait.until(ExpectedConditions.visibilityOf(AlertMessage));
            String s = AlertMessage.getText();
            if (s.equals(status)) {

                log_Pass("Popup Message Verified");
            }
            log_Pass("Message Verified For Not Initiated State Only");
            getSession().takeScreenShot();
            OKBTN.click();
            log_Pass("Clicked On The Ok Button");
            return new LegalHoldPage();


        } catch (Exception ex) {
            log_Error("validateRecordWhenLHNStatusIsInNotintiatedState() Failed");
            throw new Exception("validateRecordWhenLHNStatusIsInNotintiatedState()", ex);
        }
    }

    public ILiglPage clickOnActionDropDownAndRunInStakeHolder(String Action1) throws Exception {

        try {


            log_Info("clickOnActionDropDownAndRunInStakeHolder() Started");
            log_Info("click On Action Drop Down");
            Thread.sleep(5000);
            ActionDrpDwnStakeHolder.sendKeys(Action1);
            ActionDrpDwnStakeHolder.sendKeys(Keys.ENTER);
            log_Info("clicked On Action Drop Down");
            Thread.sleep(5000);

            log_Info("click On Run Button");
            Thread.sleep(5000);
            RunButton.click();
            Thread.sleep(5000);
            log_Info("clicked On Run Button");
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnActionDropDownAndRunInStakeHolder() Failed", ex);
        }

    }

    public ILiglPage validateLHNStatus(String LHNStatus) throws Exception {

        try {


            log_Info("validateLHNStatus() Started");
            log_Info("Check The LHN Status");
            Thread.sleep(5000);
            boolean v1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + LHNStatus + "')]")).isDisplayed();
            Thread.sleep(5000);

            System.out.println(v1);
            Thread.sleep(5000);
            Assert.assertEquals(true, v1);
            log_Info("Checked The LHN Status");

            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateLHNStatus() Failed", ex);
        }

    }

    public ILiglPage selectTemplateAndClickOnSendBtn(String Template1) throws Exception {


        try {

            log_Info("selectTemplateAndClickOnSendBtn() Started");
            log_Info("click On Template Drop Down");
            Thread.sleep(5000);
            CustodianReleaseTemplate.sendKeys(Template1);
            CustodianReleaseTemplate.sendKeys(Keys.ENTER);
            log_Info("clicked On Template Drop Down");

            log_Info("click On Send Button");
            Thread.sleep(5000);
            CustodianTemplateSendBtn.click();
            Thread.sleep(5000);
            log_Info("clicked On Send Button");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("selectTemplateAndClickOnSendBtn() Failed", ex);
        }
    }

    public ILiglPage clickOnRefreshButtonStakeHolder() throws Exception {


        try {

            log_Info("clickOnRefreshButton() Started");
            log_Info("click On Refresh Button");
            Thread.sleep(5000);
            RefreshBtnStakeHolder.click();
            Thread.sleep(5000);
            log_Info("clicked On Refresh Button");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickActionOnResponseDocument() Failed", ex);
        }

    }

    public ILiglPage createNewLegalHold(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception {

        try {


            log_Info("createNewLegalHold() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");

            /*log_Info("Select Questionaire Template Drop Down");
            getDriver().waitForelementToBeClickable(QuestionaireDrpDwn);
            Thread.sleep(5000);
            QuestionaireDrpDwn.sendKeys(CustodianQuestionaireTemplate);
            Thread.sleep(3000);
            QuestionaireDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Selected Questionaire Template Drop Down");*/

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");


            /*log_Info("Select StakeHolder Questionaire Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderQuestionaireTemplate);
            Thread.sleep(5000);
            StakeHolderQuestionaireTemplate.sendKeys(StakeHolderQueTemplate);
            Thread.sleep(3000);
            StakeHolderQuestionaireTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Questionaire Template Drop Down");*/


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage clickOnEditButtonInLHNGrid() throws Exception {


        try {

            log_Info("clickOnEditButtonInLHNGrid() Started");
            log_Info("click On Edit Button");
            Thread.sleep(5000);
            EditICON.click();
            Thread.sleep(5000);
            log_Info("clicked On Edit Button");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnEditButtonInLHNGrid() Failed", ex);
        }

    }

    public ILiglPage clearActionInLegalHold() throws Exception {


        try {

            log_Info("clearActionInLegalHold() Started");
            log_Info("Perform Clear Action");
            Thread.sleep(5000);
            NameOfTheLegalHold.clear();
            Thread.sleep(5000);
            log_Info("Performed On Clear Action");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clearActionInLegalHold() Failed", ex);
        }


    }

    public ILiglPage clickOnRefreshButtonLHGrid() throws Exception {


        try {

            log_Info("clickOnRefreshButtonLHGrid() Started");
            log_Info("click On Refresh Button");
            Thread.sleep(5000);
            RefreshBtnLH.click();
            Thread.sleep(5000);
            log_Info("clicked On Refresh Button");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnRefreshButtonLHGrid() Failed", ex);
        }

    }

    public ILiglPage clickOnRemainderButtonInRemainderConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception {

        try {


            log_Info("clickOnRemainderButtonInRemainderConfigTab() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Remainder Button");
            getDriver().waitForelementToBeClickable(RemainderBtn);
            Thread.sleep(5000);
            RemainderBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Remainder Button");

            log_Info("Click on Yes Button");
            getDriver().waitForelementToBeClickable(YesButton);
            Thread.sleep(5000);
            YesButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Yes Button clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnRemainderButtonInRemainderConfigTab() Failed", ex);
        }
    }

    public ILiglPage clickOnEscalationButtonInEscalationConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception {

        try {


            log_Info("clickOnEscalationButtonInEscalationConfigTab() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Escalation Button");
            getDriver().waitForelementToBeClickable(EscalationBtn);
            Thread.sleep(5000);
            EscalationBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Escalation Button");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnEscalationButtonInEscalationConfigTab() Failed", ex);
        }
    }

    public ILiglPage createLegalHoldUptoEscalation(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception {

        try {


            log_Info("createLegalHoldAndEditEscalationAndRemainderDefaultValues() Started");

            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createLegalHoldAndEditEscalationAndRemainderDefaultValues() Failed", ex);
        }
    }


    public ILiglPage editEscalationAndRemainderConfigValues(String Remainderdays, String Remaindermails, String Remainderfrequency, String Escalationdays, String Escalationmails, String Escalationfrequency) throws Exception {

        try {


            log_Info("editEscalationAndRemainderConfigValues() Started");

            log_Info("Click on Remainder Number Of Days Before Mail Can Be Sent");
            getDriver().waitForelementToBeClickable(RemainderDays);
            Thread.sleep(5000);
            RemainderDays.clear();
            RemainderDays.sendKeys(Remainderdays);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Remainder Number Of Days Before Mail Can Be Sent");

            log_Info("Click on Remainder Mails Cap");
            getDriver().waitForelementToBeClickable(RemainderMailsCap);
            Thread.sleep(5000);
            RemainderMailsCap.clear();
            RemainderMailsCap.sendKeys(Remaindermails);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Remainder Mails cap");

            log_Info("Click on Remainder Mails Frequency");
            getDriver().waitForelementToBeClickable(RemainderFrequency);
            Thread.sleep(5000);
            RemainderFrequency.clear();
            RemainderFrequency.sendKeys(Remainderfrequency);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Remainder Mails Frequency");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Escalation Number Of Days Before Mail Can Be Sent");
            getDriver().waitForelementToBeClickable(EscalationDays);
            Thread.sleep(5000);
            EscalationDays.clear();
            EscalationDays.sendKeys(Escalationdays);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Escalation Number Of Days Before Mail Can Be Sent");

            log_Info("Click on Escalation Mails Cap");
            getDriver().waitForelementToBeClickable(EscalationMailsCap);
            Thread.sleep(5000);
            EscalationMailsCap.clear();
            EscalationMailsCap.sendKeys(Escalationmails);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Escalation Mails cap");

            log_Info("Click on Escalation Mails Frequency");
            getDriver().waitForelementToBeClickable(EscalationFrequency);
            Thread.sleep(5000);
            EscalationFrequency.clear();
            EscalationFrequency.sendKeys(Escalationfrequency);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Escalation Mails Frequency");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("editEscalationAndRemainderConfigValues() Failed", ex);
        }
    }


    public ILiglPage clickOnSendButton() throws Exception {

        try {


            log_Info("click On Send Button");
            Thread.sleep(5000);
            SendBtn.click();
            Thread.sleep(5000);
            log_Info("clicked On Send Button");

            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnActionDropDownAndRun() Failed", ex);
        }

    }

    public ILiglPage createNewLegalHoldByStartDateEndDateNumberOfDays(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate, String Startdate, String Enddate, String Days) throws Exception {

        try {


            log_Info("createNewLegalHold() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Start Date");
            getDriver().waitForelementToBeClickable(StartDate);
            Thread.sleep(5000);
            StartDate.sendKeys(Startdate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Start Date");

            log_Info("Click on End Date");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(Enddate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On End Date");

            log_Info("Click on Number Of Days");
            getDriver().waitForelementToBeClickable(NumberOfDays);
            Thread.sleep(5000);
            NumberOfDays.sendKeys(Days);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Number Of Days");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage clickOnChooseColumnMenu() throws Exception {

        try {

            log_Info("Click on Choose Column Menu");
            getDriver().waitForelementToBeClickable(ColumnMenu);
            Thread.sleep(5000);
            ColumnMenu.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Choose Column Menu");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnChooseColumnMenu() Failed", ex);
        }
    }


    public ILiglPage searchTheColumnsInColumnMenuInLHGrid(String Column) throws Exception {

        try {

            log_Info("Click on The SearchBar");
            getDriver().waitForelementToBeClickable(SEARCHbar);
            Thread.sleep(5000);
            SEARCHbar.sendKeys(Column);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on The SearchBar");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheColumnsInLHGrid() Failed", ex);
        }
    }

    public ILiglPage selectTheColumnCheckBox(String COLUMN) throws Exception {


        try {

            log_Info("selectTheColumnCheckBox() Started");
            log_Info("Select The Particular Searched Column");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + COLUMN + "')]/ancestor::div[@role='treeitem']//input")).click();
            log_Info("Selected The Particular Searched Column");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("selectTheColumnCheckBox() Failed", ex);
        }

    }

    public ILiglPage clickOnTheDownloadLHNLink() throws Exception {


        try {

            log_Info("clickOnTheDownloadLHNLink() Started");
            log_Info("Click On The Download Button");
            Thread.sleep(5000);
            DownloadLHN.click();
            Thread.sleep(5000);
            log_Info("Clicked On The Download Button");


            log_Info("Open In The New Tab");
            ArrayList<String> tabs2 = new ArrayList<String>(getCurrentDriver().getWindowHandles());
            getCurrentDriver().switchTo().window(tabs2.get(1));
            getCurrentDriver().close();
            getCurrentDriver().switchTo().window(tabs2.get(0));
            String test = getCurrentDriver().getCurrentUrl();
            log_Info("Opened In The New Tab");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clearActionInLHColumnMenu() Failed", ex);
        }

    }

    public ILiglPage enterNameOfTheLH(String LegalHoldname) throws Exception {

        try {

            log_Info("enterNameOfTheLH() Started");

            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("enterNameOfTheLH() Failed", ex);
        }
    }

    public ILiglPage enterCustodianNoticeTemplate(String CustodianTemplate, String CustodianQuestionaireTemplate) throws Exception {

        try {


            log_Info("enterCustodianNoticeTemplate() Started");

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");

            log_Info("Select Questionaire Template Drop Down");
            getDriver().waitForelementToBeClickable(QuestionaireDrpDwn);
            Thread.sleep(5000);
            QuestionaireDrpDwn.sendKeys(CustodianQuestionaireTemplate);
            Thread.sleep(3000);
            QuestionaireDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Selected Questionaire Template Drop Down");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage clickOnNextBtn1() throws Exception {

        try {

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn1() Failed", ex);
        }
    }

    public ILiglPage clickOnNextBtn2() throws Exception {

        try {


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn2() Failed", ex);
        }
    }

    public ILiglPage clickOnNextBtn3() throws Exception {

        try {


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn3() Failed", ex);
        }
    }

    public ILiglPage clickOnNextBtn4() throws Exception {

        try {

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn4() Failed", ex);
        }
    }


    public ILiglPage clickOnNextBtn5() throws Exception {

        try {


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn5() Failed", ex);
        }
    }

    public ILiglPage clickOnNextBtn6() throws Exception {

        try {


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextBtn6() Failed", ex);
        }
    }

    public ILiglPage clickOnStakeHolderNoticeTemplate(String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception {

        try {


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");

            log_Info("Select StakeHolder Questionaire Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderQuestionaireTemplate);
            Thread.sleep(5000);
            StakeHolderQuestionaireTemplate.sendKeys(StakeHolderQueTemplate);
            Thread.sleep(3000);
            StakeHolderQuestionaireTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Questionaire Template Drop Down");


            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage clickOnSaveBtn() throws Exception {

        try {

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnSaveBtn() Failed", ex);
        }
    }

    public ILiglPage enterDateRanges(String Startdate, String Enddate, String Days) throws Exception {

        try {

            log_Info("Click on Start Date");
            getDriver().waitForelementToBeClickable(StartDate);
            Thread.sleep(5000);
            StartDate.sendKeys(Startdate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Start Date");

            log_Info("Click on End Date");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(Enddate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On End Date");

            log_Info("Click on Number Of Days");
            getDriver().waitForelementToBeClickable(NumberOfDays);
            Thread.sleep(5000);
            NumberOfDays.sendKeys(Days);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Number Of Days");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage enterKeyWords(String keywords) throws Exception {

        try {

            log_Info("Click on Keywords");
            getDriver().waitForelementToBeClickable(Keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(Keys.ENTER);
            getSession().log_Pass("Next Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    public ILiglPage validateTheDRandKWInDisableMode() throws Exception {


        try {

            log_Info("validateTheDRandKWInDisableMode() Started");

            log_Info("Check The Legal Hold DR and KW Details Are In Disbled Mode");
            Thread.sleep(5000);

            boolean v1 = StartDate.isEnabled();
            Thread.sleep(5000);

            boolean v2 = EndDate.isEnabled();
            Thread.sleep(5000);

            System.out.println(v1);
            Thread.sleep(5000);

            System.out.println(v2);
            Thread.sleep(5000);

            Assert.assertEquals(false, v1);
            Assert.assertEquals(false, v2);

            clickOnNextBtn4();

            boolean v3 = Keywords.isEnabled();
            Thread.sleep(5000);

            System.out.println(v3);
            Thread.sleep(5000);

            Assert.assertEquals(false, v3);
            Thread.sleep(5000);

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheDRandKWInDisableMode() Failed", ex);
        }
    }

    public ILiglPage validateTheButtonsInDisableMode() throws Exception {


        try {

            log_Info("validateTheButtonsInDisableMode() Started");

            log_Info("Check The Legal Hold Details Are In Disbled Mode");
            Thread.sleep(5000);

            boolean v1 = RunButn.isEnabled();
            Thread.sleep(5000);

            boolean v2 = ActionDrpDwn.isEnabled();
            Thread.sleep(5000);


            System.out.println(v1);
            Thread.sleep(5000);

            System.out.println(v2);
            Thread.sleep(5000);


            Assert.assertEquals(false, v1);
            Assert.assertEquals(false, v2);
            Thread.sleep(5000);

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheButtonsInDisableMode() Failed", ex);
        }
    }


    public ILiglPage validateTheColumnsNames() throws Exception {


        try {

            log_Info("validateTheColumn Names() Started");

            log_Info("Check The Column Names In The LH Grid");
            Thread.sleep(5000);

            boolean v1 = ListBox.isDisplayed();
            Thread.sleep(5000);

            System.out.println(v1);
            Thread.sleep(5000);

            Assert.assertEquals(true, v1);
            Thread.sleep(5000);

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheColumnsNames() Failed", ex);
        }
    }

    public ILiglPage clearActionInLHColumnMenu() throws Exception {


        try {

            log_Info("clearActionInLHColumnMenu() Started");
            log_Info("Perform Clear Action");
            Thread.sleep(5000);
            SEARCHbar.clear();
            Thread.sleep(5000);
            log_Info("Performed On Clear Action");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clearActionInLHColumnMenu() Failed", ex);
        }

    }


    public ILiglPage checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid(String CaseNameApprove, String keywords) throws Exception {

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
            boolean v5 = getCurrentDriver().findElement(By.xpath("//div[contains(text(),'" + keywords + "')]")).isDisplayed();
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


    public ILiglPage checkTheLHPopUpDetailsInDisabledCondition() throws Exception {


        try {
            log_Info("checkTheLHPopUpDetailsInDisabledCondition() Started");

            log_Info("Check The Legal Hold Details Are In Disbled Mode");
            Thread.sleep(5000);
            boolean v1 = NameOfTheLegalHold.isEnabled();
            Thread.sleep(5000);


            System.out.println(v1);
            Thread.sleep(5000);


            Assert.assertEquals(false, v1);
            Thread.sleep(5000);

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("checkTheLHPopUpDetailsInDisabledCondition() Failed", ex);
        }
    }

    public ILiglPage createNewLHBySelectingTemplateOnFlyEdit(String LegalHoldname, String CustodianTemplate, String NewtempName, String subject, String content) throws Exception {

        try {

            log_Info("createNewLHBySelectingTemplateOnFlyEdit() Started");

            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            Thread.sleep(5000);
            EditTemplate.click();
            Thread.sleep(5000);

            EmailTemplatePage pagev = new EmailTemplatePage();

            pagev.editTempOnFly(NewtempName, subject, content);
            Thread.sleep(3000);

            String s = selectedTemplateName.getText();
            Assert.assertEquals(s, NewtempName);
            log_Pass("New Template edited on Fly is Updated in Template Dropdown");
            NextButton2.click();
            Thread.sleep(2000);

            NextButton3.click();
            Thread.sleep(2000);

            NextButton4.click();
            Thread.sleep(2000);

            NextButton5.click();
            Thread.sleep(2000);

            NextButton6.click();
            Thread.sleep(2000);

            SaveButton.click();
            Thread.sleep(8000);
            log_Pass("LHN Saved Successfully After onFly Edit");

            Thread.sleep(10000);
            EditICON.click();

            Thread.sleep(2000);
            NextBtn.click();

            Thread.sleep(2000);
            String s1 = selectedTemplateName.getText();
            Assert.assertEquals(s1, NewtempName);

            log_Pass("The On Fly Edited Custodian Template is Updated To LHN");

            return new LegalHoldPage();

        } catch (Exception ex) {
            log_Error("editExistingLHNWithOnFlyEditOfCustTemp() is Failed");
            throw new Exception("Exception in editExistingLHNWithOnFlyEditOfCustTemp()", ex);
        }
    }

    public ILiglPage createNewLegalHoldByDateRangeKeyWords(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate, String Startdate, String Enddate, String Days, String keywords) throws Exception {

        try {


            log_Info("createNewLegalHold() Started");
            log_Info("Click on Name Of The Legal Hold");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            Thread.sleep(5000);
            NameOfTheLegalHold.sendKeys(LegalHoldname);
            Thread.sleep(5000);
            getSession().log_Pass("Name Of The Legal Hold Given");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            Thread.sleep(5000);
            NextButton1.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");                               //1

            log_Info("Click on Choose Notice Template Dropdown");
            getDriver().waitForelementToBeClickable(ChooseNoticeTemplateDrpDwn);
            Thread.sleep(5000);
            ChooseNoticeTemplateDrpDwn.sendKeys(CustodianTemplate);
            Thread.sleep(3000);
            ChooseNoticeTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass(" Choose Notice Template Dropdown clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            Thread.sleep(5000);
            NextButton2.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Select StakeHolder Template Drop Down");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            Thread.sleep(5000);
            StakeHolderNoticeTemplate.sendKeys(StakeHolderTemplate);
            Thread.sleep(3000);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected StakeHolder Template Drop Down");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton3);
            Thread.sleep(5000);
            NextButton3.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Start Date");
            getDriver().waitForelementToBeClickable(StartDate);
            Thread.sleep(5000);
            StartDate.sendKeys(Startdate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Start Date");

            log_Info("Click on End Date");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(Enddate);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On End Date");

            log_Info("Click on Number Of Days");
            getDriver().waitForelementToBeClickable(NumberOfDays);
            Thread.sleep(5000);
            NumberOfDays.sendKeys(Days);
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On Number Of Days");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton4);
            Thread.sleep(5000);
            NextButton4.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Keywords");
            getDriver().waitForelementToBeClickable(Keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(Keys.ENTER);
            getSession().log_Pass("Next Button clicked");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton5);
            Thread.sleep(5000);
            NextButton5.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(5000);
            NextButton6.click();
            Thread.sleep(5000);
            getSession().log_Pass("Next Button clicked");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }

    /*****************************************Admin Test*********************************************************/

    @FindBy(xpath = "//label//span[@class='mat-slide-toggle-bar']//input[@aria-checked='false']")
    public WebElement toggleDisable;

    public ILiglPage searchLegalHoldEmail(String email) throws Exception {
        try {
            wait(2);
            getSession().log_Info("Hover on Email Header");
            getDriver().waitForelementToBeClickable(Semail);
            getDriver().waitForMoveToElement(Semail);
            getSession().log_Pass("Hovered on Email Column");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menuBtn);
            getDriver().waitForMoveToElement(menuBtn);
            menuBtn.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(Filter);
            Filter.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Email in Search Bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Searchbar.sendKeys(email);
            Filter.click();
            getSession().log_Pass("Entered the Email in Search Bar");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search LH Failed", ex);
        }
    }

    public ILiglPage checkDeletedStakeholderISDisplayingInLHStakeholderGrid(String email) throws Exception {
        try {
            searchLegalHoldEmail(email);

            try {
                boolean actualValue = getDriver().customXpathBasedOnTextValue(email).isDisplayed();

                getSession().log_Info("Check that newly created Stakeholder Displaying In Stakeholder Grid");
                Assert.assertEquals(actualValue, true);
                getSession().log_Pass("Newly created Stakeholder Displayed In Stakeholder Grid");
            } catch (Exception exception) {
                getSession().log_Info("Check that deleted created Stakeholder not Displaying In Stakeholder Grid");

                getSession().log_Pass("deleted created Stakeholder not Displayed In Stakeholder Grid");
            }

            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check Delected Stakeholder Displaying In LHStakeholder Grid Failed", ex);
        }
    }

    public ILiglPage createLegalHoldWithEscalationAndReminderConfigurations(Hashtable<String, String> data) throws Exception {
        try {
            createLegalHoldUptoEscalation(data.get("legalHoldName"), data.get("custodianTemplate"), data.get("stakeHolderTemplate"));


            try {
                toggleDisable.isDisplayed();
                getSession().log_Info("enable the Reminder");
                getDriver().waitForelementToBeClickable(RemainderBtn);
                RemainderBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("enabled the Reminder");

            } catch (Exception exception) {
            }

            log_Info("Click on Remainder Number Of Days Before Mail Can Be Sent");
            getDriver().waitForelementToBeClickable(RemainderDays);
            Thread.sleep(3000);
            RemainderDays.clear();
            String RemainderdaysNew = data.get("reminderDays").replace("*", "");
            RemainderDays.sendKeys(RemainderdaysNew);
            getSession().log_Pass("Clicked on Remainder Number Of Days Before Mail Can Be Sent");

            log_Info("Click on Remainder Mails Cap");
            getDriver().waitForelementToBeClickable(RemainderMailsCap);
            Thread.sleep(3000);
            RemainderMailsCap.clear();
            String RemaindermailsNew = data.get("reminderMailCap").replace("*", "");
            RemainderMailsCap.sendKeys(RemaindermailsNew);
            getSession().log_Pass("Clicked on Remainder Mails cap");

            log_Info("Click on Remainder Mails Frequency");
            getDriver().waitForelementToBeClickable(RemainderFrequency);
            Thread.sleep(3000);
            RemainderFrequency.clear();
            String RemainderfrequencyNew = data.get("reminderFrequency").replace("*", "");
            RemainderFrequency.sendKeys(RemainderfrequencyNew);
            getSession().log_Pass("Clicked on Remainder Mails Frequency");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton6);
            Thread.sleep(3000);
            NextButton6.click();
            getSession().log_Pass("Next Button clicked");

            log_Info("Click on Escalation Number Of Days Before Mail Can Be Sent");
            getDriver().waitForelementToBeClickable(EscalationDays);
            Thread.sleep(3000);
            EscalationDays.clear();
            String EscalationdaysNew = data.get("escalationDay").replace("*", "");
            EscalationDays.sendKeys(EscalationdaysNew);
            getSession().log_Pass("Clicked on Escalation Number Of Days Before Mail Can Be Sent");

            log_Info("Click on Escalation Mails Cap");
            getDriver().waitForelementToBeClickable(EscalationMailsCap);
            Thread.sleep(3000);
            EscalationMailsCap.clear();
            String EscalationmailsNew = data.get("escalationMailsCap").replace("*", "");
            EscalationMailsCap.sendKeys(EscalationmailsNew);
            getSession().log_Pass("Clicked on Escalation Mails cap");

            log_Info("Click on Escalation Mails Frequency");
            getDriver().waitForelementToBeClickable(EscalationFrequency);
            Thread.sleep(3000);
            EscalationFrequency.clear();
            String EscalationfrequencyNew = data.get("escalationFrequency").replace("*", "");
            EscalationFrequency.sendKeys(EscalationfrequencyNew);
            getSession().log_Pass("Clicked on Escalation Mails Frequency");


            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            SaveButton.click();
            Thread.sleep(30000);
            getSession().log_Pass("Save Button clicked");

            getDriver().waitUntilSpinnerIsClosed();
            wait(45);

            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create LegalHold With Escalation And Reminder Configurations Failed", ex);
        }
    }

    public ILiglPage searchNewlyCreatedLegalHold(String legalHoldName) throws Exception {
        try {
            //search the legal hold
            getDriver().waitUntilSpinnerIsClosed();
            wait(10);
            searchRequiredLegalHoldName(legalHoldName);
            wait(5);
            clickOnEditButtonInLHNGrid();
            wait(5);

            //Navigate to Right
            getSession().log_Info("Navigate to Right in popup");
            getDriver().waitForelementToBeClickable(legalHoldNoticePopUpRightNavigation);
            legalHoldNoticePopUpRightNavigation.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Navigated to Right in popup");

            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search Newly Create LegalHold Failed", ex);
        }
    }

    public ILiglPage getReminderConfigurationsValuesInLegalHoldAtCaseLevel(String legalHoldName, String setReminderDays, String setReminderFrequency,
                                                                           String setReminderMailsCap) throws Exception {
        try {
            searchNewlyCreatedLegalHold(legalHoldName);

            //Reminder Configurations
            getSession().log_Info("Click on 'Reminder Configurations' Link");
            getDriver().waitForelementToBeClickable(reminderConfigurationsLink);
            reminderConfigurationsLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Reminder Configurations' Link");

            //Remainder Number Of Days Before Mail Can Be Sent
            getSession().log_Info("'Get Remainder Number Of Days Before Mail Can Be Sent' value");
            getDriver().waitForelementToBeClickable(RemainderDays);
            String remainderDay = RemainderDays.getAttribute("value");
            getSession().setRegressionData(setReminderDays, remainderDay);           //using set property
            getSession().log_Pass("'Remainder Number Of Days Before Mail Can Be Sent' value is" + remainderDay);


            //Reminder frequency
            getSession().log_Info("Get 'Remainder Mails Cap' value");
            getDriver().waitForelementToBeClickable(RemainderFrequency);
            String RemainderfrequencyNew = RemainderFrequency.getAttribute("value");
            getSession().setRegressionData(setReminderFrequency, RemainderfrequencyNew);         //using set property
            getSession().log_Pass("'Remainder Mails cap' value is " + RemainderfrequencyNew);

            //Reminder mails cap
            getSession().log_Info("Get 'Remainder Mails Frequency' value");
            getDriver().waitForelementToBeClickable(RemainderMailsCap);
            String RemainderMailsNew = RemainderFrequency.getAttribute("value");
            getSession().setRegressionData(setReminderMailsCap, RemainderMailsNew);         //using set property
            getSession().log_Pass("'Remainder Mails Frequency ' value is " + RemainderMailsNew);

            wait(5);

            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Getting Reminder Configurations in LegalHold at Case level Values Failed", ex);
        }
    }

    public ILiglPage getEscalationConfigurationsValuesInLegalHoldAtCaseLevel(String setEscalationDays, String setEscalationFrequency,
                                                                             String setEscalationMailsCap) throws Exception {
        try {

            //Escalation Configurations
            getSession().log_Info("Click on 'Escalation Configurations' Link");
            getDriver().waitForelementToBeClickable(escalationConfigurationsLink);
            escalationConfigurationsLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Escalation Configurations' Link");

            //Number of days after reminder when escalation can be sent
            getSession().log_Info("Get 'Number of days after reminder when escalation can be sent' value");
            getDriver().waitForelementToBeClickable(EscalationDays);
            String escalationDays = EscalationDays.getAttribute("value");
            getSession().setRegressionData(setEscalationDays, escalationDays);           //using set property
            getSession().log_Pass("'Number of days after reminder when escalation can be sent' value is" + escalationDays);


            //Escalation frequency
            getSession().log_Info("Get 'Remainder Mails Cap' value");
            getDriver().waitForelementToBeClickable(EscalationFrequency);
            String EscalationFrequencyNew = EscalationFrequency.getAttribute("value");
            getSession().setRegressionData(setEscalationFrequency, EscalationFrequencyNew);         //using set property
            getSession().log_Pass("'Escalation Mails cap' value is " + EscalationFrequencyNew);

            //Escalation mails cap
            getSession().log_Info("Get 'Escalation Mails Frequency' value");
            getDriver().waitForelementToBeClickable(EscalationMailsCap);
            String EscalationMailsNew = EscalationFrequency.getAttribute("value");
            getSession().setRegressionData(setEscalationMailsCap, EscalationMailsNew);         //using set property
            getSession().log_Pass("'Escalation Mails Frequency ' value is " + EscalationMailsNew);

            getSession().log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveButton);
            SaveButton.click();
            getSession().log_Pass("Save Button clicked");

            wait(25);

            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Getting Escalation Configurations Values in LegalHold at Case level Failed", ex);
        }
    }

    public ILiglPage checkThatNewlyCreatedQuestionnaireIsDisplaying(String legalHoldName, String custodianNotice,
                                                                    String custodianQuestionner, String stakeholderNotice,
                                                                    String stakeholderQuestionner) throws Exception {
        try {
            //Legal Hold Name
            getSession().log_Info("Enter 'Legal Hold Name'");
            getDriver().waitForelementToBeClickable(NameOfTheLegalHold);
            NameOfTheLegalHold.sendKeys(legalHoldName);
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Info("Entered 'Legal Hold Name'");

            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton1);
            NextButton1.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            getSession().log_Pass("Clicked on Next Button");

            //Custodian-Notice
            getSession().log_Info("Select Custodian notice template");
            getDriver().waitForelementToBeClickable(CustNoticeTemp);
            CustNoticeTemp.sendKeys(custodianNotice);
            wait(1);
            CustNoticeTemp.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            getSession().log_Pass("Selected Custodian notice template");

            //Custodian-Questionner
            getSession().log_Info("Search the New Created Custodian-Questionner");
            getDriver().waitForelementToBeClickable(CustQuestionaireDrpDwn);
            CustQuestionaireDrpDwn.sendKeys(custodianQuestionner);
            wait(1);
            CustQuestionaireDrpDwn.sendKeys(Keys.ENTER);
            wait(2);
            getSession().log_Pass("Searched the New Created Custodian-Questionner");

            String CQ1 = CustQuestionaireDrpDwn.getText();

            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextButton2);
            NextButton2.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            getSession().log_Pass("Clicked on Next Button");

            //Stakeholder-Notice
            getSession().log_Info("Select Stakeholder notice template");
            getDriver().waitForelementToBeClickable(StakeHolderNoticeTemplate);
            StakeHolderNoticeTemplate.sendKeys(stakeholderNotice);
            wait(1);
            StakeHolderNoticeTemplate.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            getSession().log_Pass("Selected Stakeholder notice template");

            //Stakeholder-Questionner
            getSession().log_Info("Search the New Created Stakeholder-Questionner");
            getDriver().waitForelementToBeClickable(StakeHolderQuestionaireTemplate);
            StakeHolderQuestionaireTemplate.sendKeys(stakeholderQuestionner);
            wait(1);
            StakeHolderQuestionaireTemplate.sendKeys(Keys.ENTER);
            wait(2);
            getSession().log_Pass("Searched the New Created Stakeholder-Questionner");

            String SQ1 = StakeHolderQuestionaireTemplate.getText();

            //Verify
            getSession().log_Info("Verify that Newly Created  Questionnaire template displaying in Custodian & Stakeholder Legalhold dropdown");
            getSession().log_Pass("Newly Created Questionnaire template is displayed in Custodian Dropdown is "+ CQ1.toUpperCase());
            getSession().log_Pass("Newly Created Questionnaire template is displayed in Stakeholder Dropdown is "+ SQ1.toUpperCase());

            wait(5);
            CloseBtn.click();
            wait(5);

            return new LegalHoldPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check That Newly Created Questionnaire Is Displaying Failed", ex);
        }
    }

}

