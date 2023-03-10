package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactMasterPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//span[@title='General']")
    WebElement GeneralTab;
    @FindBy(xpath = "//span[@title='Legal Hold']")
    WebElement LegalHoldTab;
    @FindBy(xpath = "//span[@title='Users and Roles']")
    WebElement UsersAndRolesTab;
    @FindBy(xpath = "//span[@title='Employee Master']")
    WebElement EmployeeMasterTab;
    public ILiglPage goToUsersRoles()throws Exception{
        try{
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            UsersAndRolesTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new UsersAndRolesPage();
        }catch (Exception ex){
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()",ex);
        }
    }
    public ILiglPage goToEmployeeMasterpage()throws Exception{
        try{
            log_Info("goToUsersRoles() Started");
            Thread.sleep(3000);
            GeneralTab.click();
            log_Info("General Tab Clicked");
            EmployeeMasterTab.click();
            log_Pass("Navigated to Users and Roles tab");

            return new EmployeeMasterPage();
        }catch (Exception ex){
            log_Error("goToUsersRoles() is Failed");
            throw new Exception("Exception in goToUsersRoles()",ex);
        }
    }
}
