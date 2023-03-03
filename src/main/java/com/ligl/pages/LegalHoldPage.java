package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.administration.EmployeeMasterPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.pages.datamanagement.DMCollectionsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class LegalHoldPage extends LiglBasePage {

    @FindBy(id = "adddoc-btn")
    WebElement AddLegalHoldBtn;

    @FindBy(id = "lhc-legal-hold-name")
    WebElement NameOfTheLegalHold;

    @FindBy(id = "btn-nextlhnTemp")
    WebElement NextBtn;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement SaveBtn;

    @FindBy(id = "lhcNoticeTemplateLHNCustodianTemplateUniqueID")
    WebElement ChooseNoticeTemplateDrpDwn;

    @FindBy(id = "Choose a questionnairelhc-custodian-ques-templateCustodianQuestionnaireTemplateUniqueID")
    WebElement QuestionaireDrpDwn;


    @FindBy(xpath = "//span[@title='LHNLIGLv']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement LegalHoldName;

    @FindBy(id = "lhncustActions")
    WebElement SelectActionDrpDwn;

    @FindBy(id = "modelaction-btn")
    WebElement RunBtn;

    @FindBy(id = "template-name")
    WebElement SelectEmailTemplateDrpDwn;

    @FindBy(id = "select-approver")
    WebElement SelectApprovalDrpDwn;

    @FindBy(id = "send-approval-btn")
    WebElement SendForApproveBtn;


    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(css = "span[class='ag-header-icon ag-header-cell-menu-button']")
    WebElement CNMenu;

    @FindBy(xpath = "//section[@class='legalholdNotice']//div[contains(text(),'No data available...')]")
    WebElement NoDataAvailable;

    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]")
    WebElement LHNAME;

    @FindBy(xpath = "//span[contains(text(),'Legal Hold Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement LHNameMenu;


    // Headers In The LHN Custodian Grid

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

    @FindBy(id = "user-button")
    WebElement StakeholderBtn;

    // Headers In The StakeHolder Grid

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


    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement EmpMail;

    @FindBy(xpath = "//button[@title='Questionnaire Response']")
    WebElement ResponseFile;

    @FindBy(id = "lhncustActions")
    WebElement ActionDrpDwn;

    @FindBy(id = "modelaction-btn")
    WebElement RunButn;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OKBTN;

    @FindBy(xpath = "//p[contains(text(),'Only Not-initiated records can be selected')]")
    WebElement AlertMessage;

    @FindBy(id = "lhns-actions")
    WebElement ActionDrpDwnStakeHolder;

    @FindBy(id = "lhns-modelaction-btn")
    WebElement RunButton;

    @FindBy(id = "lhncust-refreshGrid")
    WebElement RefreshBtnCustodian;

    @FindBy(id = "lhnconfigutaion-refreshGrid")
    WebElement RefreshBtnLH;

    @FindBy(id = "lhns-grid-refresh")
    WebElement RefreshBtnStakeHolder;

    @FindBy(id = "lhnr-rel-template")
    WebElement CustodianReleaseTemplate;

    @FindBy(id = "lhnr-savecase-btn")
    WebElement CustodianTemplateSendBtn;

    @FindBy(id = "lhc-notice-template-selectionLHNStakeHolderTemplateUniqueID")
    WebElement StakeHolderNoticeTemplate;

    @FindBy(id = "Choose a questionnairelhc-stakeholder-questionnaireStakeHolderQuestionnaireTemplateUniqueID")
    WebElement StakeHolderQuestionaireTemplate;

    @FindBy(id = "legal-hold-case-document-btn")
    WebElement NextButton1;

    @FindBy(id = "legal-hold-configuration-btn")
    WebElement NextButton2;

    @FindBy(id = "legal-hold-case-document-next-btn")
    WebElement NextButton3;

    @FindBy(id = "legal-hold-conguration-component-btn")
    WebElement NextButton4;

    @FindBy(id = "legal-hold-configuration-backlhnName-btn")
    WebElement NextButton5;

    @FindBy(id = "legal-hold-configuration-primary-btn")
    WebElement NextButton6;

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

    @FindBy(id = "reminder-frequency-legalhold")
    WebElement RemainderFrequency;

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

    @FindBy(id = "lhc-enddate")
    WebElement EndDate;

    @FindBy(id = "lhc-no-of-days")
    WebElement NumberOfDays;

    @FindBy(xpath = "//textarea[@name='Keywords']")
    WebElement Keywords;


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
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredLegalHoldName() Failed", ex);
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

    }

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

    public ILiglPage switchOnToTheStakeHolderTab() throws Exception {


        try {

            log_Info("switchOnToTheStakeHolderTab() Started");
            log_Info("click On The Stakeholder Button");
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
            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnActionDropDownAndRun() Failed", ex);
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

    public ILiglPage validateRecordWhenLHNStatusIsInNotintiatedState(String status) throws Exception {

        try {


            log_Info("validateRecordWhenLHNStatusIsInNotintiatedState() Started");
            var wait = new WebDriverWait(getCurrentDriver(), 30);
            var div = wait.until(ExpectedConditions.visibilityOf(AlertMessage));
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

    public ILiglPage clickOnRefreshButton() throws Exception {


        try {

            log_Info("clickOnRefreshButton() Started");
            log_Info("click On Refresh Button");
            Thread.sleep(5000);
            RefreshBtnCustodian.click();
            Thread.sleep(5000);
            log_Info("clicked On Refresh Button");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickActionOnResponseDocument() Failed", ex);
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
            throw new Exception("clickActionOnResponseDocument() Failed", ex);
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


    // Creating New Legal Hold In The Legal Hold Page

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
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");
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
            getDriver().waitForelementToBeClickable(SaveBtn);
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
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");
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

    public ILiglPage editEscalationAndRemainderConfigValues(String Remainderdays, String Remaindermails, String Remainderfrequency,String Escalationdays, String Escalationmails, String Escalationfrequency) throws Exception {

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
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");

            return new LegalHoldPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("editEscalationAndRemainderConfigValues() Failed", ex);
        }
    }

    public ILiglPage createNewLegalHoldByStartDateEndDateNumberOfDays(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days) throws Exception {

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
            StartDate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Start Date");

            log_Info("Click on End Date");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(Enddate);
            Thread.sleep(5000);
            EndDate.sendKeys(Keys.ENTER);
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
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
        }
    }
    public ILiglPage createNewLegalHoldByDateRangeKeyWords(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days,String keywords) throws Exception {

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
            StartDate.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Start Date");

            log_Info("Click on End Date");
            getDriver().waitForelementToBeClickable(EndDate);
            Thread.sleep(5000);
            EndDate.sendKeys(Enddate);
            Thread.sleep(5000);
            EndDate.sendKeys(Keys.ENTER);
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
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(3000);
            SaveButton.click();
            Thread.sleep(5000);
            getSession().log_Pass("Save Button clicked");
            return new LegalHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewLegalHold() Failed", ex);
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

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkTheLHPopUpDetailsInDisabledCondition() Failed",ex);
        }
    }
}







