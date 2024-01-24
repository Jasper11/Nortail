package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import utils.HelperClass;

import java.time.Duration;

public abstract class BaseScreen {
    protected AndroidDriver driver;
    public static final int DEFAULT_EXPLICIT_WAIT_TIMEOUT = 10;

    public BaseScreen() {
        this.driver = HelperClass.getDriver();
    }

    public boolean isPopUpWithTextDisplayed(String text) {
        String elementText = waitForElementVisibility(By.id("android:id/message")).getText();
        return elementText.equals(text);
    }

    protected WebElement waitForElementVisibility(By element) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(DEFAULT_EXPLICIT_WAIT_TIMEOUT))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.visibilityOfElementLocated(element));
    }
}
