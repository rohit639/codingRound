package com.cleartrip.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;

public class SignInPage extends BasePage{

	@FindBy(id="modal_window")
	private WebElement frame;
	
	@FindBy(tagName="h1")
	private WebElement titleValidation;
	
	@FindBy(id="signInButton")
	private WebElement SignIn;
	
	@FindBy(id="errors1")
	private WebElement errorMessage;
	
	public SignInPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertTrue(FunctionLib.switchToFrame(frame));
		System.out.println(titleValidation.getText());
		Assert.assertTrue(FunctionLib.isTextPresent(titleValidation, "Sign in to Cleartrip"), "Failed to validate SignIn Page");
	}
	
	public boolean verifySignIn() {
		Assert.assertTrue(FunctionLib.isElemntVisble(SignIn), "Failed as not able to view sign-In in sign-In pagr/form");
		SignIn.click();
		return FunctionLib.isTextPresent(errorMessage, "There were errors in your submission");
		
	}
	
	
}
