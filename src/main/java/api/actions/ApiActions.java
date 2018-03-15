package api.actions;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import api.utils.Configuration;


public class ApiActions {


    @Step
    public static int getResponseStatusCode(){
        return SerenityRest.then().extract().statusCode();
    }

    @Step
    public static String getResponseBody(){
        return SerenityRest.then().extract().response().asString();
    }

    public static String endpointRoot = null;

    @Step
    public static void restEndpointIsAvailable(String name){
        String locator = name.toLowerCase().replace(' ','.')+".endpoint";
        System.out.println(locator);

      //  URL endpoint = URL
        endpointRoot= Configuration.get(locator);
        Assert.assertNotNull(endpointRoot);
        System.out.println(endpointRoot);

    }

    @Step
    public void hitEndpoint() {
        SerenityRest.
                given()
                .log().all()
                .when()
                .get(endpointRoot);
    }



}
