package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.cleartrip.utils.Locators;



public class BasePage {
	@FindBy(linkText=Locators.BasePage.yourTripsLink)
	public WebElement yourTrips;
	
	@FindBy(id=Locators.BasePage.signInButton)
	public WebElement signIn;
	
	@FindBy(className=Locators.BasePage.clearTripLogo)
	public WebElement clearTripLogo;
	
	public BasePage(){
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.isElemntVisble(clearTripLogo), "Failed as not able to view clear trip logo");
	}
	
	public SignInPage navigateToSignInPage() {
		Assert.assertTrue(FunctionLib.isElemntVisble(yourTrips), "Failed as not able to view your trips link");
        yourTrips.click();
        Assert.assertTrue(FunctionLib.isElemntVisble(signIn), "Failed as not able to view Sign-In button link");
        signIn.click();
        return new SignInPage();
	}

	
}
