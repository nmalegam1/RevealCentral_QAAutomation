package com.ligl.web;

import com.ligl.base.pages.ILiglPage;
import com.ligl.session.LiglTestSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.asserts.SoftAssert;

public interface IWebConnector{
	void openBrowser(String bName);
	void navigate(String url);
	void quit();
	EventFiringWebDriver getCurrentDriver();
	void waitForElementLoad();
	LiglTestSession getSession();
	boolean isStopExecution();
    void setStopExecution(boolean stopExecution);
    void assertAll();
    SoftAssert getSoftAssert();
	void setSoftAssert(SoftAssert softAssert);
	void log(String message);
	void fail(String message);
	void logout();
	ILiglPage validateTitle(String expectedTitle);
	ILiglPage validateText(By locator, String expectedText);
	boolean isElementPresent(By locator);
	void validateLogin();
	ILiglPage validateElementPresence(By locator);
	void waitForAngularRequestsToComplete();
	void waitUntilSpinnerIsClosed();
	void waitForVisibilityOfElementLocated(By locator);
	void waitForelementToBeClickable(WebElement element);

	/*****************************************************************************/

	void scrollToView(WebElement element) throws Exception;
	void waitForMoveToElement(WebElement element) throws Exception;
	WebElement customXpathBasedOnTextValue(String textValue) throws Exception;

	void moveToRightInAngularTable(String number) throws Exception;
	WebElement checkTheCheckBox(String textValue) throws Exception;

}
