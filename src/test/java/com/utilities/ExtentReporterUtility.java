package com.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporterUtility {
    private static ExtentReports extentReports;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void setupSparkreporter(String reportName){
        ExtentSparkReporter extentSparkReporter = new ExtentSparkReporter(
                System.getProperty("user.dir") + "/" + reportName
        );

        // Configure the report
        extentSparkReporter.config().setTheme(Theme.STANDARD);
        extentSparkReporter.config().setDocumentTitle("Automation Test Report");
        extentSparkReporter.config().setReportName("Test Execution Report");
        extentSparkReporter.config().setEncoding("utf-8");

        extentReports = new ExtentReports();
        extentReports.attachReporter(extentSparkReporter);

        // Add system information
        extentReports.setSystemInfo("OS", System.getProperty("os.name"));
        extentReports.setSystemInfo("Java Version", System.getProperty("java.version"));
        extentReports.setSystemInfo("User", System.getProperty("user.name"));
    }

    public static void createExtentTest(String testName){
        ExtentTest test = extentReports.createTest(testName);
        extentTest.set(test);
    }

    public static ExtentTest getTest(){
        return extentTest.get();
    }

    public static void flushReport(){
        if (extentReports != null) {
            extentReports.flush();
        }
    }
}