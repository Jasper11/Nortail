package steps;

import dataProvider.JsonDataReader;
import pageObjects.CarouselDemoScreen;
import pageObjects.DoubleTapDemoScreen;
import pageObjects.DragNDropDemoScreen;
import pageObjects.LongPressDemoScreen;
import pageObjects.NativeViewDemoScreen;
import pageObjects.SampleListDemoScreen;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginDemoScreen;
import org.testng.Assert;
import pageObjects.SliderDemoScreen;
import pageObjects.VerticalSwipeDemoScreen;
import pageObjects.WheelPickerDemoScreen;
import testDataTypes.UserCredentials;
import enums.Direction;

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
    @Then("User sees text {string} on native view")
    public void verifyTextDisplayed(String text) {
        Assert.assertTrue(nativeViewDemoScreen.textDisplayed(text));
    }

    /// Vertical swipe steps
    @Then("User sees {string} text on vertical swipe view")
    public void isTextDisplayed(String text) {
        Assert.assertTrue(verticalSwipeDemoScreen.checkIsTextDisplayed(text));
    }

    /// Double tap screen steps
    @When("User make double tap on button")
    public void makeDoubleTap() {
        doubleTapDemoScreen.doubleTapButton();
    }

    /// Long press screen steps
    @When("User make long press on button")
    public void makeLongPress() {
        longPressDemoScreen.longPressButton();
    }

    /// Drag n Drop  screen steps
    @When("User drag n drop circle")
    public void makeDragNDrop() {
        dragNDropDemoScreen.dragNDropCircle();
    }

    @Then("User sees success message")
    public void verifySuccessMessage() {
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

    @Then("User sees text {string}")
    public void verifyTextChanged(String text) {
        Assert.assertTrue(carouselDemoScreen.messageWithTextDisplayed(text));
    }

    /// Dropdown Picker steps
    @When("User selects in picker item with {string} text")
    public void selectPickerItem(String text) {
        wheelPickerDemoScreen.selectPickerItemWithText(text);
    }

    @Then("User sees message with {string} text")
    public void verifyPickerSelectedItemText(String text) {
        Assert.assertTrue(wheelPickerDemoScreen.messageWithTextDisplayed(text));
    }

    /// Slider steps
    @When("User sets slider value with {double} percentage")
    public void setSliderValueInPercentage(Double percentage) {
        sliderDemoScreen.setSliderValue(percentage);
    }

    @Then("slider is set with {string} value")
    public void verifySliderValue(String text) {
        Assert.assertTrue(sliderDemoScreen.isSliderSetWithValue(text));
    }

    /// Common steps
    @Then("User sees message as {string}")
    public void verifyErrorMessage(String errorText) {
        Assert.assertTrue(loginDemoScreen.isPopUpWithTextDisplayed(errorText));
    }
}
