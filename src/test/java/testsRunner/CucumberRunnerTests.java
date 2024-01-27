package testsRunner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
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
    public static void tearDown() {
        HelperClass.tearDown();
    }
}