package com.ligl.web;

import java.time.Duration;
import java.util.List;

import com.ligl.base.pages.ILiglPage;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import com.ligl.session.LiglTestSession;


public abstract class LiglValidationDriver implements IWebConnector {
    EventFiringWebDriver driver;
    NgWebDriver ngWebDriver;
    WebDriverWait wait;
    JavascriptExecutor javascriptExecutor;
    boolean stopExecution;
    SoftAssert softAssert = new SoftAssert();

    public void validateLogin() {
        System.out.println("LiglValidationDriver validateLogin");
    }

    public ILiglPage validateTitle(String expTitle) {
        log("Expedted Title " + expTitle);
        log("Actual Title " + driver.getTitle());
        //Assert.assertEquals(driver.getTitle(), expTitle);
        //  System.out.println(" validateTitle Status is "+ isStopExecution());
        if (!expTitle.equals(driver.getTitle())) {
            fail("Titles do not match. Got title as " + driver.getTitle());

        }
        return getSession().getCurrentPage();
    }

    public ILiglPage validateText(By locator, String expectedText) {
        log("validateText");
        //Assert.assertEquals(actual, expected);
        String actualText = driver.findElement(locator).getText();
        log("Actual Text {" + actualText + "}. Expected Text {" + expectedText + "}");
        if (!expectedText.equals(actualText)) {
            fail("Text not Matching. Got text as " + actualText);
        }
        return getSession().getCurrentPage();
    }

    public ILiglPage validateElementPresence(By locator) {
        log("Validating element presence " + locator);
        if (!isElementPresent(locator))
            fail("Element not found - " + locator);

        return getSession().getCurrentPage();
    }

    public void waitUntilSpinnerIsClosed() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='ag-overlay ag-hidden']")));
    }


    public ILiglPage validateElementNotPresence(By locator) {

        if (isElementPresent(locator))
            fail("Element not found - " + locator);

        return getSession().getCurrentPage();
    }

    //true - present
    //false - not present
    public boolean isElementPresent(By locator) {
        getSession().setExecuteListener(false);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        } catch (TimeoutException e) {
            getSession().setExecuteListener(true);
            log("Element not found " + locator);
            return false;
        }
        getSession().setExecuteListener(true);
        log("Element found success fully " + locator);
        return true;
    }

    public void assertAll() {// control will come to stop the test.. some critical err
        // take screenshot
        softAssert.assertAll();
    }


    public boolean isStopExecution() {
        return stopExecution;
    }

    public void setStopExecution(boolean stopExecution) {
        this.stopExecution = stopExecution;
    }

    public LiglTestSession getSession() {
        return (LiglTestSession) Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
    }

    public SoftAssert getSoftAssert() {
        return softAssert;
    }

    public void setSoftAssert(SoftAssert softAssert) {
        this.softAssert = softAssert;
    }

    public void log(String message) {
        getSession().log_Info(message);
    }

    public void fail(String message) {
        // fail in extent reports
        getSession().log_Error(message);

        // fail in testng
        softAssert.fail(message);

        // decide - if exec has to be stopped
        if (isStopExecution())
            assertAll();
    }

    /*****************************************************/

    public void scrollToView(WebElement element) throws Exception {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView()", element);
    }

    public void waitForMoveToElement(WebElement element) throws Exception {
        Actions ac = new Actions(getCurrentDriver());
        ac.moveToElement(element).perform();
    }

    public WebElement customXpathBasedOnTextValue(String textValue) throws Exception {
        Thread.sleep(500);
        WebElement webElementA = getCurrentDriver().findElement(By.xpath("//span[contains(text(), '" + textValue + "')]"));
        return webElementA;
    }

    public void moveToRightInAngularTable(String number) throws Exception {
        Thread.sleep(500);
        Actions ac = new Actions(getCurrentDriver());
        int a = Integer.parseInt(number);
        for (int i = 0; i < a; i++) {
            ac.sendKeys(Keys.TAB).perform();
        }
        ac.sendKeys(Keys.TAB).perform();
    }

    public WebElement checkTheCheckBox(String textValue) throws Exception {
        try {
            Thread.sleep(1000);
            WebElement webElementB = getCurrentDriver().findElement(By.xpath("//span[@title='" + textValue + "']/ancestor::div[@ref='eCellWrapper']//div[@ref='eCheckbox']"));
            return webElementB;
        } catch (Exception ex) {
            getSession().log_Error("Check The CheckBox Failed");
            throw new Exception("Check The CheckBox Failed", ex);
        }
    }

}
