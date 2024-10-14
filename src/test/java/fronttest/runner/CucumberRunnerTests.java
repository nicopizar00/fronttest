package fronttest.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags = "",
        features = "src/test/resources/features/Purchase.feature",
        glue = "fronttest.definitions",
        plugin = {})
public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}
