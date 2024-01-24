package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class SampleListScreen {

    @FindBy(xpath = "//android.widget.TextView[@text='Samples List']")
    public WebElement screenHeader;

    public SampleListScreen() {

        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public boolean isSampleListScreenDisplayed() throws InterruptedException {
        Thread.sleep(5000);
        return screenHeader.isDisplayed();
    }
}
