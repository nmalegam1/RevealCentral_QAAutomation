package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.swing.text.View;

public class GlobalRequestPage extends LiglBaseSessionPage{


    @FindBy(id = "req-add-request-btn")
    public WebElement requestBtn;

    @FindBy(xpath = "//mat-select[@id='req-type-dpdwn']")
    public WebElement reqTypeDrpDwn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement drpDwnSearchBar;

    @FindBy(css = "#addreq-back-btn")
    public WebElement backToReqBtn;

    @FindBy(xpath = "//mat-select[@id='case']")
    WebElement ChooseACaseDrpDwn;


    @FindBy(id = "request-title")
    WebElement RequestTitle;

    @FindBy(xpath = "//mat-select[@id='assignee']")
    WebElement ChooseUser;

    @FindBy(id = "req-priority")
    WebElement PriorityDrpDwn;

    @FindBy(id = "req-completedby")
    WebElement CompletedBy;

    @FindBy(xpath = "//ckeditor[@id='add-info-text-box']//div[@role='textbox']")
    WebElement AdditionalTextArea;

    @FindBy(xpath = "//ckeditor[@name='body']//div[@role='textbox']//p")
    WebElement AdditionalMessage;

    @FindBy(id= "addreq-save-btn")
    WebElement ReqSaveBtn;

    @FindBy(id = "add-view-requests-save-btn")
    WebElement PostMessageBtn;

    @FindBy(xpath = "//button[contains(text(),'Ok')]")
    WebElement OKbutton;

    @FindBy(xpath = "//span[contains(text(),'Request ID')]")
    WebElement Column1;

    @FindBy(xpath = "//span[contains(text(),'Request Type')]")
    WebElement Column2;

    @FindBy(xpath = "//span[contains(text(),'Title')]")
    WebElement Column3;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]")
    WebElement Column4;

    @FindBy(xpath = "//span[contains(text(),'Status')]")
    WebElement Column5;

    @FindBy(xpath = "//span[contains(text(),'Priority')]")
    WebElement Column6;

    @FindBy(xpath = "//span[contains(text(),'Assigned Type')]")
    WebElement Column7;

    @FindBy(xpath = "//span[contains(text(),'Assigned to')]")
    WebElement Column8;

    @FindBy(xpath = "//button[@title='Edit']")
    WebElement EditIcon;

    @FindBy(id = "req-sttus")
    WebElement StatusDrpDwn;

    @FindBy(xpath = "//button[@title='View']")
    WebElement ViewBtn;

    @FindBy(id = "role-opt")
    WebElement RoleRadioBtn;

    @FindBy(id = "back-btn-add-view-requests")
    WebElement BackToReqBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//span[contains(text(),'Title')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement TitleMenu;


    @FindBy(xpath = "//app-custom-stats//div//div[1]//div[@class='stats-count']")
    WebElement TotalCount;

    @FindBy(xpath = "//app-custom-stats//div//div[2]//div[@class='stats-count']")
    WebElement NewCount;

    @FindBy(xpath = "//app-custom-stats//div//div[3]//div[@class='stats-count']")
    WebElement InprogressCount;

    @FindBy(xpath = "//app-custom-stats//div//div[4]//div[@class='stats-count']")
    WebElement ClosedCount;

    @FindBy(xpath = "//div[contains(text(),'No matching found')]")
    WebElement NoMatchingFound;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement SearchBarDropdown;




    /**
     * TC54560 Admin-LookUp-Requests-Check whether the lookup value is populated in create request pop up in Global requests
     */

    public ILiglPage checkNewlyCreatedLookupPopulatedInRequestTypeDropDown(String requestType) throws Exception{
        try {
            //Request Button
            getSession().log_Info("Click On '+Request' Button");
            getDriver().waitForelementToBeClickable(requestBtn);
            requestBtn.click();
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On '+Request' Button");

            //Request Type
            getSession().log_Info("Click On 'Request Type' Drop Down");
            getDriver().waitForelementToBeClickable(reqTypeDrpDwn);
            reqTypeDrpDwn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Request Type' Drop Down");

            getSession().log_Info("Enter request type");
            drpDwnSearchBar.sendKeys(requestType);
            wait(2);
            getSession().log_Pass("Entered request type");

            getSession().log_Info("Check Lookup Populated In 'RequestType' DropDown");
            String reqTypeText = getCurrentDriver().findElement(By.xpath("//span[normalize-space()='"+requestType+"']")).getText();
            Assert.assertEquals(reqTypeText, requestType);
            getSession().log_Pass("Lookup Populated In 'RequestType' DropDown");

            //Back To Request Button
            getSession().log_Info("Click On  'Back to Requests' Button");
            getDriver().scrollToView(backToReqBtn);
            getDriver().waitForelementToBeClickable(backToReqBtn);
            backToReqBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getCurrentDriver().findElement(By.xpath("//button[text()='Ok']")).click();
            getSession().log_Pass("Clicked On  'Back to Requests' Button");

            wait(4);

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("Check Lookup Populated In Request Type DropDown Failed", ex);
        }
    }

    public ILiglPage clickOnAddRequestButton() throws Exception{

        try {

            getSession().log_Info("Click On Add Request Button");
            getDriver().waitForelementToBeClickable(requestBtn);
            Thread.sleep(5000);
            requestBtn.click();
            getDriver().waitForElementLoad();
            getSession().log_Pass("Clicked On Add Request Button");


            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnAddRequestButton() Failed ", ex);
        }
    }

    public ILiglPage addAllDetailsInTheAddRequestPopUp(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{

        try {

            getSession().log_Info("Click On 'Request Type' Drop Down");
            getDriver().waitForelementToBeClickable(reqTypeDrpDwn);
            getDriver().waitForAngularRequestsToComplete();
            reqTypeDrpDwn.sendKeys(RequestType);
            Thread.sleep(3000);
            reqTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On 'Request Type' Drop Down");

            getSession().log_Info("Click On Request Title Text Box");
            getDriver().waitForelementToBeClickable(RequestTitle);
            getDriver().waitForAngularRequestsToComplete();
            RequestTitle.sendKeys(REQTitle);
            getSession().log_Pass("Clicked On Request Title Text Box");

            getSession().log_Info("Click On The Choose A Case Drop Down");
            getDriver().waitForelementToBeClickable(ChooseACaseDrpDwn);
            getDriver().waitForAngularRequestsToComplete();
            ChooseACaseDrpDwn.sendKeys(CaseDropDown);
            Thread.sleep(3000);
            ChooseACaseDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On The Choose A Case Drop Down");

            getSession().log_Info("Click On The Choose A User Drop Down");
            getDriver().waitForelementToBeClickable(ChooseUser);
            getDriver().waitForAngularRequestsToComplete();
            ChooseUser.sendKeys(UserDropDown);
            Thread.sleep(3000);
            ChooseUser.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On The Choose A User Drop Down");

            getSession().log_Info("Click On The Priority Drop Down");
            getDriver().waitForelementToBeClickable(PriorityDrpDwn);
            getDriver().waitForAngularRequestsToComplete();
            PriorityDrpDwn.sendKeys(PriorityDropDown);
            Thread.sleep(3000);
            PriorityDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On The Priority Drop Down");

            getSession().log_Info("Click On The Completed By Date");
            getDriver().waitForelementToBeClickable(CompletedBy);
            getDriver().waitForAngularRequestsToComplete();
            CompletedBy.click();
            CompletedBy.sendKeys(Keys.ESCAPE);
            Thread.sleep(3000);
            CompletedBy.sendKeys(CompleteDate);
            getSession().log_Pass("Clicked On The Completed By Date");

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalTextArea);
            getDriver().waitForAngularRequestsToComplete();
            AdditionalTextArea.sendKeys(TextBoxArea);
            getSession().log_Pass("Clicked On The Additional Area");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);",ReqSaveBtn);

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(ReqSaveBtn);
            getDriver().waitForAngularRequestsToComplete();
            ReqSaveBtn.click();
            getSession().log_Pass("Clicked On The Save Button");

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            OKbutton.click();
            getSession().log_Pass("Clicked On Button Button");
            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addAllDetailsInTheAddRequestPopUp() Failed ", ex);
        }
    }


    public ILiglPage validateCreatedRequestInTheGlobalRequestGrid(String TITLE) throws Exception{

        try {

            log_Info("Validate The Request In The Grid");

            Thread.sleep(5000);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//div[@col-id='GeneralDetails.Title']//span[contains(text(),'"+TITLE+"')]")).isDisplayed();

            System.out.println(a1);

            Thread.sleep(5000);
            Assert.assertEquals(true, a1);

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateCreatedRequestInTheGlobalRequestGrid() Failed ", ex);
        }
    }

    public ILiglPage validateListOfColumnsInTheRequestPage() throws Exception{

        try {

            log_Info("Validate The Request In The Grid");

            Thread.sleep(5000);
            boolean a1 = Column1.isDisplayed();
            boolean a2 = Column2.isDisplayed();
           // boolean a3 = Column3.isDisplayed();
            boolean a4 = Column4.isDisplayed();
            boolean a5 = Column5.isDisplayed();
            boolean a6 = Column6.isDisplayed();
            boolean a7 = Column7.isDisplayed();
            boolean a8 = Column8.isDisplayed();

            Thread.sleep(5000);
            System.out.println(a1);
            System.out.println(a2);
            //System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);



            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
           // Assert.assertEquals(true, a3);
            Assert.assertEquals(true, a4);
            Assert.assertEquals(true, a5);
            Assert.assertEquals(true, a6);
            Assert.assertEquals(true, a7);
            Assert.assertEquals(true, a8);



            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateListOfColumnsInTheRequestPage() Failed ", ex);
        }
    }


    public ILiglPage addAllDetailsInTheAddRequestPopUpWithoutAssignee(String RequestType,String REQTitle,String CaseDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{

        try {

            getSession().log_Info("Click On 'Request Type' Drop Down");
            getDriver().waitForelementToBeClickable(reqTypeDrpDwn);
            Thread.sleep(5000);
            reqTypeDrpDwn.sendKeys(RequestType);
            Thread.sleep(5000);
            reqTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Request Type' Drop Down");

            getSession().log_Info("Click On Request Title Text Box");
            getDriver().waitForelementToBeClickable(RequestTitle);
            RequestTitle.sendKeys(REQTitle);
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Request Title Text Box");

            getSession().log_Info("Click On The Choose A Case Drop Down");
            getDriver().waitForelementToBeClickable(ChooseACaseDrpDwn);
            ChooseACaseDrpDwn.sendKeys(CaseDropDown);
            Thread.sleep(5000);
            ChooseACaseDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Choose A Case Drop Down");

            getSession().log_Info("Click On The Priority Drop Down");
            getDriver().waitForelementToBeClickable(PriorityDrpDwn);
            PriorityDrpDwn.sendKeys(PriorityDropDown);
            Thread.sleep(5000);
            PriorityDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Priority Drop Down");

            getSession().log_Info("Click On The Completed By");
            getDriver().waitForelementToBeClickable(CompletedBy);
            Thread.sleep(5000);
            CompletedBy.sendKeys(CompleteDate);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Completed By");

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalTextArea);
            Thread.sleep(5000);
            AdditionalTextArea.sendKeys(TextBoxArea);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Additional Area");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReqSaveBtn);

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(ReqSaveBtn);
            Thread.sleep(5000);
            ReqSaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Save Button");

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            Thread.sleep(5000);
            OKbutton.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Button Button");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addAllDetailsInTheAddRequestPopUp() Failed ", ex);
        }
    }

    public ILiglPage clickOnEditIconInTheGrid(String TITLE) throws Exception{

        try{

            log_Info("clickOnEditIconInTheGrid() Started");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[@col-id='GeneralDetails.Title']//span[contains(text(),'"+TITLE+"')]")).click();
            Thread.sleep(5000);

            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 10; i++) {

                ac.sendKeys(Keys.TAB).perform();
            }

            getSession().log_Info("Click On The Edit Icon");
            getDriver().waitForelementToBeClickable(EditIcon);
            Thread.sleep(5000);
            EditIcon.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Edit Icon");

            return new GlobalRequestPage();

        }catch (Exception ex){
            log_Error("clickOnEditIconInTheGrid() is Failed");
            throw new Exception("Exception in clickOnEditIconInTheGrid()");
        }
    }

    public ILiglPage addMessageWhenReqIsInProgress(String TextBoxArea) throws Exception{

        try {


            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReqSaveBtn);

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalTextArea);
            Thread.sleep(5000);
            AdditionalTextArea.sendKeys(TextBoxArea);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Additional Area");

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(ReqSaveBtn);
            Thread.sleep(5000);
            ReqSaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Save Button");

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            Thread.sleep(5000);
            OKbutton.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Button Button");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addAllDetailsInTheAddRequestPopUp() Failed ", ex);
        }
    }

    public ILiglPage moveToTheParticularColumn(String TITLE) throws Exception{

        try{

            log_Info("moveToTheParticularColumn() Started");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[@col-id='GeneralDetails.Title']//span[contains(text(),'"+TITLE+"')]")).click();
            Thread.sleep(5000);

            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 10; i++) {

                ac.sendKeys(Keys.TAB).perform();
            }

            return new GlobalRequestPage();

        }catch (Exception ex){
            log_Error("moveToTheParticularColumn() is Failed");
            throw new Exception("Exception in moveToTheParticularColumn()");
        }
    }

    public ILiglPage validateStatusOfTheRequest(String status) throws Exception{

        try {

            log_Info("Validate The Request In The Grid");

            Thread.sleep(5000);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+status+"')]")).isDisplayed();

            System.out.println(a1);

            Thread.sleep(5000);
            Assert.assertEquals(true, a1);

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateStatusOfTheRequest() Failed ", ex);
        }
    }
    public ILiglPage clickOnViewIconInTheGrid() throws Exception{

        try {

            getSession().log_Info("click On Vew Icon");
            getDriver().waitForelementToBeClickable(ViewBtn);
            Thread.sleep(5000);
            ViewBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("clicked On Vew Icon");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnViewIconInTheGrid() Failed ", ex);
        }
    }

    public ILiglPage validateMessageBoxIsInDisableMode() throws Exception{

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReqSaveBtn);

            log_Info("Validate The MessageBox Is In Disabled Mode");

            Thread.sleep(5000);
            boolean a1 = AdditionalTextArea.isEnabled();

            System.out.println(a1);

            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("Validated The MessageBox Is In Disabled Mode");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateMessageBoxIsInDisableMode() Failed ", ex);
        }
    }

    public ILiglPage addAllDetailsInTheAddRequestPopUpByAssigningToRole(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{

        try {

            getSession().log_Info("Click On 'Request Type' Drop Down");
            getDriver().waitForelementToBeClickable(reqTypeDrpDwn);
            Thread.sleep(5000);
            reqTypeDrpDwn.sendKeys(RequestType);
            Thread.sleep(5000);
            reqTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Request Type' Drop Down");

            getSession().log_Info("Click On Request Title Text Box");
            getDriver().waitForelementToBeClickable(RequestTitle);
            RequestTitle.sendKeys(REQTitle);
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Request Title Text Box");

            getSession().log_Info("Click On The Choose A Case Drop Down");
            getDriver().waitForelementToBeClickable(ChooseACaseDrpDwn);
            ChooseACaseDrpDwn.sendKeys(CaseDropDown);
            Thread.sleep(5000);
            ChooseACaseDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Choose A Case Drop Down");

            getSession().log_Info("Click On The Role Type Radio Button ");
            getDriver().waitForelementToBeClickable(RoleRadioBtn);
            Thread.sleep(5000);
            RoleRadioBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Role Type Radio Button");

            getSession().log_Info("Click On The Choose A User Drop Down");
            getDriver().waitForelementToBeClickable(ChooseUser);
            ChooseUser.sendKeys(UserDropDown);
            Thread.sleep(5000);
            ChooseUser.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Choose A User Drop Down");

            getSession().log_Info("Click On The Priority Drop Down");
            getDriver().waitForelementToBeClickable(PriorityDrpDwn);
            PriorityDrpDwn.sendKeys(PriorityDropDown);
            Thread.sleep(5000);
            PriorityDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Priority Drop Down");

            getSession().log_Info("Click On The Completed By");
            getDriver().waitForelementToBeClickable(CompletedBy);
            Thread.sleep(5000);
            CompletedBy.sendKeys(CompleteDate);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Completed By");

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalTextArea);
            Thread.sleep(5000);
            AdditionalTextArea.sendKeys(TextBoxArea);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Additional Area");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReqSaveBtn);

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(ReqSaveBtn);
            Thread.sleep(5000);
            ReqSaveBtn.click();
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Save Button");

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            Thread.sleep(5000);
            OKbutton.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Button Button");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addAllDetailsInTheAddRequestPopUp() Failed ", ex);
        }
    }

    public ILiglPage sendAdditionalMessageWhenReqIsInNewStatus(String TextBoxArea) throws Exception{

        try {

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalMessage);
            Thread.sleep(5000);
            AdditionalMessage.sendKeys(TextBoxArea);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Additional Area");

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(PostMessageBtn);
            Thread.sleep(5000);
            PostMessageBtn.click();
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Save Button");

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            Thread.sleep(5000);
            OKbutton.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Button Button");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendAdditionalMessageWhenReqIsInNewStatus() Failed ", ex);
        }
    }

    public ILiglPage clickOnBackToRequestButton() throws Exception{

        try {

            getSession().log_Info("Click On Back To Request Button");
            getDriver().waitForelementToBeClickable(BackToReqBtn);
            Thread.sleep(5000);
            BackToReqBtn.click();
            getSession().log_Pass("Clicked On Back To Request Button");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnBackToRequestButton() Failed ", ex);
        }
    }

    public ILiglPage modifyIntoTheRequiredStatus(String status) throws Exception {

        try {

            log_Info("modifyIntoTheRequiredStatus() Started");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", ReqSaveBtn);


            getSession().log_Info("Click On The Status Drop Down");
            getDriver().waitForelementToBeClickable(StatusDrpDwn);
            StatusDrpDwn.click();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//mat-option[@aria-labelledby='statusdropdown']//span[contains(text(),'"+status+"')]")).click();
            StatusDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Status Drop Down");

            getSession().log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(ReqSaveBtn);
            Thread.sleep(5000);
            ReqSaveBtn.click();
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Save Button");

            getDriver().waitUntilSpinnerIsClosed();

            getSession().log_Info("Click On OK Button");
            getDriver().waitForelementToBeClickable(OKbutton);
            Thread.sleep(5000);
            OKbutton.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On Button Button");


            return new GlobalRequestPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("modifyIntoTheRequiredStatus() Failed", ex);
        }

    }

    public ILiglPage checkAndValidateTheCountOfRequestUnderNewInProgressCloseStats(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea,String status1,String status2) throws Exception{

        try {


            String initialTotalCounter = TotalCount.getText();
            int TotalCountBefore = Integer.parseInt(initialTotalCounter);

            String initialNewCounter = NewCount.getText();
            int NewCountBefore = Integer.parseInt(initialNewCounter);

            log_Info("Total Number Of Requests Before Adding  : " + TotalCountBefore);
            log_Info("Total Number Of Requests Before Adding  : " + NewCountBefore);


            clickOnAddRequestButton().addAllDetailsInTheAddRequestPopUp(RequestType, REQTitle, CaseDropDown, UserDropDown, PriorityDropDown, CompleteDate, TextBoxArea);


            String AfterTotalCounter = TotalCount.getText();
            int TotalCountAfter = Integer.parseInt(AfterTotalCounter);

            String AfterNewCounter = NewCount.getText();
            int NewCountAfter = Integer.parseInt(AfterNewCounter);


            log_Info("Total Number Of Requests After Adding is : " + TotalCountAfter);
            log_Info("Total Number Of New Requests After Adding is : " + NewCountAfter);

            try {

                if (TotalCountAfter == TotalCountBefore + 1) {

                    log_Pass("Total Count Of Requests Incremented");

                }
                if (NewCountAfter == NewCountBefore + 1) {
                    log_Pass(" New Count Of Requests Incremented");
                }
            }
            catch(Exception e) {
                throw new Exception("Either Total Count Or New Count Not Incremented", e);
            }


            // Checking The In Progress Request Count

            String initialInProgressCounter = InprogressCount.getText();
            int InProgressCountBefore = Integer.parseInt(initialInProgressCounter);

            log_Info("Total Number Of In Progress Requests Before Adding  : " + InProgressCountBefore);


            searchForTheParticularTitleOfTheRequest(REQTitle).clickOnEditIconInTheGrid(REQTitle).modifyIntoTheRequiredStatus(status1);


            String AfterInProgressCounter = InprogressCount.getText();
            int InProgressCountAfter = Integer.parseInt(AfterInProgressCounter);

            log_Info("Total Number Of In Progress Requests After Adding is : " + InProgressCountAfter);

            try {

                if (InProgressCountAfter == InProgressCountBefore + 1) {

                    log_Pass("InProgress Count Of Requests Incremented");

                }
            }
            catch(Exception e) {
                throw new Exception("In Progress Count Not Incremented", e);
            }


            // Checking The Closed Request Count

            String InitialClosedCounter = ClosedCount.getText();
            int ClosedCountBefore = Integer.parseInt(InitialClosedCounter);

            log_Info("Total Number Of Closed Requests Before Adding  : " + ClosedCountBefore);


            searchForTheParticularTitleOfTheRequest(REQTitle).clickOnEditIconInTheGrid(REQTitle).modifyIntoTheRequiredStatus(status2);


            String AfterClosedCounter = ClosedCount.getText();
            int ClosedCountAfter = Integer.parseInt(AfterClosedCounter);

            log_Info("Total Number Of Closed Requests After Adding is : " + ClosedCountAfter);

            try {

                if (ClosedCountAfter == ClosedCountBefore + 1) {

                    log_Pass("Closed Count Of Requests Incremented");

                }
            }
            catch(Exception e) {
                throw new Exception("Closed Count Not Incremented", e);
            }

                return new GlobalRequestPage();

            }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnBackToRequestButton() Failed ", ex);
        }
    }

    public ILiglPage searchForTheParticularTitleOfTheRequest(String title) throws Exception {

        try {

            log_Info("searchForTheParticularTitleOfTheRequest() Started");

            log_Info("Hover on Title Menu");
            Thread.sleep(2000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(TitleMenu).perform();
            Thread.sleep(2000);
            log_Pass("Mouse Hovered To The Title Menu");

            TitleMenu.click();
            Thread.sleep(2000);
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(2000);
            Filter.click();
            Thread.sleep(2000);
            log_Info("Filter Clicked");

            log_Info("Enter Title From Search Bar");
            Thread.sleep(2000);
            Searchbar.sendKeys(title);
            Thread.sleep(2000);
            log_Info("Entered Title From Search Bar");

            return new GlobalRequestPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchForTheParticularTitleOfTheRequest() Failed", ex);
        }

    }

    public ILiglPage validatingNonApprovedCasesInCaseDropDown(String CaseDropDown) throws Exception{

        try {

            getSession().log_Info("Search For The Not-Initiated/PendingForApproval/Rejected Cases In Case DropDown");
            getDriver().waitForAngularRequestsToComplete();
            SearchBarDropdown.sendKeys(CaseDropDown);
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Searched For The Not-Initiated/PendingForApproval/Rejected Cases In Case DropDown");

            log_Info("Validate The No Matching Found Status In Case DropDown");

            Thread.sleep(5000);
            boolean a1 = NoMatchingFound.isDisplayed();

            Thread.sleep(5000);
            System.out.println(a1);

            Thread.sleep(5000);
            Assert.assertEquals(true, a1);

            log_Info("Validated The No Matching Found Status In Case DropDown");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingNonApprovedCasesInCaseDropDown() Failed ", ex);
        }
    }

    public ILiglPage clearActionInCaseDropDown() throws Exception{

        try {

            getSession().log_Info("Clear Case On The Choose A Case Drop Down");
            Thread.sleep(5000);
            SearchBarDropdown.clear();
            Thread.sleep(5000);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Cleared Case On The Choose A Case Drop Down");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clearActionInCaseDropDow() Failed ", ex);
        }
    }

    public ILiglPage clickOnChooseACaseDropDown() throws Exception{

        try {

            getSession().log_Info("Click On The Choose A Case Drop Down");
            getDriver().waitForelementToBeClickable(ChooseACaseDrpDwn);
            ChooseACaseDrpDwn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Choose A Case Drop Down");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnChooseACaseDropDown() Failed ", ex);
        }
    }


    public ILiglPage validateTheFieldValuesInAddRequestPopUp(String FieldValues) throws Exception{

        try {

            log_Info("Validate Field Values In The Add Request PopUp");
            getDriver().waitForAngularRequestsToComplete();
            Thread.sleep(2000);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+FieldValues+"')]")).isDisplayed();
            Thread.sleep(2000);
            System.out.println(a1);
            Thread.sleep(1000);
            Assert.assertEquals(true, a1);

            log_Info("Validated Field Values In The Add Request PopUp");

            return new GlobalRequestPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateListOfColumnsInTheRequestPage() Failed ", ex);
        }
    }
}

