package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.LongPressDemoScreen;
import pageObjects.SampleListDemoScreen;

public class LongPressScreenStepsDefinition {

    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();
    LongPressDemoScreen longPressDemoScreen = new LongPressDemoScreen();


    @Given("User is on Long Press view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Long Press");
    }

    @When("I perform long press on button")
    public void performLongPress() {
        longPressDemoScreen.longPressButton();
    }

    @Then("I see popUp with message {string} on LongPress screen")
    public void verifyPopUpMessageOnLongPressScreen(String message) {
        Assert.assertTrue(longPressDemoScreen.isPopUpWithTextDisplayed(message));
    }
}
