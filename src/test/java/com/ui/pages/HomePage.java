package com.ui.pages;

import com.constants.Browser;
import static com.constants.Env.*;

import com.ui.pojo.Config;
import com.utilities.BrowserUtilty;
import static com.utilities.PropertiesUtil.*;

import com.utilities.JsonUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public final class HomePage extends BrowserUtilty {
    private static final By SIGN_IN_LINK_LOCATOR = By.className("login");

    public HomePage(Browser browserName,boolean isHeadless) {
        super(browserName,isHeadless);
        //goToWebsite(readProperty(QA,"URL"));//To call the parent class constructor from child class constructor
        goToWebsite(JsonUtility.readJSON(QA).getUrl());
        maximizeWindow();
    }

    public HomePage(WebDriver driver) {
        super(driver);
        goToWebsite(JsonUtility.readJSON(QA).getUrl());

    }

    public LoginPage goToLoginPage(){  //page function
        clickOn(SIGN_IN_LINK_LOCATOR);
        return new LoginPage(getDriver());

    }



}
