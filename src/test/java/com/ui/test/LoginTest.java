package com.ui.test;

import static org.testng.Assert.*;
import com.ui.pojo.User;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(com.ui.listeners.TestListener.class)
public class LoginTest extends TestBase{

    @Test(description = "Verify that user login with valid username and password",
            groups ={"sanity","e2e"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
    public void loginPropTest(User user){
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Asp Sharma");
    }

    @Test(description = "Verify that user login with valid username and password",
            groups ={"sanity","e2e"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class,
            dataProvider = "LoginCSVDataProvider", retryAnalyzer = com.ui.listeners.RetryAnaylzer.class)
    public void loginCSVTest(User user){
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Asp Sharma");

    }

    @Test(description = "Verify that user login with valid username and password",
            groups ={"sanity","e2e"},dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginExcelDataProvider")
    public void loginExcelTest(User user){
        assertEquals(homePage.goToLoginPage().doLoginWith(user.getEmailAddress(),user.getPassword()).getUserName(),"Carox Em");
    }

}
