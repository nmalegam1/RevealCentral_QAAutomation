package com.ligl.session;

import java.io.*;
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
	Properties smokeProperties;
	Properties regressionProperties;
	Properties globalProperties;
	public LiglTestSession()throws Exception  {
		con = new LiglDriver();
		try {
			smokeProperties = new Properties();
			regressionProperties = new Properties();
			globalProperties = new Properties();

			FileInputStream gpFIS = new FileInputStream(Constants.GLOBAL_PROP_PATH);
			globalProperties.load(gpFIS);

			FileInputStream spFIS = new FileInputStream(Constants.SMOKE_PROP_PATH);
			smokeProperties.load(spFIS);

			FileInputStream rpFIS = new FileInputStream(Constants.REGRESSION_PROP_PATH);
			regressionProperties.load(rpFIS);
		}catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	public void setSmokeData(String key, String value) throws IOException {
		smokeProperties.setProperty(key,value);
		smokeProperties.store(new FileOutputStream(Constants.SMOKE_PROP_PATH),null);
	}
	public String getSmokeData(String td) {
		return (String) smokeProperties.get(td);
	}
	public void setRegressionData(String key, String value) throws IOException {
		regressionProperties.setProperty(key,value);
		regressionProperties.store(new FileOutputStream(Constants.REGRESSION_PROP_PATH),null);
	}
	public String getRegressionData(String td)
	{
		return (String) regressionProperties.get(td);
	}
	public void setGlobalData(String key, String value) throws IOException {
		globalProperties.setProperty(key,value);
		globalProperties.store(new FileOutputStream(Constants.GLOBAL_PROP_PATH),null);
	}
	public String getGlobalData(String td)
	{
		return (String) globalProperties.get(td);
	}

	public void init(String testName, String moduleName) {
		setExecuteListener(true);
		if(Reporter.getCurrentTestResult().getTestContext().getAttribute("session") == null)
			Reporter.getCurrentTestResult().getTestContext().setAttribute("session", this);

		// init reports
		reports = ExtentManager.getReport(Constants.REPORTS_PATH);
		test = reports.createTest(testName).assignCategory(moduleName);
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
