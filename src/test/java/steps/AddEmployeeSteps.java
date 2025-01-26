package steps;

import io.cucumber.java.en.*;
import org.junit.Assert;
import utils.CommonMethods;

public class AddEmployeeSteps extends CommonMethods {

    @And("navigate to PIM Add Emploee")
    public void navigate_to_pim_add_employee() {
        click(dashboardPage.pimOption);
        click(dashboardPage.addEmployeeOption);
    }

    @When("user enters employee first name {string}")
    public void user_enters_first_name(String firstName) {
        sendText(firstName, addEmployeePage.firstNameField);
    }

    @When("user enters employee last name {string}")
    public void user_enters_last_name(String lastName) {
        sendText(lastName, addEmployeePage.lastNameField);
    }

    @When("clicks save button")
    public void clicks_save_button() {
        click(addEmployeePage.saveButton);
    }

    @Then("system generates unique ID")
    public void system_generates_unique_id() {
        String employeeId = addEmployeePage.employeeIdField.getAttribute("value");
        Assert.assertTrue("Employee ID was not generated", !employeeId.isEmpty());
    }

    @Then("employee is successfully added")
    public void employee_is_successfully_added() {
        Assert.assertTrue("Success message not displayed",
                addEmployeePage.successMessage.isDisplayed());
    }

    @When("enters employee ID {string}")
    public void enters_employee_id(String id) {
        sendText(id, addEmployeePage.employeeIdField);
    }

    @Then("employee is added with ID {string}")
    public void employee_is_added_with_id(String expectedId) {
        String actualId = addEmployeePage.employeeIdField.getAttribute("value");
        Assert.assertEquals("Employee ID mismatch", expectedId, actualId);
    }

    @When("user enters {string} {string}")
    public void user_enters_names(String firstName, String lastName) {
        if(firstName != null) sendText(firstName, addEmployeePage.firstNameField);
        if(lastName != null) sendText(lastName, addEmployeePage.lastNameField);
    }

    @Then("system shows {string} for {string}")
    public void system_shows_error_for_field(String error, String field) {
        String actualError = addEmployeePage.getFieldError(field);
        Assert.assertEquals("Error message mismatch", error, actualError);
    }
}