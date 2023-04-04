package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.testng.Assert;

public class NotificationsPage extends LiglBaseSessionPage{













    public ILiglPage validateReqAlertInTheNotificationIcon(String request) throws Exception{

        try {

            log_Info("Validate The Request In The Grid");

            Thread.sleep(5000);
            boolean a1 = getCurrentDriver().findElement(By.xpath("//span[contains(text(),'"+request+"')]")).isDisplayed();

            System.out.println(a1);

            Thread.sleep(5000);
            Assert.assertEquals(true, a1);

            return new NotificationsPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateStatusOfTheRequest() Failed ", ex);
        }
    }


    public ILiglPage clickOnTheRequestAlertInTheNotificationIcon(String assignedrequest,String PageTitle) throws Exception {

        try {

            log_Info("clickOnTheRequestAlertInTheNotificationIcon Started");

            getSession().log_Info("click On The Request Message Assigned To You");
            Thread.sleep(5000);
            getCurrentDriver().findElement(By.xpath("//span[contains(text(),'" +assignedrequest+ "')]")).click();
            Thread.sleep(5000);
            getSession().log_Pass("clicked On The Request Message Assigned To You");

            if (getCurrentDriver().getCurrentUrl().contains(PageTitle)) {
                log_Info("Naviagated To "+PageTitle+"Page");
            }
            else {

                throw new Exception("Required Page Not Loaded");
                }
            return  new GlobalRequestPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnTheRequestAlertInTheNotificationIcon() Failed ", ex);
        }
    }
}
