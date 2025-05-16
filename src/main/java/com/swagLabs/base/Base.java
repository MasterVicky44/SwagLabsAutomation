package com.swagLabs.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.Properties;

public class Base implements Constant {

    private static final ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static Properties properties;

    public Base() {
        try {
            properties = new Properties();
            FileInputStream fis = new FileInputStream("src/main/java/com/swagLabs/config/config.properties");
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void startBrowser(String browserType) {
        WebDriver localDriver;
        if (browserType.equalsIgnoreCase(FIREFOX)) {
            localDriver = new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase(SAFARI)) {
            localDriver = new SafariDriver();
        } else {
            ChromeOptions options = new ChromeOptions();
            HashMap<String, Object> prefs = new HashMap<>();
            prefs.put("credentials_enable_service", false);
            prefs.put("profile.password_manager_enabled", false);
            options.setExperimentalOption("prefs", prefs);
            options.addArguments("--incognito");

            localDriver = new ChromeDriver(options);
        }

        localDriver.manage().window().maximize();
        localDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.set(localDriver);
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void tearDown() {
        if (getDriver() != null) {
            getDriver().manage().deleteAllCookies();
            getDriver().quit();
            driver.remove();
        }
    }

    public static void goToLoginPage() {
        getDriver().get(properties.getProperty(LOGIN_URL));
    }
}
