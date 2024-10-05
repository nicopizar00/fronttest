package fronttest.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

/**
 * Contains the base configuration to run the test;
 * The website url.
 * Other important configurations to inherit to other classes.
 *
 * @author Nicolas Pizarro
 */
public class BaseConfig {

    protected WebDriver driver;
    String baseUrl = "https://www.demoblaze.com/";

    @BeforeTest
    public void beforeTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @AfterTest
    public void afterTest() {
        driver.close();
    }
}
