package com.cleartrip.pages;

import org.openqa.selenium.Keys;
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
	
	@FindBy(xpath=Locators.HotelBokingPage.dateFrom)
	 private WebElement dateFrom;
	
	@FindBy(id = Locators.HotelBokingPage.checkOutDate)
    private WebElement checkOutDate;
	
	@FindBy(xpath=Locators.HotelBokingPage.dateTill)
	 private WebElement dateTill;
	
	private static final String locationToSearch = "Indiranagar, Bangalore";
	private static final String travelrsOption = "1 room, 2 adults";
	private static final String hotelTitle = "Online Hotel Booking |Hotels Near Me |Affordable Hotels @Cleartrip";
	
		public HotelBookingPage() {
			PageFactory.initElements(BaseWebdriver.getDriver(), this);
			Assert.assertEquals(BaseWebdriver.getDriver().getTitle(), hotelTitle,"Failed as title is not same as provided for "+this.getClass());
		}
	
		public SearchResultPage navigateToHotelSearchPage() {
			
			localityTextBox.sendKeys(locationToSearch);
		        try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
		        
		        localityTextBox.sendKeys(Keys.RETURN);

		        Assert.assertTrue((FunctionLib.isElemntVisble(dateFrom)),"Failed as not able to view From Date for hotel booking");
		        dateFrom.click();
		        
		        Assert.assertTrue((FunctionLib.isElemntVisble(checkOutDate)),"Failed as not able to view to check out Date for hotel booking");
		        checkOutDate.click();
		        
		       Assert.assertTrue((FunctionLib.isElemntVisble(dateTill)),"Failed as not able to view To Date for hotel booking");
		       dateTill.click();
		       
		        Assert.assertTrue(FunctionLib.selectBasedOnVisibleText(travellerSelection, travelrsOption)); 
		        searchButton.click();
		        return new SearchResultPage();
		}
	 

}
