package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;
import pageObjects.WheelPickerDemoScreen;

public class PickerStepsDefinition {

    WheelPickerDemoScreen wheelPickerDemoScreen = new WheelPickerDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Wheel Picker view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Wheel Picker");
    }

    @When("I select picker item with {string} text")
    public void selectPickerItem(String text) {
        wheelPickerDemoScreen.selectPickerItemWithText(text);
    }

    @Then("I see message with {string} text")
    public void verifyPickerSelectedItemText(String text) {
        Assert.assertTrue(wheelPickerDemoScreen.isElementWithTextDisplayed(text));
    }
}
