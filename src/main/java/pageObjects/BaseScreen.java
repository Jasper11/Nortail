package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import enums.Direction;
import utils.HelperClass;

import java.time.Duration;
import java.util.Collections;

public abstract class BaseScreen {
    protected AndroidDriver driver;
    public static final int DEFAULT_EXPLICIT_WAIT_TIMEOUT = 5;
    By popUpTextElement = By.id("android:id/message");

    public BaseScreen() {
        this.driver = HelperClass.getDriver();
    }

    public boolean isPopUpWithTextDisplayed(String text) {
        return waitForElementVisibility(popUpTextElement).getText().equals(text);
    }

    public boolean isDisplayed(By element){
        try {
            return waitForElementVisibility(element).isDisplayed();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public WebElement waitForElementVisibility(By element) {
        return new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(DEFAULT_EXPLICIT_WAIT_TIMEOUT))
            .pollingEvery(Duration.ofMillis(250))
            .ignoring(NoSuchElementException.class)
            .until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public Point getElementCenter(WebElement element) {
        Point location = element.getLocation();
        Dimension size = element.getSize();
        return new Point(location.getX() + size.getWidth() / 2, location.getY() + size.getHeight() / 2);
    }

    public void doubleTap(WebElement element) {
        Point elementCenter = getElementCenter(element);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), elementCenter))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(100)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(100)))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(100)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void longPress(WebElement element) {
        Point elementCenter = getElementCenter(element);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), elementCenter))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofSeconds(2)))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void dragNDrop(WebElement sourceElement, WebElement targetElement) {
        Point sourceElementCenter = getElementCenter(sourceElement);
        Point targetElementCenter = getElementCenter(targetElement);
        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), sourceElementCenter))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(500)))
            .addAction(finger1.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), targetElementCenter))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }

    public void performSwipe(Direction direction) {
        Dimension size = driver.manage().window().getSize();
        int startY = 0;
        int endY = 0;
        int startX = 0;
        int endX = 0;

        if (direction.equals(Direction.LEFT)) {
            startY = (int) (size.height * 0.5);
            endY = (int) (size.height * 0.5);
            startX = (int) (size.width * 0.5);
            endX = (int) (size.width * 0.25);
        } else if (direction.equals(Direction.RIGHT)) {
            startY = (int) (size.height * 0.5);
            endY = (int) (size.height * 0.5);
            startX = (int) (size.width * 0.5);
            endX = (int) (size.width * 0.75);
        } else if (direction.equals(Direction.UP)) {
            startY = (int) (size.height * 0.5);
            endY = (int) (size.height * 0.25);
            startX = (int) (size.width * 0.5);
            endX = (int) (size.width * 0.5);
        } else if (direction.equals(Direction.DOWN)) {
            startY = (int) (size.height * 0.5);
            endY = (int) (size.height * 0.75);
            startX = (int) (size.width * 0.5);
            endX = (int) (size.width * 0.5);
        } else {
            System.err.println("Incorrect DIRECTION parameter");
        }

        PointerInput finger1 = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence sequence = new Sequence(finger1, 1)
            .addAction(finger1.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY))
            .addAction(finger1.createPointerDown(PointerInput.MouseButton.LEFT.asArg()))
            .addAction(new Pause(finger1, Duration.ofMillis(200)))
            .addAction(finger1.createPointerMove(Duration.ofMillis(200), PointerInput.Origin.viewport(), endX, endY))
            .addAction(finger1.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(sequence));
    }
}
