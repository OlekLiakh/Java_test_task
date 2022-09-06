package library.elementActions;

import org.openqa.selenium.WebElement;

public interface InputFieldActions extends BaseElementActions{

    private void fillInputField(WebElement inputField, String value, boolean isDeleteValue) {
        inputField.click();
        if (isDeleteValue) {
            inputField.clear();
        }
        inputField.sendKeys(value);
    }

    default void fillInputField(WebElement input, String value) {
        fillInputField(input, value, true);
    }

    default void fillInputFieldWithoutClear(WebElement input, String value) {
        fillInputField(input, value, false);
    }
}
