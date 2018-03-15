package api.TestRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"@rob"},
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "api.steps"
)
public class CucumberTestSuite {


}
