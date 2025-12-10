package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PaymentPage extends BrowserUtilty {

    private static final By PAYMENT_BY_BANK_WIRE= By.xpath("//a[@title='Pay by bank wire']");
    private static final By CONFIRM_PAYMENT = By.xpath("//p[@class='cart_navigation clearfix']/button");
    private static final By ALERT_SUCCESS_MESSAGE_LOCATOR = By.xpath("//p[@class='alert alert-success']");

    public PaymentPage(WebDriver driver) {
        super(driver);
    }

    public String makePaymentByWire(){
        clickOn(PAYMENT_BY_BANK_WIRE);
        clickOn(CONFIRM_PAYMENT);
        return getVisibleText(ALERT_SUCCESS_MESSAGE_LOCATOR);
    }
}
