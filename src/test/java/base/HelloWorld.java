package base;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.*;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HelloWorld {

    // Empty WebDriver instance before initiating tests
    static WebDriver driver;
    @BeforeAll
    static void setup() {
        // Use Boní Garcia WebDriverManager to initiate Selenium Webdriver
        driver = WebDriverManager.chromedriver().create();
    }
    
    @Test
    void fillHelloWorldForm() {
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");
        
        WebElement textArea = driver.findElement(By.name("comments"));
        assertThat(textArea.getText()).isEqualTo("Comments...");

        textArea.clear();
        textArea.sendKeys("Hello, World!");

        // Send TAB key on body to ensure element is unfocused
        driver.findElement(By.tagName("body")).sendKeys(Keys.TAB);
        assertThat(textArea.getAttribute("value")).isEqualTo("Hello, World!");
    }

    @AfterAll
    static void teardown() {
        // Use Boní Garcia WebDriverManager to initiate Selenium Webdriver
        driver.quit();
    }
}
