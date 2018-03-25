package com.cleartrip.demotest;
import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HotelBookingTest extends BaseWebdriver {

   

    @FindBy(linkText = "Hotels")
    private WebElement hotelLink;

    @FindBy(id = "Tags")
    private WebElement localityTextBox;

    @FindBy(id = "SearchHotelsButton")
    private WebElement searchButton;

    @FindBy(id = "travellersOnhome")
    private WebElement travellerSelection;

    public HotelBookingTest() {
    	
	}
    
    @Test
    public void shouldBeAbleToSearchForHotels() {
    	PageFactory.initElements(getDriver(), this);
    	
        hotelLink.click();

        localityTextBox.sendKeys("Indiranagar, Bangalore");
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
        
        localityTextBox.sendKeys(Keys.RETURN);
       
        
        WebElement dateFrom = driver.findElement(By.xpath("//div[@class='monthBlock first']//tr[5]//td[1]"));
        Assert.assertTrue((FunctionLib.isElemntVisble(dateFrom)),"Failed as not able to view From Date for hotel booking");
        dateFrom.click();
        
        
        WebElement checkOutDate = driver.findElement(By.id("CheckOutDate"));
        Assert.assertTrue((FunctionLib.isElemntVisble(checkOutDate)),"Failed as not able to view to check out Date for hotel booking");
        checkOutDate.click();
        WebElement dateTill = driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr[4]/td[7]"));
       Assert.assertTrue((FunctionLib.isElemntVisble(dateTill)),"Failed as not able to view To Date for hotel booking");
       dateTill.click();
       
        Assert.assertTrue(FunctionLib.seletBasedOnVisibleText(travellerSelection, "1 room, 2 adults"));
        
        searchButton.click();
        try {
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
		}
      

    }

   

}
