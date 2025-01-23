package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class DashboardPage extends CommonMethods {

    @FindBy(id = "menu_pim_viewPimModule")
    public WebElement pimOption;

    @FindBy(id = "menu_pim_addEmployee")
    public WebElement addEmployeeOption;

    @FindBy(id = "menu_pim_viewEmployeeList")
    public WebElement employeeListOption;

    @FindBy(id = "welcome")
    public WebElement welcomeMessage;

    @FindBy(css = ".page-title")
    public WebElement dashboardTitle;

    public DashboardPage() {
        PageFactory.initElements(driver, this);
    }

    public void navigateToAddEmployee() {
        click(pimOption);
        click(addEmployeeOption);
    }

    public void navigateToEmployeeList() {
        click(pimOption);
        click(employeeListOption);
    }

    public String getWelcomeMessage() {
        return welcomeMessage.getText();
    }

    public boolean isDashboardDisplayed() {
        return dashboardTitle.isDisplayed();
    }
}