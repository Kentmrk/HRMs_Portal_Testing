package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Features location
        features = "src/test/resources/features/",

        // Step definitions location
        glue = "steps",

        // What to execute
        tags = "@login or @addEmployee",

        // Readable console output
        monochrome = false,

        // Report generation
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty.html",
                "json:target/cucumber-reports/cucumber.json"
        },

        // Will check if any step is not defined in step definition
        dryRun = false
)

public class TestRunner {
        // This class should be empty
        // It's just a runner
}