package pageObjects;

import enums.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class SampleListDemoScreen extends BaseScreen {

    By screenHeader = By.xpath("//android.widget.TextView[@text='Samples List']");

    public boolean isSampleListScreenDisplayed() {
        return waitForElementVisibility(screenHeader).isDisplayed();
    }

    public void navigateTo(String viewItem) {
        By element = By.xpath(String.format("//android.widget.TextView[@text='%s']", viewItem));
        int counter = 0;
        while (!isElementDisplayed(element) && counter < 3) {
            performSwipe(Direction.UP);
            counter++;
            if (counter == 3) {
                throw new NotFoundException(String.format("Element not found by: %s", element));
            }
        }
        waitForElementVisibility(element).click();
    }
}
