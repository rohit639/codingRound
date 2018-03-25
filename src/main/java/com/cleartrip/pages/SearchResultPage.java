package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.cleartrip.utils.Locators;

public class SearchResultPage extends BasePage {
	
	@FindBy(xpath=Locators.SearchResultPage.modifySearch)
	private WebElement modifySearch; 
	
	public SearchResultPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(modifySearch),"Failed as could not validate search page "+this.getClass());
	}
	
}
