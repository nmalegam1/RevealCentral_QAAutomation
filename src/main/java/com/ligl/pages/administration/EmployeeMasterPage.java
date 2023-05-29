package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class EmployeeMasterPage extends LiglBaseSessionPage {


    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']")
    WebElement EmailName;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/ag-grid-angular/div/div[2]/div[2]/div[1]/div[2]/div/div/div[5]/div[3]/span/span")
    WebElement EmailMenuu;//Doubt

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement EditIcon;

    @FindBy(id = "select-employement-status")
    WebElement EmployeeStatus;

    @FindBy(id = "createHoldBtn")
    WebElement NextBtn;

    @FindBy(id = "save-button")
    WebElement SaveBtn;

    /*****************************************************************************************************************/
    @FindBy(xpath = "//span[normalize-space()='Employee']")
    public WebElement viewAllEmployeeLink;

    @FindBy(xpath = "//span[contains(text(), 'Import')]")
    public WebElement importEmployeeLink;

    @FindBy(id = "Import")
    public WebElement bulkImportBtn;

    @FindBy(xpath = "//input[@class='fileInpt']")
    public WebElement browserFile;

    @FindBy(id = "CloseFilebtn")
    public WebElement bulkImportCloseBtn;

    @FindBy(id = "clearall-btn")
    public WebElement bulkImportClearAllBtn;

    @FindBy(id = "ImportFilebtn")
    public WebElement ImportFilebtn;

    @FindBy(id = "Employee-Import")
    public WebElement addEmpBtn;

    @FindBy(id = "employee-code")
    public WebElement empIDTxt;

    @FindBy(id = "first-name")
    public WebElement firstNameTxt;

    @FindBy(id = "middile-name")
    public WebElement middileNameTxt;

    @FindBy(id = "last-name")
    public WebElement lastNameTXt;

    @FindBy(id = "alias")
    public WebElement aliasTxt;

    @FindBy(id = "select-department-name")
    public WebElement departmentDrpDwn;

    @FindBy(id = "title")
    public WebElement titleTxt;

    @FindBy(id = "source-last-updated-date")
    public WebElement lastUpdatedData;

    @FindBy(id = "joined-date")
    public WebElement joinedDate;

    @FindBy(id = "terminated-date")
    public WebElement terminatedDate;

    @FindBy(id = "select-employement-status")
    public WebElement empStatusDrpDwn;

    @FindBy(id = "historic-employee-id")
    public WebElement empHistoricIdTxt;

    @FindBy(id = "email")
    public WebElement empEmailTxt;

    @FindBy(id = "secondary-email")
    public WebElement empSecEmailTxt;

    @FindBy(id = "alternate-email")
    public WebElement empAltEmailTxt;

    @FindBy(id = "mobile-number")
    public WebElement moileNumTxt;

    @FindBy(id = "work-phone")
    public WebElement wrkPhnTXT;

    @FindBy(id = "work-fax")
    public WebElement wrkFaxTxt;

    @FindBy(id = "select-category")
    public WebElement categoryDrpDwn;

    @FindBy(id = "select-entity")
    public WebElement entityDrpDwn;

    @FindBy(id = "select-locatoin")
    public WebElement locationDrpDwn;

    @FindBy(id = "select-division")
    public WebElement divisionDrpDwn;

    @FindBy(id = "select-office-type")
    public WebElement officeTypeDrpDwn;

    @FindBy(id = "account-type")
    public WebElement accoutTypeTxt;

    @FindBy(id = "account-manager-first-name")
    public WebElement accountManagerFirstNameTxt;

    @FindBy(id = "account-manager-middile-name")
    public WebElement accountManagerMiddleNameTxt;

    @FindBy(id = "account-manager-last-name")
    public WebElement accountManagerLastNameTxt;

    @FindBy(id = "reporting-manager")
    public WebElement contactReportingManager;

    @FindBy(id = "office-name")
    public WebElement officeNameTxt;

    @FindBy(id = "office-address-line")
    public WebElement officeAddressLineTxt;

    @FindBy(id = "office-address-building-code")
    public WebElement officeAddressBuildingCodeTxt;

    @FindBy(id = "office-adrress-campus-code")
    public WebElement officeAddressCampusCodeTxt;

    @FindBy(id = "office-address-mailing-code")
    public WebElement officeAddressMailingCodeTxt;

    @FindBy(id = "office-address-zip-code")
    public WebElement officeAddressZipCodeTxt;

    @FindBy(id = "office-address-city")
    public WebElement officeAddressCityTxt;

    @FindBy(id = "office-address-state")
    public WebElement officeAddressStateTxt;

    @FindBy(id = "affliation")
    public WebElement affliationTxt;

    @FindBy(id = "home-department-code")
    public WebElement homeDepartmentCodeTxt;

    @FindBy(xpath = "//div[contains(text(), 'Employee')]")
    public WebElement empLink;

    @FindBy(xpath = "//div[contains(text(), 'Contact')]")
    public WebElement contactLink;

    @FindBy(xpath = "//div[contains(text(), 'Address')]")
    public WebElement addressLink;

    @FindBy(xpath = "//a[@class='prevText']")
    public WebElement previousLink;

    @FindBy(id = "more-button")
    public WebElement moreBtn;

    @FindBy(id = "back-button")
    public WebElement cancelBtn;

    @FindBy(id = "save-button")
    public WebElement saveBtn;

    @FindBy(id = "createHoldBtn")
    public WebElement nextBtn;

    @FindBy(xpath = "//i[@class='lnr lnr-pencil']")
    public WebElement editBtn;

    //@FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']")
    @FindBy(xpath = "//span[@ref='eText'][normalize-space()='Alias']")
    WebElement aliasColumn;

    @FindBy(xpath = "(//span[@ref='eMenu'])[3]")
    WebElement menu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement filter;

    //@FindBy(xpath = "//input[@placeholder='Filter...']")
    //WebElement Searchbar;

    @FindBy(xpath = "//span[@class='custom-label-error']")
    public WebElement errorValidation;

    @FindBy(xpath = "//label[@for='title']//span[@class='mat-form-field-required-marker']")
    public WebElement titleOptionalMark;

    Actions ac = new Actions(getCurrentDriver());



    public ILiglPage searchThroughEmail(String Email) throws Exception {


        try {

            log_Info("Hover on Name Header");
            getDriver().waitForelementToBeClickable(EmailName);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(EmailName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            EmailMenuu.click();
            log_Info("Menu clicked");

            log_Info("Click on Filter");
            Thread.sleep(2000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(2000);
            log_Info("Enter Employee");
            Searchbar.sendKeys(Email);

            return new EmployeeMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("searchThroughEmail() Failed",ex);
        }
    }

    public ILiglPage performEditAction(String EmployeeName) throws Exception {


        try {

            log_Info("performEditAction() Started");

            log_Info("Click On The Employee Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+EmployeeName+"')]")).click();
            getSession().log_Pass("Clicked On The Employee Name");

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            Actions ac = new Actions(getCurrentDriver());

            for (int i = 0; i < 9; i++) {

                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");


            log_Info("Click On The Edit Icon");
            Thread.sleep(5000);
            EditIcon.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Edit Icon");


            return new EmployeeMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("performEditAction() Failed",ex);
        }
    }

    public ILiglPage editEmployeeStatus(String Estatus) throws Exception {


        try {

            log_Info("Click On The Employee Status Drop Down");
            Thread.sleep(5000);
            EmployeeStatus.sendKeys(Estatus);
            Thread.sleep(5000);
            EmployeeStatus.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On The Employee Status Drop Down");

            log_Info("Click On The Next Button");
            Thread.sleep(5000);
            NextBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Next Button");

            log_Info("Click On The Next Button");
            Thread.sleep(5000);
            NextBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Next Button");

            log_Info("Click On The Save Button");
            Thread.sleep(5000);
            SaveBtn.click();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked On The Save Button");


            return new EmployeeMasterPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("editEmployeeStatus() Failed",ex);
        }
    }

    /**************************************************************************************/



    public ILiglPage clickOnEmployee() throws Exception {
        getSession().log_Info("Click on Employee");
        getDriver().waitForelementToBeClickable(viewAllEmployeeLink);
        viewAllEmployeeLink.click();
        getSession().log_Pass("Clicked on Employee");
        return new EmployeeMasterPage();
    }

    public ILiglPage clickOnImport() throws Exception {
        getSession().log_Info("Click on Import");
        getDriver().waitForelementToBeClickable(importEmployeeLink);
        importEmployeeLink.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on Import");
        return new EmployeeMasterPage();
    }


    /*
     * Search and Select the Employee
     * */

    public ILiglPage searchAndSelectTheEmployee(String employeeAlias) throws Exception {
        getSession().log_Info("Hover on Alias Header");
        getDriver().waitForelementToBeClickable(aliasColumn);
        getDriver().waitForMoveToElement(aliasColumn);
        getSession().log_Pass("Hovered on Alias Header");

        getSession().log_Info("Click on Menu");
        getDriver().waitForelementToBeClickable(menu);
        getDriver().waitForMoveToElement(menu);
        menu.click();
        getSession().log_Pass("Clicked on Menu");

        getSession().log_Info("Click on Filter");
        getDriver().waitForelementToBeClickable(filter);
        filter.click();
        getSession().log_Pass("Clicked on Filter");

        getSession().log_Info("Enter the Employee Alias in Search Bar");
        getDriver().waitForelementToBeClickable(Searchbar);
        Searchbar.sendKeys(employeeAlias);
        filter.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Entered the Employee Alias in Search Bar");

        //select the edit button
        log_Info("Click Scroll Bar And Move to Right");
        getCurrentDriver().findElement(By.xpath("//span[contains(text(), '" + employeeAlias + "')]")).click();
        wait(1);
        for (int i = 0; i < 6; i++) {
            ac.sendKeys(Keys.TAB).perform();
        }
        ac.sendKeys(Keys.TAB).perform();
        getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

        getSession().log_Info("Click on 'edit' button");
        getDriver().waitForelementToBeClickable(editBtn);
        editBtn.click();
        getSession().log_Pass("Clicked on 'edit' button");
        return new EmployeeMasterPage();

    }

    /**
     * Click on Add + Employee Button
     */

    public ILiglPage clickOnAddEmployeeButton() throws Exception {
        getSession().log_Info("Click on '+ Employee' Button'");
        getDriver().waitForelementToBeClickable(addEmpBtn);
        addEmpBtn.click();
        getDriver().waitForAngularRequestsToComplete();
        getSession().log_Pass("Clicked on '+ Employee' Button'");
        return new EmployeeMasterPage();

    }

    /**
     * Click on +Bulk Import Button
     */

    public ILiglPage employeeBulkImport(String importEmpFile) throws Exception {
        try {

            //+ Bulk Import
            getSession().log_Info("Click on + Bulk Import");
            getDriver().waitForelementToBeClickable(bulkImportBtn);
            bulkImportBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on + Bulk Import");

            //Browser the File
            getSession().log_Info("Browser the Import Employee Execl File  " + importEmpFile);
            browserFile.sendKeys(importEmpFile);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Browsered Import Employee Execl File  " + importEmpFile);

            //Import Button
            getSession().log_Info("Click on 'Import' Button");
            getDriver().waitForelementToBeClickable(ImportFilebtn);
            ImportFilebtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Import' Button");

            wait(3);

            log_Info("Click Scroll Bar And Move to Right");
            getCurrentDriver().findElement(By.xpath("(//div[@col-id='FullName']//span//span//span)[1]")).click();
            wait(1);
            for (int j = 0; j < 8; j++) {
                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            getSession().log_Pass("Clicked Scroll Bar And Moved to Right");

            getSession().log_Info("Verfiy the Employee Import Status");
            boolean temp = false;
            String expectedValue = "Completed"; //Import Completed
            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));
            for (int i = 0; i < listItem.size(); i++) {
                String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']" +
                        "//div[@role='row'][" + (i + 1) + "]//div[@col-id='importStatus']//span[@class='ellipsisAgGrid']")).getText();

                getSession().log_Pass("Employee Import Status" + actualValue.toUpperCase());

                if (actualValue.equalsIgnoreCase(expectedValue))
                    temp = true;
                else
                    temp = false;
                break;

            }

            Assert.assertEquals(temp == true, true);
            wait(4);
            return new EmployeeMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Import New Employee Failed", ex);
        } // TODO: handle exception
    }

    /**
     * TC33890 Verify the process of Creating new Employee using +Employee button
     */


    public ILiglPage createNewEmployee(
            String id, String firstName, String middleName, String lastName,
            String alias, String department, String title, String checkTitleOptional, String lastUpdate,
            String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String empEmail, String alternateEmail, String secondaryEmail,
            String mobileNumber, String telephoneNumber, String faxNumber, String category, String entity, String location, String division,
            String accountType, String accountManagerFirstName, String accountManagerMiddleName, String accountManagerLastName, String reportingManager,
            String officeType, String officeName, String officeAddressLine, String officeAddressBuildingCode, String officeAddressCampusCode,
            String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity, String officeAddressState, String affiliation,
            String homeDepartmentCode

    ) throws Exception {
        try {

            //ID
            getSession().log_Info("Enter ID");
            empIDTxt.sendKeys(id);
            getSession().log_Pass("ID Entered");

            //First Name
            getSession().log_Info("Enter First Name");
            firstNameTxt.sendKeys(firstName);
            getSession().log_Pass("First Name Entered");

            //Middle Name
            getSession().log_Info("Enter Middel Name");
            middileNameTxt.sendKeys(middleName);
            getSession().log_Pass("Middel Name Entered");

            //Last Name
            getSession().log_Info("Enter Last Name");
            lastNameTXt.sendKeys(lastName);
            getSession().log_Pass("Last Name Entered");

            //Alias
            getSession().log_Info("Enter Alias");
            aliasTxt.sendKeys(alias);
            getSession().log_Pass("Alias Entered");

            //Department Name
            getSession().log_Info("Enter Department Name");
            departmentDrpDwn.sendKeys(department);
            wait(1);
            departmentDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Department Name Entered");

            //Title
            getSession().log_Info("Enter Title");
            titleTxt.sendKeys(title);
            getSession().log_Pass("Title Entered");

            //Title Optional
            if (checkTitleOptional.contains("Yes")) {
                getSession().log_Info("Verify 'Title' field is an optional field");
                try {
                    boolean mark = titleOptionalMark.isDisplayed();
                    Assert.assertEquals(false, mark);
                } catch (Exception exception) {
                    getSession().log_Pass("'Title' field is an optional field");

                    //Employment Status
                    getSession().log_Info("Select the 'Employment Status'");
                    getDriver().waitForelementToBeClickable(empStatusDrpDwn);
                    empStatusDrpDwn.sendKeys(status);
                    Thread.sleep(2000);
                    empStatusDrpDwn.sendKeys(Keys.ENTER);
                    getSession().log_Pass("Selected the 'Employment Status'");

                    //Navigate to Contact
                    getSession().log_Info("Click on Contact link");
                    getDriver().waitForelementToBeClickable(contactLink);
                    contactLink.click();
                    getSession().log_Pass("Clicked on Contact link");

                    //Email
                    getSession().log_Info("Enter Email");
                    empEmailTxt.sendKeys(empEmail);
                    getSession().log_Pass("Email Entered");

                    //Next
                    getSession().log_Info("Click on Next Button");
                    getDriver().waitForelementToBeClickable(nextBtn);
                    nextBtn.click();
                    getDriver().waitForAngularRequestsToComplete();

                    //Save
                    getSession().log_Info("Click on 'Save' Button");
                    getDriver().waitForelementToBeClickable(saveBtn);
                    saveBtn.click();
                    getDriver().waitForAngularRequestsToComplete();
                    getSession().log_Pass("Clicked on 'Save' Button");
                }
                return new EmployeeMasterPage();
            }

            //Source Last Updated Date
            getSession().log_Info("Check the 'Source Last Updated Date'");
            //lastUpdatedData.getText();
            getSession().log_Pass("Current displayed in 'Source Last Updated Date'");

            //Date Joined
            getSession().log_Info("Enter Date Joined");
            String empJoinDateNew = empJoinDate.replace(".", "");
            joinedDate.sendKeys(empJoinDateNew);
            getSession().log_Pass("Date Joined Entered");

            //Date Terminated
            getSession().log_Info("Enter Date Terminated");
            String empTerminatedDateNew = empTerminatedDate.replace(".", "");
            terminatedDate.sendKeys(empTerminatedDateNew);
            getSession().log_Pass("Date Terminated Entered");

            //Employment Status
            getSession().log_Info("Select the 'Employment Status'");
            getDriver().waitForelementToBeClickable(empStatusDrpDwn);
            empStatusDrpDwn.sendKeys(status);
            Thread.sleep(2000);
            empStatusDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected the 'Employment Status'");

            //Historic Employee ID
            getSession().log_Info("Enter Historic Employee ID");
            empHistoricIdTxt.sendKeys(empHistoricID);
            getSession().log_Pass("Historic Employee ID Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();

            //Email
            getSession().log_Info("Enter Email");
            empEmailTxt.sendKeys(empEmail);
            getSession().log_Pass("Email Entered");

            //Alternate Email
            getSession().log_Info("Enter Alternate Email");
            empAltEmailTxt.sendKeys(alternateEmail);
            getSession().log_Pass("Entered Alternate Email");

            //Secondary Email
            getSession().log_Info("Enter Secondary Email");
            empSecEmailTxt.sendKeys(secondaryEmail);
            getSession().log_Pass("Entered Secondary Email");

            //mobile
            getSession().log_Info("Enter 20 digits Mobile Number");
            String mobileNumberNew = mobileNumber.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(moileNumTxt);
            moileNumTxt.sendKeys(mobileNumberNew);
            getSession().log_Pass("20 digits Mobile Number Entered" + mobileNumberNew);

            //Work phone
            getSession().log_Info("Enter Work Phone Number");
            getDriver().waitForelementToBeClickable(wrkPhnTXT);
            String telephoneNumberNew = telephoneNumber.replace("*", ""); //remove special character
            wrkPhnTXT.sendKeys(telephoneNumberNew);
            getSession().log_Pass("Work Phonephone Number Entered");

            //Work Fax
            getSession().log_Info("Enter Work Fax Number");
            getDriver().waitForelementToBeClickable(wrkFaxTxt);
            String faxNumberNew = faxNumber.replace("*", ""); //remove special character
            wrkFaxTxt.sendKeys(faxNumberNew);
            getSession().log_Pass("Work Fax Number Entered");

            //Category
            getSession().log_Info("Select Category");
            categoryDrpDwn.sendKeys(category);
            wait(1);
            categoryDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Category Selected");

            //Entity
            getSession().log_Info("Select Entity");
            getDriver().waitForelementToBeClickable(entityDrpDwn);
            entityDrpDwn.sendKeys(entity);
            wait(1);
            entityDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Entity' Selected");

            //Location
            getSession().log_Info("Select Location");
            getDriver().waitForelementToBeClickable(locationDrpDwn);
            locationDrpDwn.sendKeys(location);
            wait(1);
            locationDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Location' Selected");

            //Division
            getSession().log_Info("Select Division");
            getDriver().waitForelementToBeClickable(divisionDrpDwn);
            divisionDrpDwn.sendKeys(division);
            wait(1);
            divisionDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Division' Selected");

            //Account Type
            getSession().log_Info("Enter 'Account Type'");
            accoutTypeTxt.sendKeys(accountType);
            getSession().log_Pass("'Account Type' Entered");

            //Account Manager First Name
            getSession().log_Info("Enter 'Account Manager First Name'");
            accountManagerFirstNameTxt.sendKeys(accountManagerFirstName);
            getSession().log_Pass("'Account Manager First Name' Entered");

            //Account Manager Middle Name
            getSession().log_Info("Enter 'Account Manager Middle Name'");
            accountManagerMiddleNameTxt.sendKeys(accountManagerMiddleName);
            getSession().log_Pass("'Account Manager Middle Name' Entered");

            //Account Manager Last Name
            getSession().log_Info("Enter 'Account Manager Last Name'");
            accountManagerLastNameTxt.sendKeys(accountManagerLastName);
            getSession().log_Pass("'Account Manager Last Name' Entered");

            //Reporting Manager
            getSession().log_Info("Enter Reporting Manager");
            contactReportingManager.sendKeys(reportingManager);
            getSession().log_Pass("Reporting Manager Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Next' Button");

            //Office Type
            getSession().log_Info("Select Office Type");
            getDriver().waitForelementToBeClickable(officeTypeDrpDwn);
            officeTypeDrpDwn.sendKeys(entity);
            wait(1);
            officeTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Office Type' Selected");

            //Office Name
            getSession().log_Info("Enter Office Name");
            officeNameTxt.sendKeys(officeName);
            getSession().log_Pass("Entered Office Name");

            //Office Address Line
            getSession().log_Info("Enter Office Address Line");
            officeAddressLineTxt.sendKeys(officeAddressLine);
            getSession().log_Pass("Entered Office Address Line");

            //Office Address Building Code
            getSession().log_Info("Enter 'Office Address Building Code'");
            officeAddressBuildingCodeTxt.sendKeys(officeAddressBuildingCode);
            getSession().log_Pass("Office Address Building Code Entered");

            //Office Address Campus Code
            getSession().log_Info("Enter Office Address Campus Code");
            officeAddressCampusCodeTxt.sendKeys(officeAddressCampusCode);
            getSession().log_Pass("Entered Office Address Campus Code");

            //Office Address Mailing Code
            getSession().log_Info("Enter Office Address Mailing Code");
            officeAddressMailingCodeTxt.sendKeys(officeAddressMailingCode);
            getSession().log_Pass("Entered Office Address Mailing Code");

            //Office Address Zip Code
            getSession().log_Info("Enter Office Address Zip Code");
            officeAddressZipCodeTxt.sendKeys(officeAddressZipCode);
            getSession().log_Pass("Entered Office Address Zip Code");

            //Office Address City
            getSession().log_Info("Enter Office Address City");
            officeAddressCityTxt.sendKeys(officeAddressCity);
            getSession().log_Pass("Entered Office Address City");

            //Office Address State
            getSession().log_Info("Enter Office Address State");
            officeAddressStateTxt.sendKeys(officeAddressState);
            getSession().log_Pass("Entered Office Address State");

            //Affiliation
            getSession().log_Info("Enter Affiliation");
            affliationTxt.sendKeys(affiliation);
            getSession().log_Pass("Affiliation Entered");

            //Home Department Code
            getSession().log_Info("Enter Home Department Code");
            homeDepartmentCodeTxt.sendKeys(homeDepartmentCode);
            getSession().log_Pass("'Home Department Code' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");
            wait(5);
            return new EmployeeMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Create New Employee Failed", ex);
        }
    }

    public ILiglPage editEmployee(
            String firstName, String middleName, String lastName,
            String department, String title, String checkTitleOptional, String lastUpdate,
            String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String alternateEmail,
            String secondaryEmail, String mobileNumber, String telephoneNumber, String faxNumber,
            String category, String empEntity, String location, String division,
            String reportingManager, String entity, String officeName, String officeAddressLine, String officeAddressBuildingCode,
            String officeAddressCampusCode, String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity,
            String officeAddressState, String affiliation, String homeDepartmentCode

    ) throws Exception {
        try {

            //First Name
            getSession().log_Info("Clear the First Name");
            firstNameTxt.clear();
            getSession().log_Pass("FirstName Cleared");
            getSession().log_Info("Enter First Name");
            firstNameTxt.sendKeys(firstName);
            getSession().log_Pass("First Name Entered");

            //Middle Name
            getSession().log_Info("Clear Middle Name");
            middileNameTxt.clear();
            getSession().log_Pass("Middle Name Cleared");
            getSession().log_Info("Enter Middel Name");
            middileNameTxt.sendKeys(middleName);
            getSession().log_Pass("Middel Name Entered");

            //Last Name
            getSession().log_Info("clear Last Name");
            lastNameTXt.clear();
            getSession().log_Pass("Last Name Cleared");
            getSession().log_Info("Enter Last Name");
            lastNameTXt.sendKeys(lastName);
            getSession().log_Pass("Last Name Entered");

            //Department Name
            getSession().log_Info("Enter Department Name");
            departmentDrpDwn.sendKeys(department);
            wait(1);
            departmentDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Department Name Entered");

            //Title
            getSession().log_Info("Enter Title");
            titleTxt.sendKeys(title);
            getSession().log_Pass("Title Entered");

            //Title Optional
            if (checkTitleOptional.contains("Yes")) {
                getSession().log_Info("Verify 'Title' field is an optional field");
                try {
                    boolean mark = titleOptionalMark.isDisplayed();
                    Assert.assertEquals(false, mark);
                } catch (Exception exception) {

                    getSession().log_Pass("'Title' field is an optional field");

                    //Navigate to Contact
                    getSession().log_Info("Click on Contact link");
                    getDriver().waitForelementToBeClickable(contactLink);
                    contactLink.click();
                    getSession().log_Pass("Clicked on Contact link");

                    //Next
                    getSession().log_Info("Click on Next Button");
                    getDriver().waitForelementToBeClickable(nextBtn);
                    nextBtn.click();
                    getDriver().waitForAngularRequestsToComplete();

                    //Save
                    getSession().log_Info("Click on 'Save' Button");
                    getDriver().waitForelementToBeClickable(saveBtn);
                    saveBtn.click();
                    getDriver().waitForAngularRequestsToComplete();
                    getSession().log_Pass("Clicked on 'Save' Button");
                }
                return new EmployeeMasterPage();
            }

            //Source Last Updated Date
            getSession().log_Info("Check the 'Source Last Updated Date'");
            //lastUpdatedData.getText();
            getSession().log_Pass("Current displayed in 'Source Last Updated Date'");

            //Date Joined
            getSession().log_Info("Clear the Joined Date");
            getDriver().waitForelementToBeClickable(joinedDate);
            //joinedDate.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            joinedDate.clear();
            getSession().log_Pass("Joined Date Cleared");
            getSession().log_Info("Enter Date Joined");
            String empJoinDateNew = empJoinDate.replace(".", "");
            joinedDate.sendKeys(empJoinDateNew);
            getSession().log_Pass("Date Joined Entered");

            //Date Terminated
            getSession().log_Info("Clear the Terminated Date");
            getDriver().waitForelementToBeClickable(terminatedDate);
            terminatedDate.clear();
            //terminatedDate.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            wait(1);
            getSession().log_Pass("Terminated Date Cleared");
            getSession().log_Info("Enter Date Terminated");
            String empTerminatedDateNew = empTerminatedDate.replace(".", "");
            terminatedDate.sendKeys(empTerminatedDateNew);
            getSession().log_Pass("Date Terminated Entered");

            //Employment Status
            getSession().log_Info("Select the 'Employment Status'");
            getDriver().waitForelementToBeClickable(empStatusDrpDwn);
            empStatusDrpDwn.sendKeys(status);
            getSession().log_Pass("Selected the 'Employment Status'");

            //Historic Employee ID
            getSession().log_Info("Enter Historic Employee ID");
            empHistoricIdTxt.clear();
            empHistoricIdTxt.sendKeys(empHistoricID);
            getSession().log_Pass("Historic Employee ID Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            wait(2);
            //getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();

            //Alternate Email
            getSession().log_Info("Enter Alternate Email");
            empAltEmailTxt.clear();
            empAltEmailTxt.sendKeys(alternateEmail);
            getSession().log_Pass("Entered Alternate Email");

            //Secondary Email
            getSession().log_Info("Enter Secondary Email");
            empSecEmailTxt.clear();
            empSecEmailTxt.sendKeys(secondaryEmail);
            getSession().log_Pass("Entered Secondary Email");

            //mobile
            getSession().log_Info("Enter 20 digits Mobile Number");
            moileNumTxt.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            wait(1);
            String mobileNumberNew = mobileNumber.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(moileNumTxt);
            moileNumTxt.sendKeys(mobileNumberNew);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("20 digits Mobile Number Entered" + mobileNumberNew);

            //Work phone
            getSession().log_Info("Enter Work Phone Number");
            wrkPhnTXT.sendKeys(Keys.CONTROL + "A", Keys.DELETE);
            wait(1);
            getDriver().waitForelementToBeClickable(wrkPhnTXT);
            String telephoneNumberNew = telephoneNumber.replace("*", ""); //remove special character
            wrkPhnTXT.sendKeys(telephoneNumberNew);
            getSession().log_Pass("Work Phonephone Number Entered");

            //Work Fax
            getSession().log_Info("Enter Work Fax Number");
            wrkFaxTxt.clear();
            wait(1);
            getDriver().waitForelementToBeClickable(wrkFaxTxt);
            String faxNumberNew = faxNumber.replace("*", ""); //remove special character
            wrkFaxTxt.sendKeys(faxNumberNew);
            getSession().log_Pass("Work Fax Number Entered");

            //Category
            getSession().log_Info("Select Category");
            categoryDrpDwn.sendKeys(category);
            wait(1);
            categoryDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Category' Selected");

            //Entity
            getSession().log_Info("Select Entity");
            entityDrpDwn.sendKeys(entity);
            wait(1);
            entityDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Entity' Selected");

            //Location
            getSession().log_Info("Select 'Location'");
            locationDrpDwn.sendKeys(location);
            wait(1);
            locationDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Location' Selected");

            //Division
            getSession().log_Info("Select Division");
            divisionDrpDwn.sendKeys(division);
            wait(1);
            divisionDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Account Manager Last Name' Entered");

            //Reporting Manager
            getSession().log_Info("Enter Reporting Manager");
            contactReportingManager.clear();
            wait(1);
            contactReportingManager.sendKeys(reportingManager);
            getSession().log_Pass("Reporting Manager Entered");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Next' Button");

            //Office Type
            getSession().log_Info("Select Office Type");
            getDriver().waitForelementToBeClickable(officeTypeDrpDwn);
            officeTypeDrpDwn.sendKeys(entity);
            wait(1);
            officeTypeDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Office Type' Selected");

            //Office Name
            getSession().log_Info("Enter Office Name");
            officeNameTxt.clear();
            wait(1);
            officeNameTxt.sendKeys(officeName);
            getSession().log_Pass("Entered Office Name");

            //Office Address Line
            getSession().log_Info("Enter Office Address Line");
            officeAddressLineTxt.clear();
            wait(1);
            officeAddressLineTxt.sendKeys(officeAddressLine);
            getSession().log_Pass("Entered Office Address Line");

            //Office Address Building Code
            getSession().log_Info("Enter 'Office Address Building Code'");
            officeAddressBuildingCodeTxt.clear();
            wait(1);
            officeAddressBuildingCodeTxt.sendKeys(officeAddressBuildingCode);
            getSession().log_Pass("Office Address Building Code Entered");

            //Office Address Campus Code
            getSession().log_Info("Enter Office Address Campus Code");
            officeAddressCampusCodeTxt.clear();
            wait(1);
            officeAddressCampusCodeTxt.sendKeys(officeAddressCampusCode);
            getSession().log_Pass("Entered Office Address Campus Code");

            //Office Address Mailing Code
            getSession().log_Info("Enter Office Address Mailing Code");
            officeAddressMailingCodeTxt.clear();
            wait(1);
            officeAddressMailingCodeTxt.sendKeys(officeAddressMailingCode);
            getSession().log_Pass("Entered Office Address Mailing Code");

            //Office Address Zip Code
            getSession().log_Info("Enter Office Address Zip Code");
            officeAddressZipCodeTxt.clear();
            wait(1);
            officeAddressZipCodeTxt.sendKeys(officeAddressZipCode);
            getSession().log_Pass("Entered Office Address Zip Code");

            //Office Address City
            getSession().log_Info("Enter Office Address City");
            officeAddressCityTxt.clear();
            wait(1);
            officeAddressCityTxt.sendKeys(officeAddressCity);
            getSession().log_Pass("Entered Office Address City");

            //Office Address State
            getSession().log_Info("Enter Office Address State");
            officeAddressCityTxt.clear();
            wait(1);
            officeAddressStateTxt.sendKeys(officeAddressState);
            getSession().log_Pass("Entered Office Address State");

            //Affiliation
            getSession().log_Info("Enter Affiliation");
            officeAddressCityTxt.clear();
            wait(1);
            affliationTxt.sendKeys(affiliation);
            getSession().log_Pass("Affiliation Entered");

            //Home Department Code
            getSession().log_Info("Enter Home Department Code");
            officeAddressCityTxt.clear();
            wait(1);
            homeDepartmentCodeTxt.sendKeys(homeDepartmentCode);
            getSession().log_Pass("'Home Department Code' Entered");

            //Save
            getSession().log_Info("Click on 'Save' Button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Save' Button");

            wait(5);
            return new EmployeeMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Employee Failed", ex);
        }
    }

    /**
     * TC 51896 Employee Edit- Verify whether mentioned fields are non-editable
     */

    public ILiglPage empNonEditableFields() throws Exception {
        try {
            //ID
            getSession().log_Info("Check that 'Employee ID' is Non-Editable Field");
            boolean title = empIDTxt.isEnabled();
            Assert.assertEquals(title, false);
            getSession().log_Pass("'Employee ID' is Non-Editable Field");

            //Alias
            getSession().log_Info("Check that 'Alias' is Non-Editable Field");
            boolean Alias = aliasTxt.isEnabled();
            Assert.assertEquals(Alias, false);
            getSession().log_Pass("'Alias' is Non-Editable Field");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Next Button Clicked");

            //Email
            getSession().log_Info("Check that 'Email' is Non-Editable Field");
            boolean Email = empEmailTxt.isEnabled();
            Assert.assertEquals(Email, false);
            getSession().log_Pass("'Email' is Non-Editable Field");

            //Account Type
            getSession().log_Info("Check that 'Account Type' is Non-Editable Field");
            boolean AccountType = accoutTypeTxt.isEnabled();
            Assert.assertEquals(AccountType, false);
            getSession().log_Pass("'Account Type' is Non-Editable Field");

            //Account Manager First Name
            getSession().log_Info("Check that 'Account Manager First Name' is Non-Editable Field");
            boolean AccountManagerFirstName = accountManagerFirstNameTxt.isEnabled();
            Assert.assertEquals(AccountManagerFirstName, false);
            getSession().log_Pass("'Account Manager First Name' is Non-Editable Field");

            //Account Manager Middle Name
            getSession().log_Info("Check that 'Account Manager Middle Name' is Non-Editable Field");
            boolean AccountManagerMiddleName = accountManagerMiddleNameTxt.isEnabled();
            Assert.assertEquals(AccountManagerMiddleName, false);
            getSession().log_Pass("'Account Manager Middle Name' is Non-Editable Field");

            //Account Manager Last Name
            getSession().log_Info("Check that 'Account Manager Last Name' is Non-Editable Field");
            boolean AccountManagerLastName = accountManagerLastNameTxt.isEnabled();
            Assert.assertEquals(AccountManagerLastName, false);
            getSession().log_Pass("'Account Manager Last Name' is Non-Editable Field");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Next Button Clicked");

            //Cancel
            getSession().log_Info("click on Cancel button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Cancel Button Clicked");
            return new EmployeeMasterPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Edit Employee Failed", ex);
        }
    }


    /**
     * TC 43113 Create & Edit Employee- Verify Maximum length of Mobile, Telephone & Fax numbers fields should not exceed 20 digits
     */


    public ILiglPage employeeMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
            throws Exception {
        try {

            getSession().log_Info("Click on Contact link");
            getDriver().waitForelementToBeClickable(contactLink);
            contactLink.click();
            getSession().log_Pass("Clicked on Contact link");

           /*String maxLengthCount = moileNumTxt.getAttribute("maxlength");
           int maxDigit = Integer.parseInt(maxLengthCount);*/

            //mobile
            getSession().log_Info("Clear Mobile Number Field");
            moileNumTxt.clear();
            getSession().log_Pass("Mobile Number Field Cleared");
            getSession().log_Info("Enter 20 digits Mobile Number");
            String mobileNumberNew = mobileNumber.replace("*", ""); //remove special character
            getDriver().waitForelementToBeClickable(moileNumTxt);
            moileNumTxt.sendKeys(mobileNumberNew);
            getSession().log_Pass("20 digits Mobile Number Entered" + mobileNumberNew);
            //Mobile 20 digits
            getSession().log_Info("Verify that Maximum length of Mobile fields should not exceed 20 digits");
            int givenMobile = mobileNumberNew.length();
            assertEquals(20, givenMobile);
            getSession().log_Pass("Maximum length of Mobile fields 20 digits");

            //Telephone
            getSession().log_Info("Clear Telephone Number Field");
            wrkPhnTXT.clear();
            getSession().log_Pass("Telephone Number Field Cleared");
            getSession().log_Info("Enter 20 digits Telephone Number");
            getDriver().waitForelementToBeClickable(wrkPhnTXT);
            String telephoneNumberNew = telephoneNumber.replace("*", ""); //remove special character
            wrkPhnTXT.sendKeys(telephoneNumberNew);
            getSession().log_Pass("20 digits Telephone Number Entered");
            //Telephone 20 digits
            getSession().log_Info("Verify Maximum length of Telephone fields should not exceed 20 digits");
            int giveTelephone = telephoneNumberNew.length();
            assertEquals(20, giveTelephone);
            getSession().log_Pass("Maximum length of Telephone fields 20 digits");

            //Fax
            getSession().log_Info("Clear Fax Number Field");
            wrkFaxTxt.clear();
            getSession().log_Pass("Fax Number Field Cleared");
            getSession().log_Info("Enter 20 digits Fax Number");
            getDriver().waitForelementToBeClickable(wrkFaxTxt);
            String faxNumberNew = faxNumber.replace("*", ""); //remove special character
            wrkFaxTxt.sendKeys(faxNumberNew);
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

            return new EmployeeMasterPage();
        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("Employee Edit Mobile, Telephone & Fax numbers fields should not exceed 20 digits Failed", ex);
        }

    }

    /**
     * 30468 Employee Edit- Verify whether 'HR Status' , 'Hire Date' , 'Terminated Date' fields are editable
     */

    public ILiglPage editableFiedsHRStatusHireDateTerminatedDate(String empJoinDate, String empTerminatedDate, String status) throws Exception {
        try {
            //Date Joined
            getSession().log_Info("Enter Date Joined");
            joinedDate.clear();
            String empJoinDateNew = empJoinDate.replace("*", "");
            wait(2);
            joinedDate.sendKeys(empJoinDateNew);
            getSession().log_Pass("Date Joined Entered");

            //Date Terminated
            getSession().log_Info("Enter Date Terminated");
            terminatedDate.clear();
            wait(2);
            String empTerminatedDateNew = empTerminatedDate.replace("*", "");
            terminatedDate.sendKeys(empTerminatedDateNew);
            getSession().log_Pass("Date Terminated Entered");

            //Employment Status
            getSession().log_Info("Select the 'Employment Status'");
            getDriver().waitForelementToBeClickable(empStatusDrpDwn);
            empStatusDrpDwn.sendKeys(status);
            Thread.sleep(2000);
            empStatusDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Selected the 'Employment Status'");

            //Address
            getSession().log_Info("Click on Address link");
            getDriver().waitForelementToBeClickable(addressLink);
            addressLink.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on Address link");

            //Save
            getSession().log_Info("click on Save button");
            getDriver().waitForelementToBeClickable(saveBtn);
            saveBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Save Button Clicked");
            wait(5);
            return new EmployeeMasterPage();

        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("'HR Status' , 'Hire Date' , 'Terminated Date' fields are editable Failed", ex);
        }

    }

    /**
     * 35807 Create & Edit Employee- Check whether Designation is changed to 'Title'
     */

    public ILiglPage titleFieldName() throws Exception {
        try {
            getSession().log_Info("Check whether Designation is changed to 'Title'");
            String title = getCurrentDriver().findElement(By.xpath("//label[@for='title']")).getText();
            Assert.assertNotEquals(title, "Designation");
            getSession().log_Pass("Designation is changed to 'Title'");

            //Cancel
            getSession().log_Info("Click on Cancel Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On cancel Button");

            return new EmployeeMasterPage();
        } catch (Exception e) {
            // TODO: handle exception
            log_Error(e.getMessage());
            throw new Exception("Designation is changed to 'Title'", e);
        }
    }

    /**
     * TC20363 Create & Edit Employee- Verify mentioned Optional dropdown fields are available & user is able to save successfully
     */
    public ILiglPage availablityOfOptionlDropDowns() throws Exception {
        try {
            getSession().log_Info("Click on Contact link");
            getDriver().waitForelementToBeClickable(contactLink);
            contactLink.click();
            wait(2);
            getSession().log_Pass("Clicked on Contact link");

            //Category
            getSession().log_Info("Check Availablity of Category");
            boolean a1 = categoryDrpDwn.isDisplayed();
            Assert.assertEquals(a1, true);
            getSession().log_Pass("Category available");

            //Entity
            getSession().log_Info("Check Availablity of Entity");
            Assert.assertEquals(entityDrpDwn.isDisplayed(), true);
            getSession().log_Pass("'Entity' available");

            //Location
            getSession().log_Info("Check Availablity of Location");
            Assert.assertEquals(locationDrpDwn.isDisplayed(), true);
            getSession().log_Pass("'Location' available");

            //Division
            getSession().log_Info("Check Availablity of Division");
            Assert.assertEquals(divisionDrpDwn.isDisplayed(), true);
            getSession().log_Pass("'Division' available");

            //Address
            getSession().log_Info("Click on Address link");
            getDriver().waitForelementToBeClickable(addressLink);
            addressLink.click();
            wait(2);
            getSession().log_Pass("Clicked on Address link");

            //Office Type
            getSession().log_Info("Check Availablity of Office Type");
            Assert.assertEquals(officeTypeDrpDwn.isDisplayed(), true);
            getSession().log_Pass("'Office Type' available");

            //Cancel
            getSession().log_Info("Click on 'Cancel' Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Cancel' Button");

            wait(3);
            return new EmployeeMasterPage();
        } catch (Exception e) {
            // TODO: handle exception
            log_Error(e.getMessage());
            throw new Exception("Availablity Of Optionl DropDowns Failed", e);
        }
    }

    public ILiglPage availablityOfOptionlFields() throws Exception {
        try {
            //Historic Employee ID
            getSession().log_Info("Check the Availablity of Historic Employee ID");
            Assert.assertEquals(empHistoricIdTxt.isDisplayed(), true);
            getSession().log_Pass("Historic Employee ID available");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();

            //Account Type
            getSession().log_Info("Check the Availablity of 'Account Type'");
            Assert.assertEquals(accoutTypeTxt.isDisplayed(), true);
            getSession().log_Pass("'Account Type' available");

            //Account Manager First Name
            getSession().log_Info("Check the Availablity of 'Account Manager First Name'");
            Assert.assertEquals(accountManagerFirstNameTxt.isDisplayed(), true);
            getSession().log_Pass("'Account Manager First Name' available");

            //Account Manager Middle Name
            getSession().log_Info("Check the Availablity of 'Account Manager Middle Name'");
            Assert.assertEquals(accountManagerMiddleNameTxt.isDisplayed(), true);
            getSession().log_Pass("'Account Manager Middle Name' available");

            //Account Manager Last Name
            getSession().log_Info("Check the Availablity of 'Account Manager Last Name'");
            Assert.assertEquals(accountManagerLastNameTxt.isDisplayed(), true);
            getSession().log_Pass("'Account Manager Last Name' available");

            //Reporting Manager
            getSession().log_Info("Check the Availablity of Reporting Manager");
            Assert.assertEquals(contactReportingManager.isDisplayed(), true);
            getSession().log_Pass("Reporting Manager available");

            //Next
            getSession().log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(nextBtn);
            nextBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Next' Button");

            //Office Name
            wait(2);
            getSession().log_Info("Check the Availablity of Office Name");
            Assert.assertEquals(officeNameTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Name");

            //Office Address Line
            getSession().log_Info("Check the Availablity of Office Address Line");
            Assert.assertEquals(officeAddressLineTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address Line");

            //Office Address Building Code
            getSession().log_Info("Check the Availablity of 'Office Address Building Code'");
            Assert.assertEquals(officeAddressBuildingCodeTxt.isDisplayed(), true);
            getSession().log_Pass("Office Address Building Code available");

            //Office Address Campus Code
            getSession().log_Info("Check the Availablity of Office Address Campus Code");
            Assert.assertEquals(officeAddressCampusCodeTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address Campus Code");

            //Office Address Mailing Code
            getSession().log_Info("Check the Availablity of Office Address Mailing Code");
            Assert.assertEquals(officeAddressMailingCodeTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address Mailing Code");

            //Office Address Zip Code
            getSession().log_Info("Check the Availablity of Office Address Zip Code");
            Assert.assertEquals(officeAddressZipCodeTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address Zip Code");

            //Office Address City
            getSession().log_Info("Check the Availablity of Office Address City");
            Assert.assertEquals(officeAddressCityTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address City");

            //Office Address State
            getSession().log_Info("Check the Availablity of Office Address State");
            Assert.assertEquals(officeAddressStateTxt.isDisplayed(), true);
            getSession().log_Pass("available Office Address State");

            //Affiliation
            getSession().log_Info("Check the Availablity of Affiliation");
            Assert.assertEquals(affliationTxt.isDisplayed(), true);
            getSession().log_Pass("Affiliation available");

            //Home Department Code
            getSession().log_Info("Check the Availablity of Home Department Code");
            Assert.assertEquals(homeDepartmentCodeTxt.isDisplayed(), true);
            getSession().log_Pass("'Home Department Code' available");

            //Cancel
            getSession().log_Info("Click on 'Cancel' Button");
            getDriver().waitForelementToBeClickable(cancelBtn);
            cancelBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Cancel' Button");

            return new EmployeeMasterPage();
        } catch (Exception e) {
            log_Error(e.getMessage());
            throw new Exception("Availability Of Optionl Fields Failed", e);
        }
    }

    public ILiglPage getFieldsDataFromEmployee(Hashtable<String, String> data) throws Exception{
        try{
            clickOnImport();
            clickOnAddEmployeeButton();
            createNewEmployee(data.get("EmpID"), data.get("FirstName"), data.get("MiddleName"), data.get("LastName"), data.get("Alias"),
                    data.get("Department"), "","","","","", data.get("Status"),
                    "", data.get("EmpEmail"),"","","","","","",
                    "","","", data.get("AccountType"), "","","",
                    "","","","","","","",
                    "","","","","");

            wait(2);
            clickOnEmployee();
            searchAndSelectTheEmployee(data.get("Alias"));

            String firstName = firstNameTxt.getAttribute("value");
            String middleName = middileNameTxt.getAttribute("value");
            String lastName = lastNameTXt.getAttribute("value");
            String employeeName = firstName+" "+ middleName+" "+lastName;
            getSession().setRegressionData("get_EmployeeFullName", employeeName);
            nextBtn.click();
            getSession().setRegressionData("get_EmployeeEmailID", empEmailTxt.getAttribute("value"));
            cancelBtn.click();
            wait(2);
            return new EmployeeMasterPage();
        }catch (Exception e) {
            log_Error(e.getMessage());
            throw new Exception("get All Employee Fields Data Failed", e);
        }
    }

    public ILiglPage empIdValidation() throws Exception {
        Assert.assertEquals(errorValidation.getText(), "EmployeeCode Already Exists.");

        return new EmployeeMasterPage();
    }

    public ILiglPage empEmailValidation() throws Exception {
        Assert.assertEquals(errorValidation.getText(), "Employee Email Already Exists.");
        return new EmployeeMasterPage();
    }


}
















