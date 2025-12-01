package com.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class LambdaTestUtility {
    private static final String HUB_URL = "https://hub.lambdatest.com/wd/hub";
    private static ThreadLocal<WebDriver> driverlocal = new ThreadLocal<WebDriver>();
    private static ThreadLocal<DesiredCapabilities> capabilitieslocal = new ThreadLocal<DesiredCapabilities>();

    public static WebDriver initializeLambaTestSesion(String browser, String testName){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", browser);
        capabilities.setCapability("browserVersion", "latest");
        Map<String, Object> ltOptions = new HashMap<>();
        ltOptions.put("user", "shraddhapawar48");
        ltOptions.put("accessKey","LT_d2a0xDGSRKlRnKNJJfZR4BT1tfgGRDwyBuReyyQzKJ5I8Yt");
        ltOptions.put("build", "Selenium 4");
        ltOptions.put("name",testName );
        ltOptions.put("platformName", "Windows 10");
        ltOptions.put("seCdp", true);
        ltOptions.put("selenium_version", "latest");
        capabilities.setCapability("LT:Options", ltOptions);
        capabilitieslocal.set(capabilities);
        WebDriver driver= null;
        try {
            driver = new RemoteWebDriver(new URL(HUB_URL),capabilitieslocal.get());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        driverlocal.set(driver);

        return driverlocal.get();
    }

    public static void quitSession(){
        if (driverlocal.get()!=null){
            driverlocal.get().quit();
        }

    }


}
