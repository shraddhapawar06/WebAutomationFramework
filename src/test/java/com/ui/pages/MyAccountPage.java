package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public final class MyAccountPage extends BrowserUtilty {


    private static final By USER_NAME_TEXT_LOCATOR = By.xpath("//a[@title='View my customer account']/span");

    private static final By SEARCH_TEXT_BOX_LOCATOR=By.id("search_query_top");

    private static  final By ADD_NEW_ADDRESS_LOCATOR=By.xpath("//a[@title='Add my first address']");
    public MyAccountPage(WebDriver driver) {

        super(driver);
    }

    public String getUserName(){
        return  getVisibleText(USER_NAME_TEXT_LOCATOR);
    }

    public SearchResultPage searchForProduct(String productName){
        enterText(SEARCH_TEXT_BOX_LOCATOR,productName);
        enterSpecialKey(SEARCH_TEXT_BOX_LOCATOR, Keys.ENTER);
        return new SearchResultPage(getDriver());

    }

    public AddressPage goToAddressPage(){
        clickOn(ADD_NEW_ADDRESS_LOCATOR);

        AddressPage addressPage= new AddressPage(getDriver());
        return addressPage;
    }
}
