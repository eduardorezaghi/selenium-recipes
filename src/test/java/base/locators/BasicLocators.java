package base.locators;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;

public class BasicLocators {

    // Empty WebDriver instance before initiating tests
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.firefoxdriver().create();
    }

    @Test
    public void testLocators() {
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        WebElement usernameInput = driver
            .findElement(By.cssSelector("input[type='text'][name='username']"));
        
        usernameInput.sendKeys("seleniumUser");
        assertThat(usernameInput.getAttribute("value")).isEqualTo("seleniumUser");
    }
}
