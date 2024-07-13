package base;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

public class TestHelloWorld extends SeleniumBase {
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
}
