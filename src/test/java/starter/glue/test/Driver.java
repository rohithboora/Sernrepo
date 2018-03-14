package starter.glue.test;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Driver implements DriverSource {

    @Override
    public WebDriver newDriver() {
        return new FirefoxDriver();
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
