package base.javascript;


import java.time.Duration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddChildElement {
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.firefoxdriver().create();
    }

    @AfterEach
    public void teardown() throws InterruptedException {
        driver.quit();
    }

    @Test
    public void testAddChildElement() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement title = driver.findElement(By.className("display-6"));
        WebElement div = (WebElement) js.executeScript("return arguments[0].parentNode;", title);

        js.executeScript("arguments[0].innerHTML += \"<h2>New title element</h2>\"",
        div);
        assertThat(div.getAttribute("innerHTML")).contains("New title element");
    }
}
