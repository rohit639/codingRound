package com.cleartrip.demotest;
import com.cleartrip.utils.BaseWebdriver;
import com.cleartrip.utils.FunctionLib;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends BaseWebdriver {

   

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

         WebElement yourTrips = driver.findElement(By.linkText("Your trips"));
         Assert.assertTrue(FunctionLib.isElemntVisble(yourTrips), "Failed as not able to view your trips link");
         yourTrips.click();
         WebElement singIn = driver.findElement(By.id("SignIn"));
         Assert.assertTrue(FunctionLib.isElemntVisble(singIn), "Failed as not able to view Sign-In button link");
         singIn.click();
         
        WebElement frame = driver.findElement(By.id("modal_window"));
         Assert.assertTrue(FunctionLib.switchToFrame(frame));
        
        WebElement formSignIn =  driver.findElement(By.id("signInButton"));
        Assert.assertTrue(FunctionLib.isElemntVisble(formSignIn), "Failed as not able to view sign-In in sign-In pagr/form");
        formSignIn.click();
         String errors1 = driver.findElement(By.id("errors1")).getText();
        
         Assert.assertTrue(errors1.contains("There were errors in your submission"));
         driver.switchTo().parentFrame();
         
    }

   

}
