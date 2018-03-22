package ui.pageobjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class GoogleResults extends GoogleHome {

    //WebDriver driver;
    @FindBy(css=".rc h3.r")
    List<WebElement> elementresults;

    public boolean isPageInResults(String pageTitle) {
        List<String> results = new ArrayList<>();
        for (WebElement e : elementresults){

            System.out.println(e.getText());

            if (results.add(e.getText()))
                Assert.assertTrue(results.contains(pageTitle));
                return true;
        }

        return false;
    }
}
