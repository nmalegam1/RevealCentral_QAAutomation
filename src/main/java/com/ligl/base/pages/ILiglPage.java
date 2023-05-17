package com.ligl.base.pages;

import com.ligl.pages.Header;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.administration.AdminLeftMenu;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.session.LiglTestSession;
import com.ligl.web.IWebConnector;
import org.openqa.selenium.WebElement;
import org.bouncycastle.jcajce.provider.asymmetric.ec.KeyFactorySpi;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public interface ILiglPage {
    // normal browser operations
    ILiglPage openBrowser(String browser);

    void quit();

    LiglTestSession getSession();

    // Ligl Normal Pages methods
    public ILiglPage navigateURL() throws Exception;

    ILiglPage submitUsername(String userid);

    ILiglPage submitPassword(String userid);

    ILiglPage addOnpremDataSource(String s) throws Exception;

    ILiglPage goToEmployeeMasterpage() throws Exception;

    IWebConnector validator(boolean flagAssertionType);

    ILiglPage goToUsersRoles() throws Exception;

    ILiglPage validateAdminRole() throws Exception;

    ILiglPage login(String userName, String password, String Entity) throws Exception;

    ILiglPage adminLogin(String userName, String password, String entity) throws Exception;

    ILiglPage navigateSSOLoginPage();

    ILiglPage SSOLogin(String userName, String password, String Entity) throws InterruptedException;

    ILiglPage selectEntity(String entity);

    ILiglPage createNewCase(Hashtable<String, String> data) throws Exception;

    ILiglPage clickClearFilterBtn();

    // Ligl - session pages
    ILiglPage logout() throws Exception;

    ILiglPage validateCaseNotinitiatedState() throws Exception;

    void log_Info(String message);


    ILiglPage multipleCustodianSelect(Hashtable<String, String> data)throws Exception;
    ILiglPage multipleDataSourceSelect(Hashtable<String, String> data)throws Exception;
    ILiglPage checkCustodianRoleInUserCreationPopUp(String s)throws Exception;
    void log_Pass(String message);

    void log_Error(String message);

    ILiglPage validateIntermediatePageOptions();

    Header getHeader();

    LeftMenu getLeftMenu();

    ILiglPage navigateToCustodiansPage() throws Exception;

    ILiglPage navigateToLegalHoldPage();


    ILiglPage goToPMSummaryPage() throws Exception;

    ILiglPage sendLHNToApproval(String s1, String s2, String s3, String s4) throws Exception;

    ILiglPage goToLegalHold(String s) throws Exception;

    ILiglPage resendLHN(String s1, String s2) throws Exception;

    ILiglPage firstSearch() throws InterruptedException;

    ILiglPage checkAckModeColumn(String s1, String s2, String s3) throws Exception;

    ILiglPage selectOnpremDataSourceForApproval(String s) throws Exception;

    ILiglPage editExistingLHNWithOnFlyEditOfCustTemp(String s1, String s2, String s3, String s4) throws Exception;

    ILiglPage addingDSToDSIThroughCustom(String s1, String s2, String s3, String s4) throws Exception;

    ILiglPage searchLHNThroughEmail(String s) throws Exception;

    ILiglPage sendStealthMode() throws Exception;

    ILiglPage verifyCustodianInterviewTranscriptNotes() throws Exception;

    ILiglPage createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws Exception;

    public ILiglPage editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable(String s1, String s2, String s3, String s4, String s5, String s6, String s7, String s8, String s9, String s10) throws Exception;

    ILiglPage verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater(String s1, String s2, String s3, String s5, String s4, String s6) throws Exception;

    ILiglPage selectLHN(String s) throws Exception;

    ILiglPage verifyColumnsInLegalHoldGrid() throws Exception;

    ILiglPage editLHNCreatedWithDRKW(String s1, String s2, String s3, String s4, String s5, String s6) throws Exception;

    ILiglPage refreshLHN() throws InterruptedException;

    ILiglPage verifyRecordStatusOfLHN(String s) throws Exception;

    ILiglPage verifyFieldsInAddLegalHoldModel(String s1, String s2) throws Exception;

    ILiglPage checkUnableToSetStealthModeToDeactiveCust(String s) throws Exception;

    ILiglPage verifyRecordStatusInLHN(String s) throws Exception;

    ILiglPage checkReportingManagerFieldinAdditionalFields(String s) throws Exception;

    ILiglPage checkLHNForCustodians(String LHN) throws Exception;

    void selectDateFromCalendar(String date);

    ILiglPage goToDefaultLandingPage();

    public ILiglPage searchcase(String casename) throws Exception;

    public ILiglPage GoToCase(String CaseName) throws Exception;

    ILiglPage validateCustodianBeforeApproved() throws Exception;

    ILiglPage goToDataManagement() throws Exception;

    ILiglPage addDataSource(String DataSource) throws Exception;

    ILiglPage addCustodianToCase(String Email1) throws Exception;

    ILiglPage addDataSourceRecordToDSIGrid(String cust, String datasource, String DataHold, String DateRanges, String Keywords) throws Exception;

    ILiglPage addDataSources(String s) throws Exception;

    ILiglPage validateCustodianAddedToGrid(String s) throws Exception;

    ILiglPage validatePartyCreatedOrNot(String s) throws Exception;

    ILiglPage addingNewParty(String s1, String s2, String s3) throws Exception;

    ILiglPage createAndValidatePartyCreatedOrNot(String s1, String s2, String s3,String s4) throws Exception;

    ILiglPage editDataSources(String s1, String s2) throws Exception;

    ILiglPage automateRecordInDSI() throws Exception;

    ILiglPage goToDSIPage() throws Exception;

    ILiglPage waitAndvalidateForRecordToCompleteCollection(String status) throws Exception;

    ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1, String GmailCheck, String BatchNAME, String USER, String EMAIL) throws Exception;

    ILiglPage navigateToDataSourcesPage() throws Exception;

    ILiglPage goToApprovalPage();
    ILiglPage goToPreservation() throws Exception;
    ILiglPage goToDMLHScope();
    ILiglPage validateAndWaitForRecordsToCompleteLock(String s)throws Exception;
    ILiglPage goToPreservationLHScope();

    ILiglPage goToDataManagementSummary() throws Exception;
    ILiglPage caseApprovalIrrespectiveOfApprovalConfig(String BchName,String Apptemp,String UserName,String CaseNameApprove) throws Exception;

    ILiglPage sendingLegalHoldForApproval() throws Exception;

    ILiglPage approvingLegalHold() throws InterruptedException;

    ILiglPage creatingNewTemplate() throws Exception;

    ILiglPage goToAdministrationPage() throws Exception;

    ILiglPage sendCaseForApprovalWithAllScope(String BchName,String Apptemp,String UserName) throws Exception;

    ILiglPage goToSecurityPage() throws InterruptedException;
    ILiglPage searchCCDWithCustNameAndDSName(String CustName,String DST)throws Exception;
    ILiglPage checkResultsCount()throws Exception;
    ILiglPage legalHoldApprovalIrrespectiveOfApprovalConfig(String LHName,String LHAction,String Apptemp,String UserName,String CaseNameApprove) throws Exception;
    ILiglPage checkingRetainRecordAddedPrevGrid(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String PreviuosLHLDR,String PreviuosLHLKW,String LatestLHLDR,String LatestLHLKW)throws Exception;

    ILiglPage sendingCaseForSingleApproval(String BatchNAME, String USER, String EMAIL) throws Exception;
    ILiglPage createLHWithOnlyDR(String lhName, String custTemp, String startDate, String endDate) throws Exception;

    ILiglPage goToAdminLeftMenu() throws Exception;

    ILiglPage goToCaseCounselPage() throws Exception;

    ILiglPage validateCustodianAfterApproved(String Employee1) throws Exception;

    ILiglPage goToCaseManagement() throws InterruptedException;

    ILiglPage verifyApprovalHistoryStatus(String AssignedUser1,String Status1,String Status2,String AssignedUser2) throws Exception;

    ILiglPage sendingCaseForDualApproval(String Employee1,String BatchNAME,String USER1,String USER2,String SubType,String EMAIL) throws Exception;

    ILiglPage verifyingEditBtn() throws Exception;
    ILiglPage sendingCaseCustodianForApproval(String Employee1,String BatchNAME,String USER,String EMAIL) throws Exception;

    ILiglPage checkDSIForCustodians(String Employee1) throws Exception;

    ILiglPage approvingCaseSingleApprover(String CaseNameApprove) throws Exception;

    ILiglPage validateCasePendingForApprovalState() throws Exception;

    ILiglPage verifyApprovalHistoryStatusRejected(String AssignedUser1, String Status3, String AssignedUser2, String Status1) throws Exception;

    ILiglPage rejectingTheCase(String CaseNameApprove) throws Exception;

    ILiglPage enableAndDisableKeywords(String Status1) throws Exception;

    ILiglPage sendingCaseForDualApprovalLinearType(String Employee1, String GmailCheck, String GoogleDriveCheck, String BatchNAME, String EMAIL, String USER1, String USER2, String SubType) throws Exception;

    ILiglPage validateCaseRejectedState() throws Exception;

    ILiglPage sendingCaseForDualApprovalEitherType(String Employee1, String GmailCheck, String GoogleDriveCheck, String DateRange1, String DateRange2, String Keywords1, String Keywords2, String BatchNAME, String EMAIL, String USER1, String USER2, String SubType) throws Exception;

    ILiglPage validateDSIForCustodians(String Employee1) throws Exception;

    ILiglPage verifyColumnsInCustodianGrid() throws Exception;

    ILiglPage validatingUpdatedStatus(String StatusDropDown1) throws Exception;

    ILiglPage addInhouseCounselToCase(String Email1, String CounselName) throws Exception;

    ILiglPage deleteInhouseCounselFromCase() throws Exception;

    ILiglPage addDeleteOutsideCounselToCase(String OptionFromLawFirmDropDwn, String SelectAvailableLawfirm) throws Exception;

    ILiglPage createNewOutsideCounselToCase(String PartyLawFirm, String FirstName, String LastName) throws Exception;

    ILiglPage createNewContactForSelectedParty(String PartyNew, String FirstName, String LastName) throws Exception;

    ILiglPage goToOtherPartyPage() throws Exception;

    ILiglPage goToCasePage() throws Exception;

    ILiglPage verifyingCaseFieldsAreEdited(String CaseTypeDrpDwn, String CaseName1, String CaseSettingTemplateDrpDwn) throws Exception;

    ILiglPage verifyingCaseFieldsAreEditable(String CaseTypeDrpDwn, String CaseName1, String CaseSettingTemplateDrpDwn) throws Exception;

    ILiglPage verifyingApproveStatus() throws Exception;

    ILiglPage sendingCaseForApproval() throws Exception;

    ILiglPage approvingRejectedCase(String CaseNameApprove) throws Exception;

    ILiglPage validateEnableAndDisableKeywords(String Status2) throws Exception;

    ILiglPage deleteContactsAddedForParty(String PartyNew, String ContactName) throws Exception;

    ILiglPage verifyingCaseFieldsAreNonEditable() throws Exception;

    ILiglPage createNewInHouseCounselForEnterpriseParty(String PartyName, String FirstName, String LastName) throws Exception;

    ILiglPage createOtherPartyNewOutsideCounsel(String PartyName, String NameTextBox, String PartyDrpDwn, String Description, String Status, String FirstName, String LastName) throws Exception;

    ILiglPage addingNewParty(String PartyName, String PartyType, String Status, String Description) throws Exception;

    ILiglPage addingExistingParty(String PartyNameA, String PartyNew) throws Exception;

    ILiglPage searchingParty(String s) throws Exception;

    ILiglPage addExistingInHouseCounselToParty(String s) throws Exception;

    ILiglPage searchCourt(String s) throws Exception;

    ILiglPage sendCaseForApproval(String s1, String s2, String s3) throws Exception;

    ILiglPage approvalHistoryCheck(String s1, String s2) throws Exception;

    ILiglPage selectRecordInApprovalRequestsGrid(String s) throws Exception;

    ILiglPage approveCase(String s) throws Exception;

    ILiglPage sendRejectedCaseApproval() throws Exception;

    ILiglPage activeInactiveCustodians(String s1, String s2) throws Exception;

    ILiglPage editWFT(String wft) throws Exception;

    ILiglPage revokeCase() throws Exception;

    ILiglPage navigateToProsecutor() throws Exception;

    ILiglPage createNewProsecutor(String CounselFN, String CounselLN) throws Exception;

    ILiglPage validateProsecutorAddedToGrid(String FirstName, String LastName) throws Exception;

    ILiglPage searchProsecutor(String s1, String s2) throws Exception;

    ILiglPage deleteProsecutor(String FirstName, String LastName) throws Exception;

    ILiglPage sendLHNToCustodian(String CustName) throws InterruptedException;

    ILiglPage deActivateActiveCustodian(String s1, String s2) throws Exception;

    ILiglPage editDueDate(String s) throws Exception;

    ILiglPage caseCreateWithAdditionalFields(Hashtable<String, String> data) throws Exception;

    ILiglPage editAdditionalFields(String costCentre, String caseAlias, String drpDownVal) throws Exception;

    ILiglPage checkRegionIsMandatory(Hashtable<String, String> data) throws Exception;

    ILiglPage addExistingOutCounsel(String s1, String s2) throws Exception;

    ILiglPage createNewJudge(String s1, String s2) throws Exception;

    ILiglPage validateJudgeAddedToGrid(String s1, String s2) throws Exception;

    ILiglPage datesIssuedFields(String s1, String s2, String s3, String s4) throws Exception;

    ILiglPage cancelInEditDocument(String s) throws Exception;

    public ILiglPage updateInEditDocument(String s) throws Exception;

    ILiglPage addExistingContact(String s) throws Exception;

    ILiglPage goToOutSideCounselInOtherParty() throws Exception;

    ILiglPage addOutCounselWithAddLawFirmBtn(String s1, String s2, String s3, String s4, String s5) throws Exception;

    ILiglPage createNewCourt(String s1, String s2, String s3,String s4) throws Exception;

    ILiglPage validateCourtAddedToGrid(String s) throws Exception;

    ILiglPage validateEnableAndDisableDateRanges(String Status2) throws Exception;

    ILiglPage createNewCounselForSelectedOutsideCounsel(String PartyNew, String OptionFromLawFirmDropDwn, String FirstName, String LastName) throws Exception;

    ILiglPage navigateToCourtPage() throws Exception;

    ILiglPage addCourtToCase(String AvailableCourt) throws Exception;

    ILiglPage searchingAddedCourt(String AvailableCourt) throws Exception;

    ILiglPage navigateAndAddProsecutor(String AvailableCourt, String AvailableProsecutor1, String AvailableProsecutor2, String AvailableProsecutor3, String AvailableProsecutor4) throws Exception;

    ILiglPage addOneMoreInhouseCounselToCase(String Email2, String CounselName1) throws Exception;

    ILiglPage navigateToDateRangesPage() throws Exception;

    ILiglPage addDateRanges(String StartDate1, String EndDate1, String DescriptionBox) throws Exception;

    ILiglPage validatingDateRanges() throws Exception;

    ILiglPage navigateToKeyWordsPage() throws Exception;

    ILiglPage addKeywordsByBasic(String Keywords1) throws Exception;

    public ILiglPage addKeywordsByCustom(String Keywords1, String DataSource1) throws Exception;

    ILiglPage verifyingTheStatusDropDownForACase(String StatusDropDown1) throws Exception;

    ILiglPage validatingKeywords() throws Exception;

    ILiglPage validatingKeywordsByKeywordType() throws Exception;

    ILiglPage addCustodiansToCaseThroughFilters(String Employee1, String Employee2) throws Exception;

    ILiglPage validatingCustodians(String Employee2) throws Exception;

    ILiglPage validateInhouseCounsel() throws Exception;

    ILiglPage validateOutSideCounsel() throws Exception;

    ILiglPage validateNewOutSideCounselAdded(String OutSideCounsel) throws Exception;

    ILiglPage searchingAddedOutsideCounsel(String OutSideCounsel) throws Exception;

    ILiglPage searchingContact(String ContactName) throws Exception;

    ILiglPage validatingContactAddedForParty(String ContactName) throws Exception;

    ILiglPage validatingContactsAfterDeletingFromParty() throws Exception;

    ILiglPage searchingInHouseCounsel(String PartyName, String CounselName) throws Exception;

    ILiglPage validateAddedInHouseCounsel(String CounselName) throws Exception;

    ILiglPage validateAddedOutsideCounsel(String OutSideCounselName) throws Exception;

    ILiglPage searchingOutSideCounsel(String PartyNew, String OptionFromLawFirmDropDwn) throws Exception;

    ILiglPage validateProsecutors(String AvailableProsecutor1, String AvailableProsecutor2, String AvailableProsecutor3, String AvailableProsecutor4) throws Exception;

    ILiglPage validateOneOrMoreInhouseCounsel(String CounselName, String CounselName1) throws Exception;

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

    ILiglPage sendingCaseForApprovalAfterAddingScopeItems(String BatchNAME, String USER, String EMAIL) throws Exception;

    ILiglPage clickOnSendForApprovalButton() throws Exception;

    ILiglPage clickOnCustodianCheckBoxForApproval(String Emp1) throws Exception;

    ILiglPage clickOnNextButtonForApproval() throws Exception;

    ILiglPage clickOnDataSourceCheckBoxForApproval(String DataSource1) throws Exception;

    ILiglPage viewCase() throws Exception;


    // Smoke Suite Methods

    ILiglPage validateAndWaitForRecordsToCompleteCollection(String CollectionStatus) throws Exception;

    ILiglPage validateAndWaitForRecordsToCompleteProcessing(String Processingstatus) throws Exception;

    ILiglPage clickOnDateRangesCheckBoxForApproval(String DateRange) throws Exception;

    ILiglPage clickOnKeywordsCheckBoxForApproval(String KeyWords) throws Exception;

    ILiglPage addDataSourceRecordToDSIGridUptoCollection(String cust, String datasource, String DataHold) throws Exception;

    ILiglPage validateLHStatus(String Status) throws Exception;

    ILiglPage searchRequiredLegalHoldName(String LHname) throws Exception;

    ILiglPage clickOnLHCheckbox(String LHname) throws Exception;

    ILiglPage clickOnActionDropDownAndRun(String Action1) throws Exception;

    ILiglPage selectTemplateAndApproverAndClickOnSendBtn(String Template1, String ApproverName) throws Exception;

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

    ILiglPage clickOnCreateStakeHolderBtnInLH(String FirstName, String LastName, String StakeDepartment, String StakeEmailID, String StakeCategoryValue) throws Exception;

    ILiglPage searchStakeholderEmailFromLHNGrid(String StakeEmailID) throws Exception;

    ILiglPage verifyStakeholderEmailIsDisplayed(String StakeEmailID) throws Exception;

    ILiglPage validateDisplayOfDefaultTemplateInLHReleasePopup(String DefaultTemplate) throws Exception;

    ILiglPage secondSearch(String LHname) throws Exception;

    ILiglPage sendBtnInTestMail() throws Exception;

    ILiglPage validateMyHoldsGridData() throws Exception;

    ILiglPage legalHoldNotes() throws Exception;

    ILiglPage createNewNotes(String RequestBy, String NotesContent) throws Exception;

    ILiglPage validateDataInNotesGrid(String desc) throws Exception;

    ILiglPage editNotes(String RequestBy, String NotesDescription) throws Exception;

    ILiglPage clickOnAddNewLegalHoldButton() throws Exception;

    ILiglPage verifyCreatedLegalHoldIsDisplayed(String LHname) throws Exception;

    ILiglPage clickOnLegalholdGridRefreshButton() throws Exception;

    ILiglPage verifyEditedLegalHoldIsDisplayed(String LHname) throws Exception;

    ILiglPage editLegalHoldWhenOnFlyIsFalse(String EditedLegalHoldname, String CustodianQTemplate, String LHname) throws Exception;

    ILiglPage createNewLegalHoldWhenOnFlyIsFalse(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception;

    ILiglPage validateAddedCourts(String CourtAdded) throws Exception;

    ILiglPage clickOnCourtName(String CourtName1) throws Exception;

    ILiglPage clickOnAddJudgeButton() throws Exception;

    ILiglPage addExistingJudgesToCourt(String Judge) throws Exception;

    ILiglPage validateAddedJudges(String Judge) throws Exception;

    ILiglPage validateCreatedCase(String CaseName) throws Exception;

    ILiglPage searchRequiredCaseDocument(String CaseDocument) throws Exception;

    ILiglPage clickOnCaseDocument(String CaseDocument) throws Exception;

    ILiglPage deletingAddedParty(String PartyName) throws Exception;

    ILiglPage validatedeletedparty(String PartyName) throws Exception;

    ILiglPage verifyProvidingCaseAccessToUsersInSecurityUsersDropdown(String Name) throws Exception;

    ILiglPage searchRequiredFullNameInUsersDropdown(String Fullname) throws Exception;

    ILiglPage verifyAdditionalColumnsInCustodianGrid() throws Exception;

    ILiglPage verifyCreatedByColDataInCaseGrid(String CreatedByName) throws Exception;

    ILiglPage clickAndChooseColumnsInCaseGrid() throws Exception;

    ILiglPage verifyChooseColumnsDataInCaseGrid(String ApprovedOrRejectedExpected, String ApprovalTypeExpected) throws Exception;

    ILiglPage verifyAdditionalFieldsInCasePopup(String AddField1, String AddField2, String AddField3, String AddField5) throws Exception;

    ILiglPage searchRequiredApprovalBatchName(String AppBatchname) throws Exception;

    ILiglPage verifyColumnsDatainAdditionalScopeApprovalGrid(String ApprovalBatchNameExpected, String CustodiansCountExpected, String DatasourcesCountExpected, String KeywordsCountExpected, String DateRangesCountExpected, String ApprovalStatusColumnExpected, String ApprovalTypeExpected, String ApprovalUsersExpected, String ApprovedOrRejectedOnExpected) throws Exception;

    ILiglPage verifyNonApprovedScopeInCustomTab(String Custodian, String Datasource, String Daterange, String Keyword) throws Exception;

    ILiglPage navigateToNotesHistoryPage() throws Exception;

    ILiglPage verifyColumnsInNotesHistoryGrid() throws Exception;

    ILiglPage goToRequiredLegalHoldName(String LHname) throws Exception;

    ILiglPage verifyColumnsInLHNCustodianGrid() throws Exception;

    ILiglPage verifyColumnsInLHNStakeHolderGrid() throws Exception;

    ILiglPage searchActionThroughEmail(String Email1) throws Exception;

    ILiglPage verifySentByAndSentOnData(String Sentby, String Senton) throws Exception;

    ILiglPage clickActionOnResponseDocument() throws Exception;

    ILiglPage validateRecordWhenLHNStatusIsInNotintiatedState(String status) throws Exception;

    ILiglPage clickOnActionDropDownAndRunInStakeHolder(String Action1) throws Exception;

    ILiglPage validateLHNStatus(String LHNStatus) throws Exception;

    ILiglPage selectTemplateAndClickOnSendBtn(String Template1) throws Exception;

    ILiglPage clickOnRefreshButtonStakeHolder() throws Exception;

    ILiglPage createNewLegalHold(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception;

    ILiglPage clickOnEditButtonInLHNGrid() throws Exception;

    ILiglPage clearActionInLegalHold() throws Exception;

    ILiglPage clickOnRefreshButtonLHGrid() throws Exception;

    ILiglPage clickOnRemainderButtonInRemainderConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception;

    ILiglPage clickOnEscalationButtonInEscalationConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception;

    ILiglPage navigateToEmployeeMasterPage() throws Exception;

    ILiglPage validateEscalationAndRemainderDefaultValues() throws Exception;

    ILiglPage navigateToEscalationAndRemainder() throws Exception;

    ILiglPage createLegalHoldUptoEscalation(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception;

    ILiglPage editEscalationAndRemainderConfigValues(String Remainderdays, String Remaindermails, String Remainderfrequency, String Escalationdays, String Escalationmails, String Escalationfrequency) throws Exception;


    ILiglPage clickOnSendButton() throws Exception;

    ILiglPage searchThroughEmail(String Email) throws Exception;

    ILiglPage performEditAction(String EmployeeName) throws Exception;

    ILiglPage editEmployeeStatus(String Estatus) throws Exception;

    ILiglPage createNewLegalHoldByStartDateEndDateNumberOfDays(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate, String Startdate, String Enddate, String Days) throws Exception;

    ILiglPage clickOnChooseColumnMenu() throws Exception;

    ILiglPage searchTheColumnsInColumnMenuInLHGrid(String Column) throws Exception;

    ILiglPage selectTheColumnCheckBox(String COLUMN) throws Exception;

    ILiglPage validateTheDRandKWInDisableMode() throws Exception;

    ILiglPage enterKeyWords(String keywords) throws Exception;

    ILiglPage enterDateRanges(String Startdate, String Enddate, String Days) throws Exception;

    ILiglPage clickOnSaveBtn() throws Exception;

    ILiglPage clickOnStakeHolderNoticeTemplate(String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception;

    ILiglPage clickOnNextBtn6() throws Exception;

    ILiglPage clickOnNextBtn5() throws Exception;

    ILiglPage clickOnNextBtn4() throws Exception;

    ILiglPage clickOnNextBtn3() throws Exception;

    ILiglPage clickOnNextBtn2() throws Exception;

    ILiglPage clickOnNextBtn1() throws Exception;

    ILiglPage enterCustodianNoticeTemplate(String CustodianTemplate, String CustodianQuestionaireTemplate) throws Exception;

    ILiglPage enterNameOfTheLH(String LegalHoldname) throws Exception;

    ILiglPage clickOnTheDownloadLHNLink() throws Exception;

    ILiglPage validateTheButtonsInDisableMode() throws Exception;

    ILiglPage validateTheColumnsNames() throws Exception;

    ILiglPage clearActionInLHColumnMenu() throws Exception;
    ILiglPage noteColStats()throws Exception;
    ILiglPage getAndValidateCCDStats() throws Exception;
    ILiglPage editLH_DR_KW(String lhName1,String startDate, String endDate, String keyword)throws Exception;

    ILiglPage checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid(String CaseNameApprove, String keywords) throws Exception;

    ILiglPage checkTheLHPopUpDetailsInDisabledCondition() throws Exception;
    ILiglPage createLHWith_KW_DR(String lhName, String custTemp, String startDate, String endDate, String keyword) throws Exception;

    ILiglPage createNewLHBySelectingTemplateOnFlyEdit(String LegalHoldname, String CustodianTemplate, String NewtempName, String subject, String content) throws Exception;

    ILiglPage createNewLegalHoldByDateRangeKeyWords(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate, String Startdate, String Enddate, String Days, String keywords) throws Exception;

    /**
     * Admin-General
     */
    /*User and Roles Page*/
    AdminLeftMenu getAdminLeft();

    public ILiglPage refreshUserAndRolesPage() throws Exception;

    public ILiglPage newLogin(String userName, String password) throws Exception;

    public ILiglPage loginPageValidation(String userName, String password) throws Exception;

    public ILiglPage SSOLoginValidation(String userName, String password) throws Exception;

    public ILiglPage checkTheAlertNoRoleAssign() throws Exception;

    public ILiglPage verifyInActiveUserLoginValidation() throws Exception;

    public ILiglPage verifyInActiveSSOUserLoginValidation() throws Exception;

    public ILiglPage clickOnAddUserButton() throws Exception;

    public ILiglPage swithToLiglUser() throws Exception;

    public ILiglPage searchTheUser(String selectUser) throws Exception;

    public ILiglPage scrollToRightToDoActionInUsers(String selectUser) throws Exception;

    public ILiglPage clickOnEditButton(String user) throws Exception;

    public ILiglPage duplicateValidationMessageForLiglUser() throws Exception;

    public ILiglPage duplicateValidationMessageForSSOUser() throws Exception;

    public ILiglPage unavailabilityOfChangePasswordOption() throws Exception;

    public ILiglPage creatingLiglUser(
            String userName, String email, String firstName,
            String middleName, String lastName, String role, String status, String passWordConfirmation,
            String password, String confirmPassword, String sendPasswordInEmail
    ) throws Exception;

    public ILiglPage creatingSSOUser(
            String email, String firstName, String middleName, String lastName, String role, String status
    ) throws Exception;

    public ILiglPage editTheUser(
            String editUserName, String editEmail, String editFirstName,
            String editMiddleName, String editLastName, String editRole, String editStatus,
            String userEditingConfirmation
    ) throws Exception;

    public ILiglPage editSSOUser(String editEmail, String editFirstName,
                                 String editMiddleName, String editLastName, String editRole, String editStatus
    ) throws Exception;

    public ILiglPage changePasswordInUserProfile(String oldPassword, String newPassword, String confirmPassword) throws Exception;

    public ILiglPage adminResetPassword(String conformManualPawdReset, String password, String confirmPassword) throws Exception;

    public ILiglPage changePasswordAfterUserLogin(
            String changePasswordConfirmation, String oldPassword,
            String newPassword, String confirmPassword
    ) throws Exception;

    public ILiglPage acceptEula() throws Exception;

    public ILiglPage restPasswordClickDisabledForSSOUser(String searchSSOUser) throws Exception;

    public ILiglPage passwordValidation() throws Exception;

    public ILiglPage oldPasswordValidation() throws Exception;

    public ILiglPage changeRole(String roleChangeTo) throws Exception;

    public ILiglPage changeSSORole(String roleChangeTo) throws Exception;

    public ILiglPage loggedInUserRoleAfterRoleChanged(String expectedRole) throws Exception;

    /*Employee Master Page*/
    public ILiglPage clickOnImport() throws Exception;

    public ILiglPage clickOnEmployee() throws Exception;

    public ILiglPage searchAndSelectTheEmployee(String employee) throws Exception;

    public ILiglPage clickOnAddEmployeeButton() throws Exception;

    public ILiglPage employeeBulkImport(String importEmpFile) throws Exception;
    ILiglPage getCCDStats() throws IOException;
    ILiglPage goToExports(String s);


    public ILiglPage createNewEmployee(
            String id, String firstName, String middleName, String lastName,
            String alias, String department, String title, String checkTitleOptional, String lastUpdate,
            String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String empEmail, String alternateEmail, String secondaryEmail,
            String mobileNumber, String telephoneNumber, String faxNumber, String category, String entity, String location, String division,
            String accountType, String accountManagerFirstName, String accountManagerMiddleName, String accountManagerLastName, String reportingManager,
            String officeType, String officeName, String officeAddressLine, String officeAddressBuildingCode, String officeAddressCampusCode,
            String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity, String officeAddressState, String affiliation,
            String homeDepartmentCode
    ) throws Exception;

    public ILiglPage editEmployee(
            String firstName, String middleName, String lastName,
            String department, String title, String checkTitleOptional, String lastUpdate,
            String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String alternateEmail,
            String secondaryEmail, String mobileNumber, String telephoneNumber, String faxNumber,
            String accountType, String accountManagerFirstName, String accountManagerMiddleName, String accountManagerLastName,
            String reportingManager, String entity, String officeName, String officeAddressLine, String officeAddressBuildingCode,
            String officeAddressCampusCode, String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity,
            String officeAddressState, String affiliation, String homeDepartmentCode
    ) throws Exception;

    public ILiglPage empNonEditableFields() throws Exception;

    public ILiglPage employeeMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
            throws Exception;

    public ILiglPage editableFiedsHRStatusHireDateTerminatedDate(String empJoinDate, String empTerminatedDate, String status)
            throws Exception;

    public ILiglPage titleFieldName() throws Exception;

    public ILiglPage availablityOfOptionlDropDowns() throws Exception;

    public ILiglPage availablityOfOptionlFields() throws Exception;

    /*Contact Master*/
    public ILiglPage clickOnAddContactButton() throws Exception;

    public ILiglPage searchAndSelectTheContact(String firstName) throws Exception;

    public ILiglPage createContact(String firstName, String middleName, String lastName, String title, String isPrimaryContact,
                                   String status, String contactType, String partyType, String partyName, String primaryEmail,
                                   String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
                                   String addressLine2, String country, String state, String city, String zip) throws Exception;

    public ILiglPage editContact(String firstName, String middleName, String lastName, String title, String contactType,
                                 String status, String primaryContact, String partyType, String partyName, String primaryEmail,
                                 String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
                                 String addressLine2, String country, String state, String city, String zip) throws Exception;

    public ILiglPage checkPartyName(String contactType, String partyType, String partyName) throws Exception;

    public ILiglPage contactMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
            throws Exception;

    public ILiglPage checkPartyNameBasedOnSelectedContactType(String contactType, String partyType) throws Exception;

    /* Parties Page */

    public ILiglPage clickOnAddPartyButton() throws Exception;

    public ILiglPage searchAndSelectTheParties(String partiesName) throws Exception;

    public ILiglPage craeteNewParty(String name, String partyType, String department, String status, String description,
                                    String website, String email, String phone, String telephone, String fax,
                                    String addressLine1, String addressLine2, String addressLine3, String country,
                                    String state, String city, String zip) throws Exception;

    public ILiglPage editParty(String name, String partyType, String department, String status, String statusChangeReason,
                               String description, String website, String email, String phone, String telephone, String fax,
                               String addressLine1, String addressLine2, String addressLine3, String country,
                               String state, String city, String zip) throws Exception;

    public ILiglPage partyMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
            throws Exception;

    /*Email Template Page*/
    public ILiglPage createNewEmailTemplate(String emailTemplateCategory, String emailTemplateName, String subject,
                                            String content) throws Exception;

    public ILiglPage editEmailTemplate(String emailTemplateCategory, String emailTemplate, String subject,
                                       String content) throws Exception;

    public ILiglPage checkWhetherAddTemplateAndDeleteButtonsAreDisabled(String emailTemplateCategory,
                                                                        String emailTemplate) throws Exception;

    /*Case Settings Page*/

    public ILiglPage createCaseSettingsTemplate(String caseSettingsTemplateName, String Description, String kWE,
                                                String workSpaceTemplateId, String clientTemplateId,
                                                String processingProfiles) throws Exception;

    public ILiglPage checkNewlyCreatedCaseSettingTemplatePopulatedInCaseSettingsTemplateDropDown(String caseSettingsTemplate) throws Exception;

    /*Lookup Manager Page*/
    public ILiglPage selectLookupType(String lookup) throws Exception;

    public ILiglPage clickOnNewButton() throws Exception;


    public ILiglPage searchAndSelectTheLookUp(String name) throws Exception;

    public ILiglPage createLookUp(String name, String displayOrder, String description, String entityType) throws Exception;

    public ILiglPage editLookUp(String name, String displayOrder, String description, String entityType) throws Exception;

    public ILiglPage checkNewlyCreatedLookupPopulatedInRequestTypeDropDown(String requestType) throws Exception;

    public ILiglPage checkNewlyCreatedLookupPopulatedInCaseTypeDropDown(String caseType) throws Exception;

    /**
     * Admin-Legal Hold
     */
    /*Stakeholder Page*/

    public ILiglPage clickOnAddStakeholderButton() throws Exception;

    public ILiglPage createStakeholder(String firstName, String middleName, String lastName, String email,
                                       String department, String category) throws Exception;

    public ILiglPage editExitingStakeholder(String firstName, String middleName, String lastName, String email,
                                            String department, String category, String status, String reason) throws Exception;

    public ILiglPage scrollToRightToDoAction(String email) throws Exception;

    public ILiglPage searchTheStakeholder(String email) throws Exception;

    public ILiglPage deleteTheExitingStakeholder() throws Exception;

    public ILiglPage checkStakeholderDisplayingInGrid(String email) throws Exception;

    public ILiglPage verifyTheDuplicateValidationMessage() throws Exception;
    public ILiglPage verifyRecordStatusInLHNSH(String LHStatus) throws Exception;
    public ILiglPage checkDeletedStakeholderISDisplayingInLHStakeholderGrid(String email) throws Exception;
    public  ILiglPage addInActiveEMPToCase(String s) throws Exception;
    /*
     * Manage QuestionBank
     * */
    public ILiglPage refreshTheManageQuestionBankPage() throws Exception;
    public ILiglPage clickOnQuestionnaireButton() throws Exception;
    ILiglPage goToMatters() throws Exception;
    ILiglPage searchMatter(String matter);

    public ILiglPage clickOnEditInQuestionGrid() throws Exception;
    ILiglPage googleVaultLogin(String s1,String s2,String s3)throws Exception;

    public ILiglPage scrollToRightToDoActionInManageQuestionGrid(String question) throws Exception;

    /**/
    public ILiglPage clickOnQuestionnaire() throws Exception;
    public ILiglPage selectAllCCDs() throws InterruptedException;
    ILiglPage multipleCCDsSelect(Hashtable<String, String> data)throws Exception;
    public ILiglPage searchTheQuestion(String question) throws Exception;
    ILiglPage validateCollectionStats()throws Exception;

    public ILiglPage searchChildQuestion(String childQuestion) throws Exception;

    ILiglPage clikcOnStakeholderLink() throws Exception;

    ILiglPage clickOnAddRequestButton() throws Exception;

    ILiglPage validateListOfColumnsInTheRequestPage() throws Exception;

    ILiglPage validateCreatedRequestInTheGlobalRequestGrid(String TITLE) throws Exception;

    ILiglPage clickOnEditIconInTheGrid(String TITLE) throws Exception;

    ILiglPage addAllDetailsInTheAddRequestPopUpWithoutAssignee(String RequestType,String REQTitle,String CaseDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception;

    ILiglPage addAllDetailsInTheAddRequestPopUp(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception;

    public ILiglPage createNewQuestionnaire(String questionnaireTitle, String renderType, String IsParent,
                                            String IsQuestionMandatory, String RenderOptions, String Description,
                                            String AppliesTo, String searchParentQuestion) throws Exception;

    public ILiglPage editExitingQuestionnaire(String questionnaireTitle, String IsQuestionMandatory,
                                              String Description) throws Exception;
    public ILiglPage checkAppliesToIsNonEditableField() throws Exception;

    public ILiglPage verifyTheIsParentOption(String question) throws Exception;

    public ILiglPage verifyParentQuestionColumn(String question)throws Exception;
    public ILiglPage clickAddPartyBtns()throws Exception;
    public ILiglPage addExistingProsecutor(String CounselFullName)throws Exception;

    /**
     * ManageQuestionnaireTemplatesPage
     */

    public ILiglPage clickOnAddTemplate(Hashtable<String, String> data) throws Exception;

    public ILiglPage clickOnEditButtonInManageQuestionnaireTemplate() throws Exception;

    public ILiglPage clickOnAddNewQuestionButton() throws Exception;

    public ILiglPage selectQuestionnaireTemplate(String questionnaireTemplate) throws Exception;

    public ILiglPage searchTheQuestionInManageQuestionTemplate(String question) throws Exception;

    public ILiglPage createNewQuestionnaireTemplates(Hashtable<String, String> data) throws Exception;

    public ILiglPage addQuestionToManageQuestionnaireTemplate(Hashtable<String, String> data) throws Exception;

    public ILiglPage deLinkTheQuestion(String question) throws Exception;

    public ILiglPage editQuestionnaireTemplate(Hashtable<String, String> data) throws Exception;

    public ILiglPage checkThatNewlyCreatedQuestionnaireIsDisplaying(String legalHoldName, String custodianNotice,
                                                                    String custodianQuestionner, String stakeholderNotice,
                                                                    String stakeholderQuestionner) throws Exception;

    public ILiglPage getQuestionnaireTemplateName(String setQuestion) throws Exception;
    /**
     * Escalation And Reminder
     */

    public ILiglPage createLegalHoldWithEscalationAndReminderConfigurations(Hashtable<String, String> data) throws Exception;
    public ILiglPage getReminderConfigurationsValuesInLegalHoldAtCaseLevel(String legalHoldName, String setReminderDays, String setReminderFrequency,
                                                                           String setReminderMailsCap) throws Exception;
    public ILiglPage getEscalationConfigurationsValuesInLegalHoldAtCaseLevel(String setEscalationDays, String setEscalationFrequency,
                                                                             String setEscalationMailsCap) throws Exception;
    public ILiglPage checkThatReminderConfigurationsInLegalHoldAtAminLevel(String checkReminderDay, String checkReminderFrequency,
                                                                           String checkReminderMailsCap) throws Exception;
    public ILiglPage checkThatEscalationConfigurationsInLegalHoldAtAminLevel(String checkEscalationDay, String checkEscalationFrequency,
                                                                             String checkEscalationMailsCap) throws Exception;

    /**
     * Manage Display Content
     */
    public ILiglPage verifyTheParametersInManageDisplayContent(String manageContentCategory,String parameter1, String parameter2) throws Exception;
    /************************************************End Admin************************************************************************************/

    ILiglPage addMessageWhenReqIsInProgress(String TextBoxArea) throws Exception;

    ILiglPage moveToTheParticularColumn(String TITLE) throws Exception;

    ILiglPage validateStatusOfTheRequest(String status) throws Exception;

    ILiglPage clickOnViewIconInTheGrid() throws Exception;

    ILiglPage validateMessageBoxIsInDisableMode() throws Exception;

    ILiglPage clickOnNotificationIcon() throws Exception;

    ILiglPage searchForTheParticularTitleOfTheRequest(String title) throws Exception;

    ILiglPage clickOnTheRequestAlertInTheNotificationIcon(String assignedrequest,String PageTitle) throws Exception;

    ILiglPage validateReqAlertInTheNotificationIcon(String request) throws Exception;

    ILiglPage sendAdditionalMessageWhenReqIsInNewStatus(String TextBoxArea) throws Exception;

    ILiglPage clickOnBackToRequestButton() throws Exception;

    ILiglPage modifyIntoTheRequiredStatus(String status) throws Exception;

    ILiglPage checkAndValidateTheCountOfRequestUnderNewInProgressCloseStats(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea,String status1,String status2) throws Exception;

    ILiglPage addAllDetailsInTheAddRequestPopUpByAssigningToRole(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception;


    ILiglPage clickOnAddRequestButtonInCaseRequests() throws Exception;

    ILiglPage navigateToCaseLevelRequests() throws Exception;

    ILiglPage validateTheFieldValuesInAddRequestPopUp(String FieldValues) throws Exception;

    ILiglPage clearActionInCaseDropDown() throws Exception;
    ILiglPage clickOnChooseACaseDropDown() throws Exception;

    ILiglPage validatingNonApprovedCasesInCaseDropDown(String CaseDropDown) throws Exception;

    ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB, String PartyType, String Description,String StatusDrpdown) throws Exception;

    ILiglPage searchRequiredDaterangeName(String DRname) throws Exception;

    ILiglPage disabledDateRangeNotesClick(String DRName) throws Exception;

    ILiglPage NotesDelete(String NotesContent) throws Exception;

    ILiglPage validateDeletedNote(String NotesContent) throws Exception;

    ILiglPage enabledDateRangeNotesClick(String DRName) throws Exception;
    ILiglPage navigateToDashboardPage() throws Exception;

    ILiglPage clickOnProcessInsightsTab() throws Exception;

    ILiglPage clickOnReviewInsightsTab() throws Exception;

    ILiglPage clickOnLegalHoldInsightsTab() throws Exception;

    ILiglPage checkAndValidateTheCountOfTheProcessInsightsStats(String Email) throws Exception;

    ILiglPage checkAndValidateTheCountOfTheLegalHoldInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String LHname,String Action) throws Exception;

    ILiglPage selectCase() throws Exception;

    ILiglPage validateTheNavigateToDashBoardPageURL(String PageTitle) throws Exception;

    ILiglPage clickOnProductionInsightsTab() throws Exception;

    ILiglPage clickOnGlobalInsightsTab() throws Exception;

    ILiglPage validateDashBoardPageURL(String PageTitle) throws Exception;

    ILiglPage clearCaseFunctionality() throws Exception;

    ILiglPage validateTheSelectCaseNameInHeader() throws Exception;

    ILiglPage checkAndValidateTheFunctionalityOfFromToDateAndApplyButton(String SYEAR,String SMONTH,String SDATE,String EYEAR,String EMONTH,String EDATE) throws Exception;
    ILiglPage clickOnPrintButton() throws Exception;

    ILiglPage checkAndValidateTheCountOfTheCaseInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String Pstatus) throws Exception;

    ILiglPage clickOnClearAllButton() throws Exception;

    ILiglPage validateThePrintButtonFunctionality() throws Exception;

    ILiglPage checkAndValidateTheCountOfTheGlobalInsightsStats(String CaseName,String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus) throws Exception;

    ILiglPage validateUserAccessCasesCountWhenUACsetToFalse(String USERname,String PASSword,String ENTITYSelection,String Title) throws Exception;


    ILiglPage searchLastDateModifiedColumnAndValidateTheCountInDashBoard(String Comparator,String Date,String Month,String Year,String Title) throws Exception;





    ILiglPage searchRequiredKeywordName(String KWname) throws Exception;

    ILiglPage enabledKeywordsNotesClick(String KWname) throws Exception;

    ILiglPage disabledKeywordsNotesClick(String KWname) throws Exception;

    ILiglPage validateUnavailabilityOfActionColumnInEmployeeMasterFromInHouseCounselPage() throws Exception;

    ILiglPage validateUnavailabilityOfActionColumnInEmployeeMasterFromCustodiansPage() throws Exception;

    ILiglPage verifyUnavailabilityOfSecurityTabInLeftMenu() throws Exception;

    ILiglPage verifyAvailabilityOfHelpLinkInCaseListPage() throws Exception;
    ILiglPage goToNotesPage() throws InterruptedException;
    public ILiglPage notesSearchFilter(String name) throws Exception;
    public ILiglPage TypeofEventSearchFilter(String TypeofEvent) throws Exception;
    public ILiglPage notesEdit(String RequestBy,String NotesDescription) throws Exception;
    public ILiglPage validateDeletedNoteForMultipleRecords() throws Exception;
    public ILiglPage validateDeleteNote() throws Exception;
    public ILiglPage displayingSelectedNotesList(String TOE) throws Exception;
    public ILiglPage caseEditInplace() throws Exception;
    public ILiglPage reAssignCaseForSingleApproval(String EMAIL,String USER) throws Exception;
    public ILiglPage reAssignCaseForDualApproval(Hashtable<String, String> data) throws Exception;
    public ILiglPage validateRevokeCaseForSingleApproval(String a,String b) throws Exception;
    public ILiglPage validateRevokeCaseForDualApproval(String a,String b,String c) throws Exception;
    public ILiglPage validateReassignForSingleApproval(String a,String b) throws Exception;
    public ILiglPage validateReassignForDualApproval(String a,String b,String c) throws Exception;
    public ILiglPage caseEditInplaceisSelected() throws Exception;
    public ILiglPage goToNotesPageFromDocuments();
    public ILiglPage createCaseWithoutInplacePreservation(Hashtable<String,String> data) throws Exception;
    public ILiglPage verifyingCaseRoleIsNonEditable() throws Exception;
    public ILiglPage detailsColumnData(String Details) throws Exception;

    ILiglPage createNewCaseWithInPlacePreservation(Hashtable<String,String> data) throws Exception;

    ILiglPage deleteTheRequiredNotes() throws Exception;

    ILiglPage validatingEmailsInDB() throws Exception;

    ILiglPage createLHWithOnlyKW(String lhName, String custTemp, String Keywords) throws Exception;

    ILiglPage validateEmpData(String custodianName, String emailID) throws Exception;

    ILiglPage createLHWithOut_KW_DR(String lhName, String custTemp) throws Exception;
    ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(String Status) throws Exception;

    ILiglPage validateLHKW(String ExpectedLHLKW) throws Exception;

    ILiglPage validateLHDR(String ExpectedLHLDR) throws Exception;

    ILiglPage validateGSuiteDST_LockWithSingleLegalHoldWithoutFilters(String Status) throws Exception;
    ILiglPage checkingSingleCCDRecordIsReplacedWithLatestFilters(String CustName, String DST, String LockCompleteStatus, String LockNotInitiateStatus, String ExpectedLHLDR, String ExpectedLHLKW) throws Exception;

    ILiglPage checkingRetainRecordAddedPrevGrid(String CustName, String DST, String LockCompleteStatus, String LockNotInitiateStatus, String ExpectedLHLDR, String ExpectedLHLKW) throws Exception;
    ILiglPage goToIdentification() throws Exception;
    ILiglPage goToCollection() throws Exception;
    ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(String Status) throws Exception;
}

