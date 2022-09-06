package testCases;

import java.util.Properties;
import library.EnvPropertiesManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TK_0001 extends BaseTest{

  private LoginPage loginPage;
  private String userName;
  private String password;

  @BeforeTest
  public void initialize(){
    Properties prop = EnvPropertiesManager.getPropertiesFromFile();
    loginPage = new LoginPage();
    userName = prop.getProperty("USERNAME");
    password = prop.getProperty("PASSWORD");
  }

  @Test(description = "Test to verify error messages")
  public void TK_0001() {
    loginPage.openLoginPage()
        .verifyUsernameInputFieldIsDisplayed(true)
        .verifyUsernameInputFieldIsEnabled(true)
        .verifyPasswordInputFieldIsDisplayed(true)
        .verifyPasswordInputFieldIsEnabled(true)
        .verifyLoginButtonIsDisplayed(true)
        .verifyLoginButtonIsEnabled(true)
        .clickLoginButton()
        .verifyEmptyUsernameFieldMessageIsPresent(true)
        .verifyEmptyPasswordFieldMessageIsPresent(true)
        .fillUsernameInputField(userName)
        .clickLoginButton()
        .verifyEmptyUsernameFieldMessageIsPresent(false)
        .verifyEmptyPasswordFieldMessageIsPresent(true)
        .fillPasswordInputField(password)
        .clickLoginButton()
        .verifyInvalidUsernameMessageIsPresent(true)
        .verifyEmptyPasswordFieldMessageIsPresent(false);
  }

}
