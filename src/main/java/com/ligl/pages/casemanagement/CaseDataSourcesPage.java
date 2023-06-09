package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;

public class CaseDataSourcesPage extends LiglBaseSessionPage {

    @FindBy(id = "data-sources-save-btn")
    WebElement SaveBtn;

    @FindBy(xpath = "//span[@title='Case Management']")
    WebElement CaseManage;
    @FindBy(id = "edit-btn")
    WebElement Edit;

    @FindBy(xpath = "//h1[contains(text(),'Select Data Source(s)')]")
    WebElement DSHeading;
    @FindBy(id = "On-Prem-button")
    WebElement OnpremDS;


    public ILiglPage addDataSources(String DataSource1) throws Exception {

        try {
            log_Info("addDataSources() Started");
            log_Info("Click on checkbox");
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[text()='"+DataSource1+"']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on checkbox");
            Thread.sleep(2000);
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");
            return new CaseDataSourcesPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("addDataSources() Failed",ex);
        }
    }

    /**
     * Method to Edit the Data Sources
     * @param DataSource1
     * @param DataSource2
     * @return
     * @throws Exception
     */
    public ILiglPage editDataSources(String DataSource1,String DataSource2) throws Exception {
        try {
            log_Info("editDataSources() Started");
            log_Info("check element available");
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", Edit);
            Edit.isDisplayed();
            Edit.isEnabled();
            log_Info("Click on edit button");
            Thread.sleep(3000);
            Edit.click();
            ((JavascriptExecutor)getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", getCurrentDriver().findElement(By.id("Cloud-button")));
            Thread.sleep(3000);
            getCurrentDriver().findElement(By.xpath("//div[text()='"+DataSource2+"']//../..//div[@class='sourceChkbxDiv']")).click();
            String isChecked =getCurrentDriver().findElement(By.xpath("//div[text()='"+DataSource1+"']//../..//div[@class='sourceChkbxDiv']//input")).getAttribute("aria-checked");
            System.out.println(isChecked);
            Thread.sleep(3000);
            Assert.assertEquals("true" , isChecked);
            /*if(*//*Assert.assertEquals("true" , isChecked))
                log_Info("Previously Selected DataSources are not unchecking");
            else
                log_Info("Previously Selected DataSources are unchecking");*/
            SaveBtn.click();
            return new CaseDataSourcesPage();
        }
        catch (Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("EditDataSource Failed");
        }
    }


    public ILiglPage addOnpremDataSource(String DataSource)throws Exception{
        try{
            log_Info("addOnpremDataSource() Started");
            OnpremDS.click();
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Data Source is selected");
            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            return new CaseDataSourcesPage();
        }catch (Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("addOnpremDataSource() Failed", ex);
        }
    }

    public ILiglPage addDataSource(String DataSource) throws Exception {

        try {
            log_Info("addDataSources() Started");
            log_Info("Click on checkbox");
            //getDriver().waitForelementToBeClickable(Gmail);
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[text()='" + DataSource + "']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on checkbox");
            Thread.sleep(2000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DSHeading);

            return new CaseDataSourcesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addDataSources() Failed", ex);
        }
    }

    // Adding DataSource To The Selected Custodian - ReUsable Method

    public ILiglPage addingDataSource(String DataSource) throws Exception {

        try {

            log_Info("addingDataSource() Started");
            log_Info("Click on checkbox");
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[text()='"+ DataSource +"']//../..//div[@class='sourceChkbxDiv']")).click();
            log_Info("Clicked on checkbox");
            Thread.sleep(2000);
            return new CaseDataSourcesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("addingDataSource() Failed", ex);
        }
    }
    public ILiglPage multipleDataSourceSelect(Hashtable<String, String> data)throws Exception{
        try{
            log_Info("Started multipleDataSourceSelect()");
            Thread.sleep(3000);
           if(data.get("O365_Sharepoint_RunState").equals("Y"))
                addingDataSource(data.get("O365_Sharepoint_DataSource"));
            if(data.get("O365_Exchange_RunState").equals("Y"))
                addingDataSource(data.get("O365_Exchange_DataSource"));
            if(data.get("OneDrive_RunState").equals("Y"))
                addingDataSource(data.get("OneDrive_DataSource"));
            if(data.get("MS_Teams_RunState").equals("Y"))
                addingDataSource(data.get("MS_Teams_DataSource"));

            if(data.get("Hangouts_Chat_RunState").equals("Y"))
                addingDataSource(data.get("Hangouts_Chat_DataSource"));
            if(data.get("GMail_RunState").equals("Y"))
                addingDataSource(data.get("GMail_DataSource"));
            if(data.get("GDrive_RunState").equals("Y"))
                addingDataSource(data.get("GDrive_DataSource"));
            if(data.get("Google_Chat_RunState").equals("Y"))
                addingDataSource(data.get("Google_Chat_DataSource"));

            if(data.get("Dropbox_RunState").equals("Y"))
                addingDataSource(data.get("Dropbox_DataSource"));
            if(data.get("Box_RunState").equals("Y"))
                addingDataSource(data.get("Box_DataSource"));
            if(data.get("Proofpoint_RunState").equals("Y"))
                addingDataSource(data.get("Proofpoint_DataSource"));
            if(data.get("Zoom_Video_RunState").equals("Y"))
                addingDataSource(data.get("Zoom_Video_DataSource"));

            if(data.get("Zoom_Chat_RunState").equals("Y"))
                addingDataSource(data.get("Zoom_Chat_DataSource"));
            if(data.get("Onna_RunState").equals("Y"))
                addingDataSource(data.get("Onna_DataSource"));
            if(data.get("Slack_RunState").equals("Y"))
                addingDataSource(data.get("Slack_DataSource"));

            clickOnSaveButton();
            return new CaseDataSourcesPage();
        }catch(Exception ex){
            log_Error(ex.getMessage());
            throw new Exception("multipleDataSourceSelect() Failed", ex);
        }
    }

    public ILiglPage clickOnSaveButton() throws Exception {

        try {

            log_Info("clickOnSaveButton() Started");
            Thread.sleep(5000);
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView();", SaveBtn);
            log_Info("Click on SaveBtn");
            getDriver().waitForelementToBeClickable(SaveBtn);
            SaveBtn.click();
            Thread.sleep(2000);
            log_Info("Clicked on SaveBtn");
            getSession().log_Pass("Added DataSources To Case ");
            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", DSHeading);
            return new CaseDataSourcesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("clickOnSaveButton() Failed", ex);
        }

    }
}
