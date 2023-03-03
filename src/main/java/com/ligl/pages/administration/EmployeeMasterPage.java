package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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

}
















