package starter.glue.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import org.junit.Assert;
import starter.glue.actions.ApiActions;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ApiStepDefinitions {

    @Steps
    private static ApiActions apiActions;

    @Given("^the (.*) endpoint is availble$")
    public void thePEGAEndpointIsAvailble(String name) {
        apiActions.restEndpointIsAvailable(name);
    }

    @When("^I hit the endpoint$")
    public void iHitTheEndpoint()  {
        apiActions.hitEndpoint();
    }

    @Then("^I should get (\\d+) back$")
    public void iShouldGetBack(int arg0) {
        assertThat(apiActions.getResponseBody(),apiActions.getResponseStatusCode(),is(arg0));

    }
}
