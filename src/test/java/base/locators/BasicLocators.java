package base.locators;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import static org.assertj.core.api.Assertions.assertThat;


public class BasicLocators extends base.SeleniumBase {

    @Test
    public void testLocators() {
        driver.get("https://testpages.herokuapp.com/styled/basic-html-form-test.html");

        WebElement usernameInput = driver
            .findElement(By.cssSelector("input[type='text'][name='username']"));
        
        usernameInput.sendKeys("seleniumUser");
        assertThat(usernameInput.getAttribute("value")).isEqualTo("seleniumUser");
    }
}
