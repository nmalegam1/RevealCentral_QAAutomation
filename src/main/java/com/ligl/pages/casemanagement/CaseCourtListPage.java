package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseCourtListPage extends LiglBaseSessionPage {

    // Web Element For Adding One Or More Prosecutors To The Particular Court


    //   1.Adding Court To A Case

    @FindBy(id = "add-case-doc-btn-court")
    WebElement AddCourtBtn;

    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_right')]")
    WebElement LeftArrow;

    @FindBy(id="send-approval-btn")
    WebElement SaveBtn;

    //2.Searching For A Particular Court Added To Case

    @FindBy(xpath = "//span[contains(text(),'Court/Fourm')]/ancestor::div[@ref='eLabel']/span")
    WebElement CourtHeader;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement CourtMenuIcon;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CourtFilterIcon;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CourtSearchBar;


    // 3. Navigate To Prosecutor


    @FindBy(xpath = "//button[contains(text(),'Prosecutor')]")
    WebElement AddProsecutor;

    @FindBy(xpath = "//span[contains(text(),'test team')]")
    WebElement Prosecutor1;

    @FindBy(xpath = "//span[contains(text(),'Prosecutor2 Prosecutorold')]")
    WebElement Prosecutor2;

    @FindBy(xpath = "//span[contains(text(),'Prosecutor1 ProsecutorNew')]")
    WebElement Prosecutor3;

    @FindBy(xpath = "//span[contains(text(),'Prosecutor sep27')]")
    WebElement Prosecutor4;

    @FindBy(xpath = "//span[contains(text(),'Prosecutor/Advocacy')]/ancestor::div[@ref='eLabel']")
    WebElement ProsecutorHeader;

    @FindBy(xpath="//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='PartyName']//span[@class='ellipsisAgGrid']")
    WebElement CourtNameColData;

    @FindBy(xpath="//button[contains(text(),'Judge')]")
    WebElement AddJudgeBtn;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement SearchBar;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath="//span[contains(text(),'Jury')]/ancestor::div[@ref='eLabel']/span")
    WebElement JudgeHeader;

    @FindBy(xpath="//span[contains(text(),'Jury')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement JudgeMenu;

    @FindBy(xpath="//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ContactName']//span[@class='ellipsisAgGrid']")
    WebElement JudgeNameColData;


    //  10.Adding Particular Court To Case Through Add Court Button

    public ILiglPage addCourtToCase(String AvailableCourt) throws Exception {

        try {


            log_Info("Click on Add Court Button");
            getDriver().waitForelementToBeClickable(AddCourtBtn);
            Thread.sleep(5000);
            AddCourtBtn.click();
            getSession().log_Pass("Clicked on Add Court Button");

            log_Info("Select Available Court From The Table");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+AvailableCourt+"')]")).click();
            getSession().log_Pass("Selected Available Court From The Table");

            log_Info("Click On The Left Arrow");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            getSession().log_Pass("Clicked On The Left Arrow");

            log_Info("Click On The Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked On The Save Button");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addCourtToCase() Failed",ex);
        }
    }
    // 10.Searching A court Added To Case By Search Filter

    public ILiglPage searchingAddedCourt(String AvailableCourt) throws Exception {

        try {

            log_Info("Hover on Law Firm Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CourtHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on Law Firm menu icon");
            CourtMenuIcon.click();
            log_Info("clicked on law Firm menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(CourtFilterIcon);
            Thread.sleep(5000);
            CourtFilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter Court Name from search bar");
            getDriver().waitForelementToBeClickable(CourtSearchBar);
            Thread.sleep(5000);
            CourtSearchBar.sendKeys(AvailableCourt);
            log_Info("Entered Court Name from search bar");
            Thread.sleep(5000);
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("searchingAddedCourt() Failed",ex);
        }
    }

    //10. Adding Prosecutor To The Court Added And Searched

    public ILiglPage navigateAndAddProsecutor(String AvailableCourt,String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception {

        try {

            log_Info("Click on Particular Court Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+AvailableCourt+"']/span")).click();
            log_Info("Clicked on Particular Court Name");


            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddProsecutor);

            log_Info("Click on Add Prosecutor Button");
            getDriver().waitForelementToBeClickable(AddProsecutor);
            Thread.sleep(5000);
            AddProsecutor.click();
            log_Info("Clicked on Add Prosecutor Button");

            log_Info("Click on Add Prosecutor1");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+AvailableProsecutor1+"')]")).click();
            log_Info("Clicked on Add Prosecutor1");

            log_Info("Click on Add Left Arrow Button");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            log_Info("Clicked on Add Left Arrow Button");

            log_Info("Click on Add Prosecutor2 Button");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+AvailableProsecutor2+"')]")).click();
            log_Info("Clicked on Add Prosecutor2 Button");

            log_Info("Click on Add Left Arrow Button");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            log_Info("Clicked on Add Left Arrow Button");

            log_Info("Click on Add Prosecutor3 Button");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+AvailableProsecutor3+"')]")).click();
            log_Info("Clicked on Add Prosecutor3 Button");

            log_Info("Click on Add Left Arrow Button");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            log_Info("Clicked on Add Left Arrow Button");

            log_Info("Click on Add Prosecutor4 Button");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+AvailableProsecutor4+"')]")).click();
            log_Info("Clicked on Add Prosecutor4 Button");

            log_Info("Click on Add Left Arrow Button");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            log_Info("Clicked on Add Left Arrow Button");

            log_Info("Click on Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            log_Info("Clicked on Save Button");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("navigateAndAddProsecutor() Failed",ex);
        }
    }
    public ILiglPage validateProsecutors(String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception{

        try {


            Thread.sleep(5000);
            log_Info("Check The Availability Of Prosecutors in the grid");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+AvailableProsecutor1+"')]")).isDisplayed();
            boolean a2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+AvailableProsecutor2+"')]")).isDisplayed();
            boolean a3 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+AvailableProsecutor3+"')]")).isDisplayed();
            boolean a4 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+AvailableProsecutor4+"')]")).isDisplayed();
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a2);
            System.out.println(a2);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, a3);
            Assert.assertEquals(true, a4);
            return new CaseCourtListPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateProsecutors() Failed", ex);
        }
    }

    public ILiglPage validateAddedCourts(String CourtAdded) throws Exception{

        try {
            log_Info("validateAddedCourts() started");
            searchingAddedCourt(CourtAdded);
            log_Info("Filtered Added court to case");
            String test=CourtNameColData.getText();
            Assert.assertEquals(test,CourtAdded);
            log_Info("Added court is displaying in grid");
            log_Info("validateAddedCourts() completed");
            return new CaseCourtListPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateAddedCourts() Failed", ex);
        }
    }

    public ILiglPage clickOnCourtName(String CourtName1) throws Exception {

        try {


            log_Info("clickOnCourtName() started");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CourtName1 + "')]")).click();
            Thread.sleep(5000);
            log_Info("Clicked on Court Name");
            log_Info("clickOnCourtName() completed");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnCourtName Failed",ex);
        }
    }

    public ILiglPage clickOnAddJudgeButton() throws Exception {

        try {


            log_Info("clickOnAddJudgeButton() started");
            getDriver().waitForelementToBeClickable(AddJudgeBtn);
            Thread.sleep(3000);
            AddJudgeBtn.click();
            log_Info("Clicked on Add AddJudge Button");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("AddJudgeBtn Failed",ex);
        }
    }

    public ILiglPage addExistingJudgesToCourt(String Judge) throws Exception {

        try {
            log_Info("addExistingJudgesToCourt() started");
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+Judge+"')]")).click();
            Thread.sleep(3000);
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(2000);
            LeftArrow.click();
            log_Info("Clicked on Add Left Arrow Button");
            SaveBtn.click();
            log_Info("Clicked Save button");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("navigateAndAddJudge() Failed",ex);
        }
    }

    public ILiglPage validateAddedJudges(String Judge) throws Exception{

        try {
            log_Info("validateAddedJudges() started");
            searchRequiredJudge(Judge);
            log_Info("Filtered Added court to case");
            String test=JudgeNameColData.getText();
            Assert.assertEquals(test,Judge);
            log_Info("Added judge is displaying in grid");
            log_Info("validateAddedJudges() completed");
            return new CaseCourtListPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateAddedJudges() Failed", ex);
        }
    }
    public ILiglPage searchRequiredJudge(String AvailableJudge) throws Exception {

        try {
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(JudgeHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            JudgeMenu.click();
            getDriver().waitForelementToBeClickable(Filter);
            Thread.sleep(5000);
            Filter.click();
            getDriver().waitForelementToBeClickable(SearchBar);
            Thread.sleep(5000);
            SearchBar.sendKeys(AvailableJudge);
            log_Info("Entered Judge Name in search bar");
            Thread.sleep(5000);
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredJudge() Failed",ex);
        }
    }

}
