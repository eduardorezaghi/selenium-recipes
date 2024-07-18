package base.locators;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestComplexLocators extends base.SeleniumBase {
    @BeforeEach
    public void setupClass() {
        driver.get("https://testpages.eviltester.com/styled/attributes-test.html");
    }

    @Test
    public void testFindByClassname() {
        WebElement divTest = driver.findElement(By.className("explanation"));

        String className = divTest.getDomAttribute("class");

        assertThat(className).contains("explanation");
    }

    @Test
    public void testFindByCustomAttribute() {
        WebElement paragraph = driver.findElement(By.cssSelector("p[custom-attrib]"));

        String customAttribute = paragraph.getAttribute("custom-attrib");

        assertThat(customAttribute).isNotEmpty();
        assertThat(customAttribute).isEqualTo("attrib in source at load");
    }

    @Test
    public void testFindByXpath() {
        driver.get("https://testpages.eviltester.com/styled/find-by-playground-test.html");

        WebElement href = driver.findElement(By.xpath("//a[@id='a27']"));

        String id = href.getAttribute("id");

        assertThat(id).isEqualTo("a26");
    }

}
