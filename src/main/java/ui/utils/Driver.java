package ui.utils;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.nio.file.Path;


public class Driver implements DriverSource {

    String driverDir = System.getProperty("user.dir")
            + File.separator +"src"
            + File.separator +"test"+ File.separator +"resources"
            + File.separator +"drivers" + File.separator ;
    String os = System.getProperty("os.name");
    String browser = ReadProperty.loadPropertyValue("webdriver.browser","application");

    public Driver() {
        System.setProperty("webdriver.edge.driver", constructFilePath("MicrosoftWebDriver"));
        System.setProperty("webdriver.phantomjs.driver", constructFilePath("phantomjs"));
        System.setProperty("webdriver.chrome.driver", constructFilePath("chromedriver"));
        System.setProperty("webdriver.ie.driver", constructFilePath("IEDriverServer"));
    }

    private String constructFilePath(String driverName){
        if (os.contains("Windows")){
            return driverDir + "windows" + File.separator + driverName + ".exe";
        }
        else if (os.contains("OS X")){
            return driverDir + "osx" + File.separator + driverName;
        }
        return null;

    }

    @Override
    public WebDriver newDriver() {

        switch (browser) {
            case "firefox":
                return new FirefoxDriver();

            case "edge":
                return new EdgeDriver();

            case "phantomjs":
                return new PhantomJSDriver();

            case "chrome":
                ChromeOptions options = new ChromeOptions();
                options.addArguments("--disable-extensions");
                options.addArguments("--no-first-run");
                options.addArguments("--headless");
                return new ChromeDriver(options);

            case "ie":
                DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
                capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
                capabilities.setCapability("ignoreProtectedModeSettings", true);
                capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
                capabilities.setCapability("nativeEvents", false);
                capabilities.setCapability("disable-popup-blocking", true);
                capabilities.setCapability("enablePersistentHover", true);
                capabilities.setJavascriptEnabled(true);
                return new InternetExplorerDriver(capabilities);

            default:
                return null;
        }
    }


    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
