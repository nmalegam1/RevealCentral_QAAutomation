package com.ligl.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.administration.AdminLeftMenu;
import com.ligl.pages.casemanagement.CaseCustodiansPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.Constants;
import com.ligl.pages.Header;

public class LiglBaseSessionPage extends LiglBasePage {
	//Common Page where the controls can be used common from session related pages
	Header header;

	LeftMenu leftNavigation;

	AdminLeftMenu adminLeftNavigation;

	@FindBy(css=Constants.DATE_MONTH_YEAR)
	public WebElement dateMonth;
	@FindBy(css=Constants.DATE_MONTH_FORWARD)
	public WebElement forward;
	@FindBy(css=Constants.DATE_MONTH_BACKWARD)
	public WebElement backward;

	public LiglBaseSessionPage() {
		header = new Header(getCurrentDriver());
		leftNavigation = new LeftMenu(getCurrentDriver());
		adminLeftNavigation = new AdminLeftMenu(getCurrentDriver());
	}

	public Header getHeader() {
		return header;

	}

	public LeftMenu getLeftMenu() {
		return leftNavigation;

	}

	public AdminLeftMenu getAdminLeft(){return adminLeftNavigation;}

	public ILiglPage navigateToDataSourcesPage(){ return  null;}


	/*@Override
	public ILiglPage addCustodianToCase() throws Exception {
		return null;
	}
	public ILiglPage addDataSources() throws Exception {
		return null;
	}*/
	public ILiglPage navigateToLegalHoldPage() {
		return null;
	}

	public ILiglPage goToLegalHoldPage() {return null;}
	public ILiglPage approvingLegalHold() throws InterruptedException {
		return null;
	}

	public void selectDateFromCalendar(String date) {
		try {
			Date currentDate = new Date();
			Date dateToBeSelected = new SimpleDateFormat("dd-MM-yyyy").parse(date);
			String day = new SimpleDateFormat("dd").format(dateToBeSelected);
			String month = new SimpleDateFormat("MMMM").format(dateToBeSelected);
			String year = new SimpleDateFormat("yyyy").format(dateToBeSelected);
			String monthYear=month+" "+year;
			while(!dateMonth.getText().equals(monthYear)){
				System.out.println(dateMonth.getText()+" --- "+monthYear);

				if(currentDate.compareTo(dateToBeSelected) > 0)
					backward.click();
				else if(currentDate.compareTo(dateToBeSelected) < 0)
					forward.click();

			}

			getCurrentDriver().findElement(By.xpath("//td[text()='"+day+"'")).click();

		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void getRowWithCellData(String data) {

	}
}
