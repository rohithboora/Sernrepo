package ui.utils;

import net.thucydides.core.webdriver.DriverSource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;



public class Driver implements DriverSource {

    String UserDir = System.getProperty("user.dir");
    String browser = ReadProperty.loadPropertyValue("webdriver.browser","application");
    DesiredCapabilities capabilities = new DesiredCapabilities();


    @Override
    public WebDriver newDriver() {

        if(browser.equals("firefox")){
            return new FirefoxDriver();
        }else if(browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
            //DesiredCapabilities capabilities = DesiredCapabilities.chrome();

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-extensions");
            options.addArguments("--no-first-run");
            options.addArguments("--homepage=about:blank");
            options.addArguments("--test-type");
            //options.setBinary("/path/to/other/chrome/binary");

            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_ALERTS, true);
            capabilities.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
            capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, true);
            capabilities.setCapability(CapabilityType.SUPPORTS_NETWORK_CONNECTION, true);
            capabilities.setCapability(ChromeOptions.CAPABILITY,options);
            capabilities.setCapability("chrome.binary",UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
            return new ChromeDriver(capabilities);
        }else if(browser.equals("ie")) {
            System.setProperty("webdriver.ie.driver", UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"IEDriverServer.exe");
            capabilities.setCapability("webdriver.ie.driver",UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"chromedriver.exe");
            capabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, "accept");
            capabilities.setCapability("ignoreProtectedModeSettings", true);
            //IEcapabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setJavascriptEnabled(true);
            //IEcapabilities.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
            capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
            capabilities.setCapability("nativeEvents", false);
            //IEcapabilities.setCapability("unexpectedAlertBehaviour", "accept");
            capabilities.setCapability("disable-popup-blocking", true);
            capabilities.setCapability("enablePersistentHover", true);
            capabilities.setCapability("requireWindowFocus", true);
            //IEcapabilities.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, UnexpectedAlertBehaviour.IGNORE);
            capabilities.setJavascriptEnabled(true);
            return new InternetExplorerDriver(capabilities);
        }else if(browser.equals("edge")) {
            System.setProperty("webdriver.edge.driver", UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"MicrosoftWebDriver.exe");
            return new EdgeDriver();
        }else if(browser.equals("phantomjs")) {
            //DesiredCapabilities phantomjscapabilities = DesiredCapabilities.phantomjs();
            System.setProperty("webdriver.phantomjs.driver", UserDir+ File.separator +"src"+ File.separator +"test"+ File.separator +"resources"+ File.separator +"drivers"+ File.separator +"phantomjs.exe");
            return new PhantomJSDriver();
        }else {
            System.out.println("non existing browser");
        }
        return null;
    }

    @Override
    public boolean takesScreenshots() {
        return true;
    }
}
