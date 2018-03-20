package ui.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import ui.pageobjects.GoogleHome;

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
