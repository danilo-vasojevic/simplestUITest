import org.openqa.selenium.opera.OperaOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URI;

public class WebDriverProvider {
    public static RemoteWebDriver initRemoteDriver(String url, Browsers browser, String version)
            throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser.toString());
        capabilities.setVersion(version);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);
        if (browser == Browsers.OPERA) {
            OperaOptions options = new OperaOptions();
            options.setBinary("/usr/bin/opera");
            capabilities.setCapability(OperaOptions.CAPABILITY, options);
        }

        return new RemoteWebDriver(URI.create(url).toURL(), capabilities);
    }
}
