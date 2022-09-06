package library.elementActions;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

public interface BaseElementActions {

    default boolean isElementEnabled(WebElement element) {
        try {
            return element.isEnabled();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    default boolean isElementDisplayed(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    default String getElementText(WebElement element) {
        return element.getText();
    }

    default void verifyMessageIsPresent(WebElement element, boolean condition, String messageText) {
        assertEquals(isElementDisplayed(element), condition, "Message `" + messageText + "` is not present");
        if (condition) {
            String currentMessage = getElementText(element);
            assertEquals(currentMessage, messageText, "Message is not correct");
        }
    }

}
