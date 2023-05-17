package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.NotesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseDocumentsPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;
    @FindBy(xpath="//span[contains(text(),'File')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement FileNameMenu;

    @FindBy(xpath = "//span[contains(text(),'File')]/ancestor::div[@ref='eLabel']/span")
    WebElement CaseDocFileName;
    @FindBy(xpath="//button[@aria-label='pencil']")
    WebElement EditBtn;
    @FindBy(id="input-description")
    WebElement Description;
    @FindBy(id="send-approval-btn")
    WebElement UpdateBtn;
    @FindBy(css="span[class='ag-icon ag-icon-menu']")
    WebElement Menu;
    @FindBy(css="input[placeholder='Filter...']")
    WebElement SearchBar;
    @FindBy(xpath = "//span[contains(text(),'Comments')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement CommentsHeader;
    @FindBy(xpath = "//span[contains(text(),'Description')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement DescHeader;
    @FindBy(xpath = "//span[@class='ellipsistextoverflow']/ancestor::div[@col-id='Comments']//span//span")
    WebElement Comments;
    @FindBy(id="add-edit-case-documents-cancel-btn")
    WebElement CancelBtn;
    @FindBy(id="input-issued-by")
    WebElement IssuedBy;
    @FindBy(id="input-received-by")
    WebElement ReceivedBy;
    @FindBy(id="input-issued-date")
    WebElement IssuedDate;
    @FindBy(id="input-received-date")
    WebElement ReceivedDate;
    @FindBy(id="add-edit-case-documents-yes-opt-button")
    WebElement YesButton;
    @FindBy(id="add-edit-case-documents-no-opt-button")
    WebElement NoBtn;
    @FindBy(css="button[aria-label='Previous month']")
    WebElement PrevMonth;
    @FindBy(css="button[aria-label='Next month']")
    WebElement NextMonth;
    @FindBy(css="button[aria-label='November 6, 2022']")
    WebElement ParticularIssuedDate;
    @FindBy(css="button[aria-label='December 3, 2022']")
    WebElement ParticularRcvDate;
    @FindBy(xpath = "//button[@title='Notes']")
    WebElement NotesBtn;

    public ILiglPage searchRequiredCaseDocument(String CaseDocument) throws Exception {
        try {
            log_Info("searchRequiredCaseDocument() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CaseDocFileName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            FileNameMenu.click();
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            Searchbar.sendKeys(CaseDocument);
            Thread.sleep(5000);
            log_Info("Entered Case document file name In Search Bar");
            return new CaseDocumentsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredCaseDocument() Failed", ex);    }}

    public ILiglPage clickOnCaseDocument(String CaseDocument) throws Exception {

        try {


            log_Info("clickOnCaseDocument() started");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseDocument + "')]")).click();
            Thread.sleep(5000);
            log_Info("Clicked on Document Name");
            return new CaseDocumentsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnCaseDocument() Failed",ex);
        }
    }
    /**
     * Method to verify the availability and functionality of Fields in Edit Document
     * @param issuedBy
     * @param receivedBy
     * @param issuedDate
     * @param receivedDate
     * @return
     * @throws Exception
     */
    public  ILiglPage datesIssuedFields(String issuedBy,String receivedBy,String issuedDate,String receivedDate) throws Exception{
        try {
            log_Info("datesIssuedFields() Started");
            Thread.sleep(2000);
            EditBtn.click();
            boolean IB = IssuedBy.isEnabled();
            Boolean ID = IssuedDate.isEnabled();
            boolean RB = ReceivedBy.isEnabled();
            boolean RD = ReceivedDate.isEnabled();
            System.out.println(IB + " ," + ID + ", " + RB + "," + RD);
            YesButton.click();
            boolean IBY = IssuedBy.isEnabled();
            Boolean IDY = IssuedDate.isEnabled();
            boolean RBY = ReceivedBy.isEnabled();
            boolean RDY = ReceivedDate.isEnabled();
            System.out.println(IBY + " ," + IDY + ", " + RBY + "," + RDY);
            IssuedBy.sendKeys(issuedBy);
            ReceivedBy.sendKeys(receivedBy);
            String issuedDateNew=issuedDate.replace("-","");
            IssuedDate.sendKeys(issuedDateNew);
            String receivedDateNew=receivedDate.replace("-","");
            ReceivedDate.sendKeys(receivedDateNew);
            UpdateBtn.click();
            log_Pass("Details Updated Successfully");
            return new CaseDocumentsPage();
        }catch (Exception ex){
            throw new Exception("Exception in caseApproval()", ex);
        }
    }
    /**
     * Method to check the Update button Functionality in Edit Documents Page
     * @return CaseDocumentsPage()
     * @throws Exception
     */
    public ILiglPage updateInEditDocument(String newDesc) throws Exception {
        try {
            log_Info("updateInEditDocument() Started");
            Thread.sleep(3000);
            EditBtn.click();
            NoBtn.click();
            Description.clear();
            Thread.sleep(3000);
            Description.sendKeys(newDesc);
            UpdateBtn.click();
            log_Pass("Data Updated Successfully");
            Thread.sleep(3000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(DescHeader).perform();
            Thread.sleep(3000);
            DescHeader.click();
            Thread.sleep(3000);
            Filter.click();
            Thread.sleep(3000);
            SearchBar.sendKeys(newDesc);
            Thread.sleep(3000);
            String s = Comments.getAttribute("title");
            Assert.assertEquals(s, newDesc);
            log_Pass("Description Updated successfully");
            SearchBar.clear();
            Thread.sleep(3000);
            return new CaseDocumentsPage();
        }catch (Exception ex){
            log_Error("Exception in updateInEditDocument()");
            throw new Exception("updateInEditDocument() Failed",ex);
        }
    }

    /**
     * Method to verify the Functionality of Cancel Button in Edit Documents
     * @return CaseDocumentsPage
     * @throws Exception
     */
    public ILiglPage cancelInEditDocument(String newDesc) throws Exception {
        try {
            log_Info("cancelInEditDocument() Started");
            EditBtn.click();
            String s1 = Comments.getAttribute("title");
            Thread.sleep(3000);
            Description.sendKeys(newDesc);
            Thread.sleep(3000);
            CancelBtn.click();
            Thread.sleep(3000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(DescHeader).perform();
            DescHeader.click();
            //Filter.click();
            SearchBar.sendKeys(newDesc);
            Thread.sleep(3000);
            String s2 = Comments.getAttribute("title");
            Assert.assertEquals(s1, s2);
            log_Pass("Description Not updated As we click cancel button");
            return new CaseDocumentsPage();
        }catch (Exception ex){
            log_Error("Exception in cancelInEditDocument()");
            throw new Exception("cancelInEditDocument() Failed",ex);
        }
    }
    public ILiglPage goToNotesPageFromDocuments(){
        getDriver().waitForelementToBeClickable(NotesBtn);
        NotesBtn.click();
        return new NotesPage();
    }

}
