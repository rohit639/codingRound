package com.cleartrip.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.cleartrip.utils.Locators;

public class BasePage {
	@FindBy(linkText = Locators.BasePage.yourTripsLink)
	public WebElement yourTrips;

	@FindBy(id = Locators.BasePage.signInButton)
	public WebElement signIn;

	@FindBy(className = Locators.BasePage.clearTripLogo)
	public WebElement clearTripLogo;

	public BasePage() {
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

	public WebElement getDateWebElement() {

		WebElement dateToClick;
		String today = FunctionLib.getToDayDate("d");
		if (Integer.parseInt(today) <= 28) {
			dateToClick = BaseWebdriver.getDriver()
					.findElement(By.xpath("//div[@class='monthBlock first']//a[text()='" + today + "']"));
		} else
			dateToClick = BaseWebdriver.getDriver()
					.findElement(By.xpath("//div[@class='monthBlock last']//a[text()='1']"));
		return dateToClick;
	}

	public WebElement getNextDateWebElement() {

		WebElement dateToClick;
		String today = FunctionLib.getToDayDate("d");
		if (Integer.parseInt(today) <= 28) {
			int plusDate = Integer.parseInt(today) + 1;
			today = "" + plusDate;
			dateToClick = BaseWebdriver.getDriver()
					.findElement(By.xpath("//div[@class='monthBlock first']//a[text()='" + today + "']"));
		} else
			dateToClick = BaseWebdriver.getDriver()
					.findElement(By.xpath("//div[@class='monthBlock last']//a[text()='2']"));
		return dateToClick;
	}

}
