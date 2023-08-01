package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.NotesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.inject.Inject;
import javax.naming.Name;
import java.util.concurrent.TimeUnit;

public class CaseOtherPartyPage extends LiglBaseSessionPage {

    // Web Elements For Other Party

    @FindBy(id = "add-party-btn")
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

    @FindBy(id = "sel-party-typepartyUUID")
    WebElement PartyTypeDrpDwn;

    @FindBy(xpath = "//mat-select[@title='mat-select']")
    WebElement PartyTypeSearchBar;

    @FindBy(xpath= "//mat-select[@title='select-law-firm-third-party']")
    WebElement LawFirmDrpDwn;

    @FindBy(xpath = "//input[@id='description']")
    WebElement DescriptionTextBox;


    @FindBy(xpath = "//span[@title='Create 109']//span")
    WebElement PartyName4;

    @FindBy(id = "inhouse-btn")
    WebElement AddInHouseCounselBtn;

    @FindBy(xpath = "//button[@id='add-counsel-inhouse-btn']")
    WebElement AddCounselBtn;


    @FindBy(id = "inhouse-assign-btn")
    WebElement InHouseSaveBtn;

    @FindBy(id = "outsideRadio-button")
    WebElement OutsideBtn;

    @FindBy(xpath = "//button[contains(text(),'OUTHOUSE COUNSEL')]")
    WebElement AddOutsideCounselBtn;

    @FindBy(id = "add-lawfirm-outside-btn")
    WebElement AddLawFirmBtn;

    @FindBy(id = "party-add-select-statusstatusUUID")
    WebElement StatusDropDown;

    @FindBy(xpath = "//mat-select[@title='select-law-firm-third-party']")
    WebElement SelectLawFirmDrpDwn;


    @FindBy(id = "third-party-add-counsel-inhouse-btn")
    WebElement CounselBtn;

    @FindBy(xpath = "//div[@col-id='ContactName']//div[@role='presentation']//span")
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

    @FindBy(id = "party-add-select-statusstatusUUID")
    WebElement PartyStatusDrpdwn;
    @FindBy(id = "add-case-doc-btn-thirdparty-new")
    WebElement AddOutSideCounsel;
    @FindBy(xpath="//mat-select[@title='select-law-firm-third-party']")
    WebElement LawFirmDP;
    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    WebElement DeleteIcon;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement PartySearchBar;
    @FindBy(id="outsideRadio-button")
    WebElement OutSideRadioButton;
    @FindBy(xpath = "//div[contains(text(),' No data available...')]")
    WebElement NodataAvailable;
    @FindBy(id="select-contact")
    WebElement ExistingContactsDropDown;
    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']")
    WebElement Filter;
    @FindBy(css="input[placeholder='Filter...']")
    WebElement SearchBar;
    @FindBy(css="input[placeholder='Search']")
    WebElement InhouseSearchBar;
    @FindBy(id="inhouse-btn")
    WebElement AddInHouseCounsel;
    @FindBy(id="btn-addparty")
    WebElement CreatePartyBtn;
    @FindBy(id="third-party-save-btn")
    WebElement ConSaveBtn;
    @FindBy(id="outside-assign-btn")
    WebElement OutSideCounselSave;
    @FindBy(id="select-contacts-dpdwn")
    WebElement ExistingContDP;
    @FindBy(id="inhouse-assign-btn")
    WebElement InHouseAssignBTN;
    @FindBy(xpath = "//span[contains(text(),'Counsel')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement CounselHeader;

    @FindBy(xpath = "//div[@id='select-contacts-dpdwn-panel']//input[@type='text']")
    WebElement ExistingLawFirmSearchBar;

    @FindBy(xpath = "//div[@col-id='Notes']//button")
    WebElement NotesIcon;

    @FindBy(xpath = "//div[contains(text(),'Counsel Related Information')]")
    WebElement HeaderContactName;

    @FindBy(xpath = "//div[contains(text(),' List of Other Party Contact ')]")
    WebElement OtherPartyContactHeader;



    // Process Of Searching A Particular Party Through Filter

    public ILiglPage searchingParty(String PartyName) throws Exception {

        try {

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(PartyHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(2000);


            log_Info("click on Party menu icon");
            MenuIcon.click();
            log_Info("clicked on Party menu icon");
            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(FilterIcon);
            Thread.sleep(2000);
            FilterIcon.click();
            log_Info("Filter Clicked");
            getDriver().waitForelementToBeClickable(SearchBarIcon);
            Thread.sleep(2000);
            SearchBarIcon.sendKeys(PartyName);
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[@col-id='PartyName']//span[@title='"+PartyName+"']")).click();

            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchingParty() Failed", ex);

        }
    }

    /**
     * Method to validate Added party is added to party Grid
     * @param PartyName
     * @return
     * @throws Exception
     */
    public ILiglPage validatePartyCreatedOrNot(String PartyName) throws Exception{
        try{
            log_Info("validatePartyCreatedOrNot() Started");
            Thread.sleep(3000);
            Actions ac = new Actions(getCurrentDriver());
            log_Info("ValidatePartyCreatedOrNot() Started");
            ac.moveToElement(PartyHeader).perform();
            searchingParty(PartyName);
            boolean b = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+PartyName+"')]")) .isDisplayed();
            Assert.assertEquals(true, b);
            log_Pass("Created New party Added To Grid SuccessFully");
            return new CaseOtherPartyPage();
        }catch (Exception ex){
            throw new Exception("Exception in validatePartyCreatedOrNot()",ex);
        }
    }

    public ILiglPage clickAddPartyBtns()throws Exception{
        Thread.sleep(5000);
        AddParty.click();
        getSession().log_Pass("Clicked on Add Party Button");
        log_Info("Click on Add Party Button Inside");

        Thread.sleep(5000);
        AddPropertyBtn.click();
        getSession().log_Pass("Clicked on Add Party Button inside");
        return new CaseOtherPartyPage();
    }
    //  Process Of Creating New Party Through Other Party

    public ILiglPage addingNewParty(String PartyName, String PartyType, String Status, String Description) throws Exception {

        try {

            log_Info("addingNewParty() Started");

            log_Info("Click on Name TextBox In Party");
            Thread.sleep(2000);
            NameParty.sendKeys(PartyName);
            getSession().log_Pass("Clicked on Name TextBox In Party");


            log_Info("Click on Party Type Drop Down");
            Thread.sleep(2000);
            PartyTypeDrpDwn.sendKeys(PartyType);
            Thread.sleep(2000);
            PartyTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");

            Thread.sleep(3000);
            PartyStatusDrpdwn.sendKeys(Status);
            Thread.sleep(2000);
            PartyStatusDrpdwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Click on Status Drop Down");

            log_Info("Click on Description TextBox");
            Thread.sleep(2000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");


            log_Info("Click On create button");
            Thread.sleep(2000);
            CreateButton.click();
            log_Info("Clicked On create button");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addingNewParty() Failed", ex);
        }
    }

    // 4. Process Of Adding  Existing Party Through Other Party

    public ILiglPage addingExistingParty(String PartyName,String PartyType) throws Exception {

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
            getCurrentDriver().findElement(By.xpath("//mat-option//span[contains(text(),'"+PartyName+"')]")).click();
            getSession().log_Pass("Clicked on Select Party Type Drop Down");

            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//mat-radio-button//div[contains(text(),'"+PartyType+"')]")).click();

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

            Thread.sleep(2000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", OtherPartyContactHeader);

            log_Info("Click On Add Contact Button");
            getDriver().waitForelementToBeClickable(AddContactBtn);
            Thread.sleep(5000);
            AddContactBtn.click();
            getSession().log_Pass("Clicked On Add Contact Button");

            log_Info("Click On Add Contact icon");
            getDriver().waitForelementToBeClickable(AddContact);
            Thread.sleep(5000);
            AddContact.click();
            getSession().log_Pass("Clicked On Add Contact icon");

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
            AddCounselBtn.sendKeys(Keys.ESCAPE);
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


    public ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB,String PartyType,String Description,String StatusDrpdown) throws Exception {

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
            Thread.sleep(5000);
            PartyTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");


            log_Info("Click on Description TextBox");
            getDriver().waitForelementToBeClickable(DescriptionTextBox);
            Thread.sleep(5000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");

            log_Info("Click on Status Drop Down");
            getDriver().waitForelementToBeClickable(StatusDropDown);
            Thread.sleep(5000);
            StatusDropDown.sendKeys(StatusDrpdown);
            Thread.sleep(5000);
            StatusDropDown.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Status Drop Down");

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
            Thread.sleep(3000);
            boolean a1 = AddCounselBtn.isDisplayed();
            boolean a2 = AddCounselBtn.isEnabled();
            System.out.println(a1);
            System.out.println(a2);
            log_Info("Click on Add Counsel button");
            ExistingLawFirmSearchBar.sendKeys(Keys.ESCAPE);
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
            PartyTypeSearchBar.sendKeys(PartyDrpDwn);
            Thread.sleep(5000);
            PartyTypeSearchBar.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Party Type Drop Down");


            log_Info("Click on Description TextBox");
            getDriver().waitForelementToBeClickable(DescriptionTextBox);
            Thread.sleep(5000);
            DescriptionTextBox.sendKeys(Description);
            getSession().log_Pass("Clicked on Description TextBox");

            log_Info("Click On Status Drop Down");
            getDriver().waitForelementToBeClickable(PartyStatusDrpdwn);
            Thread.sleep(5000);
            PartyStatusDrpdwn.sendKeys(Status);
            Thread.sleep(5000);
            PartyStatusDrpdwn.sendKeys(Keys.ENTER);
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

    public ILiglPage deletingAddedParty(String PartyName) throws Exception {
        try {
            searchingParty(PartyName);
            Thread.sleep(5000);
            getDriver().waitForelementToBeClickable(DeleteIcon);
            Thread.sleep(3000);
            DeleteIcon.click();
            getSession().log_Pass("Delete Icon clicked");
            getDriver().waitForelementToBeClickable(YesBtn);
            Thread.sleep(3000);
            YesBtn.click();
            getSession().log_Pass("Delete Icon clicked");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("click on party delete icon Failed", ex);
        }

    }

    public ILiglPage validatedeletedparty(String PartyName) throws Exception
    {
        try {

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(PartyHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            log_Info("click on Party menu icon");
            MenuIcon.click();
            log_Info("clicked on Party menu icon");
            PartySearchBar.clear();
            PartySearchBar.sendKeys(PartyName);
            NodataAvailable.isDisplayed();
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchingParty() Failed", ex);

        }
    }

    /**
     * Method to create and validate party created and added to grid
     * @param PartyName
     * @param PartyType
     * @param Desc
     * @return CaseOtherPartyPage
     * @throws Exception
     */
    public ILiglPage createAndValidatePartyCreatedOrNot(String PartyName,String PartyType,String Desc,String Status) throws Exception {
        try {
            log_Info("createAndValidatePartyCreatedOrNot() Started");
            AddParty.click();
            CreatePartyBtn.click();
            addingNewParty(PartyName,PartyType,Status,Desc);
            validatePartyCreatedOrNot(PartyName);
            return new CaseOtherPartyPage();
        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validatePartyCreatedOrNot() Failed", ex);
        }
    }

    /**
     * Method to navigate to Outside Counsel in Other Party page
     * @return
     * @throws Exception
     */
    public ILiglPage goToOutSideCounselInOtherParty() throws Exception{
        try{
            log_Info("goToOutSideCounselInOtherParty() Started");

            Thread.sleep(3000);
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", AddInHouseCounsel);
            OutSideRadioButton.click();
            return new CaseOtherPartyPage();
        }catch (Exception ex){
            log_Error("Exception in goToOutSideCounselInOtherParty()");
            throw new Exception("goToOutSideCounselInOtherParty() Failed" , ex);
        }
    }
    /**
     * Method to Add OutSide Counsel with AddCounsel Button using LawFirm To Outside Counsel Grid
     * @param Name
     * @param lawFirm
     * @param CounselFName
     * @param CounselLName
     * @param CounFullame
     * @return
     * @throws Exception
     */
    public ILiglPage addOutCounselWithAddLawFirmBtn(String Name,String lawFirm,String CounselFName, String CounselLName, String CounFullame) throws Exception{
        try{
            AddOutSideCounsel.click();
            LawFirmDP.click();
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+lawFirm+"')]")));
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+lawFirm+"')]")).click();
            AddCounselBtn.click();
            addCounsel(CounselFName,CounselLName);
            searchingParty(Name);
            goToOutSideCounselInOtherParty();
            Thread.sleep(5000);
            validateAddedOutsideCounsel(CounFullame);

            return new CaseOtherPartyPage();
        }catch (Exception ex){
            log_Error("Exception in AddOutCounselWithAddLawFirmBtn()");
            throw new Exception("AddOutCounselWithAddLawFirmBtn Failed");
        }
    }
    /**
     *Method Create New Counsel
     * @param s1
     * @param s2
     * @throws Exception
     */
    public void addCounsel(String s1,String s2) throws Exception{
        try{
            log_Info("addCounsel() Started");
            Thread.sleep(2000);
            FirstNameBox.sendKeys(s1);
            Thread.sleep(3000);
            LastNameBox.sendKeys(s2);
            Thread.sleep(3000);
            CreateButton.click();

        }catch(Exception ex){
            log_Error("addCounsel() Failed");
            throw new Exception("Exception in addCounsel()", ex);
        }
    }
    /**
     * Method to add Existing Contact to selected PArty
     * @param existingContact
     * @return
     * @throws Exception
     */
    public ILiglPage addExistingContact(String existingContact) throws Exception {
        try {

            log_Info("addExistingContact() Started");
            Thread.sleep(2000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", HeaderContactName);
            AddContactBtn.click();
            ExistingContactsDropDown.click();
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+existingContact+"')]")).click();
            ConSaveBtn.click();
            Thread.sleep(5000);
            ContactHeader.click();
            Thread.sleep(3000);
            Filter.click();
            SearchBar.sendKeys(existingContact);
            Thread.sleep(3000);
            boolean b = getCurrentDriver().findElement(By.cssSelector("span[title='"+existingContact+"']")).isDisplayed();
            Assert.assertEquals(true, b);
            log_Info("Contact Added Succesfully");

            return new CaseOtherPartyPage();
        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addExistingContact() Failed", ex);
        }
    }
    /**
     * Method to Add Existing InHouse Counsel to EnterPrice Party And Validate that Added to Grid or not
     * @param ExistingInCounsel
     * @return CaseOtherPartyPage()
     * @throws Exception
     */
    public ILiglPage addExistingInHouseCounselToParty(String ExistingInCounsel) throws Exception {
        try {
            log_Info("addExistingInHouseCounselToParty() Started");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);",AddInHouseCounsel);
            AddInHouseCounsel.click();
           /* Thread.sleep(5000);
            InhouseSearchBar.sendKeys(Keys.ESCAPE);*/
         /*   Thread.sleep(3000);
            ExistingContDP.click();*/
            InhouseSearchBar.sendKeys(ExistingInCounsel);
            Thread.sleep(5000);
            InhouseSearchBar.sendKeys(Keys.ENTER);
            /*getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+ExistingInCounsel+"')]")).click();*/
            Thread.sleep(2000);
            InHouseAssignBTN.click();
            Thread.sleep(2000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CounselHeader).perform();
            CounselHeader.click();
            Filter.click();
            SearchBar.sendKeys(ExistingInCounsel);
            Thread.sleep(5000);
            boolean b = getCurrentDriver().findElement(By.cssSelector("span[title='"+ExistingInCounsel+"']")).isDisplayed();
            Assert.assertEquals(true, b);
            log_Info("Enterprise Counsel Added Successfully");
            return new CaseOtherPartyPage();
        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addExistingInHouseCounselToParty() Failed", ex);
        }
    }

    /**
     * Method to Add Existing OutSide Counsel to Case Perty
     * @param lawFirm
     * @param lawFirmSubEntity
     * @return
     * @throws Exception
     */
    public ILiglPage addExistingOutCounsel(String lawFirm,String lawFirmSubEntity) throws Exception{
        try{
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", AddInHouseCounsel);
            OutSideRadioButton.click();
            AddOutSideCounsel.click();
            LawFirmDP.click();
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+lawFirm+"')]")).click();
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+lawFirmSubEntity+"')]")).click();
            LeftArrow.click();
            OutSideCounselSave.click();
            return new CaseOtherPartyPage();
        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addExistingOutCounsel() Failed", ex);
        }
    }

    public ILiglPage clickingOnNotesIconInOtherPartyGrid() throws Exception {

        try {
            log_Info("clickingOnNotesIcon() Started");
            log_Info("click on Notes Icon");
            Thread.sleep(2000);
            NotesIcon.click();
            log_Pass("Clicked on Notes Icon");

            return new NotesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickingONNotesIcon() Failed");


        }
    }
}