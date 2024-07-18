package base.waiting;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class TestWait extends base.SeleniumBase {


    @Test
    public void testElementIsVisible() {
        driver.get("https://www.selenium.dev/selenium/web/dynamic.html");

        WebElement button = driver.findElement(By.id("adder"));
        button.click();

        // First, we create a Wait object with a timeout of 5 seconds
        Wait<RemoteWebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(5))
                .pollingEvery(Duration.ofMillis(500)).ignoring(NoSuchElementException.class);

        wait.until(d -> d.findElement(By.cssSelector("div[id^='box']")).isDisplayed());
    }

}
