package starter.glue.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.google.com")
public class GoogleHome extends PageObject {

    @Step
    public void Search() {


    }

    public Object verifyresults() {

        return this;

    }
}
