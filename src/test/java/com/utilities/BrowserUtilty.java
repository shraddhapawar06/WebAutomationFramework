package com.utilities;

import com.constants.Browser;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtilty {
    // Changed to static ThreadLocal for proper thread isolation
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public BrowserUtilty(Browser browserName, boolean isHeadless) {
        super();
        WebDriver webDriver = null;

        if (browserName == Browser.CHROME) {
            if (isHeadless) {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--headless");
                options.addArguments("--window-size=1920,1080");
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                webDriver = new ChromeDriver(options);
            } else {
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-dev-shm-usage");
                options.addArguments("--no-sandbox");
                webDriver = new ChromeDriver(options);
            }
        } else if (browserName == Browser.EDGE) {
            if (isHeadless) {
                EdgeOptions options = new EdgeOptions();
                options.addArguments("--headless=old");
                options.addArguments("disable-gpu");
                webDriver = new EdgeDriver(options);
            } else {
                webDriver = new EdgeDriver();
            }
        } else if (browserName == Browser.FIREFOX) {
            if (isHeadless) {
                FirefoxOptions options = new FirefoxOptions();
                options.addArguments("--headless");
                webDriver = new FirefoxDriver(options);
            } else {
                webDriver = new FirefoxDriver();
            }
        }

        driver.set(webDriver);
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtilty(WebDriver driver) {
        super();
        this.driver.set(driver);
    }

    public void goToWebsite(String url){
        if (driver.get() != null) {
            driver.get().get(url);
        }
    }

    public void maximizeWindow() {
        if (getDriver() != null)
            getDriver().manage().window().maximize();// maximize the window
    }

    public void clickOn(By locator) {
        if (getDriver() != null) {
            WebElement element = WaitUtility.waitForClickable(getDriver(),locator);
            element.click();
        }
    }

    public void enterText(By locator, String text) {
        if (getDriver() != null) {
            WebElement element = WaitUtility.waitForVisibility(getDriver(), locator);
            clearText(locator);
            element.sendKeys(text);
        }
    }

    public void clearText(By locator) {
        if (getDriver() != null) {
            WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
            element.clear();
        }
    }

    public void enterSpecialKey(By locator, Keys keyToEnter){
        if (driver.get() != null) {
            WebElement webElement = driver.get().findElement(locator);
            webElement.sendKeys(keyToEnter);
        }
    }

    public String getVisibleText(By locator) {
        if (getDriver() != null) {
            WebElement element = WaitUtility.waitForVisibility(getDriver(),locator);
            return element.getText();
        }
        return "";
    }

    public List<String> getAllVisibleText(By locator){
        if (getDriver() != null) {
            List<WebElement> webElementList = WaitUtility.waitForVisibleElements(getDriver(),locator);
            List<String> textList = new ArrayList<>();
            for(WebElement element: webElementList){
                textList.add(element.getText());
            }
            return textList;
        }
        return null;
    }

    public String takeScreenshot(String name){
        if (driver.get() == null) {
            return "";
        }

        TakesScreenshot screenshot = (TakesScreenshot) driver.get();
        File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
        String timeStamp = format.format(date);
        String path = "./screenshots/" + name + "-" + timeStamp + ".png";

        File screenshotFile = new File(path);

        try {
            FileUtils.copyFile(screenshotData, screenshotFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return path;
    }

    // New method to properly quit driver and remove from ThreadLocal
    public void quitDriver() {
        if (driver.get() != null) {
            try {
                driver.get().quit();
            } catch (Exception e) {
                System.err.println("Error while quitting driver: " + e.getMessage());
            } finally {
                driver.remove();
            }
        }
    }
}