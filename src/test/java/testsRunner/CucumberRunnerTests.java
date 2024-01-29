package testsRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import utils.HelperClass;

import java.net.MalformedURLException;

@CucumberOptions(tags = "", features = "src/test/resources/features", glue = "steps",
    plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
    @BeforeTest(alwaysRun = true)
    public static void setUp() throws MalformedURLException {
        HelperClass.setUpDriver();
    }

    @AfterTest(alwaysRun = true)
    public static void tearDown() {
        HelperClass.tearDown();
    }
}