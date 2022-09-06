package library.elementActions;

import org.openqa.selenium.WebElement;

import static org.testng.Assert.*;

public interface ButtonActions extends BaseElementActions {

    default void clickButton(WebElement button) {
        boolean isButtonDisplayed = isElementDisplayed(button);
        if (isButtonDisplayed) {
            button.click();
        } else {
            fail("Button isn't displayed");
        }
    }
}
