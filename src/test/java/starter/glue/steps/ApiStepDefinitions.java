package starter.glue.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import starter.glue.actions.ApiActions;

public class ApiStepDefinitions {

    private static ApiActions apiActions;

    @Given("^the (.*) endpoint is availble$")
    public void thePEGAEndpointIsAvailble(String name) {
        apiActions.restEndpointIsAvailable(name);
    }

    @When("^I hit the endpoint$")
    public void iHitTheEndpoint() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^I should get (\\d+) back$")
    public void iShouldGetBack(int arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
