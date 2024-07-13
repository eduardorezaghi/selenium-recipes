package base;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestWaits extends SeleniumBase {

    @Test
    public void testImplicityWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        // Implicitely wait for elements loading, polling DOM during the specified time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement landscape = driver.findElement(By.id("landscape"));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }

    @Test
    public void testExplicityWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        // For waiting explicitely, we must import WebDriverWait class and instantiate
        // a wait object
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Use of ExpectedConditions static method to validate the existante of
        // "landscape" element.
        // Equivalent to Cypress options object with { timeout } property
        WebElement landscape =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }

    @Test
    public void testFluentWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-j ava/loading-images.html");

        // Use FluentWait object instance (base class of WebDriverWait class)
        // to customize wait behavior, such as:
        // - Timeout of wait
        // - Polling time specification
        // - Error message when element is not found
        Wait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(10)) // Waits
                                                                                            // for
                                                                                            // 10
                                                                                            // seconds
                .pollingEvery(Duration.ofSeconds(1)) // Re-query the DOM every 1 second
                .ignoring(NoSuchElementException.class); // Ignore this
                                                         // exception

        WebElement landscape =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src")).containsIgnoringCase("landscape");
    }
}
