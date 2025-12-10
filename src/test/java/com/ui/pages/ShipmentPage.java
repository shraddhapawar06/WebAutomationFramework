package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShipmentPage extends BrowserUtilty {

    private static final By AGREE_TERMS_CONDITION_CHECKBOX= By.id("uniform-cgv");
    private static final By PROCEED_TO_CHECKOUT= By.name("processCarrier");

    public ShipmentPage(WebDriver driver) {
        super(driver);
    }
    public PaymentPage goToPaymentPage(){
        clickOn(AGREE_TERMS_CONDITION_CHECKBOX);
        clickOn(PROCEED_TO_CHECKOUT);
        return new PaymentPage(getDriver());
    }
}
