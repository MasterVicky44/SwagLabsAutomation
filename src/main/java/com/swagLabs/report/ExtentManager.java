package com.swagLabs.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {
    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        if (extent == null) {
            extent = createInstance();
        }
        return extent;
    }

    private static ExtentReports createInstance() {
        // Define the path to save the report
        String reportDir = "src/test/resources/Reports"; // Recommended instead of /resources
        new File(reportDir).mkdirs(); // Create directory if it doesn't exist

        String reportPath = reportDir + "/ExtentReport.html";

        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
        reporter.config().setReportName("Swag Labs Automation Report");
        reporter.config().setDocumentTitle("Test Results");

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        // Optional: add system info
        extent.setSystemInfo("Tester", "Vineet Kumar");
        extent.setSystemInfo("Environment", "QA");

        return extent;
    }
}
