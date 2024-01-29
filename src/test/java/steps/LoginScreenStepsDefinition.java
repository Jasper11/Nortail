package steps;

import dataProvider.JsonDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;
import testDataTypes.UserCredentials;

import java.io.IOException;

public class LoginScreenStepsDefinition {

    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginDemoScreen.isLoginScreenDisplayed());
    }

    @When("I perform login with {string}")
    public void performLogin(String credentialsSetName) throws IOException {
        UserCredentials credentials = new JsonDataReader().getCredentialsSetByName(credentialsSetName);
        loginDemoScreen.login(credentials.username, credentials.password);
    }

    @Then("I get logged in")
    public void verifyLogin() {
        Assert.assertTrue(sampleListDemoScreen.isSampleListScreenDisplayed());
    }

    @Then("I see popUp with message {string} on Login screen")
    public void verifyPopUpMessageOnLoginScreen(String message) {
        Assert.assertTrue(loginDemoScreen.isPopUpWithTextDisplayed(message));
    }
}
