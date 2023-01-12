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

import javax.swing.plaf.basic.BasicSliderUI;
import java.util.concurrent.TimeUnit;

public class CaseCounselPage extends LiglBaseSessionPage {

    // 1.Web Elements For Add And Delete Inside Counsel
    @FindBy(id = "add-inhousecounsel-btn")
    WebElement InHouseCounselBtn;

    @FindBy(xpath = "//span[contains(text(),'Employment Status')]/ancestor::div[@ref='eLabel']")
    WebElement NameHeaderscroll;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']")
    WebElement NameHeader;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]/ancestor::div[@ref='eLabel']")
    WebElement CounselHeader;

    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement EmailMenu;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement CounselMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement filter;

    @FindBy(css= "input[placeholder='Filter...']")
    WebElement Searchbar;


    @FindBy(id = "edit-btn")
    WebElement AddToCase;

    @FindBy(xpath = "//i[@class='fa fa-trash']")
    WebElement DeleteIcon;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesBtn;

    // 2. Web Elements For add and delete outside counsel
    @FindBy(id = "outsideRadio")
    WebElement OutsideBtn;

    @FindBy(id = "add-case-doc-btn")
    WebElement AddOutsideCounsel;

    @FindBy(id = "select-law-firm")
    WebElement SelectLawFirmDrpDwn;

    @FindBy(xpath = "//mat-icon[contains(text(),'keyboard_arrow_right')]")
    WebElement LeftArrow;

    @FindBy(id = "send-approval-btn")
    WebElement SaveBtn;


    @FindBy(xpath = "//span[contains(text(),'CounselCase4 CounselCase3')]")
    WebElement AddedCounselName;


    @FindBy(xpath = "//span[@title='A CUSTODIAN']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement Employee2;


    // 3.  Web Elements For Create New Outside Counsel

    @FindBy(xpath = "//span[contains(text(),'LawFirmParty')]")
    WebElement OptionFromLawFirm112DrpDwn;

    @FindBy(id = "add-outside-counsel-btn")
    WebElement AddCounsel;

    @FindBy(id = "firstname")
    WebElement FirstNameBox;

    @FindBy(id = "lastname")
    WebElement LastNameBox;

    @FindBy(id = "save-button")
    WebElement CreateButton;

    // WebElements For LawFirm Search

    @FindBy(xpath = "//span[contains(text(),'Law Firm')]/ancestor::div[@ref='eLabel']/span")
    WebElement LawFirmHeader;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement LawMenuIcon;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement LawFilterIcon;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement LawSearchBar;

    @FindBy(xpath = "//span[@title='Created from case outside counsel']/span")
    WebElement LawFirmName;

    @FindBy(xpath = "//app-case-counsel-inhouse[@class='ng-star-inserted']//div[contains(text(),'No data available...')]")
    WebElement NoDataAvailableIn;

    @FindBy(xpath = "//app-case-counsel-outhouse[@class='ng-star-inserted']//div[contains(text(),'No data available...')]")
    WebElement NoDataAvailableOut;

    @FindBy(xpath = "//span[contains(text(),'2_Corp ')]")
    WebElement InHouseCounsel1;

    @FindBy(xpath = "//span[contains(text(),'A CUSTODIAN')]")
    WebElement InHouseCounsel2;


    // (1.DeletingInHouseCounsel_Test) Adding One Inhouse counsel To A Case

    public ILiglPage addInhouseCounselToCase(String Email1 ,String CounselName) throws Exception {

        try {

            log_Info("Click on Add In-House Counsel Button");
            getDriver().waitForelementToBeClickable(InHouseCounselBtn);
            Thread.sleep(5000);
            InHouseCounselBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on Add In-House Counsel Button");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", NameHeaderscroll);

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(NameHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            EmailMenu.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filter);
            Thread.sleep(5000);
            filter.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee from search bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Thread.sleep(5000);
            Searchbar.sendKeys(Email1);
            log_Info("Entered Employee from search bar");

            log_Info("select Employee checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+CounselName+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("selected Employee checkbox");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            AddToCase.click();
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCounselPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addInhouseCounselToCase() Failed", ex);

        }
    }
    // 11. Adding One More inhouse counsel

    public ILiglPage addOneMoreInhouseCounselToCase(String Email2,String CounselName1) throws Exception {

        try {


            log_Info("Click on Add In-House Counsel Button");
            getDriver().waitForelementToBeClickable(InHouseCounselBtn);
            Thread.sleep(5000);
            InHouseCounselBtn.click();
            getSession().log_Pass("Clicked on Add In-House Counsel Button");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", NameHeaderscroll);

            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(NameHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            EmailMenu.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filter);
            Thread.sleep(5000);
            filter.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee from search bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Thread.sleep(5000);
            Searchbar.sendKeys(Email2);
            log_Info("Entered Employee from search bar");

            log_Info("select Employee checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+CounselName1+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("selected Employee checkbox");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            AddToCase.click();
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addOneMoreInhouseCounselToCase() Failed",ex);
        }
    }

    // 11. Validating After Adding In House Counsels To Case

    public ILiglPage validateOneOrMoreInhouseCounsel(String CounselName,String CounselName1) throws Exception{

        try {

            Thread.sleep(5000);
            log_Info("Check The Grid For Added In House Counsel To Case");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+CounselName+"')]")).isDisplayed();
            boolean a2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+CounselName1+"')]")).isDisplayed();
            System.out.println(a1);
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateOneOrMoreInHouseCounsel() Failed",ex);
        }
    }


    // Deleting inhouse counsel From a Case

    public ILiglPage deleteInhouseCounselFromCase() throws Exception {

        try {

            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DeleteIcon);

            log_Info("Click Delete icon");
            getDriver().waitForelementToBeClickable(DeleteIcon);
            Thread.sleep(5000);
            DeleteIcon.click();
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getSession().log_Pass("ClickED Delete icon");


            log_Info("Click on yes button");
            getDriver().waitForelementToBeClickable(YesBtn);
            Thread.sleep(5000);
            YesBtn.click();
            getSession().log_Pass("Clicked on yes button");
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("deleteInhouseCounselFromCase() Failed",ex);
        }
    }

    public ILiglPage validateInhouseCounsel() throws Exception{

        try {

            log_Info("Check The Grid As No Data Available Text");
            boolean a1 = NoDataAvailableIn.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateInHouseCounsel() Failed",ex);
        }
    }


    // (2.DeletingOutsideCounsel_Test) Add And Delete outside counsel

    public ILiglPage addDeleteOutsideCounselToCase (String OptionFromLawFirmDropDwn , String SelectAvailableLawfirm) throws Exception {

        try {

            log_Info("Click on Outside Btn");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked on Outside Btn");

            log_Info("Click on Add Outside Counsel Btn");
            getDriver().waitForelementToBeClickable(AddOutsideCounsel);
            Thread.sleep(5000);
            AddOutsideCounsel.click();
            getSession().log_Pass("Clicked on Add Outside Counsel Btn");

            log_Info("Click and Select Law Firm Drop Down");
            Thread.sleep(5000);
            SelectLawFirmDrpDwn.click();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OptionFromLawFirmDropDwn+"')]")).click();
            getSession().log_Pass("Clicked and Selected Law Firm Drop Down");


            log_Info("Click on Available Law Firm From Text box");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+SelectAvailableLawfirm+"')]")).click();
            getSession().log_Pass("Clicked on Available Law Firm From Text box");

            log_Info("Click on Left Arrow Button ");
            getDriver().waitForelementToBeClickable(LeftArrow);
            Thread.sleep(5000);
            LeftArrow.click();
            getSession().log_Pass("Clicked on Left Arrow Button");

            log_Info("Click on Save Button ");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Button");
            Thread.sleep(5000);

            log_Info("Hover on Law Firm Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(LawFirmHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on Law Firm menu icon");
            LawMenuIcon.click();
            log_Info("clicked on law Firm menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(LawFilterIcon);
            Thread.sleep(5000);
            LawFilterIcon.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee from search bar");
            getDriver().waitForelementToBeClickable(LawSearchBar);
            Thread.sleep(5000);
            LawSearchBar.sendKeys(OptionFromLawFirmDropDwn);
            log_Info("Entered Employee from search bar");
            Thread.sleep(5000);

            log_Info("Click on Law Firm Name ");
            getDriver().waitForelementToBeClickable(LawFirmName);
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OptionFromLawFirmDropDwn+"')]")).click();
            getSession().log_Pass("Clicked on Law Firm Name ");

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            for (int i = 0; i < 7; i++) {

                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");


            log_Info("Click Delete icon");
            getDriver().waitForelementToBeClickable(DeleteIcon);
            Thread.sleep(5000);
            DeleteIcon.click();
            getSession().log_Pass("Clicked Delete icon");


            log_Info("Click on yes button");
            getDriver().waitForelementToBeClickable(YesBtn);
            Thread.sleep(5000);
            YesBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked on yes button");
            return new CaseCounselPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addDeleteOutsideCounselToCase () Failed", ex);
        }
    }
    // Validating Outside Counsel Added To Case
    public ILiglPage validateOutSideCounsel() throws Exception{

        try {

            log_Info("Check The Grid As No Data Available Text");
            boolean a1 = NoDataAvailableOut.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateOutSideCounsel() Failed",ex);
        }
    }

    // 3.Creating new outside counsel To a particular case

    public ILiglPage createNewOutsideCounselToCase (String PartyLawFirm,String FirstName,String LastName) throws Exception {

        try {

            log_Info("Click on Outside Btn");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked on Outside Btn");

            log_Info("Click on Add Outside Counsel Btn");
            getDriver().waitForelementToBeClickable(AddOutsideCounsel);
            Thread.sleep(5000);
            AddOutsideCounsel.click();
            getSession().log_Pass("Clicked on Add Outside Counsel Btn");

            log_Info("Click and Select Law Firm Drop Down");
            Thread.sleep(5000);
            SelectLawFirmDrpDwn.click();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+PartyLawFirm+"')]")).click();
            getSession().log_Pass("Clicked and Selected Law Firm Drop Down");

            log_Info("Click On Add Counsel Button");
            getDriver().waitForelementToBeClickable(AddCounsel);
            Thread.sleep(5000);
            AddCounsel.click();
            log_Info("Clicked On Add Counsel Button");

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
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("createNewOutsideCounselToCase () Failed",ex);
        }
    }

    public ILiglPage searchingAddedOutsideCounsel(String OutSideCounsel) throws Exception{

        try {

            log_Info("Click on Outside Btn");
            getDriver().waitForelementToBeClickable(OutsideBtn);
            Thread.sleep(5000);
            OutsideBtn.click();
            getSession().log_Pass("Clicked on Outside Btn");


            log_Info("Hover on Name Header");
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CounselHeader).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);


            log_Info("click on email menu icon");
            CounselMenu.click();
            log_Info("clicked on email menu icon");

            log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filter);
            Thread.sleep(5000);
            filter.click();
            log_Info("Filter Clicked");

            log_Info("Enter Employee from search bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Thread.sleep(5000);
            Searchbar.sendKeys(OutSideCounsel);
            Thread.sleep(5000);
            log_Info("Entered Employee from search bar");
            return new CaseCounselPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("searchingAddedOutsideCounsel() Failed",ex);
        }
    }
    // validating The Added Outside Counsel

    public ILiglPage validateNewOutSideCounselAdded(String OutSideCounsel) throws Exception{

        try {


            log_Info("Check The Counsel In The Grid");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+OutSideCounsel+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseCounselPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateNewOutSideCounselAdded() Failed",ex);
        }
    }


}

