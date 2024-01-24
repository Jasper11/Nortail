package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.HelperClass;

public class LoginScreen extends BaseScreen{

    @FindBy(xpath = "//android.widget.EditText[@content-desc='username']")
    public WebElement userNameField;

    @FindBy(xpath = "//android.widget.EditText[@content-desc='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//android.widget.Button")
    public WebElement loginButton;

    public LoginScreen() {

        PageFactory.initElements(HelperClass.getDriver(), this);
    }

    public boolean isLoginScreenDisplayed() {
        return loginButton.isDisplayed();
    }

    public void login(String strUserName, String strPassword) {
        userNameField.sendKeys(strUserName);
        passwordField.sendKeys(strPassword);
        loginButton.click();
    }
}
