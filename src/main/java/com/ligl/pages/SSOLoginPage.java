package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SSOLoginPage extends LiglBasePage {
    @FindBy(name="loginfmt")
    WebElement userNameTxt;

    @FindBy(id="idSIButton9")
    WebElement nextBtn;

    @Override
    public ILiglPage SSOLogin(String userName, String password) throws InterruptedException {
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
        Thread.sleep(10000);

        if (getCurrentDriver().getTitle().contains("Legal Entity Select | Vertical")) {
            //String url=getCurrentDriver().getCurrentUrl();
            log_Info("EntityPage Loaded");
            //waitForPageToLoad();
            String entity="usa";
            System.out.println("Entity : "+entity);
            if(entity.contains("usa"))
            {
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'USA')]")).click();
                getDriver().waitForAngularRequestsToComplete();
                return new DefaultLandingPage();
            }else if (entity.contains("ind")){
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'IND')]")).click();
                return new DefaultLandingPage();
            }
        }
        return new DefaultLandingPage();
    }

}
