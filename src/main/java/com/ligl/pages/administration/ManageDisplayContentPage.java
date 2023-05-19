package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ManageDisplayContentPage extends LiglBaseSessionPage {

    @FindBy(id = "select-email-template-categorymanagetemplatecategory")
    public WebElement manageContentCategoryDrpDwn;

    @FindBy(id = "select-email-templatemanagetemplate")
    public WebElement manageContentTemplateDrpDwn;

    public ILiglPage selectManageContentCategoryDropDown(String manageContentCategory) throws Exception {
        try {
            getDriver().waitForelementToBeClickable(manageContentCategoryDrpDwn);
            getSession().log_Info("Select the 'Manage Content Category' in Manage Content Category DropDown");
            manageContentCategoryDrpDwn.sendKeys(manageContentCategory);
            wait(1);
            manageContentCategoryDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Manage Content Category' Selected in Manage Content Category DropDown");
            wait(1);
            return new ManageDisplayContentPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("select Manage Content Category DropDown Failed", ex);
        }
    }

    public ILiglPage selectManageContentTemplateDropDown(String manageContentTemplate) throws Exception {
        try {
            getSession().log_Info("Select the 'Manage Content Template' in Manage Content Template DropDown");
            getDriver().waitForelementToBeClickable(manageContentTemplateDrpDwn);
            manageContentTemplateDrpDwn.sendKeys(manageContentTemplate);
            wait(1);
            manageContentTemplateDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("'Manage Content Template' Selected in Manage Content Template DropDown");
            wait(1);
            return new ManageDisplayContentPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("select Manage Content Template DropDown Failed", ex);
        }
    }


    public ILiglPage verifyTheParametersInManageDisplayContent(String manageContentCategory,
                                                               String parameter1, String parameter2) throws Exception {
        try {
            selectManageContentCategoryDropDown(manageContentCategory);
            getSession().log_Info("Verify that Parameters In Selected Manage Display Content " + manageContentCategory);
            boolean p = getCurrentDriver().findElement(By.xpath("//li[contains(text(),'" + parameter1 + "')]")).isDisplayed();
            boolean p1 = getCurrentDriver().findElement(By.xpath("//li[contains(text(),'" + parameter2 + "')]")).isDisplayed();
            getSession().log_Pass("Parameters are displaying In Selected Manage Display Content " + p + " and " + p1);

            return new ManageDisplayContentPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifying The Parameters In Manage Display Content Failed", ex);
        }
    }
}
