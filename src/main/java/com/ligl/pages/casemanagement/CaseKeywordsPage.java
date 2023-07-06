package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.NotesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import javax.sql.DataSource;
import java.util.concurrent.TimeUnit;

public class CaseKeywordsPage extends LiglBaseSessionPage {

    // Web Elements For Adding Keywords

    @FindBy(id = "btn-keywords")
    WebElement AddKeyWordsBtn;

    @FindBy(xpath = "//*[@id='keywords']")
    WebElement Keywords;

    @FindBy(id = "basic-opt")
    WebElement BasicRadioBox;

    @FindBy(id="custom-opt")
    WebElement CustomRadioBox;

    @FindBy(id = "btn-save")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='KW1']")
    WebElement KW1;

    @FindBy(xpath = "//span[@title='KW2']")
    WebElement KW2;

    @FindBy(id = "selectType")
    WebElement SelectDataSourceDrpDwn;

    @FindBy(xpath = "//span[@title='Basic']")
    WebElement KWTP1;

    @FindBy(xpath = "//span[@title='Basic']")
    WebElement KWTP2;

    @FindBy(xpath = "//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath="//span[contains(text(),'Keyword Search Name')]/ancestor::div[@ref='eLabel']/ancestor::div[@col-id='Name']//span")
    WebElement KWNameMenu;

    @FindBy(xpath="//span[contains(text(),'Keyword Search Name') and @ref='eText']")
    WebElement KwName;

    @FindBy(xpath = "//button[@title='Notes']")
    WebElement KWNoteIcon;


    // Adding KeyWords In The Keywords Page By Taking Case Type Basic

    public ILiglPage addKeywordsByBasic(String Keywords1) throws Exception {

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", AddKeyWordsBtn);

            log_Info("Click On Add Key Words Btn");
            getDriver().waitForelementToBeClickable(AddKeyWordsBtn);
            Thread.sleep(5000);
            AddKeyWordsBtn.click();
            getSession().log_Pass("Clicked On Add Key Words Btn");


            log_Info("Click on Key Words Text Box");
            getDriver().waitForelementToBeClickable(Keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(Keywords1);
            getSession().log_Pass("Clicked on Key Words Text Box");

            log_Info("Click on Basic Radio Box");
            getDriver().waitForelementToBeClickable(BasicRadioBox);
            Thread.sleep(5000);
            BasicRadioBox.click();
            getSession().log_Pass("Clicked on Basic Radio Box");

            log_Info("Click on Save Btn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Btn");
            return new CaseKeywordsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addKeywordsByBasic() Failed", ex);
        }
    }

    // Adding KeyWords In The Keywords Page By Taking Case Type Custom

    public ILiglPage addKeywordsByCustom(String Keywords1,String DataSource1) throws Exception {

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(false);", AddKeyWordsBtn);

            log_Info("Click On Add Key Words Btn");
            getDriver().waitForelementToBeClickable(AddKeyWordsBtn);
            Thread.sleep(5000);
            AddKeyWordsBtn.click();
            getSession().log_Pass("Clicked On Add Key Words Btn");


            log_Info("Click on Key Words Text Box");
            getDriver().waitForelementToBeClickable(Keywords);
            Thread.sleep(5000);
            Keywords.sendKeys(Keywords1);
            getSession().log_Pass("Clicked on Key Words Text Box");

            log_Info("Click on Custom Radio Box");
            getDriver().waitForelementToBeClickable(CustomRadioBox);
            Thread.sleep(5000);
            CustomRadioBox.click();
            getSession().log_Pass("Clicked on Custom Radio Box");

            log_Info("Click on Select Data Source Drop Down");
            getDriver().waitForelementToBeClickable(SelectDataSourceDrpDwn);
            Thread.sleep(5000);
            SelectDataSourceDrpDwn.sendKeys(DataSource1);
            Thread.sleep(3000);
            SelectDataSourceDrpDwn.sendKeys(Keys.ENTER);
            getSession().log_Pass("Clicked on Select Data Source Drop Down");

            log_Info("Click on Save Btn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            Thread.sleep(5000);
            SaveBtn.click();
            getSession().log_Pass("Clicked on Save Btn");
            return new CaseKeywordsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addKeywordsByCustom() Failed",ex);
        }

    }

    // Validating The Keywords Added To The Keywords Page

    public ILiglPage validatingKeywords() throws Exception {

        try {

            log_Info("Check The Name Of Keywords As KW1 And KW2");
            boolean a1 = KW1.isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            boolean b1 = KW2.isDisplayed();
            Thread.sleep(3000);
            System.out.println(b1);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, b1);
            return new CaseKeywordsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingKeywords() Failed",ex);
        }
    }

    public ILiglPage validatingKeywordsByKeywordType() throws Exception {

        try {

            log_Info("Check The Name Of KeyWords As KW1 And KW2");
            boolean a1 = KW1.isDisplayed();
            boolean a2 = KWTP1.isDisplayed();
            System.out.println(a1);
            System.out.println(a2);
            Thread.sleep(3000);
            boolean b1 = KW2.isDisplayed();
            boolean b2 = KWTP2.isDisplayed();
            Thread.sleep(3000);
            System.out.println(b1);
            System.out.println(b2);
            Assert.assertEquals(true, a1);
            Assert.assertEquals(true, a2);
            Assert.assertEquals(true, b1);
            Assert.assertEquals(true, b2);
            return new CaseKeywordsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingKeywordsByKeywordType() Failed",ex);

        }
    }

    public ILiglPage enableAndDisableKeywords(String Status1) throws Exception{

        try {


            log_Info("Click On Enable Button In The Grid");
            Thread.sleep(5000);

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            Actions ac = new Actions(getCurrentDriver());

            for (int i = 0; i < 7; i++) {


                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");

            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Status1+"')]")).click();
            getSession().log_Pass("Clicked On Enable Button In The Grid");
            return new CaseKeywordsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("enableAndDisableKeywords() Failed", ex);
        }
    }

    public ILiglPage validateEnableAndDisableKeywords(String Status2) throws Exception{

        try {


            log_Info("Check The Status Of KeyWords Is Enable/Disable");

            log_Info("Click Scroll Bar And Move Right");
            Thread.sleep(5000);

            // Performing Tab Action Using For Loop

            Actions ac = new Actions(getCurrentDriver());

            for (int i = 0; i < 7; i++) {


                ac.sendKeys(Keys.TAB).perform();
            }
            ac.sendKeys(Keys.TAB).perform();
            Thread.sleep(5000);
            getSession().log_Pass("Clicked Scroll Bar And Move Right");

            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+Status2+"')]")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseKeywordsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateEnableAndDisableKeywords() Failed", ex);
        }
    }

//Searching required Keyword in Keywords grid
    public ILiglPage searchRequiredKeywordName(String KWname) throws Exception {
        try {
            log_Info("searchRequiredKeywordName() Started");
            Thread.sleep(5000);
            Actions ac = new Actions(getCurrentDriver());
            ac.moveToElement(KwName).perform();
            KWNameMenu.click();
            Thread.sleep(5000);
            Filter.click();
            Thread.sleep(5000);
            Searchbar.sendKeys(KWname);
            Thread.sleep(5000);
            return new CaseKeywordsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("searchRequiredKeywordName() Failed", ex);

        }}

    //Clicking Notes for Disabled Keywords
    public ILiglPage disabledKeywordsNotesClick(String KWname) throws Exception {
        try {
            log_Info("disabledKeywordsNotesClick() Started");
            KwName.click();
            for (int i = 0; i < 9; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(KWNoteIcon);
            KWNoteIcon.click();
            Thread.sleep(5000);
            return new NotesPage();
        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("disabledKeywordsNotesClick() Failed", ex);

        }
    }

//Clicking Note icon for Enabled Keywords
    public ILiglPage enabledKeywordsNotesClick(String KWname) throws Exception {
        try {
            log_Info("enabledKeywordsNotesClick() Started");
            searchRequiredKeywordName(KWname);
            Thread.sleep(5000);
            KwName.click();
            getDriver().waitUntilSpinnerIsClosed();
            for (int i = 0; i < 9; i++)
            {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }
            getDriver().waitForelementToBeClickable(KWNoteIcon);
            KWNoteIcon.click();
            Thread.sleep(5000);

            return new NotesPage();
        }
        catch (Exception | Error ex)
        {
            log_Error(ex.getMessage());
            throw new Exception("enabledKeywordsNotesClick() Failed", ex);

        }
    }

}
