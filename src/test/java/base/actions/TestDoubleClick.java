package base.actions;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;


public class TestDoubleClick extends base.SeleniumBase {



    @Test
    public void testDoubleClick() {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/dropdown-menu.html");
        Actions actions = new Actions(driver);

        // XPath selector example
        WebElement selector = driver.findElement(By.xpath("//*[@id=\"my-dropdown-3\"]"));

        // Using .build(), we can do multiple actions at once.
        actions.doubleClick(selector).build().perform();

        // XPath selector example
        WebElement selectorMenu = driver.findElement(By.xpath("//*[@id=\"context-menu-3\"]"));

        // Get boolean status related to element visibility.
        // Then, assert it wit isTrue() method.
        assertThat(selectorMenu.isDisplayed()).isTrue();
    }
}
