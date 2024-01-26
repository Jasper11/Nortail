package pageObjects;

import org.openqa.selenium.By;

public class LongPressDemoScreen extends BaseScreen {

    By longPressButton = By.xpath("//android.widget.TextView[@text='Long Press Me']");

    public void longPressButton() {
        longPress(waitForElementVisibility(longPressButton));
    }
}
