package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.NotesPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseNotesHistoryPage extends LiglBaseSessionPage
{
    @FindBy(id = "input-case-name")
    WebElement RequestBytxtbox;
    @FindBy(xpath = "//*[@id=\"req-add-info\"]/div[2]/p")
    WebElement Notes;
    @FindBy(id = "btn-save-and-add")
    WebElement SaveBtn;
    @FindBy(xpath = "//div[@row-id='0']//*[@title=\"View\"]")
    WebElement Editbtn;
    //@FindBy(id = "DELETE")
    @FindBy(xpath = "//div[@row-id='0']//*[@title=\"Delete\"]")
    WebElement Deletebtn;

    @FindBy(xpath ="//button[contains(text(),'Yes')]")
    WebElement Yesbtn;

    @FindBy(xpath = "//span[contains(text(),'Type of Event')]")
    WebElement NotesHeader;
    @FindBy(xpath = "//span[contains(text(),'Timestamp ')]/ancestor::div[@ref='eLabel']")
    WebElement TimeStamp;

    @FindBy(xpath = "//span[contains(text(),'Performed By')]/ancestor::div[@ref='eLabel']")
    WebElement PerformedBy;

    @FindBy(xpath = "//span[contains(text(),'Role')]/ancestor::div[@ref='eLabel']")
    WebElement Role;

    @FindBy(xpath = "//span[contains(text(),'Type of Event')]/ancestor::div[@ref='eLabel']")
    WebElement TypeOfEvent;

    @FindBy(xpath = "//span[contains(text(),'Status')]/ancestor::div[@ref='eLabel']")
    WebElement Status;

    @FindBy(xpath = "//span[contains(text(),'Details')]/ancestor::div[@ref='eLabel']")
    WebElement Details;

    @FindBy(xpath = "//span[contains(text(),'Action')]/ancestor::div[@ref='eLabel']")
    WebElement Action;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]/ancestor::div[@ref='eLabel']")
    WebElement CaseName;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]")
    WebElement CaseNameColumn;

    @FindBy(id="Columns")
    WebElement ChooseColumnsMenu;
    @FindBy(xpath = "//span[contains(text(),'Type of Event')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement ChooseTOE;
    @FindBy(xpath = "//ancestor::div[@ref='eHeader']/span[2]")
    WebElement FilterTOE;
    @FindBy(xpath = "//ancestor::div[@ref=\"eValue1\"]//input[@placeholder=\"Filter...\"]")
    WebElement SearchTOE;
    @FindBy(id= "selectType")
    public WebElement TypeofEventDrpdwn;
    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement SearchTOfEDrpdwn;
    @FindBy(xpath = "//div[@row-id=\"0\"]//div[@col-id=\"TypeofEvent\"]//span//span")
    public WebElement TypeofEventRowValue;
    @FindBy(xpath = "//div[@row-index='0']//div[@col-id='Details' and @role='gridcell']//span[@class='ellipsistextoverflow']")
    WebElement DetailsColValue;
    @FindBy(xpath = "//span[contains(text(),'Result(s)')]/ancestor::div[@class='table-header-action-item-list']//b")
    WebElement Results;



    public ILiglPage verifyColumnsInNotesHistoryGrid() throws Exception {

        try {

            log_Info("Check The Column names In The History Grid");
            boolean c1 = TimeStamp.isDisplayed();
            boolean c2 = PerformedBy.isDisplayed();
            boolean c3 = Role.isDisplayed();
            boolean c4 = TypeOfEvent.isDisplayed();
            boolean c5 = Status.isDisplayed();
            boolean c6 = Details.isDisplayed();
            boolean c7 = Action.isDisplayed();
            Thread.sleep(5000);
            // Verifying display of optional column Case name by checking from choose columns
            ChooseColumnsMenu.click();
            Thread.sleep(1000);
            CaseNameColumn.click();
            Thread.sleep(1000);
            ChooseColumnsMenu.click();
            Thread.sleep(1000);
            boolean c8 = CaseName.isDisplayed();

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

            return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInNotesHistoryGrid()", ex);
        }
    }
    public ILiglPage TypeofEventSearchFilter(String TypeofEvent) throws Exception {

        try {

            log_Info("choose ToE");
            Thread.sleep(3000);
            ChooseTOE.click();
            log_Info("click on ToE Filter");
            FilterTOE.click();
            log_Info("Click on Search");
            log_Info("Enter key");
            Thread.sleep(3000);
            SearchTOE.sendKeys(TypeofEvent);
            Thread.sleep(5000);
            log_Info("Entered key");

            return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("TypeofEventSearchFilter()", ex);
        }
    }
    public ILiglPage notesEdit(String RequestBy,String NotesDescription) throws Exception{

        try {

            log_Pass("Moving to click edit note button in grid");
            getDriver().waitForelementToBeClickable(Editbtn);
            log_Pass("Clicking on Edit note button");
            Editbtn.click();
            Thread.sleep(5000);
            log_Info("Edit note button is Clicked");
            Thread.sleep(5000);
            RequestBytxtbox.clear();
            Thread.sleep(2000);
            RequestBytxtbox.sendKeys(RequestBy);
            log_Info("Data given to Requested by field");
            Thread.sleep(5000);
            log_Info("clicking on Notes text editor field");
            Notes.clear();
            log_Info("clicked on Notes text editor field");
            Thread.sleep(5000);
            Notes.sendKeys(NotesDescription);
            log_Info("Notes content is given");
            Thread.sleep(5000);
            log_Info("clicking on Save button in edit note popup");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            Thread.sleep(5000);
            log_Info("clicked on Save button in edit note popup");

            return new CaseNotesHistoryPage();
        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("notesEdit()", ex);
        }
    }
    public ILiglPage notesDelete() throws Exception{
        try {
            log_Pass("Moving to click edit note button in grid");
            getDriver().waitForelementToBeClickable(Deletebtn);
            log_Pass("Click on Delete button of notes");
            Thread.sleep(3000);
            Deletebtn.click();
            Thread.sleep(3000);
            log_Info("Delete button is Clicked");
            Yesbtn.click();
            Thread.sleep(3000);
            log_Info("Yes button is Clicked");
            return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("displayingSelectedNotesList()", ex);
        }
    }

    public ILiglPage validateDeletedNoteForMultipleRecords() throws Exception{

        try {

            log_Info("verify No data available text in Grid");
            String a1 = Results.getText();
            int i = Integer.parseInt(a1);
            int k=--i;
            notesDelete();
            Thread.sleep(6000);
            String a2 = Results.getText();
            int j = Integer.parseInt(a2);
            Assert.assertEquals(j,k);
            log_Info("No data available text in Grid is Displayed");

            return new CaseNotesHistoryPage();

        }
            catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateDeletedNoteForMultipleRecords()", ex);
        }
    }


    public ILiglPage displayingSelectedNotesList(String TOE) throws Exception{

        try {

            log_Pass("Click on Type of Event Drop down");
            getDriver().waitForelementToBeClickable(TypeofEventDrpdwn);
            Thread.sleep(5000);
            TypeofEventDrpdwn.click();
            Thread.sleep(5000);
            SearchTOfEDrpdwn.sendKeys(TOE);
            Thread.sleep(5000);
            TypeofEventDrpdwn.sendKeys(Keys.ENTER);
            log_Pass("Clicked on Type of Event Drop down");
            waitForPageToLoad();

                String b = TypeofEventRowValue.getAttribute("title");
                Assert.assertEquals(TOE, b);
                log_Pass("Type of Event data displayed successfully");
                return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("displayingSelectedNotesList()", ex);
        }
    }


    public ILiglPage detailsColumnData(String Details) throws Exception{

        try {

        log_Info("Validating The Coulmn Data Based On Type Of Event");
        String a=DetailsColValue.getAttribute("title");
        Assert.assertEquals(Details,a);
        log_Info("Validated The Coulmn Data Based On Type Of Event");
        return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
        log_Error(ex.getMessage());
        throw new Exception("detailsColumnData()", ex);

        }
    }
}

