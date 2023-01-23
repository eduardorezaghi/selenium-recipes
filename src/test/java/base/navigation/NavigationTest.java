package base.navigation;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class NavigationTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = WebDriverManager.chromedriver().create();
    }

    @AfterEach
    void teardown() {
        driver.quit();
    }
    @Test
    public void navigationTest() {
        String baseUrl = "https://testpages.herokuapp.com/styled/";
        String firstPage = baseUrl + "basic-web-page-test.html";
        String secondPage = baseUrl + "windows-test.html";
        String thirdPage = baseUrl + "alerts/alert-test.html";

        driver.get(firstPage);

        driver.navigate().to(secondPage);
        driver.navigate().to(thirdPage);
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();

        assertThat(driver.getCurrentUrl()).isEqualTo(thirdPage);
    }
}
