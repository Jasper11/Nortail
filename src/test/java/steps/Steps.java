package steps;

import dataProvider.JsonDataReader;
import pageObjects.DoubleTapDemoScreen;
import pageObjects.LongPressDemoScreen;
import pageObjects.SampleListScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginScreen;
import org.testng.Assert;
import testDataTypes.UserCredentials;

import java.io.IOException;

public class Steps {

    LoginScreen loginScreen = new LoginScreen();
    SampleListScreen sampleListScreen = new SampleListScreen();
    DoubleTapDemoScreen doubleTapDemoScreen = new DoubleTapDemoScreen();
    LongPressDemoScreen longPressDemoScreen = new LongPressDemoScreen();

    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginScreen.isLoginScreenDisplayed());
    }

    @Given("User is on sample list screen")
    public void proceedToSampleListScreen() {
        loginScreen.login();
    }

    @When("User enters {string}")
    public void performLogin(String credentialsSetName) throws IOException {
        UserCredentials credentials = new JsonDataReader().getCredentialsSetByName(credentialsSetName);
        loginScreen.login(credentials.username, credentials.password);
    }

    @When("User navigates to {string} view")
    public void navigateToView(String view) {
        sampleListScreen.navigateTo(view);
    }

    @When("User make double tap on button")
    public void makeDoubleTap() {
        doubleTapDemoScreen.doubleTapButton();
    }

    @When("User make long press on button")
    public void makeLongPress() {
        longPressDemoScreen.longPressButton();
    }

    @Then("User is logged successfully and Sample List screen is opened")
    public void verifyLogin() {
        Assert.assertTrue(sampleListScreen.isSampleListScreenDisplayed());
    }

    @Then("User sees message as {string}")
    public void verifyErrorMessage(String errorText) {
        Assert.assertTrue(loginScreen.isPopUpWithTextDisplayed(errorText));
    }
}
