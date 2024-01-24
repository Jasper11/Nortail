package definitions;

import pageObjects.SampleListScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginScreen;
import org.testng.Assert;

public class LoginPageDefinitions {

    LoginScreen loginScreen = new LoginScreen();
    SampleListScreen sampleListScreen = new SampleListScreen();

    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed());
    }

    @When("User enters username as {string} and password as {string}")
    public void doLogin(String userName, String passWord) {
        loginScreen.login(userName, passWord);
    }

    @Then("User is logged successfully and Sample List screen is opened")
    public void verifyLogin() throws InterruptedException {
        Assert.assertTrue(sampleListScreen.isSampleListScreenDisplayed());
    }

    @Then("User sees error message as {string}")
    public void verifyErrorMessage(String errorText) {
        Assert.assertTrue(loginScreen.isPopUpWithTextDisplayed(errorText));
    }

    @Then("User sees error message <errorText>")
    public void userSeesErrorMessageErrorText() {
    }
//
//    @Then("User should be able to see a message {string} below Username")
//    public void verifyMissingUsernameMessage(String message) {
//
//        Assert.assertEquals(loginScreen.getMissingUsernameText(),message);
//    }
}
