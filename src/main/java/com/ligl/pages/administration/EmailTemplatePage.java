package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LegalHoldPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmailTemplatePage extends LiglBaseSessionPage {


    @FindBy(css="input[id='Name']")
    WebElement NewTempName;
    @FindBy(css="input[id='subject']")
    WebElement MailSubject;
    @FindBy(id="btn-save")
    WebElement SaveBtn;
    @FindBy(css="div[role='textbox']")
    WebElement MailContent;



    public ILiglPage editTempOnFly(String NewtempName, String subject, String content)throws Exception{

        try{

            log_Info("editTempOnFly() Started");
            Thread.sleep(5000);
            NewTempName.sendKeys(NewtempName);
            Thread.sleep(5000);
            MailSubject.clear();
            MailSubject.sendKeys(subject);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", SaveBtn);
            MailContent.clear();
            MailContent.sendKeys(content);
            SaveBtn.click();

            return new LegalHoldPage();

        }catch (Exception ex){
            log_Error("editTempOnFly() is Failed");
            throw new Exception("Exception in editTempOnFly()",ex);
        }
    }
}
