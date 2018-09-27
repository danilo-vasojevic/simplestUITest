import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

import static org.openqa.selenium.remote.BrowserType.CHROME;
import static org.openqa.selenium.remote.BrowserType.FIREFOX;

public class WebDriverProvider {
    private static final String remoteURL = "http://localhost:4444/wd/hub";

    public static RemoteWebDriver initRemoteDriver(String browser, String version) throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return new RemoteWebDriver(URI.create(remoteURL).toURL(), capabilities);
    }

    public static RemoteWebDriver initChrome69() throws MalformedURLException {
        return new RemoteWebDriver(URI.create(remoteURL).toURL(), setDesiredCapabilities(CHROME, "69.0"));
    }

    public static RemoteWebDriver initChrome68() throws MalformedURLException {
        return new RemoteWebDriver(URI.create(remoteURL).toURL(), setDesiredCapabilities(CHROME, "68.0"));
    }

    public static RemoteWebDriver initFirefox62() throws MalformedURLException {
        return new RemoteWebDriver(URI.create(remoteURL).toURL(), setDesiredCapabilities(FIREFOX, "62.0"));
    }

    public static RemoteWebDriver initFirefox61() throws MalformedURLException {
        return new RemoteWebDriver(URI.create(remoteURL).toURL(), setDesiredCapabilities(FIREFOX, "61.0"));
    }

    private static DesiredCapabilities setDesiredCapabilities(String browser, String version) {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        return capabilities;
    }
}