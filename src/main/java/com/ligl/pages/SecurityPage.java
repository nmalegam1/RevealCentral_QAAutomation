package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.casemanagement.CaseDataSourcesPage;
import com.ligl.pages.casemanagement.CaseOtherPartyPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SecurityPage extends LiglBaseSessionPage {

    // Verifying Approving Rejected Test Cases WebElements

    @FindBy(xpath = "//span[contains(text(),' Rejected ')]")
    WebElement ApprovalStatus;

    @FindBy(xpath = "//span[contains(text(),'Approved')]")
    WebElement ApprovedStatus;

    @FindBy(id= "btn-send-for-approval")
    WebElement SendForApprovalBtn;

    @FindBy(id = "send-approval-btn")
    WebElement SendApprovalBtn;

    @FindBy(xpath = "//span[contains(text(),' Pending Approval ')]")
    WebElement PendingStatus;

    @FindBy(xpath = "//span[contains(text(),'Not Initiated')] ")
    WebElement NotInitiatedStatus;

    @FindBy(xpath = "//div[contains(text(),'Request Approval')]")
    WebElement RATab;

    @FindBy (id = "input-case-name")
    WebElement BatchName;

    @FindBy(id = "select-approver")
    WebElement SelectApprovalDrpDwn;

    @FindBy(id = "template-name")
    WebElement TemplateNameDrpDwn;

    @FindBy(id = "dual-opt")
    WebElement DualApproval;

    @FindBy(xpath = "//mat-select[@id='select-approver']/ancestor::div[@class='form-group']//span[contains(text(),'Select Approver 1')]//..//mat-select[@id='select-approver'] ")
    WebElement SelectorApprover1;

    @FindBy(xpath = "//mat-select[@id='select-approver']/ancestor::div[@class='form-group']//span[contains(text(),'Select Approver 2')]//..//mat-select[@id='select-approver'] ")
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

    @FindBy(xpath = "//div[text()='Gmail(Not-initiated)']//../..//div[@class='sourceChkbxDiv']")
    WebElement GmailCheckBox;

    @FindBy(xpath = "//div[text()='Google Drive(Not-initiated)']//../..//div[@class='sourceChkbxDiv']")
    WebElement GoogleDriveCheckBox;




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
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForApproval() Failed",ex);
        }
    }

    public ILiglPage verifyingApproveStatus() throws Exception {

        try {

            // validating the case Status In Approved state

            log_Info("Check The Status Of Case , It Should Be In Approved State");
            boolean a3 = ApprovedStatus.isDisplayed();
            System.out.println(a3);
            Thread.sleep(3000);
            Assert.assertEquals(true, a3);
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("verifyingApproveStatus() Failed",ex);
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


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateCaseNotinitiatedState() Failed",ex);
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


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateCasePendingForApprovalState() Failed",ex);
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


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateCasePendingForApprovalState() Failed",ex);
        }
    }

    // Verify The Functionality Of Approving Case (Without Selecting Scope Items) By Selecting Single Approval Type

    public ILiglPage sendingCaseForSingleApproval(String BatchNAME,String USER,String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(BatchName);
            Thread.sleep(3000);
            BatchName.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(SelectApprovalDrpDwn);
            Thread.sleep(3000);
            SelectApprovalDrpDwn.sendKeys(USER);
            SelectApprovalDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(TemplateNameDrpDwn);
            Thread.sleep(5000);
            TemplateNameDrpDwn.sendKeys(EMAIL);
            TemplateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed",ex);
        }
    }


    public ILiglPage sendingCaseCustodianForApproval(String Employee1,String BatchNAME,String USER,String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee1+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(BatchName);
            Thread.sleep(3000);
            BatchName.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(SelectApprovalDrpDwn);
            Thread.sleep(3000);
            SelectApprovalDrpDwn.sendKeys(USER);
            SelectApprovalDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(TemplateNameDrpDwn);
            Thread.sleep(5000);
            TemplateNameDrpDwn.sendKeys(EMAIL);
            TemplateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed",ex);
        }
    }

    // Verify The Case Status When Dual Approval Is Selected And Both Approved The Status

    public ILiglPage sendingCaseForDualApproval(String BatchNAME,String USER1,String USER2,String EMAIL,String Employee1,String SubType) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee1+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(BatchName);
            Thread.sleep(3000);
            BatchName.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Dual Approval Tab");
            getDriver().waitForelementToBeClickable(DualApproval);
            Thread.sleep(3000);
            DualApproval.click();
            log_Info("Clicked on Dual Approval Tab");

            log_Info("Click on Select Approval1  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(USER1);
            SelectorApprover1.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval1  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(USER2);
            SelectorApprover2.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(ApprovalSubType);
            Thread.sleep(3000);
            ApprovalSubType.sendKeys(SubType);
            ApprovalSubType.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(TemplateNameDrpDwn);
            Thread.sleep(5000);
            TemplateNameDrpDwn.sendKeys(EMAIL);
            TemplateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed",ex);
        }
    }

                // Verify The Approval History Of The Case By Assigned Approvals

    public ILiglPage verifyApprovalHistoryStatus(String AssignedUser1,String Status1,String AssignedUser2,String Status2) throws Exception {

        try {


            log_Info("Check The Assigned UserName");
            Thread.sleep(3000);
            String s1 = AssignedUserName.getText();
            Assert.assertEquals(s1,AssignedUser1);
            log_Info("Checked The Assigned UserName");

            log_Info("Check The Assigned UserName Status");
            Thread.sleep(3000);
            String  s2 = StatusOfUser.getText();
            Assert.assertEquals(s2,Status1);
            log_Info("Checked The Assigned UserName Status");

            log_Info("Check The Assigned UserName");
            Thread.sleep(3000);
            String s3 = AssignedUserName1.getText();
            Assert.assertEquals(s3,AssignedUser2);
            log_Info("Checked The Assigned UserName");

            log_Info("Check The Assigned UserName Status");
            Thread.sleep(3000);
            String  s4 = StatusOfUser1.getText();
            Assert.assertEquals(s4,Status2);
            log_Info("Checked The Assigned UserName Status");
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("verifyApprovalHistoryStatus() Failed",ex);
        }

    }


    // Verify The Case Status When Dual Approval Is Selected - Linear Type

    public ILiglPage sendingCaseForDualApprovalLinearType(String Employee1,String GmailCheck,String GoogleDriveCheck,String BatchNAME,String USER1,String USER2,String SubType,String EMAIL) throws Exception {

        try {


            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");

            log_Info("Click on Custodian Check Box");
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee1+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Clicked on Custodian Check Box");

            log_Info("Click on Next Button");
            getDriver().waitForelementToBeClickable(NextBtn);
            Thread.sleep(5000);
            NextBtn.click();
            log_Info("Clicked on Next Button");

            log_Info("Click on Gmail Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='"+GmailCheck+"']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Gmail Checkbox");

            log_Info("Click on Google Drive Checkbox");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//div[text()='"+GoogleDriveCheck+"']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on Google Drive Checkbox");


            log_Info("Click on Request For Approval Tab");
            getDriver().waitForelementToBeClickable(RATab);
            Thread.sleep(3000);
            RATab.click();
            log_Info("Clicked on Request For Approval Tab");

            log_Info("Click on Batch Name");
            getDriver().waitForelementToBeClickable(BatchName);
            Thread.sleep(3000);
            BatchName.sendKeys(BatchNAME);
            log_Info("Clicked on Batch Name");

            log_Info("Click on Dual Approval Tab");
            getDriver().waitForelementToBeClickable(DualApproval);
            Thread.sleep(3000);
            DualApproval.click();
            log_Info("Clicked on Dual Approval Tab");

            log_Info("Click on Select Approval1  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover1);
            Thread.sleep(3000);
            SelectorApprover1.sendKeys(USER1);
            SelectorApprover1.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval1  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(SelectorApprover2);
            Thread.sleep(3000);
            SelectorApprover2.sendKeys(USER2);
            SelectorApprover2.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Select Approval2  Drop down");
            getDriver().waitForelementToBeClickable(ApprovalSubType);
            Thread.sleep(3000);
            ApprovalSubType.sendKeys(SubType);
            ApprovalSubType.sendKeys(Keys.ENTER);
            log_Info("Clicked on Select Approval2  Drop down");

            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(TemplateNameDrpDwn);
            Thread.sleep(5000);
            TemplateNameDrpDwn.sendKeys(EMAIL);
            TemplateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
            log_Info("Clicked on Send For Approval Button");


            log_Info("Check The Status Of Case , It Should Be In Pending State");
            boolean a2 = PendingStatus.isDisplayed();
            System.out.println(a2);
            Thread.sleep(3000);
            Assert.assertEquals(true, a2);
            return new SecurityPage();


        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("sendingCaseForSingleApproval() Failed",ex);
        }
    }

    public ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1,String GmailCheck,String BatchNAME,String USER ,String EMAIL) throws Exception {


        try {

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendForApprovalBtn);
            Thread.sleep(3000);
            SendForApprovalBtn.click();
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
            getDriver().waitForelementToBeClickable(BatchName);
            Thread.sleep(3000);
            BatchName.sendKeys(BatchNAME);


            log_Info("Click on Email Template Drop down");
            getDriver().waitForelementToBeClickable(TemplateNameDrpDwn);
            Thread.sleep(5000);
            TemplateNameDrpDwn.sendKeys(EMAIL);
            Thread.sleep(3000);
            TemplateNameDrpDwn.sendKeys(Keys.ENTER);
            log_Info("Clicked on Email Template Drop down");
            log_Info("Click on Select Approval  Drop down");
            getDriver().waitForelementToBeClickable(SelectApprovalDrpDwn);
            SelectApprovalDrpDwn.sendKeys(USER);
            Thread.sleep(3000);
            SelectApprovalDrpDwn.sendKeys(Keys.ENTER);

            log_Info("Click on Send For Approval Button");
            getDriver().waitForelementToBeClickable(SendApprovalBtn);
            Thread.sleep(3000);
            SendApprovalBtn.click();
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
}
