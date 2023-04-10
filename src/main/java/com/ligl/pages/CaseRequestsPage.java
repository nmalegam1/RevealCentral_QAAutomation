package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CaseRequestsPage extends LiglBaseSessionPage {


    @FindBy(id = "req-add-request-btn")
    public WebElement requestBtn;


    public ILiglPage clickOnAddRequestButtonInCaseRequests() throws Exception {

        try {

            getSession().log_Info("Click On Add Request Button");
            getDriver().waitForelementToBeClickable(requestBtn);
            Thread.sleep(5000);
            requestBtn.click();
            getDriver().waitForElementLoad();
            getSession().log_Pass("Clicked On Add Request Button");


            if (getCurrentDriver().getCurrentUrl().contains("case-level-requests")) {

                log_Info("Case Level Request Page Loaded");

            } else {

                throw new Exception("Case Level Request Page Not Loaded");
            }

            return new CaseRequestsPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnAddRequestButton", ex);
        }
    }
}
