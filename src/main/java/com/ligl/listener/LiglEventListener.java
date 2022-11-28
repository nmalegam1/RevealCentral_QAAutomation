package com.ligl.listener;

import com.ligl.session.LiglTestSession;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.AbstractWebDriverEventListener;
import org.testng.Reporter;

import com.ligl.web.IWebConnector;

public class LiglEventListener extends AbstractWebDriverEventListener{
	
	public void beforeFindBy(By locator, WebElement element, WebDriver driver) {
		
		// validate the presence and visiblity
		//System.out.println("--->"+getSession().isExecuteListener());
		/*if(getSession().isExecuteListener()) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
			/*try {
				wait.until(ExpectedConditions.presenceOfElementLocated(locator));
				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
				wait.until(ExpectedConditions.elementToBeClickable(locator));
			}catch(TimeoutException e) {
				getDriver().fail("Element not found - "+locator);
				getDriver().assertAll();
			}
		}*/
	}
	
	public IWebConnector getDriver() {
		return getSession().getCon();
	}
	
	public LiglTestSession getSession() {
		return (LiglTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public void log(String message) {
			getSession().log_Info(message);
	}
	

}
