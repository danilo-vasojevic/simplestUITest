import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;

public class RunnerClass  {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        RemoteWebDriver driver = WebDriverProvider.initRemoteDriver(
                "http://localhost:4444/wd/hub",
                Browsers.CHROME,
                "68.0"
        );

        // Test
        driver.get("http://www.google.com");
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("Hello World!");
        element.submit();
        System.out.println("Page title is: " + driver.getTitle());
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });
        System.out.println("Page title is: " + driver.getTitle());
        Thread.sleep(10000);
        driver.quit();
    }
}