package com.cleartrip.demotest;

import org.testng.annotations.Test;

import com.cleartrip.pages.LandingPage;
import com.cleartrip.utils.BaseWebdriver;

public class FlightBookingTest extends BaseWebdriver {

	@Test
	public void testThatResultsAppearForAOneWayJourney() {
		LandingPage homePage = new LandingPage();
		homePage.flightSearch();
	}

	
}
