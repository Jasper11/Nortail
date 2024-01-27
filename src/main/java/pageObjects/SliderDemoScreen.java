package pageObjects;

import org.openqa.selenium.By;

public class SliderDemoScreen extends BaseScreen {

    By slider = By.xpath("//android.widget.SeekBar");

    public boolean isSliderSetWithValue(String value) {
        By locator = By.xpath(String.format("//android.widget.SeekBar[@text='%s']", value));
        return waitForElementVisibility(locator).isDisplayed();
    }

    public void setSliderValue(Double percentage) {
        swipeElementForItsWidthPercentage(waitForElementVisibility(slider), percentage);
    }
}
