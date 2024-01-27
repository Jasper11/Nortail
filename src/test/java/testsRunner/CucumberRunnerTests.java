package testsRunner;


import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.HelperClass;

@CucumberOptions(tags = "", features = "src/test/resources/features", glue = "steps",
    plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @BeforeTest(alwaysRun = true)
    public static void setUp() {
        HelperClass.setUpDriver();
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown(Scenario scenario) {

        //validate if scenario has failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) HelperClass.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        HelperClass.tearDown();
    }
}