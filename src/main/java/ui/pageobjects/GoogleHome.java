package ui.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.google.com")
public class GoogleHome extends PageObject {

    public void Search() {


    }

    public Object verifyresults() {

        return this;

    }
}
