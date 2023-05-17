package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.*;
import com.ligl.pages.datamanagement.DMCollectionsPage;
import com.ligl.pages.datamanagement.DMDSIPage;
import com.ligl.pages.datamanagement.DMDataHoldPage;
import com.ligl.pages.datamanagement.DMSummaryPage;
import com.ligl.pages.processmanagement.PMSummaryPage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LeftMenu extends LiglBasePage {

    @FindBy(xpath = "//span[contains(text(),'Project Management')]/ancestor::li//span[contains(text(),'Summary')]")
    public WebElement caseManagementSummaryLink;

    @FindBy(xpath = "//span[contains(text(),'Project Management')]")
    public WebElement caseManagementLink;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]")
    public WebElement CounselLink;

    @FindBy(xpath = "//li[@id='Requests']")
    WebElement Requests;

    @FindBy(xpath = "//span[contains(text(),'Security')]")
    WebElement SecurityLink;

    // Left Menu web elements

    @FindBy(xpath = "//span[@title='Project Management']")
    WebElement CaseManage;

    @FindBy(xpath = "//span[@title='Legal Hold']")
    WebElement LegalHoldBtn;

    @FindBy(xpath = "//span[@title='Scope']")
    WebElement Scope;

    @FindBy(xpath = "//span[@title='Custodians']")
    WebElement CaseCust;

    @FindBy(xpath = "//span[@title='Data Sources']")
    WebElement DataSources;

    @FindBy(xpath = "//span[@title='Counsel']")
    WebElement Counsel;

    @FindBy(xpath = "//span[@title='Date Ranges']")
    WebElement DateRanges;

    @FindBy(xpath = "//span[@title='Other Party']")
    WebElement OtherParty;

    @FindBy(xpath = "//span[@title='Court']")
    WebElement Court;

    @FindBy(xpath = "//span[@title='Keywords']")
    WebElement Keywords;

    @FindBy(css="span[title='Documents']")
    WebElement Documents;

    @FindBy(xpath = "//span[@title='Data Management']")
    WebElement DataManagement;

    @FindBy(xpath = "//span[@title='Identification']")
    WebElement Identification;

    @FindBy(xpath = "//span[@title='Preservation']")
    WebElement Preservation;

    @FindBy(xpath = "//span[@title='Process Management']")
    WebElement ProcessManagement;

    @FindBy(xpath = "//span[@title='Documents']")
    WebElement CaseDocument;

    @FindBy(xpath = "//span[@title='History']")
    WebElement History;
    @FindBy(id="Collection")
    WebElement Collection;

    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public ILiglPage navigateToLegalHoldPage() {
        LegalHoldBtn.click();
        return new LegalHoldPage();
    }

    public ILiglPage goToDSIPage() throws Exception {

        try {

            try{
            if(DataManagement.isDisplayed()) {
                log_Info("Click on Data Management");
                getDriver().waitForelementToBeClickable(DataManagement);
                Thread.sleep(5000);
                DataManagement.click();
                getSession().log_Pass("Clicked on Data Management");

                log_Info("Click on Identification");
                getDriver().waitForelementToBeClickable(Identification);
                Identification.click();
                Thread.sleep(5000);
                getSession().log_Pass("Clicked on Identification");
            }}
            catch (Exception ex){
                ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", LegalHoldBtn);
                log_Info("Click on Data Management");
                getDriver().waitForelementToBeClickable(DataManagement);
                Thread.sleep(5000);
                DataManagement.click();
                getSession().log_Pass("Clicked on Data Management");

                log_Info("Click on Identification");
                getDriver().waitForelementToBeClickable(Identification);
                Identification.click();
                Thread.sleep(5000);
                getSession().log_Pass("Clicked on Identification");

            }

            return new DMDSIPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToDSIPage() Failed ", ex);
        }
    }

    /**
     * Method to Go to CaseDocumentsPage
     * @return CaseDocumentsPage()
     * @throws InterruptedException
     */
    public ILiglPage navigateToCaseDocumentsPage() throws InterruptedException {
        getSession().log_Info("Click on Project Management");
        getDriver().waitForelementToBeClickable(CaseManage);
        CaseManage.click();
        log_Pass("Project Management clicked");
        Thread.sleep(3000);
        log_Info("Click Documents");
        Documents.click();
        log_Pass("Documents tab Clicked");
        Thread.sleep(3000);
        return new CaseDocumentsPage();
    }
    public ILiglPage goToCaseManagementSummary() throws InterruptedException {
        caseManagementSummaryLink.click();
        return new CaseSummaryPage();
    }

    public ILiglPage goToCaseManagement() throws InterruptedException {
        CaseManage.click();
        return new CaseSummaryPage();
    }

    public ILiglPage goToSecurityPage() throws InterruptedException {
        Thread.sleep(8000);
        ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", SecurityLink);
        SecurityLink.click();
        return new SecurityPage();
    }

    public ILiglPage goToCaseCounselPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    CaseManage.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Counsel");
                    getDriver().waitForelementToBeClickable(Counsel);
                    Thread.sleep(5000);
                    Counsel.click();
                    log_Info("Clicked on Counsel");


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (caseMgmt1.isDisplayed()) {

                    log_Info("Click on Counsel");
                    getDriver().waitForelementToBeClickable(Counsel);
                    Thread.sleep(5000);
                    Counsel.click();
                    log_Info("Clicked on Counsel");

                }

            }
            return new CaseCounselPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToCaseCounselPage() Failed ", ex);
        }
    }

    public ILiglPage goToIdentification() throws Exception {

        try {

            try {
                WebElement DataMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Data Management']//div[contains(@style,'display: none')]")); //Data Management Menu is in collapsed form
                if (DataMgmt2.isEnabled()) {

                    log_Info("Click on Data Management");
                    getDriver().waitForelementToBeClickable(DataManagement);
                    DataManagement.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("Data Management clicked");

                    log_Info("Click on Identification");
                    getDriver().waitForelementToBeClickable(Identification);
                    Thread.sleep(5000);
                    Identification.click();
                    log_Info("Clicked on Identification");


                }
            } catch (NoSuchElementException e) {

                WebElement DataMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Data Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (DataMgmt1.isDisplayed()) {

                    log_Info("Click on Identification");
                    getDriver().waitForelementToBeClickable(Identification);
                    Thread.sleep(5000);
                    Identification.click();
                    log_Info("Clicked on Identification");

                }

            }
            return new DMDSIPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToIdentification() Failed ", ex);
        }
    }

    public ILiglPage goToPreservation() throws Exception {

        try {

            log_Info("Click on Data Management");
            getDriver().waitForelementToBeClickable(DataManagement);
            Thread.sleep(5000);
            DataManagement.click();
            getSession().log_Pass("Clicked on Data Management");

            log_Info("Click on Identification");
            getDriver().waitForelementToBeClickable(Preservation);
            Thread.sleep(5000);
            Preservation.click();
            getSession().log_Pass("Clicked on Identification");
            return new DMDataHoldPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToDataManagement() Failed ", ex);
        }
    }

    public ILiglPage goToOtherPartyPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Other Party ");
                    getDriver().waitForelementToBeClickable(OtherParty);
                    Thread.sleep(5000);
                    OtherParty.click();
                    getSession().log_Pass("other party clicked");


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (caseMgmt1.isDisplayed()) {

                    log_Info("Click on Other Party ");
                    getDriver().waitForelementToBeClickable(OtherParty);
                    Thread.sleep(5000);
                    OtherParty.click();
                    getSession().log_Pass("other party clicked");

                }



            }
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToOtherPartyPage() Failed", ex);

        }
    }


                    // Navigating To Custodian Page In The LeftMenu

    public ILiglPage navigateToCustodiansPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    Thread.sleep(5000);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    log_Info("click on the Custodians subtab");
                    Thread.sleep(5000);
                    CaseCust.click();
                    log_Info("clicked on the Custodians subtab");
                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                try {
                    if (caseMgmt1.isDisplayed()) {
                        WebElement caseMgmt3 = getCurrentDriver().findElement(By.xpath("//li[@id='Scope' and contains(@class,'open')]"));
                        if (caseMgmt3.isEnabled()) {
                            log_Info("click on the Custodians subtab");
                            Thread.sleep(5000);
                            CaseCust.click();
                            log_Info("clicked on the Custodians subtab");
                        }
                    }
                }catch (NoSuchElementException ex){

                    log_Info("click on the Data sources subtab");
                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    Thread.sleep(5000);
                    CaseCust.click();
                    log_Info("clicked on the Custodians subtab");

                }

            }
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToCustodiansPage() Failed", ex);


        }
    }


    // Navigating To Court Page

    public ILiglPage navigateToCourtPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on court Tab ");
                    getDriver().waitForelementToBeClickable(Court);
                    Thread.sleep(2000);
                    Court.click();
                    getSession().log_Pass("court Tab is clicked");


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (caseMgmt1.isDisplayed()) {

                    log_Info("Click on court Tab ");
                    getDriver().waitForelementToBeClickable(Court);
                    Thread.sleep(2000);
                    Court.click();
                    getSession().log_Pass("court Tab is clicked");

                }

            }
            return new CaseCourtListPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToCourtPage() Failed", ex);

        }

    }
// Navigating to Datasources tab
    public ILiglPage navigateToDataSourcesPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    Thread.sleep(5000);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    log_Info("click on the Data sources subtab");
                    Thread.sleep(5000);
                    DataSources.click();
                    log_Info("clicked on the Data sources subtab");



                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                try {
                    if (caseMgmt1.isDisplayed()) {
                        WebElement caseMgmt3 = getCurrentDriver().findElement(By.xpath("//li[@id='Scope' and contains(@class,'open')]"));
                        if (caseMgmt3.isEnabled()) {
                            log_Info("click on the Data sources subtab");
                            Thread.sleep(5000);
                            DataSources.click();
                            log_Info("clicked on the Data sources subtab");
                        }
                    }
                }catch (NoSuchElementException ex){

                    log_Info("click on the Data sources subtab");
                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    Thread.sleep(5000);
                    DataSources.click();
                    log_Info("clicked on the Data sources subtab");


                }

            }
            return new CaseDataSourcesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToDataSourcesPage() Failed", ex);

        }
    }

    // Navigate To Date Ranges SubTab

    public ILiglPage navigateToDateRangesPage() throws Exception {

        try {
            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    Thread.sleep(5000);
                    CaseManage.click();
                    Thread.sleep(5000);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    log_Info("click on the Date Ranges subtab");
                    DateRanges.click();
                    log_Info("clicked on the Data Ranges subtab");
                    Thread.sleep(2000);


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form
                try {
                    if (caseMgmt1.isDisplayed()) {
                        WebElement caseMgmt3 = getCurrentDriver().findElement(By.xpath("//li[@id='Scope' and contains(@class,'open')]"));
                        if (caseMgmt3.isEnabled()) {
                            log_Info("click on the Date ranges subtab");
                            Thread.sleep(5000);
                            DateRanges.click();
                            log_Info("clicked on the Date ranges subtab");
                        }
                    }
                }catch (NoSuchElementException ex){

                    log_Info("click on the Date ranges subtab");
                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    Thread.sleep(5000);
                    DateRanges.click();
                    log_Info("clicked on the Date Ranges subtab");

                }

            }
            return new CaseDateRangesPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToDateRangesPage() Failed", ex);
        }

    }

    // Navigate To Keywords SubTab

    public ILiglPage navigateToKeyWordsPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    CaseManage.click();
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", Keywords);

                    log_Info("click on the Keywords subtab");
                    Thread.sleep(5000);
                    Keywords.click();
                    log_Info("clicked on the Keywords subtab");


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                try {
                    if (caseMgmt1.isDisplayed()) {
                        WebElement caseMgmt3 = getCurrentDriver().findElement(By.xpath("//li[@id='Scope' and contains(@class,'open')]"));
                        if (caseMgmt3.isEnabled()) {
                            log_Info("click on the Keywords subtab");
                            Thread.sleep(5000);
                            Keywords.click();
                            log_Info("clicked on the Keywords subtab");
                        }
                    }
                }catch (NoSuchElementException ex){

                    log_Info("click on the Keywords subtab");
                    log_Info("Click on Scope");
                    getDriver().waitForelementToBeClickable(Scope);
                    Thread.sleep(5000);
                    Scope.click();
                    getSession().log_Pass("Scope is clicked");

                    Thread.sleep(5000);
                    Keywords.click();
                    log_Info("clicked on the Keywords subtab");


                }

            }
            return new CaseKeywordsPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToKeyWordsPage() Failed", ex);

        }

    }

    public ILiglPage goToDataManagementSummary() throws Exception {

        try {
            log_Info("Click on goToDataManagementSummary");
            getDriver().waitForelementToBeClickable(DataManagement);
            Thread.sleep(5000);
            DataManagement.click();
            getSession().log_Pass("Clicked on Data Management");

            return new DMSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToDataManagement() Failed ", ex);
        }
    }

    public ILiglPage goToPMSummaryPage() throws Exception {

        try {

            log_Info("Click on Process Management");
            getDriver().waitForelementToBeClickable(ProcessManagement);
            Thread.sleep(5000);
            ProcessManagement.click();
            Thread.sleep(3000);
            return new PMSummaryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToPMSummaryPage() Failed ", ex);
        }
    }

    public ILiglPage goToCaseDocument() throws Exception {

        try {
            getDriver().waitForelementToBeClickable(CaseDocument);
            CaseDocument.click();
            Thread.sleep(5000);
            log_Info("Clicked on Case Document");
            return new CaseDocumentsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToCaseDocument() Failed ", ex);
        }
    }

    public ILiglPage navigateToNotesHistoryPage() throws Exception {

        try {

            try {
                WebElement caseMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: none')]")); //Project Management Menu is in collapsed form
                if (caseMgmt2.isEnabled()) {

                    log_Info("Click on Project Management");
                    getDriver().waitForelementToBeClickable(CaseManage);
                    CaseManage.click();
                    getSession().log_Pass("Project Management clicked");

                    log_Info("Click on History tab ");
                    getDriver().waitForelementToBeClickable(History);
                    Thread.sleep(5000);
                    History.click();
                    getSession().log_Pass("Notes History tab clicked");


                }
            } catch (NoSuchElementException e) {

                WebElement caseMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Project Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (caseMgmt1.isDisplayed()) {

                    log_Info("Click on History tab ");
                    getDriver().waitForelementToBeClickable(History);
                    Thread.sleep(5000);
                    History.click();
                    getSession().log_Pass("Notes History tab clicked");

                }



            }
            return new CaseNotesHistoryPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToNotesHistoryPage() Failed", ex);

        }
    }

    public ILiglPage navigateToCaseLevelRequests() throws Exception {

        try {

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", Requests);


            getDriver().waitForelementToBeClickable(Requests);
            log_Info("Click on Case Request Page");
            Requests.click();
            Thread.sleep(5000);
            log_Info("Clicked on Case Request Page");

            return new CaseRequestsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToCaseLevelRequests() Failed ", ex);
        }
    }

    public ILiglPage goToCollection() throws Exception {

        try {

            try {
                WebElement DataMgmt2 = getCurrentDriver().findElement(By.xpath("//li[@id='Data Management']//div[contains(@style,'display: none')]")); //Data Management Menu is in collapsed form
                if (DataMgmt2.isEnabled()) {

                    log_Info("Click on Data Management");
                    getDriver().waitForelementToBeClickable(DataManagement);
                    DataManagement.click();
                    Thread.sleep(5000);
                    getSession().log_Pass("Data Management clicked");

                    log_Info("Click on Collection");
                    getDriver().waitForelementToBeClickable(Collection);
                    Thread.sleep(5000);
                    Collection.click();
                    log_Info("Clicked on Collection");


                }
            } catch (NoSuchElementException e) {

                WebElement DataMgmt1 = getCurrentDriver().findElement(By.xpath("//li[@id='Data Management']//div[contains(@style,'display: block')]")); //Project Management Menu is in Expanded form

                if (DataMgmt1.isDisplayed()) {

                    log_Info("Click on Collection");
                    getDriver().waitForelementToBeClickable(Collection);
                    Thread.sleep(5000);
                    Collection.click();
                    log_Info("Clicked on Collection");

                }

            }
            return new DMCollectionsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToCollection() Failed ", ex);
        }
    }


}