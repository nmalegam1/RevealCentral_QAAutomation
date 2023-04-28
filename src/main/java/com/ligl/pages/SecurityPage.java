package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SecurityPage extends LiglBaseSessionPage {

    // Verifying Approving Rejected Test Cases WebElements

    @FindBy(xpath = "//span[contains(text(),' Rejected ')]")
    WebElement ApprovalStatus;

    @FindBy(xpath = "//span[contains(text(),'Approved')]")
    WebElement ApprovedStatus;

    @FindBy(id = "btn-send-for-approval")
    WebElement sendForApprovalBtn;

    @FindBy(id = "send-approval-btn")
    WebElement sendApprovalBtn;

    @FindBy(xpath = "//span[contains(text(),' Pending Approval ')]")
    WebElement PendingStatus;

    @FindBy(xpath = "//span[contains(text(),'Not Initiated')] ")
    WebElement NotInitiatedStatus;

    @FindBy(xpath = "//div[contains(text(),'Request Approval')]")
    WebElement RATab;

    @FindBy(id = "input-case-name")
    WebElement batchNameTxt;

    @FindBy(id = "select-approver")
    WebElement selectApprovalDrpDwn;

    @FindBy(id = "template-name")
    WebElement templateNameDrpDwn;

    @FindBy(id = "dual-opt")
    WebElement DualApproval;

    @FindBy(id = "select-approver")
    WebElement SelectorApprover1;

    @FindBy(id = "select-approver-dual")
    WebElement SelectorApprover2;

    @FindBy(id = "approval-subType")
    WebElement ApprovalSubType;

    @FindBy(xpath = "//div[@class='approval-history-body']/table/tbody/tr/td[position()=1] ")
    WebElement AssignedUserName;

    @FindBy(xpath = "//div[@class='approval-history-body']/table/tbody/tr/td[position()=2]")
    WebElement StatusOfUser;

    @FindBy(xpath = "//div[@class='approval-history-body']/table/tbody/tr[position()=2]/td[position()=1]")
    WebElement AssignedUserName1;

    @FindBy(xpath = "//div[@class='approval-history-body']/table/tbody/tr[position()=2]/td[position()=2]")
    WebElement StatusOfUser1;

    @FindBy(xpath = "//button[contains(text(),'Next')]")
    WebElement NextBtn;
    @FindBy(id = "On-Prem-button")
    WebElement OnpremDSTab;

    @FindBy(id = "edit-btn")
    WebElement EditBtn;

    @FindBy(id = "user-button")
    WebElement UsersTab;

    @FindBy(id = "users-access-permissions-save-btn")
    WebElement AddUserBtn;

    @FindBy(xpath = "//mat-select[@id='FullName']")
    WebElement FullNameDropdown;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement FullNameDropdownTypeText;
    @FindBy(id = "send-approval-btn")
    WebElement AddBtn;

    @FindBy(xpath = "//span[contains(text(),'Full Name')]")
    WebElement FullNameCol;

    @FindBy(xpath = "//span[contains(text(),'Full Name')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span[@class='ag-icon ag-icon-menu']")
    WebElement FullNameMenu;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='User.FullName']//span[@class='ellipsisAgGrid']")
    WebElement FullNameColData;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath = "//span[contains(text(),'Approval Batch Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement AppBatchNameMenu;

    @FindBy(xpath = "//span[contains(text(),'Approval Batch Name')]")
    WebElement ApprovalBatchName;

    @FindBy(xpath = "//span[contains(text(),'Custodians Count')]")
    WebElement CustodiansCount;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='CustodiansCount']//span[@class='ellipsisAgGrid']")
    WebElement CustodiansCountColData;

    @FindBy(xpath = "//span[contains(text(),'Data Sources Count')]")
    WebElement DatasourcesCount;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DataSourcesCount']//span[@class='ellipsisAgGrid']")
    WebElement DatasourcesCountColData;

    @FindBy(xpath = "//span[contains(text(),'Keywords Count')]")
    WebElement KeywordsCount;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeywordsCount']//span[@class='ellipsisAgGrid']")
    WebElement KeywordsCountColData;

    @FindBy(xpath = "//span[contains(text(),'Date Ranges Count')]")
    WebElement DateRangesCount;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DateRangesCount']//span[@class='ellipsisAgGrid']")
    WebElement DateRangesCountColData;
    @FindBy(xpath = "//button[@id='appr-approve-btn']")
    WebElement ApproveBtn;

    @FindBy(xpath = "//span[contains(text(),'Approval Status')]")
    WebElement ApprovalStatusColumn;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalStatusName']//span[@class='ellipsisAgGrid']")
    WebElement ApprovalStatusColumnData;

    @FindBy(xpath = "//span[contains(text(),'Approval Type')]")
    WebElement ApprovalType;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalTypeName']//span[@class='ellipsisAgGrid']")
    WebElement ApprovalTypeColData;

    @FindBy(xpath = "//span[contains(text(),'Approval Users')]")
    WebElement ApprovalUsers;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalUsers']//span[@class='ellipsisAgGrid']")
    WebElement ApprovalUsersColData;

    @FindBy(xpath = "//span[contains(text(),'Approved/Rejected On')]")
    WebElement ApprovedOrRejectedOn;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovedOn']//span[@class='ag-cell-value']")
    WebElement ApprovedOrRejectedOnColData;

    @FindBy(xpath = "//input[@aria-label='Filter Columns Input']")
    WebElement ChooseColumnsSearch;

    @FindBy(id = "Columns")
    WebElement ChooseColumnsMenu;

    @FindBy(xpath = "//span[contains(text(),'Approval Batch Name')]")
    WebElement ApprovalBatchNameHeader;

    @FindBy(xpath = "//span[contains(text(),'Approval Users')]")
    WebElement ApprovalUsersHeader;

    @FindBy(xpath = "//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='ApprovalBatchName']//span[@class='ellipsisAgGrid']")
    WebElement ApprovalBatchNameColData;

    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement emailTempText;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement approverNameTxt;
    @FindBy(xpath = "//div[@class='approval-history-body']/table/tbody/tr[position()=1] /td[position()=1]")
    WebElement ApprovalUserName;
    @FindBy(id = "send-approval-btn")
    WebElement SaveBtn;
    @FindBy(xpath = "//button[contains(text(),'Revoke')]")
    WebElement RevokeBtn;

    @FindBy(id = "chk-all-case-casecustodians")
    WebElement allCustodiansChkBox;

    @FindBy(xpath = "//mat-checkbox[@id='SelectAll']")
    WebElement allDataSourcesChkBox;

    @FindBy(id = "chk-all-case-casedateranges")
    WebElement allDataRangesChkBox;

    @FindBy(id = "chk-all-case-casekeywords")
    WebElement allKeywordsChkBox;


    // Verifying Approving Rejected Test Case

    public ILiglPage sendingCaseForApproval() throws Exception {

        try {

            // validating the case Status In Rejected/Approved State And Approving The Case

            log_Info("Check The Status Of Case , It Should Be In Rejected State");
            boolean a1 = ApprovalStatus.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForApproval() Failed", ex);
        }
    }

    /**
     * Method to Send Case for Approval
     *
     * @param BchName
     * @param Apptemp
     * @param UserName
     * @return
     * @throws Exception
     */
    public ILiglPage sendCaseForApproval(String BchName, String Apptemp, String UserName) throws Exception {
        try {
            log_Info("Click send for Approval Button");
            sendApprovalBtn.click();
            log_Pass("Send Approval btn Clicked");
            log_Info("Click next");
            NextBtn.click();
            NextBtn.click();
            NextBtn.click();
            NextBtn.click();
            batchNameTxt.sendKeys(BchName);
            templateNameDrpDwn.click();
            Thread.sleep(4000);
            emailTempText.sendKeys(Apptemp);
            emailTempText.sendKeys(Keys.ENTER);
            Thread.sleep(3000);
            log_Info("Case Approval Temp selected");
            selectApprovalDrpDwn.click();
            log_Info("Select Approver DropDown Clicked");
            Thread.sleep(3000);
            approverNameTxt.sendKeys(UserName);
            Thread.sleep(3000);
            approverNameTxt.sendKeys(Keys.ENTER);
            log_Pass("All Credentials Required for Approval are Given");
            log_Info("Click send for Approval Button");
            sendForApprovalBtn.click();
            log_Pass("Case Sent for Approval");
            return new SecurityPage();
        } catch (Exception ex) {
            throw new Exception("Exception From sendCaseForApproval()", ex);
        }
    }

    public ILiglPage selectOnpremDataSourceForApproval(String DataSource) throws Exception {
        try {
            log_Info("selectOnpremDataSourceForApproval() Started");
            OnpremDSTab.click();
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Click on The Required DataSource Checkbox");
            return new SecurityPage();
        } catch (Exception ex) {
            log_Error(ex.getMessage());
            throw new Exception("selectOnpremDataSourceForApproval()  Failed", ex);
        }
    }

    public ILiglPage verifyingApproveStatus() throws Exception {

        try {

            // validating the case Status In Approved state

            log_Info("Check The Status Of Case , It Should Be In Approved State");
            Thread.sleep(7000);
            boolean a3 = ApprovedStatus.isDisplayed();
            System.out.println(a3);
            Thread.sleep(3000);
            Assert.assertEquals(true, a3);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingApproveStatus() Failed", ex);
        }
    }

    // check whether case is in Not - initiated state

    public ILiglPage validateCaseNotinitiatedState() throws Exception {

        try {


            log_Info("Check The Status Of Case , It Should Be In Not Initiated State");
            boolean b1 = NotInitiatedStatus.isDisplayed();
            System.out.println(b1);
            Thread.sleep(3000);
            Assert.assertEquals(true, b1);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCaseNotinitiatedState() Failed", ex);
        }
    }

    // check whether case is in Pending For Approval state

    public ILiglPage validateCasePendingForApprovalState() throws Exception {

        try {


            log_Info("Check The Status Of Case , It Should Be In Pending For Approval State");
            boolean b2 = PendingStatus.isDisplayed();
            System.out.println(b2);
            Thread.sleep(3000);
            Assert.assertEquals(true, b2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCasePendingForApprovalState() Failed", ex);
        }
    }

    // check whether case is in Rejected state

    public ILiglPage validateCaseRejectedState() throws Exception {

        try {


            log_Info("Check The Status Of Case , It Should Be In Rejected State");
            boolean b3 = ApprovalStatus.isDisplayed();
            System.out.println(b3);
            Thread.sleep(3000);
            Assert.assertEquals(true, b3);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCasePendingForApprovalState() Failed", ex);
        }
    }

    // Verify The Functionality Of Approving Case (Without Selecting Scope Items) By Selecting Single Approval Type

    public ILiglPage sendingCaseForSingleApproval(String BatchNAME, String USER, String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(selectApprovalDrpDwn);
            Thread.sleep(3000);
            selectApprovalDrpDwn.sendKeys(USER);
            Thread.sleep(5000);
            selectApprovalDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            Thread.sleep(10000);
            log_Info("Clicked on Send For Approval Button");
            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);
        }
    }


    public ILiglPage sendingCaseCustodianForApproval(String Employee1, String BatchNAME, String USER, String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(selectApprovalDrpDwn);
            Thread.sleep(3000);
            selectApprovalDrpDwn.sendKeys(USER);
            selectApprovalDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);
        }
    }

    // Verify The Case Status When Dual Approval Is Selected And Both Approved The Status

    public ILiglPage sendingCaseForDualApproval(String Employee1, String BatchNAME, String USER1, String USER2, String SubType, String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Dual Approval Tab");
            getDriver().waitForelementToBeClickable(DualApproval);
            Thread.sleep(3000);
            DualApproval.click();
            log_Info("Clicked on Dual Approval Tab");

            log_Info("Click on Select Approval1  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover1);
            Thread.sleep(5000);
            SelectorApprover1.sendKeys(USER1);
            Thread.sleep(5000);
            SelectorApprover1.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval1  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(USER2);
            Thread.sleep(5000);
            SelectorApprover2.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Approval Type  Drop down");
            getDriver().waitForelementToBeClickable(ApprovalSubType);
            ApprovalSubType.sendKeys(SubType);
            Thread.sleep(5000);
            log_Info("Clicked on Approval Type Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            Thread.sleep(8000);
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);
        }
    }

    // Verify The Approval History Of The Case By Assigned Approvals

    public ILiglPage verifyApprovalHistoryStatus(String AssignedUser1, String Status1, String AssignedUser2, String Status2) throws Exception {

        try {


            log_Info("Check The Assigned UserName");
            Thread.sleep(3000);
            String s1 = AssignedUserName.getText();
            Assert.assertEquals(s1, AssignedUser1);
            log_Info("Checked The Assigned UserName");

            log_Info("Check The Assigned UserName Status");
            Thread.sleep(3000);
            String s2 = StatusOfUser.getText();
            Assert.assertEquals(s2, Status1);
            log_Info("Checked The Assigned UserName Status");

            log_Info("Check The Assigned UserName");
            Thread.sleep(3000);
            String s3 = AssignedUserName1.getText();
            Assert.assertEquals(s3, AssignedUser2);
            log_Info("Checked The Assigned UserName");

            log_Info("Check The Assigned UserName Status");
            Thread.sleep(3000);
            String s4 = StatusOfUser1.getText();
            Assert.assertEquals(s4, Status2);
            log_Info("Checked The Assigned UserName Status");
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyApprovalHistoryStatus() Failed", ex);
        }

    }


    // Verify The Case Status When Dual Approval Is Selected - Linear Type

    public ILiglPage sendingCaseForDualApprovalLinearType(String Employee1, String GmailCheck, String GoogleDriveCheck, String BatchNAME, String EMAIL, String USER1, String USER2, String SubType) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Gmail Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + GmailCheck + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Gmail Checkbox");

            log_Info("Click on Google Drive Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + GoogleDriveCheck + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Google Drive Checkbox");


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");


            log_Info("Click on Dual Approval Tab");
            getDriver().waitForelementToBeClickable(DualApproval);
            Thread.sleep(3000);
            DualApproval.click();
            log_Info("Clicked on Dual Approval Tab");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(3000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Select Approval1  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(USER1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval1  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(USER2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Approver SubType  Drop down");
            getDriver().waitForelementToBeClickable(ApprovalSubType);
            Thread.sleep(7000);
            ApprovalSubType.sendKeys(SubType);
            log_Info("Clicked on Approver SubType  Drop down");


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);
        }
    }

    public ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1, String GmailCheck, String BatchNAME, String USER, String EMAIL) throws Exception {


        try {

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Gmail Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + GmailCheck + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Gmail Checkbox");


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);


            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(3000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");
            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(selectApprovalDrpDwn);
            selectApprovalDrpDwn.sendKeys(USER);
            Thread.sleep(3000);
            selectApprovalDrpDwn.sendKeys(Keys.ENTER);

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");
            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);

        }
    }


    public ILiglPage sendingCaseForDualApprovalEitherType(String Employee1, String GmailCheck, String GoogleDriveCheck, String DateRange1, String DateRange2, String Keywords1, String Keywords2, String BatchNAME, String EMAIL, String USER1, String USER2, String SubType) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Employee1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Gmail Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + GmailCheck + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Gmail Checkbox");

            log_Info("Click on Google Drive Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + GoogleDriveCheck + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Google Drive Checkbox");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Date Range1");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + DateRange1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Date Range1");

            log_Info("Click on Date Range2");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + DateRange2 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Date Range2");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Keyword 1");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Keywords1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Keyword 1");

            log_Info("Click on Keyword2");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Keywords2 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Keyword2");


            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");


            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");


            log_Info("Click on Dual Approval Tab");
            getDriver().waitForelementToBeClickable(DualApproval);
            Thread.sleep(3000);
            DualApproval.click();
            log_Info("Clicked on Dual Approval Tab");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(3000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Select Approval1  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(USER1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval1  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(USER2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Approver SubType  Drop down");
            getDriver().waitForelementToBeClickable(ApprovalSubType);
            Thread.sleep(3000);
            ApprovalSubType.sendKeys(SubType);
            ApprovalSubType.sendKeys(Keys.ENTER);
            log_Info("Clicked on Approver SubType  Drop down");


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForDualApprovalEitherType() Failed", ex);
        }
    }


    // Sending Case For Approval Single Approval Type

    public ILiglPage sendingCaseForApprovalAfterAddingScopeItems(String BatchNAME, String USER, String EMAIL) throws Exception {


        try {


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            Thread.sleep(3000);
            batchNameTxt.sendKeys(BatchNAME);

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            Thread.sleep(5000);
            templateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(3000);
            templateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");
            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(selectApprovalDrpDwn);
            selectApprovalDrpDwn.sendKeys(USER);
            Thread.sleep(3000);
            selectApprovalDrpDwn.sendKeys(Keys.ENTER);

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            Thread.sleep(3000);
            sendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");
            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed", ex);

        }
    }


    public ILiglPage clickOnSendForApprovalButton() throws Exception {


        try {

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            Thread.sleep(3000);
            sendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnSendForApprovalButton()  Failed", ex);

        }
    }

    public ILiglPage clickOnCustodianCheckBoxForApproval(String Emp1) throws Exception {


        try {

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + Emp1 + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnCustodianCheckBoxForApproval()  Failed", ex);

        }
    }


    public ILiglPage clickOnNextButtonForApproval() throws Exception {


        try {

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextButtonForApproval()  Failed", ex);

        }
    }

    public ILiglPage clickOnDataSourceCheckBoxForApproval(String DataSource1) throws Exception {


        try {

            log_Info("Click on The Required DataSource Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource1 + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Click on The Required DataSource Checkbox");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnNextButtonForApproval()  Failed", ex);

        }
    }

    // Date Ranges

    public ILiglPage clickOnDateRangesCheckBoxForApproval(String DateRange) throws Exception {


        try {

            log_Info("Click on The Required DateRange Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + DateRange + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on The Required DateRange Checkbox");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnDateRangesCheckBoxForApproval()  Failed", ex);

        }
    }

    //Keywords

    public ILiglPage clickOnKeywordsCheckBoxForApproval(String KeyWords) throws Exception {


        try {

            log_Info("Click on The Required Keywords Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[@title='" + KeyWords + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on The Required keywords Checkbox");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnKeywordsCheckBoxForApproval()  Failed", ex);

        }
    }

    public ILiglPage verifyProvidingCaseAccessToUsersInSecurityUsersDropdown(String Name) throws Exception {
        try {
            log_Info("verifyUnavailabilityOfInActiveUsersInSecurityUsersDropdown() Started");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EditBtn);
            log_Info("Scrolled down to View/Modify Permissions grid");
            UsersTab.click();
            log_Info("Clicked Users Tab");
            EditBtn.click();
            log_Info("Clicked Edit button");
            AddUserBtn.click();
            log_Info("Clicked AddUser button");

            Thread.sleep(10000);

            getDriver().waitUntilSpinnerIsClosed();

            getDriver().waitForelementToBeClickable(FullNameDropdown);
            Thread.sleep(5000);
            FullNameDropdown.click();
            Thread.sleep(5000);
            FullNameDropdownTypeText.sendKeys(Name);
            Thread.sleep(5000);
            FullNameDropdownTypeText.sendKeys(Keys.ENTER);


            log_Info("Entered Full name of User");
            AddBtn.click();
            log_Info("Clicked Add Button and Popup closed");
            Thread.sleep(5000);
            searchRequiredFullNameInUsersDropdown(Name);
            log_Info("Filtered Full name in Full name column in grid");
            Thread.sleep(5000);
            log_Info("Getting the Full name column data");
            String FName = FullNameColData.getText();
            Thread.sleep(3000);
            Assert.assertEquals(FName, Name);
            log_Info("User is successfully displaying in grid, Case Access is provided to user");
            log_Pass("verifyUnavailabilityOfInActiveUsersInSecurityUsersDropdown() completed successfully");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyUnavailabilityOfInActiveUsersInSecurityUsersDropdown() Failed", ex);
        }
    }

    public ILiglPage searchRequiredFullNameInUsersDropdown(String Fullname) throws Exception {
        try {
            log_Info("searchRequiredFullNameInUsersDropdown() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(FullNameCol).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            log_Info("Click On Full Name Menu");
            FullNameMenu.click();
            Thread.sleep(5000);
            log_Info("Clicked On Full Name Menu");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            log_Info("Enter Full name In The Search Bar");
            Searchbar.sendKeys(Fullname);
            Thread.sleep(5000);
            log_Info("Entered Full name In The Search Bar");
            log_Pass("searchRequiredFullNameInUsersDropdown() Completed");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredFullNameInUsersDropdown() Failed", ex);
        }
    }

    public ILiglPage searchRequiredApprovalBatchName(String AppBatchname) throws Exception {
        try {
            log_Info("searchRequiredApprovalBatchName() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(ApprovalBatchName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            log_Info("Click On Approval Batch Name Menu");
            AppBatchNameMenu.click();
            Thread.sleep(5000);
            log_Info("Clicked On Approval Batch Name Menu");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            log_Info("Enter Approval Batch name In The Search Bar");
            Searchbar.sendKeys(AppBatchname);
            Thread.sleep(5000);
            log_Info("Entered Approval Batch In The Search Bar");
            log_Pass("searchRequiredApprovalBatchName() Completed");
            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredApprovalBatchName() Failed", ex);
        }
    }

    public ILiglPage verifyColumnsDatainAdditionalScopeApprovalGrid(String ApprovalBatchNameExpected, String CustodiansCountExpected, String DatasourcesCountExpected, String KeywordsCountExpected, String DateRangesCountExpected, String ApprovalStatusColumnExpected, String ApprovalTypeExpected, String ApprovalUsersExpected, String ApprovedOrRejectedOnExpected) throws Exception {

        try {
            log_Info("Checking the Column names are displaying in Additional Scope Approval Grid in Security Page");

            String a = ApprovalBatchNameColData.getText();
            Assert.assertEquals(a, ApprovalBatchNameExpected);
            log_Info("ApprovalBatchName Column data is displaying as expected");
            Thread.sleep(2000);


            String b = CustodiansCountColData.getText();
            Assert.assertEquals(b, CustodiansCountExpected);
            log_Info("CustodiansCount Column data is displaying as expected");
            Thread.sleep(2000);

            String c = DatasourcesCountColData.getText();
            Assert.assertEquals(c, DatasourcesCountExpected);
            log_Info("DatasourcesCount Column data is displaying as expected");
            Thread.sleep(2000);

            String d = KeywordsCountColData.getText();
            Assert.assertEquals(d, KeywordsCountExpected);
            log_Info("ApprovalBatchName Column data is displaying as expected");
            Thread.sleep(2000);

            String e = DateRangesCountColData.getText();
            Assert.assertEquals(e, DateRangesCountExpected);
            log_Info("ApprovalBatchName Column data is displaying as expected");
            Thread.sleep(2000);

            String f = ApprovalStatusColumnData.getText();
            Assert.assertEquals(f, ApprovalStatusColumnExpected);
            log_Info("ApprovalStatus Column data is displaying as expected");
            Thread.sleep(2000);

            String g = ApprovalTypeColData.getText();
            Assert.assertEquals(g, ApprovalTypeExpected);
            log_Info("ApprovalType Column data is displaying as expected");
            Thread.sleep(2000);

            log_Info("Selecting 2 optional columns from choose columns");
            ChooseColumnsMenu.click();
            ChooseColumnsSearch.sendKeys("Approval Users");
            Thread.sleep(1000);
            ApprovalUsers.click();
            log_Info("Approval users column is selected and displaying in grid");
            ChooseColumnsSearch.clear();
            Thread.sleep(5000);

            ChooseColumnsSearch.sendKeys("Approved/Rejected On");
            Thread.sleep(1000);
            ApprovedOrRejectedOn.click();
            log_Info("Approved or Rejected On column is selected and displaying in grid");
            ChooseColumnsSearch.clear();
            ChooseColumnsMenu.click();
            Thread.sleep(5000);

            ApprovalBatchNameHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 7; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            Thread.sleep(3000);
            String h = ApprovalUsersColData.getText();
            Assert.assertEquals(h, ApprovalUsersExpected);
            log_Info("Approval users column data is displaying as expected in grid");
            Thread.sleep(3000);

            ApprovalUsersHeader.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 1; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            Thread.sleep(3000);
            String i = ApprovedOrRejectedOnColData.getText();
            Assert.assertEquals(i, ApprovedOrRejectedOnExpected);
            log_Info("Approved or Rejected By Column data is displaying as expected");

            log_Pass("verifyColumnsDatainAdditionalScopeApprovalGrid() validated successfully");

            return new SecurityPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsDatainAdditionalScopeApprovalGrid()", ex);
        }
    }

    /**
     * Method to Check Approval History of Case in Approval History grid in Security Page
     *
     * @param Username
     * @param Status
     * @return
     * @throws Exception
     */
    public ILiglPage approvalHistoryCheck(String Username, String Status) throws Exception {
        try {
            log_Info("approvalHistoryCheck() Started");
            Thread.sleep(3000);
            String username = ApprovalUserName.getText();
            String newUsrName = Username.replace(" ", "");
            Assert.assertEquals(username, newUsrName);
            log_Info("User Name Updated Properly");
            Thread.sleep(2000);
            String status = ApprovalStatus.getText();
            Assert.assertEquals(status, Status);
            log_Info("Approval Status is Updated to '" + status + "' successfully");

            return new SecurityPage();
        } catch (Exception ex) {
            log_Error("approvalHistoryCheck() Failed");
            throw new Exception("Exception in approvalHistoryCheck()", ex);
        }
    }

    public ILiglPage selectRecordInApprovalRequestsGrid(String approvalrecord) throws Exception {
        try {
            log_Info("selectRecordInApprovalRequestsGrid() Started");
            /*getDriver().waitForelementToBeClickable(Name);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(Name).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);*/

            /*Menu.click();

            Thread.sleep(5000);
            log_Info("Menu clicked");
            log_Info("Click on Filter");
            Thread.sleep(5000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(5000);
            log_Info("Enter Employee");
            Searchbar.sendKeys("QA_24cases11-BTH_11");
            Thread.sleep(5000);

            log_Info("Select Case To Be Approve");*/
            getCurrentDriver().findElement(By.linkText(approvalrecord)).click();
            return new ApprovalPage();
        } catch (Exception ex) {
            log_Error("selectRecordInApprovalRequestsGrid Failed");
            throw new Exception("Exception in selectRecordInApprovalRequestsGrid()", ex);
        }
    }

    public ILiglPage approveCase(String action) throws Exception {
        try {
            log_Info("caseApproval() Started");
            Thread.sleep(15000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", ApproveBtn);
            getCurrentDriver().findElement(By.id("appr-" + action + "-btn")).click();
            SaveBtn.click();
            Thread.sleep(5000);
            return new ApprovalPage();
        } catch (Exception ex) {
            throw new Exception("Exception in caseApproval()", ex);
        }
    }

    /**
     * Method to Revoke the Case which is in Pending Approval Status
     *
     * @return
     * @throws Exception
     */
    public ILiglPage revokeCase() throws Exception {
        try {
            log_Info("revokeCase() Started");
            RevokeBtn.click();
            waitForPageToLoad();
            Thread.sleep(2000);
            log_Pass("Case Approval Revoked");
            return new SecurityPage();
        } catch (Exception ex) {
            log_Error("revokeCase() Failed");
            throw new Exception("Exception in revokeCase()", ex);
        }
    }

    public ILiglPage sendRejectedCaseApproval() throws Exception {
        try {
            log_Info("Click send for Approval Button");
            sendApprovalBtn.click();
            log_Pass("Send Approval btn Clicked");
            log_Info("Click send for Approval Button");
            sendForApprovalBtn.click();
            log_Pass("Case Sent for Approval");
            return new SecurityPage();
        } catch (Exception ex) {
            throw new Exception("Exception From sendCaseForApproval()", ex);
        }
    }

    /************************************************************************************************************/

    public ILiglPage sendAllForCaseApproval(String batchName, String emailTemp, String approverName) throws Exception {
        try {
            wait(5);
            JavascriptExecutor js = (JavascriptExecutor) getCurrentDriver();
            js.executeScript("window.scrollBy(0,-500)");
            wait(5);
            getSession().log_Info("Send All Custodians, Data Sources, Date Ranges and Keywords For Case Approval");
            //Approval button
            getSession().log_Info("Click on 'Send For Approval' Button in Security Page");
            getDriver().waitForelementToBeClickable(sendForApprovalBtn);
            sendForApprovalBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Send For Approval' Button in Security Page");

            /*Custodians
            getDriver().waitForelementToBeClickable(allCustodiansChkBox);
            if (allCustodiansChkBox.isEnabled()) {
                getSession().log_Info("Select the All Custodians");
                allCustodiansChkBox.click();
                getSession().log_Pass("Selected All Custodians");
            }

            //Data Sources
            getSession().log_Info("Navigate to Data Sources");
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'Project Data Sources')]")).click();
            wait(1);
            getSession().log_Pass("Navigated to Data Sources");

            if (allDataSourcesChkBox.isEnabled()) {
                getSession().log_Info("Select the All Data Sources");
                allDataSourcesChkBox.click();
                getSession().log_Pass("Selected All Data Sources");
            } else {

                //Date Ranges
                getSession().log_Info("Navigate to Date Ranges");
                getCurrentDriver().findElement(By.xpath("//div[contains(text(),'Project Date Ranges')]")).click();
                wait(1);
                getSession().log_Pass("Navigated to Date Ranges");
            }

            getDriver().waitForelementToBeClickable(allDataRangesChkBox);
            if (allDataRangesChkBox.isEnabled()) {
                getSession().log_Info("Select the All Date Ranges");
                allDataRangesChkBox.click();
                getSession().log_Pass("All Date Ranges Selected");
            }

            //Keywords
            getSession().log_Info("Navigate to Keywords");
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'Project Keywords')]")).click();
            wait(1);
            getSession().log_Pass("Navigated to Keywords");

            getDriver().waitForelementToBeClickable(allKeywordsChkBox);
            if (allKeywordsChkBox.isEnabled()) {
                getSession().log_Info("Select the All Keywords");
                allKeywordsChkBox.click();
                getSession().log_Pass("All Keywords Selected");
            }*/

            //Request Approval
            getSession().log_Info("Navigate to Request Approval");
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'Request Approval')]")).click();
            wait(1);
            getSession().log_Pass("Navigated to Request Approval");

            //Batch Name
            getSession().log_Info("Enter 'Batch Name'");
            getDriver().waitForelementToBeClickable(batchNameTxt);
            batchNameTxt.sendKeys(batchName);
            getSession().log_Pass("'Batch Name' Entered");

            //Select Email Template
            getSession().log_Info("Select Email Template");
            wait(1);
            getDriver().waitForelementToBeClickable(templateNameDrpDwn);
            templateNameDrpDwn.sendKeys(Keys.ENTER, emailTemp, Keys.ENTER);
            getSession().log_Pass("Email Template Selected");

            //Select Approver
            getSession().log_Info("Select Approver");
            getDriver().waitForelementToBeClickable(selectApprovalDrpDwn);
            selectApprovalDrpDwn.click();
            wait(1);
            approverNameTxt.sendKeys(approverName);
            wait(1);
            getDriver().customXpathBasedOnTextValue(approverName).click();
            getSession().log_Pass("Approver Selected");

            //Send Approval Btn
            getSession().log_Info("Click on 'Send Approval' Button");
            getDriver().waitForelementToBeClickable(sendApprovalBtn);
            sendApprovalBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked on 'Send Approval' Button");


            return new SecurityPage();
        } catch (Exception exception) {
            log_Error(exception.getMessage());
            throw new Exception("Sending Custodians, Data Sources, Date Ranges and Keywords For Case Approval Failed", exception);
        }
    }
}
