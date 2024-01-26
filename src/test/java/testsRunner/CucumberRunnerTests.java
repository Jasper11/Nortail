package testsRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = "src/test/resources/features/E2E.feature", glue = "steps",
    plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}