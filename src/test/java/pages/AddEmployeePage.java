package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "middleName")
    public WebElement middleNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "employeeId")
    public WebElement employeeIdField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(css = ".message.success")
    public WebElement successMessage;

    @FindBy(css = ".validation-error")
    public WebElement errorMessage;

    @FindBy(id = "photofile")
    public WebElement photographUpload;

    @FindBy(id = "chkLogin")
    public WebElement createLoginDetailsCheckbox;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public void enterEmployeeNames(String firstName, String middleName, String lastName) {
        sendText(firstName, firstNameField);
        sendText(middleName, middleNameField);
        sendText(lastName, lastNameField);
    }

    public void enterEmployeeId(String employeeId) {
        sendText(employeeId, employeeIdField);
    }

    public String getEmployeeId() {
        return employeeIdField.getAttribute("value");
    }

    public void clickSaveButton() {
        click(saveButton);
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public String getErrorMessage() {
        return errorMessage.getText();
    }

    public void uploadEmployeePhotograph(String filePath) {
        photographUpload.sendKeys(filePath);
    }

    public void enableLoginDetailsCreation() {
        if (!createLoginDetailsCheckbox.isSelected()) {
            click(createLoginDetailsCheckbox);
        }
    }
}