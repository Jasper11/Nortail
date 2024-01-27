package pageObjects;

import enums.Direction;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;

public class VerticalSwipeDemoScreen extends BaseScreen {

    public boolean isElementWithTextDisplayed(String text) {
        By element = By.xpath(String.format("//android.widget.TextView[@text='%s']", text));
        int counter = 0;
        while (!isElementDisplayed(element) && counter < 3) {
            performSwipe(Direction.UP);
            counter++;
            if (counter == 3) {
                throw new NotFoundException(String.format("Element not found by: %s", element));
            }
        }
        return true;
    }
}
