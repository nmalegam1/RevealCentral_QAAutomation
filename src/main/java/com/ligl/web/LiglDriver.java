package com.ligl.web;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.ligl.base.pages.Constants;
import com.ligl.listener.LiglEventListener;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LiglDriver extends LiglValidationDriver {

	public void logout() {
	}

	public void openBrowser(String bName) {
		log("Opening the browser "+bName );
		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");

		if(Constants.GRIDRUN.equals("Y")) {
			// desired capabilities
			DesiredCapabilities cap = new DesiredCapabilities();
			if(bName.equalsIgnoreCase("chrome")) {
				cap.setBrowserName("chrome");
				cap.setPlatform(Platform.WINDOWS);
			}else if(bName.equalsIgnoreCase("mozilla")) {
				cap.setBrowserName("firefox");
				cap.setPlatform(Platform.WINDOWS);
			}
			
			try {
				driver = new EventFiringWebDriver(new RemoteWebDriver(new URL("http://localhost:4444"),cap));
			} catch (MalformedURLException e) {
				e.printStackTrace();
				setStopExecution(true);
				fail("Unable to launch test on hub "+ e.getMessage());
			}
			
		}else {// normal run
			//driver = new EventFiringWebDriver(new FirefoxDriver());

			if (bName.equalsIgnoreCase("chrome")) {
				ChromeOptions opt = new ChromeOptions();
				opt.addArguments("--disable-notifications");
				opt.addArguments("--remote-allow-origins=*");
				opt.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //SIT Access
				opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true); //SIT Access
				driver = new EventFiringWebDriver(new ChromeDriver(opt));
			} else if (bName.equalsIgnoreCase("mozilla")) {
				driver = new EventFiringWebDriver(new FirefoxDriver());

			}
		}

		driver.register(new LiglEventListener());
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		javascriptExecutor=(JavascriptExecutor) driver;
		ngWebDriver=new NgWebDriver(javascriptExecutor);
	}

	public void navigate(String url) {
		log("URL"+url );
		driver.get(url);
		
	}

	public void quit() {
		if(driver!=null)
		   driver.quit();
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return driver;
	}

	public void waitForElementLoad() {
		
	}

	public void waitForVisibilityOfElementLocated(By locator){
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}

	public void waitForelementToBeClickable(WebElement element){
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public void waitForAngularRequestsToComplete() {
		ngWebDriver.waitForAngularRequestsToFinish();
	}
}
