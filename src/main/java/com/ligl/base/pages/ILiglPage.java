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
    ILiglPage login(String userName, String password) throws Exception;
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

    ILiglPage checkLHNForCustodians(String LHN,String Employee1) throws Exception;

    void selectDateFromCalendar(String date);
    ILiglPage goToDefaultLandingPage();

    public ILiglPage searchcase(String casename) throws Exception;
    public ILiglPage GoToCase(String CaseName) throws Exception;

    ILiglPage validateCustodianBeforeApproved() throws Exception;

    ILiglPage goToDataManagement() throws Exception;

    ILiglPage addDataSource(String DataSource) throws Exception;

    ILiglPage addCustodianToCase(String Email1) throws Exception;

    ILiglPage addDataSourceRecordToDSIGrid(String cust,String datasource,String DataHold) throws Exception;

    ILiglPage addDataSources() throws Exception;
    ILiglPage automateRecordInDSI()throws Exception;
    ILiglPage goToDSIPage() throws Exception;

    ILiglPage waitAndvalidateForRecordToCompleteCollection(String status)throws Exception;

    ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1,String GmailCheck,String BatchNAME,String USER ,String EMAIL) throws Exception;
    ILiglPage navigateToDataSourcesPage() throws Exception;

    ILiglPage goToApprovalPage();

    ILiglPage goToDataManagementSummary() throws Exception;

    ILiglPage sendingLegalHoldForApproval() throws Exception;

    ILiglPage approvingLegalHold() throws Exception;

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

    ILiglPage sendingCaseForDualApprovalLinearType(String Employee1,String GmailCheck,String GoogleDriveCheck,String BatchNAME,String USER1,String USER2,String SubType,String EMAIL) throws Exception;

    ILiglPage validateCaseRejectedState() throws Exception;

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

    ILiglPage searchRequiredLegalHoldName(String LHname) throws Exception;

    ILiglPage goToRequiredLegalHoldName(String LHname) throws Exception;

    ILiglPage verifyColumnsInLHNCustodianGrid() throws Exception;

    ILiglPage verifyColumnsInLHNStakeHolderGrid() throws Exception;

    ILiglPage searchActionThroughEmail(String Email1) throws Exception;

    ILiglPage verifySentByAndSentOnData(String Sentby ,String Senton) throws Exception;

    ILiglPage switchOnToTheStakeHolderTab() throws Exception;

    ILiglPage clickActionOnResponseDocument() throws Exception;

    ILiglPage clickOnActionDropDownAndRun(String Action1) throws Exception;

    ILiglPage validateRecordWhenLHNStatusIsInNotintiatedState(String status) throws Exception;

    ILiglPage clickOnActionDropDownAndRunInStakeHolder(String Action1) throws Exception;

    ILiglPage validateLHNStatus(String LHNStatus) throws Exception;

    ILiglPage clickOnRefreshButton() throws Exception;

    ILiglPage clickOnRefreshButtonStakeHolder() throws Exception;

    ILiglPage selectTemplateAndClickOnSendBtn(String Template1) throws Exception;

    ILiglPage createNewLegalHold(String LegalHoldname,String CustodianTemplate,String CustodianQuestionaireTemplate,String StakeHolderTemplate,String StakeHolderQueTemplate) throws Exception;

    ILiglPage clickOnEditButtonInLHNGrid() throws Exception;

    ILiglPage clearActionInLegalHold() throws Exception;

    ILiglPage clickOnAddNewLegalHoldButton() throws Exception;

    ILiglPage clickOnRefreshButtonLHGrid() throws Exception;

    ILiglPage clickOnRemainderButtonInRemainderConfigTab(String LegalHoldname,String CustodianTemplate,String StakeHolderTemplate) throws Exception;

    ILiglPage clickOnEscalationButtonInEscalationConfigTab(String LegalHoldname,String CustodianTemplate,String StakeHolderTemplate) throws Exception;

    ILiglPage navigateToEscalationAndRemainder() throws Exception;

    ILiglPage validateEscalationAndRemainderDefaultValues() throws Exception;

    ILiglPage viewCase() throws Exception;

    ILiglPage createLegalHoldUptoEscalation(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception;

    ILiglPage editEscalationAndRemainderConfigValues(String Remainderdays, String Remaindermails, String Remainderfrequency,String Escalationdays, String Escalationmails, String Escalationfrequency) throws Exception;

    ILiglPage navigateToEmployeeMasterPage() throws Exception;

    ILiglPage searchThroughEmail(String Employee) throws Exception;

    ILiglPage performEditAction(String EmployeeName) throws Exception;

    ILiglPage editEmployeeStatus(String Estatus) throws Exception;
    ILiglPage clickOnSendButton() throws Exception;

    ILiglPage createNewLegalHoldByStartDateEndDateNumberOfDays(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days) throws Exception;


    ILiglPage createNewLegalHoldByDateRangeKeyWords(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days,String keywords) throws Exception;

    ILiglPage checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid(String CaseNameApprove,String keywords) throws Exception;

    ILiglPage checkTheLHPopUpDetailsInDisabledCondition() throws Exception;
}
