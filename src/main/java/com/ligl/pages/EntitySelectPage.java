package com.ligl.pages;

import java.util.List;

import com.ligl.base.pages.ILiglPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

import com.ligl.base.pages.Constants;

public class EntitySelectPage extends LiglBaseSessionPage {

	@FindBy(xpath= "//a[@id='entity']/span[contains(text(),'NUIX')]")
	WebElement nuixEntityLnk;

	@FindBy(xpath= "//a[@id='entity']/span[contains(text(),'Rel')]")
	WebElement relEntityLnk;

	public ILiglPage selectEntity(String entity) {
		if(entity=="NUIX")
		{
			nuixEntityLnk.click();
			return new DefaultLandingPage();
		}else if (entity=="Rel"){
			relEntityLnk.click();
			//return new DefaultLandingPage();
		}
		return new DefaultLandingPage();
	}
}
