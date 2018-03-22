package ui.pageobjects;

import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.google.com")
public class GoogleHome extends PageObject {

    @FindBy(id="lst-ib")
    WebElement searchBox;

    public void Search(String term) {
        searchBox.sendKeys(term+ Keys.RETURN);
    }

}
