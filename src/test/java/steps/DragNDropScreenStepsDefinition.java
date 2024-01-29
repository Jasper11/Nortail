package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.DragNDropDemoScreen;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;

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
