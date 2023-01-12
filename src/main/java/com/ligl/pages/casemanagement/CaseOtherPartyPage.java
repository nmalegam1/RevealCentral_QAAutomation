package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.naming.Name;
import java.util.concurrent.TimeUnit;

public class CaseOtherPartyPage extends LiglBaseSessionPage {

    // Web Elements For Other Party

    @FindBy(id = "add-case-doc-btn")
    WebElement AddParty;

    @FindBy(id = "select-party-type-third-party")
    WebElement PartyDropDown;


    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_right')]")
    WebElement LeftArrow;

    @FindBy(id = "send-approval-btn")
    WebElement SaveBtn;


    @FindBy(id = "createNewContact")
    WebElement AddContactBtn;

    @FindBy(xpath = "//button[@id='add-btn']")
    WebElement AddContact;

    @FindBy(id = "firstname")
    WebElement FirstNameBox;

    @FindBy(id = "lastname")
    WebElement LastNameBox;

    @FindBy(id = "save-button")
    WebElement CreateButton;


    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement FilterIcon;

    @FindBy(xpath = "//span[contains(text(),'Party')]/ancestor::div[@ref='eLabel']/span")
    WebElement PartyHeader;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement MenuIcon;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement SearchBarIcon;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesBtn;

    @FindBy(id = "btn-addparty")
    WebElement AddPropertyBtn;

    @FindBy(id = "party-name")
    WebElement NameParty;

    @FindBy(id = "sel-party-type")
    WebElement PartyTypeDrpDwn;

    //@FindBy(xpath = "//div[@id='sel-party-type-panel']//input[@type='text']")

    @FindBy(xpath = "//mat-select[@title='mat-select']")
    WebElement PartyTypeSearchBar;

    @FindBy(xpath= "//mat-select[@title='select-law-firm-third-party']")
    WebElement LawFirmDrpDwn;

    @FindBy(xpath = "//*[@id='description']")
    WebElement DescriptionTextBox;


    @FindBy(xpath = "//span[@title='Create 109']//span")
    WebElement PartyName4;

    @FindBy(xpath = "//button[contains(text(),'In-House Counsel')]")
    WebElement AddInHouseCounselBtn;

    @FindBy(xpath = "//button[contains(text(),' Counsel ')]")
    WebElement AddCounselBtn;


    @FindBy(id = "inhouse-assign-btn")
    WebElement InHouseSaveBtn;

    @FindBy(id = "outsideRadio-button")
    WebElement OutsideBtn;

    @FindBy(xpath = "//button[contains(text(),'Outside Counsel')]")
    WebElement AddOutsideCounselBtn;

    @FindBy(id = "add-lawfirm-outside-btn")
    WebElement AddLawFirmBtn;

    @FindBy(id = "select-status")
    WebElement StatusDropDown;

    @FindBy(xpath = "//mat-select[@title='select-law-firm-third-party']")
    WebElement SelectLawFirmDrpDwn;


    @FindBy(id = "cancel-btn")
    WebElement CounselBtn;

    @FindBy(xpath = "//span[contains(text(),'Contact')]/ancestor::div[@ref='eLabel']")
    WebElement ContactHeader;

    @FindBy(xpath = "//span[contains(text(),'Contact')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement ContactMenu;


    @FindBy(id = "btn-clear")
    WebElement FilterBtn;

    @FindBy(xpath = "//app-third-party-contacts-main[@class='ng-star-inserted']//div[contains(text(),'No data available...')]")
    WebElement NoDataAvailableContact;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]/ancestor::div[@ref='eLabel']")
    WebElement InHouseCounselHeader;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement InHouseCounselMenu;


    @FindBy(xpath = "//span[contains(text(),'Law Firm')]/ancestor::div[@ref='eLabel']")
    WebElement OutSideCounselLawFirmHeader;

    @FindBy(xpath = "//span[contains(text(),'Law Firm')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement OutSideCounselLawFirmMenu;


    // Process Of Searching A Particular Party Through Filter

    public ILiglPage searchingParty() throws Exception {

        try {

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(PartyHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on Party menu icon");
            MenuIcon.click();
            log_Info("clicked on Party menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchingParty() Failed", ex);

        }
    }


    //  Process Of Creating New Party Through Other Party

    public ILiglPage addingNewParty(String PartyName,String PartyType,String Description) throws Exception {

        try {

            log_Info("Click on Add Party Button");
            getDriver().waitForelementToBeClickable(AddParty);
            Thread.sleep(5000);
            AddParty.click();
            getSession().log_Pass("Clicked on Add Party Button");


            log_Info("Click on Add Party Button Inside");
            getDriver().waitForelementToBeClickable(AddPropertyBtn);
            Thread.sleep(5000);
            AddPropertyBtn.click();
            getSession().log_Pass("Clicked on Add Party Button inside");


            log_Info("Click on Name TextBox In Party");
            getDriver().waitForelementToBeClickable(NameParty);
            Thread.sleep(5000);
            NameParty.sendKeys(PartyName);
            getSession().log_Pass("Clicked on Name TextBox In Party");


            log_Info("Click on Party Type Drop Down");
            getDriver().waitForelementToBeClickable(PartyTypeDrpDwn);
            Thread.sleep(5000);
            PartyTypeDrpDwn.sendKeys(PartyType);
            PartyTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");


            log_Info("Click on Description TextBox");
            getDriver().waitForelementToBeClickable(DescriptionTextBox);
            Thread.sleep(5000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addingNewParty() Failed", ex);
        }
    }

    // 4. Process Of Adding  Existing Party Through Other Party

    public ILiglPage addingExistingParty(String PartyNameA,String PartyNew) throws Exception {

        try {

            log_Info("Click on Add Party Button");
            getDriver().waitForelementToBeClickable(AddParty);
            Thread.sleep(5000);
            AddParty.click();
            getSession().log_Pass("Clicked on Add Party Button");

            log_Info("Click on Select Party Type Drop Down");
            getDriver().waitForelementToBeClickable(PartyDropDown);
            Thread.sleep(5000);
            PartyDropDown.click();
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+PartyNameA+"')]")).click();
            getSession().log_Pass("Clicked on Select Party Type Drop Down");

            Thread.sleep(5000);
            //((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", NewParty);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+PartyNew+"')]")).click();

            log_Info("Click On Left Arrow Button ");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            getSession().log_Pass("Clicked On Left Arrow Button");

            log_Info("Click On Save Button ");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked On save Button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addingExistingParty() Failed", ex);
        }

    }


    // 4. Process Of Creating New Contact For Selected Party Using +Contact Button

    public ILiglPage createNewContactForSelectedParty(String PartyNew,String FirstName ,String LastName) throws Exception {

        try {

            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNew+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            log_Info("Click On Add Contact Button");
            getDriver().waitForelementToBeClickable(AddContactBtn);
            Thread.sleep(5000);
            AddContactBtn.click();
            getSession().log_Pass("Clicked On Add Contact Button");

            log_Info("Click On Add Contact icon");
            getDriver().waitForelementToBeClickable(AddContact);
            Thread.sleep(5000);
            AddContact.click();
            getSession().log_Pass("Clicked On Add Contact icon ");

            log_Info("Click On First Name");
            getDriver().waitForelementToBeClickable(FirstNameBox);
            Thread.sleep(5000);
            FirstNameBox.sendKeys(FirstName);
            log_Info("Clicked On First Name");

            log_Info("Click On Last Name");
            getDriver().waitForelementToBeClickable(LastNameBox);
            Thread.sleep(5000);
            LastNameBox.sendKeys(LastName);
            log_Info("Clicked On Last Name");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");

            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNew+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", FilterBtn);
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception(" createNewContactForSelectedParty() Failed", ex);
        }
    }

    // 4. Searching The Contact Through Filter

    public ILiglPage searchingContact(String ContactName) throws Exception{

        try{

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(ContactHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            ContactMenu.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter Contact from search bar");
            getDriver().waitForelementToBeClickable(SearchBarIcon);
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(ContactName);
            Thread.sleep(5000);
            log_Info("Entered Contact from search bar");
            return new CaseOtherPartyPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("searchingContact() Failed",ex);
        }
    }

    // 4. Validating The Contact Added For Party

    public ILiglPage validatingContactAddedForParty(String ContactName) throws Exception {

        try {

            log_Info("Check The Counsel In The Grid");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+ContactName+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseOtherPartyPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingContactAddedForParty()  Failed",ex);
        }

    }


    //5. process of deleting contacts added for party

    public ILiglPage deleteContactsAddedForParty(String PartyNew, String ContactName) throws Exception {

        try {

            log_Info("Enter PartyName from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(PartyNew);
            log_Info("Entered Party Name from search bar");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNew+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
            js.executeScript("window.scroll(0,1000)");

            log_Info("Click Delete icon");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//app-third-party-contacts-main[@class='ng-star-inserted']//span[@title='"+ContactName+"']/ancestor::div[@role='row']//button")).click();
            getSession().log_Pass("Clicked Delete icon");

            log_Info("Click On Yes Button");
            getDriver().waitForelementToBeClickable(YesBtn);
            Thread.sleep(5000);
            YesBtn.click();
            getSession().log_Pass("Clicked On Yes Button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("deleteContactsAddedForParty() Failed", ex);

        }
    }

    // Validating The Contatcts After Deleting The Contatcts From The Party


    public ILiglPage validatingContactsAfterDeletingFromParty() throws Exception{

        try {

            log_Info("Check The Grid As No Data Available Text");
            boolean a1 = NoDataAvailableContact.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseOtherPartyPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateInHouseCounsel() Failed",ex);
        }
    }

    // 6. Create New In House Counsel For Enterprise Party

    public ILiglPage createNewInHouseCounselForEnterpriseParty(String PartyName,String FirstName,String LastName) throws Exception {

        try {

            log_Info("Enter PartyName from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(PartyName);
            log_Info("Entered Party Name from search bar");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyName+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddInHouseCounselBtn);

            log_Info("Click On Add In House Counsel Button");
            getDriver().waitForelementToBeClickable(AddInHouseCounselBtn);
            Thread.sleep(5000);
            AddInHouseCounselBtn.click();
            getSession().log_Pass("Clicked On Add In House Counsel Button");


            log_Info("Click On Add Counsel Button");
            getDriver().waitForelementToBeClickable(AddCounselBtn);
            Thread.sleep(5000);
            AddCounselBtn.click();
            getSession().log_Pass("Clicked On Add Counsel Button");

            log_Info("Click On First Name");
            getDriver().waitForelementToBeClickable(FirstNameBox);
            Thread.sleep(5000);
            FirstNameBox.sendKeys(FirstName);
            log_Info("Clicked On First Name");

            log_Info("Click On Last Name");
            getDriver().waitForelementToBeClickable(LastNameBox);
            Thread.sleep(5000);
            LastNameBox.sendKeys(LastName);
            log_Info("Clicked On Last Name");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception(" createNewInHouseCounselForEnterpriseParty() Failed", ex);
        }
    }

    // 6. Searching The In House Counsel Added For Party

    public ILiglPage searchingInHouseCounsel(String PartyName,String CounselName) throws Exception {

        try {

            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyName+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddInHouseCounselBtn);



            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(InHouseCounselHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on Counsel menu icon");
            InHouseCounselMenu.click();
            log_Info("clicked on Counsel menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter In House Counsel from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(CounselName);
            log_Info("Entered In House Counsel from search bar");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchingParty() Failed", ex);

        }
    }
    // 6. Validating The Added In House Counsel InThe Grid
    public ILiglPage validateAddedInHouseCounsel(String CounselName) throws Exception{

        try {

            log_Info("Check The Grid For The Added In House Counsels");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+CounselName+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseOtherPartyPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateAddedInHouseCounsel() Failed",ex);
        }
    }

    // Validate Counsel And Save Button For Party Type


    public ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB,String PartyType,String Description) throws Exception {

        try {

            log_Info("Click on Add Party Button");
            getDriver().waitForelementToBeClickable(AddParty);
            Thread.sleep(5000);
            AddParty.click();
            getSession().log_Pass("Clicked on Add Party Button");


            log_Info("Click on Add Party Button Inside");
            getDriver().waitForelementToBeClickable(AddPropertyBtn);
            Thread.sleep(5000);
            AddPropertyBtn.click();
            getSession().log_Pass("Clicked on Add Party Button inside");


            log_Info("Click on Name TextBox In Party");
            getDriver().waitForelementToBeClickable(NameParty);
            Thread.sleep(5000);
            NameParty.sendKeys(PartyNameB);
            getSession().log_Pass("Clicked on Name TextBox In Party");


            log_Info("Click on Party Type Drop Down");
            getDriver().waitForelementToBeClickable(PartyTypeDrpDwn);
            Thread.sleep(5000);
            PartyTypeDrpDwn.sendKeys(PartyType);
            PartyTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");


            log_Info("Click on Description TextBox");
            getDriver().waitForelementToBeClickable(DescriptionTextBox);
            Thread.sleep(5000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(PartyHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            MenuIcon.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter PartyName from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(PartyNameB);
            log_Info("Entered Party Name from search bar");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNameB+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddInHouseCounselBtn);

            log_Info("Click On Add In House Counsel Button");
            getDriver().waitForelementToBeClickable(AddInHouseCounselBtn);
            Thread.sleep(5000);
            AddInHouseCounselBtn.click();
            getSession().log_Pass("Clicked On Add In House Counsel Button");


            // validating the process counsel and save Button Is Enabled or Not

            log_Info("Check The Availability Of Save And Counsel Buttons");
            boolean a1 = AddCounselBtn.isDisplayed();
            boolean a2 = AddCounselBtn.isEnabled();
            System.out.println(a1);
            System.out.println(a2);
            log_Info("Click on Add Counsel button");
            AddCounselBtn.click();
            Thread.sleep(3000);
            boolean b1 = InHouseSaveBtn.isDisplayed();
            boolean b2 = InHouseSaveBtn.isEnabled();
            Thread.sleep(3000);
            System.out.println(b1);
            System.out.println(b2);
            Assert.assertEquals(false, a2);
            Assert.assertEquals(false, b2);
            return new CaseOtherPartyPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCounselAndSaveButtonForPartyType() Failed", ex);
        }
    }


    // Case-OtherParty-Outside Counsel-Process Of Creating new outside counsel using +Lawfirm Button

    public ILiglPage createOtherPartyNewOutsideCounsel(String PartyName,String NameTextBox,String PartyDrpDwn,String Description,String Status,String FirstName,String LastName) throws Exception {

        try {


            log_Info("Enter PartyName from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(PartyName);
            log_Info("Entered Party Name from search bar");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyName+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", OutsideBtn);

            log_Info("Click On Outside Counsel Button");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked On Outside Counsel Button");

            log_Info("Click On Add Outside Counsel Button");
            getDriver().waitForelementToBeClickable(AddOutsideCounselBtn);
            Thread.sleep(5000);
            AddOutsideCounselBtn.click();
            getSession().log_Pass("Clicked On Add Outside Counsel Button");

            log_Info("Click On Add LawFirm Button");
            getDriver().waitForelementToBeClickable(AddLawFirmBtn);
            Thread.sleep(5000);
            AddLawFirmBtn.click();
            getSession().log_Pass("Clicked On Add LawFirm Button");


            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", NameParty);


            log_Info("Click on Name TextBox In Party");
            getDriver().waitForelementToBeClickable(NameParty);
            Thread.sleep(5000);
            NameParty.sendKeys(NameTextBox);
            getSession().log_Pass("Clicked on Name TextBox In Party");


            log_Info("Click on Party Type Drop Down");
            getDriver().waitForelementToBeClickable(PartyTypeDrpDwn);
            Thread.sleep(5000);
            //PartyTypeDrpDwn.click();
            PartyTypeSearchBar.sendKeys(PartyDrpDwn);
            PartyTypeSearchBar.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");


            log_Info("Click on Description TextBox");
            getDriver().waitForelementToBeClickable(DescriptionTextBox);
            Thread.sleep(5000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");

            log_Info("Click On Status Drop Down");
            getDriver().waitForelementToBeClickable(StatusDropDown);
            Thread.sleep(5000);
            StatusDropDown.sendKeys(Status);
            StatusDropDown.sendKeys(Keys.ENTER);
            log_Info("Clicked On Status Drop Down");


            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyName+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", OutsideBtn);

            log_Info("Click On Outside Counsel Button");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked On Outside Counsel Button");

            log_Info("Click On Add Outside Counsel Button");
            getDriver().waitForelementToBeClickable(AddOutsideCounselBtn);
            Thread.sleep(5000);
            AddOutsideCounselBtn.click();
            getSession().log_Pass("Clicked On Add Outside Counsel Button");

            log_Info("Click On LawFirm Drop Down");
            getDriver().waitForelementToBeClickable(LawFirmDrpDwn);
            Thread.sleep(5000);
            LawFirmDrpDwn.sendKeys(NameTextBox);
            getSession().log_Pass("Clicked On LawFirm Drop Down");

            log_Info("Click On Add Counsel Button");
            getDriver().waitForelementToBeClickable(CounselBtn);
            Thread.sleep(5000);
            CounselBtn.click();
            getSession().log_Pass("Clicked On Add Counsel Button");

            log_Info("Click On First Name");
            getDriver().waitForelementToBeClickable(FirstNameBox);
            Thread.sleep(5000);
            FirstNameBox.sendKeys(FirstName);
            getSession().log_Pass("Clicked On First Name");

            log_Info("Click On Last Name");
            getDriver().waitForelementToBeClickable(LastNameBox);
            Thread.sleep(5000);
            LastNameBox.sendKeys(LastName);
            getSession().log_Pass("Clicked On Last Name");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");

            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyName+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", OutsideBtn);

            log_Info("Click On Outside Counsel Button");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked On Outside Counsel Button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createOtherPartyNewOutsideCounsel() Failed", ex);
        }
    }

    public ILiglPage validateAddedNewOutsideCounsel(String OutsideCounsel,String NameTextBox) throws Exception{

        try {

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(OutSideCounselLawFirmHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            OutSideCounselLawFirmMenu.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter LawFirm from search bar");
            getDriver().waitForelementToBeClickable(SearchBarIcon);
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(NameTextBox);
            Thread.sleep(5000);
            log_Info("Entered LawFirm from search bar");

            log_Info("Check The Grid For The Added Outside Counsels");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[@title='"+OutsideCounsel+"']")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseOtherPartyPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateAddedNewOutsideCounsel() Failed",ex);
        }
    }


    // 7129 Case - Other Party - Outside Counsel - Verify The Process Of Creating New Counsel For Selected Counsel(LawFirm) Using +Counsel Button In Model

    public ILiglPage createNewCounselForSelectedOutsideCounsel(String PartyNew,String OptionFromLawFirmDropDwn,String FirstName,String LastName) throws Exception {

        try {

            log_Info("Enter PartyName from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(PartyNew);
            log_Info("Entered Party Name from search bar");


            log_Info("Click On Party Name ");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNew+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", OutsideBtn);

            log_Info("Click On Outside Counsel Button");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked On Outside Counsel Button");

            log_Info("Click On Add Outside Counsel Button");
            getDriver().waitForelementToBeClickable(AddOutsideCounselBtn);
            Thread.sleep(5000);
            AddOutsideCounselBtn.click();
            getSession().log_Pass("Clicked On Add Outside Counsel Button");


            log_Info("Click and Select Law Firm Drop Down");
            Thread.sleep(5000);
            SelectLawFirmDrpDwn.click();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OptionFromLawFirmDropDwn+"')]")).click();
            getSession().log_Pass("Clicked and Selected Law Firm Drop Down");


            log_Info("Click On Add Counsel Button");
            getDriver().waitForelementToBeClickable(CounselBtn);
            Thread.sleep(5000);
            CounselBtn.click();
            getSession().log_Pass("Clicked On Add Counsel Button");

            log_Info("Click On First Name");
            getDriver().waitForelementToBeClickable(FirstNameBox);
            Thread.sleep(5000);
            FirstNameBox.sendKeys(FirstName);
            log_Info("Clicked On First Name");

            log_Info("Click On Last Name");
            getDriver().waitForelementToBeClickable(LastNameBox);
            Thread.sleep(5000);
            LastNameBox.sendKeys(LastName);
            log_Info("Clicked On Last Name");

            log_Info("Click On create button");
            getDriver().waitForelementToBeClickable(CreateButton);
            Thread.sleep(5000);
            CreateButton.click();
            log_Info("Clicked On create button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewCounselForSelectedOutsideCounsel() Failed", ex);
        }
    }

    // Searching The Added Out Counsel For The Party

    public ILiglPage searchingOutSideCounsel(String PartyNew,String OptionFromLawFirmDropDwn) throws Exception {

        try {

            log_Info("Click On Party Name ");
            getDriver().waitForelementToBeClickable(PartyName4);
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+PartyNew+"']//span")).click();
            getSession().log_Pass("Clicked On Party Name");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", AddInHouseCounselBtn);

            log_Info("Click On Outside Counsel Button");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked On Outside Counsel Button");


            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(OutSideCounselLawFirmHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on Counsel menu icon");
            OutSideCounselLawFirmMenu.click();
            log_Info("clicked on Counsel menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(5000);
            FilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter In House Counsel from search bar");
            Thread.sleep(5000);
            SearchBarIcon.sendKeys(OptionFromLawFirmDropDwn);
            log_Info("Entered In House Counsel from search bar");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchingOutSideCounsel() Failed", ex);

        }
    }
    // Validating The Added Outside Counsel InThe Grid

    public ILiglPage validateAddedOutsideCounsel(String OutSideCounselName) throws Exception{

        try {

            log_Info("Check The Grid For The Added Outside Counsels");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OutSideCounselName+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseOtherPartyPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateAddedInHouseCounsel() Failed",ex);
        }
    }
}
