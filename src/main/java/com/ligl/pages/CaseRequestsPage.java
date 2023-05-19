package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseRequestsPage extends LiglBaseSessionPage {


    @FindBy(id = "req-add-request-btn")
    public WebElement requestBtn;

    @FindBy(xpath = "//mat-select[@id='case']")
    WebElement ChooseACASE;


    public ILiglPage clickOnAddRequestButtonInCaseRequests() throws Exception {

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", requestBtn);

            getSession().log_Info("Click On Add Request Button");
            getDriver().waitForelementToBeClickable(requestBtn);
            Thread.sleep(5000);
            requestBtn.click();
            getDriver().waitForElementLoad();
            getSession().log_Pass("Clicked On Add Request Button");


            if (getCurrentDriver().getCurrentUrl().contains("createRequest;isFromCase=true")) {

                log_Info("Case Level Request Page Loaded");

            } else {

                throw new Exception("Case Level Request Page Not Loaded");
            }

            getSession().log_Info("Check the Case Name Is Displayed ByDefault And In NON-Editable Mode");
            Thread.sleep(2000);
            boolean b1 = ChooseACASE.isEnabled();
            Thread.sleep(2000);
            System.out.println(b1);
            Thread.sleep(2000);
            Assert.assertEquals(true, b1);
            getSession().log_Pass("Checked the Case Name Is Displayed ByDefault And In NON-Editable Mode");

            return new CaseRequestsPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnAddRequestButton", ex);
        }
    }
}
