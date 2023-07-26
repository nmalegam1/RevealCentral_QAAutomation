package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.casemanagement.CaseDateRangesPage;
import com.paulhammant.ngwebdriver.ByAngularModel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;

public class NotesPage extends LiglBaseSessionPage {
    @FindBy(id = "btn-create-case")
    WebElement addNotesbtn;
    @FindBy(id = "record-edit")
    WebElement Notes_btn;
    @FindBy(id = "input-case-name")
    WebElement RequestBytxtbox;
    @FindBy(xpath = "//*[@id=\"req-add-info\"]/div[2]/p")
    WebElement Notes;

    @FindBy(id = "btn-save-and-add")
    WebElement SaveBtn;
    @FindBy(xpath = "//div[@col-id=\"Notes\"]//span[@ref=\"eMenu\"]//span[@role='presentation']")
     WebElement ChooseNotes;
    @FindBy(xpath = "//*[@id=\"layout\"]/div/app-case-details/div/div[2]/main/app-notes/div[3]/mat-card/ag-grid-angular/div/div[6]/div/div[1]/span[2]/span")
    WebElement Notes_filter;
    @FindBy(xpath = "//div[@role='presentation']//input[@placeholder='Filter...']")
    WebElement Notes_Search;
    @FindBy(xpath = "//div[@role='presentation']//div[@row-index='0']//div[@col-id='Notes']")
    WebElement Notes_row;

    @FindBy(xpath = "//button[@aria-label='pencil']//i")
    WebElement Editbtn;
    @FindBy(xpath = "//button[@title='Delete']")
    WebElement Deletebtn;

    @FindBy(xpath ="//button[contains(text(),'Yes')]")
    WebElement Yesbtn;

    @FindBy(xpath = "//span[contains(text(),'Type of Event')]")
    WebElement NotesHeader;

    @FindBy(xpath="//span[contains(text(),'Notes') and @ref='eText']")
    WebElement NotesColumnHeader;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath="//span[contains(text(),'Notes')]/ancestor::div[@ref='eLabel']/ancestor::div[@col-id='Notes']//span")
    WebElement NotesColumnMenu;

    @FindBy(xpath = "//div[contains(text(),'No data available...')]")
    WebElement Nodata;

    @FindBy(xpath = "//div[@role='presentation']//div[@row-index='0']//div[@col-id='Notes']//span//span[@class='ellipsistextoverflow']")
    WebElement Notesdata;

    @FindBy(xpath = "//span[contains(text(),'Result(s)')]/ancestor::div[@class='table-header-action-item-list']//b")
    WebElement Results;

    @FindBy(xpath = "//span[contains(text(),'Action')]")
    WebElement ActionColumn;

    @FindBy(id = "btn-refresh")
    WebElement RefreshButton;

    @FindBy(xpath = "//mat-select[@id='sel-matterTypeofEvent']")
    WebElement TypeOfEvent;


    public ILiglPage NewTabFunction() {

        Actions actions = new Actions(getCurrentDriver());
        for(int i=0;i<6;i++)
        {
            actions.sendKeys(Keys.TAB).build().perform();
        }
        actions.sendKeys(Keys.ENTER).build().perform();


        return new NotesPage();
    }

    public ILiglPage notesSearchFilter(String name) throws Exception {
        try{

            log_Info("choose notes");
            Thread.sleep(2000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(ChooseNotes).perform();
            getDriver().waitForelementToBeClickable(ChooseNotes);
            Thread.sleep(2000);
            ChooseNotes.click();
            Thread.sleep(2000);
            log_Info("click on notes");
            Notes_filter.click();
            log_Info("Click on Search");
            log_Info("enter key");
            Thread.sleep(5000);
            Notes_Search.sendKeys(name);
            Thread.sleep(10000);
            Notes_row.click();
            log_Pass("Clicked on Notes");
            Thread.sleep(2000);
            return new NotesPage();
        }catch (Exception ex){
            throw new Exception("Exception in NotesSearchFilter()", ex);

        }
    }

    @Override
    public ILiglPage validateDataInNotesGrid(String NotesContent) throws Exception{
        try
        {
            log_Info("Checking Display of created Notes");
            Thread.sleep(5000);
            String s1= Notesdata.getAttribute("title");
            Thread.sleep(3000);
            String s2=NotesContent;
            System.out.println(s1.equals(s2));
            log_Info("Notes is Displaying in grid");
            Thread.sleep(2000);
            return new NotesPage();

        } catch (Exception ex)
        {
            throw new Exception("Exception in ValidateDataInNotesGrid()", ex);
        }
    }

    public ILiglPage createNewNotes(String RequestBy,String NotesContent) throws Exception {
        try {

            log_Info("createNewNotes() Started");
            log_Info("Click on create new notes button");
            getDriver().waitForelementToBeClickable(addNotesbtn);
            Thread.sleep(1000);
            addNotesbtn.click();
            log_Info("Create new notes button clicked");

            if(TypeOfEvent.isEnabled()){

                TypeOfEvent.click();
                Thread.sleep(1000);
                getCurrentDriver().findElement((By.xpath("//div[@id='sel-matterTypeofEvent-panel']//mat-option[2]"))).sendKeys(Keys.ENTER);
            }

            log_Info("click on Requestedby field textbox");
            getDriver().waitForelementToBeClickable(RequestBytxtbox);
            Thread.sleep(1000);
            RequestBytxtbox.sendKeys(RequestBy);
            log_Info("Clicked On Requestedby field");

            log_Info("click on Notes text editor field");
            Notes.click();
            log_Info("clicked on Notes text editor field");
            Thread.sleep(1000);
            Notes.sendKeys(NotesContent);
            log_Info("Notes content is entered");

            log_Info("clicking on Save button in create note popup");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(1000);
            SaveBtn.click();
            log_Info("clicked on Save button in create note popup");

            return new NotesPage();
        }
        catch (Exception ex) {
            throw new Exception("Exception in CreateNewNotes()", ex);
        }

    }

    public ILiglPage editNotes(String RequestBy,String NotesDescription) throws Exception{

        try {

            log_Pass("Moving to click edit note button in grid");
            Thread.sleep(5000);
            NotesHeader.click();

            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(Editbtn);
            log_Pass("Clicking on Edit note button");
            getDriver().maxWait();
            Editbtn.click();
            log_Info("Edit note button is Clicked");
            Thread.sleep(5000);

            if(TypeOfEvent.isEnabled()){

                TypeOfEvent.click();
                Thread.sleep(1000);
                getCurrentDriver().findElement((By.xpath("//div[@id='sel-matterTypeofEvent-panel']//mat-option[2]"))).sendKeys(Keys.ENTER);
            }

            RequestBytxtbox.clear();
            log_Info("Requested By field is cleared");
            RequestBytxtbox.sendKeys(RequestBy);
            log_Info("Data given to Requested by field");
            Thread.sleep(5000);
            log_Info("clicking on Notes text editor field");
            Notes.click();
            log_Info("clicked on Notes text editor field");
            Notes.clear();
            Thread.sleep(3000);
            log_Info("Data Cleared");
            Notes.sendKeys(NotesDescription);
            log_Info("Notes content is given");
            Thread.sleep(5000);
            log_Info("clicking on Save button in edit note popup");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            Thread.sleep(5000);
            log_Info("clicked on Save button in edit note popup");
            log_Pass("editNotes() Completed");

            clickOnRefreshButtonInNotesGrid();

            Thread.sleep(3000);
            ActionColumn.click();
            for (int i = 0; i < 5; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            return new NotesPage();
        }
        catch (Exception ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("Exception in NotesEdit()", ex);
        }
    }

         //To delete notes in grid
    public ILiglPage NotesDelete(String NotesContent) throws Exception{
        try {
           searchRequiredNotesContent(NotesContent);
            Thread.sleep(3000);
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);",Deletebtn);
            NotesHeader.click();

            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            getDriver().waitForelementToBeClickable(Deletebtn);
            log_Pass("Click on Delete button of notes");
            Deletebtn.click();
            Thread.sleep(3000);
            log_Info("Delete button is Clicked");
            Yesbtn.click();
            log_Info("Yes button is Clicked");
            log_Pass("NotesDelete() Completed");
            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw  new Exception("NotesDelete() Failed", ex);

        }
    }
        //To validate whether deleted notes is not displaying in grid

    public ILiglPage validateDeletedNote(String NotesContent) throws Exception{
        try {
            log_Info("verify No data available text in Grid");
            secondSearchInNotesGrid(NotesContent);
            boolean a1 = Nodata.isDisplayed();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("No data available text in Grid is Displayed");
            log_Pass("validateDeletedNote() Completed");
            return new NotesPage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public ILiglPage searchRequiredNotesContent(String NotesContent) throws Exception {
        try {



            log_Info("searchRequiredNotesContent() Started");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(NotesColumnHeader).perform();
            Thread.sleep(5000);
            NotesColumnMenu.click();
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            Searchbar.sendKeys(NotesContent);
            Thread.sleep(5000);
            log_Pass("searchRequiredNotesContent() Completed");
            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw  new Exception("searchRequiredNotesContent() Failed", ex);

        }
    }

    public ILiglPage notesSecondSearch(String NotesContent) throws Exception {
        try {
            log_Info("secondSearch() Started");
            NotesColumnMenu.click();
            Thread.sleep(5000);
            Searchbar.sendKeys(Keys.ENTER);
            Thread.sleep(5000);
            log_Info("Data is filtered");
            log_Pass("notesSecondSearch() completed");
            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("secondSearch() Failed", ex);    }}



    public ILiglPage deleteTheRequiredNotes() throws Exception{

        try {

            Thread.sleep(3000);

            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            getDriver().waitForelementToBeClickable(Deletebtn);
            log_Pass("Click on Delete button of notes");
            Deletebtn.click();
            Thread.sleep(3000);
            log_Info("Delete button is Clicked");
            Yesbtn.click();
            Thread.sleep(5000);
            log_Info("Yes button is Clicked");
            log_Pass("NotesDelete() Completed");


            Thread.sleep(3000);
            ActionColumn.click();
            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw  new Exception("deleteTheRequiredNotes() Failed", ex);

        }
    }

    public ILiglPage secondSearchInNotesGrid(String NotesContent) throws Exception {
        try {

            log_Info("secondSearchInNotesGrid() Started");
            NotesColumnMenu.click();
            Thread.sleep(2000);
            Searchbar.clear();
            Thread.sleep(1000);
            Searchbar.sendKeys(NotesContent);
            log_Info("Data is filtered");
            log_Pass("secondSearchInNotesGrid() completed");

            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("secondSearchInNotesGrid() Failed", ex);    }}


    public ILiglPage clickOnRefreshButtonInNotesGrid() throws Exception {
        try {

            log_Info("clickOnRefreshButtonInNotesGrid() Started");
            log_Info("Click On Refresh Button");
            Thread.sleep(2000);
            RefreshButton.click();
            Thread.sleep(5000);
            log_Pass("Clicked On Refresh Button");
            log_Pass("clickOnRefreshButtonInNotesGrid() completed");

            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnRefreshButtonInNotesGrid() Failed", ex);    }}

}
