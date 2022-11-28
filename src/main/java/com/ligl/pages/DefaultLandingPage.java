package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import com.ligl.base.pages.LiglBasePage;
import com.ligl.pages.casemanagement.CaseSummaryPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Hashtable;

//****************CasePage*******************
public class DefaultLandingPage extends LiglBaseSessionPage {

    @FindBy(id= "btn-create-case")
    WebElement createCaseBtn;
    @FindBy(id= "btn-clear")
    WebElement clearFilterBtn;
    @FindBy(id= "caseAction")
    WebElement selectActionDrp;
    @FindBy(id="modelaction-btn")
    WebElement runBtn;
    @FindBy(id="btn-refresh")
    WebElement refreshBtn;

    //Create NewCase
    public ILiglPage createNewCase(Hashtable<String,String> data) {
        log_Info(data.toString());
        return new CaseSummaryPage();
    }

    //Clear Filter
    public ILiglPage clickClearFilterBtn() {
        log_Info("Click Clear Filter Button");
        clearFilterBtn.click();
        waitForPageToLoad();
        return new LiglBasePage();
    }

}
