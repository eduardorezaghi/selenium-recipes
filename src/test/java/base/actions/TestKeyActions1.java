package base.actions;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class TestKeyActions1 extends base.SeleniumBase {
    @Test
    public void testKey() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/web-form.html");

        // Find element by its name
        WebElement rangeSlider = driver.findElement(By.name("my-range"));

        // Grab its value property
        String initialValue = rangeSlider.getAttribute("value");

        // Log to Selenium output console
        log.debug("The initial value of rangeSlider is {}", initialValue);

        for (int i = 0; i < 6; i++)
            // Click ARROW_RIGHT keyboard key three times
            rangeSlider.sendKeys(Keys.ARROW_LEFT);

        String endValue = rangeSlider.getAttribute("value");
        log.debug("The final value of the slider is {}", endValue);

        // Value assertion
        assertThat(initialValue).isNotEqualTo(endValue);
    }
}
