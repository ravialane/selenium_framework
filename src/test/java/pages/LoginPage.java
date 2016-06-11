package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

  WebDriver driver;
  public LoginPage(WebDriver driver){
    this.driver = driver;
  }

  @FindBy(xpath="//*[@id='login-email']")
  public WebElement emailField;

  @FindBy(id="login-password")
  public WebElement passwordField;

  @FindBy(css="form.login-form > input[name='submit']")
  public WebElement signinButton;


  public HomePage login(String username, String password){
    emailField.sendKeys(username);
    passwordField.sendKeys(password);
    signinButton.click();

    return PageFactory.initElements(driver, HomePage.class);
  }
}
