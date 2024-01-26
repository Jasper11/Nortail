package pageObjects;

import org.openqa.selenium.By;

public class DoubleTapDemoScreen extends BaseScreen {

    By doubleTapButton = By.xpath("//android.widget.TextView[@text='Double Tap Me']");

    public void doubleTapButton() {
        doubleTap(waitForElementVisibility(doubleTapButton));
    }
}
