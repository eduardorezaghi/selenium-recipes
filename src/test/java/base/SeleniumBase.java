package base;

import static java.lang.invoke.MethodHandles.lookup;
import static org.slf4j.LoggerFactory.getLogger;
import java.io.File;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.chromium.ChromiumDriverLogLevel;
import org.slf4j.Logger;

public class SeleniumBase {
    // Package visibility to be accessed in subclasses

    // Create a SLF4J logger to log the chromedriver.log file
    protected static final Logger log = getLogger(lookup().lookupClass());

    // Allows the browser to be accessed in subclasses
    protected static WebDriver driver;

    @BeforeEach
    protected void setup() {
        // Web driver options are set here.
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized", "--force-dark-mode");


        // Create a instance of a Service class to customize
        // the chromedriver.log file and log level
        ChromeDriverService service =
                new ChromeDriverService.Builder().withLogFile(new File("chromedriver.log"))
                        .withLogLevel(ChromiumDriverLogLevel.INFO).build();

        // Launch the browser with the service and options
        driver = new ChromeDriver(service, options);
    }

    @AfterEach
    protected void teardownEach() {
        driver.quit();
    }
}
