package steps;

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
