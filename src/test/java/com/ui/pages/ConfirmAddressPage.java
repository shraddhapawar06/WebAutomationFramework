package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ConfirmAddressPage extends BrowserUtilty {

    private static final By PROCEED_TO_CHECKOUT= By.xpath("//button[@name='processAddress']");


    public ConfirmAddressPage(WebDriver driver) {
        super(driver);
    }

    public ShipmentPage goToShipmentpage(){
        clickOn(PROCEED_TO_CHECKOUT);
        return new ShipmentPage(getDriver());
    }
}
