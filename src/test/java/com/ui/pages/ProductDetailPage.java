package com.ui.pages;

import com.constants.Color;
import com.constants.Size;
import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class ProductDetailPage extends BrowserUtilty {

        private static final By SIZE_DROP_DOWN_LOCATOR = By.xpath("//div[@id='uniform-group_1']");
        private static final By BLUE_COLOR = By.xpath("//a[@id='color_14']");
   // private static final By BLACK_COLOR = By.name("Black");
        private static final By ADD_TO_CART= By.xpath("//button[@name='Submit']");
        private static final By PROCEED_TO_CHECKOUT= By.xpath("//a[@title='Proceed to checkout']");


    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public ProductDetailPage changeSize(Size size){
        selectDynamicDropdown(SIZE_DROP_DOWN_LOCATOR ,size.toString());
        return this;

    }

    public ProductDetailPage changeColor(Color color){
        if(color.toString().equals("BLUE")){
            actionClick(BLUE_COLOR);
        }
        return this;
    }

    public ProductDetailPage clickOnAddToCart(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        clickOn(ADD_TO_CART);
        return new ProductDetailPage(getDriver());

    }
     public ShoppingCartPage proceedToCheckout(){
         actionClick(PROCEED_TO_CHECKOUT);
        return  new ShoppingCartPage(getDriver());
     }

}
