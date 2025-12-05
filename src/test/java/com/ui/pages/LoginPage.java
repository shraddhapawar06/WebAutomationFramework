package com.ui.pages;

import com.utilities.BrowserUtilty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class LoginPage extends BrowserUtilty {

    public LoginPage(WebDriver driver) {

        super(driver);
    }

    private static final By EMAIL_TEXT_BOX_LOCATOR= By.xpath("//input[@id='email']");
    private static final By PASSWORD_TEXT_BOX_LOCATOR  = By.xpath("//input[@id='passwd']");
    private static final By SUBMIT_BUTTON_LOCATOR = By.id("SubmitLogin");
    private static final By ERROR_MESSAGE_LOCATOR = By.xpath("//div[contains(@class,\"alert-danger\")]/ol/li");


    public  MyAccountPage doLoginWith(String email, String password){
     enterText(EMAIL_TEXT_BOX_LOCATOR,email);
     enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
     clickOn(SUBMIT_BUTTON_LOCATOR);
     return new MyAccountPage(getDriver());

 }

 public LoginPage doLoginWithInvalidCredential(String emailAddress, String password){

     enterText(EMAIL_TEXT_BOX_LOCATOR,emailAddress);
     enterText(PASSWORD_TEXT_BOX_LOCATOR,password);
     clickOn(SUBMIT_BUTTON_LOCATOR);
     return new LoginPage(getDriver());

 }

 public  String getErrorMessage(){
        return getVisibleText(ERROR_MESSAGE_LOCATOR);
 }

}
