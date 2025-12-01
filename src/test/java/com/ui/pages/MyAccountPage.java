package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtilty {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    private static final By USER_NAME_TEXT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");

    public String getUserName(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return  getVisibleText(USER_NAME_TEXT_LOCATOR);
    }
}
