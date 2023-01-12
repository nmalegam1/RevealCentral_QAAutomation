package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class CaseCustodiansPage extends LiglBaseSessionPage
{
    @FindBy(id = "btn-createcustodian")
    WebElement AddCust;
    @FindBy(xpath = "//span[@title='a custodians1']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement Employee;

    @FindBy(id ="edit-btn")
    WebElement AddToCase;

    @FindBy(xpath = "//span[contains(text(),'Employment Status')]/ancestor::div[@ref='eLabel']")
    WebElement EmployeeStatusHeader;
    @FindBy(xpath = "//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']")
    WebElement EmailName;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@ref='eLabel']")
    WebElement NameHead;

    @FindBy(xpath = "//span[contains(text(),'Name')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement NameMenu;

    @FindBy(xpath = "//span[contains(text(),'Alias')]/ancestor::div[@ref='eLabel']")
    WebElement AliasName;

    @FindBy(xpath = "//span[contains(text(),'ID')]/ancestor::div[@ref='eLabel']")
    WebElement IdHead;

    @FindBy(xpath = "//span[contains(text(),'Action')]/ancestor::div[@ref='eLabel']//span")
    WebElement ActionHead;

    @FindBy(xpath = "//span[contains(text(),'Date Joined')]/ancestor::div[@ref='eLabel']//span")
    WebElement DateJoinedHead;

    @FindBy(xpath = "//span[contains(text(),'Date Terminated')]/ancestor::div[@ref='eLabel']")
    WebElement DateTerminatedHead;

    @FindBy(xpath = "//span[contains(text(),'Department')]/ancestor::div[@ref='eLabel']")
    WebElement DepartmentHead;

    @FindBy(xpath = "//span[contains(text(),'Alias')]/ancestor::div[@class='ag-cell-label-container ag-header-cell-sorted-none']//span")
    WebElement AliasMenu;

    @FindBy(xpath = "//span[@title='Vyshnavi Yerra']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")
    WebElement Employeee;

    @FindBy(xpath = "//span[@title='Vyshnavi Yerra']")
    WebElement CustodianName;

    @FindBy(xpath ="//span[contains(text(),'Email')]/ancestor::div[@ref='eLabel']/ancestor::div[@class='ag-header-cell ag-focus-managed ag-header-cell-sortable']//span//span")
    WebElement EmailMenu;

    @FindBy(xpath = "//*[@id=\"content\"]/div[2]/div[2]/ag-grid-angular/div/div[2]/div[2]/div[1]/div[2]/div/div/div[5]/div[3]/span/span")
    WebElement EmailMenuu;//Doubt

    @FindBy(xpath ="//div[@role='menu']//span[@aria-label='filter']/span")
    WebElement Filter;

    @FindBy(xpath= "//input[@placeholder='Filter...']")
    WebElement Searchbar;

    @FindBy(xpath= "//*[@id='record-edit']")
    WebElement EditBtn;



    //12. After Navigating To Custodian Tab The Actions We Perform Adding Custodians To A Case

    public ILiglPage addCustodianToCase(String Email1,String Employee1) throws Exception {

        try {

            log_Info("Click Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Custodians button clicked");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);


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
            Searchbar.sendKeys(Email1);
            Thread.sleep(2000);
            log_Info("Check Employee CheckBox");
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee1+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            log_Info("Employee checked");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            AddToCase.click();
            getCurrentDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCustodiansPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addCustodianToCase() Failed",ex);
        }
    }

    // Adding One Or More Custodians To A case Through Single/Multiple Filters

    public ILiglPage addCustodiansToCaseThroughFilters(String Employee1,String Employee2) throws Exception {

        try {

            log_Info("Click On Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Custodians button clicked");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);

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
            Searchbar.sendKeys(Employee1);

            // Second Filter Through Alias

           /* ac.moveToElement(AliasName).perform();
            log_Info("Hovered on Name Header");
            Thread.sleep(5000);

            AliasMenu.click();
            log_Info("Menu clicked");
            Thread.sleep(2000);

            log_Info("Click on Filter");
            Thread.sleep(2000);
            Filter.click();
            log_Info("Filter Clicked");
            Thread.sleep(2000);
            log_Info("Enter Employee");
            Searchbar.sendKeys("vyerra");
            log_Info(" Employee Entered ");*/


            log_Info("Check Employee CheckBox");
            getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee2+"']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']")).click();
            Thread.sleep(5000);
            log_Info("Employee checked");

            log_Info("Click Add To case Button");
            getDriver().waitForelementToBeClickable(AddToCase);
            Thread.sleep(3000);
            AddToCase.click();
            getSession().log_Pass("Add To Case Button clicked");
            return new CaseCustodiansPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addCustodiansToCaseThroughFilters() Failed",ex);
        }
    }

    // Validating The Custodians After Adding In The Custodian Page

    public ILiglPage validatingCustodians(String Employee2) throws Exception {

        try {

            log_Info("Check The Name Of The Custodian");
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[@title='"+Employee2+"']")).isDisplayed();
            System.out.println(a1);
            Thread.sleep(3000);
            Assert.assertEquals(true, a1);
            return new CaseCustodiansPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validatingCustodians()",ex);
        }
    }

    // Validating The Columns in the Custodian Page

    public ILiglPage verifyColumnsInCustodianGrid() throws Exception {

        try {

            log_Info("Click On Add Custodian Button");
            getDriver().waitForelementToBeClickable(AddCust);
            Thread.sleep(5000);
            AddCust.click();
            Thread.sleep(5000);
            getSession().log_Pass("Add Custodians button clicked");

            log_Info("Check The Column names In The Custodian Page");
            boolean c1 = NameHead.isDisplayed();
            boolean c2 = IdHead.isDisplayed();
            boolean c3 = AliasName.isDisplayed();
            boolean c4 = DepartmentHead.isDisplayed();
            boolean c5 = EmailName.isDisplayed();

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", EmployeeStatusHeader);

            boolean c6 = EmployeeStatusHeader.isDisplayed();
            /*boolean c7 = DateJoinedHead.isDisplayed();
            boolean c8 = DateTerminatedHead.isDisplayed();
            boolean c9 = ActionHead.isDisplayed();*/

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);
           /* System.out.println(c7);
            System.out.println(c8);
            System.out.println(c9);*/

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            Assert.assertEquals(true, c6);
           /* Assert.assertEquals(true, c7);
            Assert.assertEquals(true, c8);
            Assert.assertEquals(true, c9);*/
            return new CaseCustodiansPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInCustodianGrid()",ex);
        }
    }
}


