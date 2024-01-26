package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class HelperClass {

    private static HelperClass instance;
    private static AndroidDriver driver;
    private static AppiumDriverLocalService service;

    private HelperClass() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
            .setUdid(System.getProperty("deviceId"))
            .autoGrantPermissions()
            .setApp(System.getProperty("appPath"));

        driver = new AndroidDriver(service.getUrl(), options);
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static void setUpDriver() {

        if (instance == null) {

            instance = new HelperClass();
        }
    }

    public static void tearDown() {

        if (driver != null) {
            driver.quit();
            service.stop();
        }

        instance = null;
    }

}