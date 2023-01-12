package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;
import java.util.Hashtable;

//****************CasePage*******************

public class DefaultLandingPage extends LiglBaseSessionPage {

    @FindBy(id = "btn-create-case")
    WebElement createCaseBtn;
    @FindBy(id = "btn-clear")
    WebElement clearFilterBtn;

    @FindBy(id = "caseAction")
    WebElement selectActionDrp;

    @FindBy(id = "modelaction-btn")
    WebElement runBtn;

    @FindBy(id = "btn-refresh")
    WebElement refreshBtn;

    @FindBy(css = "span[class='ag-icon ag-icon-menu']")
    WebElement CaseSearchMenu;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement CaseSearchFilter;

    @FindBy(css = "input[placeholder='Filter...']")
    WebElement CaseSearchBar;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]/ancestor::div[@ref='eLabel']")
    WebElement CaseNameHeader;


    //Create NewCase

    public ILiglPage createNewCase() {
        return createNewCase(null);
    }

    //Create NewCase
    public ILiglPage createNewCase(Hashtable<String, String> data) {
        log_Info(data.toString());
        return new CaseSummaryPage();
    }

    //Clear Filter

    public ILiglPage clickClearFilterBtn() {
        log_Info("Click Clear Filter Button");
        clearFilterBtn.click();
        waitForPageToLoad();
        return new LiglBasePage();
    }

    // Searching a particular case throgh filter

    public ILiglPage searchcase(String CaseName) throws Exception {

        try {

            getDriver().waitForelementToBeClickable(CaseNameHeader);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CaseNameHeader).perform();


            log_Info("pointed mouse to the case name");
            waitForPageToLoad();
            log_Info("click on case search menu");
            CaseSearchMenu.click();
            log_Info("clicked on case search menu");
            waitForPageToLoad();
            log_Info("click on case filter");
            CaseSearchFilter.click();
            log_Info("clicked on case filter");
            waitForPageToLoad();
            log_Info("sending case name to the search bar");
            CaseSearchBar.sendKeys(CaseName);
            log_Info("recieved case name to the search bar");
            return this;

        }catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchcase() Failed",ex);
        }

    }


    // Particular Case Name Is Selecting

    public ILiglPage GoToCase(String CaseName) throws Exception {

        try {


            log_Info("Select Particular Case Name");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.linkText(CaseName)).click();
            Thread.sleep(5000);
            log_Info("Particular Case Name Is Selected");
            return new CaseSummaryPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("GoToCase() Failed ",ex);
        }
    }

}
