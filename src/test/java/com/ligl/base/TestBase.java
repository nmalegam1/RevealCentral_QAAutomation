package com.ligl.base;

import com.ligl.base.pages.Constants;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.ligl.session.LiglTestSession;
import com.ligl.util.Xls_Reader;

public class TestBase {
	
	public LiglTestSession session;
	public String testName=null;
	String testDataSheet=Constants.TEST_DATA_SHEET;
	public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//"+ testDataSheet +".xlsx");
	//public Xls_Reader xls = new Xls_Reader(System.getProperty("user.dir")+"//TestData.xlsx");
	
	@BeforeMethod
	public void init(ITestResult result) {
		System.out.println("@BeforeMethod");
		testName = result.getMethod().getMethodName().toUpperCase();
		System.out.println(testName);
		session= new LiglTestSession();
		session.init(testName);
	}
	
	@AfterMethod
	public void quit() {
		session.generateReport();
	}
	
}
