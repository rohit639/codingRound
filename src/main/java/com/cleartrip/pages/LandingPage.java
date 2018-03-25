package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.cleartrip.utils.Locators;

public class LandingPage extends BasePage {

	@FindBy(linkText = Locators.LandingPage.hotelLink)
	public WebElement hotelLink;

	@FindBy(id = Locators.LandingPage.oneWay)
	private WebElement oneWay;

	@FindBy(id = Locators.LandingPage.fromPlace)
	private WebElement fromPlace;

	@FindBy(id = Locators.LandingPage.toPlace)
	private WebElement toPlace;

	@FindBy(id = Locators.LandingPage.searchButton)
	private WebElement searchButton;

	private static final String landingTitle = "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.";
	private static final String fromLocation = "Bangalore";
	private static final String toLocation = "Delhi";

	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertEquals(BaseWebdriver.getDriver().getTitle(), landingTitle,
				"Failed as title is not same as provided for " + this.getClass());
	}

	public SearchResultPage flightSearch() {

		Assert.assertTrue(FunctionLib.isElemntVisble(oneWay));
		oneWay.click();

		fromPlace.clear();
		fromPlace.sendKeys(fromLocation);

		List<WebElement> originOptions = BaseWebdriver.getDriver().findElement(By.id("ui-id-1"))
				.findElements(By.tagName("li"));
		Assert.assertTrue(FunctionLib.isAllElemntVisble(originOptions));
		originOptions.get(0).click();

		toPlace.clear();
		toPlace.sendKeys(toLocation);

		List<WebElement> destinationOptions = BaseWebdriver.getDriver().findElement(By.id("ui-id-2"))
				.findElements(By.tagName("li"));
		Assert.assertTrue(FunctionLib.isAllElemntVisble(destinationOptions));
		destinationOptions.get(0).click();

		getDateWebElement().click();
		searchButton.click();
		return new SearchResultPage();
	}

	public HotelBookingPage navigateToHotelPage() {
		hotelLink.click();
		return new HotelBookingPage();
	}

}
