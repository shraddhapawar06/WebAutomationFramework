package com.ui.test;

import com.ui.pages.MyAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({ com.ui.listeners.TestListener.class })

public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;
    private static final String SEARCH_TERM="Printed Summer Dress";

    @BeforeMethod(description = "Valid user logged into application")
    public void setUp(){
        myAccountPage=homePage.goToLoginPage().doLoginWith("sigoro5941@foxroids.com","password");
    }

    @Test(description = "Verify if the logged user is able to search for a product and search result should display",
            groups = {"e2e","smoke","sanity"})
    public void verifyProductSearchTest(){
        String  data=myAccountPage.searchForProduct("Printed Summer Dress").getSearchResultTitleTitle();
        System.out.println(data);
    }

    @Test(description = "Verify the logged in user is able to see search result and all product should display",
            groups = {"e2e","smoke","sanity"})
    public void verifyproductSearchTest() {
        boolean actualResult = myAccountPage.searchForProduct("Printed Summer Dress").isSeachTermPresentInProductList(SEARCH_TERM);
        Assert.assertEquals(actualResult,true);
    }



    }

