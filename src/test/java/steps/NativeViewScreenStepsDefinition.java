package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.NativeViewDemoScreen;
import pageObjects.SampleListDemoScreen;

public class NativeViewScreenStepsDefinition {
    NativeViewDemoScreen nativeViewDemoScreen = new NativeViewDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Native View view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Native View");
    }

    @Then("I see text {string} displayed")
    public void verifyTextDisplayed(String text) {
        Assert.assertTrue(nativeViewDemoScreen.isElementWithTextDisplayed(text));
    }
}
