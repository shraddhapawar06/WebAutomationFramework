package com.ui.test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.utilities.BrowserUtilty;
import com.utilities.ExtentReporterUtility;
import com.utilities.LambdaTestUtility;
import com.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import static com.constants.Browser.CHROME;

public class TestBase {
    protected HomePage homePage;
    Logger logger=LoggerUtility.getLogger(this.getClass());
    private boolean isLambdaTest;

    @Parameters({"browser","isLambdaTest","isHeadLess"})
    @BeforeMethod(description = "Load home page of the website")
    public void setUp(@Optional ("chrome") String browser ,
                      @Optional ("false") boolean isLambdaTest,
                      @Optional ("false") boolean isheadless,
                       ITestResult result){
        this.isLambdaTest=isLambdaTest;
        WebDriver lambdaDriver;
        if (isLambdaTest){
            //For cloud test execution

            lambdaDriver=LambdaTestUtility.initializeLambaTestSesion("chrome",result.getMethod().getMethodName());
            homePage = new HomePage(lambdaDriver);
        }else {
            //Running the test on local machine!!
            homePage = new HomePage(Browser.valueOf(browser.toUpperCase()), isheadless);
        }
    }

//    @AfterMethod(description = "Close browser and cleanup")
//    public void tearDown() {
//        if (homePage != null) {
//            if (isLambdaTest)
//                LambdaTestUtility.quitSession();   //quit browser of lambda session
//            else
//                homePage.quitDriver();  //local machine browser quit
//        }
//    }

    public BrowserUtilty getInstance(){

        return homePage;
    }
}