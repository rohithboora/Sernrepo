package starter.glue.actions;

import net.thucydides.core.annotations.Step;
import org.junit.Assert;


public class ApiActions {

    @Step
    public static void restEndpointIsAvailable(String name){
        String locator = name.toLowerCase().replace(' ','.')+".endpoint";
    }
}
