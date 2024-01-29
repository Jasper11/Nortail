package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.DoubleTapDemoScreen;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;

public class DoubleTapScreenStepsDefinition {

    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    DoubleTapDemoScreen doubleTapDemoScreen = new DoubleTapDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on DoubleTap view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Double Tap");
    }

    @When("I perform double tap on button")
    public void performDoubleTap() {
        doubleTapDemoScreen.doubleTapButton();
    }

    @Then("I see popUp with message {string} on DoubleTap screen")
    public void verifyPopUpMessageOnDoubleTapScreen(String message) {
        Assert.assertTrue(doubleTapDemoScreen.isPopUpWithTextDisplayed(message));
    }
}
