package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import static org.testng.Assert.assertEquals;

public class ContactMasterPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//span[@title='General']")
    WebElement GeneralTab;
    @FindBy(xpath = "//span[@title='Legal Hold']")
    WebElement LegalHoldTab;
    @FindBy(xpath = "//span[@title='Users and Roles']")
    WebElement UsersAndRolesTab;
    @FindBy(xpath = "//span[@title='Employee Master']")
    WebElement EmployeeMasterTab;


    @FindBy(xpath = "//span[contains(text(),'Legal Hold')]")
    WebElement LegalHold;

    @FindBy(xpath = "//span[contains(text(),'Employee Master')]")
    WebElement EmployeeMaster;

    @FindBy(xpath = "//span[contains(text(),'Escalation and Reminder')]")
    WebElement EscalationRemainder;

    @FindBy(id = "number-of-days-before-reminder-escalation")
    WebElement NumberOfDays;

    @FindBy(id = "reminder-frequency-escaltion")
    WebElement Remainderfrequency;

    @FindBy(id = "reminder-mails-cap")
    WebElement RemainderMails;

    @FindBy(id = "escalation-remainder-yes-opt-button")
    WebElement YesButton;

    @FindBy(id = "select-reminder-email-template-escalation")
    WebElement RemainderTemplate;

    @FindBy(id = "number-of-days-after-reminder")
    WebElement NumberOfDaysAfterRemainder;

    @FindBy(id = "escalation-frequency")
    WebElement EscalationFrequency;

    @FindBy(id = "escalation-mails-cap")
    WebElement EscalationMails;

    @FindBy(id = "select-escalation-email-template")
    WebElement EscalationTemplate;

    @FindBy(id = "escalation-sent-to")
    WebElement EscalationSentTo;

    /*******************************************************************************************************/
    @FindBy(id = "create-contact-button")
    public WebElement contactCreateBtn;

    @FindBy(id = "btn-clear-contacts")
    public WebElement clearBtn;

    @FindBy(id = "firstname")
    public WebElement firstNameTxt;

    @FindBy(id = "middlename")
    public WebElement middleNameTxt;

    @FindBy(id = "lastname")
    public WebElement lastNameTxt;

    @FindBy(id = "Designation")
    public WebElement titleTxt;

    @FindBy(id = "select-is-primary-contactIsPrimaryContact")
    public WebElement isPrimaryContactDrpDwn;

    @FindBy(id = "select-statusStatus")
    public WebElement statusDrpDwn;

    @FindBy(id = "select-contact-typeContactTypeID")
    public WebElement contactTypeDrpDwn;

    @FindBy(id = "select-party-typePartyType")
    public WebElement partyTypeDrpDwn;

    @FindBy(id = "select-party-namePartyID")
    public WebElement partyNameDrpDwn;

    @FindBy(id = "PrimaryEmail")
    public WebElement primaryEmailTxt;

    @FindBy(id = "SecondaryEmail")
    public WebElement secondaryEmailTxt;

    @FindBy(id = "Mobile")
    public WebElement mobileTxt;

    @FindBy(id = "Telephone")
    public WebElement telephoneTxt;

    @FindBy(id = "Fax")
    public WebElement faxTxt;

    @FindBy(id = "AddressLine1")
    public WebElement addressLine1Txt;

    @FindBy(id = "AddressLine2")
    public WebElement addressLine2Txt;

    @FindBy(id = "select-country")
    public WebElement countryDrpDwn;

    @FindBy(id = "select-state")
    public WebElement stateDrpDwn;

    @FindBy(id = "City")
    public WebElement cityTxt;

    @FindBy(id = "Zip")
    public WebElement zipTxt;

    @FindBy(id = "createHoldBtn")
    public WebElement nextBtn;

    @FindBy(xpath = "//a[@class='prevText']")
    public WebElement previousLink;

    @FindBy(id = "back-button")
    public WebElement cancelBtn;

    @FindBy(id = "save-button")
    public WebElement saveBtn;

    @FindBy(xpath = "//div[contains(text(),'Contact')]")
    public WebElement contactLink;

    @FindBy(xpath = "//div[contains(text(),'Party')]")
    public WebElement partyLink;

    @FindBy(xpath = "//div[contains(text(),'Address')]")
    public WebElement addressLink;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-trash']")
    public WebElement deletBtn;

    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='First Name']")
    WebElement firstNameColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    WebElement menu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement dropDwnSearchBar;

    Actions ac = new Actions(getCurrentDriver());

    public ILiglPage goToUsersRoles() throws Exception {
        try {
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            UsersAndRolesTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new UsersAndRolesPage();
        } catch (Exception ex) {
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()", ex);
        }
    }

    public ILiglPage goToEmployeeMasterpage() throws Exception {
        try {
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            GeneralTab.click();
            log_Info("General Tab Clicked");
            EmployeeMasterTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new EmployeeMasterPage();
        } catch (Exception ex) {
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()", ex);
        }
    }

    public ILiglPage navigateToEscalationAndRemainder() throws Exception {

        try {

            log_Info("Click on LegalHold Main Tab");
            getDriver().waitForelementToBeClickable(LegalHold);
            Thread.sleep(5000);
            LegalHold.click();
            getSession().log_Pass("Clicked on LegalHold Main Tab");

            log_Info("Click on Escalation And Remainder Sub Tab");
            getDriver().waitForelementToBeClickable(EscalationRemainder);
            Thread.sleep(5000);
            EscalationRemainder.click();
            getSession().log_Pass("Clicked on Escalation And Remainder Sub Tab");

            return new ContactMasterPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("createNewOutsideCounselToCase () Failed", ex);
        }
    }


    public ILiglPage validateEscalationAndRemainderDefaultValues() throws Exception {

        try {

            Thread.sleep(5000);

            log_Info("Validate The Escalation And Remainder Default Values");

            boolean a1 = NumberOfDays.isDisplayed();
            boolean a2 = Remainderfrequency.isDisplayed();
            boolean a3 = RemainderMails.isDisplayed();
            boolean a4 = YesButton.isDisplayed();
            boolean a5 = RemainderTemplate.isDisplayed();
            boolean a6 = NumberOfDaysAfterRemainder.isDisplayed();
            boolean a7 = EscalationFrequency.isDisplayed();
            boolean a8 = EscalationMails.isDisplayed();
            boolean a9 = EscalationTemplate.isDisplayed();
            boolean a10 = EscalationSentTo.isDisplayed();

            Thread.sleep(3000);

            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            System.out.println(a4);
            System.out.println(a5);
            System.out.println(a6);
            System.out.println(a7);
            System.out.println(a8);
            System.out.println(a9);
            System.out.println(a10);

            Thread.sleep(3000);

            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, a3);
            Assert.assertEquals(true, a4);
            Assert.assertEquals(true, a5);
            Assert.assertEquals(true, a6);
            Assert.assertEquals(true, a7);
            Assert.assertEquals(true, a8);
            Assert.assertEquals(true, a9);
            Assert.assertEquals(true, a10);

            return new ContactMasterPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateEscalationAndRemainderDefaultValues() Failed", ex);
        }
    }

    public ILiglPage navigateToEmployeeMasterPage() throws Exception {

        try {

            log_Info("Click on Employee Master Page");
            getDriver().waitForelementToBeClickable(EmployeeMaster);
            Thread.sleep(5000);
            EmployeeMaster.click();
            getSession().log_Pass("Click on Employee Master Page");

            return new EmployeeMasterPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToEmployeeMasterPage () Failed", ex);
        }
    }

    /******************************************************************************/


    //Create Button
    public ILiglPage clickOnAddContactButton() throws Exception {
        getSession().log_Info("Click on Contact +Button");
        getDriver().waitForelementToBeClickable(contactCreateBtn);
        contactCreateBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on Contact +Button");
        return new ContactMasterPage();
    }

    //Search And Select The Contact
    public ILiglPage searchAndSelectTheContact(String firstName) throws Exception {
        try {
            wait(2);
            getSession().log_Info("Hover on First Name Header");
            getDriver().waitForelementToBeClickable(firstNameColumn);
            ac.moveToElement(firstNameColumn).perform();
            getSession().log_Pass("Hovered on First Name");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menu);
            ac.moveToElement(menu).perform();
            menu.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filter);
            filter.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Contact's First Name in Search Bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Searchbar.sendKeys(firstName);
            filter.click();
            getSession().log_Pass("Entered the Contact's First Name in Search Bar");

            //select the edit button
            log_Info("Click Scroll Bar And Move to Right");
            getDriver().customXpathBasedOnTextValue(firstName);
            wait(1);
            getDriver().moveToRightInAngularTable("4");
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

            getSession().log_Info("Click on 'edit' button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");

            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search And Select The Contact Failed", ex);
        }

    }

    public ILiglPage createContact(String firstName, String middleName, String lastName, String title, String isPrimaryContact,
                                   String status, String contactType, String partyType, String partyName, String primaryEmail,
                                   String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
                                   String addressLine2, String country, String state, String city, String zip) throws Exception {
        try {
            //First Name
            getSession().log_Info("Enter First Name");
            firstNameTxt.sendKeys(firstName);
            getSession().log_Pass("First Name Entered");

            //Middle Name
            getSession().log_Info("Enter Middel Name");
            middleNameTxt.sendKeys(middleName);
            getSession().log_Pass("Middel Name Entered");

            //Last Name
            getSession().log_Info("Enter Last Name");
            lastNameTxt.sendKeys(lastName);
            getSession().log_Pass("Last Name Entered");

            //Title
            getSession().log_Info("Enter Title");
            titleTxt.sendKeys(title);
            getSession().log_Pass("Title Entered");

            //Is Primary Contact
            getSession().log_Info("Select Is Primary Contact?");
            getDriver().waitForelementToBeClickable(isPrimaryContactDrpDwn);
            isPrimaryContactDrpDwn.sendKeys(isPrimaryContact);
            wait(1);
            isPrimaryContactDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();

            //Status
            getSession().log_Info("Select the 'Contact Status' " + status.toUpperCase());
            statusDrpDwn.click();
            dropDwnSearchBar.sendKeys(status);
            wait(1);
            statusDrpDwn.sendKeys(Keys.ENTER);
            wait(2);
            getSession().log_Pass("'Contact Status' Selected");

            //Contact Type
            getSession().log_Info("Select the Contact Type");
            getDriver().waitForelementToBeClickable(contactTypeDrpDwn);
            contactTypeDrpDwn.sendKeys(contactType);
            wait(1);
            contactTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Contact Type Selected");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(2);
            getSession().log_Pass("Clicked on Next Button");

            //Party Type
            getSession().log_Info("Select the Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.sendKeys(partyType);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Party Name
            getSession().log_Info("Select Party Name");
            getDriver().waitForelementToBeClickable(partyNameDrpDwn);
            partyNameDrpDwn.sendKeys(partyName);
            wait(1);
            partyNameDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Name Selected");

            //Primary Email
            getSession().log_Info("Enter Primary Email");
            primaryEmailTxt.sendKeys(primaryEmail);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Primary Email Entered");

            //Secondary Email
            getSession().log_Info("Enter Secondary Email");
            secondaryEmailTxt.sendKeys(secondaryEmail);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Secondary Email Entered");

            //Mobile
            getSession().log_Info("Enter Mobile");
            String mobileNumberNew = mobile.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(mobileTxt);
            mobileTxt.sendKeys(mobileNumberNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Mobile Entered");

            //Telephone
            getSession().log_Info("Enter Telephone");
            String telephoneNew = telephone.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(telephoneTxt);
            telephoneTxt.sendKeys(telephoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Telephone Entered");

            //Fax
            getSession().log_Info("Enter Fax");
            String faxNew = fax.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(faxTxt);
            faxTxt.sendKeys(faxNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Fax Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(1);
            getSession().log_Pass("Clicked on Next Button");

            //Address Line 1
            getSession().log_Info("Enter Address Line1");
            addressLine1Txt.sendKeys(addressLine1);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line1 Entered");

            //Address Line 2
            getSession().log_Info("Enter Address Line2");
            addressLine2Txt.sendKeys(addressLine2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line2 Entered");

            //Country
            getSession().log_Info("Select Country");
            getDriver().waitForelementToBeClickable(countryDrpDwn);
            countryDrpDwn.click();
            dropDwnSearchBar.sendKeys(country);
            wait(1);
            countryDrpDwn.sendKeys(Keys.ENTER);
            wait(3);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Country Selected");

            //State
            getSession().log_Info("Select State");
            getDriver().waitForelementToBeClickable(stateDrpDwn);
            stateDrpDwn.sendKeys(state);
            wait(1);
            stateDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("State Selected");

            //City
            getSession().log_Info("Enter CITY");
            cityTxt.sendKeys(city);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("City Entered");

            //ZIP
            getSession().log_Info("Enter ZIP");
            String zipNew = zip.replace("*", ""); //remove special character
            zipTxt.sendKeys(zipNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("ZIP Entered");

            //Save
            getSession().log_Info("Click on 'Create' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Create' Button");
            wait(5);

            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Contact Failed", ex);
        }
    }


    public ILiglPage editContact(String firstName, String middleName, String lastName, String title, String isPrimaryContact,
                                 String status, String contactType, String partyType, String partyName, String primaryEmail,
                                 String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
                                 String addressLine2, String country, String state, String city, String zip) throws Exception {
        try {
            //First Name
            getSession().log_Info("Enter First Name");
            firstNameTxt.clear();
            firstNameTxt.sendKeys(firstName);
            getSession().log_Pass("First Name Entered");

            //Middle Name
            getSession().log_Info("Enter Middel Name");
            middleNameTxt.clear();
            middleNameTxt.sendKeys(middleName);
            getSession().log_Pass("Middel Name Entered");

            //Last Name
            getSession().log_Info("Enter Last Name");
            lastNameTxt.clear();
            lastNameTxt.sendKeys(lastName);
            getSession().log_Pass("Last Name Entered");

            //Title
            getSession().log_Info("Enter Title");
            titleTxt.clear();
            titleTxt.sendKeys(title);
            getSession().log_Pass("Title Entered");

            //Is Primary Contact
            getSession().log_Info("Select Is Primary Contact?");
            getDriver().waitForelementToBeClickable(isPrimaryContactDrpDwn);
            isPrimaryContactDrpDwn.sendKeys(isPrimaryContact);
            wait(1);
            isPrimaryContactDrpDwn.sendKeys(Keys.ENTER);
            wait(2);
            getDriver().waitForAngularRequestsToComplete();

            //Status
            getSession().log_Info("Select the 'Contact Status'");
            getDriver().waitForelementToBeClickable(statusDrpDwn);
            statusDrpDwn.click();
            dropDwnSearchBar.sendKeys(status);
            wait(2);
            statusDrpDwn.sendKeys(Keys.ENTER);
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Contact Status' Selected");

            //Contact Type
            getSession().log_Info("Select the Contact Type");
            getDriver().waitForelementToBeClickable(contactTypeDrpDwn);
            contactTypeDrpDwn.sendKeys(contactType);
            wait(1);
            contactTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Contact Type Selected");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Next Button");

            //Party Type
            getSession().log_Info("Select the Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.sendKeys(partyType);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Party Name
            getSession().log_Info("Select Party Name");
            getDriver().waitForelementToBeClickable(partyNameDrpDwn);
            partyNameDrpDwn.sendKeys(partyName);
            wait(1);
            partyNameDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Name Selected");

            //Primary Email
            getSession().log_Info("Enter Primary Email");
            primaryEmailTxt.clear();
            primaryEmailTxt.sendKeys(primaryEmail);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Primary Email Entered");

            //Secondary Email
            getSession().log_Info("Enter Secondary Email");
            secondaryEmailTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            secondaryEmailTxt.sendKeys(secondaryEmail);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Secondary Email Entered");

            //Mobile
            getSession().log_Info("Enter Mobile");
            getDriver().waitForelementToBeClickable(mobileTxt);
            mobileTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            ac.moveToElement(mobileTxt).sendKeys(Keys.BACK_SPACE).perform();
            wait(1);
            String mobileNew = mobile.replace("*", "");
            mobileTxt.sendKeys(mobileNew);
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Mobile Entered");

            //Telephone
            getSession().log_Info("Enter Telephone");
            telephoneTxt.clear();
            String telephoneNew = telephone.replace("*", "");
            telephoneTxt.sendKeys(telephoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Telephone Entered");

            //Fax
            getSession().log_Info("Enter Fax");
            faxTxt.clear();
            String faxNew = fax.replace("*", "");
            faxTxt.sendKeys(faxNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Fax Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Next Button");

            //Address Line 1
            getSession().log_Info("Enter Address Line1");
            addressLine1Txt.clear();
            addressLine1Txt.sendKeys(addressLine1);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line1 Entered");

            //Address Line 2
            getSession().log_Info("Enter Address Line2");
            addressLine2Txt.clear();
            addressLine2Txt.sendKeys(addressLine2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line2 Entered");

            //Country
            getSession().log_Info("Select Country");
            getDriver().waitForelementToBeClickable(countryDrpDwn);
            countryDrpDwn.click();
            dropDwnSearchBar.sendKeys(country);
            wait(1);
            countryDrpDwn.sendKeys(Keys.ENTER);
            wait(3);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Country Selected");

            //State
            getSession().log_Info("Select State");
            getDriver().waitForelementToBeClickable(stateDrpDwn);
            stateDrpDwn.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            getDriver().waitForelementToBeClickable(stateDrpDwn);
            stateDrpDwn.sendKeys(state);
            wait(1);
            stateDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("State Selected");

            //City
            getSession().log_Info("Enter CITY");
            cityTxt.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            cityTxt.sendKeys(city);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("City Entered");

            //ZIP
            getSession().log_Info("Enter ZIP");
            zipTxt.clear();
            String zipNew = zip.replace("*", "");
            zipTxt.sendKeys(zipNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("ZIP Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");

            wait(2);
            //String SuccessMge= getCurrentDriver().findElement(By.xpath("//div[@aria-label='Success! Updated Successfully.']")).getText();
            //Assert.assertEquals(SuccessMge, "Success! Updated Successfully.");
            wait(3);

            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Contact Failed", ex);
        }
    }

    /**
     * TC7067 Contact- Check whether Party names are displaying based on selected Contact type & Party type
     */

    public ILiglPage checkPartyName(String contactType, String partyType, String partyName) throws Exception {
        try {
            //Contact Type
            getSession().log_Info("Select the Contact Type");
            getDriver().waitForelementToBeClickable(contactTypeDrpDwn);
            contactTypeDrpDwn.sendKeys(contactType);
            wait(1);
            contactTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Contact Type Selected");

            //Next
            getSession().log_Info("Click on Party Link");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Party Link");

            //Party Type
            getSession().log_Info("Select the Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.sendKeys(partyType);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Party Name
            getSession().log_Info("Select Party Name");
            getDriver().waitForelementToBeClickable(partyNameDrpDwn);
            partyNameDrpDwn.sendKeys(partyName);
            wait(1);
            String expected = getCurrentDriver().findElement(By.xpath("//span[normalize-space()='" + partyName + "']")).getText();
            wait(1);
            Assert.assertEquals(partyName, expected);
            wait(1);
            partyNameDrpDwn.sendKeys(Keys.TAB);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Name Selected");

            //Cancel
            getSession().log_Info("Click on Cancel Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Cancel Button");

            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check The Party Name Failed", ex);
        }
    }

    /**
     * 7065	Create & Edit Contact- Check whether Party types are displaying based on selected Contact type
     */

    public ILiglPage checkPartyNameBasedOnSelectedContactType(String contactType, String partyType) throws Exception {
        try {
            //Contact Type
            getSession().log_Info("Select the Contact Type");
            getDriver().waitForelementToBeClickable(contactTypeDrpDwn);
            contactTypeDrpDwn.click();
            dropDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            wait(1);
            dropDwnSearchBar.sendKeys(contactType);
            wait(1);
            contactTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Contact Type Selected");

            //Next
            getSession().log_Info("Click on Party Link");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Party Link");

            //Party Type
            getSession().log_Info("Select the Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.click();
            dropDwnSearchBar.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            wait(1);
            dropDwnSearchBar.sendKeys(partyType);
            wait(1);
            //String expected = getCurrentDriver().findElement(By.xpath("//span[normalize-space()='" + partyType + "']")).getText();
            String expected = getDriver().customXpathBasedOnTextValue(partyType).getText();
            wait(1);
            Assert.assertEquals(partyType, expected);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Cancel
            getSession().log_Info("Click on Cancel Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Cancel Button");

            return new ContactMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Check Of Party Name Failed", ex);
        }
    }


    /**
     * TC 42959	Create & Edit Contact- Verify Maximum length of Mobile, Telephone & Fax numbers fields should not exceed 20 digits
     */

    public ILiglPage contactMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
            throws Exception {
        try {

            //Party
            getSession().log_Info("Click on Party link");
            getDriver().waitForelementToBeClickable(partyLink);
            partyLink.click();
            getSession().log_Pass("Clicked on Party link");

               /*String maxLengthCount = moileNumTxt.getAttribute("maxlength");
               int maxDigit = Integer.parseInt(maxLengthCount);*/

            //mobile
            getSession().log_Info("Clear Mobile Number Field");
            mobileTxt.clear();
            getSession().log_Pass("Mobile Number Field Cleared");
            getSession().log_Info("Enter 20 digits Mobile Number");
            String mobileNumberNew = mobileNumber.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(mobileTxt);
            mobileTxt.sendKeys(mobileNumberNew);
            getSession().log_Pass("20 digits Mobile Number Entered" + mobileNumberNew);
            //Mobile 20 digits
            getSession().log_Info("Verify that Maximum length of Mobile fields should not exceed 20 digits");
            int givenMobile = mobileNumberNew.length();
            assertEquals(20, givenMobile);
            getSession().log_Pass("Maximum length of Mobile fields 20 digits");

            //Telephone
            getSession().log_Info("Clear Telephone Number Field");
            telephoneTxt.clear();
            getSession().log_Pass("Telephone Number Field Cleared");
            getSession().log_Info("Enter 20 digits Telephone Number");
            getDriver().waitForelementToBeClickable(telephoneTxt);
            String telephoneNumberNew = telephoneNumber.replace("*", ""); //remove special character
            telephoneTxt.sendKeys(telephoneNumberNew);
            getSession().log_Pass("20 digits Telephone Number Entered");
            //Telephone 20 digits
            getSession().log_Info("Verify Maximum length of Telephone fields should not exceed 20 digits");
            int giveTelephone = telephoneNumberNew.length();
            assertEquals(20, giveTelephone);
            getSession().log_Pass("Maximum length of Telephone fields 20 digits");

            //Fax
            getSession().log_Info("Clear Fax Number Field");
            faxTxt.clear();
            getSession().log_Pass("Fax Number Field Cleared");
            getSession().log_Info("Enter 20 digits Fax Number");
            getDriver().waitForelementToBeClickable(faxTxt);
            String faxNumberNew = faxNumber.replace("*", ""); //remove special character
            faxTxt.sendKeys(faxNumberNew);
            getSession().log_Pass("20 digits Fax Number Entered");
            //Fax 20 digits
            getSession().log_Info("Verify Maximum length of Fax fields should not exceed 20 digits");
            int givenFax = faxNumberNew.length();
            assertEquals(20, givenFax);
            getSession().log_Pass("Maximum length of Fax fields 20 digits");

            getSession().log_Info("Click on Cancle Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On cancle Button");

            return new ContactMasterPage();
        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("Contact Edit Mobile, Telephone & Fax numbers fields should not exceed 20 digits Failed", ex);
        }

    }

}





