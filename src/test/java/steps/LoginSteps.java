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

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        loginPage.enterUsername("admin234");
        loginPage.enterPassword("Hum@n");
    }

    @Then("user is able to see error message")
    public void user_is_able_to_see_error_message() {
        String errorValue = loginPage.getErrorMessage();
        Assert.assertEquals("Invalid credentials", errorValue);
    }
}