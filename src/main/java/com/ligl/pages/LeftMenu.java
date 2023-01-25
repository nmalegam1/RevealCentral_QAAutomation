package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.*;
import com.ligl.pages.datamanagement.DMCollectionsPage;
import com.ligl.pages.datamanagement.DMDSIPage;
import com.ligl.pages.datamanagement.DMSummaryPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LeftMenu extends LiglBasePage {

    @FindBy(xpath = "//span[contains(text(),'Case Management')]/ancestor::li//span[contains(text(),'Summary')]")
    public WebElement caseManagementSummaryLink;

    @FindBy(xpath = "//span[contains(text(),'Case Management')]")
    public WebElement caseManagementLink;

    @FindBy(xpath = "//span[contains(text(),'Counsel')]")
    public WebElement CounselLink;

    @FindBy(xpath = "//span[contains(text(),'Security')]")
    WebElement SecurityLink;

    // Left Menu web elements

    @FindBy(xpath = "//span[@title='Case Management']")
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

    @FindBy(xpath = "//span[@title='Key Words']")
    WebElement Keywords;

    @FindBy(xpath = "//div[contains(text(),'Select Data Source(s)')]")
    WebElement DataSourceHeader;

    @FindBy(xpath = "//span[@title='Data Management']")
    WebElement DataManagement;

    @FindBy(xpath = "//span[@title='Identification']")
    WebElement Identification;



    public LeftMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


    public ILiglPage goToLegalHoldPage() {
        LegalHoldBtn.click();
        return new LegalHoldPage();
    }

    public ILiglPage goToDSIPage() throws Exception {

        try {

            log_Info("Click on Data Management");
            getDriver().waitForelementToBeClickable(DataManagement);
            Thread.sleep(5000);
            DataManagement.click();
            getSession().log_Pass("Clicked on Data Management");

            log_Info("Click on Identification");
            getDriver().waitForelementToBeClickable(Identification);
            Thread.sleep(5000);
            Identification.click();
            getSession().log_Pass("Clicked on Identification");
            return new DMDSIPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToDSIPage() Failed ", ex);
        }
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
        Thread.sleep(5000);
        SecurityLink.click();
        return new SecurityPage();
    }

    public ILiglPage goToCaseCounselPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Counsel");
            getDriver().waitForelementToBeClickable(Counsel);
            Counsel.click();
            return new CaseCounselPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToCaseCounselPage() Failed ", ex);
        }
    }

                 // Navigating To Data Management Tab

    public ILiglPage goToDataManagement() throws Exception {

        try {

            log_Info("Click on Data Management");
            getDriver().waitForelementToBeClickable(DataManagement);
            Thread.sleep(5000);
            DataManagement.click();
            getSession().log_Pass("Clicked on Data Management");

            log_Info("Click on Identification");
            getDriver().waitForelementToBeClickable(Identification);
            Thread.sleep(5000);
            Identification.click();
            getSession().log_Pass("Clicked on Identification");
            return new DMCollectionsPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToDataManagement() Failed ", ex);
        }
    }

    public ILiglPage goToOtherPartyPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Other Party ");
            getDriver().waitForelementToBeClickable(OtherParty);
            OtherParty.click();
            getSession().log_Pass("other party clicked");
            return new CaseOtherPartyPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("goToOtherPartyPage() Failed", ex);
        }
    }


                    // Navigating To Custodian Page In The LeftMenu

    public ILiglPage navigateToCustodiansPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            Thread.sleep(5000);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Scope");
            getDriver().waitForelementToBeClickable(Scope);
            Scope.click();
            getSession().log_Pass("Scope is clicked");

            log_Info("Click on Case Custodians");
            getDriver().waitForelementToBeClickable(CaseCust);
            CaseCust.click();
            getSession().log_Pass("Case Custodians clicked");
            return new CaseCustodiansPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToCustodiansPage() Failed", ex);
        }

    }

    // Navigating To Data Source Page In The LeftMenu

    public ILiglPage navigateToDataSourcesPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            Thread.sleep(5000);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Scope");
            getDriver().waitForelementToBeClickable(Scope);
            Thread.sleep(5000);
            Scope.click();
            getSession().log_Pass("Scope is clicked");

            log_Info("click on the Data sources subtab");
            DataSources.click();
            log_Info("clicked on the Data sources subtab");
            Thread.sleep(2000);
            return new CaseDataSourcesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToDataSourcesPage() Failed", ex);

        }
    }

    // Navigating To Court Page

    public ILiglPage navigateToCourtPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            Thread.sleep(2000);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on court Tab ");
            getDriver().waitForelementToBeClickable(Court);
            Thread.sleep(2000);
            Court.click();
            getSession().log_Pass("court Tab is clicked");
            return new CaseCourtListPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToCourtPage() Failed", ex);

        }

    }

    // Navigate To Date Ranges SubTab

    public ILiglPage navigateToDateRangesPage() throws Exception {

        try {


            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            Thread.sleep(5000);
            CaseManage.click();
            Thread.sleep(5000);
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Scope");
            getDriver().waitForelementToBeClickable(Scope);
            Thread.sleep(5000);
            Scope.click();
            getSession().log_Pass("Scope is clicked");

            log_Info("click on the Date Ranges subtab");
            DateRanges.click();
            log_Info("clicked on the Data Ranges subtab");
            Thread.sleep(2000);
            return new CaseDateRangesPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("navigateToDateRangesPage() Failed", ex);
        }

    }

    // Navigate To Keywords SubTab

    public ILiglPage navigateToKeyWordsPage() throws Exception {

        try {

            log_Info("Click on Case Management");
            getDriver().waitForelementToBeClickable(CaseManage);
            CaseManage.click();
            CaseManage.click();
            getSession().log_Pass("case Management clicked");

            log_Info("Click on Scope");
            getDriver().waitForelementToBeClickable(Scope);
            Thread.sleep(5000);
            Scope.click();
            getSession().log_Pass("Scope is clicked");

            ((JavascriptExecutor) getCurrentDriver()).executeScript("arguments[0].scrollIntoView(true);", Keywords);

            log_Info("click on the Keywords subtab");
            Thread.sleep(2000);
            Keywords.click();
            log_Info("clicked on the Keywords subtab");
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
}