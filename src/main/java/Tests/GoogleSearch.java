package Tests;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleSearch implements Runnable {
    private RemoteWebDriver driver;
    private String name;
    private Thread myLittleThread;

    public GoogleSearch(RemoteWebDriver driver) {
        this.driver = driver;
        this.name = driver.getSessionId().toString();
    }

    public void run() {
        log("Test running");
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        final String queue = "Hello World!";
        element.sendKeys(queue);
        simulateSlowExecution();
        element.submit();
        log("Queue submitted: " + queue);
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(queue.toLowerCase());
            }
        });
        log("Page title is: " + driver.getTitle());
        log("Test completed!");
        simulateSlowExecution();
        driver.quit();
        log("Driver closed!");
    }

    public void start() {
        if (myLittleThread == null) {
            myLittleThread = new Thread(this, name);
            myLittleThread.start();
        }
    }

    private void log(String s) {
        System.out.println("[" + Thread.currentThread().getName() + "] " + s);
    }

    private void simulateSlowExecution() {
        log("Doing hard work!");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }
    }
}
