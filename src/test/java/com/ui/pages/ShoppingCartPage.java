package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCartPage extends BrowserUtilty {

    private static final By PROCEED_TO_CHECKOUT= By.xpath("//p[@class='cart_navigation clearfix']/a[@title='Proceed to checkout']");


    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    public ConfirmAddressPage proceedToCheckoutFromShoppingPage(){
        actionClick(PROCEED_TO_CHECKOUT);
        return  new ConfirmAddressPage(getDriver());
    }
}


