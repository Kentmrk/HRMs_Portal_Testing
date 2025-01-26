package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;

public class LoginSteps extends CommonMethods {

    @When("user enters admin username {string} and password {string}")
    public void user_enters_admin_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @When("user enters admin {string} and {string}")
    public void user_enters_credentials(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
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

    @Then("system shows {string} error message")
    public void system_shows_login_error_message(String expectedError) {
        String actualError = loginPage.getErrorMessage();
        Assert.assertEquals("Error message mismatch",
                expectedError, actualError);
    }
}