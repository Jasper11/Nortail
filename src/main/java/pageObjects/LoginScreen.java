package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class LoginScreen extends BaseScreen{

    By userNameField = By.xpath("//android.widget.EditText[@content-desc='username']");
    By passwordField = By.xpath("//android.widget.EditText[@content-desc='password']");
    By loginButton = By.xpath("//android.widget.Button");

    public LoginScreen() {

        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public boolean isLoginScreenDisplayed() {
        return waitForElementVisibility(loginButton).isDisplayed();
    }

    public void login(String strUserName, String strPassword) {
        waitForElementVisibility(userNameField).sendKeys(strUserName);
        waitForElementVisibility(passwordField).sendKeys(strPassword);
        waitForElementVisibility(loginButton).click();
    }
}
