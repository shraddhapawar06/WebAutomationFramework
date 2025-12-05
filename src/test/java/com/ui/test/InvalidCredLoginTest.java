package com.ui.test;

import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

@Listeners({ com.ui.listeners.TestListener.class })


public class InvalidCredLoginTest extends  TestBase{


    private static final String INVALID_EMAIL_ADDRESS="shraddhapawar86@gmail.com";
    private static final String INVALID_PASSWORD ="Juyhuk";


    @Test(description = "Verify if the proer error msg shown for the user if that user login with invalid username and password",
            groups ={"sanity","e2e"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void InValidLoginTest(User user){
        assertEquals(homePage.goToLoginPage().doLoginWithInvalidCredential(INVALID_EMAIL_ADDRESS,INVALID_PASSWORD).getErrorMessage(), "Authentication failed");
    }


}
