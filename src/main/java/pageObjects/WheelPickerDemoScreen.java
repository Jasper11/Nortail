package pageObjects;

import org.openqa.selenium.By;

public class WheelPickerDemoScreen extends BaseScreen {

    By picker = By.id("android:id/text1");

    public void selectPickerItemWithText(String item) {
        By pickerItemLocator = By.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", item));
        waitForElementVisibility(picker).click();
        waitForElementVisibility(pickerItemLocator).click();
    }
}
