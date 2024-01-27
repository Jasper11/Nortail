package pageObjects;

import org.openqa.selenium.By;

public class WheelPickerDemoScreen extends BaseScreen {

    By picker = By.id("android:id/text1");

    public boolean messageWithTextDisplayed(String text) {
        By resultText = By.xpath(String.format("//android.widget.TextView[@text=' %s ']", text));
        return waitForElementVisibility(resultText).isDisplayed();
    }

    public void selectPickerItemWithText(String item){
        By pickerItemLocator = By.xpath(String.format("//android.widget.CheckedTextView[@text='%s']", item));
        waitForElementVisibility(picker).click();
        waitForElementVisibility(pickerItemLocator).click();
    }
}
