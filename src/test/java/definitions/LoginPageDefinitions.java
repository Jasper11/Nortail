package definitions;

import dataProvider.JsonDataReader;
import pageObjects.SampleListScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginScreen;
import org.testng.Assert;
import testDataTypes.UserCredentials;

import java.io.IOException;

public class LoginPageDefinitions {

    LoginScreen loginScreen = new LoginScreen();
    SampleListScreen sampleListScreen = new SampleListScreen();

    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed());
    }

    @When("User enters {string}")
    public void doLogin(String credentialsSetName) throws IOException {
        UserCredentials credentials = new JsonDataReader().getCredentialsSetByName(credentialsSetName);
        loginScreen.login(credentials.username, credentials.password);
    }

    @Then("User is logged successfully and Sample List screen is opened")
    public void verifyLogin() throws InterruptedException {
        Assert.assertTrue(sampleListScreen.isSampleListScreenDisplayed());
    }

    @Then("User sees error message as {string}")
    public void verifyErrorMessage(String errorText) {
        Assert.assertTrue(loginScreen.isPopUpWithTextDisplayed(errorText));
    }
}
