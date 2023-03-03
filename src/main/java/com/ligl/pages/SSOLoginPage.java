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

   // @Overridepublic
    public ILiglPage SSOLogin(String userName, String password,String Entity) throws InterruptedException
    {
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
        if (getCurrentDriver().getTitle().contains("Legal Entity Select | Vertical"))
        {
            log_Info("EntityPage Loaded");
            System.out.println("Entity : "+Entity);
            if(Entity.contains(Entity))
            {
                getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Entity+"')]")).click();
                getDriver().waitForAngularRequestsToComplete();
                return new DefaultLandingPage();
            }
        }
        return new DefaultLandingPage();
    }

}
