package com.ligl.pages.datamanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.security.spec.ECField;
import java.util.List;

public class DMDataHoldPage extends LiglBaseSessionPage {
    @FindBy(xpath = "//button//span[contains(text(),'IPP - Legal Hold Scope')]")
    WebElement PreservationLHScopeBTN;
    @FindBy(xpath = "//input[@placeholder='Filter...']")
    WebElement Searchbar;
    @FindBy(xpath = "//div[@col-id='CustodianName']//span")
    WebElement CustNameSearchMenu;
    @FindBy(xpath = "//div[@col-id='DataSourceTypeName']//span")
    WebElement DSTSearchManu;
    @FindBy(xpath = "//span[@aria-label='filter']//span[@class='ag-icon ag-icon-filter']")
    WebElement SearchFilter;
    @FindBy(xpath = "//label[contains(text(),'Result(s)')]//strong")
    WebElement ResultsCount;
    @FindBy(xpath = "//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")
    WebElement PreservDataRange;
    @FindBy(xpath = "//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")
    WebElement PreservKeyword;
    @FindBy(xpath = "//span[@class='viewTextPlace']")
    WebElement LHScopePopupText;
    @FindBy(id="btn-cross")
    WebElement ScopPopupCloseBtn;
    @FindBy(xpath = "//div[@col-id='CustodianName']//div[@ref='eCheckbox']//input")
    WebElement CCDCheckBox;
    @FindBy(id="data-hold-action-dropown-data-hold-scope")
    WebElement ActionDropDown;
    @FindBy(xpath = "//div[@col-id='WorkFlowStatusName']//span[@class='ag-icon ag-icon-menu']")
    WebElement LockUnlockStatusHeader;
    @FindBy(id="action-button-id")
    WebElement RunBtn;
    @FindBy(id="btn-yes")
    WebElement LockYesBtn;

    @FindBy(xpath="//a[@class='btnrefresh']")
    WebElement RefreshBtn;
    public ILiglPage goToPreservationLHScope(){
        log_Info("goToPreservationLHScope() Started ");
        PreservationLHScopeBTN.click();
        log_Info("Navigated to Preservation LHSCope tab");
        return new DMDataHoldPage();
    }
    /**
     * Method to Validate Retain Record availability and features like color(Red), Approval Status not initiated and it should be with latest LHScope
     * @param CustName
     * @param DST
     * @param LockCompleteStatus
     * @param LockNotInitiateStatus
     * @param PreviuosLHLDR
     * @param PreviuosLHLKW
     * @param LatestLHLDR
     * @param LatestLHLKW
     * @return
     * @throws Exception
     */
    public ILiglPage checkingRetainRecordAddedPrevGrid(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String PreviuosLHLDR,String PreviuosLHLKW,String LatestLHLDR,String LatestLHLKW)throws Exception{
        try{
            log_Info("checkingRetainRecordAddedPrevGrid() Started");
            Thread.sleep(5000);
            searchCCDWithCustNameAndDSName(CustName,DST);

            String Previouscount=getSession().getRegressionData("PreservationResultsCount");
            int Previouscount1=Integer.parseInt(Previouscount);

            checkResultsCount();

            String LatestCount=getSession().getRegressionData("PreservationResultsCount");
            int LatestCount1=Integer.parseInt(LatestCount);
            if(Previouscount1+1 ==LatestCount1){
                log_Info("Retain Record Added to Presrvation Grid");
            }else
                throw new Exception("Retain Record not Added After Changing LH Scope");

            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));

            for (int j = 0; j < listItem.size(); j++) {
                String colorProp = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//span[@class='ellipsisAgGrid']/ancestor::div[@role='row']")).getAttribute("style");
                        if(colorProp.contains("color: rgb(179, 0, 0)")){
                            log_Pass("Retain Record is Populated in RED Color");
                           String lockStatus= getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();
                            if (LockNotInitiateStatus.equalsIgnoreCase(lockStatus)){
                                log_Pass("Added Retain Record is in 'Not Intitiated' State");
                            }
                            else {
                                log_Error("");
                                throw new Exception("Retain Record is not in 'Not Intiated State'");
                            }
                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).click();
                            for (int i = 0; i < 12; i++) {
                                Actions ac = new Actions(getCurrentDriver());
                                ac.sendKeys(Keys.TAB).perform();
                            }
                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")).click();
                            String LHLDR=LHScopePopupText.getText();
                            if(LHLDR.contains(LatestLHLDR)){
                                log_Pass("Retain Record is Populated with Latest LH LDR as Expected");
                            }
                            else {
                                log_Error("");
                                throw new Exception("Retain Record is not populated with Latest LH LDR ");
                            }
                            ScopPopupCloseBtn.click();
                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")).click();

                            String LHLKW=LHScopePopupText.getText();
                            if(LHLKW.contains(LatestLHLKW)){
                                log_Pass("Retain Record is Populated with Latest LH LKW as Expected");
                            }
                            else {
                                log_Error("");
                                throw new Exception("Retain Record is not populated with Latest LH LKW ");
                            }
                            ScopPopupCloseBtn.click();
                            for (int i = 0; i < 16; i++) {
                                Actions ac = new Actions(getCurrentDriver());
                                ac.sendKeys(Keys.ARROW_LEFT).perform();
                            }
                        }
                        else{
                            String lockStatus= getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();

                            if (LockCompleteStatus.equalsIgnoreCase(lockStatus)){
                                log_Pass("Existing Record is in 'Lock Completed' State");
                            }
                            else{
                                log_Error("");
                                throw new Exception("Existing Record status is changes to 'Not Intiated State'");
                            }
                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).click();
                            for (int i = 0; i < 12; i++) {
                                Actions ac = new Actions(getCurrentDriver());
                                ac.sendKeys(Keys.TAB).perform();
                            }
                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")).click();

                            String LHLDR=LHScopePopupText.getText();
                            if(LHLDR.contains(PreviuosLHLDR)){
                                log_Pass("Existing Record is Remain with Previous LH LDR as Expected");
                            }
                            else {
                                log_Error("");
                                throw new Exception("Existing Record is not populated with Previous LH LDR ");
                            }
                            ScopPopupCloseBtn.click();

                            getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")).click();
                            String LHLKW=LHScopePopupText.getText();
                            if(LHLKW.contains(PreviuosLHLKW)){
                                log_Pass("Existing Record is Remain with Previous LH LKW as Expected");
                            }
                            else {
                                log_Error("");
                                throw new Exception("Existing Record is not populated with Previous LH LKW ");
                            }
                            ScopPopupCloseBtn.click();
                            for (int i = 0; i < 16; i++) {
                                Actions ac = new Actions(getCurrentDriver());
                                ac.sendKeys(Keys.ARROW_LEFT).perform();
                            }
                        }
            }

            LockUnlockStatusHeader.click();
            Thread.sleep(3000);
            try {
                if(Searchbar.isDisplayed()) {
                    Searchbar.clear();
                    Searchbar.sendKeys(LockNotInitiateStatus);
                }
                Thread.sleep(3000);
            }catch(Exception ex){

                SearchFilter.click();
                Searchbar.sendKeys(LockNotInitiateStatus);
                Thread.sleep(3000);
            }
            initiateLock("Lock");

            return new DMDataHoldPage();
        }catch(Exception ex){
            log_Error("checkingRetainRecordAddedPrevGrid() is Failed");
            throw new Exception("Exception in checkingRetainRecordAddedPrevGrid()",ex);
        }
    }
    public ILiglPage initiateLock(String Action)throws Exception{
        try{
            log_Info("initiateLock() Started");
            CCDCheckBox.click();
            ActionDropDown.click();
            getCurrentDriver().findElement(By.xpath("//option[contains(text(),'"+Action+"')]")).click();
            RunBtn.click();
            Thread.sleep(3000);
            LockYesBtn.click();

            return new DMDataHoldPage();
        }catch (Exception ex){
            log_Error("initiateLock() is Failed");
            throw new Exception("Exception in initiateLock()");
        }
    }

    public ILiglPage searchCCDWithCustNameAndDSName(String CustName,String DST)throws Exception{
        try{
            CustNameSearchMenu.click();
            Thread.sleep(3000);
            try {
                if(Searchbar.isDisplayed()) {
                    Searchbar.clear();
                    Searchbar.sendKeys(CustName);
                }
                Thread.sleep(3000);
            }catch(Exception ex){

                SearchFilter.click();
                Searchbar.sendKeys(CustName);
                Thread.sleep(3000);
            }
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'Preservation')]")).click();
            DSTSearchManu.click();

            Thread.sleep(3000);
            try {
                if(Searchbar.isDisplayed()) {
                    Searchbar.clear();
                    Searchbar.sendKeys(DST);
                }
                Thread.sleep(3000);
            }catch(Exception ex){

                SearchFilter.click();
                Searchbar.sendKeys(DST);
                Thread.sleep(3000);
            }
            return new DMDataHoldPage();
        }catch(Exception ex){
            log_Error("searchCCDWithCustNameAndDSName() is Failed");
            throw new Exception("Exception in searchCCDWithCustNameAndDSName()",ex);
        }
    }
    public ILiglPage checkResultsCount()throws Exception{
        try{
            log_Info("checkResultsCount() is Started");
            String count=ResultsCount.getText();
            log_Info("Results Count is Fetched");
            getSession().setRegressionData("PreservationResultsCount", count);
            return new DMDataHoldPage();
        }catch(Exception ex){
            log_Error("checkResultsCount() is Failed");
            throw new Exception("Exception in checkResultsCount()",ex);
        }
    }
    public ILiglPage checkingRetainRecordAddedPrevGrid(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String ExpectedLHLDR,String ExpectedLHLKW)throws Exception{
        try{
            log_Info("checkingRetainRecordAddedPrevGrid() Started");

            searchCCDWithCustNameAndDSName(CustName,DST);

            String Previouscount=getSession().getGlobalData("PreservationResultsCount");
            int Previouscount1=Integer.parseInt(Previouscount);

            checkResultsCount();

            String LatestCount=getSession().getGlobalData("PreservationResultsCount");
            int LatestCount1=Integer.parseInt(LatestCount);
            if(Previouscount1+1 ==LatestCount1){
                log_Info("Retain Record Added to Presrvation Grid");
            }else
                throw new Exception("Retain Record not Added After Changing LH Scope");

            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));

            for (int j = 0; j < listItem.size(); j++) {
                String colorProp = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//span[@class='ellipsisAgGrid']/ancestor::div[@role='row']")).getAttribute("style");
                if(colorProp.contains("color: rgb(179, 0, 0)")){
                    log_Pass("Retain Record is Populated in RED Color");
                    String lockStatus= getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();
                    if (LockNotInitiateStatus.equalsIgnoreCase(lockStatus)){
                        log_Pass("Added Retain Record is in 'Not Intitiated' State");
                    }
                    else {
                        log_Error("");
                        throw new Exception("Retain Record is not in 'Not Intiated State'");
                    }
                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.TAB).perform();
                    }
                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")).click();
                    String LHLDR=LHScopePopupText.getText();
                    if(LHLDR.contains(ExpectedLHLDR)){
                        log_Pass("Retain Record is Populated with Latest LH LDR as Expected");
                    }
                    ScopPopupCloseBtn.click();

                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")).click();
                    String LHLKW=LHScopePopupText.getText();
                    if(LHLKW.contains(ExpectedLHLKW)){
                        log_Pass("Retain Record is Populated with Latest LH LKW as Expected");
                    }
                    ScopPopupCloseBtn.click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.ARROW_LEFT).perform();
                    }
                }
                else{
                    String lockStatus= getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();

                    if (LockCompleteStatus.equalsIgnoreCase(lockStatus)){
                        log_Pass("Existing Record is in 'Lock Completed' State");
                    }
                    else{
                        log_Error("");
                        throw new Exception("Existing Record status is changes to 'Not Intiated State'");
                    }
                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']["+(j+1)+"]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.TAB).perform();
                    }
                    PreservDataRange.click();
                    String LHLDR=LHScopePopupText.getText();
                    if(LHLDR.contains(ExpectedLHLDR)){
                        log_Pass("Existing Record is Remain with Previous LH LDR as Expected");
                    }
                    ScopPopupCloseBtn.click();

                    PreservKeyword.click();
                    String LHLKW=LHScopePopupText.getText();
                    if(LHLKW.contains(ExpectedLHLKW)){
                        log_Pass("Existing Record is Remain with Previous LH LKW as Expected");
                    }
                    ScopPopupCloseBtn.click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.ARROW_LEFT).perform();
                    }
                }
            }

            return new DMDataHoldPage();
        }catch(Exception ex){
            log_Error("checkingRetainRecordAddedPrevGrid() is Failed");
            throw new Exception("Exception in checkingRetainRecordAddedPrevGrid()",ex);
        }
    }
    public ILiglPage initiateLock()throws Exception{
        try{
            log_Info("initiateLock() Started");
            CCDCheckBox.click();
            ActionDropDown.click();
            getCurrentDriver().findElement(By.xpath("//option[contains(text(),'Lock')]")).click();
            RunBtn.click();
            Thread.sleep(3000);
            LockYesBtn.click();

            return new DMDataHoldPage();
        }catch (Exception ex){
            log_Error("initiateLock() is Failed");
            throw new Exception("Exception in initiateLock()");
        }
    }

    public ILiglPage checkingSingleCCDRecordIsReplacedWithLatestFilters(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String ExpectedLHLDR,String ExpectedLHLKW)throws Exception{
        try{
            log_Info("checkingSingleCCDRecordIsReplacedWithLatestFilters() Started");
            log_Info("Started searching for CCD record in Preservation LH Scope grid");
            searchCCDWithCustNameAndDSName(CustName,DST);
            log_Info("Storing the previous grid results count to compare with latest grid results count");
            String PreviousCount=getSession().getRegressionData("PreservationResultsCount");
            int PreviousCount1=Integer.parseInt(PreviousCount);
            log_Info("Started checking latest grid results count");
            checkResultsCount();
            log_Info("Started comparing Previous grid results count & Latest grid results count");
            String LatestCount=getSession().getRegressionData("PreservationResultsCount");
            int LatestCount1=Integer.parseInt(LatestCount);
            if(PreviousCount1 ==LatestCount1)
            {
                log_Pass("Record is Replaced in Preservation LH Scope Grid");
            }
            else
                throw new Exception("Record is not Replaced in Preservation LH Scope Grid");

            WebElement test = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']"));
            List<WebElement> listItem = test.findElements(By.xpath("div[@role='row']"));

                String colorProp = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//span[@class='ellipsisAgGrid']/ancestor::div[@role='row']")).getAttribute("style");
                if(colorProp.contains("color: rgb(179, 0, 0)")){
                    log_Pass("Replaced Record is Populated in RED Color in Preservation LH Scope grid");
                    String lockStatus= getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();
                    if (LockNotInitiateStatus.equalsIgnoreCase(lockStatus)){
                        log_Pass("Replaced Record is in 'Not Initiated' State in Preservation LH Scope Grid");
                    }
                    else {
                        log_Error("Replaced Record is not in 'Not Initiated' State in Preservation LH Scope Grid");
                        throw new Exception("Replaced Record is not in 'Not Initiated' State in Preservation LH Scope Grid");
                    }
                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.ARROW_RIGHT).perform();
                    }
                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='DateRangeName']//span[@class='ellipsistextoverflow' and @title='LDR']")).click();
                    String LHLDR=LHScopePopupText.getText();
                    if(LHLDR.contains(ExpectedLHLDR)){
                        log_Pass("Replaced Record is Populated with Latest LH LDR as Expected");
                    }
                    else
                        throw new Exception("Replaced Record is not Populated with Latest LH LDR as Expected");
                    ScopPopupCloseBtn.click();

                    getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row']//div[@col-id='KeyWordName']//span[@class='ellipsistextoverflow' and @title='LKW']")).click();
                    String LHLKW=LHScopePopupText.getText();
                    if(LHLKW.contains(ExpectedLHLKW)){
                        log_Pass("Replaced Record is Populated with Latest LH LKW as Expected");
                    }
                    else
                        throw new Exception("Replaced Record is not Populated with Latest LH LKW as Expected");
                    ScopPopupCloseBtn.click();
                    for (int i = 0; i < 16; i++) {
                        Actions ac = new Actions(getCurrentDriver());
                        ac.sendKeys(Keys.ARROW_LEFT).perform();
                    }
                    log_Info("Lock is going to be initiated for Replaced CCD in Preservation LH Scope grid");
                    initiateLock();
                    log_Info(" CCD is moving from Lock InQueue-->InProgress state");

                    for (int i = 1; i <= 200; i++) {

                        try {

                            Thread.sleep(30000);
                            for (int j = 0; j < listItem.size(); j++)
                            {
                                String actualValue = getCurrentDriver().findElement(By.xpath("//div[@ref='eCenterContainer']//div[@role='row'][" + (j + 1) + "]//div[@col-id='WorkFlowStatusName']//span[@class='ellipsisAgGrid']")).getText();

                                if (actualValue.equalsIgnoreCase(LockCompleteStatus)) {
                                    log_Pass("Lock completed for Replaced CCD");
                                    return new DMDataHoldPage();
                                }
                                if (actualValue.contains("Failed")) {
                                    log_Error("Lock failed for Replaced CCD");
                                    throw new Exception("Lock failed for Replaced CCD");
                                }
                                RefreshBtn.click();
                            }



                        } catch (Exception e) {
                            log_Error("Lock Status is not fetched");

                        }

                    }
                }

            return new DMDataHoldPage();
                    }
        catch(Exception ex){
            log_Error("checkingSingleCCDRecordIsReplacedWithLatestFilters() is Failed");
            throw new Exception("Exception in checkingSingleCCDRecordIsReplacedWithLatestFilters()",ex);
        }
    }

}
