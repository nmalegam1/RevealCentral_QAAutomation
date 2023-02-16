package com.ligl.session;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;
import com.ligl.base.pages.ILiglPage;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ligl.base.pages.Constants;
import com.ligl.reports.ExtentManager;
import com.ligl.web.IWebConnector;
import com.ligl.web.LiglDriver;

public class LiglTestSession {
	IWebConnector con;
	ILiglPage currentPage;
	ExtentReports reports;
	ExtentTest test ;
	boolean executeListener;

	Properties prop1;
	Properties prop2;







	public LiglTestSession()throws Exception  {

		con = new LiglDriver();
		try {
 prop1 = new Properties();
 prop2 = new Properties();
 FileInputStream fs1 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\smoke.properties");
 prop1.load(fs1);
 FileInputStream fs2 = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\regression.properties");
 prop2.load(fs2);
 }catch (Exception e)
 {
 e.printStackTrace();
 }
}

public String getSmokeData(String td) {
	return (String) prop1.get(td);
}
public String getRegressionData(String td)
 {
	return (String) prop2.get(td);
 }
	
	public void init(String testName) {
		setExecuteListener(true);
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
		 Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);
		
		// init reports
		reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		test = reports.createTest(testName);
	}
	
	public IWebConnector getCon() {
		return con;
	}

	public ILiglPage getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(ILiglPage currentPage) {
		this.currentPage = currentPage;
	}
	
	public void end() {
		 getCon().assertAll();
	}

	/*********************Reporting functions**********************/
	public void log_Info(String message) {
		System.out.println(message);
		test.log(Status.INFO, message);
	}
	
	public void generateReport() {
		if(reports !=null)
			reports.flush();
		// quit the browser
		if(getCon() !=null)
			getCon().quit();
	}
	
	public void log_Error(String failureMessage) {
		//fail in extent
		System.out.println("Failing "+failureMessage);
		takeScreenShot();
		test.log(Status.FAIL, failureMessage);
		// take screenshot of failure
	}

	public void log_Pass(String passMessage) {
		//pass in extent
		System.out.println(passMessage);//Writing to Console
		log_Info(passMessage);//Writing to TestNG Report
		test.log(Status.PASS, passMessage);//Writing to Extent Report
	}

	// first take screenshot and then add it to reports
	public void takeScreenShot() {
		// fileName of the screenshot
				Date d=new Date();
				String screenshotFile=d.toString().replace(":", "_").replace(" ", "_")+".png";
				// take screenshot
				File srcFile = ((TakesScreenshot) getCon().getCurrentDriver()).getScreenshotAs(OutputType.FILE);
				try {
					// get the dynamic folder name
					FileUtils.copyFile(srcFile, new File(ExtentManager.screenshotFolderPath+screenshotFile));
					//put screenshot file in reports
					test.log(Status.INFO,"Screenshot-> "+ test.addScreenCaptureFromPath(ExtentManager.screenshotFolderPath+screenshotFile));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	
	public void skipTest(String message) {
		test.log(Status.SKIP, message);
	}

	public boolean isExecuteListener() {
		return executeListener;
	}

	public void setExecuteListener(boolean executeListener) {
		this.executeListener = executeListener;
	}

}
