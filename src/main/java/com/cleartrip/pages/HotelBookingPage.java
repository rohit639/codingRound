package com.cleartrip.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;

public class HotelBookingPage extends BasePage {
		
	@FindBy(id = "Tags")
    private WebElement localityTextBox;
	
	@FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;
	
	@FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;
	
	@FindBy(xpath="//div[@class='monthBlock first']//tr[5]//td[1]")
	 private WebElement dateFrom;
	
	@FindBy(id = "CheckOutDate")
    private WebElement checkOutDate;
	
	@FindBy(xpath="//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[7]")
	 private WebElement dateTill;
	
		public HotelBookingPage() {
			PageFactory.initElements(BaseWebdriver.getDriver(), this);
			Assert.assertEquals(BaseWebdriver.getDriver().getTitle(), "Online Hotel Booking |Hotels Near Me |Affordable Hotels @Cleartrip","Failed as title is not same as provided for "+this.getClass());
		}
	
		public SearchResultPage navigateToHotelSearchPage() {
			
			localityTextBox.sendKeys("Indiranagar, Bangalore");
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
		       
		        Assert.assertTrue(FunctionLib.selectBasedOnVisibleText(travellerSelection, "1 room, 2 adults")); 
		        searchButton.click();
		        return new SearchResultPage();
		}
	 

}
