package com.ligl.base.pages;

import com.ligl.pages.Header;
import com.ligl.pages.LeftMenu;
import com.ligl.session.LiglTestSession;
import com.ligl.web.IWebConnector;

import java.util.Hashtable;

public interface ILiglPage {
	// normal browser operations
	ILiglPage openBrowser(String browser);
    void quit();
    LiglTestSession getSession();

    // Ligl Normal Pages methods
    ILiglPage navigateURL();
    ILiglPage submitUsername(String userid);
    ILiglPage submitPassword(String userid);
    IWebConnector validator(boolean flagAssertionType);

    ILiglPage validateAdminRole() throws Exception;
    ILiglPage login(String userName, String password) throws Exception;
    ILiglPage adminLogin(String userName, String password, String entity) throws Exception;
    ILiglPage navigateSSOLoginPage();
    ILiglPage SSOLogin(String userName, String password) throws InterruptedException;
    ILiglPage selectEntity(String entity);
    ILiglPage createNewCase(Hashtable<String,String> data);
    ILiglPage clickClearFilterBtn();
    // Ligl - session pages
    ILiglPage logout();
    void log_Info(String message);
    void log_Pass(String message);
    void log_Error(String message);
    ILiglPage validateIntermediatePageOptions();
    Header getHeader();
    LeftMenu getLeftMenu();
    void selectDateFromCalendar(String date);
    ILiglPage goToDefaultLandingPage();

}
