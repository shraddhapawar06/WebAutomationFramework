package com.ui.test;

import com.ui.pages.MyAccountPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.util.List;

@Listeners({ com.ui.listeners.TestListener.class })

public class SearchProductTest extends TestBase{

    private MyAccountPage myAccountPage;

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
    public void getAllProductListTest() {
        List<String> productList=myAccountPage.searchForProduct("Printed Summer Dress").getAllDressesName();
        System.out.println(productList);
    }



    }

