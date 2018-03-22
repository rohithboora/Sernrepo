package api.TestRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"@api"},
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "api.steps"
)
public class CucumberTestSuite {


}
