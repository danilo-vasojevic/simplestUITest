package Tests;

import Tests.TestSteps.TestSteps;
import org.openqa.selenium.remote.RemoteWebDriver;

import static Tests.UtilMethods.log;

public class GoogleSearch implements Runnable {
    private RemoteWebDriver driver;
    private String name;
    private Thread myLittleThread;

    private TestSteps testSteps;

    public GoogleSearch(RemoteWebDriver driver) {
        this.driver = driver;
        this.name = driver.getSessionId().toString();
        testSteps = new TestSteps(driver);
    }

    public void run() {
        log("Test running");
        String queue = "Hello World!";
        testSteps
                .typeSearchInQueue(queue)
                .submitQueue()
                .waitForPageTitle(queue)
                .quitWebDriver();
    }

    public void start() {
        if (myLittleThread == null) {
            myLittleThread = new Thread(this, name);
            myLittleThread.start();
        }
    }

}
