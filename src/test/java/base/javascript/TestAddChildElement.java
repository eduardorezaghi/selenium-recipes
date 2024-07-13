package base.javascript;


import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.assertj.core.api.Assertions.assertThat;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;


public class TestAddChildElement extends base.SeleniumBase {
    @Test
    public void testAddChildElement() throws IOException {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/long-page.html");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        TakesScreenshot ts = (TakesScreenshot) driver;


        WebElement title = driver.findElement(By.className("display-6"));
        WebElement div = (WebElement) js.executeScript("return arguments[0].parentNode;", title);

        js.executeScript("arguments[0].innerHTML += \"<h2>New title element</h2>\"", div);
        assertThat(div.getAttribute("innerHTML")).contains("New title element");

        File screenshot = ts.getScreenshotAs(OutputType.FILE);
        Files.move(screenshot.toPath(), Paths.get("src/test/java/resources/output/screenshot_js.png"), REPLACE_EXISTING);

    }
}
