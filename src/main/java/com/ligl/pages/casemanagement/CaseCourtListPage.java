package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.NotesPage;
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

    @FindBy(xpath = "//span[contains(text(),'Court/Fourm')]/ancestor::div[@role='presentation']/span")
    WebElement CourtHeader;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement CourtMenuIcon;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CourtFilterIcon;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CourtSearchBar;


    // 3. Navigate To Prosecutor


    @FindBy(id = "add-prosecutor-btn")
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

    @FindBy(id = "add-judge-btn")
    WebElement AddJudgeBtn;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement SearchBar;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath="//span[contains(text(),'Jury')]/ancestor::div[@ref='eLabel']/span")
    WebElement JudgeHeader;
    @FindBy(id="btn-court")
    WebElement CreateCourt;
    @FindBy(xpath="//span[contains(text(),'Jury')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement JudgeMenu;
    @FindBy(xpath = "//span[contains(text(),'Jury')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement JuryHeader;
    @FindBy(xpath="//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ContactName']//span[@class='ellipsisAgGrid']")
    WebElement JudgeNameColData;
    @FindBy(xpath = "//mat-icon[contains(text(),'add_box')]")
    WebElement CreateNewProsecutor;
    @FindBy(xpath = "//div[@class='prosecutor']//div[contains(text(),'No data available...')]")
    WebElement NoDataInProsecutor;
    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement DltConfirmBtn;

    @FindBy(xpath = "//button[@title='Delete']//i")
    WebElement CourtDeleteBtn;

    @FindBy(xpath = "//div[contains(text(),'No data available...')]")
    WebElement NDAinGrid;

    @FindBy(xpath = "//div[@col-id='Notes']//button")
    WebElement NotesIcon;


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
    public ILiglPage addExistingProsecutor(String CounselFullName)throws Exception
    {
        log_Info("addExistingProsecutor() Started");

        log_Info("Click on Add Prosecutor Button");
        Thread.sleep(5000);
        AddProsecutor.click();
        log_Info("Clicked on Add Prosecutor Button");

        Thread.sleep(5000);
        getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+CounselFullName+"')]")).click();
        log_Info("Clicked on Add Prosecutor Button");

        log_Info("Click on Add Left Arrow Button");
        Thread.sleep(5000);
        LeftArrow.click();
        log_Info("Clicked on Add Left Arrow Button");

        log_Info("Click on Save Button");
        Thread.sleep(5000);
        SaveBtn.click();
        log_Info("Clicked on Save Button");

        return new CaseCourtListPage();
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

    public ILiglPage validateSecondSearchAddedCourts(String CourtAdded) throws Exception{

        try {
            log_Info("validateAddedCourts() started");
            secondSearchCourt(CourtAdded);
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


            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddJudgeBtn);

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
    /**
     * Method to create New Court to case
     * @return
     * @throws Exception
     */
    public ILiglPage createNewCourt(String CourtName,String PartyType,String Desc,String Status) throws Exception {
        try{
            log_Info("addNewCourt() Started");
            AddCourtBtn.click();
            CreateCourt.click();
            Thread.sleep(5000);
            CaseOtherPartyPage COPP=new CaseOtherPartyPage();
            COPP.addingNewParty(CourtName,PartyType,Status,Desc);
            return new CaseCourtListPage();
        }catch(Exception | Error ex){
            log_Error("createNewCourt Failed");
            throw new Exception("Exception in createNewCourt()");
        }
    }

    /**
     * Method to Validate the added Court Added to Court Grid
     * @param CourtName
     * @return
     * @throws Exception
     */
    public ILiglPage validateCourtAddedToGrid(String CourtName) throws Exception {
        try{
            log_Info("validateCourtAddedToGrid() Started");
            searchCourt(CourtName);
            boolean b= getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+CourtName+"')]")).isDisplayed();
            Assert.assertEquals(true, b);
            log_Info("Court Created And Added to Grid Successflly");
            return new CaseCourtListPage();
        }catch(Exception | Error ex){
            log_Error("validateCourtAddedToGrid() Failed");
            throw new Exception("Exception in validateCourtAddedToGrid()", ex);
        }
    }
    /**
     * Searches Particular Court in grid
     * @param Court
     * @return
     * @throws Exception
     */
    public ILiglPage searchCourt(String Court) throws Exception {
        try{
            log_Info("searchCourt() started");
            log_Info("Click On Court Header");
            CourtHeader.click();
            log_Pass("Clicked On Court Header");
            Thread.sleep(2000);
            log_Info("Click On Filter Icon");
            Filter.click();
            log_Pass("Clicked On Filter Icon");
            Thread.sleep(2000);
            log_Info("Search The Required Court");
            SearchBar.sendKeys(Court);
            log_Pass("Searched The Required Court");
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Court+"')]")).click();

            return new CaseCourtListPage();

        }catch(Exception | Error ex){
            log_Error("searchCourt() Failed");
            throw new Exception("Exception in searchCourt()",ex);
        }
    }
    /**
     * Method to Create New Judge to case
     * @param conJudgeFN
     * @param conJudgeLN
     * @return CaseCourtListPage()
     * @throws Exception
     */
    public ILiglPage createNewJudge(String conJudgeFN,String conJudgeLN) throws Exception {
        try{


            log_Info("createNewJudge() started");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddJudgeBtn);
            AddJudgeBtn.click();
            CreateCourt.click();
            CaseOtherPartyPage COPP=new CaseOtherPartyPage();
            COPP.addCounsel(conJudgeFN,conJudgeLN);
            log_Info("Judge created successfully");
            Thread.sleep(3000);

            return new CaseCourtListPage();
        }catch(Exception | Error ex){
            log_Error("createNewJudge() Failed");
            throw new Exception("Exception in createNewJudge()",ex);
        }
    }
    /**
     * validating judge added/cretaed is adding to grid or not
     * @param conFN
     * @param conLN
     * @return CaseCourtListPage()
     * @throws Exception
     */
    public ILiglPage validateJudgeAddedToGrid(String conFN,String conLN) throws Exception{
        try{

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddJudgeBtn);
            log_Info("Call searchJudge Method");
            searchJudge(conFN,conLN);
            log_Info("Judge Record Searched");
            String counselFullName=conFN+" "+conLN;
            boolean b = getCurrentDriver().findElement(By.xpath("//span[contains(text(), '"+counselFullName+"')]")).isEnabled();
            Assert.assertEquals(true, b);
            log_Info("Judge Added To Grid Successfully");
            return new CaseCourtListPage();
        }catch (Exception | Error ex){
            log_Error("validateJudgeAddedToGrid() Failed");
            throw new Exception("Exception in validateJudgeAddedToGrid()", ex);
        }
    }
    /**
     * Creates New Prosecutor From +Prosecutor Button in Case->Court->+Prosecutor
     * @param CounselFN
     * @param CounselLN
     * @return CaseCourtListPage
     * @throws Exception
     */
    public ILiglPage createNewProsecutor(String CounselFN,String CounselLN) throws Exception{
        try{
            Thread.sleep(3000);
            log_Info("createNewProsecutor() Started");
            AddProsecutor.click();
            Thread.sleep(3000);
            CreateNewProsecutor.click();
            Thread.sleep(3000);
            CaseOtherPartyPage cp=new CaseOtherPartyPage();
            cp.addCounsel(CounselFN,CounselLN);
            Thread.sleep(3000);

            return new CaseCourtListPage();
        }catch (Exception | Error ex){
            log_Error("createNewProsecutor() Failed");
            throw new Exception("Exception in createNewProsecutor()", ex);
        }
    }
    /**
     * Method to Validate Prosecutor Added/Created is Added to Grid or not
     * @param FirstName
     * @param LastName
     * @return CaseCourtListPage
     * @throws Exception
     */
    public ILiglPage validateProsecutorAddedToGrid(String FirstName,String LastName) throws Exception {
        try {
            log_Info("validateProsecutorAddedToGrid() started");
            Thread.sleep(5000);
            searchProsecutor(FirstName,LastName);
            String s =(FirstName+" "+LastName);
            getCurrentDriver().findElement(By.cssSelector("span[title='"+s+"']")).isDisplayed();
            log_Info("xpathMTD() Executed");
            return new CaseCourtListPage();
        } catch (Exception | Error ex) {
            log_Error("validateProsecutorAddedToGrid() Failed");
            throw new Exception("Exception in validateProsecutorAddedToGrid()", ex);
        }
    }
    /**
     * Method To Delete Prosecutor From Grid
     * @param FirstName
     * @param LastName
     * @return CaseCourtListPage
     * @throws Exception
     */
    public ILiglPage deleteProsecutor(String FirstName, String LastName) throws Exception{
        try{
            log_Info("deleteProsecutor() Started");
            Thread.sleep(3000);
            String s =(FirstName+" "+LastName);
            getCurrentDriver().findElement(By.xpath("//div[@class='prosecutor']//span[@title='"+s+"']/ancestor::div[@role='row']//button")).click();
            Thread.sleep(3000);
            DltConfirmBtn.click();
            Thread.sleep(3000);
            secondSearchProsecutor(FirstName,LastName);
            Thread.sleep(3000);
            NoDataInProsecutor.isEnabled();
            log_Pass("Record Deleted Successfully");
            return new CaseCourtListPage();
        }catch (Exception | Error ex){
            log_Error("deleteProsecutor Failed");
            throw new Exception("Exception in deleteProsecutor()",ex);
        }
    }
    /**
     * Method to perform Search Second time(Without Filter)
     * @param s1
     * @param s2
     * @return
     * @throws Exception
     */
    public ILiglPage secondSearchProsecutor(String s1, String s2) throws Exception{
        try {
            log_Info("searchProsecutor() Started");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Prosecutor/Advocacy')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")).click();
            //Filter.click();
            SearchBar.sendKeys(s1+" "+s2);
            log_Pass("Prosecutor Entered in Search Bar");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error("searchProsecutor() Failed");
            throw new Exception("Exception in searchProsecutor()", ex);
        }
    }
    /**
     * Searches Prosecutor in Grid
     * @param s1
     * @param s2
     * @return CaseCourtListPage
     * @throws Exception
     */
    public ILiglPage searchProsecutor(String s1, String s2) throws Exception{
        try {
            log_Info("searchProsecutor() Started");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'Prosecutor/Advocacy')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")).click();

            /*if(!SearchBar.isDisplayed())*/
            Filter.click();
            SearchBar.sendKeys(s1+" "+s2);
            //getCurrentDriver().findElement(By.xpath("//span[@class='ag-icon ag-icon-menu']")).click();

            log_Pass("Prosecutor Entered in Search Bar");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error("searchProsecutor() Failed");
            throw new Exception("Exception in searchProsecutor()", ex);
        }
    }
    public ILiglPage navigateToProsecutor()throws Exception{
        try{
            log_Info("navigateToProsecutor() Started");
            log_Info("Click on Particular Court Name");
            Thread.sleep(5000);
            log_Info("Clicked on Particular Court Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddProsecutor);
            return new CaseCourtListPage();
        }catch (Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("navigateToProsecutor() Failed",ex);
        }
    }
    /**
     * Method to Search the Judge Record in Judge Grid
     * @param conFN
     * @param conLN
     * @return
     * @throws Exception
     */
    public ILiglPage searchJudge(String conFN,String conLN) throws Exception{
        try{
            JuryHeader.click();
            //Menu.click();
            Filter.click();
            String s=(conFN+" "+conLN);
            SearchBar.sendKeys(s);
            return new CaseCourtListPage();
        }catch (Exception | Error ex){
            log_Error("searchJudge() is Failed");
            throw new Exception("Exception in searchJudge()", ex);
        }
    }

    public ILiglPage deleteCourt(String CourtName) throws Exception{
        try{

            log_Info("deleteCourt() Started");
            Thread.sleep(1000);
            log_Info("Click On Delete Button");
            CourtDeleteBtn.click();
            Thread.sleep(1000);
            log_Pass("Clicked On Delete Button");
            Thread.sleep(1000);
            log_Info("Click On Yes Button In PopUp");
            Thread.sleep(1000);
            DltConfirmBtn.click();
            Thread.sleep(1000);
            log_Info("Clicked On Yes Button In PopUp");
            searchingAddedCourtAfterDeleting(CourtName);
            Thread.sleep(2000);
            NDAinGrid.isEnabled();
            log_Pass("Record Deleted Successfully");
            return new CaseCourtListPage();

        }catch (Exception | Error ex){
            log_Error("deleteCourt Failed");
            throw new Exception("Exception in deleteCourt()",ex);
        }
    }

    public ILiglPage secondSearchCourt(String Court) throws Exception {
        try{
            log_Info("secondSearchCourt() started");
            log_Info("Clear Data In Search Bar");
            SearchBar.clear();
            log_Info("Cleared Data In Search Bar");
            Thread.sleep(2000);
            SearchBar.sendKeys(Court);
            log_Pass("Searched The Required Court");
            Thread.sleep(2000);

            return new CaseCourtListPage();

        }catch(Exception | Error ex){
            log_Error("searchCourt() Failed");
            throw new Exception("Exception in searchCourt()",ex);
        }
    }

    public ILiglPage clickingOnNotesIconInCourtGrid() throws Exception {

        try {
            log_Info("clickingOnNotesIcon() Started");
            log_Info("click on Notes Icon");
            Thread.sleep(2000);
            NotesIcon.click();
            log_Pass("Clicked on Notes Icon");

            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickingOnNotesIconInCourtGrid() Failed");


        }
    }

    public ILiglPage searchingAddedCourtAfterDeleting(String AvailableCourt) throws Exception {

        try {

            log_Info("click on Court Menu icon");
            CourtMenuIcon.click();
            getDriver().minWait();
            log_Info("clicked on Court Menu icon");

            log_Info("Clear Court From Search Bar");
            CourtSearchBar.clear();
            log_Info("Cleared Court From Search Bar");

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
}
