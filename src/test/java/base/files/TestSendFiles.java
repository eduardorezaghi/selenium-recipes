package base.files;

import static org.assertj.core.api.Assertions.assertThat;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestSendFiles extends base.SeleniumBase {
    private static final String initialURL = "https://bonigarcia.dev/selenium-webdriver-java/web-form.html";

    @Test
    public void testUpload() throws IOException, InterruptedException {
        String initialURL = "https://testpages.herokuapp.com/styled/basic-html-form-test.html";
        driver.get(initialURL);

        WebElement inputFile = driver.findElement(
                By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[4]/td/input[1]"));

        Path tempFile = Files.createTempFile("tempFiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();

        inputFile.sendKeys(filename);

        driver.findElement(By.tagName("form")).submit();

        WebElement textBox = new WebDriverWait(driver, Duration.ofSeconds(3))
                .until(driver -> driver.findElement(By.className("explanation")));

        assertThat(textBox.getText()).contains("You submitted a form");
    }

    @Test
    public void testUpload2() throws IOException {
        driver.get(initialURL);

        WebElement inputFile = driver.findElement(By.name("myFile"));

        // Arrange
        // Use java.nio.file.Path to create a temporary file
        Path tempFile = Files.createTempFile("tempFiles", ".tmp");
        String fileName = tempFile.toAbsolutePath().toString();
        log.debug("File to upload: {}", fileName);

        // Act
        inputFile.sendKeys(fileName);
        driver.findElement(By.tagName("form")).submit();

        // Assert
        assertThat(driver.getPageSource()).contains("You submitted a form");
    }
}
