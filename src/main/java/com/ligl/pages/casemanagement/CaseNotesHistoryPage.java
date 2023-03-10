package com.ligl.pages.casemanagement;

import com.ligl.base.pages.ILiglPage;
import com.ligl.pages.LiglBaseSessionPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class CaseNotesHistoryPage extends LiglBaseSessionPage
{
    @FindBy(xpath = "//span[contains(text(),'Timestamp ')]/ancestor::div[@ref='eLabel']")
    WebElement TimeStamp;

    @FindBy(xpath = "//span[contains(text(),'Performed By')]/ancestor::div[@ref='eLabel']")
    WebElement PerformedBy;

    @FindBy(xpath = "//span[contains(text(),'Role')]/ancestor::div[@ref='eLabel']")
    WebElement Role;

    @FindBy(xpath = "//span[contains(text(),'Type of Event')]/ancestor::div[@ref='eLabel']")
    WebElement TypeOfEvent;

    @FindBy(xpath = "//span[contains(text(),'Status')]/ancestor::div[@ref='eLabel']")
    WebElement Status;

    @FindBy(xpath = "//span[contains(text(),'Details')]/ancestor::div[@ref='eLabel']")
    WebElement Details;

    @FindBy(xpath = "//span[contains(text(),'Action')]/ancestor::div[@ref='eLabel']")
    WebElement Action;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]/ancestor::div[@ref='eLabel']")
    WebElement CaseName;

    @FindBy(xpath = "//span[contains(text(),'Case Name')]")
    WebElement CaseNameColumn;

    @FindBy(id="Columns")
    WebElement ChooseColumnsMenu;

    public ILiglPage verifyColumnsInNotesHistoryGrid() throws Exception {

        try {
            log_Info("Check The Column names In The History Grid");
            boolean c1 = TimeStamp.isDisplayed();
            boolean c2 = PerformedBy.isDisplayed();
            boolean c3 = Role.isDisplayed();
            boolean c4 = TypeOfEvent.isDisplayed();
            boolean c5 = Status.isDisplayed();
            boolean c6 = Details.isDisplayed();
            boolean c7 = Action.isDisplayed();
            Thread.sleep(5000);
            // Verifying display of optional column Case name by checking from choose columns
            ChooseColumnsMenu.click();
            Thread.sleep(1000);
            CaseNameColumn.click();
            Thread.sleep(1000);
            ChooseColumnsMenu.click();
            Thread.sleep(1000);
            boolean c8 = CaseName.isDisplayed();

            System.out.println(c1);
            System.out.println(c2);
            System.out.println(c3);
            System.out.println(c4);
            System.out.println(c5);
            System.out.println(c6);
            System.out.println(c7);
            System.out.println(c8);

            Thread.sleep(5000);

            Assert.assertEquals(true, c1);
            Assert.assertEquals(true, c2);
            Assert.assertEquals(true, c3);
            Assert.assertEquals(true, c4);
            Assert.assertEquals(true, c5);
            Assert.assertEquals(true, c6);
            Assert.assertEquals(true, c7);
            Assert.assertEquals(true, c8);

            return new CaseNotesHistoryPage();

        }
        catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyColumnsInNotesHistoryGrid()", ex);
        }
    }

}


