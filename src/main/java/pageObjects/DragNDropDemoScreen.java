package pageObjects;

import org.openqa.selenium.By;

public class DragNDropDemoScreen extends BaseScreen {

    By elementToDrop = By.xpath("//android.widget.TextView[@text='Drop here.']");
    By elementToDrag = By.xpath("//android.widget.TextView[@text='Drag me!']");
    By successMessage = By.xpath("//android.widget.TextView[@text='Circle dropped']");

    public void dragNDropCircle() {
        dragNDrop(waitForElementVisibility(elementToDrag), waitForElementVisibility(elementToDrop));
    }

    public boolean successMessageIsDisplayed() {
        return waitForElementVisibility(successMessage).isDisplayed();
    }
}
