package steps;

import dataProvider.JsonDataReader;
import enums.Direction;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.CarouselDemoScreen;
import pageObjects.DoubleTapDemoScreen;
import pageObjects.DragNDropDemoScreen;
import pageObjects.LoginDemoScreen;
import pageObjects.LongPressDemoScreen;
import pageObjects.NativeViewDemoScreen;
import pageObjects.SampleListDemoScreen;
import pageObjects.SliderDemoScreen;
import pageObjects.VerticalSwipeDemoScreen;
import pageObjects.WheelPickerDemoScreen;
import testDataTypes.UserCredentials;

import java.io.IOException;

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
