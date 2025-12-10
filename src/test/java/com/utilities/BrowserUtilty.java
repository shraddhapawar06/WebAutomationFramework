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
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class BrowserUtilty {
    // Changed to static ThreadLocal for proper thread isolation
    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    private static final int DEFAULT_TIMEOUT = 30;
    private WebDriverWait wait;

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
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));

    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public BrowserUtilty(WebDriver driver) {
        super();
        this.driver.set(driver);
        wait = new WebDriverWait(getDriver(), Duration.ofSeconds(DEFAULT_TIMEOUT));
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
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
        }
    }

    public void clickOn(WebElement element) {
        if (getDriver() != null) {
            element.click();
        }
    }

    public void enterText(By locator, String text) {
        if (getDriver() != null) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            clearText(locator);
            element.sendKeys(text);
        }
    }

    public void clearText(By locator) {
        if (getDriver() != null) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            element.clear();
        }
    }

    public void enterSpecialKey(By locator, Keys keyToEnter){
        if (driver.get() != null) {
            WebElement webElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            webElement.sendKeys(keyToEnter);
        }
    }

    public String getVisibleText(By locator) {
        if (getDriver() != null) {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.getText();
        }
        return "";
    }

    public List<String> getAllVisibleText(By locator){
        if (getDriver() != null) {
            List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            List<String> textList = new ArrayList<>();
            for(WebElement element: webElementList){
                textList.add(element.getText());
            }
            return textList;
        }
        return null;
    }

    public List<WebElement> getAllElements(By locator){
        if (getDriver() != null) {
            List<WebElement> webElementList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
            return webElementList;
        }
        return null;
    }

    public void selectFromDropDown(By dropdownLocator, String optionToSelect){
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(dropdownLocator));
        Select select= new Select(element);
        select.selectByContainsVisibleText(optionToSelect);
    }
    public void selectDynamicDropdown(By locator, String optionValue){
        if (driver.get() != null) {
            clickOn(locator);
            clickOn(By.xpath("//*[text()='"+optionValue+"']"));
        }
    }
    public void actionClick(By locator){
        WebElement element= wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Actions actions= new Actions(getDriver());
        actions.moveToElement(element).click().build().perform();
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