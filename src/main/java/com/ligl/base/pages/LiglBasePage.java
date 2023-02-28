package com.ligl.base.pages;

import com.ligl.pages.DashboardPage;
import com.ligl.pages.LeftMenu;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import com.ligl.session.LiglTestSession;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Reporter;

import com.ligl.pages.Header;
import com.ligl.web.IWebConnector;

import java.util.Hashtable;

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

	public void quit() {
		// TODO Auto-generated method stub
	}

	public ILiglPage navigateURL() {
		return null;
	}

	public ILiglPage submitUsername(String userid) {
		return null;

	}
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

	public ILiglPage login(String userName, String password,String Entity) throws Exception {
		return null;
	}
	public ILiglPage createNewCounselForSelectedOutsideCounsel(String PartyNew,String OptionFromLawFirmDropDwn,String FirstName,String LastName) throws Exception {
		return null;
	}

	public ILiglPage searchcase(String casename) throws Exception {return null;}

	public ILiglPage GoToCase(String CaseName) throws Exception {return null;}

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

	public ILiglPage sendingCaseForDualApproval(String BatchNAME,String USER1,String USER2,String EMAIL,String Employee1,String SubType) throws Exception{
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
	public ILiglPage addDataSources() throws Exception {
		return null;
	}
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
	public ILiglPage verifyingCaseFieldsAreEditable(String CaseTypeDrpDwn,String CaseName1,String CaseSettingTemplateDrpDwn) throws Exception{
		return null;
	}
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
	public ILiglPage validateCounselAndSaveButtonForPartyType(String PartyNameB,String PartyType,String Description) throws Exception {
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
	public  ILiglPage addingNewParty(String PartyName,String PartyType,String Description) throws Exception {
		return null;
	}
	public ILiglPage validateAddedNewOutsideCounsel(String OutsideCounsel,String NameTextBox) throws Exception{
		return null;
	}
	public ILiglPage searchingParty() throws Exception {
		return null;
	}
	public ILiglPage addingExistingParty(String PartyNameA,String PartyNew) throws Exception {
		return null;
	}
	public ILiglPage sendingLegalHoldForApproval() throws Exception {
		return null;
	}
	public ILiglPage checkLHNForCustodians(String LHN,String Employee1) throws Exception{
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
	public  ILiglPage goToAdministrationPage() throws InterruptedException {
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

	// Smoke Suite Methods

	public ILiglPage validateAndWaitForRecordsToCompleteProcessing(String Processingstatus)throws Exception{
		return null;
	}

	public ILiglPage validateAndWaitForRecordsToCompleteCollection(String CollectionStatus) throws Exception{
		return null;
	}
	public ILiglPage clickOnDateRangesCheckBoxForApproval(String DateRange) throws Exception{
		return null;
	}
	public ILiglPage clickOnKeywordsCheckBoxForApproval(String KeyWords) throws Exception{
		return null;
	}
	public ILiglPage addDataSourceRecordToDSIGridUptoCollection(String cust, String datasource, String DataHold) throws Exception{
		return null;
	}
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

	public void wait(int time) {
		try {
			Thread.sleep(time*1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
