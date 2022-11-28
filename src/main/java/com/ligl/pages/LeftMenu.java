package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu extends LiglBasePage {
    @FindBy(xpath="//span[contains(text(),'Case Management')]/ancestor::li//span[contains(text(),'Summary')]")
    public WebElement caseManagementSummaryLink;

    @FindBy(xpath="//span[contains(text(),'Case Management')]")
    public WebElement caseManagementLink;

    @FindBy(xpath="//span[contains(text(),'Counsel')]")
    public WebElement CounselLink;

    @FindBy(xpath="//span[contains(text(),'Security')]")
    public WebElement SecurityLink;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public ILiglPage goToCaseManagementSummary() {
        caseManagementSummaryLink.click();
        return new CaseSummaryPage();
    }

    public ILiglPage goToSecurityPage() {
        SecurityLink.click();
        return new SecurityPage();
    }

}
