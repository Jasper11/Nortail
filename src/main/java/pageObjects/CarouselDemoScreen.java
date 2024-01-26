package pageObjects;

import org.openqa.selenium.By;

public class CarouselDemoScreen extends BaseScreen {

    public boolean messageWithTextDisplayed(String text) {
        By successMessage = By.xpath(String.format("//android.widget.TextView[@text='%s']", text));
        return waitForElementVisibility(successMessage).isDisplayed();
    }
}
