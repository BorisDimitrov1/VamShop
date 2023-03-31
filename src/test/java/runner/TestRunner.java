package runner;


import courgette.api.CourgetteAfterAll;
import courgette.api.CourgetteOptions;
import courgette.api.CourgetteTestOutput;
import courgette.api.CucumberOptions;
import courgette.api.junit.Courgette;
import org.junit.runner.RunWith;

@RunWith(Courgette.class)
@CourgetteOptions(
        testOutput  = CourgetteTestOutput.CONSOLE,
        reportTargetDir = "target",
        cucumberOptions = @CucumberOptions(
                features = "src/test/resources/features",
                glue = "step_definitions, hooks",
                plugin = {
                        "pretty",
                        "json:target/cucumber-report/cucumber.json",
                        "html:target/cucumber-report/cucumber.html",
                        "junit:target/cucumber-report/cucumber.xml"}
        ))

public class TestRunner {

    // This will be executed after all tests. Can be used to clean up data
    @CourgetteAfterAll
    public static void tearDown() {

    }



}
