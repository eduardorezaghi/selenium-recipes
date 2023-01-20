package base.screenshoot;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;

import static java.lang.invoke.MethodHandles.lookup;
import static org.assertj.core.api.Assertions.assertThat;
import static org.slf4j.LoggerFactory.getLogger;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ScreenshotBase64 {
    static final Logger log = getLogger(lookup().lookupClass());
    WebDriver driver;

    @BeforeEach
    public void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    public void teardown() throws InterruptedException {
        driver.quit();
    }
    public static void main(String[] args) {
        
    }

    @Test
    public void testScreenshot(String arg1, String... args) {
        driver.get("https://bonigarcia.dev/selenium-webdriver-java/");
        TakesScreenshot ts = (TakesScreenshot) driver;

        String screenshot = ts.getScreenshotAs(OutputType.BASE64);
        log.debug("Screenshot in base64 "
                + "(you can copy and paste it into a browser navigation bar to watch it)\n"
                + "data:image/png;base64,{}", screenshot);
        assertThat(screenshot).isNotEmpty();

    }
}
