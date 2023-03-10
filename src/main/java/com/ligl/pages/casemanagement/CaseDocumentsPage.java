package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CaseDocumentsPage extends LiglBaseSessionPage {

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;
    @FindBy(xpath="//span[contains(text(),'File')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement FileNameMenu;

    @FindBy(xpath = "//span[contains(text(),'File')]/ancestor::div[@ref='eLabel']/span")
    WebElement CaseDocFileName;

    public ILiglPage searchRequiredCaseDocument(String CaseDocument) throws Exception {
        try {
            log_Info("searchRequiredCaseDocument() Started");
            log_Info("Hover on Name Header");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(CaseDocFileName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);
            FileNameMenu.click();
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            log_Info("Filter Clicked");
            Searchbar.sendKeys(CaseDocument);
            Thread.sleep(5000);
            log_Info("Entered Case document file name In Search Bar");
            return new CaseDocumentsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredCaseDocument() Failed", ex);    }}

    public ILiglPage clickOnCaseDocument(String CaseDocument) throws Exception {

        try {


            log_Info("clickOnCaseDocument() started");
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + CaseDocument + "')]")).click();
            Thread.sleep(5000);
            log_Info("Clicked on Document Name");
            return new CaseDocumentsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnCaseDocument() Failed",ex);
        }
    }

}
