package testsRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "", features = {"src/test/resources/features/Login.feature", "src/test/resources/features/Views.feature"}, glue = "steps",
    plugin = {})

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}