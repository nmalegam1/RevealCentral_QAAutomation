package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.datamanagement.DMSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GoogleVaultPage extends LiglBaseSessionPage{
    @FindBy(id="identifierId")
    WebElement Gusername;
    @FindBy(name = "Passwd")
    WebElement GPassword;
    @FindBy(xpath = "//span[contains(text(),'Next')]")
    WebElement GNextBtn;
    @FindBy(xpath = "//a[@title='Google Vault']")
    WebElement VaultHeader;
    @FindBy(xpath = "//div[contains(text(),'Matters')]")
    WebElement Matters;
    @FindBy(xpath = "//input[@aria-label='Filter by name or owner']")
    WebElement SearchMatter;
    @FindBy(xpath = "//span[contains(text(),'Exports')]")
    WebElement ExportsTab;
    @FindBy(xpath = "//tr[@role='row']//div[contains(text(),'Count')]/ancestor::td//span")
    WebElement CountStats;
    @FindBy(xpath = "//tr[@role='row']//div[contains(text(),'Size')]/ancestor::td//span")
    WebElement SizeStats;

    public ILiglPage googleVaultLogin(String VaultURL, String username, String password)throws Exception{
        getSession().log_Info("googleVaultLogin() Started");
        getCurrentDriver().get(VaultURL);

        getSession().log_Info("GVault Opened");
        Gusername.sendKeys(username);
        getSession().log_Info("User Name Entered");
        Thread.sleep(5000);
        GNextBtn.click();
        Thread.sleep(5000);
        GPassword.sendKeys(password);
        getSession().log_Info("Password Entered");
        GNextBtn.click();
        Thread.sleep(8000);
        VaultHeader.isDisplayed();
        getSession().log_Info("Successfully Logged in to Google Vault");
        return new GoogleVaultPage();
    }

    public ILiglPage goToMatters()throws Exception
    {
        Matters.click();
        Thread.sleep(5000);
        return new GoogleVaultPage();
    }
    public ILiglPage searchMatter(String matter){

        SearchMatter.sendKeys(matter);
        return new GoogleVaultPage();
    }
    public ILiglPage goToExports(String CCD){
        getCurrentDriver().findElement(By.xpath("//span[@title='"+CCD+"']")).click();
        ExportsTab.click();
        return new DMSummaryPage();
    }
    public String getCCDStats(){
        String count=CountStats.getText();
        String size=SizeStats.getText();
        String Stats=count+size;
        return Stats;

    }
}
