package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.List;

public class SearchResultPage extends BrowserUtilty{

    private static final By PRODUCT_LISTING_TITLE_LOCATOR = By.xpath("//span[@class='lighter']");

    private static final By PRODUCT_LISTS = By.xpath("//h5[@itemprop='name']//a");



    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    public  String  getSearchResultTitleTitle(){
        return getVisibleText(PRODUCT_LISTING_TITLE_LOCATOR);
    }

    public boolean isSeachTermPresentInProductList(String searchTerm){
        List<String> keywords = Arrays.asList(searchTerm.toLowerCase().split(" "));
        List<String> productNamesList = getAllVisibleText(PRODUCT_LISTS);
        boolean result=productNamesList.stream().anyMatch(name -> (keywords.stream().anyMatch(name.toLowerCase()::contains)));

         return result;

    }
    public ProductDetailPage clickOnTheProduct(int index){
        clickOn(getAllElements(PRODUCT_LISTS).get(index));
        ProductDetailPage productDetailPage=new ProductDetailPage(getDriver());
        return productDetailPage;
    }


}
