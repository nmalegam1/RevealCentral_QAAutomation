package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class GlobalRequestPage extends LiglBaseSessionPage{
    @FindBy(id = "req-add-request-btn")
    public WebElement requestBtn;

    @FindBy(id = "req-type-dpdwn")
    public WebElement reqTypeDrpDwn;

    @FindBy(xpath = "//input[@placeholder='Search']")
    public WebElement drpDwnSearchBar;

    @FindBy(css = "#addreq-back-btn")
    public WebElement backToReqBtn;

    /**
     * TC54560 Admin-LookUp-Requests-Check whether the lookup value is populated in create request pop up in Global requests
     */

    public ILiglPage checkNewlyCreatedLookupPopulatedInRequestTypeDropDown(String requestType) throws Exception{
        try {
            //Request Button
            getSession().log_Info("Click On '+Request' Button");
            getDriver().waitForelementToBeClickable(requestBtn);
            requestBtn.click();
            wait(2);
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On '+Request' Button");

            //Request Type
            getSession().log_Info("Click On 'Request Type' Drop Down");
            getDriver().waitForelementToBeClickable(reqTypeDrpDwn);
            reqTypeDrpDwn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked On 'Request Type' Drop Down");

            getSession().log_Info("Enter request type");
            drpDwnSearchBar.sendKeys(requestType);
            wait(2);
            getSession().log_Pass("Entered request type");

            getSession().log_Info("Check Lookup Populated In 'RequestType' DropDown");
            String reqTypeText = getCurrentDriver().findElement(By.xpath("//span[normalize-space()='"+requestType+"']")).getText();
            Assert.assertEquals(reqTypeText, requestType);
            getSession().log_Pass("Lookup Populated In 'RequestType' DropDown");

            //Back To Request Button
            getSession().log_Info("Click On  'Back to Requests' Button");
            getDriver().scrollToView(backToReqBtn);
            getDriver().waitForelementToBeClickable(backToReqBtn);
            backToReqBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getCurrentDriver().findElement(By.xpath("//button[text()='Ok']")).click();
            getSession().log_Pass("Clicked On  'Back to Requests' Button");

            wait(4);

            return new GlobalRequestPage();
        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("Check Lookup Populated In Request Type DropDown Failed", ex);
        }
    }
}
