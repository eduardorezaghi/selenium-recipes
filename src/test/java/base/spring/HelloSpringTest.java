package base.spring;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.NoSuchElementException;

import io.github.bonigarcia.wdm.WebDriverManager;
import static org.assertj.core.api.Assertions.assertThat;

/*
* Spring Boot test application must be ran before tests:
*    $ ./mvnw spring-boot:run
*/
public class HelloSpringTest {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("headless");
        driver = new ChromeDriver(chromeOptions);
    }

    @AfterEach
    public void teardown() {
        driver.quit();
    }
    
    @Test
    public void testHelloWorld() {
        driver.get("http://localhost:8080/");
        
        Wait<WebDriver> wait = new FluentWait<>(driver)
        .withTimeout(Duration.ofSeconds(10))
        .pollingEvery(Duration.ofSeconds(1))
        .ignoring(NoSuchElementException.class);
        
        WebElement body = wait.until(ExpectedConditions
            .presenceOfElementLocated(By.tagName("body")));

        assertThat(body.getText()).isEqualTo("Greetings from Spring Boot!");
    }

    @Test
    public void testGreeting() {
        StringBuilder url = new StringBuilder();
        String name = "Selenium";
        url.append("http://localhost:8080/greeting?name=");
        url.append(name);

        driver.get(url.toString());
        
        WebElement body = driver.findElement(By.tagName("body"));

        assertThat(body.getText()).isEqualTo("Hello, %s!", name);
    }
}
