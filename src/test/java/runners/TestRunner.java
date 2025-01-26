package runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        // Path to feature files
        features = "src/test/resources/features",

        // Path to step definitions
        glue = "steps",

        // If true, checks if all steps are defined without running tests
        dryRun = false,

        // Specify which tests to run using tags
        tags = "@login or @addEmployee",

        // Reporting configurations
        plugin = {
                "pretty",                                               // Console output
                "html:target/cucumber-reports/cucumber.html",          // HTML report
                "json:target/cucumber-reports/cucumber.json"           // JSON report for other tools
        }
)
public class TestRunner {
        // This class remains empty
        // Used only to run tests with configuration from annotations
}