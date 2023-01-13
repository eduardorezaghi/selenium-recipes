package base;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
    WebDriver driver;

    @BeforeEach
    void setup() {
        // Use of Chromium Driver instance
        driver = WebDriverManager.chromedriver().create();
    }

    @Test
    public void testImplicityWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        // Implicitely wait for elements loading, polling DOM during the specified time
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement landscape = driver.findElement(By.id("landscape"));
        assertThat(landscape.getAttribute("src"))
                .containsIgnoringCase("landscape");
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
        WebElement landscape = wait.until(ExpectedConditions
                .presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src"))
                .containsIgnoringCase("landscape");
    }

    @Test
    public void testFluentWait() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/loading-images.html");

        // Use FluentWait object instance (base class of WebDriverWait class)
        // to customize wait behavior, such as:
        //   - Timeout of wait 
        //   - Polling time specification
        //   - Error message when element is not found
        Wait<WebDriver> wait = new FluentWait<>(driver)
            .withTimeout(Duration.ofSeconds(10))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class);

        WebElement landscape = wait.until(ExpectedConditions
            .presenceOfElementLocated(By.id("landscape")));
        assertThat(landscape.getAttribute("src"))
            .containsIgnoringCase("landscape");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }

}
