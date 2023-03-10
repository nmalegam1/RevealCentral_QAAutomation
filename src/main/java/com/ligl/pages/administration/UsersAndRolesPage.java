package com.ligl.pages.administration;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;


public class UsersAndRolesPage extends LiglBaseSessionPage {
    @FindBy(id = "add-user-roles-btn")
    WebElement AddUserBtn;
    @FindBy(id="role-sel-input")
    WebElement RolesAssignedDP;
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement RolesDPSearch;
    @FindBy(xpath = "//mat-select[@id='role-sel-input']//span//span")
    WebElement SelectedDPValue;

    /**
     * Method to check the Availability od Custodian Role in Roles Assigned Dropdown in Create role pop up
     * @return
     * @throws Exception
     */
    public ILiglPage checkCustodianRoleInUserCreationPopUp(String Role)throws Exception{
        try{
            log_Info("checkCustodianRoleInUserCreationPopUp() Started");
            AddUserBtn.click();
            Thread.sleep(3000);
            log_Info("Add User button Clicked");
            RolesAssignedDP.click();
            RolesAssignedDP.sendKeys("Custodian");
            Thread.sleep(3000);
            RolesAssignedDP.sendKeys(Keys.ENTER);
            log_Info("Role is selected");
            String RoleVal=SelectedDPValue.getText();
            Assert.assertEquals(RoleVal,Role);
            log_Pass("'"+Role+"' is Present in Roles Assigned DropDown");

            return new UsersAndRolesPage();

        }catch (Exception ex){
            log_Error("checkCustodianRoleInUserCreationPopUp() is Failed");
            throw new Exception("Exception in checkCustodianRoleInUserCreationPopUp()",ex);

        }
    }
}
