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

    @FindBy(id = "addreq-save-btn")
    WebElement ReqSaveBtn;

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


    public ILiglPage validateCreatedRequestInTheGlobalRequestGrid(String TITLE) throws Exception{

        try {

            log_Info("Validate The Request In The Grid");

            Thread.sleep(5000);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+TITLE+"')]")).isDisplayed();

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
            boolean a3 = Column3.isDisplayed();
            boolean a4 = Column4.isDisplayed();
            boolean a5 = Column5.isDisplayed();
            boolean a6 = Column6.isDisplayed();
            boolean a7 = Column7.isDisplayed();
            boolean a8 = Column8.isDisplayed();

            Thread.sleep(5000);
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);



            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, a3);
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

    public ILiglPage clickOnEditIconInTheGrid() throws Exception{

        try{

            log_Info("clickOnEditIconInTheGrid() Started");
            Thread.sleep(5000);
            Column1.click();
            Thread.sleep(5000);

            Actions ac = new Actions(getCurrentDriver());
            for (int i = 0; i < 13; i++) {

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

    public ILiglPage addMessageWhenStatusIsInProgessState() throws Exception{

        try{

            getSession().log_Info("Click On The Status Drop Down");
            getDriver().waitForelementToBeClickable(PriorityDrpDwn);
            //PriorityDrpDwn.sendKeys(StatusDrpDwn);
            Thread.sleep(5000);
            PriorityDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On The Status Drop Down");

            getSession().log_Info("Click On The Additional Area");
            getDriver().waitForelementToBeClickable(AdditionalTextArea);
            Thread.sleep(5000);
            //AdditionalTextArea.sendKeys(TextBoxArea);
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

        }catch (Exception ex){
            log_Error("validateCustStatus is Failed");
            throw new Exception("Exception in validateCustStatus()");
        }
    }
}

