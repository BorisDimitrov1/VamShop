package step_definitions.common;

import browser.Browser;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BrowserStepDefinitions {

    @When("I navigate to the e-shop")
    public void navigateToShop(){
        Browser.getDriver().navigate().to(System.getProperty("environmentUrl"));
    }

    @When("I navigate to the e-shop admin login")
    public void iNavigateToTheEShopAdminLogin() {
        Browser.getDriver().navigate().to(System.getProperty("environmentUrl") + "/users/admin_login/");
    }

    @And("Verify user is redirected to {string}")
    public void verifyUserIsRedirectedTo(String adminPanelUrl) {
        Browser.wait.until(ExpectedConditions.urlToBe(System.getProperty("environmentUrl") + adminPanelUrl));
    }
}
