package base.files;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Duration;

public class SendFiles {

    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @Test
    public void testUpload() throws IOException, InterruptedException {
        String initialURL = "https://testpages.herokuapp.com/styled/basic-html-form-test.html";
        driver.get(initialURL);

        WebElement inputFile = driver.findElement(By.xpath("//*[@id=\"HTMLFormElements\"]/table/tbody/tr[4]/td/input[1]"));

        Path tempFile = Files.createTempFile("tempFiles", ".tmp");
        String filename = tempFile.toAbsolutePath().toString();
        
        inputFile.sendKeys(filename);

        driver.findElement(By.tagName("form")).submit();

        WebElement textBox = new WebDriverWait(driver, Duration.ofSeconds(3))
                            .until(driver -> driver.findElement(By.className("explanation")));
                
        assertThat(textBox.getText()).contains("You submitted a form");
    }
}
