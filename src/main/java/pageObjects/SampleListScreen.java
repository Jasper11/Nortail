package pageObjects;

import org.openqa.selenium.By;
import utils.Direction;

public class SampleListScreen extends BaseScreen {

    By screenHeader = By.xpath("//android.widget.TextView[@text='Samples List']");

    public boolean isSampleListScreenDisplayed() {
        return waitForElementVisibility(screenHeader).isDisplayed();
    }

    public void navigateTo(String viewItem) {
        By element = By.xpath(String.format("//android.widget.TextView[@text='%s']", viewItem));

        while (!waitForElementVisibility(element).isDisplayed()) {
            performSwipe(Direction.UP);
        }

        waitForElementVisibility(element).click();
    }
}
