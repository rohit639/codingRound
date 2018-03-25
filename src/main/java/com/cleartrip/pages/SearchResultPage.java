package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;

public class SearchResultPage extends BasePage {
	
	@FindBy(xpath="//div[@id='ResultContainer_1_1']//a[@id='modifySearchLink']")
	private WebElement modifySearch; 
	
	public SearchResultPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(modifySearch),"Failed as could not validate search page "+this.getClass());
	}
	
}
