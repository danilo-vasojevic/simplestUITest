import Tests.GoogleSearch;

import java.net.MalformedURLException;

public class RunnerClass {

    public static void main(String[] args) {
        try {
            new GoogleSearch(WebDriverProvider.initChrome69()).start();
            new GoogleSearch(WebDriverProvider.initFirefox62()).start();
            new GoogleSearch(WebDriverProvider.initChrome68()).start();
            new GoogleSearch(WebDriverProvider.initFirefox61()).start();
        } catch (MalformedURLException ignored) {
        }
    }
}