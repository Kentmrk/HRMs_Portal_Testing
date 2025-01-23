package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class LoginPage extends CommonMethods {

    @FindBy(id = "txtUsername")
    public WebElement usernameField;

    @FindBy(id = "txtPassword")
    public WebElement passwordField;

    @FindBy(id = "btnLogin")
    public WebElement loginButton;

    @FindBy(id = "spanMessage")
    public WebElement errorMessage;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public void enterUsername(String username) {
        sendText(username, usernameField);
    }

    public void enterPassword(String password) {
        sendText(password, passwordField);
    }

    public void clickLoginButton() {
        click(loginButton);
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void loginToHRMS(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }
}