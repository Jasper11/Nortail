package steps;

import dataProvider.JsonDataReader;
import pageObjects.DoubleTapDemoScreen;
import pageObjects.DragNDropDemoScreen;
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
    DragNDropDemoScreen dragNDropDemoScreen = new DragNDropDemoScreen();

    /// Login screen steps
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

    /// Sample list screen steps
    @When("User navigates to {string} view")
    public void navigateToView(String view) {
        sampleListScreen.navigateTo(view);
    }

    @Then("User is logged successfully and Sample List screen is opened")
    public void verifyLogin() {
        Assert.assertTrue(sampleListScreen.isSampleListScreenDisplayed());
    }

    /// Double tap screen steps
    @When("User make double tap on button")
    public void makeDoubleTap() {
        doubleTapDemoScreen.doubleTapButton();
    }

    /// Long press screen steps
    @When("User make long press on button")
    public void makeLongPress() {
        longPressDemoScreen.longPressButton();
    }

    /// Drag n Drop  screen steps
    @When("User drag n drop circle")
    public void makeDragNDrop() {
        dragNDropDemoScreen.dragNDropCircle();
    }

    @Then("User sees success message")
    public void verifySuccessMessage() {
        Assert.assertTrue(dragNDropDemoScreen.successMessageIsDisplayed());
    }

    /// Common steps
    @Then("User sees message as {string}")
    public void verifyErrorMessage(String errorText) {
        Assert.assertTrue(loginScreen.isPopUpWithTextDisplayed(errorText));
    }
}
