package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class LoginSteps extends CommonMethods {

    @When("user enters admin username and password")
    public void user_enters_admin_username_and_password() {
        loginPage.enterUsername(ConfigReader.getProperty("userName"));
        loginPage.enterPassword(ConfigReader.getProperty("password"));
    }

    @When("user clicks on login button")
    public void user_clicks_on_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("user is able to see dashboard page")
    public void user_is_able_to_see_dashboard_page() {
        Assert.assertTrue("Dashboard is not displayed",
                dashboardPage.welcomeMessage.isDisplayed());
    }

    @When("user leaves username empty")
    public void user_leaves_username_empty() {
        loginPage.enterUsername("");
    }

    @When("enters valid password {string}")
    public void enters_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("user enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.enterUsername(username);
    }

    @When("leaves password empty")
    public void leaves_password_empty() {
        loginPage.enterPassword("");
    }

    @When("user enters invalid username {string} and password {string}")
    public void user_enters_invalid_username_and_password(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("user gets {string} error message")
    public void user_gets_error_message(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals("Error message does not match",
                expectedError, actualError);
    }
}