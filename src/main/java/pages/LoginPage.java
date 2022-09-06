package pages;

import library.elementActions.ButtonActions;
import library.elementActions.InputFieldActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.*;
import static pages.Locators.LoginPage.*;

public class LoginPage extends BasePage<LoginPage> implements InputFieldActions, ButtonActions {

    @FindBy(xpath = USERNAME_INPUT_FIELD_NAME_XPATH)
    private WebElement usernameField;
    @FindBy(xpath = PASSWORD_INPUT_FIELD_NAME_XPATH)
    private WebElement passwordField;
    @FindBy(xpath = LOGIN_BUTTON_XPATH)
    private WebElement loginButton;
    @FindBy(xpath = USERNAME_INPUT_FIELD_NAME_ERROR_MSG_XPATH)
    private WebElement usernameFieldErrorMessage;
    @FindBy(xpath = PASSWORD_INPUT_FIELD_NAME_ERROR_MSG_XPATH)
    private WebElement passwordFieldErrorMessage;

    public LoginPage() {
        super();
    }

    public LoginPage openLoginPage() {
        super.openPage(LOGIN_PAGE_URL);
        return this;
    }

    public LoginPage fillUsernameInputField(String value) {
        fillInputField(usernameField, value);
        return this;
    }

    public LoginPage fillPasswordInputField(String value) {
        fillInputField(passwordField, value);
        return this;
    }

    public LoginPage clickLoginButton() {
        clickButton(loginButton);
        return this;
    }

    public LoginPage verifyUsernameInputFieldIsDisplayed(boolean condition) {
        assertEquals(isElementDisplayed(usernameField), condition, "Verify is Username input field displayed");
        return this;
    }

    public LoginPage verifyUsernameInputFieldIsEnabled(boolean condition) {
        assertEquals(isElementEnabled(usernameField), condition, "Verify is Username input field enabled");
        return this;
    }

    public LoginPage verifyPasswordInputFieldIsDisplayed(boolean condition) {
        assertEquals(isElementDisplayed(passwordField), condition, "Verify is Password input field displayed");
        return this;
    }

    public LoginPage verifyPasswordInputFieldIsEnabled(boolean condition) {
        assertEquals(isElementEnabled(passwordField), condition, "Verify is Password input field enabled");
        return this;
    }

    public LoginPage verifyLoginButtonIsDisplayed(boolean condition) {
        assertEquals(isElementDisplayed(loginButton), condition, "Verify is Login button displayed");
        return this;
    }

    public LoginPage verifyLoginButtonIsEnabled(boolean condition) {
        assertEquals(isElementEnabled(loginButton), condition, "Verify is Login button enabled");
        return this;
    }

    public LoginPage verifyEmptyUsernameFieldMessageIsPresent(boolean condition) {
        verifyMessageIsPresent(usernameFieldErrorMessage, condition, EMPTY_USERNAME_INPUT_MSG);
        return this;
    }

    public LoginPage verifyInvalidUsernameMessageIsPresent(boolean condition) {
        verifyMessageIsPresent(usernameFieldErrorMessage, condition, INVALID_USERNAME_MSG);
        return this;
    }

    public LoginPage verifyEmptyPasswordFieldMessageIsPresent(boolean condition) {
        verifyMessageIsPresent(passwordFieldErrorMessage, condition, EMPTY_PASSWORD_INPUT_MSG);
        return this;
    }

    public LoginPage verifyInvalidPasswordMessageIsPresent(boolean condition) {
        verifyMessageIsPresent(passwordFieldErrorMessage, condition, INVALID_PASSWORD_MSG);
        return this;
    }

}
