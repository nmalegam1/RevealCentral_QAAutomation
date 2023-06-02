package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.DashboardPage;
import com.ligl.pages.GlobalRequestPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.List;

public class CaseSummaryPage extends LiglBaseSessionPage {

    @FindBy(id = "btn-edit")
    WebElement EditBtn;

    @FindBy(id = "select-statusstatus")
    WebElement StatusDrpDwn;

    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement SaveBtn;

    @FindBy(xpath = "//label[contains(text(),'Status')]")
    WebElement StatusName;

    @FindBy(id = "sel-matter-type")
    WebElement CaseType;

    @FindBy(id = "input-case-name")
    WebElement CaseName;

    @FindBy(id = "select-optimum-setting")
    WebElement CST;

    @FindBy(xpath = "//span[contains(text(),'Bankruptcy')]")
    WebElement CaseTypeName;

    @FindBy(id = "btn-update-cancel")
    WebElement CancelBtn;

    @FindBy(xpath = "//button[contains(text(),'Yes')]")
    WebElement YesBtn;

    @FindBy(xpath = "//span//div[@class='case-name-div']")
    WebElement CaseNameValidation;
    @FindBy(id = "btn-edit")
    WebElement EditCase;
    @FindBy(id = "input-due-date")
    WebElement DueDate;
    @FindBy(xpath = "//button[contains(text(),'Save')]")
    WebElement EditSave;
    @FindBy(id = "input-dynamic-column-1")
    WebElement CostCentre;
    @FindBy(id = "input-dynamic-column-2")
    WebElement CaseAlias;
    @FindBy(id = "select-dynamic-column-3")
    WebElement AddDropDown;
    @FindBy(id = "btn-custom")
    WebElement MoreBtn;
    @FindBy(id = "btn-more")
    WebElement MoreBtnCS;
    @FindBy(xpath = "//div[@id='select-workflow-template-panel']//input[@type='text']")
    WebElement WFTText;
    @FindBy(id = "select-workflow-template")
    WebElement WFT;

    @FindBy(xpath = "//span[contains(text(),'Security')]")
    WebElement SecurityLink;

    @FindBy(xpath = "//*[@id='input-dynamic-column-4']/label/span[1]/input")
    WebElement inplace_checkbox1;

    @FindBy(id="sel-role-type")
    WebElement RoleType;

    /**
     * Method to Check the Additional Fields are Editable
     *
     * @param costCentre
     * @param caseAlias
     * @param drpDownVal
     * @return
     * @throws Exception
     */
    public ILiglPage editAdditionalFields(String costCentre, String caseAlias, String drpDownVal) throws Exception {
        try {
            log_Info("editAdditionalFields() Started");
            EditCase.click();
            MoreBtn.click();
            Thread.sleep(3000);
            CostCentre.clear();
            CostCentre.sendKeys(costCentre);
            Thread.sleep(3000);
            CaseAlias.clear();
            CaseAlias.sendKeys(caseAlias);
            Thread.sleep(3000);
            /*AddDropDown.click();
            Thread.sleep(2000);
            AddDropDown.sendKeys(drpDownVal);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+drpDownVal+"')]")).click();*/

            AddDropDown.click();
            Thread.sleep(5000);
            AddDropDown.sendKeys(Keys.ENTER);

            Thread.sleep(3000);
            log_Info("Click Save Button");
            EditSave.click();
            log_Pass("Save button Clicked");
            Thread.sleep(5000);
            MoreBtnCS.click();
            String newCostCentre = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + costCentre + "')]")).getText();
            Assert.assertEquals(newCostCentre, costCentre);
            log_Pass("Work Flow Template Edited Successfully");
            String newCaseAlias = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + caseAlias + "')]")).getText();
            Assert.assertEquals(newCaseAlias, caseAlias);
            log_Pass("Work Flow Template Edited Successfully");
            Thread.sleep(3000);
            ///String newAddDPVal=getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+drpDownVal+"')]")).getText();
            //Assert.assertEquals(newAddDPVal,drpDownVal);
            //log_Pass("Work Flow Template Edited Successfully");
            return new CaseSummaryPage();
        } catch (Exception ex) {
            log_Error("editAdditionalFields() Failed");
            throw new Exception("Exception in editAdditionalFields()");
        }
    }

    /**
     * Method to check the edit of WFT irrespective of Case Approval Status
     *
     * @param wft
     * @return
     * @throws Exception
     */
    public ILiglPage editWFT(String wft) throws Exception {
        try {
            log_Info("editWFT() Started");
            EditCase.click();
            log_Info("Enter Work Flow Template");
            getDriver().waitForelementToBeClickable(WFT);
            WFT.click();
            Thread.sleep(3000);
            WFTText.sendKeys(wft);
            Thread.sleep(3000);
            WFTText.sendKeys(Keys.ENTER);
            log_Info("Click Save Button");
            SaveBtn.click();
            Thread.sleep(8000);
            log_Pass("Save button Clicked");
            String WorkFlowTemp = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + wft + "')]")).getText();
            Assert.assertEquals(WorkFlowTemp, wft);
            log_Pass("Work Flow Template Edited Successfully");
            return new CaseSummaryPage();
        } catch (Exception ex) {
            throw new Exception("Exception in editWFT()", ex);
        }
    }

    /**
     * Method to Check Due Date Field IsOptional in Edit case
     *
     * @return CaseSummaryPage()
     * @throws Exception
     */
    public ILiglPage editDueDate(String dueDate) throws Exception {
        try {
            log_Info("editDueDate() Started");
            Thread.sleep(3000);
            EditCase.click();
            String dueDateNew = dueDate.replace("-", "");
            DueDate.sendKeys(dueDateNew);
            //getCurrentDriver().findElement(By.cssSelector("button[aria-label='"+dueDateNew+"']")).click();
            DueDate.clear();
            SaveBtn.click();
            log_Pass("Case Created and Edited With out filling DueDate Field");
            return new CaseSummaryPage();
        } catch (Exception ex) {
            throw new Exception("editDueDate() id Failed", ex);
        }
    }


    public ILiglPage verifyingTheStatusDropDownForACase(String StatusDropDown1) throws Exception {

        try {

            log_Info("Click On Edit Button");
            getDriver().waitForelementToBeClickable(EditBtn);
            Thread.sleep(5000);
            EditBtn.click();
            log_Info("Click On Edit Button");


            log_Info("Click On Status Drop Down");
            Thread.sleep(5000);
            StatusDrpDwn.sendKeys(StatusDropDown1);
            Thread.sleep(5000);
            StatusDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Status Drop Down");


            log_Info("Click On Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked On Save Button");
            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingTheStatusDropDownForACase() Failed", ex);
        }
    }

    // Validating The Case Status After Modifying Status

    public ILiglPage validatingUpdatedStatus(String StatusDropDown1) throws Exception {

        try {
            log_Info("Check The Availability Of Status");
            boolean a1 = StatusName.isDisplayed();
            boolean a2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + StatusDropDown1 + "')]")).isDisplayed();
            System.out.println(a1);
            System.out.println(a2);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            return new CaseSummaryPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validatingUpdatedStatus() Failed", ex);
        }
    }

    // Validating The Case Name, Case Type , Case Setting Template are In Editable When Case Is In Non-Approved state

    public ILiglPage verifyingCaseFieldsAreEditable(String CaseTypeDrpDwn, String CaseName1, String CaseSettingTemplateDrpDwn) throws Exception {

        try {

            log_Info("Click On Edit Button");
            getDriver().waitForelementToBeClickable(EditBtn);
            Thread.sleep(5000);
            EditBtn.click();
            log_Info("Click On Edit Button");


            log_Info("Click On Case Type Drop Down");
            Thread.sleep(5000);
            CaseType.sendKeys(CaseTypeDrpDwn);
            Thread.sleep(5000);
            CaseType.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Case Type Drop Down");

            log_Info("Click On Case Name");
            Thread.sleep(5000);
            CaseName.clear();
            Thread.sleep(5000);
            CaseName.sendKeys(CaseName1);
            getSession().log_Pass("Clicked On Case Name");

            log_Info("Click On Case Type Drop Down");
            Thread.sleep(5000);
            CST.sendKeys(CaseSettingTemplateDrpDwn);
            Thread.sleep(5000);
            CST.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Case Type Drop Down");


            log_Info("Click On Save Button");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked On Save Button");
            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingCaseFieldsAreEditable() Failed", ex);
        }
    }

    // Verifying The Case Fields Are Edited When Case Is In Non-Approved State

    public ILiglPage verifyingCaseFieldsAreEdited(String CaseTypeDrpDwn, String CaseName1, String CaseSettingTemplateDrpDwn) throws Exception {

        try {
            log_Info("Check The Case Details Are Edited");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseTypeDrpDwn + "')]")).isDisplayed();
            boolean a2 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseName1 + "')]")).isDisplayed();
            boolean a3 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseSettingTemplateDrpDwn + "')]")).isDisplayed();
            System.out.println(a1);
            System.out.println(a2);
            System.out.println(a3);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, a3);
            return new CaseSummaryPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingCaseFieldsAreEdited() Failed", ex);
        }
    }

    // Validating The Case Name, Case Type , Case Setting Template are In Non-Editable When Case Is In Approved state

    public ILiglPage verifyingCaseFieldsAreNonEditable() throws Exception {

        try {

            log_Info("Click On Edit Button");
            getDriver().waitForelementToBeClickable(EditBtn);
            Thread.sleep(5000);
            EditBtn.click();
            log_Info("Click On Edit Button");

            log_Info("Check The Case Details Are In Non-Editable Mode");
            WebElement CaseName_Edit = getCurrentDriver().findElement(By.xpath("//input[@id='input-case-name']/ancestor::div/mat-form-field"));
            String classes = CaseName_Edit.getAttribute("class");
            boolean isDisabled = classes.contains("mat-form-field-disabled");
            System.out.println(isDisabled);
            Assert.assertEquals(true, isDisabled);

            WebElement CaseType_Edit = getCurrentDriver().findElement(By.id("sel-matter-type"));
            String classes1 = CaseType_Edit.getAttribute("class");
            boolean isDisabledd = classes1.contains("mat-form-field-disabled");
            System.out.println(isDisabledd);
            Assert.assertEquals(true, isDisabledd);

            WebElement CST_Edit = getCurrentDriver().findElement(By.id("select-optimum-setting"));
            String classes2 = CST_Edit.getAttribute("class");
            boolean isDisableddd = classes2.contains("mat-form-field-disabled");
            System.out.println(isDisableddd);
            Assert.assertEquals(true, isDisableddd);
            return new CaseSummaryPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingCaseFieldsAreNonEditable() Failed", ex);
        }
    }

    public ILiglPage verifyingEditBtn() throws Exception {

        try {
            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", EditBtn);
            log_Info("Click On Edit Button");
            getDriver().waitForelementToBeClickable(EditBtn);
            Thread.sleep(5000);
            EditBtn.click();
            log_Info("Clicked On Edit Button");

            log_Info("Click On Cancel Button");
            getDriver().waitForelementToBeClickable(CancelBtn);
            Thread.sleep(5000);
            CancelBtn.click();
            log_Info("Clicked On Cancel Button ");

            log_Info("Click On Yes Button");
            getDriver().waitForelementToBeClickable(YesBtn);
            Thread.sleep(5000);
            YesBtn.click();
            log_Info("Clicked On Yes Button ");
            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingEditBtn() Failed", ex);
        }
    }

    public ILiglPage validateCreatedCase(String CaseName) throws Exception {
        try {
            String casename = CaseNameValidation.getText();
            Assert.assertEquals(CaseName, casename);
            return new CaseSummaryPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateCreatedCase() Failed", ex);
        }
    }

    public ILiglPage validateTheNavigateToDashBoardPageURL(String PageTitle) throws Exception {

        try {

            getDriver().waitForAngularRequestsToComplete();

            log_Info("validateTheNavigateToDashBoardPageURL Started");


            if (getCurrentDriver().getCurrentUrl().contains(PageTitle)) {
                log_Info("Naviagated To "+PageTitle+"Page");
            }
            else {

                throw new Exception("Required Page Not Loaded");
            }
            return  new DashboardPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheNavigateToDashBoardPageURL() Failed ", ex);
        }
    }















    //verifying unavailability of Security tab for Non-legal user & Non-legal reviewer
    public ILiglPage verifyUnavailabilityOfSecurityTabInLeftMenu() throws Exception {

        try {
            Thread.sleep(5000);
            try {
                log_Info("Started checking unavailability of Security tab in Left Menu for NLU/NLR");
                getLeftMenu();
                boolean a = SecurityLink.isDisplayed();
                System.out.println(a);
                if (a == true) {
                    log_Error("Security tab is displaying");
                }
            } catch (Exception ex) {
                log_Info("Security tab is not displaying");
            }
            Thread.sleep(5000);
            return new CaseCounselPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateUnavailabilityOfCreateAndEditOfEmployeeFromCustodiansPage() Failed", ex);
        }
    }


    public ILiglPage caseEditInplaceisSelected() throws Exception {

        try {

            EditBtn.click();
            Thread.sleep(2000);
            MoreBtn.click();

            log_Info("check for inplace preservation check box selected or not");
            boolean a1 = inplace_checkbox1.isSelected();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(true, a1);
            log_Info("inplace preservation check box selected for approved case");
            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("caseEditInplaceisSelected() Failed", ex);
        }

    }

    public ILiglPage caseEditInplace() throws Exception {

        try {

            EditBtn.click();
            Thread.sleep(2000);
            MoreBtn.click();

            log_Info("check for inplace preservation check box disabled or not");
            boolean a1 = inplace_checkbox1.isEnabled();
            Thread.sleep(5000);
            System.out.println(a1);
            Thread.sleep(5000);
            Assert.assertEquals(false, a1);
            log_Info("inplace preservation check box disabled for approved case");
            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("caseEditInplace() Failed", ex);
        }
    }

    public ILiglPage verifyingCaseRoleIsNonEditable() throws Exception {

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", EditBtn);

            log_Info("Click On Edit Button");
            getDriver().waitForelementToBeClickable(EditBtn);
            Thread.sleep(5000);
            EditBtn.click();
            log_Info("Click On Edit Button");

            log_Info("Check The Case Role Type is In Non-Editable Mode");
            WebElement CaseName_Edit = getCurrentDriver().findElement(By.id("sel-role-type"));
            String classes = CaseName_Edit.getAttribute("class");
            boolean isDisabled = classes.contains("mat-form-field-disabled");
            System.out.println(isDisabled);
            Assert.assertEquals(true, isDisabled);

            return new CaseSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyingCaseRoleIsNonEditable() Failed", ex);
        }
    }

    /*************************************************Data Base********************************************************************/
    //Get All Case Fields Data in Case Management Summary Page
    public ILiglPage getCaseFieldsDataInCaseSummaryPage() throws Exception {
        try {
            List<WebElement> listItem = getCurrentDriver().findElements(By.xpath("//div[@class='row my-3']//section//span"));
            String[] caseSummary = new String[listItem.size()];
            for (int i = 0; i < listItem.size(); i++) {
                String caseDetails = getCurrentDriver().findElement(By.xpath("//div[@class='row my-3']//section[" + (i + 1) + "]//span")).getText();
                caseSummary[i] = caseDetails;
            }
            for (String listItem1 : caseSummary) {
                System.out.println(listItem1);
                for (int i = 0; i < listItem.size(); i++) {
                    getSession().setRegressionData("get_Case_Role", caseSummary[0]);
                    getSession().setRegressionData("get_Case_Name", caseSummary[1]);
                    getSession().setRegressionData("get_Case_Prefix", caseSummary[2]);
                    getSession().setRegressionData("get_Case_CreatedDate", caseSummary[3]);
                    getSession().setRegressionData("get_Case_CreatedBy", caseSummary[4]);
                    getSession().setRegressionData("get_Case_DueDate", caseSummary[5]);
                    getSession().setRegressionData("get_Case_Status", caseSummary[6]);
                    getSession().setRegressionData("get_Case_DocketNumber", caseSummary[7]);
                    getSession().setRegressionData("get_Case_Priority", caseSummary[8]);
                    getSession().setRegressionData("get_Case_Type", caseSummary[9]);
                    getSession().setRegressionData("get_Case_WorkflowTemplate", caseSummary[10]);
                    getSession().setRegressionData("get_Case_Entity", caseSummary[11]);
                    getSession().setRegressionData("get_Case_Region", caseSummary[12]);
                    getSession().setRegressionData("get_Case_SettingsTemplate", caseSummary[13]);
                    getSession().setRegressionData("get_Case_CreatedByNonLegalUser", caseSummary[14]);
                }
            }
            return new CaseSummaryPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Getting the Case Fields Data in Case Management Summary Page Failed", ex);
        }
    }
}
