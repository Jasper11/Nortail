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

public class Steps {

    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();
    NativeViewDemoScreen nativeViewDemoScreen = new NativeViewDemoScreen();
    DoubleTapDemoScreen doubleTapDemoScreen = new DoubleTapDemoScreen();
    LongPressDemoScreen longPressDemoScreen = new LongPressDemoScreen();
    DragNDropDemoScreen dragNDropDemoScreen = new DragNDropDemoScreen();
    CarouselDemoScreen carouselDemoScreen = new CarouselDemoScreen();
    WheelPickerDemoScreen wheelPickerDemoScreen = new WheelPickerDemoScreen();
    SliderDemoScreen sliderDemoScreen = new SliderDemoScreen();
    VerticalSwipeDemoScreen verticalSwipeDemoScreen = new VerticalSwipeDemoScreen();

    /// Login steps
    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginDemoScreen.isLoginScreenDisplayed());
    }

    @When("User perform login with {string}")
    public void performLogin(String credentialsSetName) throws IOException {
        UserCredentials credentials = new JsonDataReader().getCredentialsSetByName(credentialsSetName);
        loginDemoScreen.login(credentials.username, credentials.password);
    }

    @Then("User is logged successfully and Sample List screen is opened")
    public void verifyLogin() {
        Assert.assertTrue(sampleListDemoScreen.isSampleListScreenDisplayed());
    }

    /// Sample list steps
    @Given("User is on sample list screen")
    public void proceedToSampleListScreen() {
        loginDemoScreen.login();
    }

    @When("User navigates to {string} view")
    public void navigateToView(String view) {
        sampleListDemoScreen.navigateTo(view);
    }

    /// Native View steps
    @Then("Text {string} is present")
    public void verifyTextDisplayed(String text) {
        Assert.assertTrue(nativeViewDemoScreen.isTextDisplayed(text));
    }

    /// Vertical swipe steps
    @Then("Observes {string} text on vertical swipe view")
    public void isTextDisplayed(String text) {
        Assert.assertTrue(verticalSwipeDemoScreen.isTextDisplayed(text));
    }

    /// Double tap screen steps
    @When("Perform double tap on button")
    public void performDoubleTap() {
        doubleTapDemoScreen.doubleTapButton();
    }

    /// Long press screen steps
    @When("Perform long press on button")
    public void performLongPress() {
        longPressDemoScreen.longPressButton();
    }

    /// Drag n Drop  screen steps
    @When("drag n drop circle")
    public void makeDragNDrop() {
        dragNDropDemoScreen.dragNDropCircle();
    }

    @Then("User observe drag & drop success message")
    public void verifyDragNDropSuccessMessage() {
        Assert.assertTrue(dragNDropDemoScreen.successMessageIsDisplayed());
    }

    /// Swipe  screen steps
    @When("User swipe left")
    public void swipeLeft() {
        carouselDemoScreen.performSwipe(Direction.LEFT);
    }

    @When("User swipe right")
    public void swipeRight() {
        carouselDemoScreen.performSwipe(Direction.RIGHT);
    }

    @Then("User observe text {string} on Square")
    public void verifyText(String text) {
        Assert.assertTrue(carouselDemoScreen.isTextDisplayed(text));
    }

    /// Dropdown Picker steps
    @When("Select in picker item with {string} text")
    public void selectPickerItem(String text) {
        wheelPickerDemoScreen.selectPickerItemWithText(text);
    }

    @Then("User sees message with {string} text")
    public void verifyPickerSelectedItemText(String text) {
        Assert.assertTrue(wheelPickerDemoScreen.isTextDisplayed(text));
    }

    /// Slider steps
    @When("Set slider value with {double} percentage")
    public void setSliderValueInPercentage(Double percentage) {
        sliderDemoScreen.setSliderValue(percentage);
    }

    @Then("Slider is set with {string} value")
    public void verifySliderValue(String text) {
        Assert.assertTrue(sliderDemoScreen.isSliderSetWithValue(text));
    }

    /// Common steps
    @Then("User observe popUp with message {string}")
    public void verifyPopUpMessage(String message) {
        Assert.assertTrue(loginDemoScreen.isPopUpWithTextDisplayed(message));
    }
}
