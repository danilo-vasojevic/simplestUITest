import Tests.GoogleSearch;

import java.net.MalformedURLException;

import static org.openqa.selenium.remote.BrowserType.*;

public class RunnerClass {
    private static final String remoteURL = "http://localhost:4444/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        new GoogleSearch(WebDriverProvider.initRemoteDriver(remoteURL, CHROME, "69.0")).start();
        new GoogleSearch(WebDriverProvider.initRemoteDriver(remoteURL, FIREFOX, "62.0")).start();
        new GoogleSearch(WebDriverProvider.initRemoteDriver(remoteURL, CHROME, "68.0")).start();
        new GoogleSearch(WebDriverProvider.initRemoteDriver(remoteURL, FIREFOX, "61.0")).start();
    }
}