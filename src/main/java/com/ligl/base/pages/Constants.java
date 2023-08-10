package com.ligl.base.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.support.How;


public class Constants {
	public static final String GRIDRUN = "N";

	public static final String ID="id";
	public static final String NAME="name";
	public static final String XPATH="XPATH";
	public static final String CSS="CSS";

	public static final String DATE_MONTH_YEAR = "span.sCalMon";
	public static final By DATE_MONTH_YEAR_LOCATOR=By.cssSelector(DATE_MONTH_YEAR);
	
	public static final String DATE_MONTH_FORWARD = "span.calNav.dRgt";
	public static final By DATE_MONTH_FORWARD_LOCATOR=By.cssSelector(DATE_MONTH_FORWARD);
	
	public static final String DATE_MONTH_BACKWARD = "span.calNav.dLft";
	public static final By DATE_MONTH_BACKWARD_LOCATOR=By.cssSelector(DATE_MONTH_BACKWARD);

	// titles
	public static final String HOME_PAGE_TITLE = "Cases | Ligl";
	
	// report path
	public static final String REPORTS_PATH = System.getProperty("user.dir")+"//reports//";
	public static final How CSS_SEL = How.CSS;

	//properties path
	public static final String GLOBAL_PROP_PATH=System.getProperty("user.dir") + "\\src\\test\\resources\\global.properties";
	public static final String SMOKE_PROP_PATH=System.getProperty("user.dir") + "\\src\\test\\resources\\smoke.properties";
	public static final String REGRESSION_PROP_PATH=System.getProperty("user.dir") + "\\src\\test\\resources\\regression.properties";

	// sheet names
	public static final String TEST_DATA_SHEET = "TestData";
	public static final String TEST_STATUS_SHEET = "TestStatus";
	
	//col names
	public static final Object COL_SUBJECT = "Subject";
	public static final Object COL_DATE = "Date";
	public static final String TCID = "TCID";
	public static final String RUNMODE = "Runmode";

	//TestRail
	public static String testRail_RunId="6110";
	public static String testRail_UserName="test@revealdata.com";
	public static String testRail_Password="Password1!";
	public static String testRailEngineURL="https://brainspace.testrail.net/";
	public static int testRailStatus_Pass=1;
	public static int testRailStatus_Fail=5;
	//Import Employee exel file
	public static final String ImportXLSX_ShortTemplate = System.getProperty("user.dir")+"\\importEmpTemplates\\ImportXLSX_ShortTemplate.xlsx";
	public static final String ImportXLSX_Template_FullTemplate = System.getProperty("user.dir")+"\\importEmpTemplates\\ImportXLSX_Template.xlsx";
	public static final String ImportXLSX_Template_Title_Optional = System.getProperty("user.dir")+"\\importEmpTemplates\\ImportXLSX_Template_Title_Optional.xlsx";
	public static final String ImportXLSX_Template_Only_Mandatory_Field =  System.getProperty("user.dir")+"\\importEmpTemplates\\ImportXLSX_Template_Only_Mandatory_Fields.xlsx";
	public static final String ImportXLSX_Template_AccountType = System.getProperty("user.dir")+"\\importEmpTemplates\\ImportXLSX_Template_AccountType.xlsx";

	//SQL Query
	public static final String EmailTracker_Emp_query = "SELECT TOP 1 * FROM VERTICAL.EMAILTRACKER WHERE TOADDRESS LIKE '%SSIVARAJU@LIGL.IO%' AND SUBJECT LIKE'%SIT-{ENTITY} EMPLOYEE {ACTION} TO LILAC.%'ORDER BY 1 DESC";

	public static final String EmailTracker_UserCreation_query ="SELECT TOP 1 * FROM VERTICAL.EMAILTRACKER WHERE TOADDRESS LIKE '%EmailTracker_001@LIGL.IO%' AND SUBJECT LIKE '%SIT-New User Created through Manual Password for {username}%' ORDER BY 1 DESC";

	public static final String ProjectSpecialChar_ErrorMessage = "Projectname cannot contain Special Characters like ! / @ # $ % ^ *";


}
