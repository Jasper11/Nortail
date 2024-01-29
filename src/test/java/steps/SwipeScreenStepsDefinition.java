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

public class SwipeScreenStepsDefinition {

    CarouselDemoScreen carouselDemoScreen = new CarouselDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Carousel view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Carousel");
    }

    @When("I swipe left")
    public void swipeLeft() {
        carouselDemoScreen.performSwipe(Direction.LEFT);
    }

    @When("I swipe right")
    public void swipeRight() {
        carouselDemoScreen.performSwipe(Direction.RIGHT);
    }

    @Then("I see text {string} on Square")
    public void verifyText(String text) {
        Assert.assertTrue(carouselDemoScreen.isElementWithTextDisplayed(text));
    }
}
