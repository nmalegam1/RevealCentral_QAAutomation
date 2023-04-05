package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.casemanagement.CaseDateRangesPage;
import com.paulhammant.ngwebdriver.ByAngularModel;
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

    //Notes search elements
    //@FindBy(xpath = "//*[@id=\"layout\"]/div/app-case-details/div/div[2]/main/app-notes/div[3]/mat-card/ag-grid-angular/div/div[2]/div[3]/div[1]/div[2]/button")
    //WebElement ChooseNotes;
    @FindBy(xpath = "//div[@col-id=\"Notes\"]//span[@ref=\"eMenu\"]//span[@role='presentation']")
     WebElement ChooseNotes;
    //div[@role="presentation"]//span[@ref="eMenu"]//span[@role='presentation']
    // //div[@col-id="Notes"]//span[@ref="eMenu"]//span[@role='presentation']-- choose filter
    //div[@ref="eHeader"]//span[@aria-label="filter"]//span[@role='presentation']
    //*[@id="ag-890-input"]
    //*[@id="layout"]/div/app-case-details/div/div[2]/main/app-notes/div[3]/mat-card/ag-grid-angular/div/div[6]/div/div[1]/span[2]/span
    // @FindBy(xpath = "//div[@ref=\"eLabel\"]//span[contains(text(),'Notes')]")
    @FindBy(xpath = "//*[@id=\"layout\"]/div/app-case-details/div/div[2]/main/app-notes/div[3]/mat-card/ag-grid-angular/div/div[6]/div/div[1]/span[2]/span")
    WebElement Notes_filter;
    @FindBy(xpath = "//div[@role='presentation']//input[@placeholder='Filter...']")
    WebElement Notes_Search;
    @FindBy(xpath = "//div[@role=\"presentation\"]//div[@row-index=\"0\"]//div[@col-id=\"Notes\"]")
    WebElement Notes_row;
    public ILiglPage NewTabFunction() {

        Actions actions = new Actions(getCurrentDriver());
        for(int i=0;i<6;i++)
        {
            actions.sendKeys(Keys.TAB).build().perform();
        }
        actions.sendKeys(Keys.ENTER).build().perform();


        return new NotesPage();
    }

    public ILiglPage NotesSearchFilter(String name) throws Exception {
        try{
            log_Info("choose notes");
            Thread.sleep(3000);
            ChooseNotes.click();
            log_Info("click on notes");
            Notes_filter.click();
            log_Info("Click on Search");
            //  Notes_Search.click();
            log_Info("enter key");
            // Notes_Search.sendKeys("Say hello");
            Notes_Search.sendKeys(name);
            waitForPageToLoad();
            Notes_row.click();
            log_Pass("Clicked on Notes");
            Thread.sleep(4000);
            return new NotesPage();
        }catch (Exception ex){
            throw new Exception("Exception in NotesSearchFilter()", ex);

        }
    }
    // Elements of ValidateDataInNotesGrid
    // @FindBy(xpath = "//span[@title='Say helloTest data Edit']")
    @FindBy(xpath = "//div[@role='presentation']//div[@row-index='0']//div[@col-id='Notes']//span//span[@class='ellipsistextoverflow']")
    WebElement Notesdata;
    @Override
    public ILiglPage validateDataInNotesGrid(String NotesContent) throws Exception{
        try
        {
            log_Info("Checking Display of created Notes");
            Thread.sleep(5000);
            String s1= Notesdata.getAttribute("title");
            Thread.sleep(3000);
            //Assert.assertEquals(NotesContent,b);
            String s2=NotesContent;
            System.out.println(s1.equals(s2));
            log_Info("Notes is Displaying in grid");
            Thread.sleep(5000);
            return new NotesPage();

        } catch (Exception ex)
        {
            throw new Exception("Exception in ValidateDataInNotesGrid()", ex);
        }
    }

    public ILiglPage createNewNotes(String RequestBy,String NotesContent) throws Exception {
        try {
           /* log_Info("Click on Notes icon in case list page");
            Notes_btn.click();
            log_Pass("Notes icon clicked");
            Thread.sleep(5000);*/
            log_Info("Click on create new notes button");
            addNotesbtn.click();
            log_Info("Create new notes button clicked");
            Thread.sleep(5000);
            log_Info("clicking on Requested by field textbox");
            getDriver().waitForelementToBeClickable(RequestBytxtbox);
            log_Info("clicked on Requested by field textbox");
            RequestBytxtbox.sendKeys(RequestBy);
            log_Info("Data entered in Requested by field");
            Thread.sleep(5000);
            log_Info("clicking on Notes text editor field");
            Notes.click();
            log_Info("clicked on Notes text editor field");
            Notes.sendKeys(NotesContent);
            log_Info("Notes content is entered");
            log_Info("clicking on Save button in create note popup");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            log_Info("clicked on Save button in create note popup");
            return new NotesPage();


        }
        catch (Exception ex) {
            throw new Exception("Exception in CreateNewNotes()", ex);
        }

    }
    //  @FindBy(xpath = "//*[@id=\"EDIT\"]"), id = "DELETE"
    @FindBy(xpath = "//button[@title='Edit']")
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

    public ILiglPage editNotes(String RequestBy,String NotesDescription) throws Exception{
        try {
            log_Pass("Moving to click edit note button in grid");
            //((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);",Editbtn);
            NotesHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 8; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(Editbtn);
            log_Pass("Clicking on Edit note button");
            Editbtn.click();
            log_Info("Edit note button is Clicked");
            Thread.sleep(5000);
            RequestBytxtbox.sendKeys(RequestBy);
            log_Info("Data given to Requested by field");
            Thread.sleep(5000);
            log_Info("clicking on Notes text editor field");
            Notes.click();
            log_Info("clicked on Notes text editor field");
            Notes.sendKeys(NotesDescription);
            log_Info("Notes content is given");
            Thread.sleep(5000);
            log_Info("clicking on Save button in edit note popup");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            Thread.sleep(5000);
            log_Info("clicked on Save button in edit note popup");
            log_Pass("editNotes() Completed");
            return new NotesPage();
        }
        catch (Exception ex)
        {
            throw new Exception("Exception in NotesEdit()", ex);
        }
    }

    //To delete notes in grid
    public ILiglPage NotesDelete(String NotesContent) throws Exception{
        try {
            searchRequiredNotesContent(NotesContent);
            Thread.sleep(3000);
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);",Deletebtn);
            log_Pass("Click on Delete button of notes");
            Deletebtn.click();
            Thread.sleep(3000);
            log_Info("Delete button is Clicked");
            Yesbtn.click();
            log_Info("Yes button is Clicked");
            log_Pass("NotesDelete() Completed");
            return new NotesPage();
        }
        catch (Exception ex)
        {
            throw new Exception("Exception in NotesDelete()", ex);
        }
    }

    @FindBy(xpath = "//div[contains(text(),'No data available...')]")
    WebElement Nodata;

//To validate whether deleted notes is not displaying in grid
    public ILiglPage validateDeletedNote(String NotesContent) throws Exception{
        try {
            log_Info("verify No data available text in Grid");
            notesSecondSearch(NotesContent);
            boolean a1 = Nodata.isDisplayed();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("No data available text in Grid is Displayed");
            getSession().setGlobalData();
            log_Pass("validateDeletedNote() Completed");
            return new NotesPage();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    //Searching Notes content column in Notes grid
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

        }}
//To search the same notes column for second time
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


}
