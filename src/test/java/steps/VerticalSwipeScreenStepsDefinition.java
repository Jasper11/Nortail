package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;
import pageObjects.VerticalSwipeDemoScreen;

public class VerticalSwipeScreenStepsDefinition {
    VerticalSwipeDemoScreen verticalSwipeDemoScreen = new VerticalSwipeDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Vertical swiping view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Vertical swiping");
    }

    @Then("I see {string} text")
    public void isTextDisplayed(String text) {
        Assert.assertTrue(verticalSwipeDemoScreen.isElementWithTextDisplayed(text));
    }
}
