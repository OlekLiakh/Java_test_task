package pages;

public final class Locators {

    private Locators() {
    }

    public static final String BASE_URL = "https://www.pecodesoftware.com/";
    public static final String QA_PORTAL = "qa-portal/";

    public interface LoginPage {
        String LOGIN_PAGE_TITLE = "AQA internship Login";

        String LOGIN_PAGE_URL = BASE_URL + QA_PORTAL + "registerlogin/registerlogin.php";
        String USERNAME_INPUT_FIELD_NAME_XPATH = "//input[@name='username']";
        String PASSWORD_INPUT_FIELD_NAME_XPATH = "//input[@name='password']";
        String LOGIN_BUTTON_XPATH = "//input[@value='Login']";
        String USERNAME_INPUT_FIELD_NAME_ERROR_MSG_XPATH = "//input[@name='username']//following-sibling::span[text()!='']";
        String PASSWORD_INPUT_FIELD_NAME_ERROR_MSG_XPATH = "//input[@name='password']//following-sibling::span[text()!='']";

        String EMPTY_USERNAME_INPUT_MSG = "Please enter username.";
        String EMPTY_PASSWORD_INPUT_MSG = "Please enter your password.";
        String INVALID_USERNAME_MSG = "No account found with that username.";
        String INVALID_PASSWORD_MSG = "Invalid password.";

    }
}
