package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AddEmployeePage extends CommonMethods {

    @FindBy(id = "firstName")
    public WebElement firstNameField;

    @FindBy(id = "lastName")
    public WebElement lastNameField;

    @FindBy(id = "employeeId")
    public WebElement employeeIdField;

    @FindBy(id = "btnSave")
    public WebElement saveButton;

    @FindBy(className = "message-success")
    public WebElement successMessage;

    @FindBy(xpath = "//span[contains(@class,'error-message')]")
    public WebElement errorMessage;

    public AddEmployeePage() {
        PageFactory.initElements(driver, this);
    }

    public String getFieldError(String fieldName) {
        switch (fieldName.toLowerCase()) {
            case "firstname" -> {
                return firstNameField.getAttribute("validationMessage");
            }
            case "lastname" -> {
                return lastNameField.getAttribute("validationMessage");
            }
            default -> {
                return "Field not found";
            }
        }
    }
}