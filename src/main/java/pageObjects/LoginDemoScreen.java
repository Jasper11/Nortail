package pageObjects;

import org.openqa.selenium.By;

public class LoginDemoScreen extends BaseScreen {

    By userNameField = By.xpath("//android.widget.EditText[@content-desc='username']");
    By passwordField = By.xpath("//android.widget.EditText[@content-desc='password']");
    By loginButton = By.xpath("//android.widget.Button");

    public boolean isLoginScreenDisplayed() {
        return waitForElementVisibility(loginButton).isDisplayed();
    }

    public void login(String strUserName, String strPassword) {
        waitForElementVisibility(userNameField).sendKeys(strUserName);
        waitForElementVisibility(passwordField).sendKeys(strPassword);
        waitForElementVisibility(loginButton).click();
    }

    public void login() {
        waitForElementVisibility(loginButton).click();
    }
}
