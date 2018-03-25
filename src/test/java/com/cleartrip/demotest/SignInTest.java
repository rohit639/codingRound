package com.cleartrip.demotest;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cleartrip.pages.LandingPage;
import com.cleartrip.utils.BaseWebdriver;

public class SignInTest extends BaseWebdriver {

   

    @Test
    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {

    	 LandingPage homePage = new LandingPage();
        
         Assert.assertTrue(homePage.navigateToSignInPage().verifySignIn(),"Failed to verify error message for SignIn");
         driver.switchTo().parentFrame();
     }

   

}
