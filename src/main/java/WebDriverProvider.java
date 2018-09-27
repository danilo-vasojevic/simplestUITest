import org.openqa.selenium.remote.*;

import java.net.MalformedURLException;
import java.net.URI;

public class WebDriverProvider {
    public static RemoteWebDriver initRemoteDriver(String url, String browser, String version)
            throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setBrowserName(browser);
        capabilities.setVersion(version);
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", false);

        return new RemoteWebDriver(URI.create(url).toURL(), capabilities);
    }
}
