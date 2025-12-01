package com.ui.listeners;

import com.aventstack.extentreports.Status;
import com.ui.test.TestBase;
import com.utilities.BrowserUtilty;
import com.utilities.ExtentReporterUtility;
import com.utilities.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListener implements ITestListener {

    Logger logger = LoggerUtility.getLogger(this.getClass());

    @Override
    public void onTestStart(ITestResult result){
        logger.info("=== Test Started: " + result.getMethod().getMethodName() + " ===");
        logger.info("Description: " + result.getMethod().getDescription());
        logger.info("Groups: " + Arrays.toString(result.getMethod().getGroups()));

        ExtentReporterUtility.createExtentTest(result.getMethod().getMethodName());
        ExtentReporterUtility.getTest().info("Test Description: " + result.getMethod().getDescription());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        logger.info(result.getMethod().getMethodName() + " PASSED");
        ExtentReporterUtility.getTest().log(Status.PASS, result.getMethod().getMethodName() + " PASSED");
    }

    @Override
    public void onTestFailure(ITestResult result){
        logger.error(result.getMethod().getMethodName() + " FAILED");
        logger.error(result.getThrowable().getMessage());

        ExtentReporterUtility.getTest().log(Status.FAIL, result.getMethod().getMethodName() + " FAILED");
        ExtentReporterUtility.getTest().log(Status.FAIL, result.getThrowable().getMessage());

        try {
            Object testclass = result.getInstance();
            BrowserUtilty browserUtilty = ((TestBase) testclass).getInstance();

            if (browserUtilty != null && browserUtilty.getDriver() != null) {
                logger.info("Capturing screenshot for failed test");
                String screenshotPath = browserUtilty.takeScreenshot(result.getMethod().getMethodName());
                logger.info("Screenshot saved at: " + screenshotPath);

                if (screenshotPath != null && !screenshotPath.isEmpty()) {
                    ExtentReporterUtility.getTest().addScreenCaptureFromPath(screenshotPath);
                    logger.info("Screenshot attached to Extent Report");
                }
            } else {
                logger.warn("Browser instance is null, cannot capture screenshot");
            }
        } catch (Exception e) {
            logger.error("Error capturing screenshot: " + e.getMessage(), e);
            ExtentReporterUtility.getTest().warning("Could not capture screenshot: " + e.getMessage());
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName() + " SKIPPED");
        ExtentReporterUtility.getTest().log(Status.SKIP, result.getMethod().getMethodName() + " SKIPPED");

        if (result.getThrowable() != null) {
            logger.warn("Skip Reason: " + result.getThrowable());
            ExtentReporterUtility.getTest().log(Status.SKIP, result.getThrowable().getMessage());
        }
    }

    @Override
    public void onStart(ITestContext context) {
        logger.info("========================================");
        logger.info("Test Suite Started: " + context.getName());
        logger.info("========================================");

        ExtentReporterUtility.setupSparkreporter("ExtentReport.html");
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("========================================");
        logger.info("Test Suite Completed: " + context.getName());
        logger.info("Total Tests: " + context.getAllTestMethods().length);
        logger.info("Passed: " + context.getPassedTests().size());
        logger.info("Failed: " + context.getFailedTests().size());
        logger.info("Skipped: " + context.getSkippedTests().size());
        logger.info("========================================");

        ExtentReporterUtility.flushReport();
    }
}