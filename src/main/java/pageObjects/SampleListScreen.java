package pageObjects;

import org.openqa.selenium.By;
import enums.Direction;

public class SampleListScreen extends BaseScreen {

    By screenHeader = By.xpath("//android.widget.TextView[@text='Samples List']");

    public boolean isSampleListScreenDisplayed() {
        return waitForElementVisibility(screenHeader).isDisplayed();
    }

    public void navigateTo(String viewItem) throws Exception {
        By element = By.xpath(String.format("//android.widget.TextView[@text='%s']", viewItem));
        int counter = 0;
        while (!isDisplayed(element) && counter < 3) {
            performSwipe(Direction.UP);
            counter++;
            if(counter == 3){
                throw new Exception(String.format("Element not found by: %s", element));
            }
        }
        waitForElementVisibility(element).click();
    }
}
