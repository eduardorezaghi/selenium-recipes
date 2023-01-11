package base.locators;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class XpathMouseClick {
    
    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() throws InterruptedException {
        // Pause for manual browser inspection
        Thread.sleep(Duration.ofSeconds(3).toMillis());

        driver.quit();
    }

    @Test
    void testNavigation() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");

        // XPath DOM queries examples
        driver.findElement(By.xpath("//a[text()='Navigation']")).click();
        driver.findElement(By.xpath("//a[text()='Next']")).click();
        driver.findElement(By.xpath("//a[text()='3']")).click();
        driver.findElement(By.xpath("//a[text()='2']")).click();
        driver.findElement(By.xpath("//a[text()='Previous']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText();
        assertThat(bodyText).contains("Lorem ipsum");
    }

}
