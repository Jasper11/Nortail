package steps;

import dataProvider.JsonDataReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pageObjects.LoginDemoScreen;
import pageObjects.SampleListDemoScreen;
import testDataTypes.LoginTestData;

import java.io.IOException;

public class LoginScreenStepsDefinition {

    LoginDemoScreen loginDemoScreen = new LoginDemoScreen();
    SampleListDemoScreen sampleListDemoScreen = new SampleListDemoScreen();

    @Given("User is on login screen")
    public void verifyLoginScreenIsDisplayed() {
        Assert.assertTrue(loginDemoScreen.isLoginScreenDisplayed());
    }

    @When("I perform login with {string}")
    public void performLogin(String testDataSetName) throws IOException {
        LoginTestData loginTestData = new JsonDataReader().getTestDataSetSetByName(testDataSetName);
        loginDemoScreen.login(loginTestData.username, loginTestData.password);
    }

    @Then("I get logged in")
    public void verifyLogin() {
        Assert.assertTrue(sampleListDemoScreen.isSampleListScreenDisplayed());
    }

    @Then("I see popUp with message from {string} on Login screen")
    public void verifyPopUpMessageOnLoginScreen(String testDataSetName) throws IOException {
        LoginTestData loginTestData = new JsonDataReader().getTestDataSetSetByName(testDataSetName);
        Assert.assertTrue(loginDemoScreen.isPopUpWithTextDisplayed(loginTestData.errorMessage));
    }
}
