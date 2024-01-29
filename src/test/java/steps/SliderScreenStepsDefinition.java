package steps;

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

public class SliderScreenStepsDefinition {

    SliderDemoScreen sliderDemoScreen = new SliderDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Slider view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Slider");
    }

    @When("I set slider value with {double} percentage")
    public void setSliderValueInPercentage(Double percentage) {
        sliderDemoScreen.setSliderValue(percentage);
    }

    @Then("Slider is set with {string} value")
    public void verifySliderValue(String text) {
        Assert.assertTrue(sliderDemoScreen.isSliderSetWithValue(text));
    }

}
