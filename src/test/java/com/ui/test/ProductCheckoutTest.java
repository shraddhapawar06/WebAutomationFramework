package com.ui.test;

import org.testng.annotations.BeforeMethod;

public class ProductCheckoutTest extends TestBase{

    @BeforeMethod(description="User Logs into application and searches for a product")
    public void setUp(){
        homePage.goToLoginPage().doLoginWith()

    }
}
