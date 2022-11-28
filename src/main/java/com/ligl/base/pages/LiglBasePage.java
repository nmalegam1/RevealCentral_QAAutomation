package com.ligl.base.pages;

import com.ligl.pages.DashboardPage;
import com.ligl.pages.LeftMenu;
import com.ligl.session.LiglTestSession;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.ligl.pages.Header;
import com.ligl.web.IWebConnector;

import java.util.Hashtable;

public class LiglBasePage implements ILiglPage {

	public LiglBasePage() {
		//System.out.println("----------LiglBasePage Consructor-------");
		PageFactory.initElements(getCurrentDriver(), this);
		// set the page in the session
		getSession().setCurrentPage(this);
	}

	public ILiglPage openBrowser(String browser) {
		System.out.println("LiglBasePage openBrowser");
		return null;
	}

	public void quit() {
		// TODO Auto-generated method stub
	}

	public ILiglPage navigateURL() {
		return null;
	}

	public ILiglPage submitUsername(String userid) {
		return null;
		
	}
	public ILiglPage submitPassword(String userid) {
		return null;
	}

	public IWebConnector validator(boolean stopExecution) {
		   // update the flag in web layer
		    getSession().getCon().setStopExecution(stopExecution);
			return getSession().getCon();
	}

	public ILiglPage logout() {
		return null;
	}

	public ILiglPage login(String userName, String password) throws Exception {
		return null;
	}

	public ILiglPage adminLogin(String userName, String password, String entity) throws Exception{return null;}
	public ILiglPage validateAdminRole() throws Exception {return null;}
	public ILiglPage createNewCase(Hashtable<String,String> data){
		return null;
	}

	public ILiglPage navigateSSOLoginPage(){
		return null;
	}
	public ILiglPage SSOLogin(String userName, String password) throws InterruptedException {
		return null;
	}
	
	public LiglTestSession getSession() {
		return (LiglTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}
	
	public IWebConnector getDriver() {
		return getSession().getCon();
	}
	
	public EventFiringWebDriver getCurrentDriver() {
		return getSession().getCon().getCurrentDriver();
	}
	
	public void log_Info(String message) {
		getSession().log_Info(message);
	}

	public void log_Pass(String message) {
		getSession().log_Pass(message);
	}

	public void log_Error(String message) {
		getSession().log_Error(message);
	}
	public ILiglPage validateIntermediatePageOptions() {
		return null;
	}
	public ILiglPage goToDefaultLandingPage() {
		return null;
	}
	public ILiglPage goToAboutPage() {
		return null;
	}
	public ILiglPage selectEntity(String entity){return null;}
	public ILiglPage clickClearFilterBtn() {
		return null;
	}
	public Header getHeader() {
		return null;
	}
	public LeftMenu getLeftMenu() {
		return null;
	}
    
    public void selectDateFromCalendar(String date) {
    }

	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
		int i=1;
		// check for pageload 100% - 20 secs
		while(i!=10){
		String state = (String)js.executeScript("return document.readyState;");
		System.out.println(state);

		if(state.equals("complete"))
			break;
		else
			wait(2);

		i++;
		}
		// check for jquery/ajax status - 20 secs
		i=1;
		while(i!=10){
	
			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
			 	break;
			else
				 wait(2);
			 i++;
				
			}
		
		}
	
	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
