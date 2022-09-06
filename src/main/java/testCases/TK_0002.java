package testCases;

import java.util.Properties;
import library.EnvPropertiesManager;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.LoginPage;

public class TK_0002 extends BaseTest{

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

  @Test(description = "Test to fail")
  public void TK_0002() {
    loginPage.openLoginPage()
        .verifyUsernameInputFieldIsDisplayed(true)
        .verifyUsernameInputFieldIsEnabled(true)
        .verifyPasswordInputFieldIsDisplayed(true)
        .verifyPasswordInputFieldIsEnabled(true)
        .verifyLoginButtonIsDisplayed(true)
        .verifyLoginButtonIsEnabled(true)
        .fillUsernameInputField(userName)
        .fillPasswordInputField(password)
        .clickLoginButton()
        .verifyInvalidUsernameMessageIsPresent(false);
  }

}
