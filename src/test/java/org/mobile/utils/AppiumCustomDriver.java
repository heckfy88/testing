package org.mobile.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

import java.net.MalformedURLException;
import java.net.URI;
import java.time.Duration;

public class AppiumCustomDriver {

    private static AndroidDriver driver;
    private static final String APPIUM_SERVER_URL = "http://localhost:4723";

    public static AndroidDriver getDriver() throws MalformedURLException {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options();
            options.setPlatformName("Android");
            options.setDeviceName("emulator-5554");
            options.setAutomationName("UiAutomator2");
            options.setAppPackage("org.wikipedia");
            options.setAppActivity("org.wikipedia.main.MainActivity");
            options.setNoReset(true);
            options.setFullReset(false);
            options.setUdid(System.getProperty("deviceName", "emulator-5554"));

            driver = new AndroidDriver(URI.create(APPIUM_SERVER_URL).toURL(), options);
            driver.manage().timeouts().implicitlyWait(Duration.ZERO); // explicit setup
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
