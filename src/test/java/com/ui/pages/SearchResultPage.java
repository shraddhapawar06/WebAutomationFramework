package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SearchResultPage extends BrowserUtilty{

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class=\"lighter\"]");

    private static final By PRODUCT_LISTS = By.xpath("//h5[@itemprop='name']//a");


    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public  String  getSearchResultTitleTitle(){
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public List<String> getAllDressesName(){
         return getAllVisibleText(PRODUCT_LISTS);

    }
}
