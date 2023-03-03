package com.ligl.base.pages;

import com.ligl.pages.Header;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.session.LiglTestSession;
import com.ligl.web.IWebConnector;

import java.util.Hashtable;

public interface ILiglPage {
    // normal browser operations
    ILiglPage openBrowser(String browser);
    void quit();
    LiglTestSession getSession();

    // Ligl Normal Pages methods
    ILiglPage navigateURL();
    ILiglPage submitUsername(String userid);
    ILiglPage submitPassword(String userid);

    IWebConnector validator(boolean flagAssertionType);

    ILiglPage validateAdminRole() throws Exception;
    ILiglPage login(String userName, String password,String Entity) throws Exception;
    ILiglPage adminLogin(String userName, String password, String entity) throws Exception;
    ILiglPage navigateSSOLoginPage();
    ILiglPage SSOLogin(String userName, String password,String Entity) throws InterruptedException;
    ILiglPage selectEntity(String entity);
    ILiglPage createNewCase(Hashtable<String,String> data) throws Exception;
    ILiglPage clickClearFilterBtn();
    // Ligl - session pages
    ILiglPage logout() throws Exception;

    ILiglPage validateCaseNotinitiatedState() throws Exception;
    void log_Info(String message);
    void log_Pass(String message);
    void log_Error(String message);
    ILiglPage validateIntermediatePageOptions();
    Header getHeader();
    LeftMenu getLeftMenu();

    ILiglPage navigateToCustodiansPage() throws Exception;

    ILiglPage navigateToLegalHoldPage();


    ILiglPage goToPMSummaryPage() throws Exception;

    ILiglPage checkLHNForCustodians(String LHN,String Employee1) throws Exception;

    void selectDateFromCalendar(String date);
    ILiglPage goToDefaultLandingPage();

    public ILiglPage searchcase(String casename) throws Exception;
    public ILiglPage GoToCase(String CaseName) throws Exception;

    ILiglPage validateCustodianBeforeApproved() throws Exception;

    ILiglPage goToDataManagement() throws Exception;

    ILiglPage addDataSource(String DataSource) throws Exception;

    ILiglPage addCustodianToCase(String Email1) throws Exception;

    ILiglPage addDataSourceRecordToDSIGrid(String cust,String datasource,String DataHold,String DateRanges,String Keywords) throws Exception;

    ILiglPage addDataSources() throws Exception;
    ILiglPage automateRecordInDSI()throws Exception;
    ILiglPage goToDSIPage() throws Exception;

    ILiglPage waitAndvalidateForRecordToCompleteCollection(String status)throws Exception;

    ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1,String GmailCheck,String BatchNAME,String USER ,String EMAIL) throws Exception;
    ILiglPage navigateToDataSourcesPage() throws Exception;

    ILiglPage goToApprovalPage();

    ILiglPage goToDataManagementSummary() throws Exception;

    ILiglPage sendingLegalHoldForApproval() throws Exception;
    ILiglPage approvingLegalHold() throws InterruptedException;

    ILiglPage creatingNewTemplate() throws Exception;

    ILiglPage goToAdministrationPage() throws InterruptedException;

    ILiglPage goToSecurityPage() throws InterruptedException;

    ILiglPage sendingCaseForSingleApproval(String BatchNAME,String USER,String EMAIL) throws Exception;

    ILiglPage goToAdminLeftMenu() throws Exception;

    ILiglPage goToCaseCounselPage() throws Exception;

    ILiglPage validateCustodianAfterApproved(String Employee1) throws Exception;

    ILiglPage goToCaseManagement() throws InterruptedException;

    ILiglPage verifyApprovalHistoryStatus(String AssignedUser1,String Status1,String Status2,String AssignedUser2) throws Exception;

    ILiglPage sendingCaseForDualApproval(String BatchNAME,String USER1,String USER2,String EMAIL,String Employee1,String SubType) throws Exception;

    ILiglPage verifyingEditBtn() throws Exception;
    ILiglPage sendingCaseCustodianForApproval(String Employee1,String BatchNAME,String USER,String EMAIL) throws Exception;

    ILiglPage checkDSIForCustodians(String Employee1) throws Exception;

    ILiglPage approvingCaseSingleApprover(String CaseNameApprove) throws Exception;

    ILiglPage validateCasePendingForApprovalState() throws Exception;

    ILiglPage verifyApprovalHistoryStatusRejected(String AssignedUser1,String Status3,String AssignedUser2,String Status1) throws Exception;

    ILiglPage rejectingTheCase(String CaseNameApprove) throws Exception;

    ILiglPage enableAndDisableKeywords(String Status1) throws Exception;

    ILiglPage sendingCaseForDualApprovalLinearType(String Employee1,String GmailCheck,String GoogleDriveCheck,String BatchNAME,String EMAIL,String USER1,String USER2,String SubType) throws Exception;

    ILiglPage validateCaseRejectedState() throws Exception;

    ILiglPage sendingCaseForDualApprovalEitherType(String Employee1,String GmailCheck,String GoogleDriveCheck,String DateRange1,String DateRange2,String Keywords1,String Keywords2,String BatchNAME,String EMAIL,String USER1,String USER2,String SubType) throws Exception;

    ILiglPage validateDSIForCustodians(String Employee1) throws Exception;

    ILiglPage verifyColumnsInCustodianGrid() throws Exception;

    ILiglPage validatingUpdatedStatus(String StatusDropDown1) throws Exception;

    ILiglPage addInhouseCounselToCase(String Email1,String CounselName) throws Exception;
    ILiglPage deleteInhouseCounselFromCase() throws Exception;

    ILiglPage addDeleteOutsideCounselToCase(String OptionFromLawFirmDropDwn , String SelectAvailableLawfirm) throws Exception;

    ILiglPage createNewOutsideCounselToCase(String PartyLawFirm,String FirstName,String LastName) throws Exception;

    ILiglPage createNewContactForSelectedParty(String PartyNew,String FirstName ,String LastName) throws Exception;

    ILiglPage goToOtherPartyPage () throws Exception;

    ILiglPage goToCasePage() throws Exception;

    ILiglPage verifyingCaseFieldsAreEdited(String CaseTypeDrpDwn,String CaseName1,String CaseSettingTemplateDrpDwn) throws Exception;

    ILiglPage verifyingCaseFieldsAreEditable(String CaseTypeDrpDwn,String CaseName1,String CaseSettingTemplateDrpDwn) throws Exception;

    ILiglPage verifyingApproveStatus() throws Exception;

    ILiglPage sendingCaseForApproval() throws Exception;
    ILiglPage approvingRejectedCase(String CaseNameApprove ) throws Exception;

    ILiglPage validateEnableAndDisableKeywords(String Status2) throws Exception;

    ILiglPage deleteContactsAddedForParty(String PartyNew, String ContactName) throws Exception;

    ILiglPage verifyingCaseFieldsAreNonEditable() throws Exception;

    ILiglPage createNewInHouseCounselForEnterpriseParty(String PartyName,String FirstName,String LastName) throws Exception;
    ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB,String PartyType,String Description) throws Exception;

    ILiglPage createOtherPartyNewOutsideCounsel(String PartyName,String NameTextBox,String PartyDrpDwn,String Description,String Status,String FirstName,String LastName) throws Exception;

    ILiglPage addingNewParty(String PartyName,String PartyType,String Description) throws Exception;
    ILiglPage addingExistingParty(String PartyNameA,String PartyNew) throws Exception;

    ILiglPage searchingParty() throws Exception;

    ILiglPage validateEnableAndDisableDateRanges(String Status2) throws Exception;

    ILiglPage createNewCounselForSelectedOutsideCounsel(String PartyNew,String OptionFromLawFirmDropDwn,String FirstName,String LastName) throws Exception;

    ILiglPage navigateToCourtPage () throws Exception;

    ILiglPage addCourtToCase(String AvailableCourt) throws Exception;

    ILiglPage searchingAddedCourt(String AvailableCourt) throws Exception;

    ILiglPage navigateAndAddProsecutor(String AvailableCourt,String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception;

    ILiglPage addOneMoreInhouseCounselToCase(String Email2,String CounselName1) throws Exception;
    ILiglPage navigateToDateRangesPage () throws Exception;
    ILiglPage addDateRanges(String StartDate1 ,String EndDate1,String DescriptionBox) throws Exception;

    ILiglPage validatingDateRanges() throws Exception;

    ILiglPage navigateToKeyWordsPage() throws Exception;

    ILiglPage addKeywordsByBasic(String Keywords1) throws Exception;

    public ILiglPage addKeywordsByCustom(String Keywords1,String DataSource1) throws Exception;

    ILiglPage verifyingTheStatusDropDownForACase(String StatusDropDown1) throws Exception;

    ILiglPage validatingKeywords() throws Exception;

    ILiglPage validatingKeywordsByKeywordType() throws Exception;

    ILiglPage addCustodiansToCaseThroughFilters(String Employee1,String Employee2) throws Exception;

    ILiglPage validatingCustodians(String Employee2) throws Exception;

    ILiglPage validateInhouseCounsel() throws Exception;

    ILiglPage validateOutSideCounsel() throws Exception;

    ILiglPage validateNewOutSideCounselAdded(String OutSideCounsel) throws Exception;

    ILiglPage searchingAddedOutsideCounsel(String OutSideCounsel) throws Exception;

    ILiglPage searchingContact(String ContactName) throws Exception;

    ILiglPage validatingContactAddedForParty(String ContactName) throws Exception;

    ILiglPage validatingContactsAfterDeletingFromParty() throws Exception;

    ILiglPage searchingInHouseCounsel(String PartyName,String CounselName) throws Exception;

    ILiglPage validateAddedInHouseCounsel(String CounselName) throws Exception;

    ILiglPage validateAddedOutsideCounsel(String OutSideCounselName) throws Exception;

    ILiglPage searchingOutSideCounsel(String PartyNew,String OptionFromLawFirmDropDwn) throws Exception;

    ILiglPage validateProsecutors(String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception;

    ILiglPage validateOneOrMoreInhouseCounsel(String CounselName,String CounselName1) throws Exception;

    ILiglPage enableAndDisableDateRanges(String Status1) throws Exception;

    ILiglPage validateAddedNewOutsideCounsel(String OutsideCounsel, String NameTextBox) throws Exception;

    // Actions For Adding An Employee To Custodian

    ILiglPage addCustodianToCaseAtOneTime(String Email1) throws Exception;

    ILiglPage clickOnFilterButtonOnly() throws Exception;

    ILiglPage clickOnTheCutsodianCheckBox(String Emp1) throws Exception;

    ILiglPage clickOnAddToCaseButton() throws Exception;

    ILiglPage performClearAction(String Email2) throws Exception;

    // Adding Data Sources To The Custodian

    ILiglPage addingDataSource(String DataSource) throws Exception;

    ILiglPage clickOnSaveButton() throws Exception;

    // Adding Records To DSI Page

    ILiglPage searchAccountEmailRecordInDSI(String Email1) throws Exception;

    ILiglPage searchAccountEmailOneMoreTime() throws Exception;

    ILiglPage clickOnCheckBoxOfCustodian() throws Exception;

    ILiglPage sendingAccountEmailOneMorTime(String Email2) throws Exception;

    ILiglPage clickOnAutomateButton() throws Exception;


    // Approving Case With Custodian And Datasources

    ILiglPage sendingCaseForApprovalAfterAddingScopeItems(String BatchNAME,String USER ,String EMAIL) throws Exception;

    ILiglPage clickOnSendForApprovalButton() throws Exception;

    ILiglPage clickOnCustodianCheckBoxForApproval(String Emp1) throws Exception;

    ILiglPage clickOnNextButtonForApproval() throws Exception;

    ILiglPage clickOnDataSourceCheckBoxForApproval(String DataSource1) throws Exception;

    ILiglPage viewCase() throws Exception;


    // Smoke Suite Methods

    ILiglPage validateAndWaitForRecordsToCompleteCollection(String CollectionStatus) throws Exception;

    ILiglPage validateAndWaitForRecordsToCompleteProcessing(String Processingstatus)throws Exception;

    ILiglPage clickOnDateRangesCheckBoxForApproval(String DateRange) throws Exception;

    ILiglPage clickOnKeywordsCheckBoxForApproval(String KeyWords) throws Exception;

    ILiglPage addDataSourceRecordToDSIGridUptoCollection(String cust, String datasource, String DataHold) throws Exception;

    ILiglPage validateLHStatus(String Status) throws Exception;

    ILiglPage searchRequiredLegalHoldName(String LHname) throws Exception;

    ILiglPage clickOnLHCheckbox(String LHname) throws Exception;

    ILiglPage clickOnActionDropDownAndRun(String Action1) throws Exception;

    ILiglPage selectTemplateAndApproverAndClickOnSendBtn(String Template1,String ApproverName) throws Exception;

    ILiglPage validateSSCopyeesList() throws Exception;

    ILiglPage clickOnApprovedLH(String LHname) throws Exception;

    ILiglPage searchRequiredLHNStatus(String Status) throws Exception;

    ILiglPage clickOnRefreshButton() throws Exception;

    ILiglPage copyeeSScancelBtnClick() throws Exception;

    ILiglPage copyeeReleaseCancelBtnClick() throws Exception;

    ILiglPage validateRCopyeesList() throws Exception;

    ILiglPage clickOnPendingLHNameInAppPage(String CaseLHname) throws Exception;

    ILiglPage validateCaseLHDetailsInAppPage(String OnlyLHname) throws Exception;

    ILiglPage clickOnApproveBtnInAppPage() throws Exception;

    ILiglPage myHoldsAcknowledgeLink() throws Exception;

    ILiglPage switchOnToTheStakeHolderTab() throws Exception;

    ILiglPage clickOnCreateStakeHolderBtnInLH(String FirstName,String LastName,String StakeDepartment,String StakeEmailID,String StakeCategoryValue) throws Exception;

    ILiglPage searchStakeholderEmailFromLHNGrid(String StakeEmailID) throws Exception;

    ILiglPage verifyStakeholderEmailIsDisplayed(String StakeEmailID) throws Exception;

    ILiglPage validateDisplayOfDefaultTemplateInLHReleasePopup(String DefaultTemplate) throws Exception;

    ILiglPage secondSearch(String LHname) throws Exception;

    ILiglPage sendBtnInTestMail() throws Exception;

    ILiglPage validateMyHoldsGridData() throws Exception;

    ILiglPage legalHoldNotes() throws Exception;

    ILiglPage createNewNotes(String RequestBy,String NotesContent) throws Exception;

    ILiglPage validateDataInNotesGrid(String desc) throws Exception;

    ILiglPage editNotes(String RequestBy,String NotesDescription) throws Exception;

    ILiglPage clickOnAddNewLegalHoldButton() throws Exception;

    ILiglPage verifyCreatedLegalHoldIsDisplayed(String LHname) throws Exception;

    ILiglPage clickOnLegalholdGridRefreshButton() throws Exception;

    ILiglPage verifyEditedLegalHoldIsDisplayed(String LHname) throws Exception;

    ILiglPage editLegalHoldWhenOnFlyIsFalse(String EditedLegalHoldname,String CustodianQTemplate,String LHname) throws Exception;
    ILiglPage createNewLegalHoldWhenOnFlyIsFalse(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception;

   }
