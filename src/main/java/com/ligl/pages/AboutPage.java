package com.ligl.pages;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.Hashtable;

public class AboutPage  extends LiglBaseSessionPage {
    @FindBy(id = "releaseVersion")
    WebElement releaseVersion;

   public ILiglPage verifyReleaseVersion(Hashtable<String, String> data) throws Exception {
        try {


            log_Info("Click on release version");
            getDriver().waitForelementToBeClickable(releaseVersion);
            Thread.sleep(3000);
            String version=releaseVersion.getText();
            if(version.equals(data.get("ReleaseVersion")))
            {
                log_Pass("Release Version matching");
            }
            else{
                log_Error("Release Version not matching");


            }


            System.out.println(version);

            return new AboutPage();

        } catch (Exception | Error ex) {
            log_Error(ex.getMessage());
            throw new Exception("verifyReleaseVersion failed", ex);
        }
    }

}
