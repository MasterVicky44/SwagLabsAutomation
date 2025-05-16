package com.swagLabs.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.swagLabs.utils.ScreenshotUtil;
import org.apache.logging.log4j.ThreadContext;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class LogAndExtentListener implements ITestListener {
    private static final Logger logger = Log.getLogger(); // Your custom logger utility
    private static final ExtentReports extent = ExtentManager.getInstance();
    private static final ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        ThreadContext.put("suiteName", context.getName());
        logger.info("===== Test "+context.getName() +"  Started: " );
    }

    @Override
    public void onFinish(ITestContext context) {
        logger.info("===== Test "+context.getName() +"  Finished: " );
        ThreadContext.remove("suiteName");
        extent.flush();
    }

    @Override
    public void onTestStart(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        ThreadContext.put("testName", testName); // add test name to MDC
        logger.info("Starting test: " + testName);

        ExtentTest test = extent.createTest(testName);
        extentTest.set(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        extentTest.get().log(Status.PASS, "Test Passed");
        logger.info("Test Passed: " + result.getMethod().getMethodName());
        ThreadContext.remove("testName");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        logger.error("Test Failed: " + testName, result.getThrowable());
        extentTest.get().log(Status.FAIL, "Test Failed: " + result.getThrowable());
        String screenshotPath = ScreenshotUtil.captureScreenshot(testName);
        try {
            extentTest.get().addScreenCaptureFromPath(screenshotPath);
            logger.info("Screenshot attached: " + screenshotPath);
        } catch (Exception e) {
            logger.error("Failed to attach screenshot to report", e);
        }
    }


    @Override
    public void onTestSkipped(ITestResult result) {
        String testName = result.getMethod().getMethodName();
        logger.warn("Test Skipped: " + testName);
        extentTest.get().log(Status.SKIP, "Test Skipped");
        ThreadContext.remove("testName");
    }
}
