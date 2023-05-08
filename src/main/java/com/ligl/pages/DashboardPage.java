package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.xml.stream.events.StartDocument;
import java.time.Duration;
import java.util.ArrayList;

public class DashboardPage extends LiglBaseSessionPage {



    @FindBy(id = "process-insights-tab")
    WebElement ProcessInsightsTab;

    @FindBy(id = "review-insights-tab")
    WebElement ReviewInsightsTab;

    @FindBy(id = "legal-hold-insights-tab")
    WebElement LegalHoldInsightsTab;

    @FindBy(xpath = "//div[contains(text(),'Total Cases')]/ancestor::td//td[@class='tile-value']//div")
    WebElement TotalCasesCount;

    @FindBy(xpath = "//div[contains(text(),'Active  Custodians')]/ancestor::td//td[@class='tile-value']//div")
    WebElement ActiveCustodianCount;

    @FindBy(xpath = "//div[contains(text(),'DATA SOURCE(S)')]/ancestor::td//td[@class='tile-value']//div")
    WebElement DataSourceIdentifiedCount;

    @FindBy(xpath = "//strong[contains(text(),'COLLECTED')]/ancestor::td//td[@class='tile-value']//div")
    WebElement DataSourceCollectedCount;

    @FindBy(xpath = "//strong[contains(text(),'INGESTED')]/ancestor::td//td[@class='tile-value']//div")
    WebElement VolumeIngested;

    @FindBy(xpath = "//strong[contains(text(),'HOSTED')]/ancestor::td//td[@class='tile-value']//div")
    WebElement ExportSetHosted;

    @FindBy(xpath = "//strong[contains(text(),'DATA SOURCE(S)')]/ancestor::td//td[@class='tile-value']//div")
    WebElement TotalDataSourcesCount;

    @FindBy(xpath = "//strong[contains(text(),'LHN(S) SENT')]/ancestor::td//td[@class='tile-value']//div")
    WebElement TotalLHNCount;

    @FindBy(xpath = "//strong[contains(text(),'ACKNOWLEDGEMENT(S)')]/ancestor::td//td[@class='tile-value']//div")
    WebElement TotalAcknowledgementCount;

    @FindBy(xpath = "//strong[contains(text(),'REMINDERS')]/ancestor::td//td[@class='tile-value']//div")
    WebElement TotalRemainderCount;

    @FindBy(xpath = "//strong[contains(text(),'INVENTORY')]/ancestor::td//td[@class='tile-value']//div")
    WebElement InventoryCount;

    @FindBy(xpath = "//strong[contains(text(),'PUBLISH')]/ancestor::td//td[@class='tile-value']//div")
    WebElement PublishCount;

    @FindBy(id = "production-insights-tab")
    WebElement ProductionInsights;

    @FindBy(id = "global-insights-tab")
    WebElement GlobalInsights;

    @FindBy(id = "apply-filter")
    WebElement ApplyButton;


    @FindBy(xpath = "//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-0']//button[@aria-label='Open calendar']")
    WebElement StartDateCalendar;

    @FindBy(xpath = "//mat-datepicker-toggle[@data-mat-calendar='mat-datepicker-1']//button[@aria-label='Open calendar']")
    WebElement EndDateCalendar;

    @FindBy(xpath = "//button[@aria-label='Choose month and year']")
    WebElement AYearTabInCalendar;


    @FindBy(xpath = "//button[contains(text(),'Print')]")
    WebElement PrintButton;

    @FindBy(xpath = "//button[contains(text(),'Clear All')]")
    WebElement ClearAllButton;


    public ILiglPage validateAdminRole() throws Exception {
        try {
            if (getCurrentDriver().getCurrentUrl().contains("Case Insights | Vertical")) {
                log_Pass("Dashboard page is loaded default for Admin Role");
            }
            return new DashboardPage();
        } catch (Exception ex) {
            log_Error("validateAdminRole Failed");
            throw new Exception("NormalLoginTest_001 Failed", ex);
        }
    }

    public ILiglPage clickOnProcessInsightsTab() throws Exception{

        try {

            getSession().log_Info("Click On Process Insights Tab");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(ProcessInsightsTab);
            Thread.sleep(5000);
            ProcessInsightsTab.click();
            getSession().log_Pass("Clicked On Process Insights Tab");
            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnProcessInsightsTab() Failed ", ex);
        }
    }


    public ILiglPage clickOnLegalHoldInsightsTab() throws Exception{

        try {

            getSession().log_Info("Click On Legal Hold Insights Tab");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(LegalHoldInsightsTab);
            Thread.sleep(5000);
            LegalHoldInsightsTab.click();
            getSession().log_Pass("Clicked On Legal Hold Insights Tab");



            WebDriverWait wait1 = new WebDriverWait(getCurrentDriver(), Duration.ofSeconds(100));
            wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//strong[contains(text(),'LHN(S) SENT')]/ancestor::td//td[@class='tile-value']//div")));
            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnProcessInsightsTab() Failed ", ex);
        }
    }


    public ILiglPage clickOnReviewInsightsTab() throws Exception{

        try {

            getSession().log_Info("Click On Process Insights Tab");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(ReviewInsightsTab);
            Thread.sleep(5000);
            ReviewInsightsTab.click();
            getSession().log_Pass("Clicked On Process Insights Tab");
            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnProcessInsightsTab() Failed ", ex);
        }
    }


    public ILiglPage clickOnProductionInsightsTab() throws Exception{

        try {

            getSession().log_Info("Click On Production Insights Tab");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(ProductionInsights);
            Thread.sleep(5000);
            ProductionInsights.click();
            getSession().log_Pass("Clicked On Production Insights Tab");
            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnProductionInsightsTab() Failed ", ex);
        }
    }

    public ILiglPage clickOnGlobalInsightsTab() throws Exception{

        try {

            getSession().log_Info("Click On Global Insights Tab");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(GlobalInsights);
            Thread.sleep(5000);
            GlobalInsights.click();
            getSession().log_Pass("Clicked On Global Insights Tab");
            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnGlobalInsightsTab() Failed ", ex);
        }
    }


    public ILiglPage checkAndValidateTheCountOfTheGlobalInsightsStats(String CaseName,String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus) throws Exception{

        try {


            String TotalCases = TotalCasesCount.getText();
            int TotalCASESCount = Integer.parseInt(TotalCases);

            String TotalCustodians = ActiveCustodianCount.getText();
            int ActiveCUSTCount = Integer.parseInt(TotalCustodians);


            String TotalDataSourceIdentified = DataSourceIdentifiedCount.getText();
            int TotalIdentifiedDataSource = Integer.parseInt(TotalDataSourceIdentified);

            String TotalDataSourceCollected = DataSourceCollectedCount.getText();
            int TotalCollectedDataSource = Integer.parseInt(TotalDataSourceCollected);

            String IngestedVolume = VolumeIngested.getText();
            int TotalVolume = Integer.parseInt(IngestedVolume);

            String HostedExport = ExportSetHosted.getText();
            int HostedSet = Integer.parseInt(HostedExport);

            log_Info("Total Number Of Cases  : " + TotalCASESCount);
            log_Info("Total Number Of Active Custodians  : " + ActiveCUSTCount);
            log_Info("Total Number Of Identified Datasources  : " + TotalIdentifiedDataSource);
            log_Info("Total Number Of Collected DataSources  : " + TotalCollectedDataSource);
            log_Info("Total Number Of Volume  : " + TotalVolume);
            log_Info("Total Number Of Hosted Set  : " + HostedSet);

            getHeader().selectCase().searchcase(CaseName).GoToCase(CaseName)
                    .getLeftMenu().navigateToCustodiansPage().addCustodianToCaseAtOneTime(Email)
                    .clickOnTheCutsodianCheckBox(Emp)
                    .clickOnFilterButtonOnly()
                    .performClearAction(EMAIL)
                    .clickOnTheCutsodianCheckBox(EMP)
                    .clickOnAddToCaseButton()
                    .getLeftMenu().navigateToDataSourcesPage().addOnpremDataSource(DataSource)
                    .getLeftMenu().goToDSIPage()
                    .addingDSToDSIThroughCustom(Emp,DataSource,SourcePath,DataHold)
                    .searchAccountEmailRecordInDSI(Email)
                    .automateRecordInDSI()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(CollectionStatus)
                    .getHeader().clearCaseFunctionality()
                    .getHeader().navigateToDashboardPage().clickOnGlobalInsightsTab();

            String AfterTotalCases = TotalCasesCount.getText();
            int AfterTotalCASESCount = Integer.parseInt(AfterTotalCases);

            log_Info("Total Number Of Active Cases  : " + AfterTotalCASESCount);

            String AfterTotalCustodians = ActiveCustodianCount.getText();
            int AfterActiveCUSTCount = Integer.parseInt(AfterTotalCustodians);

            log_Info("Total Number Of Active Custodians  : " + AfterActiveCUSTCount);

            String AfterTotalDataSourceIdentified = DataSourceIdentifiedCount.getText();
            int AfterTotalIdentifiedDataSource = Integer.parseInt(AfterTotalDataSourceIdentified);

            log_Info("Total Number Of DataSources Identified  : " + AfterTotalIdentifiedDataSource);

            String AfterTotalDataSourceCollected = DataSourceCollectedCount.getText();
            int AfterTotalCollectedDataSource = Integer.parseInt(AfterTotalDataSourceCollected);

            log_Info("Total Number Of DataSources Collected  : " + AfterTotalCollectedDataSource);

            try {

                if (AfterActiveCUSTCount == ActiveCUSTCount + 2) {

                    log_Pass("Total Count Of Custodian Incremented");
                }
            }
            catch(Exception e) {
                throw new Exception("Either Total Count Or New Count Not Incremented", e);
            }

            try {

                if (AfterTotalIdentifiedDataSource == TotalIdentifiedDataSource + 1) {

                    log_Pass("Total Count Of Datasource Identified Incremented");
                }
            }
            catch(Exception e) {
                throw new Exception("Either Total Count Or New Count Not Incremented", e);
            }

            try {

                if (AfterTotalCollectedDataSource == TotalCollectedDataSource + 1) {

                    log_Pass("Total Count Of DataSource Collected Incremented");
                }
            }
            catch(Exception e) {
                throw new Exception("Either Total Count Or New Count Not Incremented", e);
            }

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkAndValidateTheCountOfTheGlobalInsightsStats() Failed ", ex);
        }
    }


    public ILiglPage checkAndValidateTheCountOfTheLegalHoldInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String LHname,String Action) throws Exception{

        try {


            String TotalCases = TotalCasesCount.getText();
            int TotalCASESCount = Integer.parseInt(TotalCases);

            String TotalCustodians = ActiveCustodianCount.getText();
            int ActiveCUSTCount = Integer.parseInt(TotalCustodians);


            String TotalDataSource = TotalDataSourcesCount.getText();
            int TotalDataSourcecount = Integer.parseInt(TotalDataSource);

            String TotalLHNsent = TotalLHNCount.getText();
            int TotalLHNcount = Integer.parseInt(TotalLHNsent);

            String TotalAcknowledgement = TotalAcknowledgementCount.getText();
            int TotalAcknowledgementcount = Integer.parseInt(TotalAcknowledgement);

            String TotalRemainder = TotalRemainderCount.getText();
            int TotalRemaindercount = Integer.parseInt(TotalRemainder);

            log_Info("Total Number Of Cases  : " + TotalCASESCount);
            log_Info("Total Number Of Active Custodians  : " + ActiveCUSTCount);
            log_Info("Total Number Of Datasources  : " + TotalDataSourcecount);
            log_Info("Total Number Of LHN count  : " + TotalLHNcount);
            log_Info("Total Number Of Acknowledgement   : " + TotalAcknowledgementcount);
            log_Info("Total Number Of Remaindercount  : " + TotalRemaindercount);

            getHeader().viewCase()

                    .getLeftMenu().navigateToCustodiansPage().addCustodianToCaseAtOneTime(Email)
                    .clickOnTheCutsodianCheckBox(Emp)
                    .clickOnFilterButtonOnly()
                    .performClearAction(EMAIL)
                    .clickOnTheCutsodianCheckBox(EMP)
                    .clickOnAddToCaseButton()
                    .getLeftMenu().navigateToDataSourcesPage().addOnpremDataSource(DataSource)
                    .getLeftMenu().goToDSIPage()
                    .addingDSToDSIThroughCustom(Emp,DataSource,SourcePath,DataHold)
                    .searchAccountEmailRecordInDSI(Email)
                    .automateRecordInDSI()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(CollectionStatus)
                    .getLeftMenu().navigateToLegalHoldPage()
                    .searchRequiredLegalHoldName(LHname).goToRequiredLegalHoldName(LHname)
                    .searchActionThroughEmail(EMAIL)
                    .clickOnActionDropDownAndRun(Action)
                    .getHeader().goToMyHoldsPage()
                    .searchRequiredLegalHoldName(LHname).myHoldsAcknowledgeLink().clickOnRefreshButton()
                    .validateMyHoldsGridData()
                    .getHeader().navigateToDashboardPage().clickOnLegalHoldInsightsTab();

            String AfterTotalCustodians = ActiveCustodianCount.getText();
            int AfterActiveCUSTCount = Integer.parseInt(AfterTotalCustodians);

            log_Info("Total Number Of Active Custodians  : " + AfterActiveCUSTCount);

            String AfterTotalDataSource = TotalDataSourcesCount.getText();
            int AfterTotalDataSourcecount = Integer.parseInt(AfterTotalDataSource);

            log_Info("Total Number Of DataSources  : " + AfterTotalDataSourcecount);

            String AfterTotalLHNsent = TotalLHNCount.getText();
            int AfterTotalLHNcount = Integer.parseInt(AfterTotalLHNsent);

            log_Info("Total Number Of LHN   : " + AfterTotalLHNcount);

            String AfterTotalAcknowledgement = TotalAcknowledgementCount.getText();
            int AfterTotalAcknowledgementcount = Integer.parseInt(AfterTotalAcknowledgement);

            log_Info("Total Number Of Acknowledgement   : " + AfterTotalAcknowledgementcount);


            try {

                if (AfterActiveCUSTCount == ActiveCUSTCount + 2) {

                    log_Pass("Total Count Of Custodians Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalDataSourcecount == TotalDataSourcecount + 1) {

                    log_Pass("Total Count Of DataSources Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalLHNcount == TotalLHNcount + 1) {

                    log_Pass("Total Count Of LHN Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalAcknowledgementcount == TotalAcknowledgementcount + 1) {

                    log_Pass("Total Count Of LHN Acknowledgement Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }


            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkAndValidateTheCountOfTheLegalHoldInsightsStats() Failed ", ex);
        }
    }

    public ILiglPage validateDashBoardPageURL(String PageTitle) throws Exception {

        try {

            getDriver().waitForAngularRequestsToComplete();

            log_Info("validateTheNavigateToDashBoardPageURL Started");


            if (getCurrentDriver().getCurrentUrl().contains(PageTitle)) {
                log_Info("Naviagated To "+PageTitle+"Page");
            }
            else {

                throw new Exception("Required Page Not Loaded");
            }
            return  new DashboardPage();


        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("validateTheNavigateToDashBoardPageURL() Failed ", ex);
        }
    }

    public ILiglPage checkAndValidateTheCountOfTheCaseInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String Pstatus) throws Exception{

        try {


            String TotalCases = TotalCasesCount.getText();
            int TotalCASESCount = Integer.parseInt(TotalCases);

            String TotalCustodians = ActiveCustodianCount.getText();
            int ActiveCUSTCount = Integer.parseInt(TotalCustodians);


            String TotalDataSourceIdentified = DataSourceIdentifiedCount.getText();
            int TotalIdentifiedDataSourcecount = Integer.parseInt(TotalDataSourceIdentified);

            String TotalDataSorceCollected = DataSourceCollectedCount.getText();
            int TotalCollectedDataSourcecount = Integer.parseInt(TotalDataSorceCollected);

            String TotalInventory = InventoryCount.getText();
            int TotalInventorycount = Integer.parseInt(TotalInventory);

            String TotalPublish = PublishCount.getText();
            int TotalPublishcount = Integer.parseInt(TotalPublish);



            log_Info("Total Number Of Cases  : " + TotalCASESCount);
            log_Info("Total Number Of Active Custodians  : " + ActiveCUSTCount);
            log_Info("Total Number Of Datasources Identified  : " + TotalIdentifiedDataSourcecount);
            log_Info("Total Number Of Datasources Collected  : " + TotalCollectedDataSourcecount);
            log_Info("Total Number Of Inventory Records   : " + TotalInventorycount);
            log_Info("Total Number Of Publish Records  : " + TotalPublishcount);

            getHeader().viewCase()

                    .getLeftMenu().navigateToCustodiansPage().addCustodianToCaseAtOneTime(Email)
                    .clickOnTheCutsodianCheckBox(Emp)
                    .clickOnFilterButtonOnly()
                    .performClearAction(EMAIL)
                    .clickOnTheCutsodianCheckBox(EMP)
                    .clickOnAddToCaseButton()
                    .getLeftMenu().navigateToDataSourcesPage().addOnpremDataSource(DataSource)
                    .getLeftMenu().goToDSIPage()
                    .addingDSToDSIThroughCustom(Emp,DataSource,SourcePath,DataHold)
                    .searchAccountEmailRecordInDSI(Email)
                    .automateRecordInDSI()
                    .getLeftMenu().goToDataManagementSummary()
                    .validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(CollectionStatus)
                    .getLeftMenu().goToPMSummaryPage()
                    .validateAndWaitForRecordsToCompleteProcessing(Pstatus)
                    .getHeader().navigateToDashboardPage().clickOnProcessInsightsTab();


            String AfterTotalCustodians = ActiveCustodianCount.getText();
            int AfterActiveCUSTCount = Integer.parseInt(AfterTotalCustodians);

            log_Info("Total Number Of Active Custodians  : " + AfterActiveCUSTCount);

            String AfterTotalDataSourceIdentified = DataSourceIdentifiedCount.getText();
            int AfterTotalDataSourceIdentifiedcount = Integer.parseInt(AfterTotalDataSourceIdentified);

            log_Info("Total Number Of DataSources Identified  : " + AfterTotalDataSourceIdentifiedcount);

            String AfterTotalDataSourceCollected = DataSourceCollectedCount.getText();
            int AfterTotalDataSourceCollectedcount = Integer.parseInt(AfterTotalDataSourceCollected);

            log_Info("Total Number Of DataSources Collected   : " + AfterTotalDataSourceCollectedcount);

            String AfterTotalInventory = InventoryCount.getText();
            int AfterTotalInventorycount = Integer.parseInt(AfterTotalInventory);

            log_Info("Total Number Of Inventory Count   : " + AfterTotalInventorycount);

            String AfterTotalPublish = PublishCount.getText();
            int AfterTotalPublishcount = Integer.parseInt(AfterTotalPublish);

            log_Info("Total Number Of Publish Count   : " + AfterTotalPublishcount);


            try {

                if (AfterActiveCUSTCount == ActiveCUSTCount + 2) {

                    log_Pass("Total Count Of Custodians Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalDataSourceIdentifiedcount == TotalIdentifiedDataSourcecount + 1) {

                    log_Pass("Total Count Of DataSources  Identified Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalDataSourceCollectedcount == TotalCollectedDataSourcecount + 1) {

                    log_Pass("Total Count Of Collected DataSource Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            try {

                if (AfterTotalInventorycount == TotalInventorycount + 1) {

                    log_Pass("Total Count Of Inventory Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }
            try {

                if (AfterTotalPublishcount == TotalPublishcount + 1) {

                    log_Pass("Total Count Of Publish Incremented");
                }
            }
            catch(Exception e) {
                log_Error("Either Total Count Or New Count Not Incremented");
            }

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkAndValidateTheCountOfTheCaseInsightsStats() Failed ", ex);
        }
    }


    public ILiglPage checkAndValidateTheFunctionalityOfFromToDateAndApplyButton(String SYEAR,String SMONTH,String SDATE,String EYEAR,String EMONTH,String EDATE) throws Exception{

        try {

            getSession().log_Info("Enter The Start Date");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(StartDateCalendar);
            Thread.sleep(5000);
            StartDateCalendar.click();
            Thread.sleep(2000);
            AYearTabInCalendar.click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SYEAR+"']")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+SMONTH+"')]")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+SDATE+"']//div")).click();
            Thread.sleep(2000);
            getSession().log_Pass("Entered The Start Date");

            getSession().log_Info("Enter The End Date");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(EndDateCalendar);
            Thread.sleep(5000);
            EndDateCalendar.click();
            Thread.sleep(2000);
            AYearTabInCalendar.click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+EYEAR+"']")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//div[contains(text(),'"+EMONTH+"')]")).click();
            Thread.sleep(2000);
            getCurrentDriver().findElement(By.xpath("//button[@aria-label='"+EDATE+"']//div")).click();
            Thread.sleep(2000);
            getSession().log_Pass("Entered The End Date");

            getSession().log_Info("Click On The Apply Button");
            getDriver().waitForelementToBeClickable(ApplyButton);
            Thread.sleep(2000);
            ApplyButton.click();
            getSession().log_Pass("Clicked On The Apply Button");

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("checkAndValidateTheFunctionalityOfFromToDateAndApplyButtonInCaseInsights() Failed ", ex);
        }
    }

    public ILiglPage clickOnPrintButton() throws Exception{

        try {

            getSession().log_Info("Click On Print Button");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(PrintButton);
            Thread.sleep(5000);
            PrintButton.click();
            getSession().log_Pass("Clicked On Print Button");

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnPrintButton() Failed ", ex);
        }
    }

    public ILiglPage validateThePrintButtonFunctionality() throws Exception{

        try {

            ArrayList<String> tabs2 = new ArrayList<String>(getCurrentDriver().getWindowHandles());
            getCurrentDriver().switchTo().window(tabs2.get(1));
            if(getCurrentDriver().getCurrentUrl().contains("chrome://print/"))
                System.out.println("Print dialog is opened");
                        //closing print dialog
            JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
            js.executeScript("document.querySelector(\"body > print-preview-app\").shadowRoot.querySelector(\"#sidebar\").shadowRoot.querySelector(\"print-preview-button-strip\").shadowRoot.querySelector(\"div > cr-button.cancel-button\").click();");
                //switch to current window after closing print window
            getCurrentDriver().switchTo().window(getCurrentDriver().getWindowHandles().toArray()[0].toString());
                        //Logout application

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateThePrintButtonFunctionality() Failed ", ex);
        }
    }

    public ILiglPage clickOnClearAllButton() throws Exception{

        try {

            getSession().log_Info("Click On ClearAll Button");
            getDriver().waitForAngularRequestsToComplete();
            getDriver().waitForelementToBeClickable(ClearAllButton);
            Thread.sleep(5000);
            ClearAllButton.click();
            getSession().log_Pass("Clicked On ClearAll Button");

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("clickOnClearAllButton() Failed ", ex);
        }
    }

    public ILiglPage validateUserAccessCasesCountWhenUACsetToFalse(String USERname,String PASSword,String ENTITYSelection,String Title) throws Exception{

        try {


            String TotalCasesEDISC = TotalCasesCount.getText();
            int EDISCTotalCASESCount = Integer.parseInt(TotalCasesEDISC);

            log_Info("Total Number Of Cases  : " + EDISCTotalCASESCount);

            getHeader().logout()
                    .login(USERname,PASSword,ENTITYSelection)
                    .getHeader().navigateToDashboardPage()
                    .validateDashBoardPageURL(Title);

            String TotalCasesSUPER = TotalCasesCount.getText();
            int SUPERTotalCASESCount = Integer.parseInt(TotalCasesSUPER);

            log_Info("Total Number Of Cases  : " + SUPERTotalCASESCount);


            try {

                if (EDISCTotalCASESCount == SUPERTotalCASESCount) {

                    log_Pass("Total Count Of Cases In EDISC User And SUPER user Are EQUAL ");
                }
            }
            catch(Exception e) {
                log_Error("Total Count In Both Users Are Not Same");
            }

            return new DashboardPage();

        }catch (Exception | Error ex){
            log_Error(ex.getMessage());
            throw new Exception("validateUserAccessCasesCountWhenUACsetToFalse() Failed ", ex);
        }
    }
}


