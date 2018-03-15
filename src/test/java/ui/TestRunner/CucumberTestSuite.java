package ui.TestRunner;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        tags = {"@jack"},
        plugin = {"pretty"},
        features = "src/test/resources/features",
        glue = "ui.steps"
)
public class CucumberTestSuite {


}
