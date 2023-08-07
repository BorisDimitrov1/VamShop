package step_definitions.admin;

import io.cucumber.java.en.And;
import page_objects.admin.AdminLoginPage;

public class AdminLoginStepDefinitions {

    private AdminLoginPage loginPage = new AdminLoginPage();

    @And("Populate the username field with correct username")
    public void populateTheUsernameFieldWithCorrectUsername() {
        loginPage.populateUsername(System.getProperty("adminUsername"));
    }

    @And("Populate the password field with correct password")
    public void populateThePasswordFieldWithCorrectUsername() {
        loginPage.populatePassword(System.getProperty("adminPassword"));
    }

    @And("Click login button")
    public void clickLoginButton(){
        loginPage.clickLoginButton();
    }
}
