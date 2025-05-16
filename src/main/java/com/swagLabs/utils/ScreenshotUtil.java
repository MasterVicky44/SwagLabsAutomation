package com.swagLabs.utils;

import com.swagLabs.base.Base;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil extends Base {

    public static String captureScreenshot(String testName) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = "target/ScreenShots/";
        String screenshotFile = testName + "_" + timestamp + ".png";
        String screenshotPath = screenshotDir + screenshotFile;

        try {
            File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);
            File destFile = new File(screenshotPath);
            destFile.getParentFile().mkdirs();
            Files.copy(srcFile.toPath(), destFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "../ScreenShots/" + screenshotFile; // relative to ExtentReport
    }
}
