package com.ligl.pages;

import com.ligl.base.pages.LiglBasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage extends LiglBasePage {
    String selectedEntity;
    @FindBy(id = "username")
    WebElement userNameTxt;

    @FindBy(id = "password")
    WebElement passwordTxt;

    @FindBy(id = "signin-button")
    WebElement signInBtn;
    //sign-in-with-sso

    @FindBy(id = "sign-in-with-sso")
    WebElement ssoSignInBtn;

    @FindBy(xpath = "//span[@class='error-message custom-label-error']")
    WebElement weakPasswordValidation;

    @FindBy(xpath = "//div[@class='mt-2 pt-2 pl-2 ml-5 custom-label-error pull-left']")
    WebElement validation;

    @Override
    public ILiglPage login(String userName, String password, String Entity) throws Exception {// 20 elements
        try {

            log_Info("Enter User Name");
            getDriver().waitForelementToBeClickable(userNameTxt);
            userNameTxt.sendKeys(userName);
            getSession().log_Pass("user name entered");
            log_Info("Enter Password");
            getDriver().waitForelementToBeClickable(passwordTxt);
            passwordTxt.sendKeys(password);
            log_Pass("password entered");
            signInBtn.click();
            getSession().log_Pass("Clicked signin button");
            Thread.sleep(2000);
            getDriver().waitForAngularRequestsToComplete();

            if (getCurrentDriver().getCurrentUrl().contains("legalentity")) {
                log_Info("EntityPage Loaded");
                System.out.println("Entity : " + Entity);
                if (Entity.contains(Entity)) {
                    getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + Entity + "')]")).click();
                    getDriver().waitUntilSpinnerIsClosed();
                    getDriver().waitForAngularRequestsToComplete();
                    return new DefaultLandingPage();
                }
            }
            return new DefaultLandingPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("login failed", ex);
        }
    }

    @Override
    public ILiglPage adminLogin(String userName, String password, String entity) throws Exception {

        try {


            log_Info("Enter User Name");
            getDriver().waitForelementToBeClickable(userNameTxt);
            userNameTxt.sendKeys(userName);
            getSession().log_Pass("user name entered");
            log_Info("Enter Password");
            //getSession().failTest("failed action");
            getDriver().waitForelementToBeClickable(passwordTxt);
            passwordTxt.sendKeys(password);
            log_Pass("password entered");
            //getSession().log_Pass("password entered");
            //log("Click SignIn button");
            signInBtn.click();
            getSession().log_Pass("Clicked signin button");
            getDriver().waitForAngularRequestsToComplete();
            Thread.sleep(2000);

            if (getCurrentDriver().getCurrentUrl().contains("legalentity")) {
                log_Info("EntityPage Loaded");
                System.out.println("Entity : " + entity);
                if (entity.contains(entity)) {
                    getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + entity + "')]")).click();
                    getDriver().waitForAngularRequestsToComplete();
                    return new DashboardPage();
                }
            } else if (getCurrentDriver().getCurrentUrl().contains("dashboard/caseinsights")) {
                //getDriver().waitForVisibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']"));
                //getDriver().waitForAngularRequestsToComplete();
                log_Info("DashboardPage Loaded");
                return new DashboardPage();
            }
            return new LiglBasePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Admin login failed", ex);
        }
    }

    @Override
    public ILiglPage navigateSSOLoginPage() {// 20 elements
        log_Info("Click SSO Signin button");
        ssoSignInBtn.click();
        getSession().log_Pass("Clicked SSO Signin button");
        //waitForPageToLoad();
        return new SSOLoginPage();
    }

    /**
     * This 'New Login' Method Used only for "No Role Assgined" "Accpect Eula page" and "First time login users password changing"
     */
    public ILiglPage newLogin(String userName, String password) throws Exception {
        try {
            getSession().log_Info("Enter User Name");
            getDriver().waitForelementToBeClickable(userNameTxt);
            userNameTxt.sendKeys(userName);
            getSession().log_Pass("user name entered");
            getSession().log_Info("Enter Password");
            getDriver().waitForelementToBeClickable(passwordTxt);
            passwordTxt.sendKeys(password);
            getSession().log_Pass("password entered");
            getSession().log_Info("Click SignIn button");
            signInBtn.click();
            getDriver().waitForAngularRequestsToComplete();
            getSession().log_Pass("Clicked signin button");
            waitForPageToLoad();
            return new NewUsersLandingPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("new Login Failed", ex);
        }
    }

    public ILiglPage loginPageValidation(String userName, String password) throws Exception {
        try {
            //log("Enter UserName");
            getSession().log_Info("Enter User Name");
            getDriver().waitForelementToBeClickable(userNameTxt);
            userNameTxt.sendKeys(userName);
            getSession().log_Pass("Entered User Name");
            //Weak Password
            getSession().log_Info("Enter Weak Password");
            getDriver().waitForelementToBeClickable(passwordTxt);
            passwordTxt.sendKeys(password);
            getSession().log_Pass("Enter Weak Password");
            try {
                getSession().log_Info("Click on 'Enter' key in KeyBoard");
                passwordTxt.sendKeys(Keys.ENTER);
                getSession().log_Pass("Clicked on 'Enter' key in KeyBoard");
                String validationWkPWD = weakPasswordValidation.getText();


            } catch (Exception as) {
                getSession().log_Info("Click on 'Tab' key in KeyBoard");
                passwordTxt.sendKeys(Keys.TAB);
                getSession().log_Pass("Clicked on 'Tab' key in KeyBoard");

                /*getSession().log_Info("Click on 'Sign In' button");
                getDriver().waitForelementToBeClickable(signInBtn);
                signInBtn.click();
                getDriver().waitForAngularRequestsToComplete();
                getSession().log_Pass("Clicked on SignIn button");*/

            }

            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Login Validation Failed", ex);
        }

    }

    /**
     * TC22508-Check whether Password strength validation is displaying for fields when user enters weak password
     */
    @Override
    public ILiglPage passwordValidation() throws Exception {
        try {
            //Validation
            getSession().log_Info("Check 'Password strength validation' is displaying when user enters weak password");
            wait(1);
            String validationWkPWD = weakPasswordValidation.getText();
            Assert.assertEquals(validationWkPWD, "Password length should be between " +
                    "8 and 15 characters with atleast 1 uppercase, 1 numeric and 1 special character.");
            getSession().log_Pass("'Password strength validation' is displayed");
            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Password Strength Validation Failed", ex);
        }
    }

    public ILiglPage oldPasswordValidation() throws Exception {
        try {
            //Validation
            getSession().log_Info("Check 'Password validation' is displaying when user enter 'old password'");
            wait(1);
            String validationOldPWD = validation.getText();
            Assert.assertEquals(validationOldPWD, "Invalid password");
            getSession().log_Pass("'Invalid Password' validation is displayed when user enter 'old password'");
            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Old Password Validation Failed", ex);
        }
    }

    /**
     * 28581	Users & Roles- Ligl & SSO User- Check that Validation should be displayed in Login page when In-Active status user logs in
     */

    public ILiglPage verifyInActiveUserLoginValidation() throws Exception {
        try {
            getSession().log_Info("Check that 'The User is currently disabled' Validation Displayed");
            wait(1);
            String UserDisabled = validation.getText();
            Assert.assertEquals(UserDisabled, "The User is currently disabled");
            getSession().log_Pass("'The User is currently disabled' Validation Displayed");
            return new LoginPage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("InActive User Login Failed", ex);
        }
    }

    public ILiglPage loginWithLiglorSSOUser(String IsSSOLogin, String ssoUserName, String ssoPassWord, String EntitySelection, String UserName, String PassWord) throws Exception {// 20 elements
        try {

            log_Info("loginWithLiglorSSOUser() Started");

            if (IsSSOLogin.equals("Y")) {

                navigateSSOLoginPage();
                SSOLoginPage sso = new SSOLoginPage();
                sso.SSOLogin(ssoUserName, ssoPassWord, EntitySelection);
            } else {
                login(UserName, PassWord, EntitySelection);
            }
            return new DefaultLandingPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("loginWithLiglorSSOUser() failed", ex);
        }
    }

    @Override
    public ILiglPage RCLogin(String userType, String entity) throws Exception {
        try {
            if (userType.toLowerCase().contentEquals("adminuser")) {
                log_Info("Enter User Name");
                getDriver().waitForelementToBeClickable(userNameTxt);
                userNameTxt.sendKeys(getSession().getGlobalData("Admin_UserName"));
                getSession().log_Pass("user name entered");
                log_Info("Enter Password");
                //getSession().failTest("failed action");
                getDriver().waitForelementToBeClickable(passwordTxt);
                passwordTxt.sendKeys(getSession().getGlobalData("Admin_Password"));
                log_Pass("password entered");
                //getSession().log_Pass("password entered");
                //log("Click SignIn button");
                signInBtn.click();
                getSession().log_Pass("Clicked signin button");
                getDriver().waitForAngularRequestsToComplete();
                Thread.sleep(2000);
                if (getCurrentDriver().getCurrentUrl().contains("legalentity")) {
                    log_Info("EntityPage Loaded");
                    if (entity.toLowerCase().contentEquals("rel"))
                        selectedEntity = getSession().getGlobalData("Rel_Entity");
                    else if (entity.toLowerCase().contentEquals("eur"))
                        selectedEntity = getSession().getGlobalData("EUR_Entity");
                    else if (entity.toLowerCase().contentEquals("custom"))
                        selectedEntity = getSession().getGlobalData("Custom_Entity");
                    System.out.println("Entity : " + selectedEntity);
                    if (entity.contains(entity)) {
                        getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" + selectedEntity + "')]")).click();
                        getDriver().waitForAngularRequestsToComplete();
                        return new DashboardPage();
                    }
                } else if (getCurrentDriver().getCurrentUrl().contains("dashboard/caseinsights")) {
                    //getDriver().waitForVisibilityOfElementLocated(By.xpath("//div[@class='ag-center-cols-container']"));
                    //getDriver().waitForAngularRequestsToComplete();
                    log_Info("DashboardPage Loaded");
                    return new DashboardPage();
                }
            } else if (userType.toLowerCase().contentEquals("ssouser")) {
                navigateSSOLoginPage();
                SSOLoginPage sso = new SSOLoginPage();
                sso.loginWithSSOUser(entity);
                return  new DefaultLandingPage();
            } else if (userType.toLowerCase().contentEquals("superuser")) {
                login(getSession().getGlobalData("Superuser_UserName"), getSession().getGlobalData("Superuser_Password"),getSession().getGlobalData("Custom_Entity"));
                return  new DefaultLandingPage();
            } else {
                log_Error("Invalid user passed in TestData Sheet");
            }
            return new LiglBasePage();
        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("Reveal Central login is failed", ex);
        }
    }
}
