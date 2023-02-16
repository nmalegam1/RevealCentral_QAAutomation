package com.ligl.pages.processmanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import com.ligl.pages.datamanagement.DMCollectionsPage;
import com.ligl.pages.datamanagement.DMSummaryPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class PMSummaryPage extends LiglBaseSessionPage {


    @FindBy(xpath = "//span[contains(text(),'Group')]")
    WebElement GroupHeader;

    @FindBy(xpath = "//a[@id='refresh']")
    WebElement RefreshBtn;

    @FindBy(xpath = "//h1[contains(text(),'Process Management Summary')]")
    WebElement Header;

    @FindBy(xpath = "//ag-grid-angular//div[@ref='eCenterContainer']//span[contains(text(),'Hosting Completed')]")
    WebElement HostingComStatus;




    // Validate And Wait For Records To Complete Processing (NUIX / RELATIVITY)

    public ILiglPage validateAndWaitForRecordsToCompleteProcessing(String Processingstatus)throws Exception{

        try{

            log_Info("validateAndWaitForRecordsToCompleteProcessing() Started");
            Thread.sleep(5000);
            GroupHeader.click();

            for (int i = 0; i < 16; i++) {
                Actions ac = new Actions(getCurrentDriver());
                ac.sendKeys(Keys.TAB).perform();
            }

            int y = 0;
            int z = 0;

            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));

            Outer:


            for (int i = 1; i <= 90; i++) {

                try {

                    Thread.sleep(30000);


                    for (int j = 0; j < listItem.size(); j++) {
                        String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatus']//span[@class='ellipsisAgGrid']")).getText();

                        if (actualValue.equalsIgnoreCase(Processingstatus)) {

                            y++;

                        }

                        else if (actualValue.contains("Failed")) {
                            y++;
                            z++;
                        }


                        else if(listItem.size() == y){
                            getSession().takeScreenShot();
                            break Outer;

                        }

                    }

                    z=0;
                    y=0;


                    RefreshBtn.click();

                } catch (Exception e) {

                }

            }

            if (z==listItem.size()) {
                getSession().takeScreenShot();
                return new PMSummaryPage();

            }
            return new PMHostingPage();
        }catch (Exception ex){
            log_Error("validateAndWaitForRecordsToCompleteProcessing() Failed");
            throw new Exception("validateAndWaitForRecordsToCompleteProcessing() Failed",ex);
        }
    }
}


















