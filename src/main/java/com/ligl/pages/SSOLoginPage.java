package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSOLoginPage extends LiglBasePage {
    String selectedEntity;
    @FindBy(name = "loginfmt")
    WebElement userNameTxt;

    @FindBy(id = "idSIButton9")
    WebElement nextBtn;

    // @Overridepublic
    public ILiglPage SSOLogin(String userName, String password, String Entity) throws InterruptedException {
        log_Info("Enter SSO UserName");
        userNameTxt.sendKeys(userName);
        getSession().log_Pass("Entered SSO username");
        nextBtn.click();
        getCurrentDriver().findElement(By.name("passwd")).sendKeys(password);
        getSession().log_Pass("Entered SSO password");
        getCurrentDriver().findElement(By.xpath("//input[@value='Sign in']")).click();
        getSession().log_Pass("Clicked Sign in button");
        getCurrentDriver().findElement(By.xpath("//input[@value='Yes']")).click();
        getSession().log_Pass("Clicked Yes button in confirmation window");
        Thread.sleep(15000);
        if (getCurrentDriver().getCurrentUrl().contains("legalentity")) {
            log_Info("EntityPage Loaded");
            System.out.println("Entity : " + Entity);
            if (Entity.contains(Entity)) {
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Entity + "')]")).click();
                getDriver().waitForAngularRequestsToComplete();
                return new DefaultLandingPage();
            }
        }
        return new DefaultLandingPage();
    }

    public ILiglPage loginWithSSOUser(String entity) throws InterruptedException {
        log_Info("Enter SSO UserName");
        userNameTxt.sendKeys(getSession().getGlobalData("SSO_UserName"));
        getSession().log_Pass("Entered SSO username");
        nextBtn.click();
        getCurrentDriver().findElement(By.name("passwd")).sendKeys(getSession().getGlobalData("SSO_Password"));
        getSession().log_Pass("Entered SSO password");
        getCurrentDriver().findElement(By.xpath("//input[@value='Sign in']")).click();
        getSession().log_Pass("Clicked Sign in button");
        getCurrentDriver().findElement(By.xpath("//input[@value='Yes']")).click();
        getSession().log_Pass("Clicked Yes button in confirmation window");
        Thread.sleep(15000);
        if (getCurrentDriver().getCurrentUrl().contains("legalentity")) {
            log_Info("EntityPage Loaded");
            if (entity.toLowerCase().contentEquals("rel"))
                selectedEntity = getSession().getGlobalData("Rel_Entity");
            else if (entity.toLowerCase().contentEquals("eur"))
                selectedEntity = getSession().getGlobalData("EUR_Entity");
            else if (entity.toLowerCase().contentEquals("custom"))
                selectedEntity = getSession().getGlobalData("Custom_Entity");
            System.out.println("Entity : " + selectedEntity);
            if (entity.contains(entity)) {
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + selectedEntity + "')]")).click();
                getDriver().waitForAngularRequestsToComplete();
                return new DefaultLandingPage();
            }
        }
        return new DefaultLandingPage();
    }

}
