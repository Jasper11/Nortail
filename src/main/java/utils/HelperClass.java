package utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Objects;

public class HelperClass {

    private static HelperClass instance;
    private static AndroidDriver driver;
    private static AppiumDriverLocalService service;
    private static String currentAppBundleId;

    private HelperClass() throws MalformedURLException {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();

        UiAutomator2Options options = new UiAutomator2Options()
            .setUdid(System.getProperty("deviceId"))
            .autoGrantPermissions()
            .setApp(System.getProperty("appPath"));

        URL url = null;
        if (System.getProperty("env").equalsIgnoreCase("local")) {
            url = service.getUrl();
        }
        if (System.getProperty("env").equalsIgnoreCase("cloud")) {
            url = new URL("http://username:accessKey@hub-cloud.browserstack.com/wd/hub");
        }

        driver = new AndroidDriver(Objects.requireNonNull(url), options);
        currentAppBundleId = driver.getCurrentPackage();
    }

    public static AndroidDriver getDriver() {
        return driver;
    }

    public static String getCurrentAppBundleId() {
        return currentAppBundleId;
    }

    public static void setUpDriver() throws MalformedURLException {

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