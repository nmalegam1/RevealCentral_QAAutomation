package com.ligl.base.pages;

import com.ligl.pages.DashboardPage;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.administration.AdminLeftMenu;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.session.LiglTestSession;
import org.apache.poi.xwpf.usermodel.BreakType;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.ligl.pages.Header;
import com.ligl.web.IWebConnector;

import java.awt.*;
import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

public class LiglBasePage implements ILiglPage {

	public LiglBasePage() {
		//System.out.println("----------LiglBasePage Consructor-------");
		PageFactory.initElements(getCurrentDriver(), this);
		// set the page in the session
		getSession().setCurrentPage(this);
	}

	public ILiglPage openBrowser(String browser) {
		System.out.println("LiglBasePage openBrowser");
		return null;
	}

	public ILiglPage createLHWithOut_KW_DR(String lhName, String custTemp) throws Exception{
		return null;
	}

	public ILiglPage caseApprovalIrrespectiveOfApprovalConfig(String BchName,String Apptemp,String UserName,String CaseNameApprove) throws Exception{
		return null;
	}

	public ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPLHScopeGrid(String Status) throws Exception{
		return null;
	}

	public ILiglPage validateLHKW(String ExpectedLHLKW) throws Exception{
		return null;
	}

	public ILiglPage validateLHDR(String ExpectedLHLDR) throws Exception{
		return null;
	}

	public ILiglPage validateGSuiteDST_LockWithSingleLegalHoldWithoutFilters(String Status) throws Exception{
		return null;
	}

	public ILiglPage editLH_DR_KW(String lhName1,String startDate, String endDate, String keyword)throws Exception{
		return null;
	}

	public ILiglPage goToPreservation() throws Exception{
		return null;
	}

	public ILiglPage goToPreservationLHScope(){
		return null;
	}

	public ILiglPage searchCCDWithCustNameAndDSName(String CustName,String DST)throws Exception{
		return null;
	}

	public ILiglPage checkResultsCount()throws Exception{
		return null;
	}

	public ILiglPage checkingSingleCCDRecordIsReplacedWithLatestFilters(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String ExpectedLHLDR,String ExpectedLHLKW)throws Exception{
		return null;
	}

	public ILiglPage createLHWith_KW_DR(String lhName, String custTemp, String startDate, String endDate, String keyword) throws Exception{
		return null;
	}

	public ILiglPage checkingRetainRecordAddedPrevGrid(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String ExpectedLHLDR,String ExpectedLHLKW)throws Exception{
		return null;
	}

	public ILiglPage goToDMLHScope(){
		return null;
	}
	public ILiglPage addOnpremDataSource(String s)throws Exception{return null;}
	public void quit() {
		// TODO Auto-generated method stub
	}

	public ILiglPage navigateURL() throws Exception {
		return null;
	}

	public ILiglPage submitUsername(String userid) {
		return null;

	}
	public ILiglPage goToUsersRoles()throws Exception{return null;}
	public ILiglPage goToEmployeeMasterpage()throws Exception{return null;}
	public ILiglPage selectOnpremDataSourceForApproval(String s)throws Exception{return null;}
	public ILiglPage addingDSToDSIThroughCustom(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage submitPassword(String userid) {
		return null;
	}

	@Override
	public IWebConnector validator(boolean stopExecution) {
		// update the flag in web layer
		getSession().getCon().setStopExecution(stopExecution);
		return getSession().getCon();
	}

	public ILiglPage logout() throws Exception {
		return null;
	}

	public ILiglPage checkCustodianRoleInUserCreationPopUp(String s)throws Exception{return null;}
	public ILiglPage login(String userName, String password,String Entity) throws Exception {
		return null;
	}
	public ILiglPage createNewCounselForSelectedOutsideCounsel(String PartyNew,String OptionFromLawFirmDropDwn,String FirstName,String LastName) throws Exception {
		return null;
	}
	public ILiglPage sendLHNToApproval(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage searchcase(String casename) throws Exception {return null;}

	public ILiglPage GoToCase(String CaseName) throws Exception {return null;}
	public ILiglPage goToLegalHold(String s)throws  Exception{return null;}
	public ILiglPage firstSearch()throws InterruptedException{return null;}
	public ILiglPage resendLHN(String s1,String s2)throws Exception{return null;}

	public ILiglPage adminLogin(String userName, String password, String entity) throws Exception{return null;}
	public ILiglPage validateAdminRole() throws Exception {return null;}
	public ILiglPage createNewCase(Hashtable<String,String> data) throws Exception {
		return null;
	}

	public ILiglPage navigateSSOLoginPage(){
		return null;
	}
	public ILiglPage SSOLogin(String userName, String password,String Entity) throws InterruptedException {
		return null;
	}

	public ILiglPage goToPMSummaryPage() throws Exception{
		return null;
	}



	public LiglTestSession getSession() {
		return (LiglTestSession)Reporter.getCurrentTestResult().getTestContext().getAttribute("session");
	}

	public IWebConnector getDriver() {
		return getSession().getCon();
	}

	public EventFiringWebDriver getCurrentDriver() {
		return getSession().getCon().getCurrentDriver();
	}

	public void log_Info(String message) {
		getSession().log_Info(message);
	}

	@Override
	public ILiglPage multipleCustodianSelect(Hashtable<String, String> data) throws Exception {
		return null;
	}

	@Override
	public ILiglPage multipleDataSourceSelect(Hashtable<String, String> data) throws Exception {
		return null;
	}

	public void log_Pass(String message) {
		getSession().log_Pass(message);
	}

	public void log_Error(String message) {
		getSession().log_Error(message);
	}
	public ILiglPage validateIntermediatePageOptions() {
		return null;
	}
	public ILiglPage goToDefaultLandingPage() {
		return null;
	}
	public ILiglPage goToAboutPage() {
		return null;
	}
	public ILiglPage selectEntity(String entity){return null;}
	public ILiglPage clickClearFilterBtn() {
		return null;
	}
	public Header getHeader() {
		return null;
	}
	public LeftMenu getLeftMenu() {
		return null;
	}
	public ILiglPage sendingCaseCustodianForApproval(String Employee1,String BatchNAME,String USER,String EMAIL) throws Exception{
		return null;
	}
	public ILiglPage validateDSIForCustodians(String Employee1) throws Exception{
		return null;
	}
	public ILiglPage goToCaseManagement() throws InterruptedException{
		return null;
	}
	public ILiglPage verifyingEditBtn() throws Exception{
		return null;
	}
	public ILiglPage navigateToCustodiansPage() throws Exception { return  null;}

	public ILiglPage navigateToLegalHoldPage()  { return  null;}

	public  ILiglPage sendingCaseForDualApproval(String Employee1,String BatchNAME,String USER1,String USER2,String SubType,String EMAIL) throws Exception{
		return null;
	}

	public ILiglPage goToSecurityPage() throws InterruptedException{
		return null;
	}
	public ILiglPage sendingCaseForSingleApproval(String BatchNAME,String USER,String EMAIL) throws Exception{
		return null;
	}
	public ILiglPage goToDSIPage() throws Exception{
		return null;
	}
	public ILiglPage sendingCaseForApprovalWithScopeItems(String Employee1,String GmailCheck,String BatchNAME,String USER ,String EMAIL) throws Exception{
		return  null;
	}
	public ILiglPage waitAndvalidateForRecordToCompleteCollection(String status)throws Exception{
		return  null;
	}
	public ILiglPage goToDataManagementSummary() throws Exception{
		return  null;
	}
	public ILiglPage addDataSourceRecordToDSIGrid(String cust,String datasource,String DataHold,String DateRanges,String Keywords) throws Exception{
		return  null;
	}
	public ILiglPage automateRecordInDSI()throws Exception{
		return  null;
	}
	public ILiglPage addDataSource(String DataSource) throws Exception{
		return  null;
	}

	public ILiglPage goToLegalHoldPage() throws Exception {return null;}
	public ILiglPage navigateToDataSourcesPage() throws Exception { return  null;}
	public void selectDateFromCalendar(String date) {
	}

	public ILiglPage addCustodianToCase(String Email1) throws Exception {
		return null;
	}
	public ILiglPage addDataSources(String s) throws Exception {
		return null;
	}
	public ILiglPage validatePartyCreatedOrNot(String s)throws Exception{return null;}
	public ILiglPage addingNewParty(String s1,String s2,String s3)throws Exception{return null;}
	public ILiglPage createAndValidatePartyCreatedOrNot(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage validateCustodianAddedToGrid(String s)throws Exception{return null;}
	public ILiglPage editDataSources(String s1,String s2)throws Exception{return null;}
	public ILiglPage validateCaseNotinitiatedState() throws Exception{
		return null;
	}
	public ILiglPage validateCustodianAfterApproved(String Employee1) throws Exception{
		return null;
	}
	public ILiglPage validateCasePendingForApprovalState() throws Exception{
		return null;
	}
	public ILiglPage verifyApprovalHistoryStatus(String AssignedUser1,String Status1,String Status2,String AssignedUser2) throws Exception{
		return  null;
	}
	public ILiglPage validateCaseRejectedState() throws Exception{
		return null;
	}
	public ILiglPage verifyColumnsInCustodianGrid() throws Exception{
		return null;
	}
	public ILiglPage goToCaseCounselPage() throws Exception {
		return null;
	}
	public ILiglPage verifyApprovalHistoryStatusRejected(String AssignedUser1,String Status3,String AssignedUser2,String Status1) throws Exception{
		return null;
	}
	public ILiglPage sendingCaseForDualApprovalLinearType(String Employee1,String GmailCheck,String GoogleDriveCheck,String BatchNAME,String EMAIL,String USER1,String USER2,String SubType) throws Exception{
		return null;
	}
	public ILiglPage rejectingTheCase(String CaseNameApprove) throws Exception{
		return null;
	}

	public ILiglPage sendingCaseForDualApprovalEitherType(String Employee1,String GmailCheck,String GoogleDriveCheck,String DateRange1,String DateRange2,String Keywords1,String Keywords2,String BatchNAME,String EMAIL,String USER1,String USER2,String SubType) throws Exception{
		return null;
	}
	public ILiglPage addCustodiansToCaseThroughFilters(String Employee1,String Employee2) throws Exception {
		return null;
	}
	public ILiglPage validatingCustodians(String Employee1) throws Exception {
		return null;
	}
	public ILiglPage addInhouseCounselToCase(String Email1, String CounselName) throws Exception {
		return null;
	}
	public ILiglPage deleteInhouseCounselFromCase() throws Exception {
		return null;
	}
	public ILiglPage createNewInHouseCounselForEnterpriseParty(String PartyName,String FirstName,String LastName) throws Exception {
		return null;
	}
	public ILiglPage addOneMoreInhouseCounselToCase(String Email2,String CounselName1) throws Exception {
		return null;
	}
	public ILiglPage navigateToDateRangesPage () throws Exception {
		return null;
	}
	public ILiglPage addDateRanges(String StartDate1 ,String EndDate1,String DescriptionBox) throws Exception {
		return null;
	}
	public ILiglPage validatingDateRanges() throws Exception {
		return null;
	}
	public ILiglPage navigateToKeyWordsPage() throws Exception {
		return null;
	}

	public ILiglPage addKeywordsByBasic(String Keywords1) throws Exception {
		return null;
	}
	public ILiglPage addKeywordsByCustom(String Keywords1,String DataSource1) throws Exception {
		return null;
	}
	public ILiglPage validatingUpdatedStatus(String StatusDropDown1) throws Exception{
		return null;
	}
	public ILiglPage verifyingTheStatusDropDownForACase(String StatusDropDown1) throws Exception{
		return null;
	}
	public ILiglPage validateInhouseCounsel() throws Exception{
		return null;
	}
	public ILiglPage approvingRejectedCase(String CaseNameApprove ) throws Exception{
		return null;
	}
	public ILiglPage verifyingApproveStatus() throws Exception{
		return  null;
	}
	public ILiglPage approvingCaseSingleApprover(String CaseNameApprove) throws Exception{
		return null;
	}
	public ILiglPage goToCasePage() throws Exception {
		return null;
	}
	public ILiglPage checkAckModeColumn(String s1, String s2,String s3)throws Exception{return null;}
	public ILiglPage verifyingCaseFieldsAreEditable(String CaseTypeDrpDwn,String CaseName1,String CaseSettingTemplateDrpDwn) throws Exception{
		return null;
	}
	public  ILiglPage sendStealthMode()throws Exception{return null;}
	public ILiglPage selectLHN(String s)throws Exception{return null;}
	public  ILiglPage verifyRecordStatusOfLHN(String s)throws Exception{return null;}
	public ILiglPage refreshLHN()throws InterruptedException{return null;}
	public ILiglPage verifyColumnsInLegalHoldGrid()throws Exception{return null;}
	public ILiglPage verifyCustodianInterviewTranscriptNotes()throws Exception{return null;}
	public ILiglPage createLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Disabled(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10)throws Exception{
		return null;
	}
	public ILiglPage editLHNAfterFirstLHNWith_KW_DR_AndCheckKW_DR_Editable(String s1,String s2,String s3,String s4,String s5,String s6,String s7,String s8,String s9,String s10)throws Exception{
		return null;
	}
	public ILiglPage verifyLHKWCreatedInFirstLHDisplayeingInLHsCreatedLater(String s1,String s2,String s3,String s5,String s4,String s6)throws Exception{return null;}
	public     ILiglPage editLHNCreatedWithDRKW(String s1,String s2,String s3,String s4,String s5,String s6)throws Exception{return null;}
	public ILiglPage verifyFieldsInAddLegalHoldModel(String s1,String s2)throws Exception{return null;}
	public ILiglPage checkUnableToSetStealthModeToDeactiveCust(String s)throws Exception{return null;}
	public ILiglPage checkReportingManagerFieldinAdditionalFields(String s)throws  Exception{return null;}
	public  ILiglPage verifyRecordStatusInLHN(String s)throws Exception{return null;}
	public ILiglPage searchLHNThroughEmail(String s)throws Exception{return null;}
	public ILiglPage editExistingLHNWithOnFlyEditOfCustTemp(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage verifyingCaseFieldsAreEdited(String CaseTypeDrpDwn,String CaseName1,String CaseSettingTemplateDrpDwn) throws Exception{
		return null;
	}
	public ILiglPage verifyingCaseFieldsAreNonEditable() throws Exception{
		return null;
	}
	public ILiglPage sendingCaseForApproval() throws Exception{
		return null;
	}
	public ILiglPage enableAndDisableKeywords(String Status1) throws Exception{
		return null;
	}
	public ILiglPage validateEnableAndDisableKeywords(String Status2) throws Exception{
		return null;
	}
	public ILiglPage enableAndDisableDateRanges(String Status1) throws Exception{
		return null;
	}
	public ILiglPage validateEnableAndDisableDateRanges(String Status2) throws Exception{
		return null;
	}

	public ILiglPage validateOutSideCounsel() throws Exception{
		return null;
	}
	public ILiglPage validateNewOutSideCounselAdded(String OutSideCounsel) throws Exception{
		return null;
	}

	public ILiglPage validatingKeywords() throws Exception {
		return null;
	}
	public ILiglPage searchingAddedOutsideCounsel(String OutSideCounsel) throws Exception{
		return null;
	}
	public ILiglPage searchingContact(String ContactName) throws Exception{
		return null;
	}
	public ILiglPage validatingContactAddedForParty(String ContactName) throws Exception{
		return null;
	}
	public ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB, String PartyType, String Description,String StatusDrpdown) throws Exception {
		return null;
	}

	public ILiglPage navigateToDashboardPage()throws Exception{
		return null;
	}
	public ILiglPage validatingContactsAfterDeletingFromParty() throws Exception{
		return null;
	}
	public ILiglPage validatingKeywordsByKeywordType() throws Exception {
		return null;
	}
	public ILiglPage searchingInHouseCounsel(String PartyName,String CounselName) throws Exception{
		return null;
	}

	public ILiglPage validateAddedInHouseCounsel(String CounselName) throws Exception{
		return null;
	}
	public ILiglPage searchingOutSideCounsel(String PartyNew,String OptionFromLawFirmDropDwn) throws Exception{
		return null;
	}
	public ILiglPage validateProsecutors(String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception{
		return null;
	}
	public ILiglPage validateOneOrMoreInhouseCounsel(String CounselName,String CounselName1) throws Exception{
		return null;
	}
	public ILiglPage validateAddedOutsideCounsel(String OutSideCounselName) throws Exception{
		return null;
	}
	public ILiglPage goToApprovalPage(){
		return null;
	}
	public ILiglPage createOtherPartyNewOutsideCounsel(String PartyName,String NameTextBox,String PartyDrpDwn,String Description,String Status,String FirstName,String LastName) throws Exception {
		return null;
	}
	public ILiglPage addingNewParty(String PartyName, String PartyType, String Status, String Description) throws Exception {
		return null;
	}
	public ILiglPage validateAddedNewOutsideCounsel(String OutsideCounsel,String NameTextBox) throws Exception{
		return null;
	}
	public ILiglPage searchingParty(String s) throws Exception {
		return null;
	}
	public ILiglPage searchCourt(String s)throws Exception{return null;}
	public ILiglPage createNewJudge(String s1,String s2)throws Exception{return null;}
	public ILiglPage validateJudgeAddedToGrid(String s1,String s2)throws Exception{return null;}
	public  ILiglPage datesIssuedFields(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage cancelInEditDocument(String s)throws Exception{return null;}
	public ILiglPage updateInEditDocument(String s)throws Exception{return null;}
	public ILiglPage addExistingContact(String s)throws Exception{return null;}
	public ILiglPage approvalHistoryCheck(String s1,String s2)throws Exception{return null;}
	public ILiglPage selectRecordInApprovalRequestsGrid(String s)throws Exception{return null;}
	public ILiglPage approveCase(String s)throws Exception{return null;}
	public ILiglPage sendRejectedCaseApproval()throws Exception{return null;}
	public ILiglPage checkRegionIsMandatory(Hashtable<String,String> data) throws Exception{return null;}
	public ILiglPage editWFT(String wft) throws Exception{return null;}
	public ILiglPage revokeCase() throws Exception{return null;}
	public ILiglPage navigateToProsecutor()throws Exception{return null;}
	public ILiglPage createNewProsecutor(String CounselFN,String CounselLN) throws Exception{return null;}
	public ILiglPage validateProsecutorAddedToGrid(String FirstName,String LastName) throws Exception{return null;}
	public ILiglPage searchProsecutor(String s1, String s2) throws Exception{return null;}
	public  ILiglPage deleteProsecutor(String FirstName, String LastName) throws Exception{return null;}

	@Override
	public ILiglPage sendLHNToCustodian() throws InterruptedException {
		return null;
	}

	public ILiglPage sendLHNToCustodian(String CustName) throws InterruptedException{return null;}
	public ILiglPage activeInactiveCustodians(String s1,String s2)throws Exception{return null;}
	public ILiglPage deActivateActiveCustodian(String s1,String s2)throws Exception{return null;}
	public ILiglPage editDueDate(String s)throws Exception{return null;}
	public ILiglPage caseCreateWithAdditionalFields(Hashtable<String,String> data) throws Exception{return null;}
	public ILiglPage editAdditionalFields(String costCentre,String caseAlias,String drpDownVal) throws Exception{return null;}
	public ILiglPage addExistingInHouseCounselToParty(String s)throws Exception{return null;}
	public ILiglPage addExistingOutCounsel(String s1,String s2)throws Exception{return null;}
	public ILiglPage sendCaseForApproval(String s1,String s2,String s3)throws Exception{return null;}
	public ILiglPage addOutCounselWithAddLawFirmBtn(String s1,String s2,String s3,String s4,String s5)throws Exception{return null;}
	public ILiglPage goToOutSideCounselInOtherParty()throws Exception{return null;}
	public ILiglPage addingExistingParty(String PartyNameA,String PartyNew) throws Exception {
		return null;
	}
	public ILiglPage validateCourtAddedToGrid(String s)throws Exception{return null;}
	public ILiglPage createNewCourt(String s1,String s2,String s3,String s4)throws Exception{return null;}
	public ILiglPage sendingLegalHoldForApproval() throws Exception {
		return null;
	}
	public ILiglPage checkLHNForCustodians(String LHN) throws Exception{
		return null;
	}

	public ILiglPage checkDSIForCustodians(String Employee1) throws Exception{
		return null;
	}
	public ILiglPage goToDataManagement() throws Exception{
		return null;
	}
	public ILiglPage validateCustodianBeforeApproved() throws Exception{
		return null;
	}
	public ILiglPage approvingLegalHold() throws InterruptedException {
		return null;
	}
	public ILiglPage creatingNewTemplate() throws Exception {
		return null;
	}
	public  ILiglPage goToAdministrationPage() throws Exception {
		return null;
	}
	public ILiglPage goToAdminLeftMenu() throws Exception {
		return null;
	}
	public ILiglPage addDeleteOutsideCounselToCase(String OptionFromLawFirmDropDwn , String SelectAvailableLawfirm) throws Exception {
		return null;
	}
	public ILiglPage createNewOutsideCounselToCase(String PartyLawFirm,String FirstName,String LastName) throws Exception {
		return null;
	}
	public ILiglPage createNewContactForSelectedParty(String PartyNew,String FirstName ,String LastName) throws Exception {
		return null;
	}
	public ILiglPage goToOtherPartyPage () throws Exception {
		return null;
	}

	public ILiglPage navigateToCourtPage () throws Exception {
		return null;
	}
	public ILiglPage addCourtToCase(String AvailableCourt) throws Exception {
		return null;
	}
	public ILiglPage searchingAddedCourt(String AvailableCourt) throws Exception {
		return null;
	}
	public ILiglPage navigateAndAddProsecutor(String AvailableCourt,String AvailableProsecutor1,String AvailableProsecutor2,String AvailableProsecutor3,String AvailableProsecutor4) throws Exception {
		return null;
	}

	public ILiglPage deleteContactsAddedForParty(String PartyNew, String ContactName) throws Exception {
		return null;
	}

	// Actions For Adding An Employee To Custodian

	public ILiglPage addCustodianToCaseAtOneTime(String Email1) throws Exception{
		return  null;
	}
	public ILiglPage clickOnFilterButtonOnly() throws Exception{
		return  null;
	}
	public ILiglPage clickOnTheCutsodianCheckBox(String Emp1) throws Exception{
		return null;
	}
	public ILiglPage clickOnAddToCaseButton() throws Exception{
		return null;
	}
	public ILiglPage performClearAction(String Email2) throws Exception{
		return null;
	}

	// Adding Data Sources To The Custodian

	public ILiglPage addingDataSource(String DataSource) throws Exception{
		return null;
	}
	public ILiglPage clickOnSaveButton() throws Exception{
		return null;
	}

	// Adding Records To DSI Page

	public ILiglPage searchAccountEmailRecordInDSI(String Email1) throws Exception{
		return null;
	}

	public ILiglPage searchAccountEmailOneMoreTime() throws Exception{
		return null;
	}
	public ILiglPage clickOnCheckBoxOfCustodian() throws Exception{
		return null;
	}
	public ILiglPage sendingAccountEmailOneMorTime(String Email2) throws Exception{
		return null;
	}
	public ILiglPage clickOnAutomateButton() throws Exception{
		return null;
	}
	// Approving Case With Custodian And Datasources

	public ILiglPage sendingCaseForApprovalAfterAddingScopeItems(String BatchNAME,String USER ,String EMAIL) throws Exception{
		return null;
	}
	public ILiglPage clickOnSendForApprovalButton() throws Exception{
		return null;
	}
	public ILiglPage clickOnCustodianCheckBoxForApproval(String Emp1) throws Exception{
		return null;
	}
	public ILiglPage clickOnNextButtonForApproval() throws Exception{
		return null;
	}
	public ILiglPage clickOnDataSourceCheckBoxForApproval(String DataSource1) throws Exception{
		return null;
	}
	public ILiglPage viewCase() throws Exception{
		return null;
	}

	@Override
	public ILiglPage validateAndWaitForRecordsToCompleteCollection(String CollectionStatus) throws Exception {
		return null;
	}

	public ILiglPage validateAndWaitForRecordsToCompleteLockOrCollectionInIPPAllGrid(String Status) throws Exception{
		return null;
	}

	// Smoke Suite Methods

	public ILiglPage validateAndWaitForRecordsToCompleteProcessing(String Processingstatus)throws Exception{
		return null;
	}
	public ILiglPage clickOnDateRangesCheckBoxForApproval(String DateRange) throws Exception{
		return null;
	}
	public ILiglPage clickOnKeywordsCheckBoxForApproval(String KeyWords) throws Exception{
		return null;
	}
	public  ILiglPage addInActiveEMPToCase(String s) throws Exception {return null;}

	public ILiglPage addDataSourceRecordToDSIGridUptoCollection(String cust, String datasource, String DataHold) throws Exception {
		return null;
	}
	public ILiglPage verifyRecordStatusInLHNSH(String LHStatus) throws Exception{return null;}
	public ILiglPage validateLHStatus(String Status) throws Exception{
		return null;
	}
	public ILiglPage searchRequiredLegalHoldName(String LHname) throws Exception{
		return null;
	}

	public ILiglPage clickOnLHCheckbox(String LHname) throws Exception{
		return null;
	}

	public  ILiglPage clickOnActionDropDownAndRun(String Action1) throws Exception{
		return null;
	}

	public ILiglPage selectTemplateAndApproverAndClickOnSendBtn(String Template1,String ApproverName) throws Exception{
		return null;
	}
	public ILiglPage validateSSCopyeesList() throws Exception{
		return  null;
	}

	public ILiglPage clickOnApprovedLH(String LHname) throws Exception{
		return null;
	}

	public ILiglPage searchRequiredLHNStatus(String Status) throws Exception{
		return null;
	}

	public ILiglPage clickOnRefreshButton() throws Exception{
		return null;
	}

	public ILiglPage copyeeSScancelBtnClick() throws Exception{
		return null;
	}

	public ILiglPage copyeeReleaseCancelBtnClick() throws Exception{
		return null;
	}

	public ILiglPage validateRCopyeesList() throws Exception{
		return null;
	}

	public ILiglPage clickOnPendingLHNameInAppPage(String CaseLHname) throws Exception{
		return null;
	}

	public ILiglPage validateCaseLHDetailsInAppPage(String OnlyLHname) throws Exception{
		return null;
	}

	public ILiglPage clickOnApproveBtnInAppPage() throws Exception{
		return null;
	}

	public ILiglPage myHoldsAcknowledgeLink() throws Exception{
		return null;
	}

	public ILiglPage switchOnToTheStakeHolderTab() throws Exception{
		return null;
	}

	public ILiglPage clickOnCreateStakeHolderBtnInLH(String FirstName,String LastName,String StakeDepartment,String StakeEmailID,String StakeCategoryValue) throws Exception{
		return null;
	}

	public ILiglPage searchStakeholderEmailFromLHNGrid(String StakeEmailID) throws Exception{
		return null;
	}

	public ILiglPage verifyStakeholderEmailIsDisplayed(String StakeEmailID) throws Exception{
		return null;
	}

	public ILiglPage validateDisplayOfDefaultTemplateInLHReleasePopup(String DefaultTemplate) throws Exception{
		return null;
	}

	public ILiglPage secondSearch(String LHname) throws Exception{
		return null;
	}

	public ILiglPage sendBtnInTestMail() throws Exception{
		return null;
	}

	public ILiglPage validateMyHoldsGridData() throws Exception{
		return null;
	}

	public ILiglPage legalHoldNotes() throws Exception{
		return null;
	}

	public ILiglPage createNewNotes(String RequestBy,String NotesContent) throws Exception{
		return null;
	}

	public ILiglPage validateDataInNotesGrid(String desc) throws Exception{
		return null;
	}

	public ILiglPage editNotes(String RequestBy,String NotesDescription) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddNewLegalHoldButton() throws Exception{
		return null;
	}

	public ILiglPage createNewLegalHoldWhenOnFlyIsFalse(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate, String startdate,String enddate,String keyword) throws Exception{
		return null;
	}

	public ILiglPage verifyCreatedLegalHoldIsDisplayed(String LHname) throws Exception{
		return null;
	}

	public ILiglPage editLegalHoldWhenOnFlyIsFalse(String EditedLegalHoldname,String CustodianQTemplate,String LHname) throws Exception{
		return null;
	}

	public ILiglPage clickOnLegalholdGridRefreshButton() throws Exception{
		return null;
	}

	public ILiglPage verifyEditedLegalHoldIsDisplayed(String LHname) throws Exception{
		return null;
	}

	public ILiglPage validateAddedCourts(String CourtAdded) throws Exception{
		return null;
	}
	public ILiglPage clickOnCourtName(String CourtName1) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddJudgeButton() throws Exception{
		return null;
	}

	public ILiglPage addExistingJudgesToCourt(String Judge) throws Exception{
		return null;
	}

	public ILiglPage validateAddedJudges(String Judge) throws Exception{
		return null;
	}

	public ILiglPage validateCreatedCase(String CaseName) throws Exception{
		return null;
	}

	public ILiglPage searchRequiredCaseDocument(String CaseDocument) throws Exception{
		return null;
	}

	public ILiglPage clickOnCaseDocument(String CaseDocument) throws Exception{
		return null;
	}

	public ILiglPage deletingAddedParty(String PartyName) throws Exception{
		return null;
	}

	public ILiglPage validatedeletedparty(String PartyName) throws Exception{
		return null;
	}

	public ILiglPage verifyProvidingCaseAccessToUsersInSecurityUsersDropdown(String Name) throws Exception{
		return null;
	}

	public ILiglPage searchRequiredFullNameInUsersDropdown(String Fullname) throws Exception{
		return null;
	}

	public ILiglPage verifyAdditionalColumnsInCustodianGrid() throws Exception{
		return null;
	}

	public ILiglPage verifyCreatedByColDataInCaseGrid(String CreatedByName) throws Exception{
		return null;
	}

	public ILiglPage clickAndChooseColumnsInCaseGrid() throws Exception{
		return null;
	}

	public ILiglPage verifyChooseColumnsDataInCaseGrid(String ApprovedOrRejectedExpected, String ApprovalTypeExpected) throws Exception{
		return null;
	}

	public ILiglPage verifyAdditionalFieldsInCasePopup(String AddField1,String AddField2,String AddField3,String AddField5) throws Exception{
		return null;
	}

	public ILiglPage searchRequiredApprovalBatchName(String AppBatchname) throws Exception{
		return null;
	}

	public ILiglPage verifyColumnsDatainAdditionalScopeApprovalGrid(String ApprovalBatchNameExpected,String CustodiansCountExpected,String DatasourcesCountExpected,String KeywordsCountExpected,String DateRangesCountExpected,String ApprovalStatusColumnExpected,String ApprovalTypeExpected,String ApprovalUsersExpected,String ApprovedOrRejectedOnExpected) throws Exception {
		return null;
	}

	public ILiglPage navigateToNotesHistoryPage() throws Exception{
		return null;
	}

	public ILiglPage verifyColumnsInNotesHistoryGrid() throws Exception{
		return null;
	}

	public ILiglPage goToRequiredLegalHoldName(String LHname) throws Exception{
		return null;
	}

	public ILiglPage verifyColumnsInLHNCustodianGrid() throws Exception{
		return null;
	}


	public ILiglPage verifyColumnsInLHNStakeHolderGrid() throws Exception{
		return null;
	}

	public ILiglPage searchActionThroughEmail(String Email1) throws Exception{
		return null;
	}

	public ILiglPage verifySentByAndSentOnData(String Sentby ,String Senton) throws Exception{
		return null;
	}

	public ILiglPage clickActionOnResponseDocument() throws Exception{
		return null;
	}
	public ILiglPage validateRecordWhenLHNStatusIsInNotintiatedState(String status) throws Exception{
		return null;
	}

	public ILiglPage clickOnActionDropDownAndRunInStakeHolder(String Action1) throws Exception{
		return null;
	}
	public ILiglPage validateLHNStatus(String LHNStatus) throws Exception{
		return null;
	}
	public ILiglPage selectTemplateAndClickOnSendBtn(String Template1) throws Exception{
		return null;
	}
	public ILiglPage clickOnRefreshButtonStakeHolder() throws Exception{
		return null;
	}

	public ILiglPage createNewLegalHold(String LegalHoldname, String CustodianTemplate, String CustodianQuestionaireTemplate, String StakeHolderTemplate, String StakeHolderQueTemplate) throws Exception {
		return null;
	}

	public ILiglPage clickOnEditButtonInLHNGrid() throws Exception{
		return null;
	}

	public ILiglPage clearActionInLegalHold() throws Exception{
		return null;
	}

	public ILiglPage clickOnRefreshButtonLHGrid() throws Exception{
		return null;
	}
	public ILiglPage clickOnRemainderButtonInRemainderConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception{
		return null;
	}
	public ILiglPage clickOnEscalationButtonInEscalationConfigTab(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception{
		return null;
	}
	public ILiglPage navigateToEmployeeMasterPage() throws Exception{
		return null;
	}

	public ILiglPage validateEscalationAndRemainderDefaultValues() throws Exception{
		return null;
	}

	public ILiglPage navigateToEscalationAndRemainder() throws Exception{
		return null;
	}

	public ILiglPage createLegalHoldUptoEscalation(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate) throws Exception{
		return null;
	}

	public ILiglPage editEscalationAndRemainderConfigValues(String Remainderdays, String Remaindermails, String Remainderfrequency,String Escalationdays, String Escalationmails, String Escalationfrequency) throws Exception {
		return null;
	}

	public ILiglPage clickOnSendButton() throws Exception{
		return null;
	}

	public ILiglPage searchThroughEmail(String Email) throws Exception{
		return null;
	}

	public ILiglPage performEditAction(String EmployeeName) throws Exception{
		return null;
	}

	public ILiglPage editEmployeeStatus(String Estatus) throws Exception{
		return null;
	}
	public ILiglPage createNewLegalHoldByStartDateEndDateNumberOfDays(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days) throws Exception {
		return null;
	}

	public ILiglPage clickOnChooseColumnMenu() throws Exception{
		return null;
	}

	public ILiglPage searchTheColumnsInColumnMenuInLHGrid(String Column) throws Exception{
		return null;
	}

	public ILiglPage selectTheColumnCheckBox(String COLUMN) throws Exception{
		return null;
	}

	public ILiglPage validateTheDRandKWInDisableMode() throws Exception{
		return null;
	}

	public ILiglPage enterKeyWords(String keywords) throws Exception{
		return null;
	}

	public ILiglPage enterDateRanges(String Startdate,String Enddate,String Days) throws Exception{
		return null;
	}

	public ILiglPage clickOnSaveBtn() throws Exception{
		return null;
	}

	public ILiglPage clickOnStakeHolderNoticeTemplate(String StakeHolderTemplate,String StakeHolderQueTemplate) throws Exception{
		return null;
	}

	public ILiglPage clickOnNextBtn6() throws Exception{
		return null;
	}
	public ILiglPage clickOnNextBtn5() throws Exception{
		return null;
	}

	public ILiglPage clickOnNextBtn4() throws Exception{
		return null;
	}
	public ILiglPage clickOnNextBtn3() throws Exception{
		return null;
	}
	public ILiglPage clickOnNextBtn2() throws Exception{
		return null;
	}
	public ILiglPage clickOnNextBtn1() throws Exception{
		return null;
	}

	public ILiglPage enterCustodianNoticeTemplate(String CustodianTemplate) throws Exception{
		return null;
	}

	public ILiglPage enterNameOfTheLH(String LegalHoldname) throws Exception{
		return null;
	}

	public ILiglPage clickOnTheDownloadLHNLink() throws Exception{
		return null;
	}

	public ILiglPage validateTheButtonsInDisableMode() throws Exception{
		return null;
	}

	public ILiglPage validateTheColumnsNames() throws Exception{
		return null;
	}

	public ILiglPage noteColStats()throws Exception{return null;}
	public ILiglPage clearActionInLHColumnMenu() throws Exception{
		return null;
	}
	public ILiglPage getAndValidateCCDStats() throws Exception{return null;}

	public ILiglPage checkWhetherLHDetailsWithPreviewOptionDisplayInTheGrid(String CaseNameApprove,String keywords) throws Exception{
		return null;
	}

	public ILiglPage checkTheLHPopUpDetailsInDisabledCondition() throws Exception{
		return null;
	}

	public ILiglPage createNewLHBySelectingTemplateOnFlyEdit(String LegalHoldname, String CustodianTemplate, String NewtempName,String subject,String content)throws Exception{
		return null;
	}

	public ILiglPage createNewLegalHoldByDateRangeKeyWords(String LegalHoldname, String CustodianTemplate, String StakeHolderTemplate,String Startdate,String Enddate,String Days,String keywords) throws Exception{
		return null;
	}



	public ILiglPage verifyNonApprovedScopeInCustomTab(String Custodian,String Datasource,String Daterange,String Keyword) throws Exception{
		return null;
	}

	/**
	 * Admin-General
	 */
	/*User and Roles Page*/
	public AdminLeftMenu getAdminLeft() {
		return null;
	}

	public ILiglPage refreshUserAndRolesPage() throws Exception{return null;}

	public ILiglPage newLogin(String userName, String password) throws Exception {
		return null;
	}

	public ILiglPage loginPageValidation(String userName, String password) throws Exception {
		return null;
	}

	public ILiglPage SSOLoginValidation(String userName, String password) throws Exception {
		return null;
	}

	public ILiglPage checkTheAlertNoRoleAssign() throws Exception {
		return null;
	}

	public ILiglPage verifyInActiveUserLoginValidation() throws Exception {
		return null;
	}

	public ILiglPage verifyInActiveSSOUserLoginValidation() throws Exception {
		return null;
	}
	public ILiglPage clickOnAddUserButton() throws Exception{return null;}

	public ILiglPage swithToLiglUser() throws Exception{return null;}

	public ILiglPage searchTheUser(String selectUser) throws Exception {return null;}

	public ILiglPage scrollToRightToDoActionInUsers(String selectUser) throws Exception{return null;}

	public ILiglPage clickOnEditButton(String user) throws Exception {
		return null;
	}

	public ILiglPage duplicateValidationMessageForLiglUser() throws Exception {
		return null;
	}

	public ILiglPage duplicateValidationMessageForSSOUser() throws Exception {
		return null;
	}

	public ILiglPage unavailabilityOfChangePasswordOption() throws Exception {
		return null;
	}

	public ILiglPage creatingLiglUser(
			String userName, String email, String firstName,
			String middleName, String lastName, String role, String status,
			String passWordConfirmation, String password, String confirmPassword, String sendPasswordInEmail
	) throws Exception {
		return null;
	}

	public ILiglPage creatingSSOUser(
			String email, String firstName, String middleName, String lastName, String role, String status
	) throws Exception {
		return null;
	}

	public ILiglPage editTheUser(
			String editUserName, String editEmail, String editFirstName,
			String editMiddleName, String editLastName, String editRole, String editStatus,
			String userEditingConfirmation
	) throws Exception {
		return null;
	}

	public ILiglPage editSSOUser(String editEmail, String editFirstName,
								 String editMiddleName, String editLastName, String editRole, String editStatus
	) throws Exception {
		return null;
	}

	public ILiglPage changePasswordInUserProfile(String oldPassword, String newPassword, String confirmPassword)
			throws Exception {
		return null;
	}

	public ILiglPage adminResetPassword(String conformManualPawdReset, String password, String confirmPassword) throws Exception {
		return null;
	}

	public ILiglPage changePasswordAfterUserLogin(
			String changePasswordConfirmation, String oldPassword,
			String newPassword, String confirmPassword
	) throws Exception {
		return null;
	}

	public ILiglPage acceptEula() throws Exception {
		return null;
	}

	public ILiglPage restPasswordClickDisabledForSSOUser(String searchSSOUser) throws Exception {
		return null;
	}

	public ILiglPage passwordValidation() throws Exception {
		return null;
	}

	public ILiglPage oldPasswordValidation() throws Exception {
		return null;
	}

	public ILiglPage changeRole(String roleChangeTo) throws Exception {
		return null;
	}

	public ILiglPage changeSSORole(String roleChangeTo) throws Exception {
		return null;
	}

	public ILiglPage loggedInUserRoleAfterRoleChanged(String expectedRole) throws Exception {
		return null;
	}

	/*Employee Master Page*/

	public ILiglPage clickOnImport() throws Exception {
		return null;
	}

	public ILiglPage clickOnEmployee() throws Exception {
		return null;
	}

	public ILiglPage searchAndSelectTheEmployee(String employee) throws Exception {
		return null;
	}

	public ILiglPage clickOnAddEmployeeButton() throws Exception {
		return null;
	}

	public ILiglPage employeeBulkImport(String importEmpFile) throws Exception {
		return null;
	}

	public ILiglPage createNewEmployee(
			String id, String firstName, String middleName, String lastName,
			String alias, String department, String title, String checkTitleOptional, String lastUpdate,
			String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String empEmail, String alternateEmail, String secondaryEmail,
			String mobileNumber, String telephoneNumber, String faxNumber, String category, String entity, String location, String division,
			String accountType, String accountManagerFirstName, String accountManagerMiddleName, String accountManagerLastName, String reportingManager,
			String officeType, String officeName, String officeAddressLine, String officeAddressBuildingCode, String officeAddressCampusCode,
			String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity, String officeAddressState, String affiliation,
			String homeDepartmentCode
	) throws Exception {
		return null;
	}

	public ILiglPage editEmployee(
			String firstName, String middleName, String lastName,
			String department, String title, String checkTitleOptional, String lastUpdate,
			String empJoinDate, String empTerminatedDate, String status, String empHistoricID, String alternateEmail,
			String secondaryEmail, String mobileNumber, String telephoneNumber, String faxNumber,
			String accountType, String accountManagerFirstName, String accountManagerMiddleName, String accountManagerLastName,
			String reportingManager, String entity, String officeName, String officeAddressLine, String officeAddressBuildingCode,
			String officeAddressCampusCode, String officeAddressMailingCode, String officeAddressZipCode, String officeAddressCity,
			String officeAddressState, String affiliation, String homeDepartmentCode
	) throws Exception {
		return null;
	}

	public ILiglPage empNonEditableFields() throws Exception {
		return null;
	}

	public ILiglPage employeeMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
			throws Exception {
		return null;
	}

	public ILiglPage editableFiedsHRStatusHireDateTerminatedDate(String empJoinDate, String empTerminatedDate, String status)
			throws Exception {
		return null;
	}

	public ILiglPage titleFieldName() throws Exception {
		return null;
	}

	public ILiglPage availablityOfOptionlDropDowns() throws Exception {
		return null;
	}

	public ILiglPage availablityOfOptionlFields() throws Exception {
		return null;
	}

	/*Contact Master*/

	public ILiglPage clickOnAddContactButton() throws Exception {
		return null;
	}

	public ILiglPage searchAndSelectTheContact(String firstName) throws Exception {
		return null;
	}

	public ILiglPage createContact(String firstName, String middleName, String lastName, String title, String isPrimaryContact,
								   String status, String contactType, String partyType, String partyName, String primaryEmail,
								   String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
								   String addressLine2, String country, String state, String city, String zip) throws Exception {
		return null;
	}

	public ILiglPage editContact(String firstName, String middleName, String lastName, String title, String contactType,
								 String status, String primaryContact, String partyType, String partyName, String primaryEmail,
								 String secondaryEmail, String mobile, String telephone, String fax, String addressLine1,
								 String addressLine2, String country, String state, String city, String zip) throws Exception {
		return null;
	}

	public ILiglPage checkPartyName(String contactType, String partyType, String partyName) throws Exception {
		return null;
	}

	public ILiglPage contactMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
			throws Exception {
		return null;
	}

	public ILiglPage checkPartyNameBasedOnSelectedContactType(String contactType, String partyType) throws Exception {
		return null;
	}

	/* Parties Page */

	public ILiglPage clickOnAddPartyButton() throws Exception {
		return null;
	}

	public ILiglPage searchAndSelectTheParties(String partiesName) throws Exception {
		return null;
	}

	public ILiglPage craeteNewParty(String name, String partyType, String department, String status, String description,
									String website, String email, String phone, String telephone, String fax,
									String addressLine1, String addressLine2, String addressLine3, String country,
									String state, String city, String zip) throws Exception {
		return null;
	}

	public ILiglPage editParty(String name, String partyType, String department, String status, String statusChangeReason,
							   String description, String website, String email, String phone, String telephone, String fax,
							   String addressLine1, String addressLine2, String addressLine3, String country,
							   String state, String city, String zip) throws Exception {
		return null;
	}

	public ILiglPage partyMaximumOfDigitsAllowedContctFields(String mobileNumber, String telephoneNumber, String faxNumber)
			throws Exception{
		return null;
	}

	/*Email Template Page*/
	public ILiglPage createNewEmailTemplate(String emailTemplateCategory, String emailTemplateName, String subject,
											String content) throws Exception {
		return null;
	}

	public ILiglPage editEmailTemplate(String emailTemplateCategory, String emailTemplate, String subject,
									   String content) throws Exception {
		return null;
	}

	public ILiglPage checkWhetherAddTemplateAndDeleteButtonsAreDisabled(String emailTemplateCategory,
																		String emailTemplate) throws Exception {
		return null;
	}

	/*Case Settings Page*/

	public ILiglPage createCaseSettingsTemplate(String caseSettingsTemplateName, String Description, String kWE,
												String workSpaceTemplateId, String clientTemplateId,
												String processingProfiles) throws Exception{
		return null;
	}

	public ILiglPage checkNewlyCreatedCaseSettingTemplatePopulatedInCaseSettingsTemplateDropDown(String caseSettingsTemplate) throws Exception{
		return null;
	}
	public ILiglPage getCCDStats() throws IOException {return null;}

	/*Lookup Manager Page*/
	public ILiglPage selectLookupType(String lookup) throws Exception{
		return null;
	}
	public ILiglPage goToExports(String a){return null;}
	public ILiglPage validateAndWaitForRecordsToCompleteLock(String s)throws Exception{return null;}
	public ILiglPage checkingRetainRecordAddedPrevGrid(String CustName,String DST,String LockCompleteStatus,String LockNotInitiateStatus,String PreviuosLHLDR,String PreviuosLHLKW,String LatestLHLDR,String LatestLHLKW)throws Exception{return null;}
	public ILiglPage createLHWithOnlyDR(String lhName, String custTemp, String startDate, String endDate) throws Exception{return null;}
	public ILiglPage clickOnNewButton() throws Exception{return null;}
	public ILiglPage searchAndSelectTheLookUp(String name) throws Exception{return null;}

	public ILiglPage createLookUp(String name, String displayOrder, String description, String entityType) throws Exception{
		return null;
	}

	public ILiglPage editLookUp(String name, String displayOrder, String description, String entityType) throws Exception{
		return null;
	}

	public ILiglPage checkNewlyCreatedLookupPopulatedInRequestTypeDropDown(String requestType) throws Exception{
		return null;
	}

	public ILiglPage checkNewlyCreatedLookupPopulatedInCaseTypeDropDown(String caseType) throws Exception{
		return null;
	}

	/**
	 * Admin-Legal Hold
	 */
	/*Stakeholder Page*/

	public ILiglPage clickOnAddStakeholderButton() throws Exception{return null;}

	public ILiglPage createStakeholder(String firstName, String middleName, String lastName, String email,
									   String department, String category) throws Exception{return null;}

	public ILiglPage editExitingStakeholder(String firstName, String middleName, String lastName, String email,
											String department, String category, String status, String reason)
			throws Exception{return null;}

	public ILiglPage scrollToRightToDoAction(String email) throws Exception {return null;}

	public ILiglPage searchTheStakeholder(String email) throws Exception{return null;}

	public ILiglPage deleteTheExitingStakeholder() throws Exception{return null;}

	public ILiglPage checkStakeholderDisplayingInGrid(String email) throws Exception{return null;}

	public ILiglPage checkDeletedStakeholderISDisplayingInLHStakeholderGrid(String email) throws Exception{return null;}

	@Override
	public ILiglPage clickOnQuestionnaire() throws Exception {
		return null;
	}

	public ILiglPage verifyTheDuplicateValidationMessage() throws Exception{return null;}

	/*
	 * Manage QuestionBank
	 * */
	public ILiglPage refreshTheManageQuestionBankPage() throws Exception{return null;}
	public ILiglPage clickOnQuestionnaireButton() throws Exception{return null;}

	public ILiglPage clickOnEditInQuestionGrid() throws Exception{return null;}

	public ILiglPage scrollToRightToDoActionInManageQuestionGrid(String question) throws Exception{return null;}

	public ILiglPage searchTheQuestion(String question) throws Exception{return null;}

	public ILiglPage searchChildQuestion(String childQuestion) throws Exception{return null;}

	public ILiglPage createNewQuestionnaire(String questionnaireTitle, String renderType, String IsParent,
											String IsQuestionMandatory, String RenderOptions, String Description,
											String AppliesTo, String searchParentQuestion) throws Exception{
		return null;
	}

	public ILiglPage clikcOnStakeholderLink() throws  Exception{
		return null;
	}


	public ILiglPage clickOnAddRequestButton() throws Exception{
		return null;
	}

	public ILiglPage addAllDetailsInTheAddRequestPopUp(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{
		return null;
	}

	public ILiglPage validateCreatedRequestInTheGlobalRequestGrid(String TITLE) throws Exception{
		return null;
	}
	public ILiglPage validateListOfColumnsInTheRequestPage() throws Exception{
		return null;
	}
	public ILiglPage clickOnEditIconInTheGrid(String TITLE) throws Exception{
		return null;
	}
	public ILiglPage goToMatters() throws Exception {return null;}
	public ILiglPage searchMatter(String matter){return null;}

	 public ILiglPage googleVaultLogin(String s1,String s2,String s3)throws Exception{return null;}
	public ILiglPage validateCollectionStats()throws Exception{return null;}
	public ILiglPage addAllDetailsInTheAddRequestPopUpWithoutAssignee(String RequestType,String REQTitle,String CaseDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{
		return null;
	}

	public ILiglPage editExitingQuestionnaire(String questionnaireTitle, String IsQuestionMandatory,
											  String Description) throws Exception{return null;}

	public ILiglPage checkAppliesToIsNonEditableField() throws Exception{return null;}

	public ILiglPage verifyTheIsParentOption(String question) throws Exception{return null;}

	public ILiglPage verifyParentQuestionColumn(String question)throws Exception{return null;}
	public ILiglPage clickAddPartyBtns()throws Exception{return null;}
	public ILiglPage addExistingProsecutor(String CounselFullName)throws Exception{return null;}

	/**
	 * ManageQuestionnaireTemplatesPage*/

	public ILiglPage clickOnAddTemplate(Hashtable<String, String> data) throws Exception{return null;}

	public ILiglPage clickOnEditButtonInManageQuestionnaireTemplate() throws Exception{return null;}

	public ILiglPage clickOnAddNewQuestionButton() throws Exception{return null;}

	public ILiglPage selectQuestionnaireTemplate(String questionnaireTemplate) throws Exception{return null;}

	public ILiglPage searchTheQuestionInManageQuestionTemplate(String question) throws Exception{return null;}

	public ILiglPage createNewQuestionnaireTemplates(Hashtable<String,String> data)
			throws Exception{return null;}

	public ILiglPage addQuestionToManageQuestionnaireTemplate(Hashtable < String, String > data) throws Exception{
		return null;
	}

	public ILiglPage deLinkTheQuestion(String question) throws Exception{return null;}

	public ILiglPage editQuestionnaireTemplate(Hashtable<String, String> data) throws Exception{return null;}

	public ILiglPage checkThatNewlyCreatedQuestionnaireIsDisplaying(String legalHoldName, String custodianNotice,
																	String custodianQuestionner, String stakeholderNotice,
																	String stakeholderQuestionner) throws Exception{
		return null;
	}

	public ILiglPage getQuestionnaireTemplateName(String setQuestion) throws Exception{return null;}

	/**
	 * Escalation And Reminder
	 */

	public ILiglPage createLegalHoldWithEscalationAndReminderConfigurations(Hashtable<String, String> data) throws Exception{
		return null;
	}

	public ILiglPage getReminderConfigurationsValuesInLegalHoldAtCaseLevel(String legalHoldName, String setReminderDays, String setReminderFrequency,
																		   String setReminderMailsCap) throws Exception{
		return null;
	}

	public ILiglPage getEscalationConfigurationsValuesInLegalHoldAtCaseLevel(String setEscalationDays, String setEscalationFrequency,
																			 String setEscalationMailsCap) throws Exception{
		return null;
	}

	public ILiglPage checkThatReminderConfigurationsInLegalHoldAtAminLevel(String checkReminderDay,String checkReminderFrequency,
																		   String checkReminderMailsCap) throws Exception{
		return null;
	}

	public ILiglPage checkThatEscalationConfigurationsInLegalHoldAtAminLevel(String checkEscalationDay,String checkEscalationFrequency,
																			 String checkEscalationMailsCap) throws Exception{
		return null;
	}

	/**
	 * Manage Display Content
	 */
	public ILiglPage verifyTheParametersInManageDisplayContent(String manageContentCategory,
															   String parameter1, String parameter2) throws Exception{
		return null;
	}



	/******************************************************************End Admin******************************************************************/

	public ILiglPage searchForTheParticularTitleOfTheRequest(String title) throws Exception{
		return null;
	}

	public ILiglPage sendAdditionalMessageWhenReqIsInNewStatus(String TextBoxArea) throws Exception{
		return null;
	}

	public ILiglPage clickOnBackToRequestButton() throws Exception{
		return null;
	}

	public ILiglPage modifyIntoTheRequiredStatus(String status) throws Exception{
		return null;
	}

	public ILiglPage clickOnTheRequestAlertInTheNotificationIcon(String assignedrequest,String PageTitle) throws Exception{
		return null;
	}

	public ILiglPage addAllDetailsInTheAddRequestPopUpByAssigningToRole(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea) throws Exception{
		return null;
	}

	public ILiglPage clickOnNotificationIcon() throws Exception{
		return null;
	}

	public ILiglPage validateReqAlertInTheNotificationIcon(String request) throws Exception{
		return null;
	}

	public ILiglPage addMessageWhenReqIsInProgress(String TextBoxArea) throws Exception{
		return null;
	}
	public ILiglPage moveToTheParticularColumn(String TITLE) throws Exception{
		return null;
	}

	public ILiglPage validateStatusOfTheRequest(String status) throws Exception{
		return null;
	}
	public ILiglPage clickOnViewIconInTheGrid() throws Exception{
		return null;
	}

	public ILiglPage validateMessageBoxIsInDisableMode() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfRequestUnderNewInProgressCloseStats(String RequestType,String REQTitle,String CaseDropDown,String UserDropDown,String PriorityDropDown,String CompleteDate,String TextBoxArea,String status1,String status2) throws Exception{
		return null;
	}
	public ILiglPage clickOnChooseACaseDropDown() throws Exception{
		return null;
	}

	public ILiglPage validateTheFieldValuesInAddRequestPopUp(String FieldValues) throws Exception{
		return null;
	}

	public ILiglPage navigateToCaseLevelRequests() throws Exception{
		return null;
	}
	public ILiglPage validatingNonApprovedCasesInCaseDropDown(String CaseDropDown) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddRequestButtonInCaseRequests() throws Exception{
		return null;
	}

	public ILiglPage clearActionInCaseDropDown() throws Exception{
		return null;
	}

	public ILiglPage searchRequiredDaterangeName(String DRname) throws Exception{
		return null;
	}

	public ILiglPage disabledDateRangeNotesClick(String DRName) throws Exception{
		return null;
	}

	public ILiglPage NotesDelete(String NotesContent) throws Exception{
		return null;
	}

	public ILiglPage validateDeletedNote(String NotesContent) throws Exception{
		return null;
	}

	public ILiglPage enabledDateRangeNotesClick(String DRName) throws Exception{
		return null;
	}

	public ILiglPage enabledKeywordsNotesClick(String KWname) throws Exception{
		return null;
	}

	public ILiglPage searchRequiredKeywordName(String KWname) throws Exception{
		return null;
	}

	public ILiglPage disabledKeywordsNotesClick(String KWname) throws Exception{
		return null;
	}

	public ILiglPage validateUnavailabilityOfActionColumnInEmployeeMasterFromInHouseCounselPage() throws Exception{
		return null;
	}

	public ILiglPage validateUnavailabilityOfActionColumnInEmployeeMasterFromCustodiansPage() throws Exception{
		return null;
	}

	public ILiglPage verifyUnavailabilityOfSecurityTabInLeftMenu() throws Exception{
		return null;
	}

	public ILiglPage verifyAvailabilityOfHelpLinkInCaseListPage() throws Exception{
		return null;
	}
	public ILiglPage goToNotesPage() throws InterruptedException{return null;}
	public ILiglPage notesSearchFilter(String name) throws Exception{return null;}
	public ILiglPage TypeofEventSearchFilter(String TypeofEvent) throws Exception{return null;}
	public ILiglPage notesEdit(String RequestBy,String NotesDescription) throws Exception{return null;}
	public ILiglPage notesDelete() throws Exception{return null;}
	public ILiglPage validateDeletedNoteForMultipleRecords() throws Exception{return null;}
	public ILiglPage validateDeleteNote() throws Exception{return null;}
	public ILiglPage displayingSelectedNotesList(String TOE) throws Exception{return null;}
	public ILiglPage caseEditInplace() throws Exception{return null;}
	public ILiglPage reAssignCaseForSingleApproval(String EMAIL,String USER) throws Exception{return null;}
	public ILiglPage reAssignCaseForDualApproval(Hashtable<String, String> data) throws Exception{return null;}
	public ILiglPage validateRevokeCaseForSingleApproval(String a,String b) throws Exception{return null;}
	public ILiglPage validateRevokeCaseForDualApproval(String a,String b,String c) throws Exception{return null;}
	public ILiglPage validateReassignForSingleApproval(String a,String b) throws Exception{return null;}
	public ILiglPage validateReassignForDualApproval(String a,String b,String c) throws Exception{return null;}
	public ILiglPage caseEditInplaceisSelected() throws Exception{return null;}
	public ILiglPage goToNotesPageFromDocuments(){return null;}
	public ILiglPage createCaseWithoutInplacePreservation(Hashtable<String,String> data) throws Exception{return null;}
	public ILiglPage verifyingCaseRoleIsNonEditable() throws Exception{return null;}
	public ILiglPage detailsColumnData(String Details) throws Exception{return null;}

	public ILiglPage createNewCaseWithInPlacePreservation(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage deleteTheRequiredNotes() throws Exception{
		return null;
	}

	public ILiglPage validatingEmailsInDB() throws Exception{
		return null;
	}


	public ILiglPage clickOnProcessInsightsTab() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfTheProcessInsightsStats(String Email) throws Exception{
		return null;
	}

	public ILiglPage clickOnReviewInsightsTab() throws Exception{
		return null;
	}

	public ILiglPage clickOnLegalHoldInsightsTab() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfTheLegalHoldInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String LHname,String Action)throws Exception{
		return null;
	}

	public ILiglPage selectCase() throws Exception{
		return null;
	}

	public ILiglPage validateTheNavigateToDashBoardPageURL(String PageTitle) throws Exception{
		return null;
	}

	public ILiglPage clickOnProductionInsightsTab() throws Exception{
		return null;
	}

	public ILiglPage clickOnGlobalInsightsTab() throws Exception{
		return null;
	}

	public ILiglPage validateDashBoardPageURL(String PageTitle) throws Exception{
		return null;
	}

	public ILiglPage clearCaseFunctionality() throws Exception{
		return null;
	}

	public ILiglPage validateTheSelectCaseNameInHeader() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheFunctionalityOfFromToDateAndApplyButton(String SYEAR,String SMONTH,String SDATE,String EYEAR,String EMONTH,String EDATE) throws Exception{
		return null;
	}

	public ILiglPage clickOnPrintButton() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfTheCaseInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus,String Pstatus) throws Exception{
		return null;
	}

	public ILiglPage clickOnClearAllButton() throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfTheGlobalInsightsStats(String CaseName,String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus) throws Exception{
		return null;
	}

	public ILiglPage validateThePrintButtonFunctionality() throws Exception{
		return null;
	}


	public ILiglPage validateUserAccessCasesCountWhenUACsetToFalse(String USERname,String PASSword,String ENTITYSelection,String Title) throws Exception{
		return null;
	}

	public ILiglPage searchLastDateModifiedColumnAndValidateTheCountInDashBoard(String Comparator,String Date,String Month,String Year,String Title,String SYEAR,String SMONTH,String SDATE) throws Exception{
		return null;
	}

	public ILiglPage validateEmpData(String custodianName, String emailID) throws Exception{
		return null;
	}

	public ILiglPage legalHoldApprovalIrrespectiveOfApprovalConfig(String LHName,String LHAction,String Apptemp,String UserName,String CaseNameApprove) throws Exception{
		return null;
	}

	public ILiglPage sendCaseForApprovalWithAllScope(String BchName,String Apptemp,String UserName) throws Exception{
		return null;
	}

	public ILiglPage goToIdentification() throws Exception{
		return null;
	}

	public ILiglPage goToCollection() throws Exception{
		return null;
	}

	public ILiglPage navigateToProjectDocumentsPage() throws Exception{
		return null;
	}
	public ILiglPage validateTheFieldValuesInAddRequestPopUpThroughEditICON(String REQtype,String REQtitle,String ChooseCASE,String chooseUSER,String PRIORITY,String DATE) throws Exception{
		return null;
	}

	public ILiglPage clickOnEditLinkInLHScreen() throws Exception{
		return null;
	}

	public ILiglPage clickOnDoneButtonInRemainderandEscalationTab() throws Exception{
		return null;
	}

	public ILiglPage clickOnCancelButtonInRemainderandEscalationTab() throws Exception{
		return null;
	}

	public ILiglPage clickOnRemainderAndEscalationLink() throws Exception{
		return null;
	}

	public ILiglPage clickOnPreservationScopeLink() throws Exception{
		return null;
	}

	public ILiglPage enterLHDateRanges(String startdate,String enddate) throws Exception{
		return null;
	}

	public ILiglPage enterLHKeywords(String KeyWORDS) throws Exception{
		return null;
	}

	public ILiglPage clickOnDoneBtnInPreservationScopeScreen() throws Exception{
		return null;
	}

	public ILiglPage creatingNewTemplateByOnFlyEdit(String NewtempName, String subject, String content,String LHname) throws Exception{
		return null;
	}

	/******************************************************************DB******************************************************************/
	public ILiglPage getCaseFieldsDataInCaseSummaryPage() throws Exception{return null;}
	public ILiglPage sendAllForCaseApproval(String batchName, String emailTemp, String approverName) throws Exception{
		return null;
	}
	public ILiglPage createNewProjectWithAllFields(Hashtable<String,String> data) throws Exception{return null;}
	public ILiglPage getFieldsDataFromSSOUserPopUp(Hashtable<String, String> data) throws Exception{return null;}

	public ILiglPage getFieldsDataFromEmployee(Hashtable<String, String> data) throws Exception{return null;}

	public void waitForPageToLoad(){
		JavascriptExecutor js = (JavascriptExecutor)getCurrentDriver();
		int i=1;
		// check for pageload 100% - 20 secs
		while(i!=10){
			String state = (String)js.executeScript("return document.readyState;");
			System.out.println(state);

			if(state.equals("complete"))
				break;
			else
				wait(2);

			i++;
		}
		// check for jquery/ajax status - 20 secs
		i=1;
		while(i!=10){

			Long d= (Long) js.executeScript("return jQuery.active;");
			System.out.println(d);
			if(d.longValue() == 0 )
				break;
			else
				wait(2);
			i++;

		}

	}
	public ILiglPage selectAllCCDs() throws InterruptedException {return null;}
	public ILiglPage multipleCCDsSelect(Hashtable<String, String> data) throws Exception {return null;}

	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public ILiglPage createLHWithOnlyKW(String lhName, String custTemp, String Keywords) throws Exception{return  null;}
	public ILiglPage lhnSave()throws Exception{return null;}
	public ILiglPage addLHNWithMandatoryFields(String lhName, String custTemp)throws Exception{return null;}
	public ILiglPage lhnCancel()throws Exception{return null;}
	public ILiglPage lhnOnFlyEdit()throws Exception{return null;}
	public ILiglPage chooseStakeHolderQuestionnaireTemplate(String StakeHolderQueTemplate)throws Exception{return null;}
	public ILiglPage chooseStakeHolderTemplate(String StakeHolderTemplate)throws Exception{return null;}
	public ILiglPage chooseCustodianQuestionnaireTemplate(String CustodianQuestionaireTemplate)throws Exception{return null;}

	public ILiglPage editLHName(String lhName) throws Exception{
		return null;
	}

	public ILiglPage createProjectWithBothMandatoryAndOptionalFields(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddProjectButton() throws Exception{
		return null;
	}

	public ILiglPage clickOnSaveAndAddDetailsButtonInAddProjectPopUp(String CaseNAME) throws Exception{
		return null;
	}

	public ILiglPage enterPriority(String PRIORITY) throws Exception{
		return null;
	}

	public ILiglPage enterRegion(String REGION) throws Exception{
		return null;
	}

	public ILiglPage enterEntity(String ENTITY) throws Exception{
		return null;
	}

	public ILiglPage enterProjectSettingTemplate(String PST) throws Exception{
		return null;
	}

	public ILiglPage enterDescription(String DESC) throws Exception{
		return null;
	}

	public ILiglPage enterProjectName(String PROJECT) throws Exception{
		return null;
	}

	public ILiglPage enterRole(String ROLE) throws Exception{
		return null;
	}

	public ILiglPage enterProjectType(String ProjectType) throws Exception{
		return null;
	}
	public ILiglPage searchCustodian(String custodian)throws Exception{return null;}

	public ILiglPage createProjectWhenProjectSettingTemplateFieldIsDisabled(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage createProjectWhenRegionFieldIsDisabled(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage verifyProjectNameFieldValidationSpecialCharactersAllowedAndNotAllowed(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage clickOnSaveAndAddDetailsButton() throws Exception{
		return null;
	}

	public ILiglPage performClearActionInTheProjectNameField() throws Exception{
		return null;
	}

	public ILiglPage validateProjectNameFieldErrorMessage() throws Exception{
		return null;
	}

	public ILiglPage verifyUserCanChooseAnyDateInDueDateWhileProjectCreateOrEdit(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage enterProjectDueDate(String DueDate) throws Exception{
		return null;
	}

	public ILiglPage performClearActionInProjectDueDate() throws Exception{
		return null;
	}

	public ILiglPage clickOnProjectEditButton() throws Exception{
		return null;
	}

	public ILiglPage clickOnSaveButtonFromEditPopUpInCaseSummaryPage() throws Exception{
		return null;
	}

	public ILiglPage  enterProjectDueDateWhileEditing(String DueDate) throws Exception{
		return null;
	}

	public ILiglPage verifyMandatoryFieldsAreEditableInEditProjectPopUpUntillProjectApproved(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage validateTheEditedDetailsInEditProjectPopUpInProjectSummary(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage secondSearchInNotesGrid(String NotesContent) throws Exception{
		return null;
	}

	public ILiglPage loginWithLiglorSSOUser(String UserName, String PassWord,String EntitySelection,String IsSSOLogin,String ssoUserName, String ssoPassWord) throws Exception{
		return null;
	}

	public ILiglPage clickOnChooseColumnsInProjectGrid() throws Exception{
		return null;
	}

	public ILiglPage searchForTheRequiredColumnsThroughChooseColumn(String RequiredColumn1) throws Exception{
		return null;
	}

	public ILiglPage performClearActionInSearchBarInChooseColumn() throws Exception{
		return null;
	}

	public ILiglPage validateTheMandatoryAndOptionalFieldDetailsInProjectSummary(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddAndViewLinkInDSI() throws Exception{
		return null;
	}

	public ILiglPage validateEditButtonInDisableMode() throws Exception{
		return null;
	}

	public ILiglPage searchingRequriedCounsel(String Email1) throws Exception{
		return null;
	}

	public ILiglPage clickingOnNotesIcon() throws Exception{
		return null;
	}

	public ILiglPage toggleToOutSideCounsel() throws Exception{
		return null;
	}
	public ILiglPage clickOnAddOutsideCounsel() throws Exception{
		return null;
	}
	public ILiglPage selectALawfirmFromDropdown(String PartyLawFirm) throws Exception{
		return null;
	}
	public ILiglPage selectAvailableLawFirms(String ExistingLawFirm) throws Exception{
		return null;
	}
	public ILiglPage clickOnSaveButtonInAddOutsideCounselPopUp() throws Exception{
		return null;
	}

	public ILiglPage searchRequiredOutsideCounselInOutsideCounselGrid(String OutSideCounsel) throws Exception{
		return null;
	}

	public ILiglPage secondSearchRequiredOutsideCounselInOutsideCounselGrid(String OutSideCounsel) throws Exception{
		return null;
	}
	public ILiglPage clickOnAddLawFirmButtonInAddOutsideCounselPopUp() throws Exception{
		return null;
	}
	public ILiglPage createNewLawFirmInAddLawFirmPopUp(String FirstName,String PartyType,String Status,String Description) throws Exception{
		return null;
	}

	public ILiglPage clickOnAddCounselButtonInAddOutsideCounselPopUp() throws Exception{
		return null;
	}
	public ILiglPage createNewCounselInAddOutsideCounselPopUp(String FirstName, String LastName) throws Exception{
		return null;
	}
	public ILiglPage movingTheCursorToTheRightPosition() throws Exception{
		return null;
	}
	public ILiglPage deleteCourt(String CourtName) throws Exception{
		return null;
	}

	public ILiglPage secondSearchCourt(String Court) throws Exception{
		return null;
	}
	public ILiglPage clickingOnNotesIconInCourtGrid() throws Exception{
		return null;
	}

	public ILiglPage clickOnRefreshButtonInNotesGrid() throws Exception{
		return null;
	}

	public ILiglPage createNewCaseSP(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage validatingAlreadyAddedInHouseCounselsAreDisplayingInEmployeeMasterGrid(String Email1) throws Exception{
		return null;
	}
	public ILiglPage clickingOnNotesIconInOtherPartyGrid() throws Exception{
		return null;
	}
	public ILiglPage projectAndScopeItemsSendingForApproval(String Emp1,String DataSource1,String DateRange1,String KeyWords1,String BATCHname,String UserName ,String EmailTemplate) throws Exception{
		return null;
	}

	public ILiglPage validateBatchForProjectApprovalStatus() throws Exception{
		return null;
	}
	public ILiglPage searchRequiredProjectBatch(String BatchName) throws Exception{
		return null;
	}

	public ILiglPage validateProjectKeywordsAreInApprovedState() throws Exception{
		return null;
	}

	public ILiglPage validateProjectDateRangessAreInApprovedState() throws Exception{
		return null;
	}
	public ILiglPage validateProjectDataSourcesAreInApprovedState() throws Exception{
		return null;
	}
	public ILiglPage validateProjectCustodiansAreInApprovedState() throws Exception{
		return null;
	}

	public ILiglPage validateProjectDetailsAreInApprovedStateInApprovalPage() throws Exception{
		return null;
	}

	public ILiglPage moveBackToTheRequiredColumn() throws Exception{
		return null;
	}

	public ILiglPage searchLastDateModifiedColumnAndValidateTheCountInDashBoardWhenUACIsFALSE(String Comparator,String Date,String Month,String Year,String Title,String SYEAR,String SMONTH,String SDATE) throws Exception{
		return null;
	}

	public ILiglPage verifyTheDataInProcessInsightsWhenProjectContextIsNotSetWhenDefaultDatesAreSelected(Hashtable<String, String> data,String Emp) throws Exception{
		return null;
	}
	public ILiglPage validateTheDataWhenFromAndToDatesAreAdjusted(String SYEAR,String SMONTH,String SDATE,String EYEAR,String EMONTH,String EDATE) throws Exception{
		return null;
	}

	public ILiglPage validateRevokeButtonFunctionality(String a,String b) throws Exception{
		return null;
	}
	public ILiglPage performReAssignFunctionalityForTheProject(String EMAIL,String USER) throws Exception{
		return null;
	}
	public ILiglPage validateReAssignButtonFunctionality(String AssignedUser,String Status) throws Exception{
		return null;
	}

	public ILiglPage createRequestByFillingOnlyMandatoryFieldsInTheAddRequestPopUp(String RequestType,String REQTitle,String CaseDropDown) throws Exception{
		return null;
	}

	public ILiglPage validateClearFilterFunctionalityInLegalHoldInsights(String SYEAR,String SMONTH,String SDATE,String EYEAR, String EMONTH,String EDATE) throws Exception{
		return null;
	}

	public ILiglPage validateClearFilterFunctionalityInGlobalInsights(String selectYear,String selectVaue) throws Exception{
		return null;
	}
	public ILiglPage validateClearFilterFunctionalityInProductionInsights() throws Exception{
		return null;
	}

	public ILiglPage validateClearFilterFunctionalityInProcessInsights(String SYEAR,String SMONTH,String SDATE,String EYEAR, String EMONTH,String EDATE) throws Exception{
		return null;
	}

	public ILiglPage checkAndValidateTheCountOfTheProcessInsightsStats(String Email,String Emp,String EMAIL,String EMP, String DataSource,String SourcePath,String DataHold,String CollectionStatus) throws Exception{
		return null;
	}

	public ILiglPage validateSecondSearchAddedCourts(String CourtAdded) throws Exception{
		return null;
	}

	public ILiglPage searchingAddedCourtAfterDeleting(String AvailableCourt) throws Exception{
		return null;
	}

	public ILiglPage validatingTheErrorMessageWhileCreatingTheDuplicateProjectNames(Hashtable<String,String> data) throws Exception{
		return null;
	}

	public ILiglPage validateTheSaveAndAddDetailsButtonIsInDisableModeInAddProjectPopUp() throws Exception{
		return null;
	}

	public ILiglPage clickingOnClearFilterButtonInOtherPartyScreen() throws Exception{
		return null;
	}

	public ILiglPage validatePartyInTheOtherPartyScreenAfterAddingThroughAddPartyButton(String PartyName) throws Exception{
		return null;
	}

	public ILiglPage secondSearchPartyInOtherPartyGrid(String PartyName) throws Exception{
		return null;
	}

	public ILiglPage validateCustStatus(String CustStatus) throws Exception{
		return null;
	}

	public ILiglPage deleteAddedJudgeForTheRespectiveCourt() throws Exception{
		return null;
	}

	public ILiglPage deleteContactsAddedForRespectiveParty(String ContactName) throws Exception{
		return null;
	}

	public ILiglPage verifyContactsAndCounselsShouldDisplayForTheRespectiveParty(String existingContact,String existingCounsel) throws Exception{
		return null;
	}

	public ILiglPage secondSearchForTheOutsideCounsel(String OutsideCounsel) throws Exception{
		return null;
	}

	public ILiglPage deleteOutsideCounselForTheRespectiveParty(String OutsideCounsel) throws Exception{
		return null;
	}
	public ILiglPage verifyJudgesAndProsecutorsShouldDisplayForTheRespectiveCourt(String existingJudge,String existingProsecutor) throws Exception{
		return null;
	}
	public ILiglPage revokeReassignNotInitiatedLH() throws Exception{return null;}
	public ILiglPage checkActiveUserInLHApprovalDP(String UserName) throws Exception{return null;}

	public ILiglPage RCLogin(String userType, String entity) throws Exception{
		return null;
	}

	public ILiglPage loginWithSSOUser(String Entity) throws InterruptedException{
		return null;
	}
	public ILiglPage ValidateDefaultValueInTypeofEventDropdown(String DropDownValue) throws Exception{
		return null;
	}
	public ILiglPage validateProjectPrefixIsAutogeneratedInAlphaNumericFormat(Hashtable<String, String> data) throws Exception{
		return null;
	}
}
