

package testRunner;

import cucumber.api.CucumberOptions;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Feature/Login.feature", //location of feature file
        glue = "stepDefinitions", //package name where steps are defined
        dryRun = false,
        monochrome=true,
        plugin = {"pretty",
                "html:test-output",
                 },tags = "@regression"
)

public class TestRunner {

    }


