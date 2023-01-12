package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

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
            CaseType.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked On Case Type Drop Down");

            log_Info("Click On Case Name");
            Thread.sleep(5000);
            CaseName.clear();
            CaseName.sendKeys(CaseName1);
            getSession().log_Pass("Clicked On Case Name");

            log_Info("Click On Case Type Drop Down");
            Thread.sleep(5000);
            CST.sendKeys(CaseSettingTemplateDrpDwn);
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
}
