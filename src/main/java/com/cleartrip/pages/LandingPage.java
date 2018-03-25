package com.cleartrip.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;

public class LandingPage extends BasePage {
	
	 @FindBy(linkText = "Hotels")
	    public WebElement hotelLink;
	 
	 @FindBy(id="OneWay")
	 private WebElement oneWay;
	
	 @FindBy(id="FromTag")
	 private WebElement fromPlace;
	 
	 @FindBy(id="ToTag")
	 private WebElement toPlace;
	 
	 @FindBy(xpath="//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]")
	 private WebElement dateSelection;
	 
	 @FindBy(id="SearchBtn")
	 private WebElement searchButton;
	 
	 
	 
	public LandingPage() {
		PageFactory.initElements(BaseWebdriver.getDriver(), this);
		Assert.assertEquals(BaseWebdriver.getDriver().getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.","Failed as title is not same as provided for "+this.getClass());
	}

	public SearchResultPage flightSearch() {
		
        Assert.assertTrue(FunctionLib.isElemntVisble(oneWay));
        oneWay.click();

        fromPlace.clear();
        fromPlace.sendKeys("Bangalore");
      
        List<WebElement> originOptions = BaseWebdriver.getDriver().findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
        Assert.assertTrue(FunctionLib.isAllElemntVisble(originOptions));
        originOptions.get(0).click();

        toPlace.clear();
        toPlace.sendKeys("Delhi");

        List<WebElement> destinationOptions = BaseWebdriver.getDriver().findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
        Assert.assertTrue(FunctionLib.isAllElemntVisble(destinationOptions));
        destinationOptions.get(0).click();

        //need to work on date 
        dateSelection.click();

    
        searchButton.click();
       return new SearchResultPage();
	}
	
	
	public HotelBookingPage navigateToHotelPage() {
		 hotelLink.click();
		 return new HotelBookingPage();
	}
	
	}
