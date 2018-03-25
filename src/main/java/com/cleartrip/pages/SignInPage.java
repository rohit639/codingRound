package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.cleartrip.utils.Locators;

public class SignInPage extends BasePage{

	@FindBy(id= Locators.SignInPage.frame)
	private WebElement frame;
	
	@FindBy(tagName= Locators.SignInPage.titleValidation)
	private WebElement titleValidation;
	
	@FindBy(id = Locators.SignInPage.sigInButton)
	private WebElement signIn;
	
	@FindBy(id= Locators.SignInPage.errorMessage)
	private WebElement errorMessage;
	
	private static final String signInTitle = "Sign in to Cleartrip";
	private static final String errorMsg = "There were errors in your submission";
	
	public SignInPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.switchToFrame(frame));
		Assert.assertTrue(FunctionLib.isTextPresent(titleValidation, signInTitle), "Failed to validate SignIn Page");
	}
	
	public boolean verifySignIn() {
		Assert.assertTrue(FunctionLib.isElemntVisble(signIn), "Failed as not able to view sign-In in sign-In pagr/form");
		signIn.click();
		return FunctionLib.isTextPresent(errorMessage, errorMsg);
		
	}
	
	
}
