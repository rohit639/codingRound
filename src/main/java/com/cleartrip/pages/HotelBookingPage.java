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

public class HotelBookingPage extends BasePage {

	@FindBy(id = Locators.HotelBokingPage.localityTextBox)
	private WebElement localityTextBox;

	@FindBy(id = Locators.HotelBokingPage.searchButton)
	private WebElement searchButton;

	@FindBy(id = Locators.HotelBokingPage.travellerSelection)
	private WebElement travellerSelection;

	@FindBy(id = Locators.HotelBokingPage.checkOutDate)
	private WebElement checkOutDate;

	private static final String locationToSearch = "Indiranagar, Bangalore";
	private static final String travelrsOption = "1 room, 2 adults";
	private static final String hotelTitle = "Online Hotel Booking |Hotels Near Me |Affordable Hotels @Cleartrip";

	public HotelBookingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertEquals(BaseWebdriver.getDriver().getTitle(), hotelTitle,
				"Failed as title is not same as provided for " + this.getClass());
	}

	public SearchResultPage navigateToHotelSearchPage() {
		localityTextBox.clear();
		localityTextBox.sendKeys(locationToSearch);
		// wanted to keep this in BasePage or find better solution but no time
		List<WebElement> originOptions = BaseWebdriver.getDriver().findElement(By.id("ui-id-1"))
				.findElements(By.tagName("li"));
		Assert.assertTrue(FunctionLib.isAllElemntVisble(originOptions));
		originOptions.get(1).click();
		Assert.assertTrue((FunctionLib.isElemntVisble(getDateWebElement())),
				"Failed as not able to view From Date for hotel booking");
		getDateWebElement().click();

		Assert.assertTrue((FunctionLib.isElemntVisble(checkOutDate)),
				"Failed as not able to view to check out Date for hotel booking");
		checkOutDate.click();

		Assert.assertTrue((FunctionLib.isElemntVisble(getNextDateWebElement())),
				"Failed as not able to view To Date for hotel booking");
		getNextDateWebElement().click();

		Assert.assertTrue(FunctionLib.selectBasedOnVisibleText(travellerSelection, travelrsOption));
		searchButton.click();
		return new SearchResultPage();
	}

}
