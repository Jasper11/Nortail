package pageObjects;

import org.openqa.selenium.By;

public class SampleListScreen extends BaseScreen {

    By screenHeader = By.xpath("//android.widget.TextView[@text='Samples List']");

    public boolean isSampleListScreenDisplayed() {
        return waitForElementVisibility(screenHeader).isDisplayed();
    }

    public void navigateTo(String viewItem) {
        waitForElementVisibility(By.xpath(String.format("//android.widget.TextView[@text='%s']", viewItem))).click();
    }
}
