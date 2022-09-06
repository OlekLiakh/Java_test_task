package library;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;

public class WebDriverInitializer {

    private static WebDriver driver;

    private WebDriverInitializer() {
    }

    public static void setDriver() {
        String browserName = System.getProperty("browser");
        setDriver(browserName);
    }

    public static void setDriver(String browserName) {
        if (browserName == null) {
            browserName = "chrome";
        }
        if (browserName.equalsIgnoreCase("chrome")) {
            driver = WebDriverManager.chromedriver().create();
        } else if (browserName.equalsIgnoreCase("firefox")) {
            driver = WebDriverManager.firefoxdriver().create();
        } else if (browserName.equalsIgnoreCase("edge")) {
            driver = WebDriverManager.edgedriver().create();
        } else if (browserName.equalsIgnoreCase("safari")) {
            driver = WebDriverManager.safaridriver().create();
        } else {
            throw new RuntimeException("A " + browserName +
                " browser is not supported by framework. Please choose one of four: Chrome, Firefox, Edge or Safari");
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            setDriver();
        }
        return driver;
    }

    public static void quitWebDriver() {
        driver.quit();
        driver = null;
    }
}
