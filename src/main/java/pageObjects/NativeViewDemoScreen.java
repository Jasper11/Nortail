package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NativeViewDemoScreen extends BaseScreen {

    public boolean textDisplayed(String text) {
        By message = By.xpath("//android.widget.TextView");
        waitForElementVisibility(message);
        List<String> texts = new ArrayList<>();
        List<WebElement> elements = driver.findElements(message);
        for (WebElement element: elements) {
            texts.add(element.getText());
        }
        return texts.contains(text);
    }
}
