package ui.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import ui.pageobjects.GoogleHome;
import ui.pageobjects.GoogleResults;

public class StepDefinitions {

    GoogleHome googleHome;
    GoogleResults googleResults;


    @Given("^I open Google$")
    public void iOpenGoogle() {
        googleHome.open();
    }

    @When("^I search for \"([^\"]*)\"$")
    public void iSearchFor(String term) {
        googleHome.Search(term);
    }

    @Then("^I should find \"([^\"]*)\"$")
    public void iShouldFind(String pageTitle) {
        Assert.assertTrue(googleResults.isPageInResults(pageTitle));
    }
}
