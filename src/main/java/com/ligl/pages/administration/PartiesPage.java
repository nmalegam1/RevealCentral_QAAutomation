package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertEquals;

public class PartiesPage extends LiglBaseSessionPage {
    @FindBy(id = "add-btn")
    public WebElement addPartyBtn;

    @FindBy(xpath = "//div[contains(text(),'Party')]")
    public WebElement partyLink;

    @FindBy(xpath = "//div[contains(text(),'Contact')]")
    public WebElement contactLink;

    @FindBy(xpath = "//div[contains(text(),'Address')]")
    public WebElement addressLink;

    @FindBy(id = "createHoldBtn")
    public WebElement nextBtn;

    @FindBy(xpath = "//button[normalize-space()='Cancel']")
    public WebElement cancelBtn;

    @FindBy(id = "party-name")
    public WebElement partyNameTXt;

    @FindBy(id = "sel-party-typepartyUUID")
    public WebElement partyTypeDrpDwn;

    @FindBy(id = "department")
    public WebElement departmentTxt;

    @FindBy(id = "party-add-select-statusstatusUUID")
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

    Actions ac = new Actions(getCurrentDriver());

    //Create Button
    public ILiglPage clickOnAddPartyButton() throws Exception {
        getSession().log_Info("Click On + Party Button");
        getDriver().waitForelementToBeClickable(addPartyBtn);
        addPartyBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked On + Party Button");
        return new PartiesPage();
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

            //select the edit button
            log_Info("Click Scroll Bar And Move to Right");
            getDriver().customXpathBasedOnTextValue(partiesName);
            wait(1);
            getDriver().moveToRightInAngularTable("2");
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

            getSession().log_Info("Click on 'edit' button");
            getDriver().waitForelementToBeClickable(editBtn);
            editBtn.click();
            getSession().log_Pass("Clicked on 'edit' button");

            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Search And Select The Parties Failed", ex);
        }
    }

    /**
     * TC8735 Parties Verify the process of Creating new Party using +Party button
     */

    public ILiglPage craeteNewParty(String name, String partyType, String department, String status, String description,
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
            getSession().log_Info("Enter Phone");
            getDriver().waitForelementToBeClickable(phoneTxt);
            String phoneNew = phone.replace("*", ""); //remove special character
            phoneTxt.sendKeys(phoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Phone Entered");

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
            getDriver().waitForelementToBeClickable(createBtn);
            createBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Create' Button");
            wait(5);


            return new PartiesPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Party Failed", ex);

        }
    }
    public ILiglPage editParty(String name, String partyType, String department, String status, String statusChangeReason,
                               String description, String website, String email, String phone, String telephone, String fax,
                               String addressLine1, String addressLine2, String addressLine3, String country,
                               String state, String city, String zip) throws Exception{
        try {
            //Name
            getSession().log_Info("Enter Name");
            getDriver().waitForelementToBeClickable(partyNameTXt);
            partyNameTXt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
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
            departmentTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
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
            descriptionTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
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
            websiteTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            websiteTxt.sendKeys(website);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Website Entered");

            //Email
            getSession().log_Info("Enter Email");
            getDriver().waitForelementToBeClickable(emailTxt);
            emailTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            emailTxt.sendKeys(email);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Email Entered");

            //Phone
            getSession().log_Info("Enter Phone");
            getDriver().waitForelementToBeClickable(phoneTxt);
            phoneTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            String phoneNew = phone.replace("*", ""); //remove special character
            phoneTxt.sendKeys(phoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Phone Entered");

            //Telephone
            getSession().log_Info("Enter Telephone");
            telephoneTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            String telephoneNew = telephone.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(telephoneTxt);
            telephoneTxt.sendKeys(telephoneNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Telephone Entered");

            //Fax
            getSession().log_Info("Enter Fax");
            faxTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
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
            addressLine1TXt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            addressLine1TXt.sendKeys(addressLine1);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line1 Entered");

            //Address Line 2
            getSession().log_Info("Enter Address Line2");
            addressLine2TXt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            addressLine2TXt.sendKeys(addressLine2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Address Line2 Entered");

            //Address Line 3
            getSession().log_Info("Enter Address Line3");
            addressLine3TXt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
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
            cityTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            cityTxt.sendKeys(city);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("City Entered");

            //ZIP
            getSession().log_Info("Enter ZIP");
            zipTxt.sendKeys(Keys.CONTROL+"A", Keys.BACK_SPACE);
            String zipNew = zip.replace("*", ""); //remove special character
            zipTxt.sendKeys(zipNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("ZIP Entered");

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
            phoneTxt.sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
            getSession().log_Pass("Phone Number Field Cleared");
            getSession().log_Info("Enter 20 digits Mobile Number");
            String phoneNumberNew = phoneNumber.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(phoneTxt);
            phoneTxt.sendKeys(phoneNumberNew);
            getSession().log_Pass("20 digits Phone Number Entered");
            //Mobile 20 digits
            getSession().log_Info("Verify that Maximum length of Phone fields should not exceed 20 digits");
            int givenPhone = phoneNumberNew.length();
            assertEquals(20, givenPhone);
            getSession().log_Pass("Maximum length of Phone fields 20 digits");

            //Telephone
            getSession().log_Info("Clear Telephone Number Field");
            telephoneTxt.sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
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
            faxTxt.sendKeys(Keys.CONTROL+"A",Keys.BACK_SPACE);
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

            return new PartiesPage();
        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("Party Edit/Create Mobile, Telephone & Fax numbers fields should not exceed 20 digits Failed", ex);
        }

    }
}