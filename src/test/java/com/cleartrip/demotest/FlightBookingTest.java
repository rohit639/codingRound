package com.cleartrip.demotest;
import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class FlightBookingTest extends BaseWebdriver {

		@Test
	    public void testThatResultsAppearForAOneWayJourney() {

	    	WebElement oneWay = driver.findElement(By.id("OneWay"));
	        Assert.assertTrue(FunctionLib.isElemntVisble(oneWay));
	        oneWay.click();

	        driver.findElement(By.id("FromTag")).clear();
	        driver.findElement(By.id("FromTag")).sendKeys("Bangalore");
	       
	        List<WebElement> originOptions = driver.findElement(By.id("ui-id-1")).findElements(By.tagName("li"));
	        Assert.assertTrue(FunctionLib.isAllElemntVisble(originOptions));
	        originOptions.get(0).click();

	        driver.findElement(By.id("ToTag")).clear();
	        driver.findElement(By.id("ToTag")).sendKeys("Delhi");

	        List<WebElement> destinationOptions = driver.findElement(By.id("ui-id-2")).findElements(By.tagName("li"));
	        Assert.assertTrue(FunctionLib.isAllElemntVisble(destinationOptions));
	        destinationOptions.get(0).click();

	        //need to work on date 
	        driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr[4]/td[7]")).click();

	    
	       driver.findElement(By.id("SearchBtn")).click();
	       WebElement searchSummry = driver.findElement(By.className("searchSummary"));
	       Assert.assertTrue(FunctionLib.isElemntVisble(searchSummry));
	       
	       //this is just to show page completed task. No need of try block
	       try {
			Thread.sleep(1000);		} catch (Exception e) {	}
	    }

	    
}
