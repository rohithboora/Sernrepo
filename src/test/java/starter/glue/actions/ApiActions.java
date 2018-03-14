package starter.glue.actions;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;
import starter.glue.test.Configuration;

import java.net.URL;
import java.util.Properties;


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
