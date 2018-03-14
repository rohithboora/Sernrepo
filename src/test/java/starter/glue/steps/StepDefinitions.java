package starter.glue.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.openqa.selenium.WebDriver;
import starter.glue.pageobjects.GoogleHome;

import static net.bytebuddy.matcher.ElementMatchers.is;
import static org.assertj.core.api.Java6Assertions.assertThat;

public class StepDefinitions {

    GoogleHome googleHome;


    @Given("^I open Google$")
    public void iOpenGoogle() {
        googleHome.open();
    }

    @When("^I search for testing$")
    public void iSearchForTesting() throws Throwable {
        googleHome.Search();
    }

    @Then("^I should find the results Bob$")
    public void iShouldFindTheResultsBob() {
    }

}
