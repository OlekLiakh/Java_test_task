package pages;

import library.elementActions.BaseElementActions;
import library.elementActions.ButtonActions;
import library.WebDriverInitializer;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

abstract class BasePage<T extends BasePage<T>> implements BaseElementActions, ButtonActions {

    private final WebDriver driver;

    public BasePage() {
        driver = WebDriverInitializer.getDriver();
        PageFactory.initElements(driver, this);
    }

    protected void openPage(String url) {
        driver.get(url);
    }
}
