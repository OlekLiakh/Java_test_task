package testCases;

import java.time.Duration;
import library.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public abstract class BaseTest {
    private WebDriver driver;

    @BeforeTest
    protected void setupTest() {
        driver = WebDriverInitializer.getDriver();
    }

    @AfterTest
    protected void tearDown() {
        WebDriverInitializer.quitWebDriver();
    }
}
