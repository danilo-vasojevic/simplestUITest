import Tests.TestCase1;

import java.net.MalformedURLException;

public class RunnerClass {
    private static final String REMOTE_DRIVER_URL = "http://localhost:4444/wd/hub";

    public static void main(String[] args) throws MalformedURLException {
        new TestCase1(WebDriverProvider.initRemoteDriver(REMOTE_DRIVER_URL, Browsers.CHROME, "69.0")).start();
        new TestCase1(WebDriverProvider.initRemoteDriver(REMOTE_DRIVER_URL, Browsers.FIREFOX, "62.0")).start();
        new TestCase1(WebDriverProvider.initRemoteDriver(REMOTE_DRIVER_URL, Browsers.CHROME, "68.0")).start();
        new TestCase1(WebDriverProvider.initRemoteDriver(REMOTE_DRIVER_URL, Browsers.FIREFOX, "61.0")).start();
    }
}