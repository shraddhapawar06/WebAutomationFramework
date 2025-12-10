package com.ui.test;

import com.constants.Color;
import com.constants.Size;
import com.ui.pages.SearchResultPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Size;


@Listeners({ com.ui.listeners.TestListener.class })

public class ProductCheckoutTest extends TestBase{

    private  static String SEARCH_TERM="Printed Summer Dress";
    private SearchResultPage searchResultPage;

    @BeforeMethod(description="User Logs into application and searches for a product")
    public void setUp(){
       searchResultPage = homePage.goToLoginPage().doLoginWith("sigoro5941@foxroids.com","password").searchForProduct(SEARCH_TERM);

    }

    @Test(description = "Verify user is able to checkout product",groups = {"e2e","sanity"},retryAnalyzer = com.ui.listeners.RetryAnaylzer.class)
    public void verifyProductCheckout(){
        String orderconfirmationmsg =searchResultPage.clickOnTheProduct(0).changeSize(Size.M).changeColor(Color.BLUE).clickOnAddToCart()
                .proceedToCheckout().proceedToCheckoutFromShoppingPage().goToShipmentpage().goToPaymentPage().makePaymentByWire();
        Assert.assertTrue(orderconfirmationmsg.contains("complete"));
        System.out.println(orderconfirmationmsg);
    }
}
