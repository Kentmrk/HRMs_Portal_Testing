package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;
import utils.ConfigReader;

public class AddEmployeeSteps extends CommonMethods {

    @Given("user is logged in with admin credentials")
    public void user_is_logged_in_with_admin_credentials() {
        loginPage.loginToHRMS(ConfigReader.getProperty("userName"),
                ConfigReader.getProperty("password"));
    }

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        click(dashboardPage.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters first name {string} and last name {string}")
    public void user_enters_first_and_last_name(String firstName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(lastName, addEmployeePage.lastNameField);
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("system generates employee ID automatically")
    public void system_generates_employee_id_automatically() {
        String employeeId = addEmployeePage.employeeIdField.getAttribute("value");
        Assert.assertTrue("Employee ID was not generated",
                employeeId != null && !employeeId.isEmpty());
    }

    @Then("employee is successfully added")
    public void employee_is_successfully_added() {
        Assert.assertTrue("Employee was not added successfully",
                addEmployeePage.successMessage.isDisplayed());
    }

    @When("user enters first name {string} and middle name {string} and last name {string}")
    public void user_enters_full_name(String firstName, String middleName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);
    }

    @When("user enters employee ID {string}")
    public void user_enters_employee_id(String employeeId) {
        sendText(employeeId, addEmployeePage.employeeIdField);
    }

    @Then("employee is successfully added with ID {string}")
    public void employee_is_successfully_added_with_id(String expectedId) {
        String actualId = addEmployeePage.employeeIdField.getAttribute("value");
        Assert.assertEquals("Employee ID mismatch", expectedId, actualId);
    }

    @When("user enters employee data {string} and {string} and {string}")
    public void user_enters_employee_data(String firstName, String middleName, String lastName) {
        sendText(firstName, addEmployeePage.firstNameField);
        sendText(middleName, addEmployeePage.middleNameField);
        sendText(lastName, addEmployeePage.lastNameField);
    }

    @Then("system shows {string} message")
    public void system_shows_message(String expectedMessage) {
        String actualMessage = addEmployeePage.successMessage.getText();
        Assert.assertEquals("Status message mismatch",
                expectedMessage, actualMessage);
    }
}