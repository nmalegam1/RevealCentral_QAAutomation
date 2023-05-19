import com.paulhammant.ngwebdriver.NgWebDriver;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class SampleTest {
	@Test
	public void Test1() throws InterruptedException {
		WebDriver driver;
		NgWebDriver ngWebDriver;
		JavascriptExecutor javascriptExecutor;

		System.setProperty(ChromeDriverService.CHROME_DRIVER_SILENT_OUTPUT_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\chromedriver.exe");
		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--disable-notifications");

		opt.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true); //SIT Access
		opt.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS,true); //SIT Access

		driver = new EventFiringWebDriver(new ChromeDriver(opt));// Launching the LaunchPage
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(120));
		javascriptExecutor=(JavascriptExecutor) driver;
		ngWebDriver=new NgWebDriver(javascriptExecutor);
		driver.get("https://rt.myligl.io/RT/#/login");
		String user="superuser1";
		String pw="Testing@123";
//		driver.get("https://in-opt-sit-01.in.vertical.com/SIT/#/login");
//		String user="nmalegamSITSuperUser";
//		String pw="Manual@456";
		ngWebDriver.waitForAngularRequestsToFinish();
		WebElement username=driver.findElement(By.name("userName"));
		WebElement password=driver.findElement(By.name("password"));
		wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(user);
		wait.until(ExpectedConditions.elementToBeClickable(username));
		password.sendKeys(pw);
		driver.findElement(By.id("signin-button")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']")));
		ngWebDriver.waitForAngularRequestsToFinish();
		//Close change password popup if appear
        if(driver.getCurrentUrl().contains("user-change-password")) {
            WebElement passwordCloseBtn=driver.findElement(By.id("btn-cross"));
            wait.until(ExpectedConditions.elementToBeClickable(passwordCloseBtn));
            passwordCloseBtn.click();
        }
        //Select Region
        if(driver.getCurrentUrl().contains("legalentity")) {
			//Relativity xpath = //span[contains(text(),'Relativity')]
            WebElement nuixEntity=driver.findElement(By.xpath("//a[id='entity']/span[contains(text(),'NUIX')]"));
            wait.until(ExpectedConditions.elementToBeClickable(nuixEntity));
			nuixEntity.click();
			ngWebDriver.waitForAngularRequestsToFinish();
        }

		//ngWebDriver.waitForAngularRequestsToFinish();
		//driver.findElement(By.cssSelector(".menu-item-parent")).click();
		//ngWebDriver.waitForAngularRequestsToFinish();
//		WebElement jobManagerTabLink=driver.findElement(By.xpath("//span[@id='job-manager-tab']"));
//		jobManagerTabLink.click();
//		ngWebDriver.waitForAngularRequestsToFinish();
		//element.click();
		//driver.findElement(By.id("sel-matter-type")).sendKeys(text);
//		List<WebElement> options = element.findElements(By.xpath("//div[@id='sel-matter-type-panel']//span[@class='mat-option-text']"));
//		for (WebElement option : options){
//			if (option.getText().trim().contains(text)){
//				option.click();
//				break;
//			}
//		}
		//***************Creating New CASE********************
		//driver.navigate().refresh();
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']")));
		//ngWebDriver.waitForAngularRequestsToFinish();
		driver.findElement(By.xpath("//button[@id='btn-create-case']")).click();
		driver.findElement(By.id("sel-matter-type")).click();
		driver.findElement(By.xpath("//div[@id='sel-matter-type-panel']//input[@type='text']")).sendKeys("Admiralty & Maritime");
		driver.findElement(By.xpath("//div[@id='sel-matter-type-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("sel-role-type")).click();
		driver.findElement(By.xpath("//div[@id='sel-role-type-panel']//input[@type='text']")).sendKeys("Defendant");
		driver.findElement(By.xpath("//div[@id='sel-role-type-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("input-case-name")).sendKeys("QA_Automation_01");
		driver.findElement(By.xpath("//textarea[@id='input-description-1']")).sendKeys("Desc");


		driver.findElement(By.id("select-workflow-template")).click();
		driver.findElement(By.xpath("//div[@id='select-workflow-template-panel']//input[@type='text']")).sendKeys("WFT-COLLECTION");
		driver.findElement(By.xpath("//div[@id='select-workflow-template-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("select-optimum-setting")).click();
		driver.findElement(By.xpath("//div[@id='select-optimum-setting-panel']//input[@type='text']")).sendKeys("case settings tempalte");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select-optimum-setting-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("select-org")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select-org-panel']//input[@type='text']")).sendKeys("Vertical East Corp");
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select-org-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("select-sub-org")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select-sub-org-panel']//input[@type='text']")).sendKeys("Vertical East Corp Facility");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//div[@id='select-sub-org-panel']//input[@type='text']")).sendKeys(Keys.ENTER);

		driver.findElement(By.id("select-priority")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='select-priority-panel']//mat-option[2]")).click();
		//driver.findElement(By.id("input-description-2")).sendKeys("Automation testing");

		driver.findElement(By.xpath("//button[contains(text(),'More')]"));
		driver.findElement(By.id("btn-create-cancel")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Yes')]")).click();
		//button[contains(text(),'Yes')]
		//Logout
		WebElement userNameLink=driver.findElement(By.id("profileDropdown"));
		WebElement logoutLink=driver.findElement(By.xpath("//a[@data-action='userLogout']"));
		userNameLink.click();
		logoutLink.click();
		ngWebDriver.waitForAngularRequestsToFinish();
		driver.quit();
	}

}
