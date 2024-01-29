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

public class DragNDropScreenStepsDefinition {

    DragNDropDemoScreen dragNDropDemoScreen = new DragNDropDemoScreen();
    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on Drag & Drop view")
    public void proceedToTestView() {
        loginDemoScreen.login();
        sampleListDemoScreen.navigateTo("Drag & Drop");
    }

    @When("I drag n drop circle")
    public void performDragNDrop() {
        dragNDropDemoScreen.dragNDropCircle();
    }

    @Then("I see drag & drop success message")
    public void verifyDragNDropSuccessMessage() {
        Assert.assertTrue(dragNDropDemoScreen.successMessageIsDisplayed());
    }
}
