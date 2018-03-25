package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cleartrip.utils.FunctionLib;



public class BasePage {
	@FindBy(linkText="Your trips")
	public WebElement yourTrips;
	
	@FindBy(id="SignIn")
	public WebElement signIn;
	
	
	public SignInPage navigateToSignInPage() {
		Assert.assertTrue(FunctionLib.isElemntVisble(yourTrips), "Failed as not able to view your trips link");
        yourTrips.click();
        Assert.assertTrue(FunctionLib.isElemntVisble(signIn), "Failed as not able to view Sign-In button link");
        signIn.click();
        return new SignInPage();
	}

	
}
