package base.screenshoot;


import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestScreenshotBase64 extends base.SeleniumBase {
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
