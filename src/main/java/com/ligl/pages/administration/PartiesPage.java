package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Hashtable;

import static org.testng.Assert.assertEquals;

public class PartiesPage extends LiglBaseSessionPage {
    @FindBy(id = "add-btn")
    public WebElement addPartyBtn;

    @FindBy(xpath = "//div[text()='Party']")
    public WebElement partyLink;

    @FindBy(xpath = "//div[text()='Contact']")
    public WebElement contactLink;

    @FindBy(xpath = "//div[text()='Address']")
    public WebElement addressLink;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    public WebElement nextBtn;

    @FindBy(xpath = "//button[contains(text(),'Cancel')]")
    public WebElement cancelBtn;

    @FindBy(id = "party-name")
    public WebElement partyNameTXt;

    @FindBy(id = "sel-party-type")
    public WebElement partyTypeDrpDwn;

    @FindBy(id = "department")
    public WebElement departmentTxt;

    @FindBy(id = "party-add-select-status")
    public WebElement statusDrpDwn;

    @FindBy(id = "description")
    public WebElement descriptionTxt;

    @FindBy(id = "website")
    public WebElement websiteTxt;

    @FindBy(id = "contact-info-email")
    public WebElement emailTxt;

    @FindBy(id = "contact-info-phone")
    public WebElement phoneTxt;

    @FindBy(id = "contact-info-telephone")
    public WebElement telephoneTxt;

    @FindBy(id = "contact-info-fax")
    public WebElement faxTxt;

    @FindBy(id = "address-line1")
    public WebElement addressLine1TXt;

    @FindBy(id = "address-line2")
    public WebElement addressLine2TXt;

    @FindBy(id = "address-line3")
    public WebElement addressLine3TXt;

    @FindBy(id = "select-country")
    public WebElement countryDrpDwn;

    @FindBy(id = "select-state")
    public WebElement stateDrpDwn;

    @FindBy(id = "city")
    public WebElement cityTxt;

    @FindBy(id = "zip")
    public WebElement zipTxt;

    @FindBy(id = "save-button")
    public WebElement createBtn;

    @FindBy(xpath = "//a[@class='prevText']")
    public WebElement previousLink;

    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Party Name']")
    public WebElement partyNameColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[1]")
    public WebElement menuBtn;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    public WebElement filterBtn;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    public WebElement Searchbar;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    @FindBy(id = "status-change-reason")
    public WebElement statusChangeReasonTxt;

    //Create Button
    public ILiglPage clickOnAddPartyButtonInParties() throws Exception {
        try {
            getSession().log_Info("Click On + Party Button");
            getDriver().waitForelementToBeClickable(addPartyBtn);
            addPartyBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On + Party Button");
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error("Click On Add Party Button Failed");
            throw new Exception("Click On Add Party Button Failed", ex);
        }
    }

    public ILiglPage clickOnCreateButtonInParties() throws Exception {
        try {
            getSession().log_Info("Click on 'Create' Button");
            getDriver().waitForelementToBeClickable(createBtn);
            createBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Create' Button");
            wait(5);
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Create Button In Add New Party Details PopUp Failed", ex);
        }
    }

    public ILiglPage clickOnEditButtonInParties() throws Exception {
        try {
            getSession().log_Info("Click on 'edit' button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Edit Button In Parties Grid Failed", ex);
        }
    }

    public ILiglPage clickOnSaveButtonInParties() throws Exception{
        try {
            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(createBtn);
            createBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");
            wait(5);
            return new PartiesPage();
        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Click On Save Button In Edit Party Details PopUp Failed", ex);

        }
    }


    //Search And Select The Parties
    public ILiglPage searchAndSelectTheParties(String partiesName) throws Exception {
        try {
            wait(2);
            getSession().log_Info("Hover on Parties Name Header");
            getDriver().waitForelementToBeClickable(partyNameColumn);
            getDriver().waitForMoveToElement(partyNameColumn);
            getSession().log_Pass("Hovered on Party Name");

            getSession().log_Info("Click on Menu");
            getDriver().waitForelementToBeClickable(menuBtn);
            getDriver().waitForMoveToElement(menuBtn);
            menuBtn.click();
            getSession().log_Pass("Clicked on Menu");

            getSession().log_Info("Click on Filter");
            getDriver().waitForelementToBeClickable(filterBtn);
            filterBtn.click();
            getSession().log_Pass("Clicked on Filter");

            getSession().log_Info("Enter the Contact's Party Name in Search Bar");
            getDriver().waitForelementToBeClickable(Searchbar);
            Searchbar.sendKeys(partiesName);
            filterBtn.click();
            getSession().log_Pass("Entered the Party's Name in Search Bar");

            //select
            log_Info("Click Scroll Bar And Move to Right");
            getDriver().customXpathBasedOnTextValue(partiesName);
            wait(1);
            getDriver().moveToRightInAngularTable("2");
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");


            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search And Select The Parties Failed", ex);
        }
    }


    public ILiglPage crateNewPartyFields(String name, String partyType, String department, String status, String description,
                                         String website, String email, String phone, String telephone, String fax,
                                         String addressLine1, String addressLine2, String addressLine3, String country,
                                         String state, String city, String zip) throws Exception {
        try {
            //Name
            getSession().log_Info("Enter Name");
            getDriver().waitForelementToBeClickable(partyNameTXt);
            partyNameTXt.sendKeys(name);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Name");

            //Party Type
            getSession().log_Info("Select Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.sendKeys(partyType);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Department
            getSession().log_Info("Enter Department");
            getDriver().waitForelementToBeClickable(departmentTxt);
            departmentTxt.sendKeys(department);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Department");

            //Status
            getSession().log_Info("Select 'Status'");
            getDriver().waitForelementToBeClickable(statusDrpDwn);
            statusDrpDwn.sendKeys(status);
            wait(1);
            statusDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Status' Selected");

            //Description
            getSession().log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(description);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(1);
            getSession().log_Pass("Clicked on Next Button");

            //Website
            getSession().log_Info("Enter Website");
            getDriver().waitForelementToBeClickable(websiteTxt);
            websiteTxt.sendKeys(website);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Website Entered");

            //Email
            getSession().log_Info("Enter Email");
            getDriver().waitForelementToBeClickable(emailTxt);
            emailTxt.sendKeys(email);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Entered");

            //Phone
            getSession().log_Info("Enter Phone Number");
            getDriver().waitForelementToBeClickable(phoneTxt);
            String phoneNew = getDriver().removeSpecialCharacter(phone);
            phoneTxt.sendKeys(phoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Phone Entered Number");
            //Mobile field should not exceed 20 digits
            getSession().log_Info("Verify that Maximum length of Phone fields should not exceed 20 digits");
            String phone1 = phoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(phone1);
            getSession().log_Pass("Maximum length of Phone fields 20 digits");

            //Telephone
            getSession().log_Info("Enter Telephone Number");
            String telephoneNew = getDriver().removeSpecialCharacter(telephone);
            getDriver().waitForelementToBeClickable(telephoneTxt);
            telephoneTxt.sendKeys(telephoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Telephone Entered Number");
            //Telephone field should not exceed 20 digits
            getSession().log_Info("Verify Maximum length of Telephone fields should not exceed 20 digits");
            String telephone1 = telephoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(telephone1);
            getSession().log_Pass("Maximum length of Telephone fields 20 digits");


            //Fax
            getSession().log_Info("Enter Fax Number");
            String faxNew = getDriver().removeSpecialCharacter(fax);
            getDriver().waitForelementToBeClickable(faxTxt);
            faxTxt.sendKeys(faxNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Fax Entered Number");
            //Fax field should not exceed 20 digits
            getSession().log_Info("Verify Maximum length of Fax fields should not exceed 20 digits");
            String fax1 = faxTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(fax1);
            getSession().log_Pass("Maximum length of Fax fields 20 digits");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(1);
            getSession().log_Pass("Clicked on Next Button");

            //Address Line 1
            getSession().log_Info("Enter Address Line1");
            addressLine1TXt.sendKeys(addressLine1);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line1 Entered");

            //Address Line 2
            getSession().log_Info("Enter Address Line2");
            addressLine2TXt.sendKeys(addressLine2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line2 Entered");

            //Address Line 3
            getSession().log_Info("Enter Address Line3");
            addressLine3TXt.sendKeys(addressLine3);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line3 Entered");

            //Country
            getSession().log_Info("Select Country");
            getDriver().waitForelementToBeClickable(countryDrpDwn);
            countryDrpDwn.sendKeys(country);
            wait(1);
            countryDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Country Selected");

            //State
            getSession().log_Info("Select State");
            getDriver().waitForelementToBeClickable(stateDrpDwn);
            stateDrpDwn.sendKeys(state);
            wait(1);
            stateDrpDwn.sendKeys(Keys.ENTER);
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("State Selected");

            //City
            getSession().log_Info("Enter 'City'");
            cityTxt.sendKeys(city);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'City' Entered");

            //ZIP
            getSession().log_Info("Enter 'ZIP'");
            String zipNew = getDriver().removeSpecialCharacter(zip);
            zipTxt.sendKeys(zipNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'ZIP' Entered");


            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Party Fields Failed", ex);

        }
    }

    public ILiglPage editExitingPartyFields(String name, String partyType, String department, String status, String statusChangeReason,
                                            String description, String website, String email, String phone, String telephone, String fax,
                                            String addressLine1, String addressLine2, String addressLine3, String country,
                                            String state, String city, String zip) throws Exception {
        try {
            //Name
            getSession().log_Info("Enter Name");
            getDriver().waitForelementToBeClickable(partyNameTXt);
            partyNameTXt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            partyNameTXt.sendKeys(name);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Name");

            //Party Type
            getSession().log_Info("Select Party Type");
            getDriver().waitForelementToBeClickable(partyTypeDrpDwn);
            partyTypeDrpDwn.sendKeys(partyType);
            wait(1);
            partyTypeDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Party Type Selected");

            //Department
            getSession().log_Info("Enter Department");
            getDriver().waitForelementToBeClickable(departmentTxt);
            departmentTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            departmentTxt.sendKeys(department);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Entered Department");

            //Status
            getSession().log_Info("Select 'Status'");
            getDriver().waitForelementToBeClickable(statusDrpDwn);
            statusDrpDwn.sendKeys(status);
            wait(1);
            statusDrpDwn.sendKeys(Keys.ENTER);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Status' Selected");

            //Status Change Reason
            getSession().log_Info("Enter Status Change Reason");
            getDriver().waitForelementToBeClickable(statusChangeReasonTxt);
            statusChangeReasonTxt.sendKeys(statusChangeReason);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Status Change Reason Entered");

            //Description
            getSession().log_Info("Enter Description");
            getDriver().waitForelementToBeClickable(descriptionTxt);
            descriptionTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            descriptionTxt.sendKeys(description);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("'Description' Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(1);
            getSession().log_Pass("Clicked on Next Button");

            //Website
            getSession().log_Info("Enter Website");
            getDriver().waitForelementToBeClickable(websiteTxt);
            websiteTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            websiteTxt.sendKeys(website);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Website Entered");

            //Email
            getSession().log_Info("Enter Email");
            getDriver().waitForelementToBeClickable(emailTxt);
            emailTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            emailTxt.sendKeys(email);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Entered");

            //Phone
            getSession().log_Info("Clear Phone Number Field");
            phoneTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Phone Number Field Cleared");
            getSession().log_Info("Enter the mobile Number");
            String phoneNumberNew = getDriver().removeSpecialCharacter(phone);
            getDriver().waitForelementToBeClickable(phoneTxt);
            phoneTxt.sendKeys(phoneNumberNew);
            getSession().log_Pass("Mobile Number Entered");
            //Mobile 20 digits
            getSession().log_Info("Verify that Maximum length of Phone fields should not exceed 20 digits");
            String phone1 = phoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(phone1);
            getSession().log_Pass("Maximum length of Phone fields 20 digits");

            //Telephone
            getSession().log_Info("Clear Telephone Number Field");
            telephoneTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Telephone Number Field Cleared");
            getSession().log_Info("Enter the Telephone Number");
            getDriver().waitForelementToBeClickable(telephoneTxt);
            String telephoneNumberNew = getDriver().removeSpecialCharacter(telephone);
            telephoneTxt.sendKeys(telephoneNumberNew);
            getSession().log_Pass("Telephone Number Entered");
            //Telephone 20 digits
            getSession().log_Info("Verify Maximum length of Telephone fields should not exceed 20 digits");
            String telephone1 = telephoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(telephone1);
            getSession().log_Pass("Maximum length of Telephone fields 20 digits");

            //Fax
            getSession().log_Info("Clear Fax Number Field");
            faxTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Fax Number Field Cleared");
            getSession().log_Info("Enter 20 digits Fax Number");
            getDriver().waitForelementToBeClickable(faxTxt);
            String faxNumberNew = getDriver().removeSpecialCharacter(fax);
            faxTxt.sendKeys(faxNumberNew);
            getSession().log_Pass("20 digits Fax Number Entered");
            //Fax field should not exceed 20 digits
            getSession().log_Info("Verify Maximum length of Fax fields should not exceed 20 digits");
            String fax1 = faxTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(fax1);
            getSession().log_Pass("Fax fields 20 digits");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            wait(1);
            getSession().log_Pass("Clicked on Next Button");

            //Address Line 1
            getSession().log_Info("Enter Address Line1");
            addressLine1TXt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            addressLine1TXt.sendKeys(addressLine1);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line1 Entered");

            //Address Line 2
            getSession().log_Info("Enter Address Line2");
            addressLine2TXt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            addressLine2TXt.sendKeys(addressLine2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line2 Entered");

            //Address Line 3
            getSession().log_Info("Enter Address Line3");
            addressLine3TXt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            addressLine3TXt.sendKeys(addressLine3);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line3 Entered");

            //Country
            getSession().log_Info("Select Country");
            getDriver().waitForelementToBeClickable(countryDrpDwn);
            countryDrpDwn.sendKeys(country);
            wait(1);
            countryDrpDwn.sendKeys(Keys.ENTER);
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
            cityTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            cityTxt.sendKeys(city);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("City Entered");

            //ZIP
            getSession().log_Info("Enter ZIP");
            zipTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            String zipNew = getDriver().removeSpecialCharacter(zip);
            zipTxt.sendKeys(zipNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("ZIP Entered");

            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Party Failed", ex);
        }
    }

    public ILiglPage partyMaximumOfDigitsAllowedContctFields(String phoneNumber, String telephoneNumber, String faxNumber)
            throws Exception {
        try {

            //Party
            getSession().log_Info("Click on Contact link");
            getDriver().waitForelementToBeClickable(contactLink);
            contactLink.click();
            getSession().log_Pass("Clicked on Contact link");

               /*String maxLengthCount = moileNumTxt.getAttribute("maxlength");
               int maxDigit = Integer.parseInt(maxLengthCount);*/

            //Phone
            getSession().log_Info("Clear Phone Number Field");
            phoneTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Phone Number Field Cleared");
            getSession().log_Info("Enter the mobile Number");
            String phoneNumberNew = getDriver().removeSpecialCharacter(phoneNumber);
            getDriver().waitForelementToBeClickable(phoneTxt);
            phoneTxt.sendKeys(phoneNumberNew);
            getSession().log_Pass("Mobile Number Entered");
            //Mobile 20 digits
            getSession().log_Info("Verify that Maximum length of Phone fields should not exceed 20 digits");
            String phone1 = phoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(phone1);
            getSession().log_Pass("Maximum length of Phone fields 20 digits");

            //Telephone
            getSession().log_Info("Clear Telephone Number Field");
            telephoneTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Telephone Number Field Cleared");
            getSession().log_Info("Enter the Telephone Number");
            getDriver().waitForelementToBeClickable(telephoneTxt);
            String telephoneNumberNew = getDriver().removeSpecialCharacter(telephoneNumber);
            telephoneTxt.sendKeys(telephoneNumberNew);
            getSession().log_Pass("Telephone Number Entered");
            //Telephone 20 digits
            getSession().log_Info("Verify Maximum length of Telephone fields should not exceed 20 digits");
            String telephone1 = telephoneTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(telephone1);
            getSession().log_Pass("Maximum length of Telephone fields 20 digits");

            //Fax
            getSession().log_Info("Clear Fax Number Field");
            faxTxt.sendKeys(Keys.CONTROL + "A", Keys.BACK_SPACE);
            getSession().log_Pass("Fax Number Field Cleared");
            getSession().log_Info("Enter 20 digits Fax Number");
            getDriver().waitForelementToBeClickable(faxTxt);
            String faxNumberNew = faxNumber.replace("*", ""); //remove special character
            faxTxt.sendKeys(faxNumberNew);
            getSession().log_Pass("20 digits Fax Number Entered");
            //Fax field should not exceed 20 digits
            getSession().log_Info("Verify Maximum length of Fax fields should not exceed 20 digits");
            String fax1 = faxTxt.getAttribute("value");
            getDriver().maximumValueShouldNotExceed20Digits(fax1);
            getSession().log_Pass("Maximum length of Fax fields 20 digits");

            getSession().log_Info("Click on Cancle Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On cancle Button");

            return new PartiesPage();
        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("Party Edit/Create Mobile, Telephone & Fax numbers fields should not exceed 20 digits Failed", ex);
        }

    }


    /**
     * TC8735 Parties - Verify the process of Creating new Party using +Party button
     */

    public ILiglPage crateTheNewParty(Hashtable<String, String> data) throws Exception {
        try {
            clickOnAddPartyButtonInParties();
            crateNewPartyFields(data.get("Name"), data.get("PartyType"), data.get("Department"), data.get("Status"), data.get("Description"),
                    data.get("Website"), data.get("Email"), data.get("Phone"), data.get("Telephone"), data.get("Fax"), data.get("AddressLine1"),
                    data.get("AddressLine2"), data.get("AddressLine3"), data.get("Country"), data.get("State"), data.get("City"), data.get("Zip"));
            clickOnCreateButtonInParties();
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Party Failed", ex);
        }

    }

    /*
     * TC8746 Parties - Verify the process of Editing Party using Edit existing Party button in grid
     * */

    public ILiglPage editTheExitingParty(Hashtable<String, String> data) throws Exception {
        try {
            searchAndSelectTheParties(data.get("SearchPartyName"));
            clickOnEditButtonInParties();
            editExitingPartyFields(data.get("EditName"), data.get("EditPartyType"), data.get("EditDepartment"), data.get("EditStatus"),
                    data.get("StatusChangeReason"), data.get("EditDescription"), data.get("EditWebsite"), data.get("EditEmail"),
                    data.get("EditPhone"), data.get("EditTelephone"), data.get("EditFax"), data.get("EditAddressLine1"),
                    data.get("EditAddressLine2"), data.get("EditAddressLine3"), data.get("EditCountry"), data.get("EditState"),
                    data.get("EditCity"), data.get("EditZip"));
            clickOnSaveButtonInParties();
            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit the Exiting Party Failed", ex);
        }
    }


    public ILiglPage verifyTheError() throws Exception {
        try {
            getSession().log_Info("Check 'Name' Field");
            String n1 = getCurrentDriver().findElement(By.id("errorFullName")).getText();
            getSession().takeScreenShot();
            getSession().log_Error("'Required Name Field' not Entered " + n1);
        } catch (NoSuchFieldError ex) {
            getSession().log_Info("Check 'Party Type' Field");
            String n2 = getCurrentDriver().findElement(By.xpath("(//span[@class='error-message ng-star-inserted'])[1]")).getText();
            getSession().takeScreenShot();
            getSession().log_Error("'Required 'Party Type' Field not Selected' " + n2);
        } finally {
            try {
                getSession().log_Info("Check 'Status ' Field");
                String n1 = getCurrentDriver().findElement(By.xpath("(//span[@class='error-message ng-star-inserted'])[1]")).getText();
                getSession().takeScreenShot();
                getSession().log_Error("Required Status Field not Selected' " + n1);
            } catch (NoSuchFieldError ex) {
                getSession().log_Info("Check 'Description ' Field");
                String n2 = getCurrentDriver().findElement(By.cssSelector("#errorDescription")).getText();
                getSession().takeScreenShot();
                getSession().log_Error("'Required 'Description ' Field not Entered" + n2);
            }
        }
        return new PartiesPage();
    }


}