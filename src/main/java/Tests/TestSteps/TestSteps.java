package Tests.TestSteps;

import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Tests.UtilMethods.log;
import static Tests.UtilMethods.simulateHardWork;

public class TestSteps {
    private WebDriver driver;
    public TestSteps(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public TestSteps typeSearchInQueue(String queue) {
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys(queue);
        simulateHardWork();

        log("Queue input:" + queue);
        return this;
    }

    public TestSteps submitQueue() {
       driver.findElement(By.name("q")).submit();
        simulateHardWork();

        log("Queue submitted");
        return this;
    }

    public TestSteps waitForPageTitle(final String queue) {
        (new WebDriverWait(driver,10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(queue.toLowerCase());
            }
        });
        simulateHardWork();

        log("Page title is: " + driver.getTitle());
        return this;
    }

    public void quitWebDriver() {
        driver.quit();
        simulateHardWork();
        log("Driver quit!");
    }
}
