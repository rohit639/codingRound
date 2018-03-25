package com.cleartrip.demotest;

import org.testng.annotations.Test;

import com.cleartrip.pages.LandingPage;
import com.cleartrip.utils.BaseWebdriver;

public class HotelBookingTest extends BaseWebdriver {

	@Test
	public void shouldBeAbleToSearchForHotels() {
		LandingPage homePage = new LandingPage();
		homePage.navigateToHotelPage().navigateToHotelSearchPage();
	}

}
